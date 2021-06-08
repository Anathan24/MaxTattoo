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

CREATE TABLE client(
    clientId INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    specifications VARCHAR(250)
);

CREATE TABLE city(
    cityId INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE location(
    locationId INT PRIMARY KEY,
    clientId INT,
    cityId INT,

    FOREIGN KEY(clientId) REFERENCES client(clientId),
    FOREIGN KEY(cityId) REFERENCES city(cityId)
);

CREATE TABLE state(
    stateId INT PRIMARY KEY,
    state VARCHAR(15)
);

CREATE TABLE orderType(
    orderTypeId INT PRIMARY KEY,
    type VARCHAR(15)
);

CREATE TABLE clientsOrder(
    clientsOrderId INT PRIMARY KEY,
    sittingNumber INT NOT NULL CHECK(sittingNumber > 0),
    orderPrice INT default 0,
    prepayment INT default 0,
    startDate date,
    endDate date,
    orderType VARCHAR(10),

    stateId INT,
    orderTypeId INT,
    clientId INT,
    FOREIGN KEY(stateId) REFERENCES state(stateId),
    FOREIGN KEY(orderTypeId) REFERENCES orderType(orderTypeId),
    FOREIGN key(clientId) REFERENCES client(clientId)
);

CREATE TABLE sitting(
    sittingId int PRIMARY KEY,
    sittingDate date NOT NULL,
    spentHours INT,
    sittingPrice int default 0,
    note VARCHAR(250),

    stateId INT,
    clientsOrderId INT,
    FOREIGN KEY(stateId) REFERENCES state(stateId),
    FOREIGN KEY(clientsOrderId) REFERENCES clientsOrder(clientsOrderId)
);

CREATE TABLE paint(
    paintId INT PRIMARY KEY,
    producer VARCHAR(25),
    color VARCHAR(25)
);

CREATE TABLE sitting_paint(
    sittingPaintId INT PRIMARY KEY,
    sittingId INT,
    paintId INT,

    FOREIGN KEY(sittingId) REFERENCES sitting(sittingId),
    FOREIGN KEY(paintId) REFERENCES paint(paintId)
);

CREATE TABLE needle(
    needleId INT PRIMARY KEY,
    producer VARCHAR(50),
    code CHAR(10),
    needleSharpening CHAR(10)
);

CREATE TABLE sitting_needle(
    sittingNeedleId INT PRIMARY KEY,
    sittingId INT,
    needleId INT UNIQUE,

    FOREIGN KEY(sittingId) REFERENCES sitting(sittingId),
    FOREIGN KEY(needleId) REFERENCES needle(needleId)
);
