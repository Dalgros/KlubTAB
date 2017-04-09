--INFORMATOR KLUBOWY
--TWORZENIE APLIKACJI BAZODANOWYCH 2017
--KAROL NOWICKI
--MICHAL SOKOL

--dodawanie zawodników
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Boguslaw', 'Linda',TO_DATE('21-06-88','DD-MM-YY'),188,90);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Marek', 'Kaczmarski',TO_DATE('01-12-89','DD-MM-YY'),171,67);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Józef', 'Beck',TO_DATE('13-11-90','DD-MM-YY'),190,88);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Adam', 'Batory',TO_DATE('11-11-94','DD-MM-YY'),188,71);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Julian', 'Krynski',TO_DATE('24-03-97','DD-MM-YY'),177,69);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Amdeusz', 'Snarsky',TO_DATE('25-07-95','DD-MM-YY'),183,79);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Sebastian', 'Roszkowski',TO_DATE('16-05-93','DD-MM-YY'),176,78);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Adam', 'Stefaniak',TO_DATE('27-10-91','DD-MM-YY'),186,73);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Izabela', 'Jurkiewicz',TO_DATE('15-05-94','DD-MM-YY'),179,68);
INSERT INTO zawodnik (imie ,nazwisko,data_urodzenia,wzrost,waga) VALUES('Malgorzata', 'Fracala',TO_DATE('20-01-90','DD-MM-YY'),169,65);

--dodawanie sezonów
INSERT INTO sezon (rok) VALUES (2015);
INSERT INTO sezon (rok) VALUES (2016);
INSERT INTO sezon (rok) VALUES (2017);

--dodanie statystyk
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(1,1,51,13,0,5,3,191);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(1,2,83,78,6,7,2,145);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(1,3,56,42,7,8,9,685);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(2,1,72,35,1,5,4,697);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(2,2,11,32,9,4,7,699);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(2,3,14,89,7,4,0,916);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(3,1,14,21,3,2,3,816);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(3,2,60,42,7,5,8,524);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(3,3,51,6,2,8,5,550);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(4,1,14,12,8,7,4,813);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(4,2,49,54,3,0,8,601);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(4,3,17,97,0,3,8,899);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(5,1,6,29,0,1,6,685);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(5,2,72,79,0,6,6,696);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(5,3,1,77,5,3,2,720);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(6,1,88,1,2,6,6,863);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(6,2,63,70,1,6,4,419);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(6,3,34,0,8,2,4,712);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(7,1,28,40,8,5,2,871);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(7,2,44,80,5,1,1,844);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(7,3,12,6,1,3,3,911);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(8,1,34,29,6,6,6,51);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(8,2,63,73,7,0,2,840);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(8,3,10,84,6,1,4,778);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(9,1,40,59,3,5,4,480);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(9,2,30,65,8,9,2,154);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(9,3,58,57,5,6,3,108);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(10,1,0,63,6,3,4,103);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(10,2,15,42,1,6,6,379);
INSERT INTO zawodnik_statystyki(id_zawodnik,id_sezon,strzelone_bramki,stracone_bramki,zolte_kartki,czerwone_kartki,faule,rozegrane_minuty)
VALUES(10,3,27,30,1,0,4,870);

--dodawnie Klubu
INSERT INTO Klub (nazwa,logo)
VALUES('Orly',NULL);
INSERT INTO Klub (nazwa,logo)
VALUES('FC Bialystok',NULL);
INSERT INTO Klub (nazwa,logo)
VALUES('Real Ostroleka',NULL);

--dodawanie Budynku
INSERT INTO Budynek(id_klub,kod_pocztowy,miejscowosc,UlicaNumer,Funkcja)
VALUES(1,'21-371','Lomza','Pogodna 12','Biuro');
INSERT INTO Budynek(id_klub,kod_pocztowy,miejscowosc,UlicaNumer,Funkcja)
VALUES(1,'21-371','Lomza','Ciepla 1','Boisko');
INSERT INTO Budynek(id_klub,kod_pocztowy,miejscowosc,UlicaNumer,Funkcja)
VALUES(2,'18-211','Bialystok','Plazowa 102','Biuro');
INSERT INTO Budynek(id_klub,kod_pocztowy,miejscowosc,UlicaNumer,Funkcja)
VALUES(2,'18-215','Bialystok','Mila 2','Hala sportowa');
INSERT INTO Budynek(id_klub,kod_pocztowy,miejscowosc,UlicaNumer,Funkcja)
VALUES(3,'25-291','Ostroleka','Zabia 67','Biuro');
INSERT INTO Budynek(id_klub,kod_pocztowy,miejscowosc,UlicaNumer,Funkcja)
VALUES(3,'25-615','Wyszkow','Biala 37','Hala widowiskowo-sportowa');

