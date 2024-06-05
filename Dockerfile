FROM openjdk:17-oracle

WORKDIR /app

COPY target/students-0.0.1-SNAPSHOT.jar students.jar

CMD ["java", "-jar", "students.jar"]