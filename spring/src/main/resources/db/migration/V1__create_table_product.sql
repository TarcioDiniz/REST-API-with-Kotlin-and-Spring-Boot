CREATE TABLE Product (
  id CHAR(36) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  value_product DECIMAL(10,2) NOT NULL,
  image VARCHAR(255),
  userID VARCHAR(255)
);
