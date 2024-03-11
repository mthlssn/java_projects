-- HOSPITAL DB

-- source script.sql;

DROP DATABASE hospital;
CREATE DATABASE hospital;
USE hospital;

-- ======================================================================================

-- TABELA ESPECIALIDADE
CREATE TABLE especialidade ( 
    id INT(10) NOT NULL auto_increment, 
    nomeEsp VARCHAR(100) NOT NULL, 
    PRIMARY KEY (id)
);

-- TABELA PLANO DE SAUDE
CREATE TABLE planoDeSaude ( 
    id INT(10) NOT NULL auto_increment, 
    nomePlan VARCHAR(100) NOT NULL, 
    PRIMARY KEY (id)
);

-- TABELA FICHAS
CREATE TABLE ficha ( 
    id INT(10) NOT NULL auto_increment, 
    nomePaciente VARCHAR(100) NOT NULL, 
    numCarteiraPlano VARCHAR(10) NOT NULL, 
    idPlanoDeSaude INT(10) NOT NULL,
    idEspecialidade INT(10) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_PlanoDeSaude FOREIGN KEY (idPlanoDeSaude) REFERENCES planoDeSaude(id),
    CONSTRAINT FK_Especialidade FOREIGN KEY (idEspecialidade) REFERENCES especialidade(id)
);

-- ======================================================================================

-- INSERIR DADOS ESPECIALIDADE
INSERT INTO especialidade (nomeEsp) VALUES
('Alergia'),
('Anestesiologia'),
('Angiologia'),
('Oncologia'),
('Cardiologia'),
('Cirurgia Geral'),
('Clínica Médica'),
('Dermatologia'),
('Endocrinologia'),
('Ginecologia'),
('Infectologia'),
('Nefrologia'),
('Neurologia'),
('Obstetrícia'),
('Ortopedia'),
('Otorrinolaringologia'),
('Pediatria'),
('Pneumologia'),
('Reumatologia'),
('Urologia');

-- INSERIR DADOS PLANO DE SAUDE
INSERT INTO planoDeSaude (nomePlan) VALUES
('Coletivo'),
('Empresarial'),
('Individual'),
('Familiar');

-- INSERIR DADOS FICHAS
INSERT INTO ficha (nomePaciente, numCarteiraPlano, idPlanoDeSaude, idEspecialidade) VALUES
("Eric Oliveira", "XX053", 4, 18),
("Danielle Dias", "XX418", 1, 3),
("Joel Romildo", "XX555", 2, 16),
("Caio Assunção", "XX155", 3, 1),
("Ricardo Gonçalves", "XX831", 2, 7),
("Olga Wanda", "XX346", 1, 14),
("Márcio Pedro", "XX739", 4, 9),
("Batista Galindo", "XX541", 1, 5),
("Gabriel Hugo", "XX973", 1, 15),
("Eustáquio Balestero", "XX376", 4, 17)
-- ,
-- ("Meire Walderice", "XX704", 2, 8),
-- ("Filipe Gusmão", "XX864", 4, 15),
-- ("Nádia Marilúcia", "XX618", 1, 5),
-- ("Thalisson Santos", "XX999", 4, 10),
-- ("Lino Olavo de", "XX168", 1, 9),
-- ("Guilherme Severino", "XX940", 2, 16),
-- ("Melanie Telma", "XX504", 3, 6),
-- ("Mário Robson", "XX320", 4, 9),
-- ("Artur Robert", "XX881", 1, 16),
-- ("Aparecida Esteves", "XX149", 2, 10)
;

-- ======================================================================================

-- SHOW TABLES;

-- SELECT * FROM ficha;
-- SELECT * FROM planoDeSaude;
-- SELECT * FROM especialidade;

