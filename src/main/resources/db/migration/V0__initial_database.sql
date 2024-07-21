-- Create table for Product entity with fields from AuditableEntity
CREATE TABLE IF NOT EXISTS  Product (
                         id UUID PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         firm VARCHAR(255) NOT NULL,
                         product_version VARCHAR(255) NOT NULL,
                         product_type VARCHAR(255) NOT NULL,
                         version BIGINT NOT NULL,
                         created TIMESTAMP NOT NULL,
                         modified TIMESTAMP
);