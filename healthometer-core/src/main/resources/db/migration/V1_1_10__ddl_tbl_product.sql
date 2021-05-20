CREATE TABLE healthometer.product
(
    id                    serial PRIMARY KEY,
    name                  varchar(45) NOT NULL UNIQUE,
    target_category_id    integer,
    unit_subcategories_id integer,
    amount_value          decimal,
    date_created          timestamp,
    date_updated          timestamp,
    user_created          integer,
    user_updated          integer,
    foreign key (target_category_id) references healthometer.target_category (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id)
);