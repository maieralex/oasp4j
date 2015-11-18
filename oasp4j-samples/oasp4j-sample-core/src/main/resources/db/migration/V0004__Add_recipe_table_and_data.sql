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

INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (0, 0, 'Hamburger', 'with bacon and cheese, served with fries', 'en', 7.99, 1, 'Carl Cook', 'beef, main dish', 2, 'beef, breadcrumbs, eggs, oil', 'easy', 15, 7, 1000, 'whisk eggs, flip pork into whisked eggs with both sides, flip pork into breadcrumbs with both sides, fry');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (1, 0, 'Lammkaree', 'auf Rotweinsauce an Gemüse', 'de', 4.99, 2, 'Carl Cook', 'pasta, pork, main dish', 2, 'pork (minced), tomatoes, pasta, oil', 'very easy', 5, 15, 800, 'cook pasta, fry the minced meat, mix tomatoes with fried meat, mix cooked pasta with sauce');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (2, 0, 'Pfannengericht', 'Sweet austrian dessert', 'de', 3.99, 3, 'Carl Cook', 'dessert', 2, 'eggs, flour, powdered sugar', 'medium', 15, 10, 1200, 'make liquidy dough, start frying dough, rip solid dough into pieces');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (3, 0, 'Pizza', 'German marinated pot roast with raisins', 'en', 10.99, 4, 'Carl Cook', 'pork, main dish', 4, 'meat (usually beef, veal, venison), marinated in wine and/or vinegar, vegetables, and spices', 'hard', 50, 60, 2500, 'marinate roast, cook roast, prepare gravy');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (4, 0, 'Ricebowl', 'Fried Vegetables in asian sauce', 'en', 5.99, 5, 'Carl Cook', 'vegan', 2, 'peppers, carrots, mushrooms, ginger, garlic', 'easy', 20, 10, 500, 'cut vegetables, throw the cut pieces into the frying pan, season and taste');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (5, 0, 'Fried vegetables', 'Fried Vegetables in asian sauce', 'en', 5.99, 6, 'Carl Cook', 'vegan', 2, 'peppers, carrots, mushrooms, ginger, garlic', 'easy', 20, 10, 500, 'cut vegetables, throw the cut pieces into the frying pan, season and taste');
INSERT INTO RECIPE (id, modificationCounter, name, description, language, price, imageId, author, categories, portions, ingredients, difficulty, prepTimeMinutes, cookTimeMinutes, calories, cookingInstructions) VALUES (6, 0, 'OASP Gericht', 'Fried Vegetables in asian sauce', 'de', 5.99, 0, 'Carl Cook', 'vegan', 2, 'peppers, carrots, mushrooms, ginger, garlic', 'easy', 20, 10, 500, 'cut vegetables, throw the cut pieces into the frying pan, season and taste');
