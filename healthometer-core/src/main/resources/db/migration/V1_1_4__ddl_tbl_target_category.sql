CREATE TABLE target_category
(
    id                  int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                varchar(45) NOT NULL UNIQUE,
    description         varchar(255),
    default_measurement varchar(10),
    date_created        datetime DEFAULT NULL,
    date_updated        datetime DEFAULT NULL,
    user_created        int(11) DEFAULT NULL,
    user_updated        int(11) DEFAULT NULL
);