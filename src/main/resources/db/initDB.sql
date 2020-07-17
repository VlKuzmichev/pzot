DROP TABLE IF EXISTS results_answers;
DROP TABLE IF EXISTS results_questions;
DROP TABLE IF EXISTS results_tests;
DROP TABLE IF EXISTS results_users;
DROP TABLE IF EXISTS results;
DROP TABLE IF EXISTS tests_questions;
DROP TABLE IF EXISTS tests_users;
DROP TABLE IF EXISTS test_statuses;
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

CREATE TABLE user_group_users (
    group_id int references user_groups(id),
    user_id int references users(id),
    CONSTRAINT user_group_users_idx UNIQUE (group_id, user_id),
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
    name              VARCHAR                 NOT NULL,
    question_group_id INTEGER                 NOT NULL,
    FOREIGN KEY (question_group_id) REFERENCES question_groups (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX question_unique_name_idx ON questions (name);

CREATE TABLE answers
(
    id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name              VARCHAR                 NOT NULL,
    truth             BOOL DEFAULT FALSE      NOT NULL,
    question_id       INTEGER                 NOT NULL,
    FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);

CREATE TABLE tests
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR                 NOT NULL,
    start_date       TIMESTAMP               NULL,
    end_date         TIMESTAMP               NULL
);
CREATE UNIQUE INDEX test_unique_name_idx ON tests (name);

CREATE TABLE tests_questions (
    test_id int references tests(id),
    question_id int references questions(id),
    CONSTRAINT tests_questions_idx UNIQUE (test_id, question_id),
    primary key (test_id, question_id)
--     FOREIGN KEY (test_id) REFERENCES tests (id) ON DELETE CASCADE,
--     FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);

CREATE TABLE tests_users (
    test_id int references tests(id),
    user_id int references users(id),
    CONSTRAINT tests_users_idx UNIQUE (test_id, user_id),
    primary key (test_id, user_id)
--     FOREIGN KEY (test_id) REFERENCES tests (id),
--     FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE test_statuses
(
    status           VARCHAR,
    test_id          INTEGER                 NOT NULL,
    CONSTRAINT test_statuses_idx UNIQUE (status, test_id),
    FOREIGN KEY (test_id) REFERENCES tests (id) ON DELETE CASCADE
);

CREATE TABLE results
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    answer_date      TIMESTAMP               NOT NULL
);

CREATE TABLE results_users (
                             result_id int references results(id),
                             user_id int references users(id),
                             CONSTRAINT results_users_idx UNIQUE (result_id, user_id),
                             primary key (result_id, user_id)
);

CREATE TABLE results_tests (
                               result_id int references results(id),
                               test_id int references tests(id),
                               CONSTRAINT results_tests_idx UNIQUE (result_id, test_id),
                               primary key (result_id, test_id)
);

CREATE TABLE results_questions (
                               result_id int references results(id),
                               question_id int references questions(id),
                               CONSTRAINT results_questions_idx UNIQUE (result_id, question_id),
                               primary key (result_id, question_id)
);

CREATE TABLE results_answers (
                                   result_id int references results(id),
                                   answer_id int references answers(id),
                                   CONSTRAINT results_answers_idx UNIQUE (result_id, answer_id),
                                   primary key (result_id, answer_id)
);
