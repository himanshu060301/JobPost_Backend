FROM maven:3.8.3-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM maven:3.8.3-jdk-11-slim
COPY --from=build /target/joblisting-0.0.1-SNAPSHOT.jar joblisting.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","joblisting.jar" ]