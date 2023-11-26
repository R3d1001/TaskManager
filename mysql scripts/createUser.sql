create database TaskManager; -- Creates the new database
create user 'TaskManagerUser'@'%' identified by 'Password'; -- Creates the user
grant all on TaskManager.* to 'TaskManagerUser'@'%'; -- Gives all privileges to the new user on the newly created database