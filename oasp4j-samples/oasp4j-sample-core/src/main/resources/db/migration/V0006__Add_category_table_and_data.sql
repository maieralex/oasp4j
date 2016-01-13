CREATE CACHED TABLE PUBLIC.CATEGORY(
    id BIGINT NOT NULL,
    languageId BIGINT NOT NULL,
    modificationCounter INTEGER NOT NULL,
    name VARCHAR(255),
    language VARCHAR(2)
);

ALTER TABLE PUBLIC.CATEGORY ADD CONSTRAINT PUBLIC.PK_CATEGORY PRIMARY KEY(id);
ALTER TABLE PUBLIC.RECIPE ADD CONSTRAINT PUBLIC.FK_RECIPE2CATEGORY FOREIGN KEY(categoryId) REFERENCES PUBLIC.CATEGORY(id) NOCHECK;

-- Categories DE
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (0, 0, 0, 'Vorspeisen', 'de');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (1, 1, 0, 'Für den kleinen Hunger', 'de');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (2, 2, 0, 'Vom Grill', 'de');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (3, 3, 0, 'Fisch', 'de');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (4, 4, 0, 'Pasta', 'de');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (5, 5, 0, 'Pizza', 'de');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (6, 6, 0, 'Nachspeisen', 'de');

-- Categories EN
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (7, 0, 0, 'Appetizer', 'en');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (8, 1, 0, 'Snacks', 'en');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (9, 2, 0, 'Grilled', 'en');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (10, 3, 0, 'Fish', 'en');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (11, 4, 0, 'Pasta', 'en');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (12, 5, 0, 'Pizza', 'en');
INSERT INTO CATEGORY (id, languageId, modificationCounter, name, language)  VALUES (13, 6, 0, 'Dessert', 'en');
