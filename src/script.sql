-- USE TEST;

DELETE FROM amr_order_items;
DELETE FROM amr_place_items_menu;
DELETE FROM amr_orders;
DELETE FROM amr_places;
DELETE FROM amr_user;

CREATE TABLE amr_user (
  ID       NUMBER(32) PRIMARY KEY NOT NULL ,
  Username VARCHAR2(255) UNIQUE,
  Pass     VARCHAR2(255),
  Name     VARCHAR2(255),
  PhoneNo  VARCHAR2(50)
);

CREATE TABLE amr_places (
  ID      NUMBER(32) PRIMARY KEY NOT NULL ,
  Name    VARCHAR2(255),
  PhoneNo VARCHAR2(50)
);

CREATE TABLE amr_place_items_menu (
  ID      NUMBER(32) PRIMARY KEY,
  PlaceID NUMBER(32) REFERENCES amr_places,
  Name    VARCHAR2(255),
  "Desc"  CLOB,
  Price   NUMBER(5, 2)
);

CREATE TABLE amr_orders (
  ID           NUMBER(32) PRIMARY KEY NOT NULL ,
  Owner_userID NUMBER(32) REFERENCES amr_user,
  Status       VARCHAR2(50),
  PlaceID      NUMBER(32) REFERENCES amr_places,
  "Date"       DATE
);

CREATE TABLE amr_order_items (
  ID                NUMBER(32) PRIMARY KEY NOT NULL ,
  OrderID           NUMBER(32) REFERENCES amr_orders,
  Place_Item_MenuID NUMBER(32) REFERENCES amr_place_items_menu,
  UserID            NUMBER(32) REFERENCES amr_user,
  Count             NUMBER(10, 0) DEFAULT (1)
);
