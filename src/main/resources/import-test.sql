DROP TABLE IF EXISTS Espada;
DROP TABLE IF EXISTS Herrero;


CREATE TABLE Herrero
(
    nombre VARCHAR (255) NOT NULL UNIQUE ,
    localidad VARCHAR (255),
    PRIMARY KEY (nombre)
) ENGINE = InnoDB;

CREATE TABLE Espada
(
    nombre VARCHAR (255) NOT NULL UNIQUE,
    longitud FLOAT NOT NULL,
    afilada BOOLEAN,
    herrero VARCHAR(255),
    PRIMARY KEY (nombre),
    CONSTRAINT `fk_herrero_espada`
        FOREIGN KEY (herrero) REFERENCES Herrero (nombre)
            ON DELETE SET NULL
            ON UPDATE SET NULL
) ENGINE = InnoDB;

INSERT INTO Herrero (nombre, localidad) VALUES ('Godot', 'Midland');
INSERT INTO Herrero (nombre, localidad) VALUES ('Griffith', 'Tudor');
INSERT INTO Espada (nombre, longitud, afilada, herrero) VALUES ('Dragonslayer', 200.0, false, 'Godot');
INSERT INTO Espada (nombre, longitud, afilada, herrero) VALUES ('Frostmourne', 100.0, false, 'Griffith');