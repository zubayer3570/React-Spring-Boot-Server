FROM maven:21-jdk AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
COPY --from=build target/blog-0.0.1-SNAPSHOT.jar blog.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "blog.jar"]