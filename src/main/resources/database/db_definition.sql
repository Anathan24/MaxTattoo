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
    clientId BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    gender VARCHAR(10),
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
    stateName VARCHAR(15)
);

CREATE TABLE order_types(
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
    FOREIGN KEY(orderTypeId) REFERENCES order_types(orderTypeId),
    FOREIGN key(clientId) REFERENCES clients(clientId)
);

CREATE TABLE sittings(
    sittingId BIGINT PRIMARY KEY,
    sittingDate TIMESTAMP,
    spentHours DOUBLE PRECISION,
    sittingPrice INT,
    sittingNote VARCHAR(250),

    stateId INT,
    orderId INT,
    FOREIGN KEY(stateId) REFERENCES states(stateId),
    FOREIGN KEY(orderId) REFERENCES orders(orderId)
);

CREATE TABLE paints(
    paintId BIGINT PRIMARY KEY,
    paintProducer VARCHAR(25),
    color VARCHAR(25)
);

CREATE TABLE sitting_paints(
    sittingPaintId BIGINT PRIMARY KEY,
    sittingId BIGINT,
    paintId BIGINT,

    FOREIGN KEY(sittingId) REFERENCES sittings(sittingId),
    FOREIGN KEY(paintId) REFERENCES paints(paintId)
);

CREATE TABLE needles(
    needleId BIGINT PRIMARY KEY,
    needleProducer VARCHAR(50),
    needleCode CHAR(10),
    needleSharpening CHAR(10)
);

CREATE TABLE sitting_needles(
    sittingNeedleId INT PRIMARY KEY,
    sittingId BIGINT,
    needleId BIGINT UNIQUE,

    FOREIGN KEY(sittingId) REFERENCES sittings(sittingId),
    FOREIGN KEY(needleId) REFERENCES needles(needleId)
);