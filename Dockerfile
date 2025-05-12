FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build/libs/backend-nike-website-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dserver.port=$PORT", "-jar", "/app/app.jar"]
