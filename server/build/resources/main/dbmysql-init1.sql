drop table if exists User;
drop table if exists LoginLog;

create table city (id int primary key auto_increment, username varchar, state varchar, country varchar);

create table User (id int primary key auto_increment, username varchar, password varchar, age varchar)
create table LoginLog (id int primary key auto_increment, userId int, loginIp varchar, loginDate date);

insert into User (username, password, age) values ('test', '123456', '11');
insert into LoginLog(userId, loginIp, loginDate) values (1, '127.0.0.1', '2017-07-20')