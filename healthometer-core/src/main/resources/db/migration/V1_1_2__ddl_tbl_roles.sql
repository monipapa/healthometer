-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE healthometer.roles
(
    id           serial PRIMARY KEY,
    name         varchar(30) NOT NULL UNIQUE,
    description  varchar(100) DEFAULT NULL,
    date_created timestamp,
    date_updated timestamp,
    user_created varchar(45),
    user_updated varchar(45)
);