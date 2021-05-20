
CREATE TABLE healthometer.unit_subcategories
(
    id                 serial PRIMARY KEY,
    unit_categories_id integer     NOT NULL,
    name               varchar(30) NOT NULL,
    date_created       timestamp,
    date_updated       timestamp,
    user_created       integer,
    user_updated       integer
);