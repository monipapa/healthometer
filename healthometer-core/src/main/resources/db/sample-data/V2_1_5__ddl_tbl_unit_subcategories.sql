INSERT INTO healthometer.unit_subcategories(id, unit_categories_id, name, abbreviation, date_created, date_updated,
                                            user_created,
                                            user_updated)
VALUES (1, 1, 'Kilogram', 'kg', now(), now(), NULL, NULL),
       (2, 1, 'Gram', 'g', now(), now(), NULL, NULL),
       (3, 3, 'Centimeter', 'cm', now(), now(), NULL, NULL),
       (4, 2, 'Calories', 'cal', now(), now(), NULL, NULL);