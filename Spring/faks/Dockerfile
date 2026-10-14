FROM eclipse-temurin:21-jdk-alpine
LABEL authors="Ivan"
COPY target/faks-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/demo.jar"]