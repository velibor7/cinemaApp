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


-- USER

ALTER TABLE USER DROP COLUMN DTYPE;

INSERT INTO USER
    (username, password, name, surname, phone_number, email, date_of_birth, role, active)
VALUES
    ('pero', 'pero123', 'Petar', 'Petrovic', '+381 63 963 854', 'pero@test.com', '01.01.1999', 'admin', TRUE);

INSERT INTO USER
    (username, password, name, surname, phone_number, email, date_of_birth, role, active)
VALUES
    ('mare', 'mare123', 'Marko', 'Markovic', '+381 63 234 612', 'mare@test.com', '01.01.1999', 'manager', TRUE);
INSERT INTO USER
    (username, password, name, surname, phone_number, email, date_of_birth, role, active)
VALUES
    ('djoka', 'djoka123', 'Djordje', 'Djurendic', '+381 63 333 183', 'djoka@test.com', '01.01.1999', 'viewer', TRUE);

-- MOVIE


INSERT INTO MOVIE
    (name, description, genre, duration, grade)
VALUES
    ('Random title', 'Random desc lalal', 'action', 150, 8.8);

--! PROJECTION (single)
INSERT INTO PROJECTION
    (day, time, price, movie_id)
VALUES
    (TO_DATE('07.05.2020.','DD.MM.YYY.'), '20:00', 300, 1);


--! PROJECTIONS (THIS IS CONNECTION )
INSERT INTO PROJECTIONS
    (auditorium_id, projection_id)
VALUES(1, 1);
