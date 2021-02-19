DROP DATABASE IF EXISTS testnovae;

CREATE DATABASE IF NOT EXISTS testnovae
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


DROP TABLE public.credit_card;


CREATE TABLE public.credit_card
(
    id bigint NOT NULL,
    card_holder_name character varying(255) COLLATE pg_catalog."default",
    card_number character varying(255) COLLATE pg_catalog."default",
    billing_address character varying(255) COLLATE pg_catalog."default",
    expired_date timestamp without time zone,
    cvv character varying(255) COLLATE pg_catalog."default",
    mark_number character varying(255) COLLATE pg_catalog."default",
    creation_date timestamp without time zone,
    CONSTRAINT credit_card_pkey PRIMARY KEY (id)
)

CREATE SEQUENCE public.credit_card_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.credit_card_sequence
    OWNER TO postgres;

TABLESPACE pg_default;

ALTER TABLE public.credit_card
    OWNER to postgres;