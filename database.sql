-- Kör hela filen som root: mysql -u root -p < database.sql

DROP DATABASE IF EXISTS webshop;
CREATE DATABASE webshop;

CREATE USER IF NOT EXISTS 'webshop'@'localhost' IDENTIFIED BY 'Haha123';
GRANT SELECT ON webshop.* TO 'webshop'@'localhost';

USE webshop;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO users (username, password) VALUES ('test', 'test123');

INSERT INTO items (name, description, price) VALUES
                                                 ('Ramlösa Citron', 'Kolsyrat vatten med citronsmak, 50 cl', 15.00),
                                                 ('Nocco Ramonade', 'Energidryck, 30 cl', 25.00),
                                                 ('Snickers', 'Snickers chockladbar', 15.00);
