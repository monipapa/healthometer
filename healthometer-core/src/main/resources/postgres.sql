-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile
CREATE SCHEMA healthometer;
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

-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

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

-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

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


-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO healthometer.status(id, name, description) VALUES (1,'active','active status');
INSERT INTO healthometer.status(id, name, description) VALUES (2,'disabled','disabled status');
INSERT INTO healthometer.status(id, name, description) VALUES (3,'deleted','deleted status');


-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO healthometer.roles VALUES
(1,'admin','admin role',now(),now(),NULL,NULL),
(2,'user','user role',now(),now(),NULL,NULL);

-- noinspection SqlResolveForFile
-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO healthometer.users(id,username,firstname,lastname,email,password,user_status_id, user_role_id) VALUES
(1,'admin','Admin','Mc Admin','admin@ikubinfo.al','$2a$10$bZuFl53cd20mgLFaprt3IuIZ5p9kFAXQHW26NvFAFyDFg/JCQdfni',1, 1),
(2,'user','User','Mc User','user@ikubinfo.al','$2a$10$bZuFl53cd20mgLFaprt3IuIZ5p9kFAXQHW26NvFAFyDFg/JCQdfni',1, 2);
