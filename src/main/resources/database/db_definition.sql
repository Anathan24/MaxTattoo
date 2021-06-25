DROP TABLE IF EXISTS sitting_paints;
DROP TABLE IF EXISTS sitting_needles;
DROP TABLE IF EXISTS paints;
DROP TABLE IF EXISTS needles;
DROP TABLE IF EXISTS sittings;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS states;
DROP TABLE IF EXISTS order_types;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients(
    client_id_fk BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    gender VARCHAR(10),
    description VARCHAR(250)
);

CREATE TABLE cities(
    city_id_pk BIGINT PRIMARY KEY,
    city_name VARCHAR(50)
);

CREATE TABLE locations(
    location_id_pk BIGINT PRIMARY KEY,
    name VARCHAR(25),
    city_id_fk INT,
    client_id_fk INT,

    FOREIGN KEY(client_id_fk) REFERENCES clients(client_id_fk),
    FOREIGN KEY(city_id_fk) REFERENCES cities(city_id_pk)
);

CREATE TABLE states(
    state_id_pk BIGINT PRIMARY KEY,
    state_name VARCHAR(15)
);

CREATE TABLE order_types(
    order_type_id_pk BIGINT PRIMARY KEY,
    type VARCHAR(15)
);

CREATE TABLE orders(
    order_id_pk BIGINT PRIMARY KEY,
    sitting_number INT default 1,
    order_price INT default 0,
    prepayment INT default 0,
    start_date date,
    end_date date,

    state_id_fk INT,
    order_type_id_fk INT,
    client_id_fk INT,
    FOREIGN KEY(state_id_fk) REFERENCES states(state_id_pk),
    FOREIGN KEY(order_type_id_fk) REFERENCES order_types(order_type_id_pk),
    FOREIGN key(client_id_fk) REFERENCES clients(client_id_fk)
);

CREATE TABLE sittings(
    sitting_id_pk BIGINT PRIMARY KEY,
    sitting_date TIMESTAMP,
    spent_hours DOUBLE PRECISION,
    sitting_price INT,
    sitting_note VARCHAR(250),

    state_id_fk INT,
    order_id_fk INT,
    FOREIGN KEY(state_id_fk) REFERENCES states(state_id_pk),
    FOREIGN KEY(order_id_fk) REFERENCES orders(order_id_pk)
);

CREATE TABLE paints(
    paint_id_pk BIGINT PRIMARY KEY,
    paint_producer VARCHAR(25),
    color VARCHAR(25)
);

CREATE TABLE sitting_paints(
    sitting_paint_id_pk BIGINT PRIMARY KEY,
    sitting_id_fk BIGINT,
    paint_id_fk BIGINT,

    FOREIGN KEY(sitting_id_fk) REFERENCES sittings(sitting_id_pk),
    FOREIGN KEY(paint_id_fk) REFERENCES paints(paint_id_pk)
);

CREATE TABLE needles(
    needle_id_pk BIGINT PRIMARY KEY,
    needle_producer VARCHAR(50),
    needle_code CHAR(10),
    needle_sharpening CHAR(10)
);

CREATE TABLE sitting_needles(
    sitting_needle_id_pk INT PRIMARY KEY,
    sitting_id_fk BIGINT,
    needle_id_fk BIGINT UNIQUE,

    FOREIGN KEY(sitting_id_fk) REFERENCES sittings(sitting_id_pk),
    FOREIGN KEY(needle_id_fk) REFERENCES needles(needle_id_pk)
);