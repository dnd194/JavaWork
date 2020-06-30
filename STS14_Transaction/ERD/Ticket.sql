
/* Drop Tables */

DROP TABLE test_card CASCADE CONSTRAINTS;
DROP TABLE test_ticket CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_card
(
	user_id varchar2(20) NOT NULL,
	buy_amount number default 1
);


CREATE TABLE test_ticket
(
	user_id varchar2(20) NOT NULL,
	ticket_count number NOT NULL,
	CONSTRAINT ticket_buy_limit 
	check(ticket_count BETWEEN 1 AND 5)
);

--ticket 2장을 카드로 결제하는 경우
INSERT INTO TEST_CARD VALUES ('aaa',2);
INSERT INTO test_ticket VALUES ('aaa',2);

SELECT * FROM TEST_CARD ;
SELECT * FROM TEST_TICKET ;

--ticket 5장을 카드로 결제하는 경우
INSERT INTO TEST_CARD VALUES ('aaa',5);
INSERT INTO test_ticket VALUES ('aaa',5);

--ticket 6장을 카드로 결제하는 경우
INSERT INTO TEST_CARD VALUES ('aaa',6);
INSERT INTO test_ticket VALUES ('aaa',6);




