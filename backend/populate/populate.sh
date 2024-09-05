#!/bin/sh
for filename in ./payloads/*; do
	curl --silent -X POST -H "Content-Type: application/json" -d @"$filename" http://spring-boot:8080/add-movie
	echo ""
done
