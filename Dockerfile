FROM        java:8-jdk

ENV         JAVA_HOME         /usr/lib/jvm/java-8-openjdk-amd64
ENV         GLASSFISH_HOME    /usr/local/glassfish4
ENV         PATH              $PATH:$JAVA_HOME/bin:$GLASSFISH_HOME/bin

ENV ADMIN_USER admin
ENV ADMIN_PASSWORD admin

RUN	    apt-get update && apt-get install -y curl unzip zip inotify-tools && \
            rm -rf /var/lib/apt/lists/; exit 0

RUN         curl -L -o /tmp/glassfish-4.1.zip http://download.java.net/glassfish/4.1/release/glassfish-4.1.zip && \
            unzip /tmp/glassfish-4.1.zip -d /usr/local && \
            rm -f /tmp/glassfish-4.1.zip

EXPOSE      8080 4848 8181

WORKDIR     /usr/local/glassfish4

# set secure-admin enabled and default password
RUN echo 'AS_ADMIN_PASSWORD=\n \
          AS_ADMIN_NEWPASSWORD='$ADMIN_PASSWORD'\n \
          EOF\n' \
          >> /opt/tmpfile

RUN echo 'AS_ADMIN_PASSWORD='$ADMIN_PASSWORD'\n \
          EOF\n' \
          >> /opt/pwdfile

# during build of the container configuring GlassFish to enable secure-admin
# default password admin admin
RUN asadmin start-domain && \
    asadmin --user $ADMIN_USER --passwordfile=/opt/tmpfile change-admin-password && \
    asadmin --user $ADMIN_USER --passwordfile=/opt/pwdfile enable-secure-admin && \
    asadmin restart-domain

COPY target/laba1-1.0-SNAPSHOT.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy

CMD asadmin start-domain --verbose
