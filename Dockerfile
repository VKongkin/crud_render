FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app

# Copy the Maven/Gradle wrapper and project files
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

# Give execute permissions to the Maven wrapper
RUN chmod +x ./mvnw

# Build the application (using Maven here; adjust if you're using Gradle)
RUN ./mvnw clean package -DskipTests

# Use a smaller base image to run the application
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/CRUD-0.0.1-SNAPSHOT.jar CRUD.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/CRUD.jar"]

