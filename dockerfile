FROM openjdk
MAINTAINER  sans11
WORKDIR /app
COPY target/phonebook.jar /app/phonebook.jar
ENTRYPOINT ["java","-jar","phonebook.jar"`]