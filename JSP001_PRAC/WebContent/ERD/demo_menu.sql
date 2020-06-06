/* Drop Triggers */

DROP TRIGGER TRI_cs_tb_cs_uid;
DROP TRIGGER TRI_inventory_tb_inv_uid;
DROP TRIGGER TRI_member_tb_mem_uid;
DROP TRIGGER TRI_menu_tb_menu_uid;
DROP TRIGGER TRI_orderlist_orderlist_uid;
DROP TRIGGER TRI_order_tb_order_uid;
DROP TRIGGER TRI_sales_tb_sales_uid;
DROP TRIGGER TRI_storeinfo_tb_store_uid;
DROP TRIGGER TRI_subcribe_tb_sub_uid;



/* Drop Tables */

DROP TABLE cs_tb CASCADE CONSTRAINTS;
DROP TABLE order_detail CASCADE CONSTRAINTS;
DROP TABLE menu_tb CASCADE CONSTRAINTS;
DROP TABLE order_tb CASCADE CONSTRAINTS;
DROP TABLE storeinfo_tb CASCADE CONSTRAINTS;
DROP TABLE member_tb CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_cs_tb_cs_uid;
DROP SEQUENCE SEQ_inventory_tb_inv_uid;
DROP SEQUENCE SEQ_mem_uid;
DROP SEQUENCE SEQ_menu_tb_menu_uid;
DROP SEQUENCE SEQ_orderlist_orderlist_uid;
DROP SEQUENCE SEQ_order_tb_order_uid;
DROP SEQUENCE SEQ_sales_tb_sales_uid;
DROP SEQUENCE SEQ_store_uid;




/* Create Sequences */

CREATE SEQUENCE SEQ_cs_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_inv_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_mem_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_menu_tb_menu_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_orderlist_orderlist_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_order_tb_order_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_sales_tb_sales_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_store_uid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE cs_tb
(
	cs_uid number NOT NULL,
	cs_subject varchar2(50) NOT NULL,
	cs_content clob NOT NULL,
	cs_regdate date DEFAULT SYSDATE,
	mem_uid number NOT NULL,
	PRIMARY KEY (cs_uid)
);


CREATE TABLE member_tb
(
	mem_uid number NOT NULL,
	mem_id varchar2(50) NOT NULL,
	mem_pw varchar2(50) NOT NULL,
	mem_name varchar2(50),
	mem_phonenum varchar2(20) NOT NULL,
	mem_email varchar2(50) NOT NULL,
	mem_sub_regdate date,
	mem_sub_period number,
	mem_sub_payment number,
	mem_sub_method varchar2(50),
	PRIMARY KEY (mem_uid)
);

SELECT * FROM MEMBER_TB;
DELETE * FROM MEMBER_TB WHERE mem_uid = 2;

CREATE TABLE storeinfo_tb
(
	store_uid number NOT NULL,
	store_name varchar2(50) NOT NULL,
	store_loca varchar2(300) NOT NULL,
	store_phonenum varchar2(50) NOT NULL,
	mem_uid number NOT NULL,
	PRIMARY KEY (store_uid)
);

SELECT * FROM storeinfo_tb;
DELETE mem_uid FROM MEMBER_TB;


CREATE TABLE menu_tb
(
	menu_uid number NOT NULL,
	menu_name varchar2(50) NOT NULL,
	menu_price number NOT NULL,
	store_uid number NOT NULL,
	PRIMARY KEY (menu_uid)
);
INSERT INTO menu_tb VALUES (SEQ_menu_tb_menu_uid.nextval,'아아',4500,2);
INSERT INTO menu_tb VALUES (SEQ_menu_tb_menu_uid.nextval,'라뗴',5500,2);
INSERT INTO menu_tb VALUES (SEQ_menu_tb_menu_uid.nextval,'쏘쿨',6500,2);
INSERT INTO menu_tb VALUES (SEQ_menu_tb_menu_uid.nextval,'히하히하',7500,2);
SELECT * FROM menu_tb;
SELECT menu_name, menu_price FROM menu_tb;
CREATE TABLE order_detail
(
	orderdetail_uid number NOT NULL,
	orderdetail_price number NOT NULL,
	orderdetail_menuname varchar2(40) NOT NULL,
	orderdetail_quantity number NOT NULL,
	order_uid number NOT NULL,
	menu_uid number NOT NULL,
	PRIMARY KEY (orderdetail_uid)
);


CREATE TABLE order_tb
(
	order_uid number NOT NULL,
	order_regdate date,
	order_totalprice number,
	store_uid number NOT NULL,
	PRIMARY KEY (order_uid)
);



/* Create Foreign Keys */

ALTER TABLE cs_tb
	ADD FOREIGN KEY (mem_uid)
	REFERENCES member_tb (mem_uid)
;


ALTER TABLE storeinfo_tb
	ADD FOREIGN KEY (mem_uid)
	REFERENCES member_tb (mem_uid)
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (menu_uid)
	REFERENCES menu_tb (menu_uid)
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (order_uid)
	REFERENCES order_tb (order_uid)
;


ALTER TABLE menu_tb
	ADD FOREIGN KEY (store_uid)
	REFERENCES storeinfo_tb (store_uid)
;


ALTER TABLE order_tb
	ADD FOREIGN KEY (store_uid)
	REFERENCES storeinfo_tb (store_uid)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_cs_tb_cs_uid BEFORE INSERT ON cs_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_cs_tb_cs_uid.nextval
	INTO :new.cs_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_inventory_tb_inv_uid BEFORE INSERT ON inventory_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_inventory_tb_inv_uid.nextval
	INTO :new.inv_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_member_tb_mem_uid BEFORE INSERT ON member_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_member_tb_mem_uid.nextval
	INTO :new.mem_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_menu_tb_menu_uid BEFORE INSERT ON menu_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_menu_tb_menu_uid.nextval
	INTO :new.menu_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_orderlist_orderlist_uid BEFORE INSERT ON orderlist
FOR EACH ROW
BEGIN
	SELECT SEQ_orderlist_orderlist_uid.nextval
	INTO :new.orderlist_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_order_tb_order_uid BEFORE INSERT ON order_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_order_tb_order_uid.nextval
	INTO :new.order_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_sales_tb_sales_uid BEFORE INSERT ON sales_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_sales_tb_sales_uid.nextval
	INTO :new.sales_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_storeinfo_tb_store_uid BEFORE INSERT ON storeinfo_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_storeinfo_tb_store_uid.nextval
	INTO :new.store_uid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_subcribe_tb_sub_uid BEFORE INSERT ON subcribe_tb
FOR EACH ROW
BEGIN
	SELECT SEQ_subcribe_tb_sub_uid.nextval
	INTO :new.sub_uid
	FROM dual;
END;
