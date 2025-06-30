@echo off
echo ========================================
echo Event Management System - Database Setup
echo ========================================
echo.

REM Check if MySQL is installed
mysql --version >nul 2>&1
if errorlevel 1 (
    echo Error: MySQL is not installed or not in PATH
    echo Please install MySQL Server first
    pause
    exit /b 1
)

echo MySQL found. Starting database setup...
echo.

REM Set MySQL connection parameters
set MYSQL_HOST=localhost
set MYSQL_USER=root
set MYSQL_PASSWORD=12345678
set DATABASE_NAME="Event management"

echo Step 1: Creating database...
mysql -h %MYSQL_HOST% -u %MYSQL_USER% -p%MYSQL_PASSWORD% -e "CREATE DATABASE IF NOT EXISTS %DATABASE_NAME%;"

if errorlevel 1 (
    echo Error: Failed to create database
    echo Please check your MySQL credentials
    pause
    exit /b 1
)

echo ✓ Database created successfully
echo.

echo Step 2: Creating tables and inserting sample data...
mysql -h %MYSQL_HOST% -u %MYSQL_USER% -p%MYSQL_PASSWORD% %DATABASE_NAME% < database_setup.sql

if errorlevel 1 (
    echo Error: Failed to run database setup script
    echo Please check the database_setup.sql file
    pause
    exit /b 1
)

echo ✓ Tables created and sample data inserted successfully
echo.

echo Step 3: Testing database connection...
echo Running database connection test...

REM Set classpath for Java
set CLASSPATH=.
if exist "lib\*.jar" (
    for %%i in (lib\*.jar) do set CLASSPATH=!CLASSPATH!;%%i
)

java -cp "%CLASSPATH%" Database.DatabaseConnectionTest

if errorlevel 1 (
    echo.
    echo Database setup completed but connection test failed
    echo Please check the error messages above
) else (
    echo.
    echo ========================================
    echo Database setup completed successfully!
    echo ========================================
    echo.
    echo You can now run the Event Management System
    echo.
)

pause 