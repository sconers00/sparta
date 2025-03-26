CREATE TABLE `todo` (
	`id`	bigint	NOT NULL	COMMENT 'autogen',
	`todo`	varchar(200)
	`created`	date	NOT NULL	COMMENT 'fixed value',
	`edited`	date	NOT NULL,
	`pswd`	varchar(20)	NOT NULL
);

CREATE TABLE `scheduler` (
	`user`	varchar(20)	NOT NULL,
	`id`	bigint	NOT NULL	COMMENT 'autogen'
);

CREATE TABLE `user` (
	`user`	varchar(20)	NOT NULL,
	`name`	varchar(20)	NOT NULL,
	`email`	varcher(40)	NOT NULL
);

