# FROM store/oracle/serverjre:8 
FROM openjdk:8u302-jdk
#FROM openjdk:11

# Set environment variables and default password for user 'admin'
ENV GLASSFISH_PKG=glassfish-5.0.1.zip \
    GLASSFISH_URL=http://download.oracle.com/glassfish/5.0.1/release \
    GLASSFISH_HOME=/glassfish5 \
    PATH=$PATH:/glassfish5/bin \
    PASSWORD=glassfish

# Install packages, download and extract GlassFish
# Setup password file
# Enable DAS
RUN apt-get install -y wget unzip 
RUN wget --no-check-certificate ${GLASSFISH_URL}/${GLASSFISH_PKG} 
RUN unzip -o ${GLASSFISH_PKG} 
RUN rm -f ${GLASSFISH_PKG} 
RUN apt-get remove --purge -y wget unzip 
RUN echo "----- CREATE PASSWORD FILE --------------------" 
RUN echo "AS_ADMIN_PASSWORD=" > /tmp/gfpassword
RUN echo "AS_ADMIN_NEWPASSWORD=${PASSWORD}" >> /tmp/gfpassword
RUN echo "----- CHANGE ADMIN PASSWORD AND SECURE ADMIN ACCESS --------------------"
RUN asadmin --user=admin --passwordfile=/tmp/gfpassword change-admin-password --domain_name domain1
RUN echo "----- ENABLE DOMAIN ADMINISTRATION SERVER --------------------"
RUN asadmin start-domain && \
    echo "AS_ADMIN_PASSWORD=${PASSWORD}" > /tmp/gfpassword && \
    asadmin --user=admin --passwordfile=/tmp/gfpassword enable-secure-admin && \
    asadmin --user=admin stop-domain 

# Ports being exposed
EXPOSE 4848 8080 8181 9009

COPY target/laba1-1.0-SNAPSHOT.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy

# Start asadmin console and the domain
CMD ["asadmin", "start-domain", "-v", "--debug"]