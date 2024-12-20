FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} eventsProject-1.0.0.jar
ENTRYPOINT ["java", "-jar" ,"/eventsProject-1.0.0.jar"]
EXPOSE 8089