CREATE TABLE IF NOT EXISTS author(
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    bookList CHAR(36) NOT NULL
);