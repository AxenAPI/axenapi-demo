FROM openjdk:17.0.2-jdk

WORKDIR /app

COPY build/libs/demo-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

ENTRYPOINT exec java -jar ./app.jar
