CREATE DATABASE agenciaTuristicaNoturna;

USE agenciaTuristicaNoturna;

CREATE TABLE Agencia (
Id_Agencia INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50),
Descrição VARCHAR(400)
);

CREATE TABLE Destinos (
Id_Destino INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50),
Descrição VARCHAR(400),
Preço INT
);

CREATE TABLE Promoçoes (
Id_Promoção INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50),
Descrição VARCHAR(200),
Preço_Promocional INT,
DatadeInicio DATETIME,
DatadeTérmino DATETIME,
Id_Destino INT,
FOREIGN KEY(Id_Destino) REFERENCES Destinos (Id_Destino)
);

CREATE TABLE Usuario (
Id_Usuario INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50),
Login VARCHAR(30),
Senha VARCHAR(20),
PermissõesdeAcesso VARCHAR(20)
);

CREATE TABLE Cliente (
Id_Cliente INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(50),
Email VARCHAR(30),
Telefone VARCHAR(15),
Endereço VARCHAR(30),
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
Valor_Pago INT,
Status VARCHAR(20),
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
