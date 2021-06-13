CREATE TABLE healthometer.product
(
    id                    serial PRIMARY KEY,
    name                  varchar(45) NOT NULL UNIQUE,
    target_category_id    integer NOT NULL,
    unit_subcategories_id integer NOT NULL,
    amount_value          decimal NOT NULL,
    date_created          timestamp,
    date_updated          timestamp,
    user_created          varchar(45),
    user_updated          varchar(45),
    foreign key (target_category_id) references healthometer.target_category (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id)
);