FROM alpine/java:11-jdk

WORKDIR /app

COPY target/ItemStore-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]