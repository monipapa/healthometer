CREATE TABLE product
(
    id                  int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                varchar(45) NOT NULL UNIQUE,
    amount         decimal ,
    measurement varchar(10),
    target_category_id        int(11),
    date_created        datetime DEFAULT NULL,
    date_updated        datetime DEFAULT NULL,
    user_created        int(11) DEFAULT NULL,
    user_updated        int(11) DEFAULT NULL,
    foreign key (target_category_id) references target_category(id)
);