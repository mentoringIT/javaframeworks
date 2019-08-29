create database bookstore;
use bookstore;

CREATE TABLE address

(

   ADDRESS_ID int PRIMARY KEY NOT NULL,

   STREET varchar(255) NOT NULL,

   ZIPCODE varchar(16) NOT NULL,

   CITY varchar(255) NOT NULL,

   USERNAME varchar(50) NOT NULL

)

;

CREATE TABLE author

(

   AUTHOR_ID int PRIMARY KEY NOT NULL,

   AUTHOR_NAME varchar(255) NOT NULL

)

;

CREATE TABLE author_book

(

   AUTHOR_ID int NOT NULL,

   BOOK_ID int NOT NULL,

   CONSTRAINT PRIMARY PRIMARY KEY (AUTHOR_ID,BOOK_ID)

)

;

CREATE TABLE authorities

(

   USERNAME varchar(50) PRIMARY KEY NOT NULL,

   AUTHORITY varchar(50) NOT NULL

)

;

CREATE TABLE book

(

   BOOK_ID int PRIMARY KEY NOT NULL,

   TITLE varchar(255) NOT NULL,

   DESCRIPTION text,

   LIST_PRICE real DEFAULT 0 NOT NULL,

   LIST_PRICE_CURRENCY varchar(3) NOT NULL,

   PAPERBACK real,

   PUBLISHER varchar(255),

   LANGUAGE varchar(50),

   ISBN10_integer varchar(10),

   ISBN13_integer varchar(14),

   CATEGORY_ID int NOT NULL

)

;

CREATE TABLE book_image

(

   BOOK_IMAGE_ID int PRIMARY KEY NOT NULL,

   BOOK_ID int NOT NULL,

   FILENAME varchar(255) NOT NULL

)

;

CREATE TABLE category

(

   CATEGORY_ID int PRIMARY KEY NOT NULL,

   CATEGORY_NAME varchar(255) NOT NULL

)

;

CREATE TABLE inventory

(

   BOOK_ID int PRIMARY KEY NOT NULL,

   BOOK_QUANTITY int DEFAULT 0 NOT NULL

)

;

CREATE TABLE line_item

(

   LINE_ITEM_ID int PRIMARY KEY NOT NULL,

   QUANTITY int NOT NULL,

   UNIT_PRICE int NOT NULL,

   BOOK_ID int NOT NULL,

   PURCHASE_ORDER_ID int NOT NULL

)

;

CREATE TABLE purchase_order

(

   PURCHASE_ORDER_ID int PRIMARY KEY NOT NULL,

   ORDER_DATE date NOT NULL,

   TOTAL_PRICE int NOT NULL,

   USERNAME varchar(50) NOT NULL,

   SHIP_TO_ADDRESS_ID int NOT NULL,

   BILL_TO_ADDRESS_ID int NOT NULL

)

;

CREATE TABLE users

(

   USERNAME varchar(50) PRIMARY KEY NOT NULL,

   PASSWORD varchar(50) NOT NULL,

   ENABLED int NOT NULL,

   FULL_NAME varchar(255) NOT NULL,

   EMAIL varchar(255) NOT NULL,

   CREATED timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,

   DAY_OF_BIRTH date NOT NULL,

   GENDER varchar(255) NOT NULL

)

;

ALTER TABLE address

ADD CONSTRAINT FKADDRESS158933

FOREIGN KEY (USERNAME)

REFERENCES users(USERNAME)

;

CREATE INDEX FKADDRESS158933 ON address(USERNAME)

;

CREATE UNIQUE INDEX PRIMARY ON address(ADDRESS_ID)

;

CREATE UNIQUE INDEX PRIMARY ON author(AUTHOR_ID)

;

ALTER TABLE author_book

ADD CONSTRAINT FKAUTHOR_BOO613711

FOREIGN KEY (BOOK_ID)

REFERENCES book(BOOK_ID)

;

ALTER TABLE author_book

ADD CONSTRAINT FKAUTHOR_BOO675362

FOREIGN KEY (AUTHOR_ID)

REFERENCES author(AUTHOR_ID)

;

CREATE INDEX FKAUTHOR_BOO613711 ON author_book(BOOK_ID)

;

CREATE UNIQUE INDEX PRIMARY ON author_book

(

  AUTHOR_ID,

  BOOK_ID

)

;

ALTER TABLE authorities

ADD CONSTRAINT FKAUTHORITIE730779

FOREIGN KEY (USERNAME)

REFERENCES users(USERNAME)

;

