# Stage 1: Build the frontend
FROM node:14-alpine AS frontend-build

WORKDIR /app/src/main/front-end-react

# Copy the package.json and install dependencies
COPY ./src/main/front-end-react/package.json ./
RUN npm install

# Copy the rest of the React app source code and build it
COPY src/main/react-spring ./
RUN npm run build

# Stage 2: Build the Spring Boot application
FROM eclipse-temurin:17-jdk-alpine AS backend-build

WORKDIR /app

# Copy the Maven wrapper and project files
COPY mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

# Copy the built React frontend to the Spring Boot resources folder
COPY --from=frontend-build /app/src/main/fornt-end-react/dist/ /app/src/main/resources/static/

# Give execute permissions to the Maven wrapper
RUN chmod +x ./mvnw

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Stage 3: Run the application using a smaller base image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy the built JAR file from the build stage to the final image
COPY --from=backend-build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
