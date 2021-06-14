INSERT INTO clients(clientId, name, surname, gender, description) VALUES (1, 'User Name 1', 'User Surname 1', 'Male', 'Description');
INSERT INTO clients(clientId, name, surname, gender, description) VALUES (2, 'User Name 2', 'User Surname 2', 'Female', 'Description');
INSERT INTO clients(clientId, name, surname, gender, description) VALUES (3, 'User Name 3', 'User Surname 3', 'Male', 'Description');
INSERT INTO clients(clientId, name, surname, gender, description) VALUES (4, 'User Name 4', 'User Surname 4', 'Female', 'Description');
INSERT INTO clients(clientId, name, surname, gender, description) VALUES (5, 'User Name 5', 'User Surname 5', 'Male', 'Description');

INSERT INTO cities(cityId, cityName) VALUES (1, 'Varese');
INSERT INTO cities(cityId, cityName) VALUES (2, 'Milano');
INSERT INTO cities(cityId, cityName) VALUES (3, 'Gallarate');
INSERT INTO cities(cityId, cityName) VALUES (4, 'Busto Arsizio');

INSERT INTO locations(locationId, name, cityId, clientId) VALUES(1, 'Location Varese', 1, 1);
INSERT INTO locations(locationId, name, cityId, clientId) VALUES(2, 'Location Varese', 1, 2);
INSERT INTO locations(locationId, name, cityId, clientId) VALUES(3, 'Location Varese', 1, 2);
INSERT INTO locations(locationId, name, cityId, clientId) VALUES(4, 'Location Milano', 2, 5);
INSERT INTO locations(locationId, name, cityId, clientId) VALUES(5, 'Location Milano', 2, 5);

INSERT INTO states(stateId, state) VALUES(1, 'Preview');
INSERT INTO states(stateId, state) VALUES(2, 'TO DO');
INSERT INTO states(stateId, state) VALUES(3, 'In Progress');
INSERT INTO states(stateId, state) VALUES(4, 'Finished');

INSERT INTO orderTypes(orderTypeId, orderType) VALUES(1, 'Tattoo');

INSERT INTO orders(orderId, sittingNumber, orderPrice, prepayment, startDate, endDate, stateId, orderTypeId, clientId) VALUES(1, 200, 50, '20/04/2021','20/06/2022', 1, 1, 1);
INSERT INTO orders(orderId, sittingNumber, orderPrice, prepayment, startDate, endDate, stateId, orderTypeId, clientId) VALUES(2, 200, 50, '20/04/2021','20/06/2022', 2, 1, 2);
INSERT INTO orders(orderId, sittingNumber, orderPrice, prepayment, startDate, endDate, stateId, orderTypeId, clientId) VALUES(3, 200, 50, '20/04/2021','20/06/2022', 3, 1, 3);
INSERT INTO orders(orderId, sittingNumber, orderPrice, prepayment, startDate, endDate, stateId, orderTypeId, clientId) VALUES(4, 200, 50, '20/04/2021','20/06/2022', 2, 1, 4);
INSERT INTO orders(orderId, sittingNumber, orderPrice, prepayment, startDate, endDate, stateId, orderTypeId, clientId) VALUES(5, 200, 50, '20/04/2021','20/06/2022', 3, 1, 5);

INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(1, '22/04/2020', 1, 50, 'SittingNote 1', 4, 1);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(2, '22/04/2020', 5, 25, 'SittingNote 2', 4, 1);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(3, '22/04/2020', 3, 100, 'SittingNote 3', 4, 2);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(4, '22/04/2020', 6, 10, 'SittingNote 4', 4, 2);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(5, '22/04/2020', 8, 70, 'SittingNote 5', 4, 2);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(6, '22/04/2020', 10, 45, 'SittingNote 6', 4, 3);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(7, '22/04/2020', 3, 65, 'SittingNote 7', 4, 3);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(8, '22/04/2020', 6, 45, 'SittingNote 8', 4, 3);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(9, '22/04/2020', 7, 15, 'SittingNote 9', 4, 4);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(10, '22/04/2020', 9, 95, 'SittingNote 10', 4, 4);
INSERT INTO sittings(sittingId, sittingDate, spentHours, sittingPrice, sittingNote, stateId, ordersId)VALUES(11, '22/04/2020', 8, 65, 'SittingNote 11', 4, 5);

INSERT INTO paints(paintId, producer, color) VALUES(1, 'Producer 1', 'Yellow');
INSERT INTO paints(paintId, producer, color) VALUES(2, 'Producer 2', 'Black');
INSERT INTO paints(paintId, producer, color) VALUES(3, 'Producer 3', 'White');
INSERT INTO paints(paintId, producer, color) VALUES(4, 'Producer 4', 'Blue');
INSERT INTO paints(paintId, producer, color) VALUES(5, 'Producer 5', 'Purpure');

INSERT INTO sittings_paints(sittingPaintId, sittingId, paintId) VALUES (1, 1, 2);
INSERT INTO sittings_paints(sittingPaintId, sittingId, paintId) VALUES (2, 10, 4);
INSERT INTO sittings_paints(sittingPaintId, sittingId, paintId) VALUES (3, 4, 3);
INSERT INTO sittings_paints(sittingPaintId, sittingId, paintId) VALUES (4, 3, 5);
INSERT INTO sittings_paints(sittingPaintId, sittingId, paintId) VALUES (5, 6, 2);

INSERT INTO needles(needleId, producer, needleCode, needleSharpening) VALUES (1, 'Producer 1', '1rl', '5ra');
INSERT INTO needles(needleId, producer, needleCode, needleSharpening) VALUES (2, 'Producer 2', '4rl', '10ra');
INSERT INTO needles(needleId, producer, needleCode, needleSharpening) VALUES (3, 'Producer 3', '3rl', '15ra');

INSERT INTO sittings_needles(sittingNeedleId, sittingId, needleId) VALUES (1, 3, 1);
INSERT INTO sittings_needles(sittingNeedleId, sittingId, needleId) VALUES (2, 2, 2);
INSERT INTO sittings_needles(sittingNeedleId, sittingId, needleId) VALUES (3, 9, 2);
INSERT INTO sittings_needles(sittingNeedleId, sittingId, needleId) VALUES (4, 1, 3);
INSERT INTO sittings_needles(sittingNeedleId, sittingId, needleId) VALUES (5, 4, 1);
INSERT INTO sittings_needles(sittingNeedleId, sittingId, needleId) VALUES (6, 5, 1);