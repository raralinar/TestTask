FROM openjdk:17

MAINTAINER test
COPY target/TestTask-1.0-SNAPSHOT.jar app.jar
COPY json-simple-1.1.1.jar /json.jar
COPY tickets.json /tickets.json
ENTRYPOINT ["java", "-cp", "/app.jar:/json.jar", "test.Main", "/tickets.json"]


