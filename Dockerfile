FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app

# Copy the Maven wrapper and project files
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

# Give execute permissions to the Maven wrapper
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Use a smaller base image to run the application
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR file from the build stage to the final image
COPY --from=build /app/target/CRUD-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