--dodawanie czlonkow zarzadu
INSERT INTO czlonek_zarzadu(id_klub,imie,nazwisko,stanowisko,pensja)
VALUES (1,'Pawel','Bogacz','Prezes','5000');
INSERT INTO czlonek_zarzadu(id_klub,imie,nazwisko,stanowisko,pensja)
VALUES (2,'Michal','Frankowski','Skarbnik','2000');
INSERT INTO czlonek_zarzadu(id_klub,imie,nazwisko,stanowisko,pensja)
VALUES (2,'Malgorzata','Filipiak','Prezes','4000');
INSERT INTO czlonek_zarzadu(id_klub,imie,nazwisko,stanowisko,pensja)
VALUES (3,'Aleksander','Macedonski','Prezes','3500');

--dodawanie sekcji
INSERT INTO Sekcja (id_klub,dyscyplina,plec)
VALUES (1,'Pilka nozna','m');
INSERT INTO Sekcja (id_klub,dyscyplina,plec)
VALUES (1,'Pilka siatkowa','k');
INSERT INTO Sekcja (id_klub,dyscyplina,plec)
VALUES (2,'Pilka nozna','m');
INSERT INTO Sekcja (id_klub,dyscyplina,plec)
VALUES (3,'Pilka halowa','m');

--dodawanie lig
INSERT INTO Liga(nazwa,kraj)
VALUES('Pilka Nozna Mezczyzn','Polska');
INSERT INTO Liga(nazwa,kraj)
VALUES('Pilka Halowa Meska','Polska');
INSERT INTO Liga(nazwa,kraj)
VALUES('Siatkowka Kobiet','Polska');

--dodawanie druzyn
INSERT INTO druzyna(id_sekcja,id_liga,nazwa)
VALUES(1,1,'Smack Ziemniaka');
INSERT INTO druzyna(id_sekcja,id_liga,nazwa)
VALUES(2,3,'Gwardia');
INSERT INTO druzyna(id_sekcja,id_liga,nazwa)
VALUES(3,1,'Maczka Kostna');
INSERT INTO druzyna(id_sekcja,id_liga,nazwa)
VALUES(4,2,'Rzucanka');
-- dodanie kontraktów
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(1,1,TO_DATE('27-10-15','DD-MM-YY'),TO_DATE('27-10-17','DD-MM-YY'),30000,500000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(2,3,TO_DATE('27-10-16','DD-MM-YY'),TO_DATE('27-10-17','DD-MM-YY'),2000,40000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(3,4,TO_DATE('22-11-15','DD-MM-YY'),TO_DATE('12-01-17','DD-MM-YY'),1000,5000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(4,1,TO_DATE('27-10-16','DD-MM-YY'),TO_DATE('27-10-18','DD-MM-YY'),30000,800000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(5,1,TO_DATE('27-01-17','DD-MM-YY'),TO_DATE('27-10-17','DD-MM-YY'),3000,65000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(6,4,TO_DATE('11-05-11','DD-MM-YY'),TO_DATE('09-05-17','DD-MM-YY'),21000,370000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(7,3,TO_DATE('06-06-14','DD-MM-YY'),TO_DATE('11-03-17','DD-MM-YY'),4000,10000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(8,1,TO_DATE('3-12-16','DD-MM-YY'),TO_DATE('11-12-17','DD-MM-YY'),8000,70000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(9,2,TO_DATE('08-08-08','DD-MM-YY'),TO_DATE('11-10-20','DD-MM-YY'),1600,60000);
INSERT INTO Kontrakt(id_zawodnik,id_druzyna,poczatek_kontraktu,koniec_kontraktu,pensja,wartosc_rynkowa)
VALUES(10,2,TO_DATE('15-04-10','DD-MM-YY'),TO_DATE('21-08-21','DD-MM-YY'),2100,66000);
