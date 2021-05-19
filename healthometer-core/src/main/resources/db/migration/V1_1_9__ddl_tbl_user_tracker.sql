CREATE TABLE user_tracker
(
    id             int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_target_id int(11) NOT NULL,
    product_id     int(11) NOT NULL,
    date_created   datetime,
    date_updated   datetime,
    user_created   int(11),
    user_updated   int(11),
    foreign key (user_target_id) references user_target (id),
    foreign key (product_id) references product (id)
);