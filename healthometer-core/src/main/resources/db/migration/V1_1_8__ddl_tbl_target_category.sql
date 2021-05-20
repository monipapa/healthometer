CREATE TABLE healthometer.target_category
(
    id                 serial PRIMARY KEY,
    name               varchar(45) NOT NULL UNIQUE,
    description        varchar(255),
    unit_categories_id integer,
    date_created       timestamp,
    date_updated       timestamp,
    user_created       integer,
    user_updated       integer,
    foreign key (unit_categories_id) references healthometer.unit_categories (id)

);