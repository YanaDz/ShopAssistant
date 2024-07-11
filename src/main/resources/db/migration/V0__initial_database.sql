-- Create table for Product entity with fields from AuditableEntity
CREATE TABLE Product (
                         id UUID PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         firm VARCHAR(255) NOT NULL,
                         productVersion VARCHAR(255) NOT NULL,
                         productType VARCHAR(255) NOT NULL,
                         version BIGINT NOT NULL,
                         created TIMESTAMP NOT NULL,
                         modified TIMESTAMP
);