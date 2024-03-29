INSERT INTO locations(location_id_pk, location_name) VALUES(111, 'Location Varese');
INSERT INTO locations(location_id_pk, location_name) VALUES(112, 'Location Milano');

INSERT INTO cities(city_id_pk, city_name) VALUES (111, 'Varese');
INSERT INTO cities(city_id_pk, city_name) VALUES (112, 'Milano');
INSERT INTO cities(city_id_pk, city_name) VALUES (113, 'Gallarate');
INSERT INTO cities(city_id_pk, city_name) VALUES (114, 'Busto Arsizio');

INSERT INTO locations_cities(locations_cities_id_pk, location_id_fk, city_id_fk) VALUES (111, 111, 111);
INSERT INTO locations_cities(locations_cities_id_pk, location_id_fk, city_id_fk) VALUES (112, 112, 112);
INSERT INTO locations_cities(locations_cities_id_pk, location_id_fk, city_id_fk) VALUES (113, 111, 113);
INSERT INTO locations_cities(locations_cities_id_pk, location_id_fk, city_id_fk) VALUES (114, 112, 114);

INSERT INTO clients(client_id_pk, name, surname, gender, telephone_number, description, location_id_fk) VALUES (111, 'User Name 1', 'User Surname 1', 'Male', '393844697812', 'Description', 111);
INSERT INTO clients(client_id_pk, name, surname, gender, telephone_number, description, location_id_fk) VALUES (112, 'User Name 2', 'User Surname 2', 'Female', '393844697812', 'Description', 111);
INSERT INTO clients(client_id_pk, name, surname, gender, telephone_number, description, location_id_fk) VALUES (113, 'User Name 3', 'User Surname 3', 'Male', '393844697812', 'Description', 112);
INSERT INTO clients(client_id_pk, name, surname, gender, telephone_number, description, location_id_fk) VALUES (114, 'User Name 4', 'User Surname 4', 'Female', '393844697812', 'Description', 112);
INSERT INTO clients(client_id_pk, name, surname, gender, telephone_number, description, location_id_fk) VALUES (115, 'User Name 5', 'User Surname 5', 'Male', '393844697812', 'Description', 111);

INSERT INTO order_types(order_type_id_pk, type) VALUES(111, 'Tattoo');
INSERT INTO order_types(order_type_id_pk, type) VALUES(112, 'Permanent Makeup');

INSERT INTO orders(order_id_pk, sitting_number, avg_sitting_cost, order_price, already_paid, prepayment, state, start_date, end_date, order_type_id_fk, client_id_fk)
VALUES(111, 5, 100, 200, 100, 100, 'Preview', '20/04/2021','20/06/2022', 111, 111);
INSERT INTO orders(order_id_pk, sitting_number, avg_sitting_cost, order_price, already_paid, prepayment, state, start_date, end_date, order_type_id_fk, client_id_fk)
VALUES(112, 3, 120, 450, 225, 150, 'To do', '20/04/2021','20/06/2022', 111, 111);
INSERT INTO orders(order_id_pk, sitting_number, avg_sitting_cost, order_price, already_paid, prepayment, state, start_date, end_date, order_type_id_fk, client_id_fk)
VALUES(113, 6, 130, 770, 335, 200, 'In Progress', '20/04/2021','20/06/2022', 111, 111);
INSERT INTO orders(order_id_pk, sitting_number, avg_sitting_cost, order_price, already_paid, prepayment, state, start_date, end_date, order_type_id_fk, client_id_fk)
VALUES(114, 7, 150, 440, 220, 450, 'Finished', '20/04/2021','20/06/2022', 111, 112);
INSERT INTO orders(order_id_pk, sitting_number, avg_sitting_cost, order_price, already_paid, prepayment, state, start_date, end_date, order_type_id_fk, client_id_fk)
VALUES(115, 2, 100, 450, 225, 744, 'To do', '20/04/2021','20/06/2022', 111, 113);
INSERT INTO orders(order_id_pk, sitting_number, avg_sitting_cost, order_price, already_paid, prepayment, state, start_date, end_date, order_type_id_fk, client_id_fk)
VALUES(116, 5, 190, 200, 100, 100, 'In Progress', '20/04/2021','20/06/2022', 112, 114);
INSERT INTO orders(order_id_pk, sitting_number, avg_sitting_cost, order_price, already_paid, prepayment, state, start_date, end_date, order_type_id_fk, client_id_fk)
VALUES(117, 5, 175, 555, 500, 100,  'Preview','20/04/2021','20/06/2022', 112, 115);

INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (111, '22/04/2020', 'To do', 1.5, 120, 'SittingNote 1', 111);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (112, '22/04/2020', 'Finished', 5.5, 50, 'SittingNote 2', 111);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (113, '22/04/2020', 'To do', 3, 70, 'SittingNote 3', 112);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (114, '22/04/2020', 'Finished', 6, 600, 'SittingNote 4', 112);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (115, '22/04/2020', 'To do', 8.5, 250, 'SittingNote 5', 112);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (116, '22/04/2020', 'Finished', 10, 75, 'SittingNote 6', 113);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (117, '22/04/2020', 'To do', 3, 80, 'SittingNote 7', 113);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (118, '22/04/2020', 'Finished', 6, 100, 'SittingNote 8', 113);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (119, '22/04/2020', 'To do', 7, 120, 'SittingNote 9', 114);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (120, '22/04/2020', 'Finished', 9, 700, 'SittingNote 10', 114);
INSERT INTO sittings(sitting_id_pk, date_time, state, spent_hours, paid, notes, order_id_fk) VALUES (121, '22/04/2020', 'To do', 8, 300, 'SittingNote 11', 115);

INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES(111, 'Producer 1', 'Yellow');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES(112, 'Producer 2', 'Black');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES(113, 'Producer 3', 'White');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES(114, 'Producer 4', 'Blue');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES(115, 'Producer 5', 'Purpure');

INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES (111, 111, 112);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES (112, 120, 114);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES (113, 114, 113);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES (114, 113, 115);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES (115, 116, 112);

INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES (111, 'Producer 1', '1rl', '5ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES (112, 'Producer 2', '4rl', '10ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES (113, 'Producer 3', '3rl', '15ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES (114, 'Producer 4', '4rl', '16ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES (115, 'Producer 5', '3rl', '23ra');

INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES (111, 113, 111);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES (112, 112, 112);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES (113, 119, 113);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES (114, 111, 114);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES (115, 114, 115);