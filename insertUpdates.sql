
insert into mydb.user values (1001,'Jon','Test','jon,test@testing.com','1999-03-30',2000,3000);
insert into mydb.user values(1002,'Bill','tester','btester@testing.com','1978-10-19',2001,null);
insert into mydb.property values(202,now(),'19132 leig ln',1001,5,2,2,3000,'single family home');
insert into mydb.propertyfeature values(202,'f1',202);
insert into mydb.address values(101,19132,'leigh','tx','USA',78660,202);
insert into mydb.city values(2,'New York',101,202);
insert into mydb.clientwish values(3000,'f1');
insert into mydb.feature values('f1','pool',3000,202);
insert into mydb.client values(1002,1000000,1002,1003,1004,1005);
insert into mydb.agent values(2001);
insert into mydb.state values(4,'Texas',101,202);
insert into mydb.visit values(501,2000,3000,now(),202,2000);
insert into mydb.propertyforent values (202,2500,now(),202);
UPDATE mydb.agent SET `id` = 2000 WHERE (`id` = '1000');
select * from mydb.agent;
delete from user where 'id' = 1001;
select * from mydb.address,mydb.agent,mydb.city,mydb.clientwish,mydb.property,mydb.propertyfeature,mydb.propertyforent,
mydb.user;

