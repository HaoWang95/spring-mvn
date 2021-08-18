# To wrap this application as a docker image and then run it as a microservice
# 1. Start with the base image that contains the Java runtime
FROM openjdk:11-slim as build

# 2. Contain some necessary information such as the maintainer
MAINTAINER HaoWang alanwang0028@gmail.com
LABEL maintainer="alanwang0028@gmail.com"

# 3. Add the application's jar file to the container, this jar file is generated via maven and is therefore the
# whole application, here, after the copy, keep the same name
COPY target/swagger-0.0.1-SNAPSHOT.jar swagger-0.0.1-SNAPSHOT.jar

# Another option to copy the jar file is
# ARG JAR_FILE=target/*.jar -> by doing this, we create a variable argument called JAR_FILE which points to the jar.
# Then COPY ${JAR_FILE} app.jar -> copy the JAR_FILE and save it as app.jar

# 4. Define the entrypoint that execute the application
ENTRYPOINT ["java", "-jar", "/swagger-0.0.1-SNAPSHOT.jar"]
