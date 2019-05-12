CREATE TABLE public."Hello"
(
    "Id" integer NOT NULL,
    "Name" character varying(200),
    PRIMARY KEY ("Id")
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public."Hello"
    OWNER to "AscProAdmin";