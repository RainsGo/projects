--DROP DATABASE IF EXISTS sampledb;
--CREATE DATABASE sampledb DEFAULT CHARACTER SET utf8;
--USE sampledb;

--drop table if exists User;
--drop table if exists LoginLog;

create table if not exists User (
    id int primary key auto_increment,
    username varchar(255) default null,
    password varchar(255) default null,
    age int(8)
);

create table if not exists LoginLog (
    id int primary key auto_increment,
    userId int default null,
    longIp varchar(255) default null,
    longDate date default null
);
