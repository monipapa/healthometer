CREATE TABLE healthometer.unit_categories
(
    id           serial PRIMARY KEY,
    name         varchar(30) NOT NULL UNIQUE,
    description  varchar(100),
    default_unit varchar(10),
    date_created timestamp,
    date_updated timestamp,
    user_created integer,
    user_updated integer
);