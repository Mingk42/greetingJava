#!/bin/bash

JAR_FILE_NAME=greeting-0.0.1-SNAPSHOT.jar

# Get PID from the file
PID=$(pgrep -f $JAR_FILKE_NAME)

if [ -z "$PID" ]; then
	echo "> 현재 구동중인 어플리케이션이 없습니다. 종료할 수 없습니다."
else
	echo "> kill -9 $PID"
	kill -9 $PID
	echo "> 실행중인 애플리케이션을 종료하고 있습니다..."
	sleep 10
fi
