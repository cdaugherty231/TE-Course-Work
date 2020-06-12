BEGIN TRANSACTION;

CREATE TABLE people (
   
    name varchar(64) NOT NULL,
    id integer NOT NULL,
	
);

CREATE TABLE class (
    id integer NOT NULL,
    name varchar(64) NOT NULL,
    instructor id integer NOT NULL
);

CREATE TABLE students (
    student_id integer NOT NULL,
    class_id integer NOT NULL
);

CREATE TABLE linked_in_connections (
    id_a integer NOT NULL,
    id_b integer NOT NULL
);

COMMIT;