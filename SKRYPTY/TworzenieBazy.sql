--INFORMATOR KLUBOWY
--TWORZENIE APLIKACJI BAZODANOWYCH 2017
--KAROL NOWICKI
--MICHAL SOKOL

--czyszczenie bazy
DROP TRIGGER liga_trigger;
DROP TRIGGER klub_trigger;
DROP TRIGGER budynek_trigger;
DROP TRIGGER czlonek_zarzadu_trigger;
DROP TRIGGER sekcja_trigger;
DROP TRIGGER druzyna_trigger;
DROP TRIGGER sezon_trigger;
DROP TRIGGER zawodnik_trigger;

DROP SEQUENCE liga_sequence;
DROP SEQUENCE klub_sequence;
DROP SEQUENCE budynek_sequence;
DROP SEQUENCE czlonek_zarzadu_sequence;
DROP SEQUENCE sekcja_sequence;
DROP SEQUENCE druzyna_sequence;
DROP SEQUENCE sezon_sequence;
DROP SEQUENCE zawodnik_sequence;

DROP TABLE zawodnik_statystyki;
DROP TABLE kontrakt;
DROP TABLE zawodnik;
DROP TABLE sezon;
DROP TABLE druzyna;
DROP TABLE sekcja;
DROP TABLE czlonek_zarzadu;
DROP TABLE budynek;
DROP TABLE klub;
DROP TABLE liga;

--tworzenie bazy
CREATE TABLE liga(id_liga NUMBER PRIMARY KEY, nazwa VARCHAR2(20) NOT NULL, kraj VARCHAR2(20) NOT NULL);

CREATE TABLE klub(id_klub NUMBER PRIMARY KEY, nazwa VARCHAR2(20)NOT NULL, logo BLOB);

CREATE TABLE budynek(id_budynek NUMBER PRIMARY KEY, id_klub NUMBER, kod_pocztowy VARCHAR2(6),miejscowosc VARCHAR2(20),ulicanumer VARCHAR2(20),funkcja VARCHAR2(50));
ALTER TABLE budynek ADD FOREIGN KEY(id_klub) REFERENCES Klub(Id_klub) ON DELETE CASCADE;

CREATE TABLE czlonek_zarzadu(id_czlonek NUMBER PRIMARY KEY,id_klub NUMBER NOT NULL,imie VARCHAR2(20), nazwisko VARCHAR2(50),stanowisko VARCHAR2(20),pensja NUMBER);
ALTER TABLE czlonek_zarzadu ADD FOREIGN KEY(id_klub)REFERENCES klub(id_klub) ON DELETE CASCADE;

CREATE TABLE sekcja (id_sekcja NUMBER PRIMARY KEY,id_klub NUMBER NOT NULL,dyscyplina VARCHAR2(20),plec VARCHAR2(1));
ALTER TABLE sekcja ADD FOREIGN KEY(id_klub) REFERENCES klub(id_klub) ON DELETE CASCADE;
ALTER TABLE sekcja ADD CHECK (plec='m' OR plec='M' OR plec ='k' OR plec='K');

CREATE TABLE druzyna(id_druzyna NUMBER PRIMARY KEY,id_sekcja NUMBER NOT NULL,id_liga NUMBER NOT NULL,nazwa VARCHAR2(20));
ALTER TABLE druzyna ADD FOREIGN KEY(id_sekcja) REFERENCES sekcja(id_sekcja) ON DELETE CASCADE;
ALTER TABLE druzyna ADD FOREIGN KEY(id_liga) REFERENCES liga(id_liga) ;

CREATE TABLE sezon(id_sezon NUMBER PRIMARY KEY, rok NUMBER(4) NOT NULL);

CREATE TABLE zawodnik (id_zawodnik NUMBER PRIMARY KEY,imie VARCHAR2(20),nazwisko VARCHAR2(50),data_urodzenia DATE,wzrost NUMBER(3),waga NUMBER(3));

