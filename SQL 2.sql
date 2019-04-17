CREATE TABLE tb_produto (
    id BIGINT NOT NULL,
    descricao varchar(255) NOT NULL,
    marca varchar(255) NOT NULL,
    preco DECIMAL(8,2),
    PRIMARY KEY (id)
);

CREATE TABLE tb_aplicativo (
    id BIGINT NOT NULL,
    nome varchar(255) NOT NULL,
    desenvolvedor varchar(255) NOT NULL,
    nr_downloads BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tb_computador (
    id BIGINT NOT NULL,
    marca varchar(255) NOT NULL,
    processador varchar(255) NOT NULL,
    qtd_ram BIGINT NOT NULL,
    tam_disco BIGINT NOT NULL,
    PRIMARY KEY (id)
)

INSERT INTO tb_produto VALUES(123456,'celular A2','Xiaomi', 1100.00 );
INSERT INTO tb_produto VALUES(4567387,'teste','teste', 100.00 );
INSERT INTO tb_aplicativo VALUES(987654,'Facebook','Mark', 1234567 );
INSERT INTO tb_computador VALUES(345678,'DELL','I7', 12, 500 );

SELECT * FROM tb_produto
SELECT * FROM tb_aplicativo
SELECT * FROM tb_computador

