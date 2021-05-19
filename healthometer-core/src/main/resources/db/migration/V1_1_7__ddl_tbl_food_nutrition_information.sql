CREATE TABLE food_nutrition_information
(
    id           int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id   int(11) NOT NULL,
    nutrition_id int(11) NOT NULL,
    amount       decimal,
    date_created datetime DEFAULT NULL,
    date_updated datetime DEFAULT NULL,
    user_created int(11) DEFAULT NULL,
    user_updated int(11) DEFAULT NULL,
    foreign key (product_id) references product (id),
    foreign key (nutrition_id) references nutrition (id)
);