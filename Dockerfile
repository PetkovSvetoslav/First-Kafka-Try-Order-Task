FROM openjdk:17-jdk-slim
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY target/Order-Processing-System-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