CREATE TABLE kontrakt (id_zawodnik NUMBER,id_druzyna NUMBER, poczatek_kontraktu DATE, koniec_kontraktu DATE,pensja NUMBER, wartosc_rynkowa NUMBER);
ALTER TABLE kontrakt ADD FOREIGN KEY(id_zawodnik) REFERENCES zawodnik(id_zawodnik);
ALTER TABLE kontrakt ADD FOREIGN KEY(id_druzyna) REFERENCES druzyna(id_druzyna);
ALTER TABLE kontrakt ADD PRIMARY KEY(id_zawodnik, id_druzyna);

CREATE TABLE zawodnik_statystyki( id_zawodnik NUMBER,id_sezon NUMBER NOT NULL, strzelone_bramki NUMBER(3), stracone_bramki NUMBER(3), zolte_kartki NUMBER(3),czerwone_kartki NUMBER(3), faule NUMBER(3),rozegrane_minuty NUMBER);
ALTER TABLE zawodnik_statystyki ADD FOREIGN KEY(id_zawodnik) REFERENCES zawodnik(id_zawodnik);
ALTER TABLE zawodnik_statystyki ADD FOREIGN KEY(id_sezon) REFERENCES sezon(id_sezon) ON DELETE CASCADE;
ALTER TABLE zawodnik_statystyki ADD PRIMARY KEY(id_zawodnik,id_sezon);

--tworzenie sekwencji
CREATE SEQUENCE liga_sequence;
CREATE SEQUENCE klub_sequence;
CREATE SEQUENCE budynek_sequence;
CREATE SEQUENCE czlonek_zarzadu_sequence;
CREATE SEQUENCE sekcja_sequence;
CREATE SEQUENCE druzyna_sequence;
CREATE SEQUENCE sezon_sequence;
CREATE SEQUENCE zawodnik_sequence;

--tworzenie triggerow
CREATE OR REPLACE TRIGGER liga_trigger 
BEFORE INSERT ON liga FOR EACH ROW
BEGIN
  SELECT liga_sequence.NEXTVAL INTO :new.id_liga FROM dual;
END;
/

CREATE OR REPLACE TRIGGER klub_trigger 
BEFORE INSERT ON klub FOR EACH ROW
BEGIN
  SELECT klub_sequence.NEXTVAL INTO :new.id_klub FROM dual;
END;
/

CREATE OR REPLACE TRIGGER budynek_trigger 
BEFORE INSERT ON budynek FOR EACH ROW
BEGIN
  SELECT budynek_sequence.NEXTVAL INTO :new.id_budynek FROM dual;
END;
/

CREATE OR REPLACE TRIGGER czlonek_zarzadu_trigger 
BEFORE INSERT ON czlonek_zarzadu FOR EACH ROW
BEGIN
  SELECT czlonek_zarzadu_sequence.NEXTVAL INTO :new.id_czlonek FROM dual;
END;
/

CREATE OR REPLACE TRIGGER sekcja_trigger 
BEFORE INSERT ON sekcja FOR EACH ROW
BEGIN
  SELECT sekcja_sequence.NEXTVAL INTO :new.id_sekcja FROM dual;
END;
/

CREATE OR REPLACE TRIGGER druzyna_trigger 
BEFORE INSERT ON druzyna FOR EACH ROW
BEGIN
  SELECT druzyna_sequence.NEXTVAL INTO :new.id_druzyna FROM dual;
END;
/

CREATE OR REPLACE TRIGGER sezon_trigger 
BEFORE INSERT ON sezon FOR EACH ROW
BEGIN
  SELECT sezon_sequence.NEXTVAL INTO :new.id_sezon FROM dual;
END;
/

CREATE OR REPLACE TRIGGER zawodnik_trigger 
BEFORE INSERT ON zawodnik FOR EACH ROW
BEGIN
  SELECT zawodnik_sequence.NEXTVAL INTO :new.id_zawodnik FROM dual;
END;
/

