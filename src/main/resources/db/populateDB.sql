DELETE FROM user_group_users;
DELETE FROM user_roles;
DELETE FROM user_groups;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO user_groups (name) VALUES
('All'),
('St mechaniks'),
('Mechaniks'),
('Specialists');

INSERT INTO users (name, password, email, full_name) VALUES
  ('User', 'password', 'user@yandex.ru', 'Ivanov Ivan Ivanovich'),
  ('Exam', 'password2', 'exam@yandex.ru', 'Petrov Peter Petrovich'),
  ('Admin', 'password3', 'admin@yandex.ru', 'Adminov Admin Adminovich');

INSERT INTO user_group_users (group_id, user_id) VALUES
(100000, 100004),
(100000, 100005),
(100000, 100006);


INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100004),
  ('ROLE_EXAMINER', 100005),
  ('ROLE_ADMIN', 100006);
