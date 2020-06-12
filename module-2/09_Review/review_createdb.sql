BEGIN TRANSACTION;

CREATE TABLE people (
   
    name varchar(64) NOT NULL,
    id integer NOT NULL,
	class_id integer
);

CREATE TABLE class (
    id integer NOT NULL,
    name varchar(64) NOT NULL,
    instructor varchar(64) NOT NULL
);

COMMIT;