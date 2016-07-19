USE TEST;

-- DELETE FROM AMR_USER;
-- DELETE FROM AMR_ORDER_ITEMS;
-- DELETE FROM AMR_PLACE_ITEMS_MENU;
-- DELETE FROM AMR_ORDERS;
-- DELETE FROM AMR_PLACES;


-- BEGIN
--   FOR c IN ( SELECT table_name
--              FROM user_tables
--              WHERE table_name LIKE 'amr_%' )
--   LOOP
--     EXECUTE IMMEDIATE 'DROP TABLE ' || c.table_name;
--   END LOOP;
-- END;

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

INSERT INTO amr_places (ID, Name, PhoneNo) VALUES ('1', 'place1', '123451');
INSERT INTO amr_place_items_menu (ID, PlaceID, Name, "Desc", Price) VALUES ('1', '1', 'item1', 'desc1', 999.99);
SELECT *
FROM amr_place_items_menu;