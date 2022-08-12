

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
	Description VARCHAR(50)
);

-- item
create table item (
	id INT,
	Name VARCHAR(50),
	price DECIMAL(4,1),
	store_id INT,
    category_id INT
);