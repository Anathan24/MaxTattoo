CREATE OR REPLACE VIEW ClientView AS
	SELECT c.clientId, c.name, c.surname, c.gender, c.description
	FROM clients c
	WHERE c.name = 'User Name 1' AND c.surname='User Surname 1';

CREATE OR REPLACE VIEW OrderView AS
	SELECT o.orderId, o.sittingNumber, o.orderPrice, o.prepayment, o.startDate, o.endDate, s.stateName, ot.type
	FROM orders o INNER JOIN states s ON o.stateId = s.stateId INNER JOIN order_types ot ON o.orderTypeId = ot.orderTypeId
	WHERE o.clientId = 1;

CREATE OR REPLACE VIEW SittingView AS
	SELECT s.sittingId, s.sittingDate, s.spentHours, s.sittingPrice, s.sittingNote,
	pn.paintId, pn.paintProducer, pn.color, nd.needleId, nd.needleProducer, nd.needleCode, nd.needleSharpening

	FROM Sittings s INNER JOIN Sitting_Paints sp ON s.sittingId=sp.sittingId INNER JOIN Paints pn ON sp.paintId = pn.paintId
					INNER JOIN Sitting_Needles sd ON s.sittingId=sd.sittingId INNER JOIN Needles nd ON sd.needleId = nd.needleId
	WHERE s.orderId = 1;