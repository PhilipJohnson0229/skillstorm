-- tables / DDL

create table Artist (
	ArtistId INT auto_increment,
	Name VARCHAR(50)
);

create table Album (
	AlbumId INT auto_increment,
	Title VARCHAR(50),
	ArtistId INT
);
