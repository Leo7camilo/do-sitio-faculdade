CREATE TABLE mercadoria (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(200) NOT NULL,
	data_producao DATE NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(200) NOT NULL,
	codigo_categoria BIGINT(20) NOT NULL,
	codigo_produtor BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY (codigo_produtor) REFERENCES produtor(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO mercadoria (descricao, data_producao, valor, observacao, codigo_categoria, codigo_produtor) 
values ('Tomate', '2022-08-25', 5.25,'O Tomate Rubi Orgânico da Fazenda Rio Bonito tem sua qualidade comprovada pela certificação Global GAP', 1, 1);


