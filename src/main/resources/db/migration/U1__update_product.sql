ALTER TABLE Product ADD COLUMN product_type_str VARCHAR(255);

UPDATE Product
SET product_type_str = CASE product_type
                           WHEN 0 THEN 'HOME_APPLIANCE'
                           WHEN 1 THEN 'KITCHEN_APPLIANCE'
                           WHEN 3 THEN 'SMARTPHONES'
                           WHEN 4 THEN 'COMPUTERS'
                           ELSE NULL -- Optional: Handle unexpected values
    END;

ALTER TABLE Product DROP COLUMN product_type;

ALTER TABLE Product RENAME COLUMN product_type_str TO product_type;