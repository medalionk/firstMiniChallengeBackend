UPDATE attraction SET `country`='Italy', `latitude`='41,890251', `longitude`='12,492373', `location_name`='Rome', `state`='Lazio' WHERE `id`='100';



INSERT INTO attraction (id, about, latitude, longitude, `name`, location_name, state, country )
VALUES ('100', 'A beautiful Place', 41.890251, 12.492373, 'Vongu', 'Rome', 'Lazio', 'Italy');
INSERT INTO attraction (id, about, latitude, longitude, `name`, location_name, state, country )
VALUES ('101', 'A beautiful Place', 43.32215, 11.3259, 'Vongu', 'Siena', 'Tuscany', 'Italy');
INSERT INTO attraction (id, about, latitude, longitude, `name`, location_name, state, country )
VALUES ('102', 'A beautiful Place', 43.769562, 11.255814, 'Vongu', 'Florence', 'Tuscany', 'Italy');
INSERT INTO attraction (id, about, latitude, longitude, `name`, location_name, state, country )
VALUES ('103', 'A beautiful Place', 43.70853, 10.4036, 'Vongu', 'Pisa', 'Tuscany', 'Italy');
INSERT INTO attraction (id, about, latitude, longitude, `name`, location_name, state, country )
VALUES ('104', 'A beautiful Place', 40.853294, 14.305573, 'Vongu', 'Naples', 'Campania', 'Italy');

INSERT INTO images (id, image)
VALUES ('100', 'https://mrwallpaper.com/wp-content/uploads/Colosseum-Rome-1920x1080.jpg');
INSERT INTO images (id, image)
VALUES ('101', 'http://architectureimg.com/wp-content/uploads/2017/02/houses-siena-italy-houses-old-city-cities-house-town-italia-hd-pictures.jpg');
INSERT INTO images (id, image)
VALUES ('102', 'https://mrwallpaper.com/wp-content/uploads/Colosseum-Rome-1920x1080.jpg');
INSERT INTO images (id, image)
VALUES ('103', 'https://mrwallpaper.com/wp-content/uploads/Colosseum-Rome-1920x1080.jpg');
INSERT INTO images (id, image)
VALUES ('104', 'https://mrwallpaper.com/wp-content/uploads/Colosseum-Rome-1920x1080.jpg');

INSERT INTO client (id, city, country, street, zip_code, email, first_name, last_name, password, phone)
VALUES ('200', 'Naples', 'Italy', 'Marceto', '51009', 'a@b.c', 'Mattin', 'Abj', 'werttr', '56655555');


INSERT INTO booking (amount, currency, label, end_date, start_date, client_id)
VALUES ('12', 'EUR', '12.0', '2018/1/9', '2018/1/10', '200');

