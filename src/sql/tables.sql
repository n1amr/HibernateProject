-- USE TEST;

-- DELETE FROM amr_order_items;
-- DELETE FROM amr_place_items_menu;
-- DELETE FROM amr_orders;
-- DELETE FROM amr_places;
-- DELETE FROM amr_user;

DROP TABLE amr_order_items;
DROP TABLE amr_place_items_menu;
DROP TABLE amr_orders;
DROP TABLE amr_places;
DROP TABLE amr_user;

CREATE TABLE amr_user (
  ID       NUMBER(32) PRIMARY KEY NOT NULL,
  Username VARCHAR2(255) UNIQUE,
  Pass     VARCHAR2(255),
  Name     VARCHAR2(255),
  PhoneNo  VARCHAR2(50)
);

CREATE TABLE amr_places (
  ID      NUMBER(32) PRIMARY KEY NOT NULL,
  Name    VARCHAR2(255),
  PhoneNo VARCHAR2(50)
);

CREATE TABLE amr_place_items_menu (
  ID      NUMBER(32) PRIMARY KEY,
  PlaceID NUMBER(32) REFERENCES amr_places NOT NULL,
  Name    VARCHAR2(255),
  "Desc"  CLOB,
  Price   NUMBER(5, 2),
  CONSTRAINT "NON_NEGATIVE_PRICE" CHECK (Price >= 0) ENABLE
);

CREATE TABLE amr_orders (
  ID           NUMBER(32) PRIMARY KEY           NOT NULL,
  Owner_userID NUMBER(32) REFERENCES amr_user   NOT NULL,
  Status       VARCHAR2(50),
  PlaceID      NUMBER(32) REFERENCES amr_places NOT NULL,
  "Date"       DATE
);

CREATE TABLE amr_order_items (
  ID                NUMBER(32) PRIMARY KEY                     NOT NULL,
  OrderID           NUMBER(32) REFERENCES amr_orders           NOT NULL,
  Place_Item_MenuID NUMBER(32) REFERENCES amr_place_items_menu NOT NULL,
  UserID            NUMBER(32) REFERENCES amr_user             NOT NULL,
  Count             NUMBER(10, 0) DEFAULT (1)
);
