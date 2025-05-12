FROM openjdk:17-jdk-slim as build

WORKDIR /app
COPY . .

# Compilar la app
RUN ./gradlew build --no-daemon

# Segunda etapa: para la imagen final más liviana
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar el JAR compilado desde el build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
