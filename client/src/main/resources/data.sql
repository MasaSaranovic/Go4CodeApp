use db_restoran;

insert into kategorija (naziv) values ('Pizza');
insert into kategorija (naziv) values ('Sendvic');
insert into kategorija (naziv) values ('Pasta');
insert into kategorija (naziv) values ('Gazirani sok');
insert into kategorija (naziv) values ('Negazirani sok');
insert into kategorija (naziv) values ('Salata');
insert into kategorija (naziv) values ('Predjelo');

insert into stavka (naziv, cena, kategorija_id) values ('Capricosa', '58952', 1);
insert into stavka (naziv, cena, kategorija_id) values ('Pepperoni', '8636', 1);
insert into stavka (naziv, cena, kategorija_id) values ('Sendvic sa prsutom', '100', 2);
insert into stavka (naziv, cena, kategorija_id) values ('Karbonara', '8677', 3);
insert into stavka (naziv, cena, kategorija_id) values ('Penne napolitana', '500', 3);


insert into korisnik (ime, prezime, email, sifra) values ('Masa', 'Saranovic', 'masasaran@gmail.com', 'masas');
insert into korisnik (ime, prezime, email, sifra) values ('Darko', 'Dulic', 'darkodulic@gmail.com', 'darkod');
insert into korisnik (ime, prezime, email, sifra) values ('Vlado', 'Saranovic', 'saran.vlado@gmail.com', 'vlados');
insert into korisnik (ime, prezime, email, sifra) values ('Tijana', 'Smajic', 'tijana.smajic00@gmail.com', 'tijanas');
insert into korisnik (ime, prezime, email, sifra) values ('Selena', 'Delcev', 'seldel@gmail.com', 'selenad');
insert into korisnik (ime, prezime, email, sifra) values ('Kristina', 'Tadic', 'tadickris@gmail.com', 'kristinat');
insert into korisnik (ime, prezime, email, sifra) values ('Maja', 'Jukic', 'maja.jukic@gmail.com', 'majaj');