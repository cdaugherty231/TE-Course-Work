-- what country codes have at least one city with a population> 100000
SELECT  DISTINCT countrycode
FROM city
WHERE population > 100000;

-- countries with a lifeexpectancy between 60 and 70
SELECT name, lifeexpectancy
FROM country
WHERE lifeexpectancy BETWEEN 60 and 70;

--does betwen work with alpha
SELECT name 
FROM city
WHERE SUBSTRING( name, 1, 1 ) BETWEEN 'a' AND 'd';

-- The name and population of all cities in the USA with a population of greater than 1 million people
SELECT name, population
FROM city
WHERE countrycode = 'USA' AND population > 1000000;

-- The name and population of all cities in China with a population of greater than 1 million people
SELECT * FROM country WHERE name = 'China';

SELECT name, population
FROM city
WHERE countrycode = 'CHN' AND population > 1000000;

-- The name and region of all countries in North or South America

--LIKE, IN, AND 
SELECT name, region, continent
FROM country
WHERE continent LIKE '%America';

SELECT name, region, continent
FROM country
WHERE continent IN ('North America', 'South America');


SELECT name, region, continent
FROM country
WHERE continent = 'North America' OR  continent = 'South America';
  
  
-- The name, continent, and head of state of all countries whose form of government is a monarchy
--what are all possible forms of government

SELECT DISTINCT governmentform
FROM country

SELECT name, continent, headofstate, governmentform
FROM country
WHERE governmentform LIKE '%Monarchy%';

-- The name, country code, and population of all cities with a population less than one thousand people

-- The name and region of all countries in North or South America except for countries in the Caribbean

-- The name, population, and GNP of all countries with a GNP greater than $1 trillion dollars and a population of less than 1 billion people

-- The name and population of all cities in Texas that have a population of greater than 1 million people

-- The name and average life expectancy of all countries in southern regions

-- The name and average life expectancy of all countries in southern regions for which an average life expectancy has been provided (i.e. not equal to null)

-- The name, continent, GNP, and average life expectancy of all countries in Africa or Asia that have an average life expectancy of at least 70 years and a GNP between $1 million and $100 million dollars
