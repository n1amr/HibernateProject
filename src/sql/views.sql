-- Order view
CREATE OR REPLACE VIEW AMR_ORDER_VIEW AS
SELECT
  AMR_ORDERS.ID     AS "Order ID",
  AMR_USER.NAME     AS "Owner Name",
  AMR_ORDERS.STATUS AS "Status",
  AMR_PLACES.NAME   AS "Plcae Name",
  AMR_ORDERS."Date" AS "Date"
FROM AMR_ORDERS
  JOIN AMR_PLACES ON AMR_ORDERS.PLACEID = AMR_PLACES.ID
  JOIN AMR_USER ON AMR_ORDERS.OWNER_USERID = AMR_USER.ID
ORDER BY AMR_ORDERS."Date" DESC;

-- Order item view
CREATE OR REPLACE VIEW AMR_ORDER_ITEM_VIEW AS
SELECT
  AMR_ORDERS.ID                                               AS "Order ID",
  AMR_PLACES.NAME                                             AS "Place Name",
  AMR_USER.USERNAME                                           AS "Username",
  AMR_ORDER_ITEMS.COUNT                                       AS "Count",
  ('$' || AMR_PLACE_ITEMS_MENU.PRICE)                         AS "Price",
  ('$' || AMR_ORDER_ITEMS.COUNT * AMR_PLACE_ITEMS_MENU.PRICE) AS "Total"
FROM AMR_ORDER_ITEMS
  JOIN AMR_USER ON AMR_ORDER_ITEMS.USERID = AMR_USER.ID
  JOIN AMR_PLACE_ITEMS_MENU ON AMR_ORDER_ITEMS.PLACE_ITEM_MENUID = AMR_PLACE_ITEMS_MENU.ID
  JOIN AMR_ORDERS ON AMR_ORDER_ITEMS.ORDERID = AMR_ORDERS.ID
  JOIN AMR_PLACES ON AMR_ORDERS.PLACEID = AMR_PLACES.ID;