DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, password, email, full_name) VALUES
('User', 'password', 'user@yandex.ru', 'Ivanov Ivan Ivanovich'), -- 100004
('Editor', 'password2', 'exam@yandex.ru', 'Petrov Peter Petrovich'), -- 100005
('Admin', 'password3', 'admin@yandex.ru', 'Adminov Admin Adminovich'); -- 100006
-- ('User', '{noop}password', 'user@yandex.ru', 'Ivanov Ivan Ivanovich'), -- 100004
-- ('Exam', '{noop}password2', 'exam@yandex.ru', 'Petrov Peter Petrovich'), -- 100005
-- ('Admin', '{noop}password3', 'admin@yandex.ru', 'Adminov Admin Adminovich'); -- 100006


INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
        ('ROLE_EDITOR', 100001),
       ('ROLE_EDITOR', 100000),
       ('ROLE_ADMIN', 100002);
-- VALUES ('ROLE_USER', 100004),
--        ('ROLE_EXAMINER', 100005),
--        ('ROLE_ADMIN', 100006);
