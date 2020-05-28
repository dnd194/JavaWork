
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE test_member
(
	mb_no number,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate date
);

-- 시퀀스 추가
DROP SEQUENCE test_member_seq; --혹시나 있던 걸 지움
CREATE SEQUENCE test_member_seq;

DELETE FROM TEST_MEMBER ;

SELECT * FROM TEST_MEMBER ORDER BY MB_NO DESC ;






/* Drop Tables */

DROP TABLE inventory_tb CASCADE CONSTRAINTS;
DROP TABLE sales_tb CASCADE CONSTRAINTS;
DROP TABLE order_tb CASCADE CONSTRAINTS;
DROP TABLE menu_tb CASCADE CONSTRAINTS;
DROP TABLE storeinfo_tb CASCADE CONSTRAINTS;
DROP TABLE member_tb CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_inventory_tb_inv_uid;
DROP SEQUENCE SEQ_member_tb_mem_uid;
DROP SEQUENCE SEQ_menu_tb_menu_uid;
DROP SEQUENCE SEQ_order_tb_order_uid;
DROP SEQUENCE SEQ_sales_tb_sales_uid;
DROP SEQUENCE SEQ_storeinfo_tb_store_uid;




/* Create Sequences */

CREATE SEQUENCE SEQ_inventory_tb_inv_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_member_tb_mem_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_menu_tb_menu_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_order_tb_order_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_sales_tb_sales_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_storeinfo_tb_store_uid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE inventory_tb
(
   inv_uid number NOT NULL,
   inv_cakename varchar2(50) NOT NULL,
   inv_cost number NOT NULL,
   inv_quantity number NOT NULL,
   store_uid number NOT NULL,
   PRIMARY KEY (inv_uid)
);


CREATE TABLE member_tb
(
   mem_uid number NOT NULL,
   mem_id varchar2(50) NOT NULL,
   mem_pw varchar2(50) NOT NULL,
   mem_name varchar2(50) NOT NULL,
   mem_email varchar2(50) NOT NULL,
   PRIMARY KEY (mem_uid)
);


CREATE TABLE menu_tb
(
   menu_uid number NOT NULL,
   menu_name varchar2(50) NOT NULL,
   menu_price number NOT NULL,
   menu_regdate date NOT NULL DEFAULT SYSDATE,
   store_uid number NOT NULL,
   PRIMARY KEY (menu_uid)
);


CREATE TABLE order_tb
(
   order_uid number NOT NULL,
   order_name varchar2(50) NOT NULL,
   order_regdate date NOT NULL DEFAULT SYSDATE,
   menu_uid number NOT NULL,
   PRIMARY KEY (order_uid)
);


CREATE TABLE sales_tb
(
   sales_uid number NOT NULL,
   store_uid number NOT NULL,
   order_uid number NOT NULL,
   sales_profit number,
   PRIMARY KEY (sales_uid)
);


CREATE TABLE storeinfo_tb
(
   store_uid number NOT NULL,
   store_name varchar2(50) NOT NULL,
   store_loca varchar2(100) NOT NULL,
   store_phonenum number NOT NULL,
   mem_uid number NOT NULL,
   PRIMARY KEY (store_uid)
);



/* Create Foreign Keys */

ALTER TABLE storeinfo_tb
   ADD FOREIGN KEY (mem_uid)
   REFERENCES member_tb (mem_uid)
;


ALTER TABLE order_tb
   ADD FOREIGN KEY (menu_uid)
   REFERENCES menu_tb (menu_uid)
;


ALTER TABLE sales_tb
   ADD FOREIGN KEY (order_uid)
   REFERENCES order_tb (order_uid)
;


ALTER TABLE inventory_tb
   ADD FOREIGN KEY (store_uid)
   REFERENCES storeinfo_tb (store_uid)
;


ALTER TABLE menu_tb
   ADD FOREIGN KEY (store_uid)
   REFERENCES storeinfo_tb (store_uid)
;


ALTER TABLE sales_tb
   ADD FOREIGN KEY (store_uid)
   REFERENCES storeinfo_tb (store_uid)
;



/* Create Triggers */

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

SELECT * FROM STOREINFO_TB ;
SELECT * FROM MEMBER_TB ;
INSERT INTO MEMBER_TB VALUES(SEQ_member_tb_mem_uid.NEXTVAL,'DDD','123','쑤영','DND194@DN.COM' );
INSERT INTO storeinfo_tb VALUES (SEQ_storeinfo_tb_store_uid.NEXTVAL, '수영', '서울', 0101, SEQ_storeinfo_tb_store_uid.NEXTVAL);
/* 여기다가 변수이름 넣어주면 될듯*/

