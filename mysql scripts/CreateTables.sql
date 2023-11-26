USE TaskManager;


ALTER TABLE `Tasks` DROP FOREIGN KEY `Tasks_fk1`;
DROP TABLE SubTasks;
DROP TABLE UserTask;
DROP TABLE Comments;
DROP TABLE Tasks;
DROP TABLE Users;

CREATE TABLE dummy (
	id int primary key
);

CREATE TABLE Users (
	`id` INT(5) NOT NULL AUTO_INCREMENT UNIQUE,
	`username` varchar(20) NOT NULL UNIQUE,
	`password` varchar(255) NOT NULL,
	`email` varchar(50) NOT NULL UNIQUE,
	`firstName` TEXT(20) NOT NULL,
	`lastName` TEXT(20) NOT NULL,
	`gender` char(1) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Tasks` (
	`taskID` INT NOT NULL AUTO_INCREMENT UNIQUE,
	`name` TEXT NOT NULL,
	`description` TEXT NOT NULL,
	`creationDate` DATE NOT NULL,
	`setDueDate` DATE NOT NULL,
	`status` TEXT NOT NULL,
	`priority` INT NOT NULL,
	`ownerUserID` int NOT NULL UNIQUE,
	PRIMARY KEY (`taskID`)
);

CREATE TABLE `SubTasks` (
	`subtaskID` INT NOT NULL AUTO_INCREMENT,
	`parentTaskID` INT NOT NULL,
	`title` varchar(255) NOT NULL,
	`description` TEXT NOT NULL,
	`dueDate` DATE NOT NULL,
	`status` TEXT NOT NULL,
	`priority` TEXT NOT NULL,
	`assignedTO` INT NOT NULL,
	PRIMARY KEY (`subtaskID`)
);

CREATE TABLE `UserTask` (
	`id` INT NOT NULL,
	`TaskID` INT NOT NULL,
	PRIMARY KEY (`id`,`TaskID`)
);

CREATE TABLE `Comments` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`taskID` INT NOT NULL,
	`description` TEXT NOT NULL,
	`userID` INT NOT NULL,
	PRIMARY KEY (`id`)
);


ALTER TABLE `Tasks` ADD CONSTRAINT `Tasks_fk1` FOREIGN KEY (`ownerUserID`) REFERENCES `Users`(`id`);

ALTER TABLE `SubTasks` ADD CONSTRAINT `SubTasks_fk0` FOREIGN KEY (`parentTaskID`) REFERENCES `Tasks`(`taskID`);

ALTER TABLE `SubTasks` ADD CONSTRAINT `SubTasks_fk1` FOREIGN KEY (`assignedTO`) REFERENCES `Users`(`id`);

ALTER TABLE `UserTask` ADD CONSTRAINT `UserTask_fk0` FOREIGN KEY (`id`) REFERENCES `Users`(`id`);

ALTER TABLE `UserTask` ADD CONSTRAINT `UserTask_fk1` FOREIGN KEY (`taskID`) REFERENCES `Tasks`(`taskID`);

ALTER TABLE `Comments` ADD CONSTRAINT `Comments_fk0` FOREIGN KEY (`taskID`) REFERENCES `Tasks`(`taskID`);

ALTER TABLE `Comments` ADD CONSTRAINT `Comments_fk1` FOREIGN KEY (`userID`) REFERENCES `users`(`id`);








