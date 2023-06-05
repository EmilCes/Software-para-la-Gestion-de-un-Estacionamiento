#CREATE USER 'proyectoSGE'@'localhost' IDENTIFIED BY 'chanclas321?';
#GRANT ALL PRIVILEGES ON * . * TO 'proyectoSGE'@'localhost';
#FLUSH PRIVILEGES;

CREATE DATABASE SGE;
USE SGE;
#DROP DATABASE SGE;

CREATE TABLE Tarjetas (
	IDTarjeta INT AUTO_INCREMENT,
    PRIMARY KEY(IDTarjeta),
    estado NVARCHAR(15),
	IDFechaHoraTarjeta INT,
    IDCajon INT
);

CREATE TABLE FechaHorasTarjetas (
	IDFechaHoraTarjeta INT AUTO_INCREMENT,
    PRIMARY KEY(IDFechaHoraTarjeta),
	fechaHoraEntrada DATETIME NOT NULL,
	fechaHoraSalida DATETIME,
    IDTarjeta INT NOT NULL
);

CREATE TABLE Cajones (
	IDCajon INT AUTO_INCREMENT,
    PRIMARY KEY(IDCajon),
    numeroCajon INT NOT NULL,
    piso INT NOT NULL,
    tipoVehiculo NVARCHAR(10) NOT NULL,
    IDTarjeta INT NOT NULL
);

CREATE TABLE Precios (
	IDPrecio INT AUTO_INCREMENT,
    PRIMARY KEY(IDPrecio),
    precioHoraNormalCarro DOUBLE NOT NULL,
    precioHoraEspecialCarro DOUBLE NOT NULL,
    precioHoraNormalMoto DOUBLE NOT NULL,
    precioHoraEspecialMoto DOUBLE NOT NULL,
    precioTarjetaDañada DOUBLE NOT NULL,
    precioTarjetaExtraviada DOUBLE NOT NULL
);

CREATE TABLE Usuarios (
	IDUsuario INT AUTO_INCREMENT,
	PRIMARY KEY(IDUsuario),
    nombreUsuario NVARCHAR(30),
    contraseña NVARCHAR(20)
);

#CONSTRAINTS
ALTER TABLE Tarjetas ADD CONSTRAINT FK_Tarjeta_FechaHoraTarjeta FOREIGN KEY(IDFechaHoraTarjeta) REFERENCES FechaHorasTarjetas(IDFechaHoraTarjeta) ON DELETE CASCADE;
ALTER TABLE Tarjetas ADD CONSTRAINT FK_Tarjeta_Cajon FOREIGN KEY(IDCajon) REFERENCES Cajones(IDCajon) ON DELETE CASCADE;

ALTER TABLE FechaHorasTarjetas ADD CONSTRAINT FK_FechaHora_Tarjeta FOREIGN KEY(IDTarjeta) REFERENCES Tarjetas(IDTarjeta) ON DELETE CASCADE;

ALTER TABLE Cajones ADD CONSTRAINT FK_Cajon_Tarjeta FOREIGN KEY(IDTarjeta) REFERENCES Tarjetas(IDTarjeta) ON DELETE CASCADE;


INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');
INSERT INTO Tarjetas (estado) VALUES ('Disponible');


INSERT INTO Cajones (numeroCajon, piso, tipoVehiculo, IDTarjeta)
VALUES 
  (1, 1, 'Automovil', 1),
  (2, 1, 'Automovil', 2),
  (3, 1, 'Automovil', 3),
  (4, 1, 'Automovil', 4),
  (5, 1, 'Automovil', 5),
  (6, 1, 'Automovil', 6),
  (7, 1, 'Automovil', 7),
  (8, 1, 'Automovil', 8),
  (9, 1, 'Automovil', 9),
  (10, 1, 'Automovil', 10),
  (11, 1, 'Automovil', 11),
  (12, 1, 'Automovil', 12),
  (13, 1, 'Automovil', 13),
  (14, 1, 'Automovil', 14),
  (15, 1, 'Automovil', 15),
  (16, 1, 'Automovil', 16),
  (17, 1, 'Automovil', 17),
  (18, 1, 'Automovil', 18),
  (19, 1, 'Automovil', 19),
  (20, 1, 'Automovil', 20),
  (21, 1, 'Automovil', 21),
  (22, 1, 'Automovil', 22),
  (23, 1, 'Automovil', 23),
  (24, 1, 'Automovil', 24),
  (25, 1, 'Automovil', 25),
  (26, 1, 'Automovil', 26),
  (27, 1, 'Automovil', 27),
  (28, 1, 'Automovil', 28),
  (29, 1, 'Automovil', 29),
  (30, 1, 'Automovil', 30),
  (31, 1, 'Automovil', 31),
  (32, 1, 'Automovil', 32),
  (33, 1, 'Automovil', 33),
  (34, 1, 'Automovil', 34),
  (35, 1, 'Automovil', 35),
  (36, 1, 'Automovil', 36),
  (37, 1, 'Automovil', 37),
  (38, 1, 'Automovil', 38),
  (39, 1, 'Automovil', 39),
  (40, 1, 'Automovil', 40),
  (41, 1, 'Automovil', 41),
  (42, 1, 'Automovil', 42),
  (43, 1, 'Automovil', 43),
  (44, 1, 'Automovil', 44),
  (45, 1, 'Automovil', 45),
  (46, 1, 'Automovil', 46),
  (47, 1, 'Automovil', 47),
  (48, 1, 'Automovil', 48),
  (49, 1, 'Automovil', 49),
  (50, 1, 'Automovil', 50);
  
