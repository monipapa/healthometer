INSERT INTO healthometer.unit_categories(id, name, description, default_unit, date_created, date_updated, user_created,
                                         user_updated)
VALUES (1, 'Weight', 'Unit for measuring weight', 'Kg', now(), now(), NULL, NULL),
       (2, 'Energy', 'Unit for measuring energy', 'Cal', now(), now(), NULL, NULL);
