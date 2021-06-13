INSERT INTO healthometer.unit_categories(id, name, description, default_unit, date_created, date_updated, user_created,
                                         user_updated)
VALUES (1, 'Mass', 'Unit for measuring mass', 'g', now(), now(), NULL, NULL),
       (2, 'Energy', 'Unit for measuring energy', 'cal', now(), now(), NULL, NULL),
       (3, 'Length', 'Unit for measuring height', 'cm', now(), now(), NULL, NULL),
       (4, '', '', '', now(), now(), NULL, NULL);
