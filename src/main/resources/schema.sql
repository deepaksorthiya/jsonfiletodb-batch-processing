DROP TABLE customer IF EXISTS;

CREATE TABLE customer  (
    cust_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(250),
    last_name VARCHAR(250),
    city VARCHAR(250),
    country VARCHAR(250)
);