CREATE DATABASE agenciaTuristicaNoturna;

USE agenciaTuristicaNoturna;

CREATE TABLE Agencia (
Id_Agencia INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50) NOT NULL,
Descrição VARCHAR(400) NOT NULL
);

CREATE TABLE Destinos (
Id_Destino INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50) NOT NULL,
Descrição VARCHAR(400) NOT NULL,
Preço INT NOT NULL
);

CREATE TABLE Promoçoes (
Id_Promoção INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50) NOT NULL,
Descrição VARCHAR(200) NOT NULL,
Preço_Promocional INT NOT NULL,
DatadeInicio DATETIME NOT NULL,
DatadeTérmino DATETIME NOT NULL,
Id_Destino INT NOT NULL,
FOREIGN KEY(Id_Destino) REFERENCES Destinos (Id_Destino)
);

CREATE TABLE Usuario (
Id_Usuario INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50) NOT NULL,
Login VARCHAR(30) NOT NULL,
Senha VARCHAR(20) NOT NULL,
PermissõesdeAcesso VARCHAR(20)
);

CREATE TABLE Cliente (
Id_Cliente INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50) NOT NULL,
Email VARCHAR(30) NOT NULL,
Telefone VARCHAR(15) NOT NULL,
Endereço VARCHAR(30) NOT NULL,
Id_Usuario INT,
Id_Agencia INT,
FOREIGN KEY(Id_Usuario) REFERENCES Usuario (Id_Usuario),
FOREIGN KEY(Id_Agencia) REFERENCES Agencia (Id_Agencia)
);

CREATE TABLE Passagem (
Id_Passagem INT AUTO_INCREMENT PRIMARY KEY,
Data_da_Venda DATETIME,
DatadaPartida DATETIME,
DatadeRetorno DATETIME,
Preço_Passagem INT,
NumerodeVoo VARCHAR(20)
);

CREATE TABLE Compra_de_Passagem (
Id_Compra_Passagem INT AUTO_INCREMENT PRIMARY KEY,
Data_da_Compra DATETIME,
Valor_Pago INT NOT NULL,
Status VARCHAR(20) NOT NULL,
Id_Passagem int,
FOREIGN KEY(Id_Passagem) REFERENCES Passagem (Id_Passagem)
);

CREATE TABLE Oferece (
Id_Agencia INT,
Id_Promoção INT,
FOREIGN KEY(Id_Agencia) REFERENCES Agencia (Id_Agencia),
FOREIGN KEY(Id_Promoção) REFERENCES Promoçoes (Id_Promoção)
);

CREATE TABLE Faz (
Id_Cliente INT,
Id_Compra_Passagem INT,
FOREIGN KEY(Id_Cliente) REFERENCES Cliente (Id_Cliente),
FOREIGN KEY(Id_Compra_Passagem) REFERENCES Compra_de_Passagem (Id_Compra_Passagem)
);

CREATE TABLE Propõe (
Id_Agencia INT,
Id_Destino INT,
FOREIGN KEY(Id_Agencia) REFERENCES Agencia (Id_Agencia),
FOREIGN KEY(Id_Destino) REFERENCES Destinos (Id_Destino)
);
