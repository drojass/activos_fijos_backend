FROM maven:3.8.3-openjdk-17 as BUILD
WORKDIR /usr/src/app
COPY asd_checks.xml .
COPY asd_checkstyle_suppressions.xml .
COPY licenseheader.txt .
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn -B -e -C -T 1C package package -Dmaven.test.skip=true -Dcheckstyle.skip=true
FROM openjdk:17-jdk-slim-buster
LABEL org.opencontainers.image.source https://github.com/drojass/activos_fijos_backend
VOLUME /tmp
EXPOSE 8080
COPY --from=BUILD /usr/src/app/target/*jar /opt/target/app.jar
WORKDIR /opt/target

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar $JAR_OPTS