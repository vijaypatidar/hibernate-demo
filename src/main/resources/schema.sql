use hibernate;

create table users(
  username varchar(50) not null,
  first_name varchar(50),
  last_name varchar(50),
  create_at date,
primary key(username)
);

create table user_roles(
  role_id int not null auto_increment,
  username varchar(50) not null,
  role varchar(50) not null,
  foreign key (username) references users(username),
primary key(role_id ,
role)
);

create table country(
  country_id bigint not null auto_increment,
  country_name varchar(50) not null ,
  country_code varchar (3) not null ,
primary key(country_id)
);

create table state(
	state_id bigint not null auto_increment,
country_id bigint not null,
	state_name varchar(50) not null ,
	state_code varchar (3) not null ,
	primary key(state_id),
foreign key(country_id) references country(country_id)
);

create table city(
	city_id bigint not null auto_increment,
state_id bigint not null,
	city_name varchar(50) not null ,
	primary key(city_id),
foreign key(state_id) references state (state_id)
);
