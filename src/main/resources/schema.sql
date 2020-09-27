DROP TABLE customer IF EXISTS;

CREATE TABLE customer  (
    cust_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    city VARCHAR(30),
    country VARCHAR(30)
);