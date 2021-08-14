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

INSERT INTO clients(client_id_pk, name, surname, gender, description, location_id_fk) VALUES (111, 'User Name 1', 'User Surname 1', 'Male', 'Description', 111);
INSERT INTO clients(client_id_pk, name, surname, gender, description, location_id_fk) VALUES (112, 'User Name 2', 'User Surname 2', 'Female', 'Description', 111);
INSERT INTO clients(client_id_pk, name, surname, gender, description, location_id_fk) VALUES (113, 'User Name 3', 'User Surname 3', 'Male', 'Description', 112);
INSERT INTO clients(client_id_pk, name, surname, gender, description, location_id_fk) VALUES (114, 'User Name 4', 'User Surname 4', 'Female', 'Description', 112);
INSERT INTO clients(client_id_pk, name, surname, gender, description, location_id_fk) VALUES (115, 'User Name 5', 'User Surname 5', 'Male', 'Description', 111);

INSERT INTO order_types(order_type_id_pk, type) VALUES(111, 'Tattoo');
INSERT INTO order_types(order_type_id_pk, type) VALUES(112, 'Permanent Makeup');

INSERT INTO orders(order_id_pk, sitting_number, order_price, state, prepayment, start_date, end_date, order_type_id_fk, client_id_fk) VALUES(111, 5, 200, 'Preview', 100, '20/04/2021','20/06/2022', 111, 111);
INSERT INTO orders(order_id_pk, sitting_number, order_price, state, prepayment, start_date, end_date, order_type_id_fk, client_id_fk) VALUES(112, 3, 456, 'To do', 150, '20/04/2021','20/06/2022', 111, 111);
INSERT INTO orders(order_id_pk, sitting_number, order_price, state, prepayment, start_date, end_date, order_type_id_fk, client_id_fk) VALUES(113, 6, 777, 'In Progress', 200, '20/04/2021','20/06/2022', 111, 111);
INSERT INTO orders(order_id_pk, sitting_number, order_price, state, prepayment, start_date, end_date, order_type_id_fk, client_id_fk) VALUES(114, 7, 444, 'Finished', 450, '20/04/2021','20/06/2022', 111, 112);
INSERT INTO orders(order_id_pk, sitting_number, order_price, state, prepayment, start_date, end_date, order_type_id_fk, client_id_fk) VALUES(115, 2, 456, 'To do', 744, '20/04/2021','20/06/2022', 111, 113);
INSERT INTO orders(order_id_pk, sitting_number, order_price, state, prepayment, start_date, end_date, order_type_id_fk, client_id_fk) VALUES(116, 5, 200, 'In Progress', 100, '20/04/2021','20/06/2022', 112, 114);
INSERT INTO orders(order_id_pk, sitting_number, order_price, state, prepayment, start_date, end_date, order_type_id_fk, client_id_fk) VALUES(117, 5, 555, 'Preview', 100, '20/04/2021','20/06/2022', 112, 115);

INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(111, '22/04/2020', 'To do', 1.5, 50, 'SittingNote 1', 120, 111);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(112, '22/04/2020', 'Finished', 5.5, 25, 'SittingNote 2', 10, 111);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(113, '22/04/2020', 'To do', 3, 100, 'SittingNote 3', 50, 112);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(114, '22/04/2020', 'Finished', 6, 10, 'SittingNote 4', 600, 112);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(115, '22/04/2020', 'To do', 8.5, 70, 'SittingNote 5', 233, 112);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(116, '22/04/2020', 'Finished', 10, 45, 'SittingNote 6', 44, 113);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(117, '22/04/2020', 'To do', 3, 65, 'SittingNote 7', 76, 113);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(118, '22/04/2020', 'Finished', 6, 45, 'SittingNote 8', 33, 113);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(119, '22/04/2020', 'To do', 7, 15, 'SittingNote 9', 76, 114);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(120, '22/04/2020', 'Finished', 9, 95, 'SittingNote 10', 70, 114);
INSERT INTO sittings(sitting_id_pk, sitting_date, state, spent_hours, sitting_price, sitting_note, paid, order_id_fk)VALUES(121, '22/04/2020', 'To do', 8, 65, 'SittingNote 11', 67, 115);

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