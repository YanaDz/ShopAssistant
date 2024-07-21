ALTER TABLE product
    ALTER COLUMN version SET DEFAULT 0,
    ALTER COLUMN created SET DEFAULT NOW();

ALTER TABLE seller ALTER COLUMN version SET DEFAULT 0,
                   ALTER COLUMN created SET DEFAULT NOW();

ALTER TABLE purchase ALTER COLUMN version SET DEFAULT 0,
                     ALTER COLUMN created SET DEFAULT NOW();

