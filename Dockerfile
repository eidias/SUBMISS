FROM java:8-jdk
MAINTAINER Ahmed Rizawan (ahm.rizawan@gmail.com)

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV MAVEN_HOME /opt/maven/apache-maven-3.6.3-bin
ENV KARAF_HOME /opt/karaf/apache-karaf-4.2.9

RUN apt-get update \
	&& apt-get install unzip supervisor nano htop -yq \
  	&& apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN mkdir /opt/maven;
RUN mkdir /opt/karaf;
RUN mkdir /app;

ADD tools/apache-maven-3.6.3-bin.zip /opt/maven
ADD tools/apache-karaf-4.2.9.zip /opt/karaf

RUN unzip /opt/maven/apache-maven-3.6.3-bin.zip
RUN unzip /opt/karaf/apache-karaf-4.2.9.zip

WORKDIR /app
ADD . .

RUN mvn clean install; \
    tar --strip-components=1 -C /opt/karaf -xzf target/karaf-distro-1.0-SNAPSHOT.tar.gz; \
    rm -rf /tmp/*

RUN chmod 755 /opt; \
    sed -i "21s/out/stdout/" /opt/karaf/etc/org.ops4j.pax.logging.cfg;

VOLUME ["/opt/karaf/deploy"]

EXPOSE 1099 8101 44444

CMD ["/opt/karaf/bin/karaf"]