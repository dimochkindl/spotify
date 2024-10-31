create database spotik;

CREATE TABLE IF NOT EXISTS playlist
(
    id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    duration character varying(8) COLLATE pg_catalog."default",
    number_of_tracks integer,
    number_of_plays integer,
    CONSTRAINT pk_playlist PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS album
(
    id integer NOT NULL,
    title character varying(250) COLLATE pg_catalog."default" NOT NULL,
    number_of_tracks integer,
    number_of_plays integer,
    duration character varying(8) COLLATE pg_catalog."default",
    type character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT pk_album PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS music
(
    id integer NOT NULL,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    duration character varying(8) COLLATE pg_catalog."default",
    number_of_plays integer,
    genre character varying(100) COLLATE pg_catalog."default",
    lyrics_url character varying(255) COLLATE pg_catalog."default",
    playlist_id integer,
    CONSTRAINT pk_music PRIMARY KEY (id),
    constraint fk_playlist foreign key (playlist_id) references playlist(id)
);

CREATE TABLE IF NOT EXISTS "user"
(
    id integer NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(10) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT user_username_key UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS artist
(
    id integer NOT NULL,
    nickname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    listeners integer,
    CONSTRAINT pk_artist PRIMARY KEY (id),
    CONSTRAINT artist_nickname_key UNIQUE (nickname)
);

create table if not exists artist_music
(
    id integer,
    artist_id integer,
    music_id integer,
    album_id integer,
    creation_date date,
    constraint pk_artist_music primary key (id),
    constraint fk_artist foreign key (artist_id) references artist (id),
    constraint fk_album foreign key (album_id) references album (id),
    constraint fk_music foreign key (music_id) references music (id)
);

create table if not exists user_playlist
(
    id integer,
    user_id integer,
    playlist_id integer,
    creation_date date,
    constraint pk_user_playlist primary key (id),
    constraint fk_user foreign key (user_id) references "user" (id),
    constraint fk_playlist foreign key (playlist_id) references playlist (id)
);