DROP DATABASE IF EXISTS springbootdb;
CREATE DATABASE springbootdb; 
USE springbootdb;

DROP TABLE IF EXISTS tasks;
CREATE TABLE IF NOT EXISTS tasks (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  description varchar(50) DEFAULT NULL,
  status varchar(20),
  PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO tasks (id, description,status) VALUES
	(1001,'Schedule daily staus call','Completed'),
	(1002,'Update priorities','In progress'),
	(1003,'Set up call with client','New');
commit;
