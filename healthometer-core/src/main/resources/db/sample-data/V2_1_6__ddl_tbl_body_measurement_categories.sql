INSERT INTO healthometer.body_measurement_categories(id,name, description,unit_categories_id,date_created, date_updated,
                                            user_created,
                                            user_updated)
VALUES (1,  'Weight', 'Body''s relative mass or the quantity of matter contained by it, giving rise to a downward force.',1, now(), now(), NULL, NULL),
       (2,  'Height', 'The measurement of someone or something from head to foot or from base to top.',3, now(), now(), NULL, NULL);
