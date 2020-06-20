-- USER


--DROP TABLE if exists USERS
-- cascade;

-- DROP TABLE if exists USER cascade;
-- ALTER TABLE USER DROP COLUMN DTYPE;
-- CREATE TABLE [USER];

INSERT INTO USERS
    (username, password, firstname, surname, phone_number, email, date_of_birth, role, active)
VALUES
    ('pero', 'pero123', 'Petar', 'Petrovic', '+381 63 963 854', 'pero@test.com', '01.01.1999', 'admin', TRUE);
INSERT INTO USERS
    (username, password, firstname, surname, phone_number, email, date_of_birth, role, active)
VALUES
    ('mare', 'mare123', 'Marko', 'Markovic', '+381 63 234 612', 'mare@test.com', '01.01.1999', 'manager', TRUE);
INSERT INTO USERS
    (username, password, firstname, surname, phone_number, email, date_of_birth, ROLE, active)
VALUES
    ('djoka', 'djoka123', 'Djordje', 'Djurendic', '+381 63 333 183', 'djoka@test.com', '01.01.1999', 'viewer', TRUE);



-- CINEMA

INSERT INTO CINEMA
    (name, address, phone_number, email
    )
VALUES
    ('Cineplexx', 'Trg Dositeja Obradovića 6', '+381 60 123 4567', 'cineplexx@test.com');
INSERT INTO CINEMA
    (name, address, phone_number, email
    )
VALUES
    ('Cinestar', 'BIG', '+381 69 876 5432', 'cinestar@test.com');


-- AUDITORIUM
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (120, 'A1', 1);
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (140, 'A2', 2);
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (20, 'B1', 1);
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (50, 'B2', 2);



-- MOVIE


INSERT INTO MOVIE
    (name, description, genre, duration, grade)
VALUES
    ('Random title', 'Random desc lalal', 'action', 150, 8.8);
INSERT INTO MOVIE
    (name, description, genre, duration, grade)
VALUES
    ('Random title2', 'Random desc lalal2', 'comedy', 100, 4.7);
INSERT INTO MOVIE
    (name, description, genre, duration, grade)
VALUES
    ('Random title3', 'Random desc lalal3', 'action', 110, 9.8);
INSERT INTO MOVIE
    (name, description, genre, duration, grade)
VALUES
    ('Random title4', 'Random desc lalal4', 'drama', 159, 8.1);
INSERT INTO MOVIE
    (name, description, genre, duration, grade)
VALUES
    ('Random title5', 'Random desc lalal5', 'drama', 210, 2.5);

--! PROJECTION (single)
INSERT INTO PROJECTION
    (day, time, price, movie_id)
VALUES
    (TO_DATE('07.05.2020.','DD.MM.YYY.'), '20:00', 300, 1);


--! PROJECTIONS (THIS IS CONNECTION )
INSERT INTO PROJECTIONS
    (auditorium_id, projection_id)
VALUES(1, 1);
