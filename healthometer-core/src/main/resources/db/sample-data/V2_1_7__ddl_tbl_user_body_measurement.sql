INSERT INTO healthometer.user_body_measurement(id, user_id, body_measurement_category_id, unit_subcategories_id, value,
                                               date_created, date_updated,
                                               user_created,
                                               user_updated)
VALUES (1, 1,1,1,54,now(), now(), NULL, NULL),
       (2, 1,2,3,163,now(), now(), NULL, NULL),
       (3, 2,1,1,56,now(), now(), NULL, NULL),
       (4, 2,2,3,171,now(), now(), NULL, NULL),
       (5, 1,3,5 ,19,now(), now(), NULL, NULL),
       (6, 1,1,1,52,now(), now(), NULL, NULL);

/*
VALUES (1, 1, 1, 1, 54, now(), now(), NULL, NULL),
       (2, 1, 2, 3, 163, now(), now(), NULL, NULL),
       (3, 2, 1, 1, 56, now(), now(), NULL, NULL),
       (4, 2, 2, 3, 171, now(), now(), NULL, NULL),
       (5, 1, 4, NULL, 19, now(), now(), NULL, NULL),
       (6, 1, 1, 1, 52, now(), now(), NULL, NULL);*/