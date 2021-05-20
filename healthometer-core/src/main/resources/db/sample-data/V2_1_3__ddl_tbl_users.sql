-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO healthometer.users(id,username,firstname,lastname,email,password,user_status_id, user_role_id) VALUES
(1,'admin','Admin','Mc Admin','admin@ikubinfo.al','$2a$10$bZuFl53cd20mgLFaprt3IuIZ5p9kFAXQHW26NvFAFyDFg/JCQdfni',1, 1),
(2,'user','User','Mc User','user@ikubinfo.al','$2a$10$bZuFl53cd20mgLFaprt3IuIZ5p9kFAXQHW26NvFAFyDFg/JCQdfni',1, 2);
