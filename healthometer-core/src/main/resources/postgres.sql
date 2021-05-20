CREATE TABLE healthometer.status
(
    id           serial PRIMARY KEY,
    name         varchar(45) NOT NULL,
    description  varchar(255),
    date_created timestamp,
    date_updated timestamp,
    user_created integer,
    user_updated integer
);

CREATE TABLE healthometer.roles
(
    id           serial PRIMARY KEY,
    name         varchar(30) NOT NULL UNIQUE,
    description  varchar(100) DEFAULT NULL,
    date_created timestamp,
    date_updated timestamp,
    user_created integer,
    user_updated integer
);

CREATE TABLE healthometer.users
(
    id           serial PRIMARY KEY,
    username     varchar(45)  NOT NULL UNIQUE,
    firstname    varchar(45)  NOT NULL,
    lastname     varchar(45)  NOT NULL,
    email        varchar(100) NOT NULL UNIQUE,
    password     varchar(255) NOT NULL,
    user_status_id  integer,
    date_created timestamp,
    date_updated timestamp,
    user_role_id    integer      NOT NULL,
    user_created integer,
    user_updated integer,
    foreign key (user_status_id) references healthometer.status (id),
    foreign key (user_role_id) references healthometer.roles (id)
);

CREATE TABLE healthometer.unit_categories
(
    id           serial PRIMARY KEY,
    name         varchar(30) NOT NULL UNIQUE,
    description  varchar(100),
    default_unit varchar(10),
    date_created timestamp,
    date_updated timestamp,
    user_created integer,
    user_updated integer
);

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

CREATE TABLE healthometer.body_measurement_categories
(
    id                 serial PRIMARY KEY,
    name               varchar(30) NOT NULL UNIQUE,
    description        varchar(100) DEFAULT NULL,
    unit_categories_id integer     NOT NULL,
    date_created       timestamp,
    date_updated       timestamp,
    user_created       integer,
    user_updated       integer,
    foreign key (unit_categories_id) references healthometer.unit_categories (id)
);





CREATE TABLE healthometer.user_body_measurement
(
    id                           serial PRIMARY KEY,
    user_id                      integer NOT NULL,
    body_measurement_category_id integer NOT NULL,
    unit_subcategories_id        integer,
    value                        decimal,
    date_created                 timestamp,
    date_updated                 timestamp,
    user_created                 integer,
    user_updated                 integer,
    foreign key (body_measurement_category_id) references healthometer.body_measurement_categories (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id)
);


/*CREATE TABLE healthometer.measurements
(
    id                        serial PRIMARY KEY,
    name                      varchar(30) NOT NULL,
    abbreviation              varchar(10) NOT NULL,
    measurement_categories_id varchar(10),
    date_created              timestamp,
    date_updated              timestamp,
    user_created              integer,
    user_updated              integer,
    foreign key (measurement_categories_id) references healthometer.measurement_categories (id)
);
*/


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


CREATE TABLE healthometer.user_target_category
(
    id                    serial PRIMARY KEY,
    user_id               integer NOT NULL,
    target_category_id    integer NOT NULL,
    unit_subcategories_id integer,
    target_value          decimal,
    date_created          timestamp,
    date_updated          timestamp,
    user_created          integer,
    user_updated          integer,
    foreign key (user_id) references healthometer.users (id),
    foreign key (target_category_id) references healthometer.target_category (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id)

);


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
/*
CREATE TABLE healthometer.nutrition
(
    id                  serial PRIMARY KEY,
    name                varchar(45) NOT NULL UNIQUE,
    description         varchar(255),
    default_measurement varchar(10),
    date_created        timestamp,
    date_updated        timestamp,
    user_created        integer,
    user_updated        integer
);

CREATE TABLE healthometer.food_nutrition_information
(
    id           serial PRIMARY KEY,
    product_id   integer NOT NULL,
    nutrition_id integer NOT NULL,
    amount       decimal,
    date_created timestamp,
    date_updated timestamp,
    user_created integer,
    user_updated integer,
    foreign key (product_id) references product (id),
    foreign key (nutrition_id) references nutrition (id)
);

CREATE TABLE healthometer.user_target
(
    id                 serial PRIMARY KEY,
    user_id            integer NOT NULL,
    target_category_id integer NOT NULL,
    amount             decimal,
    measurement        varchar(10),
    date_created       timestamp,
    date_updated       timestamp,
    user_created       integer,
    user_updated       integer,
    foreign key (user_id) references users (id),
    foreign key (target_category_id) references target_category (id)
);
*/
CREATE TABLE healthometer.user_target_tracker
(
    id                      serial PRIMARY KEY,
    user_target_category_id integer NOT NULL,
    product_id              integer,
    unit                    decimal,
    unit_subcategories_id   integer,
    unit_value              decimal,
    date_created            timestamp,
    date_updated            timestamp,
    user_created            integer,
    user_updated            integer,
    foreign key (user_target_category_id) references healthometer.user_target_category (id),
    foreign key (product_id) references healthometer.product (id),
    foreign key (unit_subcategories_id) references healthometer.unit_subcategories (id)
);
