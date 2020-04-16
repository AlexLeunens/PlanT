@echo off

@echo This will import the plant_database (case sensitive) from a sql file in the database migrations folder.
@echo You will need to enter the password for user root

cd ..
cd ./database_migrations
set migrationPath=%cd%

cd C:\Program Files\MySQL\MySQL Server 8.0\bin

mysql -u root -p plant_database < %migrationPath%/plant_dump.sql

@echo Done!
pause;