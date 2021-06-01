INSERT INTO healthometer.unit_categories(id, name, description, default_unit, date_created, date_updated, user_created,
                                         user_updated)
VALUES (1, 'Weight', 'Unit for measuring weight', 'kg', now(), now(), NULL, NULL),
       (2, 'Energy', 'Unit for measuring energy', 'cal', now(), now(), NULL, NULL),
       (3, 'Height', 'Unit for measuring height', 'cm', now(), now(), NULL, NULL),
       (4, '', '', '', now(), now(), NULL, NULL);
