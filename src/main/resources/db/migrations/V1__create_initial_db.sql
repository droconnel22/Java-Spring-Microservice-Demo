-- Table: public.hello

-- DROP TABLE public.hello;

CREATE TABLE public.hello
(
    id integer NOT NULL,
    created_on timestamp without time zone NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT hello_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hello
    OWNER to "AscProAdmin";



-- Table: public.gratitude_list

-- DROP TABLE public.gratitude_list;

CREATE TABLE public.gratitude_list
(
    id integer NOT NULL,
    category character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    reason character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    hello_id integer,
    CONSTRAINT gratitude_list_pkey PRIMARY KEY (id),
    CONSTRAINT fkjnh38pe6er8qglhi71403jk7l FOREIGN KEY (hello_id)
        REFERENCES public.hello (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.gratitude_list
    OWNER to "AscProAdmin";