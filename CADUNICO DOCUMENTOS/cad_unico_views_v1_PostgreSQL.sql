----------------------------------------------------------------------------- VIEWS -----------------------------------------------------------------------------


-------------------- FAMÍLIAS -----------------


CREATE OR REPLACE VIEW vw_familias AS 
	SELECT id, remocao_familia, situacao_remocao, especifique_remocao 
	FROM familias;
	
	
--------------------- INDIVÍDUO -----------------


CREATE OR REPLACE VIEW vw_individuos AS 
	SELECT id, id_familia, responsavel_familia, nome, apelido, idade, sexo, etnia, estado_civil, 
		nome_mae, nome_pai, responsavel, grau_parentesco, prestou_informacao 
	FROM individuo;
	
	
-------------------- NASCIMENTO INDIVÍDUO -----------------


-------------------- DOCUMENTOS INDIVÍDUO -----------------


-------------------- ESCOLARIDADE INDIVÍDUO -----------------


-------------------- PROFISSIONAL INDIVÍDUO -----------------


-------------------- DEFICIENTE INDIVÍDUO -----------------


-------------------- ANEXO INDIVÍDUO -----------------


-------------------- EMPRESA -----------------


CREATE OR REPLACE VIEW vw_empresas AS 
	SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem 
	FROM empresa;
	
	
-------------------- DOCUMENTOS EMPRESA -----------------


------------------------ TELEFONES ---------------------


-------------------- TELEFONES INDIVÍDUO -----------------


-------------------- TELEFONES EMPRESA -----------------


---------------- IMÓVEL ---------------------


CREATE OR REPLACE VIEW vw_imoveis AS 
	SELECT id, id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, 
		doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem 
	FROM imovel;
	
	
-------------------- COMPOSIÇÃO IMÓVEL -----------------


-------------------- ENDEREÇO IMÓVEL -----------------


-------------------- SERVIÇOS IMÓVEL -----------------


-------------------- ANEXO IMÓVEL -----------------


-------------------- DEMOLIÇÃO IMÓVEL -----------------


-------------------- ANEXO DEMOLIÇÃO -----------------


-------------------- INDIVÍDUO IMÓVEL -----------------


-------------------- EMPRESA IMÓVEL -----------------


------------------------ NÚCLEO -------------------------


CREATE OR REPLACE VIEW vw_nucleos AS 
	SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, 
		pop_outra_fonte_dados, renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, 
		padrao_construtivo, transporte_coletivo, adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel 
	FROM nucleo;
	
	
-------------------- ANEXO TRANSPORTE -----------------


-------------------- INFRAESTRUTURA URBANA -----------------


-------------------- SITUAÇÃO FUNDIÁRIA -----------------


-------------------- ANEXO ZONEAMENTO -----------------


-------------------- ANEXO JUDICIAL -----------------


-------------------- AÇÕES NÚCLEO -----------------


-------------------- REMANEJAMENTOS -----------------


-------------------- REASSENTAMENTOS -----------------


-------------------- DESCONSTRUÇÕES -----------------


-------------------- ASPECTOS AMBIENTAIS -----------------


------------------------------ APPS -----------------------------


-------------------- ÁREA RISCO -----------------


-------------------- AMBIENTAL ÁREA RISCO -----------------


-------------------- PROGRAMAS HABITACIONAIS -----------------


-------------------- VIAS PÚBLICAS -----------------


-------------------- RECURSO MOBILIDADE -----------------


CREATE OR REPLACE VIEW vw_recurso_mobilidades AS 
	SELECT id, nome 
	FROM recurso_mobilidade;
	
	
-------------------- INSTITUCIONAL SOCIAL -----------------


-------------------- RECURSO SOCIAL -----------------


CREATE OR REPLACE VIEW vw_recurso_sociais AS 
	SELECT id, nome 
	FROM recurso_social;
	
	
-------------------- SECRETARIAS -----------------


CREATE OR REPLACE VIEW vw_secretarias AS 
	SELECT id, nome, descricao, ativo 
	FROM secretarias;
	
	
-------------------- GRUPOS -----------------


CREATE OR REPLACE VIEW vw_grupos AS 
	SELECT id, nome, descricao, ativo 
	FROM grupos;
	
	
-------------------- PERMISSÕES -----------------


CREATE OR REPLACE VIEW vw_permissoes AS 
	SELECT id, nome, descricao 
	FROM permissoes;
	
	
-------------------- GRUPOS PERMISSÕES -----------------


-------------------- USUÁRIOS -----------------


CREATE OR REPLACE VIEW vw_usuarios AS 
	SELECT id, id_grupo, id_secretaria, matricula, senha, foto, nome, email, ativo 
	FROM usuarios;

