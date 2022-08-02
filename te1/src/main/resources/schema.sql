DROP TABLE IF EXISTS personas;

CREATE TABLE personas (
 id INTEGER NOT NULL,
 username VARCHAR(50),
 password VARCHAR(50),
 name VARCHAR(50),
 surname VARCHAR(100),
 PRIMARY KEY (id)
);