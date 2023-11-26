USE TaskManager;


ALTER TABLE `Tasks` DROP FOREIGN KEY `Tasks_fk1`;
DROP TABLE SubTasks;
DROP TABLE UserTask;
DROP TABLE Comments;
DROP TABLE Tasks;
DROP TABLE Users;


CREATE TABLE `Users` (
	`id` INT(5) NOT NULL AUTO_INCREMENT UNIQUE,
	`Username` varchar(20) NOT NULL UNIQUE,
	`Password` varchar(20) NOT NULL,
	`Email` varchar(50) NOT NULL UNIQUE,
	`FirstName` TEXT(20) NOT NULL,
	`LastName` TEXT(20) NOT NULL,
	`Gender` char(1) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Tasks` (
	`TaskID` INT NOT NULL AUTO_INCREMENT UNIQUE,
	`Name` TEXT NOT NULL,
	`Description` TEXT NOT NULL,
	`CreationDate` DATE NOT NULL,
	`SetDueDate` DATE NOT NULL,
	`Status` TEXT NOT NULL,
	`Priority` INT NOT NULL,
	`OwnerUserID` int NOT NULL UNIQUE,
	PRIMARY KEY (`TaskID`)
);

CREATE TABLE `SubTasks` (
	`SubtaskID` INT NOT NULL AUTO_INCREMENT,
	`ParentTaskID` INT NOT NULL,
	`Title` varchar(255) NOT NULL,
	`Description` TEXT NOT NULL,
	`DueDate` DATE NOT NULL,
	`Status` TEXT NOT NULL,
	`Priority` TEXT NOT NULL,
	`AssignedTO` INT NOT NULL,
	PRIMARY KEY (`SubtaskID`)
);

CREATE TABLE `UserTask` (
	`id` INT NOT NULL,
	`TaskID` INT NOT NULL,
	PRIMARY KEY (`id`,`TaskID`)
);

CREATE TABLE `Comments` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`TaskID` INT NOT NULL,
	`Description` TEXT NOT NULL,
	`UserID` INT NOT NULL,
	PRIMARY KEY (`id`)
);


ALTER TABLE `Tasks` ADD CONSTRAINT `Tasks_fk1` FOREIGN KEY (`OwnerUserID`) REFERENCES `Users`(`id`);

ALTER TABLE `SubTasks` ADD CONSTRAINT `SubTasks_fk0` FOREIGN KEY (`ParentTaskID`) REFERENCES `Tasks`(`TaskID`);

ALTER TABLE `SubTasks` ADD CONSTRAINT `SubTasks_fk1` FOREIGN KEY (`AssignedTO`) REFERENCES `Users`(`id`);

ALTER TABLE `UserTask` ADD CONSTRAINT `UserTask_fk0` FOREIGN KEY (`id`) REFERENCES `Users`(`id`);

ALTER TABLE `UserTask` ADD CONSTRAINT `UserTask_fk1` FOREIGN KEY (`TaskID`) REFERENCES `Tasks`(`TaskID`);

ALTER TABLE `Comments` ADD CONSTRAINT `Comments_fk0` FOREIGN KEY (`TaskID`) REFERENCES `Tasks`(`TaskID`);

ALTER TABLE `Comments` ADD CONSTRAINT `Comments_fk1` FOREIGN KEY (`UserID`) REFERENCES `Users`(`id`);





