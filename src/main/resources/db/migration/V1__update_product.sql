ALTER TABLE Product ADD COLUMN product_type_int INT;

UPDATE Product
SET product_type_int = CASE product_type
                           WHEN 'HOME_APPLIANCE' THEN 0
                           WHEN 'KITCHEN_APPLIANCE' THEN 1
                           WHEN 'SMARTPHONES' THEN 3
                           WHEN 'COMPUTERS' THEN 4
                           ELSE NULL -- Optional: Handle unexpected values
    END;

ALTER TABLE Product DROP COLUMN product_type;

ALTER TABLE Product RENAME COLUMN product_type_int TO product_type;