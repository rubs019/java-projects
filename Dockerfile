FROM maven:3.6.1-jdk-11-slim

ENV URL=null
ENV USERNAME=null
ENV PASSWORD=null
ENV DRIVER_CLASS_NAME=com.mysql.jdbc.Driver
ENV DDL_AUTO=none
ENV API_KEY=null

RUN mkdir /spring

WORKDIR /spring

COPY target/*.jar api.jar

EXPOSE 80

CMD [ "sh", "-c", "java -jar api.jar --server.port=80 --spring.datasource.url=${URL} --spring.datasource.username=${USERNAME} --spring.datasource.password=${PASSWORD} --spring.datasource.driver-class-name=${DRIVER_CLASS_NAME} --spring.jpa.hibernate.ddl-auto=${DDL_AUTO} --api_key=${API_KEY}" ]
