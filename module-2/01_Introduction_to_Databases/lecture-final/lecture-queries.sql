-- SELECT ... FROM
-- Selecting the names for all countries
SELECT name
FROM country;


-- Selecting the name and population of all countries
SELECT name, population
FROM country;


-- Selecting all columns from the city table
SELECT *
FROM city;

select * 
from city;


-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio

--Conditional clauses in the WHERE clause can include
-- =, <>, !=, >, >=, <, <=
-- IN(values), NOT IN(values)
-- BETWEEN value AND value
-- IS NULL, IS NOT NULL
-- LIKE (with wildcard characters %)
-- Multiple conditions use AND and OR
SELECT name,district
FROM city
WHERE district = 'Ohio';


-- Selecting countries that gained independence in the year 1776
SELECT name, indepyear
FROM country
WHERE indepyear = 1776;


-- Selecting countries not in Asia


-- Selecting countries that do not have an independence year

-- Selecting countries that do have an independence year


-- Selecting countries that have a population greater than 5 million



-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
SELECT name, population, district
FROM city
WHERE district = 'Ohio' AND population > 400000

-- Selecting country names on the continent North America or South America

SELECT name, continent FROM country WHERE continent = 'North America' OR continent = 'South America';

SELECT name, continent 
FROM country 
WHERE continent IN ('North America','South America');

SELECT name, continent 
FROM country 
WHERE continent LIKE '%America';

SELECT name, continent 
FROM country 
WHERE continent ILIKE '%america'; --case insensitive LIKE

-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
SELECT name as "The Country Name", population as "The Pop", lifeexpectancy as "How Long to Live", 
     ROUND((population / surfacearea)::numeric,2) as "Population Per Area"
FROM country


