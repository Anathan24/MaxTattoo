DROP TABLE IF EXISTS sittings_paints;
DROP TABLE IF EXISTS sittings_needles;
DROP TABLE IF EXISTS paints;
DROP TABLE IF EXISTS needles;
DROP TABLE IF EXISTS sittings;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS states;
DROP TABLE IF EXISTS orderTypes;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients(
    clientId BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    description VARCHAR(250)
);

CREATE TABLE cities(
    cityId BIGINT PRIMARY KEY,
    cityName VARCHAR(50)
);

CREATE TABLE locations(
    locationId BIGINT PRIMARY KEY,
    name VARCHAR(25),
    cityId INT,
    clientId INT,

    FOREIGN KEY(clientId) REFERENCES clients(clientId),
    FOREIGN KEY(cityId) REFERENCES cities(cityId)
);

CREATE TABLE states(
    stateId BIGINT PRIMARY KEY,
    state VARCHAR(15)
);

CREATE TABLE orderTypes(
    orderTypeId BIGINT PRIMARY KEY,
    type VARCHAR(15)
);

CREATE TABLE orders(
    orderId BIGINT PRIMARY KEY,
    sittingNumber INT default 1,
    orderPrice INT default 0,
    prepayment INT default 0,
    startDate date,
    endDate date,

    stateId INT,
    orderTypeId INT,
    clientId INT,
    FOREIGN KEY(stateId) REFERENCES states(stateId),
    FOREIGN KEY(orderTypeId) REFERENCES orderTypes(orderTypeId),
    FOREIGN key(clientId) REFERENCES clients(clientId)
);

CREATE TABLE sittings(
    sittingId BIGINT PRIMARY KEY,
    sittingDate date NOT NULL,
    spentHours NUMERIC,
    sittingPrice int default 0,
    sittingNote VARCHAR(250),

    stateId INT,
    ordersId INT,
    FOREIGN KEY(stateId) REFERENCES states(stateId),
    FOREIGN KEY(ordersId) REFERENCES orders(orderId)
);

CREATE TABLE paints(
    paintId BIGINT PRIMARY KEY,
    producer VARCHAR(25),
    color VARCHAR(25)
);

CREATE TABLE sittings_paints(
    sittingPaintId BIGINT PRIMARY KEY,
    sittingId INT,
    paintId INT,

    FOREIGN KEY(sittingId) REFERENCES sittings(sittingId),
    FOREIGN KEY(paintId) REFERENCES paints(paintId)
);

CREATE TABLE needles(
    needleId BIGINT PRIMARY KEY,
    producer VARCHAR(50),
    needleCode CHAR(10),
    needleSharpening CHAR(10)
);

CREATE TABLE sittings_needles(
    sittingNeedleId INT PRIMARY KEY,
    sittingId INT,
    needleId INT UNIQUE,

    FOREIGN KEY(sittingId) REFERENCES sittings(sittingId),
    FOREIGN KEY(needleId) REFERENCES needles(needleId)
);