INSERT INTO Cajones (numeroCajon, piso, tipoVehiculo, IDTarjeta)
VALUES 
  (1, 2, 'Automovil', 51),
  (2, 2, 'Automovil', 52),
  (3, 2, 'Automovil', 53),
  (4, 2, 'Automovil', 54),
  (5, 2, 'Automovil', 55),
  (6, 2, 'Automovil', 56),
  (7, 2, 'Automovil', 57),
  (8, 2, 'Automovil', 58),
  (9, 2, 'Automovil', 59),
  (10, 2, 'Automovil', 60),
  (11, 2, 'Automovil', 61),
  (12, 2, 'Automovil', 62),
  (13, 2, 'Automovil', 63),
  (14, 2, 'Automovil', 64),
  (15, 2, 'Automovil', 65),
  (16, 2, 'Automovil', 66),
  (17, 2, 'Automovil', 67),
  (18, 2, 'Automovil', 68),
  (19, 2, 'Automovil', 69),
  (20, 2, 'Automovil', 70),
  (21, 2, 'Automovil', 71),
  (22, 2, 'Automovil', 72),
  (23, 2, 'Automovil', 73),
  (24, 2, 'Automovil', 74),
  (25, 2, 'Automovil', 75),
  (26, 2, 'Automovil', 76),
  (27, 2, 'Automovil', 77),
  (28, 2, 'Automovil', 78),
  (29, 2, 'Automovil', 79),
  (30, 2, 'Automovil', 80),
  (31, 2, 'Automovil', 81),
  (32, 2, 'Automovil', 82),
  (33, 2, 'Automovil', 83),
  (34, 2, 'Automovil', 84),
  (35, 2, 'Automovil', 85),
  (36, 2, 'Automovil', 86),
  (37, 2, 'Automovil', 87),
  (38, 2, 'Automovil', 88),
  (39, 2, 'Automovil', 89),
  (40, 2, 'Automovil', 90),
  (41, 2, 'Automovil', 91),
  (42, 2, 'Automovil', 92),
  (43, 2, 'Automovil', 93),
  (44, 2, 'Automovil', 94),
  (45, 2, 'Automovil', 95),
  (46, 2, 'Automovil', 96),
  (47, 2, 'Automovil', 97),
  (48, 2, 'Automovil', 98),
  (49, 2, 'Automovil', 99),
  (50, 2, 'Automovil', 100);

INSERT INTO Cajones (numeroCajon, piso, tipoVehiculo, IDTarjeta)
VALUES 
  (1, 3, 'Automovil', 101),
  (2, 3, 'Automovil', 102),
  (3, 3, 'Automovil', 103),
  (4, 3, 'Automovil', 104),
  (5, 3, 'Automovil', 105),
  (6, 3, 'Automovil', 106),
  (7, 3, 'Automovil', 107),
  (8, 3, 'Automovil', 108),
  (9, 3, 'Automovil', 109),
  (10, 3, 'Automovil', 110),
  (11, 3, 'Automovil', 111),
  (12, 3, 'Automovil', 112),
  (13, 3, 'Automovil', 113),
  (14, 3, 'Automovil', 114),
  (15, 3, 'Automovil', 115),
  (16, 3, 'Automovil', 116),
  (17, 3, 'Automovil', 117),
  (18, 3, 'Automovil', 118),
  (19, 3, 'Automovil', 119),
  (20, 3, 'Automovil', 120),
  (21, 3, 'Automovil', 121),
  (22, 3, 'Automovil', 122),
  (23, 3, 'Automovil', 123),
  (24, 3, 'Automovil', 124),
  (25, 3, 'Automovil', 125),
  (26, 3, 'Automovil', 126),
  (27, 3, 'Automovil', 127),
  (28, 3, 'Automovil', 128),
  (29, 3, 'Automovil', 129),
  (30, 3, 'Automovil', 130),
  (31, 3, 'Automovil', 131),
  (32, 3, 'Automovil', 132),
  (33, 3, 'Automovil', 133),
  (34, 3, 'Automovil', 134),
  (35, 3, 'Automovil', 135),
  (36, 3, 'Automovil', 136),
  (37, 3, 'Automovil', 137),
  (38, 3, 'Automovil', 138),
  (39, 3, 'Automovil', 139),
  (40, 3, 'Automovil', 140),
  (41, 3, 'Automovil', 141),
  (42, 3, 'Automovil', 142),
  (43, 3, 'Automovil', 143),
  (44, 3, 'Automovil', 144),
  (45, 3, 'Automovil', 145),
  (46, 3, 'Automovil', 146),
  (47, 3, 'Automovil', 147),
  (48, 3, 'Automovil', 148),
  (49, 3, 'Automovil', 149),
  (50, 3, 'Automovil', 150);

