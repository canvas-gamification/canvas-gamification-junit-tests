#!/bin/bash
echo "Compiling..."
javac -d bin -cp "lib/*:." -sourcepath src ./src/**/**/*.java
sleep 2
echo "Running..."
java -jar lib/junit-platform-console-standalone-1.9.0-M1.jar --class-path bin --scan-class-path --fail-if-no-tests
