create schema if not exists spotik;

create table if not exists spotik.subscription
(
    id int primary key,
    name varchar (255),
    price real,
    description varchar (500)
    );

create table if not exists spotik.user
(
    id int primary key,
    username varchar (100) unique not null,
    password varchar (10) not null,
    email varchar (255) not null,
    subscription_id int,
    foreign key (subscription_id) references spotik.subscription
);

create table if not exists spotik.playlist
(
    id int primary key,
    name varchar (100) not null,
    duration varchar (8),
    creator varchar(100) not null,
    creation_date date,
    number_of_tracks int,
    number_of_plays int
);

create table if not exists spotik.artist_user
(
    id int primary key,
    username varchar (100) unique not null,
    password varchar (10) not null,
    email varchar (255) not null,
    info varchar (500),
    genre varchar(255) not null,
    subscription_id int,
    foreign key (subscription_id) references spotik.subscription
);

create table if not exists spotik.admin
(
    id int primary key,
    username varchar (100) unique not null,
    password varchar (10) not null,
    email varchar (255) not null,
    registration_date date,
    subscription_id int,
    foreign key (subscription_id) references spotik.subscription
    );

