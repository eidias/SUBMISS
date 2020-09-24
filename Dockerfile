FROM openjdk:8 as builder
MAINTAINER Ahmed Rizawan (ahm.rizawan@gmail.com)

ENV JAVA_HOME /usr/local/openjdk-8
ENV MAVEN_HOME /opt/maven/apache-maven-3.6.3
ENV KARAF_HOME /opt/karaf/apache-karaf-4.2.9
ENV PATH="$MAVEN_HOME/bin:${PATH}"
ENV PATH="$KARAF_HOME/bin:${PATH}"

RUN apt-get update \
	&& curl -sL https://deb.nodesource.com/setup_14.x | bash - \
	&& apt-get install unzip supervisor nano htop nodejs build-essential chrpath libssl-dev libxft-dev libfreetype6 libfreetype6-dev libfontconfig1 libfontconfig1-dev wget -yq \
  	&& apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN mkdir /opt/maven;
RUN mkdir /opt/karaf;
RUN mkdir /opt/submiss
RUN mkdir /app;

ADD tools/apache-maven-3.6.3-bin.zip /opt/maven
ADD tools/apache-karaf-4.2.9.zip /opt/karaf

RUN unzip /opt/maven/apache-maven-3.6.3-bin.zip -d /opt/maven/
RUN unzip /opt/karaf/apache-karaf-4.2.9.zip -d /opt/karaf/

WORKDIR /app

ADD . .

WORKDIR /app/submiss-web-ui

RUN cd $(npm root -g)/npm \
  && npm install fs-extra \
  && npm install yarn gulp bower -g

RUN yarn
RUN echo '{ "allow_root": true }' > /root/.bowerrc
RUN bower install --allow-root

RUN chmod 755 /opt

RUN chmod +x /app/tools/scripts/init.sh \
	&& sh /app/tools/scripts/init.sh

RUN cp -apv /app/tools/karaf_etc/* /opt/karaf/apache-karaf-4.2.9/etc/
RUN cp -apv /app/configs/* /opt/karaf/apache-karaf-4.2.9/etc/

WORKDIR /app

RUN mvn clean install -DskipTests -e

# our final base image
FROM openjdk:8u171-jre-alpine

MAINTAINER Ahmed Rizawan (ahm.rizawan@gmail.com)

RUN apk update && apk upgrade && apk add netcat-openbsd && apk add curl unzip

ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV MAVEN_HOME /opt/maven/apache-maven-3.6.3
ENV KARAF_HOME /opt/karaf/apache-karaf-4.2.9
ENV PATH="$MAVEN_HOME/bin:${PATH}"
ENV PATH="$KARAF_HOME/bin:${PATH}"

RUN mkdir -p /opt/maven;
RUN mkdir -p /opt/karaf;
RUN mkdir -p /opt/submiss
RUN mkdir -p /app;

WORKDIR /app

# copy over the built artifact from the maven image
COPY --from=builder /app/submiss-dist/target/*.zip ./
COPY --from=builder /opt/maven/apache-maven-3.6.3-bin.zip /opt/maven
COPY --from=builder /opt/karaf/apache-karaf-4.2.9.zip /opt/karaf

RUN unzip /opt/maven/apache-maven-3.6.3-bin.zip -d /opt/maven/
RUN unzip /opt/karaf/apache-karaf-4.2.9.zip -d /opt/karaf/

RUN unzip /app/submiss-dist-1.8.0.zip -d /opt/submiss/

RUN ls -la /opt/submiss/submiss-dist-1.8.0

EXPOSE 1099 8101 44444

CMD ["/opt/karaf/apache-karaf-4.2.9/bin/karaf", "server"]