all : build stop run
.PHONY: all

build :
	mvn package
	docker build -t javaeelaba1 .

run :
	docker-compose up

stop :
	docker-compose down
