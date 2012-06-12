@echo off
echo Compilation...
echo %~n1
java -jar Compiller.jar %1
if not exist %1.j goto end

java -jar lib/jasmin.jar %1.j
del %1.j

if not exist %~n1.class goto end

jar cvfe %~n1.jar %~n1 %~n1.class
del %~n1.class
: end