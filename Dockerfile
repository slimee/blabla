FROM java:8-jdk-alpine

COPY ./target/blablamower-0.0.1.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch blablamower-0.0.1.jar'

ENTRYPOINT ["java","-jar","blablamower-0.0.1.jar"]