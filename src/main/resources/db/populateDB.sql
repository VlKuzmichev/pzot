DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM user_groups;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO user_groups (name) VALUES
('НАЧАЛЬНИКИ УЧАСТКА'), -- 100000
('СТАРШИЕ ЭЛЕКТРОМЕХАНИКИ'), -- 100001
('ЭЛЕКТРОМЕХАНИКИ'), -- 100002
('СПЕЦИАЛИСТЫ'); -- 100003

INSERT INTO users (name, password, email, full_name, user_group_id) VALUES
('User', 'password', 'user@yandex.ru', 'Ivanov Ivan Ivanovich', 100002), -- 100004
('Exam', 'password2', 'exam@yandex.ru', 'Petrov Peter Petrovich', 100003), -- 100005
('Admin', 'password3', 'admin@yandex.ru', 'Adminov Admin Adminovich', 100003); -- 100006
-- ('User', '{noop}password', 'user@yandex.ru', 'Ivanov Ivan Ivanovich'), -- 100004
-- ('Exam', '{noop}password2', 'exam@yandex.ru', 'Petrov Peter Petrovich'), -- 100005
-- ('Admin', '{noop}password3', 'admin@yandex.ru', 'Adminov Admin Adminovich'); -- 100006


INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100004),
        ('ROLE_USER', 100005),
       ('ROLE_EXAMINER', 100005),
       ('ROLE_ADMIN', 100006);
