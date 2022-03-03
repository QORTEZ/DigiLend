CREATE TABLE IF NOT EXISTS "roles" (
    "id"  BIGINT ,
    "name" VARCHAR(120) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO "roles" VALUES
    (1,'ROLE_CUSTOMER'),
    (2,'ROLE_ADMIN') ON CONFLICT (id) DO NOTHING;
