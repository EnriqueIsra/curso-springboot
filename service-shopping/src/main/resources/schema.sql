DROP TABLE IF EXISTS tbl_invoices;
CREATE TABLE tbl_invoices (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number_invoice VARCHAR(250) NOT NULL,
    description VARCHAR(250) NOT NULL,
    customer_id BIGINT NOT NULL,
    create_at TIMESTAMP,
    state VARCHAR(250)
);

DROP TABLE IF EXISTS tbl_invoice_items;
CREATE TABLE tbl_invoice_items (
    invoice_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    price DOUBLE
);