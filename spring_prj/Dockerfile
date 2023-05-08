# FROM openjdk:8
# VOLUME /tmp
# COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]


FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /tmp
COPY ./spring_prj/src ./src
COPY ./spring_prj/pom.xml .
RUN mvn package

FROM openjdk:11.0-jdk
COPY --from=builder /tmp/target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/demo-0.0.1-SNAPSHOT.jar"]