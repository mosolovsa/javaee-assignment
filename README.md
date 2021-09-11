# Assignment #1, course enterprise systems architecture

## Glassfish running

Prereqs: docker (https://docs.docker.com/get-started/)

```
cd ${REPODIR}
docker build -t javaeelaba1 .
docker run -p 4848:4848 -p 8080:8080 -p 8181:8181 javaeelaba1
```

Accessing application:

```
http://127.0.0.1:8080/laba1-1.0-SNAPSHOT/
```

## build WAR

Prereqs: Maven and JDK (sudo apt-get install maven)

```
mvn package
```
