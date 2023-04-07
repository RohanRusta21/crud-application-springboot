FROM ubuntu
RUN apt update -y
RUN apt install openjdk-17-jre -y
RUN apt install maven -y
COPY pom.xml .
COPY ./src ./src
RUN mvn package
EXPOSE 80
COPY target/*.jar ./crud-application-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "./crud-application-0.0.1-SNAPSHOT.jar"]

#0.0.1-SNAPSHOT