INSERT INTO Cajones (numeroCajon, piso, tipoVehiculo, IDTarjeta)
VALUES 
  (1, 4, 'Automovil', 151),
  (2, 4, 'Automovil', 152),
  (3, 4, 'Automovil', 153),
  (4, 4, 'Automovil', 154),
  (5, 4, 'Automovil', 155),
  (6, 4, 'Automovil', 156),
  (7, 4, 'Automovil', 157),
  (8, 4, 'Automovil', 158),
  (9, 4, 'Automovil', 159),
  (10, 4, 'Automovil', 160),
  (11, 4, 'Automovil', 161),
  (12, 4, 'Automovil', 162),
  (13, 4, 'Automovil', 163),
  (14, 4, 'Automovil', 164),
  (15, 4, 'Automovil', 165),
  (16, 4, 'Automovil', 166),
  (17, 4, 'Automovil', 167),
  (18, 4, 'Automovil', 168),
  (19, 4, 'Automovil', 169),
  (20, 4, 'Automovil', 170),
  (21, 4, 'Automovil', 171),
  (22, 4, 'Automovil', 172),
  (23, 4, 'Automovil', 173),
  (24, 4, 'Automovil', 174),
  (25, 4, 'Automovil', 175),
  (26, 4, 'Automovil', 176),
  (27, 4, 'Automovil', 177),
  (28, 4, 'Automovil', 178),
  (29, 4, 'Automovil', 179),
  (30, 4, 'Automovil', 180),
  (31, 4, 'Automovil', 181),
  (32, 4, 'Automovil', 182),
  (33, 4, 'Automovil', 183),
  (34, 4, 'Automovil', 184),
  (35, 4, 'Automovil', 185),
  (36, 4, 'Automovil', 186),
  (37, 4, 'Automovil', 187),
  (38, 4, 'Automovil', 188),
  (39, 4, 'Automovil', 189),
  (40, 4, 'Automovil', 190),
  (41, 4, 'Automovil', 191),
  (42, 4, 'Automovil', 192),
  (43, 4, 'Automovil', 193),
  (44, 4, 'Automovil', 194),
  (45, 4, 'Automovil', 195),
  (46, 4, 'Automovil', 196),
  (47, 4, 'Automovil', 197),
  (48, 4, 'Automovil', 198),
  (49, 4, 'Automovil', 199),
  (50, 4, 'Automovil', 200);
  
  INSERT INTO Cajones (numeroCajon, piso, tipoVehiculo, IDTarjeta)
VALUES 
  (1, 5, 'Moto', 201),
  (2, 5, 'Moto', 202),
  (3, 5, 'Moto', 203),
  (4, 5, 'Moto', 204),
  (5, 5, 'Moto', 205),
  (6, 5, 'Moto', 206),
  (7, 5, 'Moto', 207),
  (8, 5, 'Moto', 208),
  (9, 5, 'Moto', 209),
  (10, 5, 'Moto', 210),
  (11, 5, 'Moto', 211),
  (12, 5, 'Moto', 212),
  (13, 5, 'Moto', 213),
  (14, 5, 'Moto', 214),
  (15, 5, 'Moto', 215),
  (16, 5, 'Moto', 216),
  (17, 5, 'Moto', 217),
  (18, 5, 'Moto', 218),
  (19, 5, 'Moto', 219),
  (20, 5, 'Moto', 220),
  (21, 5, 'Moto', 221),
  (22, 5, 'Moto', 222),
  (23, 5, 'Moto', 223),
  (24, 5, 'Moto', 224),
  (25, 5, 'Moto', 225),
  (26, 5, 'Moto', 226),
  (27, 5, 'Moto', 227),
  (28, 5, 'Moto', 228),
  (29, 5, 'Moto', 229),
  (30, 5, 'Moto', 230),
  (31, 5, 'Moto', 231),
  (32, 5, 'Moto', 232),
  (33, 5, 'Moto', 233),
  (34, 5, 'Moto', 234),
  (35, 5, 'Moto', 235),
  (36, 5, 'Moto', 236),
  (37, 5, 'Moto', 237),
  (38, 5, 'Moto', 238),
  (39, 5, 'Moto', 239),
  (40, 5, 'Moto', 240),
  (41, 5, 'Moto', 241),
  (42, 5, 'Moto', 242),
  (43, 5, 'Moto', 243),
  (44, 5, 'Moto', 244),
  (45, 5, 'Moto', 245),
  (46, 5, 'Moto', 246),
  (47, 5, 'Moto', 247),
  (48, 5, 'Moto', 248),
  (49, 5, 'Moto', 249),
  (50, 5, 'Moto', 250);
  
