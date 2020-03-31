@echo off

@echo This will export the plant_database (case sensitive) to a sql file in the database migrations folder.
@echo You will need to enter the password for user root

cd ..
cd ./database_migrations
set migrationPath=%cd%

cd C:\Program Files\MySQL\MySQL Server 8.0\bin

mysqldump --add-drop-table -u root -p plant_database > %migrationPath%/plant_dump.sql

@echo Done!
pause;