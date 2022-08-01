#!/bin/zsh

source ~/.bash_profile
sdk use java 17.0.4-oracle
mvn clean install -DskipTests

docker build . -t theilig/simple-web-service
