FROM maven:3.6.3-jdk-11-slim as BUILD
WORKDIR /usr/src/app
COPY checkstyle-asd.xml .
COPY checkstyle-supressions.xml .
COPY licenseheader.txt .
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn -B -e -C -T 1C package package -Dmaven.test.skip=true -Dcheckstyle.skip=true
# Start with a base image containing Java runtime
FROM openjdk:11.0.7-jdk
# Add Maintainer Info
LABEL maintainer="forduz@grupoasd.com.co"
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8080
COPY --from=BUILD /usr/src/app/target/*jar /opt/target/app.jar
WORKDIR /opt/target

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar $JAR_OPTS