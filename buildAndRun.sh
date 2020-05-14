#!/bin/sh
mvn clean package && docker build -t it.alfonsodomenici/jwtpayara .
docker rm -f jwtpayara || true && docker run -d -p 8080:8080 -p 4848:4848 --name jwtpayara it.alfonsodomenici/jwtpayara 
