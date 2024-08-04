FROM maven:3.9.6-amazoncorretto-17 AS user-service-development

ENV LANG=C.UTF-8 \
  APP_HOME=/usr/src/app \
  MAVEN_CONFIG=/root/.m2

WORKDIR $APP_HOME

CMD mvn spring-boot:run


FROM user-service-development AS user-service

ENV LANG=C.UTF-8 \
  APP_HOME=/usr/src/app \
  MAVEN_CONFIG=/root/.m2

WORKDIR $APP_HOME

COPY pom.xml ./

RUN mvn -Dmaven.test.skip=true dependency:resolve-plugins

RUN mvn -Dmaven.test.skip=true dependency:resolve

COPY . .

RUN mvn -Dmaven.test.skip=true clean package

CMD mvn spring-boot:run
