# DROP DATABASE IF EXISTS tasksdb;
#CREATE DATABASE tasksdb; 
#USE tasksdb;

DROP TABLE IF EXISTS tasks;
CREATE TABLE IF NOT EXISTS tasks (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  description varchar(50) DEFAULT NULL,
  status varchar(20),
  PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


