FROM java:17

ENV SERVER_PORT 8999

ADD  target/springboot3.jar springboot3.jar

ENTRYPOINT ["java", "-jar","/springboot3.jar"]
