CREATE TABLE user_target
(
    id                 int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id            int(11) NOT NULL,
    target_category_id int(11) NOT NULL,
    amount             decimal,
    measurement        varchar(10),
    date_created       datetime DEFAULT NULL,
    date_updated       datetime DEFAULT NULL,
    user_created       int(11) DEFAULT NULL,
    user_updated       int(11) DEFAULT NULL,
    foreign key (user_id) references users (id),
    foreign key (target_category_id) references target_category (id)
);