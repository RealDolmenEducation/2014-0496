insert into book(title, author, isbn) values('Nineteen Eighty Four', 'George Orwell', '0000000001');
insert into book(title, author, isbn) values('Alice''s Adventures In Wonderland', 'Lewis Carroll', '0000000002');

insert into passengers(firstName, lastName, socialSecurityNumber, dateOfBirth, street, number, city, postalCode) values('Janis', 'Joplin', '00002', '1948-01-23', 'Kattenberg', '15', 'Grimbergen', '1874');
insert into passenger_details(lastName, socialSecurityNumber, picture, frequentFlyerMiles) values('Joplin', '00002', x'1A2B3C4D5E6F', 5000);

insert into ticket(price, passenger_lastName, passenger_socialSecurityNumber) values(240.53, 'Joplin', '00002');