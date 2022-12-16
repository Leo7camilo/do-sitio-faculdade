CREATE TABLE usuario (
	codigo BIGINT(20) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE usuario MODIFY codigo bigint PRIMARY KEY AUTO_INCREMENT;

INSERT INTO usuario (nome, email, senha) values ('Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO usuario (nome, email, senha) values ('Maria Silva', 'maria@ifsp.edu.br', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');


CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR');

INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_ADMIN');

CREATE TABLE usuario_permissao (
	codigo bigint(20) NOT NULL,
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE usuario_permissao MODIFY codigo bigint PRIMARY KEY AUTO_INCREMENT;

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);

-- maria
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);


CREATE TABLE categoria (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('ORGANICO');
