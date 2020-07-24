DELETE FROM results;
DELETE FROM tests_users;
DELETE FROM tests_questions;
DELETE FROM test_statuses;
DELETE FROM tests;
DELETE FROM answers;
DELETE FROM questions;
DELETE FROM question_groups;
DELETE FROM user_group_users;
DELETE FROM user_roles;
DELETE FROM user_groups;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO user_groups (name)
VALUES ('All'), -- 100000
       ('St mechaniks'), -- 100001
       ('Mechaniks'), -- 100002
       ('Specialists'); -- 100003

INSERT INTO users (name, password, email, full_name) VALUES
('User', 'password', 'user@yandex.ru', 'Ivanov Ivan Ivanovich'), -- 100004
('Exam', 'password2', 'exam@yandex.ru', 'Petrov Peter Petrovich'), -- 100005
('Admin', 'password3', 'admin@yandex.ru', 'Adminov Admin Adminovich'); -- 100006

INSERT INTO user_group_users (group_id, user_id)
VALUES (100000, 100004),
       (100000, 100005),
       (100000, 100006);

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100004),
       ('ROLE_EXAMINER', 100005),
       ('ROLE_ADMIN', 100006);

INSERT INTO question_groups (name)
VALUES ('VOPROSY PO OT'),                  -- 100007
       ('VOPROSY PO ELEKTROBEZOPASNOSTY'); -- 100008

INSERT INTO questions (name, question_group_id) VALUES
('При какой численности работников в организации должна обязательно создаваться служба охраны труда?', 100007), -- 100009
('Какие меры по оказанию первой помощи пострадавшему необходимо предпринять при обморожении?', 100007); -- 100010

INSERT INTO answers (name, truth, question_id) VALUES
('Более 50 человек', true, 100009), -- 100011
('Более 30 человек', false, 100009), -- 100012
('Более 15 человек', false, 100009), -- 100013
('Более 20 человек', false, 100009), -- 100014
('Прекратить воздействие низких температур, восстановить кровообращение, наложив теплоизолирующие повязки, дать обезболивающее' ||
 ' и любое теплое питье, доставить в лечебное учреждение', true, 100010), -- 100015
('Прекратить воздействие низких температур, быстро растереть отмороженные участки, наложить сухую стерильную повязку, ' ||
 'дать обильное питье и обезболивающее', false, 100010), -- 100016
('Прекратить воздействие низких температур, поместив пострадавшего к источникам тепла (печи или камину), сменить одежду ' ||
 'влажную на сухую, дать обезболивающее и любое теплое питье', false, 100010), -- 100017
('Пострадавшего поместить в ванну с горячей водой или уложить возле электронагревателя', false, 100010); -- 100018

INSERT INTO tests (name, start_date, end_date)
VALUES ('TEST1', '2020-04-10 10:00:00', '2020-04-11 10:00:00'), -- 100019
       ('TEST2', '2020-04-11 10:00:00', '2020-04-12 10:00:00'); -- 100020

INSERT INTO test_statuses (status, test_id)
VALUES ('INACTIVE', 100019),
       ('INACTIVE', 100020);

INSERT INTO tests_questions (test_id, question_id)
VALUES (100019, 100009),
       (100020, 100010);

INSERT INTO tests_users (test_id, user_id)
VALUES (100019, 100004),
       (100019, 100005),
       (100020, 100004);

INSERT INTO results (answer_date, user_id, test_id, question_id, answer_id)
VALUES ('2020-04-10 10:00:00', 100004, 100019, 100009, 100012); -- 100021
