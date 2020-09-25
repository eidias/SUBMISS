FROM openjdk:8
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

RUN mkdir -p /app/submiss-dist/target/submiss
RUN unzip /app/submiss-dist/target/submiss-dist-1.8.0.zip -d /app/submiss-dist/target/submiss

RUN ls -la /app/submiss-dist/target/submiss

WORKDIR /app/submiss-dist/target/submiss/bin

EXPOSE 1099 8101 44444

CMD ["./start"]