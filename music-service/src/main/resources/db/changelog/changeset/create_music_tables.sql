create schema if not exists spotik;

create table if not exists spotik.music
(
    id int primary key,
    title varchar (255) not null,
    duration varchar (8),
    number_of_plays int,
    genre varchar(100),
    lyrics_url varchar(255)
);

create table if not exists spotik.author
(
    id int primary key,
    nickname varchar (255) not null unique,
    listeners int
);

create table if not exists spotik.album
(
    id int primary key,
    title varchar(250) not null,
    number_of_tracks int,
    number_of_plays int,
    duration varchar(8),
    creation_date date,
    type varchar(30)
);

create table if not exists spotik.author_lyrics
(
    id int primary key,
    song_id int,
    author_id int,
    album_id int,
    foreign key (song_id) references spotik.music(id),
    foreign key (author_id) references spotik.author(id),
    foreign key (album_id) references spotik.album(id)
);