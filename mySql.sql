create database mydb;

use mydb;
DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
id INT AUTO_INCREMENT  PRIMARY KEY,
name VARCHAR(250) NOT NULL,
dep INT NOT NULL);
                        
                        
INSERT INTO Person (name,  dep) VALUES
('raghad',2),
('lina', 1 ),
('shaima',2)  ;

INSERT INTO Person (name,  dep) VALUES
('raghad',1),
('lina', 2),
('raghad',2)  ;


create table phone_number(
pid int  AUTO_INCREMENT PRIMARY KEY,
person_id int,
number varchar(20),
type varchar(20),
 FOREIGN KEY (person_id) REFERENCES Person(id)
 
);

create table project(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

create table persons_projects(
person_id int,
project_id int,
FOREIGN KEY (person_id)
REFERENCES person(id),
FOREIGN KEY (project_id)
REFERENCES project(id)
);

create table bank_account(
id int PRIMARY KEY AUTO_INCREMENT,
type varchar(20),
balance real,
person_id int,
FOREIGN KEY (person_id)
REFERENCES person(id)
);









DROP TABLE IF EXISTS PhoneNumber;
DROP TABLE IF EXISTS phone_number;

select * from Person;
select * from bank_account ;

select * from project;
select * from persons_projects;
select * from phone_number;
