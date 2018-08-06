CREATE SCHEMA access;

DROP SEQUENCE IF EXISTS roles_seq_pk CASCADE;
CREATE SEQUENCE roles_seq_pk
INCREMENT BY 1
MINVALUE 0
MAXVALUE 2147483647
START WITH 1
CACHE 1
NO CYCLE;
CREATE TABLE IF NOT EXISTS access.roles (
  role_id BIGINT NOT NULL DEFAULT nextval('roles_seq_pk'),
  role VARCHAR(50) NOT NULL,
  CONSTRAINT  role_pk PRIMARY KEY (role_id),
  CONSTRAINT role_unique UNIQUE (role)
);

DROP SEQUENCE IF EXISTS groups_seq_pk CASCADE;
CREATE SEQUENCE groups_seq_pk
INCREMENT BY 1
MINVALUE 0
MAXVALUE 2147483647
START WITH 1
CACHE 1
NO CYCLE;
CREATE TABLE IF NOT EXISTS access.groups (
  group_id BIGINT NOT NULL DEFAULT nextval('groups_seq_pk'),
  name TEXT NOT NULL,
  CONSTRAINT group_pk PRIMARY KEY (group_id),
  CONSTRAINT name_uq UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS access.role_groups(
  group_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  CONSTRAINT group_fk FOREIGN KEY (group_id) REFERENCES access.groups(group_id),
  CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES access.roles(role_id),
  CONSTRAINT role_groups_pk PRIMARY KEY (group_id, role_id)
);

DROP SEQUENCE IF EXISTS users_seq_pk CASCADE;
CREATE SEQUENCE users_seq_pk
INCREMENT BY 1
MINVALUE 0
MAXVALUE 2147483647
START WITH 1
CACHE 1
NO CYCLE;
CREATE TABLE IF NOT EXISTS access.users (
  user_id BIGINT NOT NULL DEFAULT nextval('users_seq_pk'),
  login VARCHAR(50) NOT NULL,
  password VARCHAR(250) NOT NULL,
  enabled  BOOLEAN NOT NULL,
  CONSTRAINT  user_pk PRIMARY KEY (user_id),
  CONSTRAINT login_unique UNIQUE (login)
);

CREATE TABLE IF NOT EXISTS access.user_groups (
  user_id BIGINT NOT NULL,
  group_id BIGINT NOT NULL,
  CONSTRAINT user_groups_pk PRIMARY KEY (user_id, group_id),
  CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES access.users(user_id),
  CONSTRAINT group_pk FOREIGN KEY (group_id) REFERENCES access.groups(group_id)
);


