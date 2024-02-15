#!/bin/bash

echo
echo "### Adding superman ###"
curl -s -X POST http://localhost:8080/heroes/superman/35 | jq .

echo
echo "### Adding batman ###"
curl -s -X POST http://localhost:8080/heroes/batman/45 | jq .

echo
echo "### Listing all heroes ###"
curl -s http://localhost:8080/heroes | jq .
