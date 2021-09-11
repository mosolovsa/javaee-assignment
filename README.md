# Assignment #1, enterprise systems architecture course

## App building

Prereqs: Maven and JDK (sudo apt-get install maven)
	     docker docker-compose (https://docs.docker.com/get-started/)

```
cd ${REPODIR}
mvn package
docker build -t javaeelaba1 .
```

## App running

```
cd ${REPODIR}
docker-compose up
```

Accessing application:

```
http://127.0.0.1:8080/laba1-1.0-SNAPSHOT/
```

## Debug in Idea

### In Dockerfile

- Add 9009 to exposed TCP ports:

- change CMD  (note --debug):
```CMD asadmin start-domain --debug --verbose```

### runing container:
docker run -p 4848:4848 -p 8080:8080 -p 8181:8181 -p 41221:9009 javaeelaba1

41221 - port that Idea tries to connect with debugger, 9009 - debugger port inside container

### Idea remote Glassfish debugging
https://www.jetbrains.com/help/idea/run-debug-configuration-glassfish-server.html

## TODO:
- pull app from github and build in container?