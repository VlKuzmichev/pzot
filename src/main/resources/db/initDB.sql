DROP TABLE IF EXISTS student_groups;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_groups;
DROP TABLE IF EXISTS groups;
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
    full_name        VARCHAR                 NOT NULL,
    user_group_id    INTEGER                 NOT NULL,
    FOREIGN KEY (user_group_id) REFERENCES user_groups (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX users_unique_name_idx ON users (name);

CREATE TABLE user_roles
(
    user_id          INTEGER                 NOT NULL,
    role             VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE groups
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX group_unique_name_idx ON groups (name);

CREATE TABLE student_groups
(
    user_id          INTEGER                 NOT NULL,
    group_id          INTEGER                 NOT NULL,
    CONSTRAINT student_groups_idx UNIQUE (user_id, group_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (group_id) REFERENCES groups (id)
);
