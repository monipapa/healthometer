CREATE TABLE healthometer.user_target_category
(
    id                    serial PRIMARY KEY,
    user_id               integer NOT NULL,
    target_category_id    integer NOT NULL,
    unit_subcategories_id integer,
    target_value          decimal,
    date_created          timestamp,
    date_updated          timestamp,
    user_created          varchar(45),
    user_updated          varchar(45),
    foreign key (user_id) references healthometer.users (id),
    foreign key (target_category_id) references healthometer.target_category (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id)

);