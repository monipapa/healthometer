
CREATE TABLE healthometer.body_measurement_categories
(
    id                 serial PRIMARY KEY,
    name               varchar(30) NOT NULL UNIQUE,
    description        varchar(100) DEFAULT NULL,
    unit_categories_id integer     NOT NULL,
    date_created       timestamp,
    date_updated       timestamp,
    user_created       varchar(45),
    user_updated       varchar(45),
    foreign key (unit_categories_id) references healthometer.unit_categories (id)
);