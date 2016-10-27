CREATE TABLE authority (
  id integer NOT NULL PRIMARY KEY,
  role varchar(255) NOT NULL UNIQUE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 CREATE TABLE pelaaja (
  username varchar(100) NOT NULL PRIMARY KEY,
  password_encrypted varchar(255) NOT NULL,
  enabled tinyint NOT NULL,
  name varchar(100) NOT NULL,
  pisteet int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE pelaaja_authority (
  id integer NOT NULL auto_increment PRIMARY KEY,
  pelaaja_username varchar(100) NOT NULL,
  authority_id integer NOT NULL,
  FOREIGN KEY (pelaaja_username) REFERENCES pelaaja(username) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE peli (
	id integer NOT NULL auto_increment PRIMARY KEY,
	pelaaja1 varchar(100) NOT NULL,
	pelaaja2 varchar(100) NOT NULL,
	pvm varchar(15) not null,
	voittaja varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO authority VALUES
(1,'ROLE_USER'),
(2,'ROLE_ADMIN');

INSERT INTO pelaaja (username, password_encrypted, enabled, name) VALUES
('admin1','5e49ff9b1a2c5e7ef98bfe0215c6e3ba4d21181ffc236f42021ba50dde945c73008f6d77f3d4e7ba',1,'Admin Henkilo');
	
INSERT INTO pelaaja_authority (pelaaja_username, authority_id) VALUES ('admin1', 2);


Tavalliset käyttäjät:
testaaja (testisala)
karvonen (karvonen)
sulkapallo (sulkapallonen)
peluri (pelurimies)

Admin:
admin1 (adminsala)

