-- Script pour crÃ©er la base de donnÃ©es Book Selling System
-- ExÃ©cutez ce script dans MySQL aprÃ¨s l'installation

CREATE DATABASE IF NOT EXISTS book_selling_system;
USE book_selling_system;

-- Table pour les comptes utilisateurs
CREATE TABLE IF NOT EXISTS account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first VARCHAR(50) NOT NULL,
    last VARCHAR(50) NOT NULL,
    user1 VARCHAR(50) UNIQUE NOT NULL,
    pass1 VARCHAR(255) NOT NULL,
    emailadd VARCHAR(100) NOT NULL,
    mb VARCHAR(15) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table pour les livres
CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category VARCHAR(50),
    condition_type ENUM('new', 'old') NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table pour les commandes
CREATE TABLE IF NOT EXISTS bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    book_id INT,
    quantity INT DEFAULT 1,
    total_price DECIMAL(10,2),
    status ENUM('pending', 'confirmed', 'cancelled') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES account(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- InsÃ©rer un compte admin par dÃ©faut
INSERT IGNORE INTO account (first, last, user1, pass1, emailadd, mb) 
VALUES ('Admin', 'User', 'admin', 'admin123', 'admin@example.com', '1234567890');

-- InsÃ©rer quelques livres d'exemple
INSERT IGNORE INTO books (title, author, price, category, condition_type, description)
VALUES 
('Java Programming', 'Oracle', 45.99, 'Programming', 'new', 'Complete guide to Java programming'),
('Database Systems', 'Ramez Elmasri', 39.99, 'Database', 'old', 'Comprehensive database concepts'),
('Web Development', 'Mozilla Foundation', 29.99, 'Web', 'new', 'Modern web development techniques');

COMMIT;

