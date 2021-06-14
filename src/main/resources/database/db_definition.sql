DROP TABLE IF EXISTS sitting_paint;
DROP TABLE IF EXISTS sitting_needle;
DROP TABLE IF EXISTS paint;
DROP TABLE IF EXISTS needle;
DROP TABLE IF EXISTS sitting;
DROP TABLE IF EXISTS clientsOrder;
DROP TABLE IF EXISTS state;
DROP TABLE IF EXISTS orderType;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS client;

CREATE TABLE clients(
    clientId INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    description VARCHAR(250)
);

CREATE TABLE cities(
    cityId INT PRIMARY KEY,
    cityName VARCHAR(50)
);

CREATE TABLE locations(
    locationId INT PRIMARY KEY,
    name VARCHAR(25),
    cityId INT,
    clientId INT,

    FOREIGN KEY(clientId) REFERENCES clients(clientId),
    FOREIGN KEY(cityId) REFERENCES cities(cityId)
);

CREATE TABLE states(
    stateId INT PRIMARY KEY,
    state VARCHAR(15)
);

CREATE TABLE orderTypes(
    orderTypeId INT PRIMARY KEY,
    orderType VARCHAR(15)
);

CREATE TABLE orders(
    orderId INT PRIMARY KEY,
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
    sittingId int PRIMARY KEY,
    sittingDate date NOT NULL,
    spentHours DOUBLE,
    sittingPrice int default 0,
    sittingNote VARCHAR(250),

    stateId INT,
    ordersId INT,
    FOREIGN KEY(stateId) REFERENCES states(stateId),
    FOREIGN KEY(clientsOrderId) REFERENCES orders(orderId)
);

CREATE TABLE paints(
    paintId INT PRIMARY KEY,
    producer VARCHAR(25),
    color VARCHAR(25)
);

CREATE TABLE sittings_paints(
    sittingPaintId INT PRIMARY KEY,
    sittingId INT,
    paintId INT,

    FOREIGN KEY(sittingId) REFERENCES sittings(sittingId),
    FOREIGN KEY(paintId) REFERENCES paints(paintId)
);

CREATE TABLE needles(
    needleId INT PRIMARY KEY,
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