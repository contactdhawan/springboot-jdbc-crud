create table person
(
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);

insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(1001, 'NEERAJ', 'BLM',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(1002, 'SARIKA', 'BLM',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(1003, 'ANIRUDH', 'BLM',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(1004, 'NEERAJ', 'BLM',sysdate());