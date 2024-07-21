CREATE TABLE IF NOT EXISTS seller
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(255),
    search_url VARCHAR(255),
    version    BIGINT    NOT NULL,
    created    TIMESTAMP NOT NULL,
    modified   TIMESTAMP
);

CREATE TABLE IF NOT EXISTS purchase
(
    id          UUID PRIMARY KEY,
    product_id  UUID,
    seller_id   UUID,
    price       DOUBLE PRECISION,
    product_url VARCHAR(255),
    version     BIGINT    NOT NULL,
    created     TIMESTAMP NOT NULL,
    modified    TIMESTAMP,
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT fk_seller FOREIGN KEY (seller_id) REFERENCES seller (id)
);