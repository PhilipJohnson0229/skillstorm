-- DROP TABLE users;
-- DROP TABLE authorities;
-- DROP TABLE store;
-- DROP TABLE category;
-- DROP TABLE item;

-- tables / DDL
create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);

-- "role"  USER, ADMIN. "authority" ROLE_USER, ROLE_ADMIN
create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

-- store
create table store (
	id INT,
	Name VARCHAR(50),
	location VARCHAR(50)
);

-- category
create table category (
	id INT,
	Name VARCHAR(50),
	description VARCHAR(50)
);

-- item
create table item (
	id INT,
	Name VARCHAR(50),
	price DECIMAL(4,1),
	store_id INT,
    category_id INT
);