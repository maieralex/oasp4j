CREATE CACHED TABLE PUBLIC.RECIPE(
    id BIGINT NOT NULL,
    modificationCounter INTEGER NOT NULL,
    name VARCHAR(255),
    description VARCHAR(255),
    language VARCHAR(2),
    price DECIMAL(19, 2),
    imageId BIGINT,
    author VARCHAR(255),
    categories VARCHAR(255),
    portions INTEGER,
    ingredients VARCHAR(500),
    difficulty VARCHAR(255),
    prepTimeMinutes INTEGER,
    cookTimeMinutes INTEGER,
    calories BIGINT,
    cookingInstructions VARCHAR(500)
);

ALTER TABLE PUBLIC.RECIPE ADD CONSTRAINT PUBLIC.PK_RECIPE PRIMARY KEY(id);

INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions)  VALUES (0, 0, 'Hamburger', 'With bacon and cheese, served with fries on a homemade bun' , 'en', 7.99, 1, 'Carl Cook', 'beef, main dish', 2, 'beef, hamburger bun, tomato, onion, bacon', 'easy', 10, 7, 1200,  'Lightly oil grill& heat BBQ to medium. Whisk egg in a bowl& add next 6 ingredients. Add any of the “stir-ins” that appeal to you. Crumble in beef& using your hands or a fork, gently mix together. Handle the meat as little as possible – the more you work it, the tougher it gets.');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes,  calories, cookingInstructions) VALUES (1, 0, 'Lammkarree', 'Auf Rotweinsauce an Gemüse', 'de', 24.99, 2, 'Carl Cook', 'Lamm, Hauptgericht', 2, 'Lamm, Rotwein, Gemüse', 'hard', 25, 30, 970, 'Lammkarrees putzen, Silberhaut und Fett entfernen. Haut- und Fleischreste sorgfältig vom Lammrückenknochen abschaben. Fleischabschnitte (ca. 500 g) beiseite legen. Lammkarrees kalt stellen. Zwiebeln und Knoblauch in feine Streifen schneiden ...');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes,  calories, cookingInstructions) VALUES (2, 0, 'Pfannengericht', 'Lecker gekochtes Fleisch mit Gemüse', 'de', 6.99, 3, 'Carl Cook', 'main dish', 2, 'Schweinefleisch, Gemüse, Frühlingszwiebeln, Knoblauch, Paprika, Mais', 'easy', 15, 10, 500, 'Die Frühlingszwiebeln putzen und in kleine Ringe schneiden. Den Knoblauch ebenfalls in kleine Stücke schneiden. Frühlingszwiebeln und Knoblauch in Öl andünsten. Während dessen die beiden Schnitzel ...');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (3, 0, 'Pizza', 'Italian pizza with mozarella, salami and tomatoes', 'en', 10.99, 4, 'Carl Cook', 'main dish', 4, 'mozarella, salami, tomatoes,', 'easy', 50, 60, 2500, 'The pastry evenly to the tomato sauce. With the zucchini slices and basil leaves, and in between the slices of sausage prove - the salami should be crispy after baking. Distributed in the gaps mozzarella pieces. The pizza with olive oil Drizzle with salt and pepper and bake until golden brown and crispy.');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (4, 0, 'Ricebowl', 'Ricebowl with changing ingredients', 'en', 5.99, 5, 'Carl Cook', 'vegan', 2, 'peppers, carrots, mushrooms, ginger, garlic', 'easy', 20, 10, 500, 'cut vegetables, throw the cut pieces into the frying pan, season and taste - add rice.');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes,  calories, cookingInstructions) VALUES (5, 0, 'Fried vegetables', 'Fried Vegetables in asian sauce', 'en', 5.99, 6, 'Carl Cook', 'vegan', 2, 'peppers, carrots, mushrooms, ginger, garlic', 'easy', 20, 10, 500, 'cut vegetables, throw the cut pieces into the frying pan, season and taste');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (6, 0, 'OASP featured ', 'Herbstliches Gericht für die Mitarbeiter des OASP-Teams', 'de', 5.99, 0, 'Carl Cook', 'wechselnd', 1, 'Kürbis, Salz, Wasser, Mehl, Paprikapulver', 'easy', 10, 10, 500, 'Kürbis schälen, Kerne mit einem Löffel auskratzen, in 4-5 cm lange Stücke schneiden. Salz überstreuen, Wasser angießen und so lange kochen, bis sie glasig aussehen. Abgießen, Kürbisstücke warm halten. Für die Soße Zwiebel in Butter oder Margarine erhitzen, lassen ...');