CREATE UNIQUE INDEX PRIMARY ON authorities(USERNAME)

;

CREATE UNIQUE INDEX AUTHORITIES_AUTHORITY ON authorities(AUTHORITY)

;

ALTER TABLE book

ADD CONSTRAINT FKBOOK207446

FOREIGN KEY (CATEGORY_ID)

REFERENCES category(CATEGORY_ID)

;

CREATE UNIQUE INDEX PRIMARY ON book(BOOK_ID)

;

CREATE INDEX FKBOOK207446 ON book(CATEGORY_ID)

;

ALTER TABLE book_image

ADD CONSTRAINT FKBOOK_IMAGE361735

FOREIGN KEY (BOOK_ID)

REFERENCES book(BOOK_ID)

;

CREATE UNIQUE INDEX PRIMARY ON book_image(BOOK_IMAGE_ID)

;

CREATE INDEX FKBOOK_IMAGE361735 ON book_image(BOOK_ID)

;

CREATE UNIQUE INDEX PRIMARY ON category(CATEGORY_ID)

;

ALTER TABLE inventory

ADD CONSTRAINT FKINVENTORY549602

FOREIGN KEY (BOOK_ID)

REFERENCES book(BOOK_ID)

;

CREATE UNIQUE INDEX PRIMARY ON inventory(BOOK_ID)

;

ALTER TABLE line_item

ADD CONSTRAINT FKLINE_ITEM780834

FOREIGN KEY (BOOK_ID)

REFERENCES book(BOOK_ID)

;

ALTER TABLE line_item

ADD CONSTRAINT FKLINE_ITEM143555

FOREIGN KEY (PURCHASE_ORDER_ID)

REFERENCES purchase_order(PURCHASE_ORDER_ID)

;

CREATE UNIQUE INDEX PRIMARY ON line_item(LINE_ITEM_ID)

;

CREATE INDEX FKLINE_ITEM143555 ON line_item(PURCHASE_ORDER_ID)

;

CREATE INDEX FKLINE_ITEM780834 ON line_item(BOOK_ID)

;

ALTER TABLE purchase_order

ADD CONSTRAINT FKPURCHASE_O393279

FOREIGN KEY (SHIP_TO_ADDRESS_ID)

REFERENCES address(ADDRESS_ID)

;

ALTER TABLE purchase_order

ADD CONSTRAINT FKPURCHASE_O780820

FOREIGN KEY (BILL_TO_ADDRESS_ID)

REFERENCES address(ADDRESS_ID)

;

ALTER TABLE purchase_order

ADD CONSTRAINT FKPURCHASE_O950752

FOREIGN KEY (USERNAME)

REFERENCES users(USERNAME)

;

CREATE INDEX FKPURCHASE_O950752 ON purchase_order(USERNAME)

;

CREATE INDEX FKPURCHASE_O780820 ON purchase_order(BILL_TO_ADDRESS_ID)

;

CREATE UNIQUE INDEX PRIMARY ON purchase_order(PURCHASE_ORDER_ID)

;

CREATE INDEX FKPURCHASE_O393279 ON purchase_order(SHIP_TO_ADDRESS_ID)

;

CREATE UNIQUE INDEX PRIMARY ON users(USERNAME)

;








INSERT INTO users (USERNAME,PASSWORD,ENABLED,FULL_NAME,EMAIL,CREATED,DAY_OF_BIRTH,GENDER) VALUES ('jignacios','Zaq12wsx',1,'Jorge Ignacio Jacinto Sosa','jorge.jaso.0703@gmail.com', '2018-02-08 19:49:50.','2018-02-08','M');
INSERT INTO users (USERNAME,PASSWORD,ENABLED,FULL_NAME,EMAIL,CREATED,DAY_OF_BIRTH,GENDER) VALUES ('mangelg','Zaq12wsx',1,'Miguel Angel Garcia','mangelg@gmail.com', '2017-12-04 21:55:06.','2017-12-04','M');

SELECT * FROM users

INSERT INTO address (ADDRESS_ID,STREET,ZIPCODE,CITY,USERNAME) VALUES (1,'2da Cda de Teatlalco','56490','Estado de México','mangelg');

INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (1,'Joshua Bloch');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (2,'Gary Mak');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (3,'Anton Szandor Lavey');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (4,'Jan Machacek');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (5,'Jessica Ditt');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (6,'Aleksa Vukotic');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (7,'Anirvan Chakraborty');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (8,'Dave Minter');
INSERT INTO author (AUTHOR_ID,AUTHOR_NAME) VALUES (9,'Jeff Linwood');


