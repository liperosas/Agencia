--CREATE DATABASE agencia
--GO
--USE agencia

--CREATE TABLE ag_categoria_existentes(	Cat_Ag_Cod INT IDENTITY PRIMARY KEY NOT NULL,
--							Tipo_Cat VARCHAR(200) NOT NULL )
							
--CREATE TABLE agencia(	Ag_Cod INT IDENTITY PRIMARY KEY NOT NULL,
--						Ag_Nome VARCHAR(200) NOT NULL,
--						Ag_Endereco VARCHAR(200) NOT NULL,
--						Ag_Fone VARCHAR(13) NOT NULL,
--						Ag_Email VARCHAR(200) NOT NULL,
--						Ag_Outras_Info VARCHAR(255) )


--CREATE TABLE categorias_da_agencia(	Ag_Cod INT REFERENCES agencia(Ag_Cod),
--						Cat_Ag_Cod INT REFERENCES ag_categoria_existentes(Cat_Ag_Cod),
--						CONSTRAINT chave_pk PRIMARY KEY (Ag_cod,Cat_Ag_Cod) );

--CREATE TABLE vaga(	Vaga_Cod INT IDENTITY PRIMARY KEY NOT NULL,
--					Vaga_Local VARCHAR(200) NOT NULL,
--					Pre_Requisito VARCHAR(200) NOT NULL,
--					Tipo_Vaga VARCHAR(200) NOT NULL,
					
--					Ag_Cod INT REFERENCES agencia(Ag_Cod) )
					
--CREATE TABLE curriculo(	Curriculo_Cod INT IDENTITY PRIMARY KEY NOT NULL,
--							Primeiro_Nome VARCHAR(20) NOT NULL,
--							SobreNome VARCHAR(20) NOT NULL,
--							Sexo CHAR(1) constraint DF_Sexo default('M') constraint CK_Sexo check (Sexo='m' or Sexo='F') NOT NULL,
--							Endereco VARCHAR(200) NOT NULL,
--							Contato_Fone VARCHAR(13) NOT NULL,
--							Contato_Email VARCHAR(200),
--							Contato_Outras_Info VARCHAR(255),
--							Experiencia_De_Trabalho VARCHAR(255))
