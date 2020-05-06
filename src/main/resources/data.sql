-- CINEMA
INSERT INTO CINEMA
    (name, address, phoneNumber, email)
VALUES
    ('Cineplexx', 'Trg Dositeja Obradovića 6', "+381 60 123 4567", "cineplexx@test.com");
INSERT INTO CINEMA
    (name, address, phoneNumber, email)
VALUES
    ('Cinestar', 'BIG', "+381 69 876 5432", "cinestar@test.com");


-- AUDITORIUM
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (120, "A1", 1);
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (140, "A2", 2);
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (20, "B1", 1);
INSERT INTO AUDITORIUM
    (capacity, label, cinema_id)
VALUES
    (50, "B2", 2);

-- VIEWER
INSERT INTO VIEWER
    (username, password, name, surname, phoneNumber, email, dateOfBirth, role, active)
VALUES
    ("pero", "pero123", "Petar", "Petrovic", "+381 63 963 854", "pero@test.com", TO_DATE('01.01.1999', 'DD.MM.YYYY.'), "viewer", true)
INSERT INTO VIEWER
    (username, password, name, surname, phoneNumber, email, dateOfBirth, role, active)
VALUES
    ("mare", "mare123", "Marko", "Markovic", "+381 63 111 224", "mare@test.com", TO_DATE('03.11.1983', 'DD.MM.YYYY.'), "viewer", false)


-- MOVIE
INSERT INTO MOVIE
    (name, description, genre, duration, grade)
VALUES
    ("Random title", "Random desc lalal", "action", 150, 8.8)


--! PROJECTION (single)
INSERT INTO PROJECTION
    (day, time, price, movie_id)
VALUES
    (TO_DATE('07.05.2020.',
"DD.MM.YYY."), '20
:00', 400)

--! PROJECTIONS (THIS IS CONNECTION )
INSERT INTO PROJECTIONS
    (auditorium_id, projection_id)
VALUES(1, 1)

