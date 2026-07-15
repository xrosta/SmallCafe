#!/bin/bash
set -e
mvn clean package
java -jar target/smallcafe-1.0.0.jar
