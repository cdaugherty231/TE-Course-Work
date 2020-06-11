-- INSERT

--INSERT INTO table_name (column1, column2, ..., column_n)
--VALUES (value1, value2, ... value_n);

--INSERT INTO table_name VALUES (value1, value2, ... value_n);

-- 1. Add Klingon as a spoken language in the USA
select * from countrylanguage;

INSERT INTO countrylanguage (countrycode,language,isOfficial,percentage)
VALUES('USA','Klingon',false,1.2);

-- 2. Add Klingon as a spoken language in Great Britain
select * from country where name ILIKE '%United Kingdom%';

INSERT INTO countrylanguage (countrycode,language,isOfficial,percentage)
VALUES('GBR','Klingon',false,1.2);

--FIND NULLABLE COLUMNS
select c.table_schema,
       c.table_name,
       c.column_name,
       case c.is_nullable
            when 'NO' then 'not nullable'
            when 'YES' then 'is nullable'
       end as nullable
from information_schema.columns c
join information_schema.tables t
     on c.table_schema = t.table_schema 
     and c.table_name = t.table_name
where c.table_schema not in ('pg_catalog', 'information_schema')
      and t.table_type = 'BASE TABLE' 
order by table_schema,
         table_name,
         column_name;

-- UPDATE

-- UPDATE table_name
-- SET column = value
-- WHERE column = value

-- 1. Update the capital of the USA to Houston
SELECT code, ci.name FROM COUNTRY c JOIN city ci on c.capital = ci.id WHERE countrycode = 'USA';

SELECT * FROM city WHERE name = 'Houston';

UPDATE country
SET capital = 3796
WHERE code = 'USA';

UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Houston')
WHERE code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state
SELECT code, ci.name, headofstate 
FROM COUNTRY c JOIN city ci on c.capital = ci.id WHERE countrycode = 'USA';

UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington'),
    headofstate = 'Katie Dwyer'
WHERE code = 'USA';


-- DELETE

--DELETE FROM table_name
--WHERE column=value;

-- 1. Delete English as a spoken language in the USA
--SELECT *
DELETE 
FROM countrylanguage
WHERE countrycode = 'USA' AND language = 'English';

-- 2. Delete all occurrences of the Klingon language 
--SELECT *
DELETE
FROM countrylanguage
WHERE language = 'Klingon';


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

INSERT INTO countrylanguage(language)
VALUES('Elvish');

-- 2. Try inserting English as a spoken language in the country ZZZ as official and 10%. What happens?
INSERT INTO countrylanguage (countrycode,language,isOfficial,percentage)
VALUES('ZZZ','English',true,10);

--fails due to foreign key constraint fk_countrylanguage_countrycode
-- you can't insert a language for a country that doesn't exist in the country table

-- 3. Try deleting the country USA. What happens?
DELETE 
FROM country
WHERE code = 'USA';

--update or delete on table "country" violates foreign key constraint "fk_countrycode" 
--on table "city"

-- i can't delete from country if it will make a row in city violate a fk constraint

-- CONSTRAINTS

--A constraint is associated with a table and defines properties that the column data must comply with.

-- Types of Constraints
-- NOT NULL
-- UNIQUE
-- PRIMARY KEY - allows FKs to establish a relationship, and enforces NOT NULL and UNIQUE,
-- FOREIGN KEY - enforces valid PK values, and limits deletion of the PK row if FK row exists
-- CHECK - specifies acceptable values that can be entered in the column
-- DEFAULT - provides a default value for the column

-- 1. Try inserting Wakandian as a spoken language in the USA
INSERT INTO countrylanguage (countrycode,language,isofficial,percentage)
VALUES('USA','Wakandian',true,10);

-- 2. Try again. What happens?

INSERT INTO countrylanguage (countrycode,language,isofficial,percentage)
VALUES('USA','Wakandian',false,100);

--duplicate key value violates unique constraint "pk_countrylanguage_countrycode_language"
--countrycode and language togetheer are requried to be unique

-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE country
SET continent = 'Outer Space'
WHERE code = 'USA';

--new row for relation "country" violates check constraint "country_continent_check"

-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

--START TRANSACTION
--COMMIT  
--ROLLBACK 

-- 1. Try deleting all of the rows from the country language table and roll it back.
START TRANSACTION;

--SELECT COUNT(*) FROM countrylanguage;

DELETE 
FROM countrylanguage;

SELECT COUNT(*) FROM countrylanguage;

ROLLBACK ;

SELECT COUNT(*) FROM countrylanguage;
-- 2. Try updating all of the cities to be in the USA and roll it back

START TRANSACTION;

UPDATE city
SET countrycode = 'USA';

SELECT * FROM city;
ROLLBACK;

-- 3. Demonstrate two different SQL connections trying to access the same table where
-- one happens to be inside of a transaction but hasn't committed yet.

START TRANSACTION;

UPDATE country
SET headofstate = 'Ferris Bueller'
WHERE code = 'USA';

COMMIT;

SELECT * FROM country WHERE code = 'USA';


--USING CTEs
-- WITH cte_name (column_list) AS (
--     CTE_query_definition 
-- )
-- statement;

--select all of the lifeexpencies for countries that have at least 5 cities with a pop
-- between 100000 and 10000000

SELECT name, lifeexpectancy
FROM country
WHERE code IN (
      SELECT countrycode 
      FROM city 
      WHERE population between 100000 and 10000000
      GROUP BY countrycode
      HAVING COUNT(*) > 5
      )

WITH country_lots_big_city (countrycode) AS (
      SELECT countrycode 
      FROM city 
      WHERE population between 100000 and 10000000
      GROUP BY countrycode
      HAVING COUNT(*) > 5
)
select name, lifeexpectancy
FROM country c
INNER JOIN country_lots_big_city big on c.code = big.countrycode;

--select * from country_lots_big_city; temporary for next statement ONLY