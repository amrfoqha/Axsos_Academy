import json
import mysql.connector

# Load JSON
with open(r"c:\Users\ASUS\Downloads\Resipie.json", "r") as f:
    recipes = json.load(f)

# Connect to MySQL
conn = mysql.connector.connect(
    host="localhost",
    user="root",
    password="root123",
    database="cookly"
)
cursor = conn.cursor()

# Create table if not exists
cursor.execute("""
CREATE TABLE IF NOT EXISTS recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    cuisine VARCHAR(100),
    description TEXT,
    calories INT,
    cooking_time INT,
    ingredients TEXT,
    steps TEXT,
    image VARCHAR(2500),
    category VARCHAR(2500)
)
""")

# Insert recipes into the database
for recipe in recipes:
    time_str = recipe.get("time_cooking") or recipe.get("timeCooking") 
   

    cursor.execute("""
        INSERT INTO recipes (title, cuisine, description, calories, cooking_time, ingredients, steps, image, category)
        VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)
    """, (
        recipe.get("title"),
        recipe.get("cuisine"),
        recipe.get("description", "Delicious recipe"),
        recipe.get("calories", 500),
        time_str,
        json.dumps(recipe.get("ingredients", [])),  # convert list to JSON string
        json.dumps(recipe.get("steps", [])),
        recipe.get("imageUrl", ""),
        json.dumps(recipe.get("categories", []))
    ))

conn.commit()
cursor.close()
conn.close()

print(f"{len(recipes)} recipes inserted successfully!")
