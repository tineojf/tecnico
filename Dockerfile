FROM eclipse-temurin:21.0.5_11-jdk

EXPOSE 8080

WORKDIR /app

COPY ./pom.xml /app
COPY ./.mvn /app/.mvn
COPY ./mvnw /app

RUN ./mvnw dependency:go-offline

COPY ./src /app/src

RUN ./mvnw clean install -DskipTests

RUN apt-get update && apt-get install -y netcat-openbsd

ENTRYPOINT ["sh", "-c", "while ! nc -z reto-db 3306; do sleep 1; done; java -jar /app/target/reto-0.0.1-SNAPSHOT.jar"]