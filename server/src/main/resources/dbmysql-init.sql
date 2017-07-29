
--drop table if exists t_user_role;
--drop table if exists t_role_permission;
--drop table if exists t_logs_auth;
--drop table if exists t_users;
--drop table if exists t_roles;
--drop table if exists t_permissions;

create table if not exists t_users (
    id varchar(32) not null unique,
    username varchar(32) not null unique,
    password varchar(255) not null,
    age int(8) unsigned,
    email varchar(32) default null unique,
    last_password_reset_date timestamp not null,
    primary key (id)
)engine=InnoDB default charset=utf8;

create table if not exists t_roles (
    name varchar(32) not null unique,
    enable boolean not null,
    primary key (name)
)engine=InnoDB default charset=utf8;

create table if not exists t_permissions (
    name varchar(32) not null unique,
    primary key (name)
)engine=InnoDB default charset=utf8;

create table if not exists t_user_role (
    id varchar(32) not null unique,
    user_id varchar(32) not null,
    role_name varchar(32) not null,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES t_users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_name) REFERENCES t_roles(name) ON DELETE CASCADE ON UPDATE CASCADE
)engine=InnoDB default charset=utf8;

create table if not exists t_role_permission (
    id varchar(32) not null unique,
    role_name varchar(32) not null,
    permission_name varchar(32) not null,
    primary key (id),
    FOREIGN KEY (permission_name) REFERENCES t_permissions(name) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_name) REFERENCES t_roles(name) ON DELETE CASCADE ON UPDATE CASCADE
)engine=InnoDB default charset=utf8;

create table if not exists t_logs_auth (
    id varchar(32) not null unique,
    user_id varchar(32) default null,
    login_ip varchar(32) default null,
    login_date datetime default null,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES t_users(id) ON DELETE CASCADE ON UPDATE CASCADE
)engine=InnoDB default charset=utf8;


--insert into User (username, password, age) values ('test', '123456', '11');
--insert into LoginLog(userId, loginIp, loginDate) values (1, '127.0.0.1', '2017-07-20')
