-- -- HOSPITAL DB

-- -- source script.sql;

-- -- TABELA ESPECIALIDADE
-- CREATE TABLE especialidade ( 
--     id INT(10) NOT NULL auto_increment, 
--     nomeEsp VARCHAR(100) NOT NULL, 
--     PRIMARY KEY (id)
-- );

-- -- TABELA PLANO DE SAUDE
-- CREATE TABLE planoDeSaude ( 
--     id INT(10) NOT NULL auto_increment, 
--     nomePlan VARCHAR(100) NOT NULL, 
--     PRIMARY KEY (id)
-- );

-- -- TABELA FICHAS
-- CREATE TABLE ficha ( 
--     id INT(10) NOT NULL auto_increment, 
--     nomePaciente VARCHAR(100) NOT NULL, 
--     numCarteiraPlano VARCHAR(10) NOT NULL, 
--     idPlanoDeSaude INT(10) NOT NULL,
--     idEspecialidade INT(10) NOT NULL,
--     PRIMARY KEY (id),
--     CONSTRAINT FK_PlanoDeSaude FOREIGN KEY (idPlanoDeSaude) REFERENCES planoDeSaude(id),
--     CONSTRAINT FK_Especialidade FOREIGN KEY (idEspecialidade) REFERENCES especialidade(id)
-- );

-- --------------------------------------------------------------------------------------

-- -- INSERIR DADOS ESPECIALIDADE
-- INSERT INTO especialidade (nomeEsp) VALUES
-- ('Alergia'),
-- ('Anestesiologia'),
-- ('Angiologia'),
-- ('Oncologia'),
-- ('Cardiologia'),
-- ('Cirurgia Geral'),
-- ('Clínica Médica'),
-- ('Dermatologia'),
-- ('Endocrinologia'),
-- ('Ginecologia'),
-- ('Infectologia'),
-- ('Nefrologia'),
-- ('Neurologia'),
-- ('Obstetrícia'),
-- ('Ortopedia'),
-- ('Otorrinolaringologia'),
-- ('Pediatria'),
-- ('Pneumologia'),
-- ('Reumatologia'),
-- ('Urologia');

-- -- INSERIR DADOS PLANO DE SAUDE
-- INSERT INTO planoDeSaude (nomePlan) VALUES
-- ('Coletivo'),
-- ('Empresarial'),
-- ('Individual'),
-- ('Familiar');

-- -- INSERIR DADOS FICHAS
-- INSERT INTO ficha (id, nomePaciente, numCarteiraPlano, idPlanoDeSaude, idEspecialidade) VALUES
-- (01, 'Maria', '12412', 2, 19),
-- (02, 'Mateus', '14263', 3, 10),
-- (03, 'Thalisson', '14263', 2, 7),
-- (04, 'José', '14363', 2, 14),
-- (05, 'Leticia', '10108', 4, 16),
-- (06, 'Fernanda', '46717', 3, 1),
-- (07, 'Pablo', '26346', 1, 2);

-- SHOW TABLES;

-- SELECT * FROM ficha;
-- SELECT * FROM planoDeSaude;
-- SELECT * FROM especialidade;

SELECT ficha.id, ficha.nomePaciente, ficha.numCarteiraPlano, planoDeSaude.nomePlan, especialidade.nomeEsp FROM ficha 
INNER JOIN planoDeSaude ON planoDeSaude.id = ficha.idPlanoDeSaude 
INNER JOIN especialidade ON especialidade.id = ficha.idEspecialidade 
-- ORDER BY ficha.id;
WHERE ficha.id=2;

----


UPDATE ficha SET nomePaciente="Thalise", numCarteiraPlano="61378", idPlanoDeSaude=2, idEspecialidade=5 WHERE id=3;