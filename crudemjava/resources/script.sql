CREATE DATABASE agenda;

CREATE TABLE contatos(
	id int not null auto_increment primary key,
	nome varchar(40),
	idade int,
	dataCadastro date
	);

INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Maria', 10, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Thalisson', 120, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('João', 45, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Eduarda', 74, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Daniel', 17, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Fernanda', 234, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Alberto', 27, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Marcela', 86, '2022-12-21');
INSERT INTO contatos(nome, idade, datacadastro) VALUES ('Francisco', 35, '2022-12-21');