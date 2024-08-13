#!/bin/bash
for filename in ./payloads/*; do
	curl -H 'Content-Type: application/json' \
		-d '$(cat $filename)' \
		-X POST \
		http://localhost:6868/add-movie
done
