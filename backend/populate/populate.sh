#!/bin/bash
for filename in ./payloads/*; do
	curl -X POST -H "Content-Type: application/json" -d @$filename http://localhost:6868/add-movie
done
