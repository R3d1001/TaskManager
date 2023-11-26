use TaskManager;

select * from comments;

insert into Users(username, password, email, firstName, lastName, gender) values (
    'sickfires1',
    '123',
    'abc1@xyz.com',
    'abc',
    'xyz',
    'M'
    );


insert into Tasks(name, description, creationDate, setDueDate, status, priority, ownerUserID) values (
	'dummy name2',
    'dummy description',
    curdate(),
    curdate(),
    'Incomplete',
    2,
    1
);

insert into UserTask values (1, 1);

select * from tasks;
select * from UserTask;


select * from Users;

select * from tasks;
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

