
CREATE TABLE healthometer.user_body_measurement
(
    id                           serial PRIMARY KEY,
    user_id                      integer NOT NULL,
    body_measurement_category_id integer NOT NULL,
    unit_subcategories_id        integer,
    value                        decimal,
    date_created                 timestamp,
    date_updated                 timestamp,
    user_created                 varchar(45),
    user_updated                 varchar(45),
    foreign key (body_measurement_category_id) references healthometer.body_measurement_categories (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id),
    foreign key (user_id) references healthometer.users (id)
);