UPDATE Tarjetas SET IDCajon = 1 WHERE IDTarjeta = 1;
UPDATE Tarjetas SET IDCajon = 2 WHERE IDTarjeta = 2;
UPDATE Tarjetas SET IDCajon = 3 WHERE IDTarjeta = 3;
UPDATE Tarjetas SET IDCajon = 4 WHERE IDTarjeta = 4;
UPDATE Tarjetas SET IDCajon = 5 WHERE IDTarjeta = 5;
UPDATE Tarjetas SET IDCajon = 6 WHERE IDTarjeta = 6;
UPDATE Tarjetas SET IDCajon = 7 WHERE IDTarjeta = 7;
UPDATE Tarjetas SET IDCajon = 8 WHERE IDTarjeta = 8;
UPDATE Tarjetas SET IDCajon = 9 WHERE IDTarjeta = 9;
UPDATE Tarjetas SET IDCajon = 10 WHERE IDTarjeta = 10;
UPDATE Tarjetas SET IDCajon = 11 WHERE IDTarjeta = 11;
UPDATE Tarjetas SET IDCajon = 12 WHERE IDTarjeta = 12;
UPDATE Tarjetas SET IDCajon = 13 WHERE IDTarjeta = 13;
UPDATE Tarjetas SET IDCajon = 14 WHERE IDTarjeta = 14;
UPDATE Tarjetas SET IDCajon = 15 WHERE IDTarjeta = 15;
UPDATE Tarjetas SET IDCajon = 16 WHERE IDTarjeta = 16;
UPDATE Tarjetas SET IDCajon = 17 WHERE IDTarjeta = 17;
UPDATE Tarjetas SET IDCajon = 18 WHERE IDTarjeta = 18;
UPDATE Tarjetas SET IDCajon = 19 WHERE IDTarjeta = 19;
UPDATE Tarjetas SET IDCajon = 20 WHERE IDTarjeta = 20;
UPDATE Tarjetas SET IDCajon = 21 WHERE IDTarjeta = 21;
UPDATE Tarjetas SET IDCajon = 22 WHERE IDTarjeta = 22;
UPDATE Tarjetas SET IDCajon = 23 WHERE IDTarjeta = 23;
UPDATE Tarjetas SET IDCajon = 24 WHERE IDTarjeta = 24;
UPDATE Tarjetas SET IDCajon = 25 WHERE IDTarjeta = 25;
UPDATE Tarjetas SET IDCajon = 26 WHERE IDTarjeta = 26;
UPDATE Tarjetas SET IDCajon = 27 WHERE IDTarjeta = 27;
UPDATE Tarjetas SET IDCajon = 28 WHERE IDTarjeta = 28;
UPDATE Tarjetas SET IDCajon = 29 WHERE IDTarjeta = 29;
UPDATE Tarjetas SET IDCajon = 30 WHERE IDTarjeta = 30;
UPDATE Tarjetas SET IDCajon = 31 WHERE IDTarjeta = 31;
UPDATE Tarjetas SET IDCajon = 32 WHERE IDTarjeta = 32;
UPDATE Tarjetas SET IDCajon = 33 WHERE IDTarjeta = 33;
UPDATE Tarjetas SET IDCajon = 34 WHERE IDTarjeta = 34;
UPDATE Tarjetas SET IDCajon = 35 WHERE IDTarjeta = 35;
UPDATE Tarjetas SET IDCajon = 36 WHERE IDTarjeta = 36;
UPDATE Tarjetas SET IDCajon = 37 WHERE IDTarjeta = 37;
UPDATE Tarjetas SET IDCajon = 38 WHERE IDTarjeta = 38;
UPDATE Tarjetas SET IDCajon = 39 WHERE IDTarjeta = 39;
UPDATE Tarjetas SET IDCajon = 40 WHERE IDTarjeta = 40;
UPDATE Tarjetas SET IDCajon = 41 WHERE IDTarjeta = 41;
UPDATE Tarjetas SET IDCajon = 42 WHERE IDTarjeta = 42;
UPDATE Tarjetas SET IDCajon = 43 WHERE IDTarjeta = 43;
UPDATE Tarjetas SET IDCajon = 44 WHERE IDTarjeta = 44;
UPDATE Tarjetas SET IDCajon = 45 WHERE IDTarjeta = 45;
UPDATE Tarjetas SET IDCajon = 46 WHERE IDTarjeta = 46;
UPDATE Tarjetas SET IDCajon = 47 WHERE IDTarjeta = 47;
UPDATE Tarjetas SET IDCajon = 48 WHERE IDTarjeta = 48;
UPDATE Tarjetas SET IDCajon = 49 WHERE IDTarjeta = 49;
UPDATE Tarjetas SET IDCajon = 50 WHERE IDTarjeta = 50;
UPDATE Tarjetas SET IDCajon = 51 WHERE IDTarjeta = 51;
UPDATE Tarjetas SET IDCajon = 52 WHERE IDTarjeta = 52;
UPDATE Tarjetas SET IDCajon = 53 WHERE IDTarjeta = 53;
UPDATE Tarjetas SET IDCajon = 54 WHERE IDTarjeta = 54;
UPDATE Tarjetas SET IDCajon = 55 WHERE IDTarjeta = 55;
UPDATE Tarjetas SET IDCajon = 56 WHERE IDTarjeta = 56;
UPDATE Tarjetas SET IDCajon = 57 WHERE IDTarjeta = 57;
UPDATE Tarjetas SET IDCajon = 58 WHERE IDTarjeta = 58;
UPDATE Tarjetas SET IDCajon = 59 WHERE IDTarjeta = 59;
UPDATE Tarjetas SET IDCajon = 60 WHERE IDTarjeta = 60;
UPDATE Tarjetas SET IDCajon = 61 WHERE IDTarjeta = 61;
UPDATE Tarjetas SET IDCajon = 62 WHERE IDTarjeta = 62;
UPDATE Tarjetas SET IDCajon = 63 WHERE IDTarjeta = 63;
UPDATE Tarjetas SET IDCajon = 64 WHERE IDTarjeta = 64;
UPDATE Tarjetas SET IDCajon = 65 WHERE IDTarjeta = 65;
UPDATE Tarjetas SET IDCajon = 66 WHERE IDTarjeta = 66;
UPDATE Tarjetas SET IDCajon = 67 WHERE IDTarjeta = 67;
UPDATE Tarjetas SET IDCajon = 68 WHERE IDTarjeta = 68;
UPDATE Tarjetas SET IDCajon = 69 WHERE IDTarjeta = 69;
UPDATE Tarjetas SET IDCajon = 70 WHERE IDTarjeta = 70;
UPDATE Tarjetas SET IDCajon = 71 WHERE IDTarjeta = 71;
UPDATE Tarjetas SET IDCajon = 72 WHERE IDTarjeta = 72;
UPDATE Tarjetas SET IDCajon = 73 WHERE IDTarjeta = 73;
UPDATE Tarjetas SET IDCajon = 74 WHERE IDTarjeta = 74;
UPDATE Tarjetas SET IDCajon = 75 WHERE IDTarjeta = 75;
UPDATE Tarjetas SET IDCajon = 76 WHERE IDTarjeta = 76;
UPDATE Tarjetas SET IDCajon = 77 WHERE IDTarjeta = 77;
UPDATE Tarjetas SET IDCajon = 78 WHERE IDTarjeta = 78;
UPDATE Tarjetas SET IDCajon = 79 WHERE IDTarjeta = 79;
UPDATE Tarjetas SET IDCajon = 80 WHERE IDTarjeta = 80;
UPDATE Tarjetas SET IDCajon = 81 WHERE IDTarjeta = 81;
UPDATE Tarjetas SET IDCajon = 82 WHERE IDTarjeta = 82;
UPDATE Tarjetas SET IDCajon = 83 WHERE IDTarjeta = 83;
UPDATE Tarjetas SET IDCajon = 84 WHERE IDTarjeta = 84;
UPDATE Tarjetas SET IDCajon = 85 WHERE IDTarjeta = 85;
UPDATE Tarjetas SET IDCajon = 86 WHERE IDTarjeta = 86;
UPDATE Tarjetas SET IDCajon = 87 WHERE IDTarjeta = 87;
UPDATE Tarjetas SET IDCajon = 88 WHERE IDTarjeta = 88;
UPDATE Tarjetas SET IDCajon = 89 WHERE IDTarjeta = 89;
UPDATE Tarjetas SET IDCajon = 90 WHERE IDTarjeta = 90;
UPDATE Tarjetas SET IDCajon = 91 WHERE IDTarjeta = 91;
UPDATE Tarjetas SET IDCajon = 92 WHERE IDTarjeta = 92;
UPDATE Tarjetas SET IDCajon = 93 WHERE IDTarjeta = 93;
UPDATE Tarjetas SET IDCajon = 94 WHERE IDTarjeta = 94;
UPDATE Tarjetas SET IDCajon = 95 WHERE IDTarjeta = 95;
UPDATE Tarjetas SET IDCajon = 96 WHERE IDTarjeta = 96;
UPDATE Tarjetas SET IDCajon = 97 WHERE IDTarjeta = 97;
UPDATE Tarjetas SET IDCajon = 98 WHERE IDTarjeta = 98;
UPDATE Tarjetas SET IDCajon = 99 WHERE IDTarjeta = 99;
UPDATE Tarjetas SET IDCajon = 100 WHERE IDTarjeta = 100;
UPDATE Tarjetas SET IDCajon = 101 WHERE IDTarjeta = 101;
UPDATE Tarjetas SET IDCajon = 102 WHERE IDTarjeta = 102;
UPDATE Tarjetas SET IDCajon = 103 WHERE IDTarjeta = 103;
UPDATE Tarjetas SET IDCajon = 104 WHERE IDTarjeta = 104;
UPDATE Tarjetas SET IDCajon = 105 WHERE IDTarjeta = 105;
UPDATE Tarjetas SET IDCajon = 106 WHERE IDTarjeta = 106;
UPDATE Tarjetas SET IDCajon = 107 WHERE IDTarjeta = 107;
UPDATE Tarjetas SET IDCajon = 108 WHERE IDTarjeta = 108;
UPDATE Tarjetas SET IDCajon = 109 WHERE IDTarjeta = 109;
UPDATE Tarjetas SET IDCajon = 110 WHERE IDTarjeta = 110;
UPDATE Tarjetas SET IDCajon = 111 WHERE IDTarjeta = 111;
UPDATE Tarjetas SET IDCajon = 112 WHERE IDTarjeta = 112;
UPDATE Tarjetas SET IDCajon = 113 WHERE IDTarjeta = 113;
UPDATE Tarjetas SET IDCajon = 114 WHERE IDTarjeta = 114;
UPDATE Tarjetas SET IDCajon = 115 WHERE IDTarjeta = 115;
UPDATE Tarjetas SET IDCajon = 116 WHERE IDTarjeta = 116;
UPDATE Tarjetas SET IDCajon = 117 WHERE IDTarjeta = 117;
UPDATE Tarjetas SET IDCajon = 118 WHERE IDTarjeta = 118;
UPDATE Tarjetas SET IDCajon = 119 WHERE IDTarjeta = 119;
UPDATE Tarjetas SET IDCajon = 120 WHERE IDTarjeta = 120;
UPDATE Tarjetas SET IDCajon = 121 WHERE IDTarjeta = 121;
UPDATE Tarjetas SET IDCajon = 122 WHERE IDTarjeta = 122;
UPDATE Tarjetas SET IDCajon = 123 WHERE IDTarjeta = 123;
UPDATE Tarjetas SET IDCajon = 124 WHERE IDTarjeta = 124;
UPDATE Tarjetas SET IDCajon = 125 WHERE IDTarjeta = 125;
UPDATE Tarjetas SET IDCajon = 126 WHERE IDTarjeta = 126;
UPDATE Tarjetas SET IDCajon = 127 WHERE IDTarjeta = 127;
UPDATE Tarjetas SET IDCajon = 128 WHERE IDTarjeta = 128;
UPDATE Tarjetas SET IDCajon = 129 WHERE IDTarjeta = 129;
UPDATE Tarjetas SET IDCajon = 130 WHERE IDTarjeta = 130;
UPDATE Tarjetas SET IDCajon = 131 WHERE IDTarjeta = 131;
UPDATE Tarjetas SET IDCajon = 132 WHERE IDTarjeta = 132;
UPDATE Tarjetas SET IDCajon = 133 WHERE IDTarjeta = 133;
UPDATE Tarjetas SET IDCajon = 134 WHERE IDTarjeta = 134;
UPDATE Tarjetas SET IDCajon = 135 WHERE IDTarjeta = 135;
UPDATE Tarjetas SET IDCajon = 136 WHERE IDTarjeta = 136;
UPDATE Tarjetas SET IDCajon = 137 WHERE IDTarjeta = 137;
UPDATE Tarjetas SET IDCajon = 138 WHERE IDTarjeta = 138;
UPDATE Tarjetas SET IDCajon = 139 WHERE IDTarjeta = 139;
UPDATE Tarjetas SET IDCajon = 140 WHERE IDTarjeta = 140;
UPDATE Tarjetas SET IDCajon = 141 WHERE IDTarjeta = 141;
UPDATE Tarjetas SET IDCajon = 142 WHERE IDTarjeta = 142;
UPDATE Tarjetas SET IDCajon = 143 WHERE IDTarjeta = 143;
UPDATE Tarjetas SET IDCajon = 144 WHERE IDTarjeta = 144;
UPDATE Tarjetas SET IDCajon = 145 WHERE IDTarjeta = 145;
UPDATE Tarjetas SET IDCajon = 146 WHERE IDTarjeta = 146;
UPDATE Tarjetas SET IDCajon = 147 WHERE IDTarjeta = 147;
UPDATE Tarjetas SET IDCajon = 148 WHERE IDTarjeta = 148;
UPDATE Tarjetas SET IDCajon = 149 WHERE IDTarjeta = 149;
UPDATE Tarjetas SET IDCajon = 150 WHERE IDTarjeta = 150;
UPDATE Tarjetas SET IDCajon = 151 WHERE IDTarjeta = 151;
UPDATE Tarjetas SET IDCajon = 152 WHERE IDTarjeta = 152;
UPDATE Tarjetas SET IDCajon = 153 WHERE IDTarjeta = 153;
UPDATE Tarjetas SET IDCajon = 154 WHERE IDTarjeta = 154;
UPDATE Tarjetas SET IDCajon = 155 WHERE IDTarjeta = 155;
UPDATE Tarjetas SET IDCajon = 156 WHERE IDTarjeta = 156;
UPDATE Tarjetas SET IDCajon = 157 WHERE IDTarjeta = 157;
UPDATE Tarjetas SET IDCajon = 158 WHERE IDTarjeta = 158;
UPDATE Tarjetas SET IDCajon = 159 WHERE IDTarjeta = 159;
UPDATE Tarjetas SET IDCajon = 160 WHERE IDTarjeta = 160;
UPDATE Tarjetas SET IDCajon = 161 WHERE IDTarjeta = 161;
UPDATE Tarjetas SET IDCajon = 162 WHERE IDTarjeta = 162;
UPDATE Tarjetas SET IDCajon = 163 WHERE IDTarjeta = 163;
UPDATE Tarjetas SET IDCajon = 164 WHERE IDTarjeta = 164;
UPDATE Tarjetas SET IDCajon = 165 WHERE IDTarjeta = 165;
UPDATE Tarjetas SET IDCajon = 166 WHERE IDTarjeta = 166;
UPDATE Tarjetas SET IDCajon = 167 WHERE IDTarjeta = 167;
UPDATE Tarjetas SET IDCajon = 168 WHERE IDTarjeta = 168;
UPDATE Tarjetas SET IDCajon = 169 WHERE IDTarjeta = 169;
UPDATE Tarjetas SET IDCajon = 170 WHERE IDTarjeta = 170;
UPDATE Tarjetas SET IDCajon = 171 WHERE IDTarjeta = 171;
UPDATE Tarjetas SET IDCajon = 172 WHERE IDTarjeta = 172;
UPDATE Tarjetas SET IDCajon = 173 WHERE IDTarjeta = 173;
UPDATE Tarjetas SET IDCajon = 174 WHERE IDTarjeta = 174;
UPDATE Tarjetas SET IDCajon = 175 WHERE IDTarjeta = 175;
UPDATE Tarjetas SET IDCajon = 176 WHERE IDTarjeta = 176;
UPDATE Tarjetas SET IDCajon = 177 WHERE IDTarjeta = 177;
UPDATE Tarjetas SET IDCajon = 178 WHERE IDTarjeta = 178;
UPDATE Tarjetas SET IDCajon = 179 WHERE IDTarjeta = 179;
UPDATE Tarjetas SET IDCajon = 180 WHERE IDTarjeta = 180;
UPDATE Tarjetas SET IDCajon = 181 WHERE IDTarjeta = 181;
UPDATE Tarjetas SET IDCajon = 182 WHERE IDTarjeta = 182;
UPDATE Tarjetas SET IDCajon = 183 WHERE IDTarjeta = 183;
UPDATE Tarjetas SET IDCajon = 184 WHERE IDTarjeta = 184;
UPDATE Tarjetas SET IDCajon = 185 WHERE IDTarjeta = 185;
UPDATE Tarjetas SET IDCajon = 186 WHERE IDTarjeta = 186;
UPDATE Tarjetas SET IDCajon = 187 WHERE IDTarjeta = 187;
UPDATE Tarjetas SET IDCajon = 188 WHERE IDTarjeta = 188;
UPDATE Tarjetas SET IDCajon = 189 WHERE IDTarjeta = 189;
UPDATE Tarjetas SET IDCajon = 190 WHERE IDTarjeta = 190;
UPDATE Tarjetas SET IDCajon = 191 WHERE IDTarjeta = 191;
UPDATE Tarjetas SET IDCajon = 192 WHERE IDTarjeta = 192;
UPDATE Tarjetas SET IDCajon = 193 WHERE IDTarjeta = 193;
UPDATE Tarjetas SET IDCajon = 194 WHERE IDTarjeta = 194;
UPDATE Tarjetas SET IDCajon = 195 WHERE IDTarjeta = 195;
UPDATE Tarjetas SET IDCajon = 196 WHERE IDTarjeta = 196;
UPDATE Tarjetas SET IDCajon = 197 WHERE IDTarjeta = 197;
UPDATE Tarjetas SET IDCajon = 198 WHERE IDTarjeta = 198;
UPDATE Tarjetas SET IDCajon = 199 WHERE IDTarjeta = 199;
UPDATE Tarjetas SET IDCajon = 200 WHERE IDTarjeta = 200;
UPDATE Tarjetas SET IDCajon = 201 WHERE IDTarjeta = 201;
UPDATE Tarjetas SET IDCajon = 202 WHERE IDTarjeta = 202;
UPDATE Tarjetas SET IDCajon = 203 WHERE IDTarjeta = 203;
UPDATE Tarjetas SET IDCajon = 204 WHERE IDTarjeta = 204;
UPDATE Tarjetas SET IDCajon = 205 WHERE IDTarjeta = 205;
UPDATE Tarjetas SET IDCajon = 206 WHERE IDTarjeta = 206;
UPDATE Tarjetas SET IDCajon = 207 WHERE IDTarjeta = 207;
UPDATE Tarjetas SET IDCajon = 208 WHERE IDTarjeta = 208;
UPDATE Tarjetas SET IDCajon = 209 WHERE IDTarjeta = 209;
UPDATE Tarjetas SET IDCajon = 210 WHERE IDTarjeta = 210;
UPDATE Tarjetas SET IDCajon = 211 WHERE IDTarjeta = 211;
UPDATE Tarjetas SET IDCajon = 212 WHERE IDTarjeta = 212;
UPDATE Tarjetas SET IDCajon = 213 WHERE IDTarjeta = 213;
UPDATE Tarjetas SET IDCajon = 214 WHERE IDTarjeta = 214;
UPDATE Tarjetas SET IDCajon = 215 WHERE IDTarjeta = 215;
UPDATE Tarjetas SET IDCajon = 216 WHERE IDTarjeta = 216;
UPDATE Tarjetas SET IDCajon = 217 WHERE IDTarjeta = 217;
UPDATE Tarjetas SET IDCajon = 218 WHERE IDTarjeta = 218;
UPDATE Tarjetas SET IDCajon = 219 WHERE IDTarjeta = 219;
UPDATE Tarjetas SET IDCajon = 220 WHERE IDTarjeta = 220;
UPDATE Tarjetas SET IDCajon = 221 WHERE IDTarjeta = 221;
UPDATE Tarjetas SET IDCajon = 222 WHERE IDTarjeta = 222;
UPDATE Tarjetas SET IDCajon = 223 WHERE IDTarjeta = 223;
UPDATE Tarjetas SET IDCajon = 224 WHERE IDTarjeta = 224;
UPDATE Tarjetas SET IDCajon = 225 WHERE IDTarjeta = 225;
UPDATE Tarjetas SET IDCajon = 226 WHERE IDTarjeta = 226;
UPDATE Tarjetas SET IDCajon = 227 WHERE IDTarjeta = 227;
UPDATE Tarjetas SET IDCajon = 228 WHERE IDTarjeta = 228;
UPDATE Tarjetas SET IDCajon = 229 WHERE IDTarjeta = 229;
UPDATE Tarjetas SET IDCajon = 230 WHERE IDTarjeta = 230;
UPDATE Tarjetas SET IDCajon = 231 WHERE IDTarjeta = 231;
UPDATE Tarjetas SET IDCajon = 232 WHERE IDTarjeta = 232;
UPDATE Tarjetas SET IDCajon = 233 WHERE IDTarjeta = 233;
UPDATE Tarjetas SET IDCajon = 234 WHERE IDTarjeta = 234;
UPDATE Tarjetas SET IDCajon = 235 WHERE IDTarjeta = 235;
UPDATE Tarjetas SET IDCajon = 236 WHERE IDTarjeta = 236;
UPDATE Tarjetas SET IDCajon = 237 WHERE IDTarjeta = 237;
UPDATE Tarjetas SET IDCajon = 238 WHERE IDTarjeta = 238;
UPDATE Tarjetas SET IDCajon = 239 WHERE IDTarjeta = 239;
UPDATE Tarjetas SET IDCajon = 240 WHERE IDTarjeta = 240;
UPDATE Tarjetas SET IDCajon = 241 WHERE IDTarjeta = 241;
UPDATE Tarjetas SET IDCajon = 242 WHERE IDTarjeta = 242;
UPDATE Tarjetas SET IDCajon = 243 WHERE IDTarjeta = 243;
UPDATE Tarjetas SET IDCajon = 244 WHERE IDTarjeta = 244;
UPDATE Tarjetas SET IDCajon = 245 WHERE IDTarjeta = 245;
UPDATE Tarjetas SET IDCajon = 246 WHERE IDTarjeta = 246;
UPDATE Tarjetas SET IDCajon = 247 WHERE IDTarjeta = 247;
UPDATE Tarjetas SET IDCajon = 248 WHERE IDTarjeta = 248;
UPDATE Tarjetas SET IDCajon = 249 WHERE IDTarjeta = 249;
UPDATE Tarjetas SET IDCajon = 250 WHERE IDTarjeta = 250;

INSERT INTO Precios (IDPrecio, precioHoraNormalCarro, precioHoraEspecialCarro, precioHoraNormalMoto, precioHoraEspecialMoto, precioTarjetaDañada, precioTarjetaExtraviada)
VALUES (1, 10.50, 15.75, 8.25, 12.50, 50.00, 100.00);

INSERT INTO Usuarios (nombreUsuario, contraseña) VALUES ('admin','123456');

SELECT IDUsuario, nombreUsuario, contraseña FROM Usuarios WHERE nombreUsuario = '12' AND contraseña = '12'

