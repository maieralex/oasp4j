CREATE CACHED TABLE PUBLIC.RECIPE(
    id BIGINT NOT NULL,
    modificationCounter INTEGER NOT NULL,
    name VARCHAR(255),
    description VARCHAR(255),
    price DECIMAL(19, 2),
    image BIGINT
);

ALTER TABLE PUBLIC.RECIPE ADD CONSTRAINT PUBLIC.PK_RECIPE PRIMARY KEY(id);

INSERT INTO RECIPE (id, modificationCounter, name, description, price) VALUES (0, 0, 'WienerSchnitzel', 'Schnitzel Wiener Art', 7.99);
INSERT INTO RECIPE (id, modificationCounter, name, description, price) VALUES (1, 0, 'Spaghetti', 'Pasta nach Bolognese Art', 8.99);
INSERT INTO RECIPE (id, modificationCounter, name, description, price) VALUES (2, 0, 'Kaiserschmarn', 'Leckere Delikatesse', 7.99);
INSERT INTO RECIPE (id, modificationCounter, name, description, price) VALUES (3, 0, 'Sauerbraten', 'Sauerbraten nach rheinischer Art', 10.99);
INSERT INTO RECIPE (id, modificationCounter, name, description, price, image) VALUES (4, 0, 'Asiapfanne', 'Frisches Gemuese aus dem Wok', 4.99, 10);
