FROM eclipse-temurin:17-jdk-alpine as build
#FROM maven:3.9.6-openjdk-17 AS build
WORKDIR /app
#COPY . /app/
RUN mvn clean package
# Copy the Maven wrapper and project files
#COPY mvnw pom.xml ./
#COPY .mvn .mvn
#COPY src src

# Give execute permissions to the Maven wrapper
#RUN chmod +x ./mvnw

# Build the application
#RUN ./mvnw clean package -DskipTests

# Use a smaller base image to run the application
FROM eclipse-temurin:17-jdk-alpine
#FROM openjdk:17-alpine
WORKDIR /app

# Copy the built JAR file from the build stage to the final image
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
