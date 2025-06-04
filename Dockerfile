FROM openjdk:17-jdk-slim as build

WORKDIR /app
COPY . .

# Dar permisos de ejecución al gradlew
RUN chmod +x ./gradlew

# Compilar la app
#RUN ./gradlew build --no-daemon
RUN ./gradlew build -x test --no-daemon

# Segunda etapa para imagen final
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar el JAR desde el build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
