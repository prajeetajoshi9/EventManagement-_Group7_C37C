#!/bin/bash

echo "Starting Event Management System..."
echo

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "Error: Java is not installed or not in PATH"
    echo "Please install Java JDK 8 or higher"
    exit 1
fi

# Check Java version
java_version=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$java_version" -lt 8 ]; then
    echo "Error: Java 8 or higher is required"
    echo "Current version: $(java -version 2>&1 | head -n 1)"
    exit 1
fi

# Check if MySQL connector is available
if [ ! -f "lib/mysql-connector-j-9.3.0.jar" ]; then
    echo "Warning: MySQL connector not found in lib directory"
    echo "Please ensure mysql-connector-j-9.3.0.jar is in the lib folder"
    echo
fi

# Set classpath
CLASSPATH="."
if [ -d "lib" ]; then
    for jar in lib/*.jar; do
        if [ -f "$jar" ]; then
            CLASSPATH="$CLASSPATH:$jar"
        fi
    done
fi

# Run the application
echo "Starting application..."
java -cp "$CLASSPATH" View.MainApplication

if [ $? -eq 0 ]; then
    echo
    echo "Application closed successfully"
else
    echo
    echo "Application failed to start"
    echo "Please check the error messages above"
fi 