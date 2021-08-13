DROP TABLE IF EXISTS sittings_paints;
DROP TABLE IF EXISTS sittings_needles;
DROP TABLE IF EXISTS locations_cities;
DROP TABLE IF EXISTS paints;
DROP TABLE IF EXISTS needles;
DROP TABLE IF EXISTS sittings;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS states;
DROP TABLE IF EXISTS order_types;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS locations;

CREATE TABLE locations(
    location_id_pk BIGSERIAL PRIMARY KEY,
    location_name VARCHAR
);

CREATE TABLE cities(
    city_id_pk BIGSERIAL PRIMARY KEY,
    city_name VARCHAR
);

CREATE TABLE locations_cities(
    locations_cities_id_pk BIGSERIAL PRIMARY KEY,
    location_id_fk BIGINT,
    city_id_fk BIGINT,

    FOREIGN KEY (location_id_fk) REFERENCES locations(location_id_pk),
    FOREIGN KEY (city_id_fk) REFERENCES cities(city_id_pk)
);

CREATE TABLE clients(
    client_id_pk BIGSERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    gender VARCHAR,
    description VARCHAR,
    location_id_fk BIGINT,

    FOREIGN KEY(location_id_fk) REFERENCES locations(location_id_pk)
);

CREATE TABLE states(
    state_id_pk BIGSERIAL PRIMARY KEY,
    state_name VARCHAR
);

CREATE TABLE order_types(
    order_type_id_pk BIGSERIAL PRIMARY KEY,
    type VARCHAR
);

CREATE TABLE orders(
    order_id_pk BIGSERIAL PRIMARY KEY,
    sitting_number NUMERIC,
    order_price NUMERIC,
    prepayment NUMERIC,
    start_date date,
    end_date date,

    state_id_fk BIGINT,
    order_type_id_fk BIGINT,
    client_id_fk BIGINT,
    FOREIGN KEY(state_id_fk) REFERENCES states(state_id_pk),
    FOREIGN KEY(order_type_id_fk) REFERENCES order_types(order_type_id_pk),
    FOREIGN KEY(client_id_fk) REFERENCES clients(client_id_pk)
);

CREATE TABLE sittings(
    sitting_id_pk BIGSERIAL PRIMARY KEY,
    sitting_date TIMESTAMP,
    spent_hours DOUBLE PRECISION,
    sitting_price NUMERIC,
    sitting_note VARCHAR,
    paid NUMERIC,

    state_id_fk BIGINT,
    order_id_fk BIGINT,
    FOREIGN KEY(state_id_fk) REFERENCES states(state_id_pk),
    FOREIGN KEY(order_id_fk) REFERENCES orders(order_id_pk)
);

CREATE TABLE paints(
    paint_id_pk BIGSERIAL PRIMARY KEY,
    paint_producer VARCHAR,
    color VARCHAR
);

CREATE TABLE needles(
    needle_id_pk BIGSERIAL PRIMARY KEY,
    needle_producer VARCHAR,
    needle_code VARCHAR,
    needle_sharpening VARCHAR
);

CREATE TABLE sittings_paints(
    sitting_paint_id_pk BIGSERIAL PRIMARY KEY,
    sitting_id_fk BIGINT,
    paint_id_fk BIGINT,

    FOREIGN KEY(sitting_id_fk) REFERENCES sittings(sitting_id_pk),
    FOREIGN KEY(paint_id_fk) REFERENCES paints(paint_id_pk)
);

CREATE TABLE sittings_needles(
    sitting_needle_id_pk BIGSERIAL PRIMARY KEY,
    sitting_id_fk BIGINT,
    needle_id_fk BIGINT,

    FOREIGN KEY(sitting_id_fk) REFERENCES sittings(sitting_id_pk),
    FOREIGN KEY(needle_id_fk) REFERENCES needles(needle_id_pk)
);