CREATE TABLE produtor (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO produtor (nome, descricao, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Chico Bento', 'Chico Bento é o caipira mais curioso e teimoso das belas terras de Vila Abobrinha, cidadezinha do interior. Seu amor pela doce e simples vida da roça','Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Vila Abobrinha', 'MG', true);

