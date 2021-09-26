FROM openjdk:8-jdk-alpine
WORKDIR ./target/
COPY ./target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]