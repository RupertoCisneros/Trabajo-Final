# Maven 
FROM maven:3.8.1-openjdk-11-slim AS builder

WORKDIR /app

COPY BackEnd/pom.xml .

RUN mvn -e -B dependency:resolve

COPY BackEnd/src ./src

RUN mvn clean -e -B package


# RTSDK Java
FROM openjdk:11

WORKDIR /app

ENV TZ=America/Guayaquil
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=builder /app/target/remetfu-Ver1.0.jar .

EXPOSE 8282

CMD ["java", "-jar", "./remetfu-Ver1.0.jar"]
