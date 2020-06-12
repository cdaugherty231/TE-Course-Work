--empty file, let's try different things

--TO INSERT MULTIPLE ROWS AT ONCE

--INSERT INTO table(col list)
--VALUES (row 1 col vals), (row2 col vals) , (row3 col vals)
INSERT INTO film_actor(actor_id,film_id)
VALUES   (  (SELECT actor_id FROM actor WHERE first_name = 'LISA' AND last_name = 'BYWAY'),
            (SELECT film_id FROM film WHERE title='Euclidean PI' )
         ) , 
         (  (SELECT actor_id FROM actor WHERE first_name = 'HAMPTON' AND last_name = 'AVENUE'),
            (SELECT film_id FROM film WHERE title='Euclidean PI' )
         )

     

-- 4. Add Mathmagical to the category table.
select * from category
INSERT INTO category(name)
VALUES  ('Mathmagical'), ('KatiesFavs'), ('EmmyWinners') 

--INSERT FROM NESTED SELECT
INSERT INTO films (code, title, did, date_prod, kind)
     SELECT table.code, 'Tampopo', 110, '1985-02-10', 'Comedy'
     FROM other_table AS table2;