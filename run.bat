@echo off
echo Starting Event Management System...
echo.

REM Check if Java is installed
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed or not in PATH
    echo Please install Java JDK 8 or higher
    pause
    exit /b 1
)

REM Check if MySQL connector is available
if not exist "lib\mysql-connector-j-9.3.0.jar" (
    echo Warning: MySQL connector not found in lib directory
    echo Please ensure mysql-connector-j-9.3.0.jar is in the lib folder
    echo.
)

REM Set classpath
set CLASSPATH=.
if exist "lib\*.jar" (
    for %%i in (lib\*.jar) do set CLASSPATH=!CLASSPATH!;%%i
)

REM Run the application
echo Starting application...
java -cp "%CLASSPATH%" View.MainApplication

if errorlevel 1 (
    echo.
    echo Application failed to start
    echo Please check the error messages above
    pause
) else (
    echo.
    echo Application closed successfully
)

pause 