-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population
FROM country
ORDER BY population DESC;

--Names of countries and continents in ascending order
SELECT name,continent
FROM country
ORDER BY continent,name ASC;

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL 
ORDER BY lifeexpectancy DESC
LIMIT 10
--OFFSET 50;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
SELECT (name || ', ' || district) as name_and_state
FROM city
WHERE district IN ('Oregon','California','Washington')
ORDER BY district, name;

-- AGGREGATE FUNCTIONS: MIN, MAX, AVG, SUM, COUNT
-- Average Life Expectancy in the World
SELECT AVG(lifeexpectancy)
FROM country;

-- Total population of all the cities in Ohio
SELECT SUM(population)
FROM city
WHERE district = 'Ohio';

-- The surface area of the smallest country in the world
SELECT MIN(surfacearea)  --if i have an aggregate function, i can't select other columns UNLESS they are in the group by
FROM country;

SELECT name, surfacearea
FROM country
ORDER BY surfacearea ASC
LIMIT 1;

-- The 10 largest countries in the world
SELECT name, surfacearea
FROM country
ORDER BY surfacearea DESC
LIMIT 10;

-- The number of countries who declared independence in 1991
SELECT COUNT(*) as num_countries
FROM country
WHERE indepyear='1991';


-- GROUP BY

-- SELECT col, col1 aggregate_function
-- FROM table
-- WHERE is optional
-- GROUP BY col, col1
-- HAVING is like a where for the aggregate stuff
-- ORDER BY is optional

-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode) as "Count Countries"
FROM countrylanguage
GROUP BY language
ORDER BY   "Count Countries" DESC;

select * from countrylanguage order by language;
select * from countrylanguage where language = 'English';

-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) as "average life expectancy"
FROM country
WHERE  lifeexpectancy IS NOT NULL
GROUP BY continent
--HAVING  AVG(lifeexpectancy) IS NOT NULL
ORDER BY "average life expectancy" DESC;

--All languages spoken in at least 10 countries
SELECT language, COUNT(countrycode)
FROM countrylanguage
GROUP BY LANGUAGE
HAVING COUNT(countrycode) >= 10;

-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG(lifeexpectancy) as "average life expectancy"
FROM country
WHERE  continent <> 'Antarctica'
GROUP BY continent
--HAVING  AVG(lifeexpectancy) IS NOT NULL
ORDER BY "average life expectancy" DESC;

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

-- The average population of cities in each state in the USA ordered by state name
SELECT district, AVG(population) as ave_pop
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

-- SUBQUERIES
-- Find the names of cities under a given government leader, Elisabeth II
select * from country where headofstate = 'Elisabeth II';

SELECT name
FROM city
WHERE countrycode IN ( 
    SELECT code FROM country WHERE headofstate = 'Elisabeth II'
   );


-- Find the names of cities whose country they belong to has not declared independence yet
SELECT * FROM country WHERE indepyear IS NULL;

SELECT name
FROM city
WHERE countrycode IN ( SELECT code FROM country WHERE indepyear IS NULL);

--What's the biggest city by population in Barbados? 
SELECT name
FROM city
WHERE countrycode = (SELECT code FROM country WHERE name = 'Barbados')
ORDER BY population DESC
LIMIT 1; 

--BAD ANSWER - THIS DOESN"T USE SUBQUERIES
SELECT code FROM country WHERE name = 'Barbados';

SELECT name
FROM city
WHERE countrycode = 'BRB'
ORDER BY population DESC
LIMIT 1; 


--List of country codes that speak the most popular language

--subquery: find the most popular language
SELECT language,COUNT(countrycode)
FROM countrylanguage 
GROUP BY language
ORDER BY COUNT(countrycode) DESC
LIMIT 1;


SELECT countrycode
FROM countrylanguage
WHERE language = (
    SELECT language
    FROM countrylanguage 
    GROUP BY language
    ORDER BY COUNT(countrycode) DESC
    LIMIT 1
  );


-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.
SELECT country.name, country.surfacearea
FROM country
ORDER BY surfacearea ASC
LIMIT 1;

SELECT c.name, c.surfacearea
FROM country as c --alias the table name
ORDER BY c.surfacearea ASC
LIMIT 1;

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

-- Also counts the number of rows in the city table

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.
SELECT SUM(population) as sum_pop, AVG(population) as ave_pop, COUNT(*) as total_cities
FROM city;

-- Gets the MIN population and the MAX population from the city table.
SELECT MIN(population) as smallest_city, MAX(population) as biggest_city
FROM city;

SELECT name,population
FROM city
WHERE population = ( SELECT MIN(population) FROM city )
  OR  population = ( SELECT MAX(population) FROM city );

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
