-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE roles (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(30) NOT NULL UNIQUE ,
  description varchar(100) DEFAULT NULL,
  date_created datetime DEFAULT CURRENT_TIMESTAMP,
  date_updated datetime DEFAULT CURRENT_TIMESTAMP,
  user_created int(11) DEFAULT NULL,
  user_updated int(11) DEFAULT NULL );