INSERT INTO category (CATEGORY_ID,CATEGORY_NAME) VALUES (1,'Fiction');
INSERT INTO category (CATEGORY_ID,CATEGORY_NAME) VALUES (2,'Religion');


INSERT INTO book (BOOK_ID,TITLE,DESCRIPTION,LIST_PRICE,LIST_PRICE_CURRENCY,PAPERBACK,PUBLISHER,LANGUAGE,ISBN10_integer,ISBN13_integer,CATEGORY_ID) VALUES (1,'Java Effective Guide','Are you looking for a deeper understanding of the Java programming language so that you can write code that is clearer, more correct, more robust, and more reusable? Look no further! Effective Java, Second Edition',40.0,'USD',272.0,'Addison-Wesley; First Printing edition (June 15, 2001)','English','0201310058','978-0201310054',1);
INSERT INTO book (BOOK_ID,TITLE,DESCRIPTION,LIST_PRICE,LIST_PRICE_CURRENCY,PAPERBACK,PUBLISHER,LANGUAGE,ISBN10_integer,ISBN13_integer,CATEGORY_ID) VALUES (2,'Java from scratch','Make more',7.99,'USD',272.0,'Avon (December 1, 1976)','English','0380015390','978-0380015399',2);
INSERT INTO book (BOOK_ID,TITLE,DESCRIPTION,LIST_PRICE,LIST_PRICE_CURRENCY,PAPERBACK,PUBLISHER,LANGUAGE,ISBN10_integer,ISBN13_integer,CATEGORY_ID) VALUES (3,'Pro Spring 3','Discover what is new and available in Spring 3',31.49,'USD',999.0,'Apress (December 9, 2009)','English','1430218452','978-1430218456',1);
INSERT INTO book (BOOK_ID,TITLE,DESCRIPTION,LIST_PRICE,LIST_PRICE_CURRENCY,PAPERBACK,PUBLISHER,LANGUAGE,ISBN10_integer,ISBN13_integer,CATEGORY_ID) VALUES (4,'Pro Hibernate 3','Discover what is new and available in Hibernate 3',32.57,'USD',242.0,'Apress (June 27, 2005)','English','1590595114','978-1590595114',1);
INSERT INTO book (BOOK_ID,TITLE,DESCRIPTION,LIST_PRICE,LIST_PRICE_CURRENCY,PAPERBACK,PUBLISHER,LANGUAGE,ISBN10_integer,ISBN13_integer,CATEGORY_ID) VALUES (5,'Spring Recipes: A Problem-Solution Approach','Product Description Spring addresses most aspects of Java/Java EE application development and offers simple solutions to them. By using Spring, you will be lead to use industry best practices to design and implement your applications. The releases of Spring 2.x have added many improvements and new features to the 1.x versions. Spring Recipes: A Problemï¿½Solution Approach focuses on the latest Spring 2.5 features for building enterprise Java applications.',33.64,'USD',752.0,'Apress (June 19, 2008)','English','1590599799','978-1590599792',1);

INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (1,1);
INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (2,5);
INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (3,2);
INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (4,3);
INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (5,3);
INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (6,3);
INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (8,4);
INSERT INTO author_book (AUTHOR_ID,BOOK_ID) VALUES (9,4);


 

INSERT INTO book_image (BOOK_IMAGE_ID,BOOK_ID,FILENAME) VALUES (1,1,'spring-recipes.jpg');
INSERT INTO book_image (BOOK_IMAGE_ID,BOOK_ID,FILENAME) VALUES (2,2,'effective-java.jpg');
INSERT INTO book_image (BOOK_IMAGE_ID,BOOK_ID,FILENAME) VALUES (3,3,'spring.jpg');
INSERT INTO book_image (BOOK_IMAGE_ID,BOOK_ID,FILENAME) VALUES (4,5,'hibernate.jpg');
INSERT INTO book_image (BOOK_IMAGE_ID,BOOK_ID,FILENAME) VALUES (5,4,'spring.jpg');

INSERT INTO inventory (BOOK_ID,BOOK_QUANTITY) VALUES (1,25);
INSERT INTO inventory (BOOK_ID,BOOK_QUANTITY) VALUES (2,666);
INSERT INTO inventory (BOOK_ID,BOOK_QUANTITY) VALUES (3,1);
INSERT INTO inventory (BOOK_ID,BOOK_QUANTITY) VALUES (4,1);
INSERT INTO inventory (BOOK_ID,BOOK_QUANTITY) VALUES (5,5);


