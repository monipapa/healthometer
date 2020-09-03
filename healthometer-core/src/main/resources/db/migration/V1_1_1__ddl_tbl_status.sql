-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE status (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(45) NOT NULL,
  description varchar(255) DEFAULT NULL,
  date_created datetime DEFAULT NULL,
  date_updated datetime DEFAULT NULL,
  user_created int(11) DEFAULT NULL,
  user_updated int(11) DEFAULT NULL);