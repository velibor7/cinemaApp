-- USER
INSERT INTO USER
    (user_type, active, date_of_birth, email, firstname, password, phone_number, position, surname, username)
VALUES
    (1, TRUE, '01.01.1990', 'pero@test.com', 'Pero', 'pero123', '+381 64 5432 332', 'viewer', 'Peric', 'pero');
INSERT INTO USER
    (user_type, active, date_of_birth, email, firstname, password, phone_number, position, surname, username)
VALUES
    (2, TRUE, '01.01.1990', 'menadjer1@test.com', 'Menadjer', 'menadjer123', '+381 64 5432 332', 'manager', 'Menadjerovic', 'menadjer1');
INSERT INTO USER
    (user_type, active, date_of_birth, email, firstname, password, phone_number, position, surname, username)
VALUES
    (3, TRUE, '01.01.1990', 'admin1@test.com', 'Admin', 'admin123', '+381 64 5432 332', 'admin', 'Adminkovic', 'admin1');

-- CINEMA

INSERT INTO CINEMA
    (name, address, phone_number, email, manager_id)
VALUES
    ('Cineplexx', 'Trg Dositeja Obradovića 6', '+381 60 123 4567', 'cineplexx@test.com', 2);
INSERT INTO CINEMA
    (name, address, phone_number, email, manager_id)
VALUES
    ('Cinestar', 'BIG', '+381 69 876 5432', 'cinestar@test.com', 2);


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
    (day, time, price, movie_id, cinema_id)
VALUES
    ('07.05.2020.', '20:00', 300, 1, 2);


    -- ! ovde nisam siguran za date

--! PROJECTIONS (THIS IS CONNECTION )
INSERT INTO PROJECTIONS (auditorium_id, projection_id) VALUES(2, 1);

INSERT INTO MOVIES_WATCHED (viewer_id, movie_id) VALUES (1, 1);

INSERT INTO MOVIES_RESERVED (viewer_id, movie_id) VALUES (1,2);