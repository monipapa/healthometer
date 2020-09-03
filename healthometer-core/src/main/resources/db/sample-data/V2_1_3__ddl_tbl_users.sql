-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO users(id,username,firstname,lastname,email,password,user_status, user_role) VALUES
(1,'admin','Admin','Mc Admin','admin@ikub.al','$2a$10$bZuFl53cd20mgLFaprt3IuIZ5p9kFAXQHW26NvFAFyDFg/JCQdfni',1, 1),
(2,'user','User','Mc User','user@ikub.al','$2a$10$bZuFl53cd20mgLFaprt3IuIZ5p9kFAXQHW26NvFAFyDFg/JCQdfni',1, 2);
