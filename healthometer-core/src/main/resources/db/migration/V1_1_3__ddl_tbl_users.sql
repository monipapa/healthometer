-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username varchar(45) NOT NULL UNIQUE,
  firstname varchar(45) NOT NULL,
  lastname varchar(45) NOT NULL,
  email varchar(100) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  user_status int(11) DEFAULT NULL,
  date_created datetime DEFAULT NULL,
  date_updated datetime DEFAULT NULL,
  user_role int(11) NOT NULL,
  user_created int(11) DEFAULT NULL,
  user_updated int(11) DEFAULT NULL);