FROM maven:3.5.3-jdk-8 as build
ENV PROJECT pre-build
RUN mkdir -p /workspace
WORKDIR /workspace
RUN mvn archetype:generate -DgroupId=com.my.app -DartifactId=${PROJECT} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
WORKDIR /workspace/${PROJECT}
ADD pom.xml ./
ADD Main.java ./src/main/java/com/my/app/
RUN mvn clean package
RUN find ./target -type f -name "${PROJECT}-*-with-dependencies.jar" | xargs -I {} mv {} /app.jar

FROM openjdk:8u171-jdk-slim-stretch
COPY --from=build /app.jar /
ENTRYPOINT ["java","-cp","/app.jar","com.my.app.Main"]
CMD ["-l","512","--pattern","2"]
