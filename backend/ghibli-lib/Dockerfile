FROM maven:3.9.8-eclipse-temurin-21

WORKDIR /ghibli-lib
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run