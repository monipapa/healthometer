CREATE TABLE healthometer.unit_subcategories
(
    id                 serial PRIMARY KEY,
    unit_categories_id integer     NOT NULL,
    name               varchar(30) NOT NULL,
    abbreviation       varchar(10),
    date_created       timestamp,
    date_updated       timestamp,
    user_created       varchar(45),
    user_updated       varchar(45)
);