DROP TABLE IF EXISTS tests;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions CASCADE;
DROP TABLE IF EXISTS question_groups;
DROP TABLE IF EXISTS user_group_users;
DROP TABLE IF EXISTS user_groups;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE user_groups
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX user_group_unique_name_idx ON user_groups (name);

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  full_name        VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX users_unique_name_idx ON users (name);
--CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_group_users (
  group_id int references user_groups(id),
  user_id int references users(id),
  CONSTRAINT user_group_users_idx UNIQUE (group_id, user_id),
--  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
  primary key (group_id, user_id)
);

CREATE TABLE user_roles
(
  user_id          INTEGER                 NOT NULL,
  role             VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE question_groups
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX question_group_unique_name_idx ON question_groups (name);

CREATE TABLE questions
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    text              VARCHAR                 NOT NULL,
    right_answers     INTEGER DEFAULT 1       NOT NULL
);
CREATE UNIQUE INDEX question_unique_name_idx ON questions (text);

CREATE TABLE answers
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  text              VARCHAR                 NOT NULL,
  truth             BOOL DEFAULT FALSE      NOT NULL,
  question_id       INTEGER                 NOT NULL,
  FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);

CREATE TABLE tests
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX test_unique_name_idx ON tests (name);
