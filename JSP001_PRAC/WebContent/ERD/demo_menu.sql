
/* Drop Tables */

DROP TABLE demo_menu_table CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE demo_menu_table
(
	menu_uid number NOT NULL,
	menu_name varchar2(30) NOT NULL,
	menu_price number NOT NULL,
	PRIMARY KEY (menu_uid)
);

CREATE SEQUENCE uid_seq;

SELECT * FROM demo_menu_table;
