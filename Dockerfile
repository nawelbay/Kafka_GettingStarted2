# Use an OpenJDK image to build the app
FROM openjdk:8-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built jar file
COPY target/MyFirstKafkaProject-1.0-SNAPSHOT.jar /app/kafka-example.jar

# Specify the command to run the producer or consumer
ENTRYPOINT ["java", "-cp", "/app/kafka-example.jar"]
