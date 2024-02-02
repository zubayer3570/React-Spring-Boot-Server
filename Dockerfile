FROM openjdk:21
VOLUME /tmp
COPY target/blog-0.0.1-SNAPSHOT.jar blog.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "blog.jar"]