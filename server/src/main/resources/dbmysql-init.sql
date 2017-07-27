--drop table if exists t_users;
--drop table if exists t_roles;
--drop table if exists t_user_role;
--drop table if exists t_logs_auth;

create table if not exists t_users (
    id varchar(32) not null unique,
    username varchar(32) not null,
    password varchar(32) not null,
    age int(8) unsigned,
    email varchar(32) default null,
    last_reset_password_date date not null,
    primary key (id)
)engine=InnoDB default charset=utf8;

create table if not exists t_roles (
    id varchar(32) not null unique,
    name varchar(32) not null,
    enable boolean not null,
    primary key (id)
)engine=InnoDB default charset=utf8;

create table if not exists t_user_role (
    id varchar(32) not null unique,
    user_id varchar(32) not null,
    role_id varchar(32) not null,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES t_users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES t_roles(id) ON DELETE CASCADE ON UPDATE CASCADE
)engine=InnoDB default charset=utf8;

create table if not exists t_permissions (
    id varchar(32) not null unique,
    name varchar(32) not null,
    primary key (id),
)engine=InnoDB default charset=utf8;

create table if not exists t_role_permission (
    id varchar(32) not null unique,
    role_id varchar(32) not null,
    permission_id varchar(32) not null,
    primary key (id),
    FOREIGN KEY (permission_id) REFERENCES t_permission(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES t_roles(id) ON DELETE CASCADE ON UPDATE CASCADE
)engine=InnoDB default charset=utf8;

create table if not exists t_logs_auth (
    id varchar(32) not null unique,
    user_id varchar(32) default null,
    long_ip varchar(32) default null,
    long_date datetime default null,
    primary key (id),
)engine=InnoDB default charset=utf8;
