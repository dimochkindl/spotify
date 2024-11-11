CREATE DATABASE spotik;

\c spotik

CREATE TABLE IF NOT EXISTS playlist
(
    id serial PRIMARY KEY,
    name character varying(100) NOT NULL,
    duration character varying(8),
    number_of_tracks integer,
    number_of_plays integer
);

CREATE TABLE IF NOT EXISTS album
(
    id serial PRIMARY KEY,
    title character varying(250) NOT NULL,
    number_of_tracks integer,
    number_of_plays integer,
    duration character varying(8),
    type character varying(30)
);

CREATE TABLE IF NOT EXISTS music
(
    id serial PRIMARY KEY,
    title character varying(255) NOT NULL,
    duration character varying(8),
    number_of_plays integer,
    genre character varying(100),
    lyrics_url character varying(255),
    playlist_id integer,
    CONSTRAINT fk_playlist FOREIGN KEY (playlist_id) REFERENCES playlist(id)
);

CREATE TABLE IF NOT EXISTS app_user
(
    id serial PRIMARY KEY,
    username character varying(100) NOT NULL,
    password character varying(10) NOT NULL,
    email character varying(255) NOT NULL,
    CONSTRAINT user_username_key UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS artist
(
    id serial PRIMARY KEY,
    nickname character varying(255) NOT NULL,
    listeners integer,
    CONSTRAINT artist_nickname_key UNIQUE (nickname)
);

CREATE TABLE IF NOT EXISTS artist_music
(
    id serial PRIMARY KEY,
    artist_id integer,
    music_id integer,
    album_id integer,
    creation_date date,
    CONSTRAINT fk_artist FOREIGN KEY (artist_id) REFERENCES artist (id),
    CONSTRAINT fk_album FOREIGN KEY (album_id) REFERENCES album (id),
    CONSTRAINT fk_music FOREIGN KEY (music_id) REFERENCES music (id)
);

CREATE TABLE IF NOT EXISTS user_playlist
(
    id serial PRIMARY KEY,
    user_id integer,
    playlist_id integer,
    creation_date date,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES app_user (id),
    CONSTRAINT fk_playlist FOREIGN KEY (playlist_id) REFERENCES playlist (id)
);