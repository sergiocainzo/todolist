CREATE TABLE tb_todos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    estado VARCHAR(50),
    prioridade VARCHAR(50),
    data_criacao TIMESTAMP
);