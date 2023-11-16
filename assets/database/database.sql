CREATE DATABASE IF NOT EXISTS workoutwiz;
USE workoutwiz;


CREATE TABLE Cliente (
  ClienteID INT AUTO_INCREMENT PRIMARY KEY,
  Nome VARCHAR(255),
  Idade INT,
  Sexo TEXT,
  HistoricoDeTreinamento TEXT,
  RestricoesFisicas TEXT,
  NivelDeCondicionamento TEXT,
  PreferenciasDeTreino TEXT,
  DisponibilidadeDeTempo INT,
  Senha VARCHAR(255),
  Email TEXT,
  TreinadorID INT
);

-- Tabela Treinador
CREATE TABLE Treinador (
  TreinadorID INT AUTO_INCREMENT PRIMARY KEY,
  Nome VARCHAR(255),
  Especialidade TEXT,
  Senha VARCHAR(255)
);

-- Tabela AvaliacaoInicial
CREATE TABLE AvaliacaoInicial (
  AvaliacaoID INT AUTO_INCREMENT PRIMARY KEY,
  ClienteID INT,
  TreinadorID INT,
  Objetivos TEXT,
  HistoricoDeTreinamento TEXT,
  RestricoesFisicas TEXT,
  NivelDecondicionamento TEXT,
  PreferenciasdeTreino TEXT,
  DisponibilidadeDeTempo INT,
  FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID),
  FOREIGN KEY (TreinadorID) REFERENCES Treinador(TreinadorID)
);

-- Tabela PlanodeTreino
CREATE TABLE PlanodeTreino (
  TreinoID INT AUTO_INCREMENT PRIMARY KEY,
  ClienteID INT,
  Data DATE,
  Frequencia INT,
  Modalidade TEXT,
  GanhoDeMassaMuscular TEXT,
  ControleDePeso TEXT,
  AumentoDaResistencia TEXT,
  ProgressoesDeCarga TEXT,
  ProgressoesDeDificuldade TEXT,
  TreinadorID INT,
  FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID),
  FOREIGN KEY (TreinadorID) REFERENCES Treinador(TreinadorID)
);

-- Tabela Progresso
CREATE TABLE Progresso (
  ProgressoID INT AUTO_INCREMENT PRIMARY KEY,
  TreinoID INT,
  PesosLevantados INT,
  DistanciasPercorridas INT,
  TemposAlcancados INT,
  Grafico BLOB,
  Relatorio TEXT,
  FOREIGN KEY (TreinoID) REFERENCES PlanodeTreino(TreinoID)
);

-- Tabela Aprimoramento
CREATE TABLE Aprimoramento (
  AprimoramentoID INT AUTO_INCREMENT PRIMARY KEY,
  TreinoID INT,
  ExecucoesDosMovimentos TEXT,
  DescricaoDaExecucao TEXT,
  DicasDeSeguranca TEXT,
  Feedback TEXT,
  FOREIGN KEY (TreinoID) REFERENCES PlanodeTreino(TreinoID)
);

-- Tabela Objetivos
CREATE TABLE Objetivos (
  ObjetivosID INT AUTO_INCREMENT PRIMARY KEY,
  ClienteID INT,
  Descricao TEXT,
  FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID)
);

-- Tabela Exercicios
CREATE TABLE Exercicios (
  ExercicioID INT AUTO_INCREMENT PRIMARY KEY,
  TreinoID INT,
  NomeDoExercicio VARCHAR(255),
  NumeroDeRepeticoes INT,
  Peso INT,
  FOREIGN KEY (TreinoID) REFERENCES PlanodeTreino(TreinoID)
);

-- Tabela PlanejamentoDeTreinos
CREATE TABLE PlanejamentoDeTreinos (
  PlanejamentoDeTreinosID INT AUTO_INCREMENT PRIMARY KEY,
  TreinoID INT,
  Tempo VARCHAR(255),
  Data VARCHAR(255),
  FOREIGN KEY (TreinoID) REFERENCES PlanodeTreino(TreinoID)
);

-- Tabela Feedback
CREATE TABLE Feedback (
  FeedbackID INT AUTO_INCREMENT PRIMARY KEY,
  ClienteID INT,
  Nome VARCHAR(255),
  Publico TEXT,
  Texto VARCHAR(255),
  FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID)

);
