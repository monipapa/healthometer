CREATE TABLE healthometer.unit_categories
(
    id           serial PRIMARY KEY,
    name         varchar(30) NOT NULL UNIQUE,
    description  varchar(100),
    default_unit varchar(30),
    date_created timestamp,
    date_updated timestamp,
    user_created varchar(45),
    user_updated varchar(45)
);