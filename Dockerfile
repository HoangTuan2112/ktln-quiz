# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target folder into the container
COPY target/quiz_java-0.0.1-SNAPSHOT.jar /app/kltn2024.jar

# Expose the port (use $PORT environment variable for Heroku)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/kltn2024.jar"]
CMD ["--server.port=${PORT:8080}"]
