--CREATE AND DROP A DATABSE

--these are allowed in db visualizer but the vs code extension we use doesn't support
CREATE DATABASE database_name;
DROP DATABASE database_name;

--drop table if exists
-- DROP TABLE IF EXISTS payment;
-- DROP TABLE IF EXISTS rental;
-- DROP TABLE IF EXISTS inventory;

-- --CREATE TABLE table_name
-- (
--   column_name1 data_type(size),
--   column_name2 data_type(size) NOT NULL,
--   column_name3 data_type(size),
--   CONSTRAINT pk_column_1 PRIMARY KEY (column_name1),
--   CONSTRAINT fk_tablename_column1_othertablename FOREIGN KEY (column_name2) REFERENCES othertable_name(name of columnin other table)    
-- );


ALTER TABLE table_name
ADD CONSTRAINT pk_constraint_name PRIMARY KEY (column_name(s));

ALTER TABLE table_name
ADD CONSTRAINT fk_constraint_name FOREIGN KEY (column_name) REFERENCES table(column_name);

ALTER TABLE table_name
ADD CONSTRAINT chk_constraint_name CHECK (column_name = 'value' OR column_name IN (values));