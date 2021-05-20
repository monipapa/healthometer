-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile
CREATE SCHEMA healthometer;
CREATE TABLE healthometer.status
(
    id           serial PRIMARY KEY,
    name         varchar(45) NOT NULL,
    description  varchar(255),
    date_created timestamp,
    date_updated timestamp,
    user_created integer,
    user_updated integer
);