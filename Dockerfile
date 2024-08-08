FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar CRUD-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CRUD-0.0.1-SNAPSHOT.jar"]
