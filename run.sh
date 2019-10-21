#!/bin/bash

OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=8000"
JAR=/home/likwei/src/private/io-swagger-testbed/target/io-swagger-testbed-1.0.0-SNAPSHOT.jar

java $OPTS -jar $JAR 
