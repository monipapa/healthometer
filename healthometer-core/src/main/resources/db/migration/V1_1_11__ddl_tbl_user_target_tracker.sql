CREATE TABLE healthometer.user_target_tracker
(
    id                      serial PRIMARY KEY,
    user_target_category_id integer NOT NULL,
    product_id              integer NOT NULL,
    unit                    decimal NOT NULL,
    unit_subcategories_id   integer,
    unit_value              decimal,
    date_created            timestamp,
    date_updated            timestamp,
    user_created            varchar(45),
    user_updated            varchar(45),
    foreign key (user_target_category_id) references healthometer.user_target_category (id),
    foreign key (product_id) references healthometer.product (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id)
);
