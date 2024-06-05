FROM openjdk:17-oracle

WORKDIR /app

COPY target/students-0.0.1-SNAPSHOT.jar students.jar

ENV REPO_STARTER=false

CMD ["java", "-jar", "students.jar"]