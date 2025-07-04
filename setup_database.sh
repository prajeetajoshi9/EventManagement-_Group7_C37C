#!/bin/bash

echo "========================================"
echo "Event Management System - Database Setup"
echo "========================================"
echo

# Check if MySQL is installed
if ! command -v mysql &> /dev/null; then
    echo "Error: MySQL is not installed or not in PATH"
    echo "Please install MySQL Server first"
    exit 1
fi

echo "MySQL found. Starting database setup..."
echo

# Set MySQL connection parameters
MYSQL_HOST="localhost"
MYSQL_USER="root"
MYSQL_PASSWORD="12345678"
DATABASE_NAME="Event management"

echo "Step 1: Creating database..."
mysql -h "$MYSQL_HOST" -u "$MYSQL_USER" -p"$MYSQL_PASSWORD" -e "CREATE DATABASE IF NOT EXISTS \`$DATABASE_NAME\`;"

if [ $? -ne 0 ]; then
    echo "Error: Failed to create database"
    echo "Please check your MySQL credentials"
    exit 1
fi

echo "✓ Database created successfully"
echo

echo "Step 2: Creating tables and inserting sample data..."
mysql -h "$MYSQL_HOST" -u "$MYSQL_USER" -p"$MYSQL_PASSWORD" "$DATABASE_NAME" < database_setup.sql

if [ $? -ne 0 ]; then
    echo "Error: Failed to run database setup script"
    echo "Please check the database_setup.sql file"
    exit 1
fi

echo "✓ Tables created and sample data inserted successfully"
echo

echo "Step 3: Testing database connection..."
echo "Running database connection test..."

# Set classpath for Java
CLASSPATH="."
if [ -d "lib" ]; then
    for jar in lib/*.jar; do
        if [ -f "$jar" ]; then
            CLASSPATH="$CLASSPATH:$jar"
        fi
    done
fi

java -cp "$CLASSPATH" Database.DatabaseConnectionTest

if [ $? -eq 0 ]; then
    echo
    echo "========================================"
    echo "Database setup completed successfully!"
    echo "========================================"
    echo
    echo "You can now run the Event Management System"
    echo
else
    echo
    echo "Database setup completed but connection test failed"
    echo "Please check the error messages above"
fi 