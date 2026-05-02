@echo off
set "JAVA_HOME=C:\Users\shashi\.cursor\extensions\redhat.java-1.53.0-win32-x64\jre\21.0.10-win32-x86_64"
set "PATH=%JAVA_HOME%\bin;%PATH%"
mvnw.cmd spring-boot:run
