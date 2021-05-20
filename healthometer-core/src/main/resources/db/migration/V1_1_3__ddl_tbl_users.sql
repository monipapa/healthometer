-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE healthometer.users
(
    id           serial PRIMARY KEY,
    username     varchar(45)  NOT NULL UNIQUE,
    firstname    varchar(45)  NOT NULL,
    lastname     varchar(45)  NOT NULL,
    email        varchar(100) NOT NULL UNIQUE,
    password     varchar(255) NOT NULL,
    user_status_id  integer,
    date_created timestamp,
    date_updated timestamp,
    user_role_id    integer      NOT NULL,
    user_created integer,
    user_updated integer,
    foreign key (user_status_id) references healthometer.status (id),
    foreign key (user_role_id) references healthometer.roles (id)
);