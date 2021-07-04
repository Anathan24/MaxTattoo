INSERT INTO clients(client_id_pk, name, surname, gender, description) VALUES ('1', 'User Name 1', 'User Surname 1', 'Male', 'Description');
INSERT INTO clients(client_id_pk, name, surname, gender, description) VALUES ('2', 'User Name 2', 'User Surname 2', 'Female', 'Description');
INSERT INTO clients(client_id_pk, name, surname, gender, description) VALUES ('3', 'User Name 3', 'User Surname 3', 'Male', 'Description');
INSERT INTO clients(client_id_pk, name, surname, gender, description) VALUES ('4', 'User Name 4', 'User Surname 4', 'Female', 'Description');
INSERT INTO clients(client_id_pk, name, surname, gender, description) VALUES ('5', 'User Name 5', 'User Surname 5', 'Male', 'Description');

INSERT INTO cities(city_id_pk, city_name) VALUES ('1', 'Varese');
INSERT INTO cities(city_id_pk, city_name) VALUES ('2', 'Milano');
INSERT INTO cities(city_id_pk, city_name) VALUES ('3', 'Gallarate');
INSERT INTO cities(city_id_pk, city_name) VALUES ('4', 'Busto Arsizio');

INSERT INTO locations(location_id_pk, name, city_id_fk, client_id_fk) VALUES('1', 'Location Varese', 1, 1);
INSERT INTO locations(location_id_pk, name, city_id_fk, client_id_fk) VALUES('2', 'Location Varese', 1, 2);
INSERT INTO locations(location_id_pk, name, city_id_fk, client_id_fk) VALUES('3', 'Location Varese', 1, 2);
INSERT INTO locations(location_id_pk, name, city_id_fk, client_id_fk) VALUES('4', 'Location Milano', 2, 5);
INSERT INTO locations(location_id_pk, name, city_id_fk, client_id_fk) VALUES('5', 'Location Milano', 2, 5);

INSERT INTO states(state_id_pk, state_name) VALUES('1', 'Preview');
INSERT INTO states(state_id_pk, state_name) VALUES('2', 'TO DO');
INSERT INTO states(state_id_pk, state_name) VALUES('3', 'In Progress');
INSERT INTO states(state_id_pk, state_name) VALUES('4', 'Finished');

INSERT INTO order_types(order_type_id_pk, type) VALUES(1, 'Tattoo');
INSERT INTO order_types(order_type_id_pk, type) VALUES(2, 'Permanent Makeup');

INSERT INTO orders(order_id_pk, sitting_number, order_price, prepayment, start_date, end_date, state_id_fk, order_type_id_fk) VALUES('1', 5, 200, 100, '20/04/2021','20/06/2022', 1, 1);
INSERT INTO orders(order_id_pk, sitting_number, order_price, prepayment, start_date, end_date, state_id_fk, order_type_id_fk) VALUES('2', 3, 456, 150, '20/04/2021','20/06/2022', 2, 1);
INSERT INTO orders(order_id_pk, sitting_number, order_price, prepayment, start_date, end_date, state_id_fk, order_type_id_fk) VALUES('3', 6, 777, 200, '20/04/2021','20/06/2022', 3, 1);
INSERT INTO orders(order_id_pk, sitting_number, order_price, prepayment, start_date, end_date, state_id_fk, order_type_id_fk) VALUES('4', 7, 444, 450, '20/04/2021','20/06/2022', 2, 1);
INSERT INTO orders(order_id_pk, sitting_number, order_price, prepayment, start_date, end_date, state_id_fk, order_type_id_fk) VALUES('5', 2, 456, 744, '20/04/2021','20/06/2022', 3, 1);
INSERT INTO orders(order_id_pk, sitting_number, order_price, prepayment, start_date, end_date, state_id_fk, order_type_id_fk) VALUES('6', 5, 200, 100, '20/04/2021','20/06/2022', 1, 1);
INSERT INTO orders(order_id_pk, sitting_number, order_price, prepayment, start_date, end_date, state_id_fk, order_type_id_fk) VALUES('7', 5, 200, 100, '20/04/2021','20/06/2022', 1, 1);

INSERT INTO clients_orders(client_order_id_pk, client_id_fk, order_id_fk) VALUES('1', '1', '1');
INSERT INTO clients_orders(client_order_id_pk, client_id_fk, order_id_fk) VALUES('2', '1', '2');
INSERT INTO clients_orders(client_order_id_pk, client_id_fk, order_id_fk) VALUES('3', '1', '3');
INSERT INTO clients_orders(client_order_id_pk, client_id_fk, order_id_fk) VALUES('4', '2', '4');
INSERT INTO clients_orders(client_order_id_pk, client_id_fk, order_id_fk) VALUES('5', '3', '5');
INSERT INTO clients_orders(client_order_id_pk, client_id_fk, order_id_fk) VALUES('6', '4', '6');
INSERT INTO clients_orders(client_order_id_pk, client_id_fk, order_id_fk) VALUES('7', '5', '7');

INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('1', '22/04/2020', 1.5, 50, 'SittingNote 1', 0, 4, 1);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('2', '22/04/2020', 5.5, 25, 'SittingNote 2', 0, 4, 1);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('3', '22/04/2020', 3, 100, 'SittingNote 3', 0, 4, 2);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('4', '22/04/2020', 6, 10, 'SittingNote 4', 0, 4, 2);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('5', '22/04/2020', 8.5, 70, 'SittingNote 5', 0, 4, 2);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('6', '22/04/2020', 10, 45, 'SittingNote 6', 0, 4, 3);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('7', '22/04/2020', 3, 65, 'SittingNote 7', 0, 4, 3);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('8', '22/04/2020', 6, 45, 'SittingNote 8', 0, 4, 3);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('9', '22/04/2020', 7, 15, 'SittingNote 9', 0, 4, 4);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('10', '22/04/2020', 9, 95, 'SittingNote 10', 0, 4, 4);
INSERT INTO sittings(sitting_id_pk, sitting_date, spent_hours, sitting_price, sitting_note, paid, state_id_fk, order_id_fk)VALUES('11', '22/04/2020', 8, 65, 'SittingNote 11', 0, 4, 5);

INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES('1', 'Producer 1', 'Yellow');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES('2', 'Producer 2', 'Black');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES('3', 'Producer 3', 'White');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES('4', 'Producer 4', 'Blue');
INSERT INTO paints(paint_id_pk, paint_producer, color) VALUES('5', 'Producer 5', 'Purpure');

INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES ('1', 1, 2);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES ('2', 10, 4);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES ('3', 4, 3);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES ('4', 3, 5);
INSERT INTO sittings_paints(sitting_paint_id_pk, sitting_id_fk, paint_id_fk) VALUES ('5', 6, 2);

INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES ('1', 'Producer 1', '1rl', '5ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES ('2', 'Producer 2', '4rl', '10ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES ('3', 'Producer 3', '3rl', '15ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES ('4', 'Producer 4', '4rl', '16ra');
INSERT INTO needles(needle_id_pk, needle_producer, needle_code, needle_sharpening) VALUES ('5', 'Producer 5', '3rl', '23ra');

INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES ('1', 3, 1);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES ('2', 2, 2);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES ('3', 9, 3);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES ('4', 1, 4);
INSERT INTO sittings_needles(sitting_needle_id_pk, sitting_id_fk, needle_id_fk) VALUES ('5', 4, 5);