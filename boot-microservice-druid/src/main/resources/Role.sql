create table Role(
	id varchar(255) not null PRIMARY KEY,
	name varchar(255)
);

create table User(
	id varchar(255) not null PRIMARY KEY,
	username varchar(255),
	password varchar(255)
);