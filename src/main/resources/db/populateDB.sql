DELETE FROM student_groups;
DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM user_groups;
DELETE FROM groups;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO groups (name) VALUES
('Группа 01'), -- 100000
('Группа 02'), -- 100001
('Группа 03'); -- 100002

INSERT INTO user_groups (name) VALUES
('НАЧАЛЬНИКИ УЧАСТКА'), -- 100003
('СТАРШИЕ ЭЛЕКТРОМЕХАНИКИ'), -- 100004
('ЭЛЕКТРОМЕХАНИКИ'), -- 100005
('СПЕЦИАЛИСТЫ'); -- 100006

INSERT INTO users (name, password, email, full_name, user_group_id) VALUES
('User', '$2a$10$Sx1rY0BSqQhunZaDxDyfd.nwymYvZ6Pvx3D30tyUtztLotT/qX9ey', 'user@yandex.ru', 'Ivanov Ivan Ivanovich', 100005), -- 100004
('Exam', '$2a$10$l9Qo3zfKn7UZmC6L7gu8P..vZY4.TLKXFJTSGHukvWtobBK2tN52e', 'exam@yandex.ru', 'Petrov Peter Petrovich', 100006), -- 100005
('Admin', '$2a$10$r8M0vqxK67p.094hxUqAVe9vMEkM6dPs67kGigFhpxXUICSfFYa3S', 'admin@yandex.ru', 'Adminov Admin Adminovich', 100006); -- 100006
-- password
-- password2
-- password3

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100007),
        ('ROLE_USER', 100008),
       ('ROLE_EXAMINER', 100008),
       ('ROLE_ADMIN', 100009);

INSERT INTO student_groups (group_id, user_id)
VALUES (100000, 100007),
       (100000, 100008),
       (100001, 100009);
