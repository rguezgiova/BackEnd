DROP TABLE IF EXISTS personasTest;

CREATE TABLE personasTest (
 id INTEGER NOT NULL,
 username VARCHAR(50),
 password VARCHAR(50),
 name VARCHAR(50),
 surname VARCHAR(100),
 PRIMARY KEY (id)
);