CREATE DATABASE IF NOT EXISTS workoutwiz;
USE workoutwiz;


CREATE TABLE Academia (
  AcademiaID INT PRIMARY KEY,
  Nome VARCHAR(255),
  Localizacao TEXT,
  Contato INT
);

CREATE TABLE Treinador (
  TreinadorID INT PRIMARY KEY,
  Nome VARCHAR(255),
  Especialidade TEXT,
  AcademiaID INT,
  FOREIGN KEY (AcademiaID) REFERENCES Academia(AcademiaID)
);

CREATE TABLE Nutricionista (
  NutricionistaID INT PRIMARY KEY,
  Nome VARCHAR(255),
  Especialidade TEXT,
  AcademiaID INT,
  FOREIGN KEY (AcademiaID) REFERENCES Academia(AcademiaID)
);

CREATE TABLE Cliente (
  ClienteID INT PRIMARY KEY,
  Nome VARCHAR(255),
  Idade INT,
  Sexo TEXT,
  HistoricoDeTreinamento TEXT,
  RestricoesFisicas TEXT,
  NivelDeCondicionamento TEXT,
  PreferenciasDeTreino TEXT,
  DisponibilidadeDeTempo INT,
  TreinadorID INT,
  NutricionistaID INT,
  AcademiaID INT,
  FOREIGN KEY (TreinadorID) REFERENCES Treinador(TreinadorID),
  FOREIGN KEY (NutricionistaID) REFERENCES Nutricionista(NutricionistaID),
  FOREIGN KEY (AcademiaID) REFERENCES Academia(AcademiaID)
);

CREATE TABLE Objetivos (
  ObjetivosID INT PRIMARY KEY,
  ClienteID INT,
  Descricao TEXT,
  FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID)
);

CREATE TABLE AvaliacaoInicial (
  AvaliacaoID INT PRIMARY KEY,
  ClienteID INT,
  TreinadorID INT,
  NutricionistaID INT,
  Objetivos TEXT,
  HistoricoDeTreinamento TEXT,
  RestricoesFisicas TEXT,
  NivelDecondicionamento TEXT,
  PreferenciasdeTreino TEXT,
  DisponibilidadeDeTempo INT,
  FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID),
  FOREIGN KEY (TreinadorID) REFERENCES Treinador(TreinadorID),
  FOREIGN KEY (NutricionistaID) REFERENCES Nutricionista(NutricionistaID)
);

CREATE TABLE PlanodeTreino (
  TreinoID INT PRIMARY KEY,
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

CREATE TABLE Exercicios (
  ExercicioID INT PRIMARY KEY,
  PlanodeTreinoID INT,
  NomeDoExercicio VARCHAR(255),
  NumeroDeRepeticoes INT,
  Peso NUMBER,
  FOREIGN KEY (PlanodeTreinoID) REFERENCES PlanodeTreino(TreinoID)
);

CREATE TABLE Progresso (
  ProgressoID INT PRIMARY KEY,
  TreinoID INT,
  PesosLevantados INT,
  DistanciasPercorridas NUMBER,
  TemposAlcancados NUMBER,
  Grafico BLOB,
  Relatorio TEXT,
  FOREIGN KEY (TreinoID) REFERENCES PlanodeTreino(TreinoID)
);

CREATE TABLE ExecucaodosTreinos (
  ExecucaoID INT PRIMARY KEY,
  TreinoID INT,
  Semana INT,
  Exercicios TEXT,
  Dias INT,
  Data DATE,
  FOREIGN KEY (TreinoID) REFERENCES PlanodeTreino(TreinoID)
);

CREATE TABLE Aprimoramento (
  AprimoramentoID INT PRIMARY KEY,
  TreinoID INT,
  ExecucoesDosMovimentos TEXT,
  DescricaoDaExecucao TEXT,
  DicasDeSeguranca TEXT,
  Feedback TEXT,
  FOREIGN KEY (TreinoID) REFERENCES PlanodeTreino(TreinoID)
);

CREATE TABLE Feedback (
  FeedbackID INT PRIMARY KEY,
  ClienteID INT,
  TreinadorID INT,
  NutricionistaID INT,
  Publico TEXT,
  RedeSocial TEXT,
  Nome VARCHAR(255),
  FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID),
  FOREIGN KEY (TreinadorID) REFERENCES Treinador(TreinadorID),
  FOREIGN KEY (NutricionistaID) REFERENCES Nutricionista(NutricionistaID)
);
