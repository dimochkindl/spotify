
create database spotik;

CREATE TABLE IF NOT EXISTS subscription
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    price real,
    description character varying(500) COLLATE pg_catalog."default",
    CONSTRAINT subscription_pkey PRIMARY KEY (id)
);

INSERT INTO subscription (id, name, price, description) VALUES
                                                                   (1, 'Basic Plan', 9.99, 'A basic subscription plan with limited features'),
                                                                   (2, 'Standard Plan', 19.99, 'A standard subscription plan with more features'),
                                                                   (3, 'Premium Plan', 29.99, 'A premium subscription plan with advanced features'),
                                                                   (4, 'Enterprise Plan', 49.99, 'An enterprise-level subscription plan with custom features');

CREATE TABLE IF NOT EXISTS music
(
    id integer NOT NULL,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    duration character varying(8) COLLATE pg_catalog."default",
    number_of_plays integer,
    genre character varying(100) COLLATE pg_catalog."default",
    lyrics_url character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT music_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS album
(
    id integer NOT NULL,
    title character varying(250) COLLATE pg_catalog."default" NOT NULL,
    number_of_tracks integer,
    number_of_plays integer,
    duration character varying(8) COLLATE pg_catalog."default",
    creation_date date,
    type character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT album_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "user"
(
    id integer NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(10) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    subscription_id integer,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_username_key UNIQUE (username),
    CONSTRAINT user_subscription_id_fkey FOREIGN KEY (subscription_id)
        REFERENCES subscription (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS admin
(
    id integer NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(10) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    registration_date date,
    subscription_id integer,
    CONSTRAINT admin_pkey PRIMARY KEY (id),
    CONSTRAINT admin_username_key UNIQUE (username),
    CONSTRAINT admin_subscription_id_fkey FOREIGN KEY (subscription_id)
        REFERENCES subscription (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


CREATE TABLE IF NOT EXISTS artist_user
(
    id integer NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(10) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    info character varying(500) COLLATE pg_catalog."default",
    genre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    subscription_id integer,
    CONSTRAINT artist_user_pkey PRIMARY KEY (id),
    CONSTRAINT artist_user_username_key UNIQUE (username),
    CONSTRAINT artist_user_subscription_id_fkey FOREIGN KEY (subscription_id)
    REFERENCES subscription (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS author
(
    id integer NOT NULL,
    nickname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    listeners integer,
    CONSTRAINT author_pkey PRIMARY KEY (id),
    CONSTRAINT author_nickname_key UNIQUE (nickname)
);


CREATE TABLE IF NOT EXISTS playlist
(
    id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    duration character varying(8) COLLATE pg_catalog."default",
    creator character varying(100) COLLATE pg_catalog."default" NOT NULL,
    creation_date date,
    number_of_tracks integer,
    number_of_plays integer,
    CONSTRAINT playlist_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS author_lyrics
(
    id integer NOT NULL,
    song_id integer,
    author_id integer,
    album_id integer,
    CONSTRAINT author_lyrics_pkey PRIMARY KEY (id),
    CONSTRAINT author_lyrics_album_id_fkey FOREIGN KEY (album_id)
    REFERENCES album (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT author_lyrics_author_id_fkey FOREIGN KEY (author_id)
    REFERENCES author (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT author_lyrics_song_id_fkey FOREIGN KEY (song_id)
    REFERENCES music (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);