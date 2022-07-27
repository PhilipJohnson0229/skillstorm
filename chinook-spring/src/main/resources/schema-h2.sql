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

create table Track (
	TrackId INT auto_increment,
	Name VARCHAR(50),
	AlbumId INT,
	MediaTypeId INT,
	GenreId INT,
	Composer VARCHAR(50),
	Milliseconds INT,
	Bytes INT,
	UnitPrice DECIMAL(5,2)
);