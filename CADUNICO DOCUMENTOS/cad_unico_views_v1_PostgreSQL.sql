----------------------------------------------------------------------------- VIEWS -----------------------------------------------------------------------------


-------------------- FAMÍLIAS -----------------


CREATE OR REPLACE VIEW vw_familias AS 
	SELECT id, remocao_familia, situacao_remocao, especifique_remocao, atendente, dt_atendimento, atendente_atualizacao, dt_atualizacao 
	FROM familias;
	
	
--------------------- INDIVÍDUO -----------------


CREATE OR REPLACE VIEW vw_individuos AS 
	SELECT id, id_familia, responsavel_familia, nome, apelido, idade, sexo, etnia, estado_civil, 
		nome_mae, nome_pai, responsavel, grau_parentesco, observacoes, prestou_informacao, cpf_informante 
	FROM individuo ORDER BY nome;
	
	
-------------------- NASCIMENTO INDIVÍDUO -----------------


-------------------- DOCUMENTOS INDIVÍDUO -----------------


-------------------- ESCOLARIDADE INDIVÍDUO -----------------


-------------------- PROFISSIONAL INDIVÍDUO -----------------


-------------------- DEFICIENTE INDIVÍDUO -----------------


-------------------- ANEXO INDIVÍDUO -----------------


-------------------- EMPRESA -----------------


CREATE OR REPLACE VIEW vw_empresas AS 
	SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem 
	FROM empresa ORDER BY razao_social;
	
	
-------------------- DOCUMENTOS EMPRESA -----------------


------------------------ TELEFONES ---------------------


-------------------- TELEFONES INDIVÍDUO -----------------


-------------------- TELEFONES EMPRESA -----------------


---------------- IMÓVEL ---------------------


CREATE OR REPLACE VIEW vw_imoveis AS 
	SELECT id, id_nucleo, tipo_imovel, valor_aluguel, tipo_propriedade, 
		doc_propriedade, num_doc_propriedade, localidade, paga_iptu, ic, selagem 
	FROM imovel;
	
	
CREATE OR REPLACE VIEW vw_imoveis_completos AS 
	SELECT i.id AS id, i.id_nucleo AS id_nucleo, i.tipo_imovel AS tipo_imovel, i.tipo_propriedade AS tipo_propriedade, i.doc_propriedade AS doc_propriedade, 
	i.num_doc_propriedade AS num_doc_propriedade, e.tipo_area AS tipo_area, e.tipo_logradouro AS tipo_logradouro, e.logradouro AS logradouro, e.numero AS numero, 
	e.complemento AS complemento, e.cep AS cep, e.bairro AS bairro, e.id_municipio AS id_municipio, m.id_estado AS id_estado  
	FROM imovel AS i
	INNER JOIN nucleo AS n ON i.id_nucleo = n.id 
	INNER JOIN endereco_imovel AS e ON i.id = e.id_imovel 
	INNER JOIN municipios AS m ON e.id_municipio = m.id 
	INNER JOIN estados AS es ON m.id_estado = es.id 
	ORDER BY n.nome, e.tipo_logradouro, e.logradouro, e.numero, e.bairro, m.nome, es.nome;
	
	
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
		padrao_construtivo, transporte_coletivo, adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel, ativo  
	FROM nucleo WHERE ativo = 'Y' ORDER BY nome;
	
	
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
	FROM recurso_mobilidade ORDER BY nome;
	
	
-------------------- INSTITUCIONAL SOCIAL -----------------


-------------------- RECURSO SOCIAL -----------------


CREATE OR REPLACE VIEW vw_recurso_sociais AS 
	SELECT id, nome 
	FROM recurso_social ORDER BY nome;
	
	
-------------------- DEPARTAMENTOS -----------------


CREATE OR REPLACE VIEW vw_departamentos AS 
	SELECT id, sigla, nome, descricao, ativo 
	FROM departamentos ORDER BY sigla;
	
	
-------------------- GRUPOS -----------------


CREATE OR REPLACE VIEW vw_grupos AS 
	SELECT id, nome, descricao, ativo 
	FROM grupos ORDER BY nome;
	
	
-------------------- PERMISSÕES -----------------


CREATE OR REPLACE VIEW vw_permissoes AS 
	SELECT id, nome, descricao 
	FROM permissoes ORDER BY nome;
	
	
-------------------- GRUPOS PERMISSÕES -----------------


-------------------- USUÁRIOS -----------------


CREATE OR REPLACE VIEW vw_usuarios AS 
	SELECT id, id_grupo, id_departamento, usuario, senha, foto, nome, email, ativo 
	FROM usuarios ORDER BY usuario;
	
	
CREATE OR REPLACE VIEW vw_usuarios_completos AS 
	SELECT u.id AS u_id, u.usuario AS u_usuario, u.senha AS u_senha, u.foto AS u_foto, u.nome AS u_nome, u.email AS u_email, u.ativo AS u_ativo, 
	d.id AS d_id, d.sigla AS d_sigla, d.nome AS d_nome, d.descricao AS d_descricao, d.ativo AS d_ativo, g.id AS g_id, g.nome AS g_nome, 
	g.descricao AS g_descricao, g.ativo AS g_ativo 
	FROM usuarios AS u 
	INNER JOIN departamentos AS d ON u.id_departamento = d.id 
	INNER JOIN grupos AS g ON u.id_grupo = g.id 
	ORDER BY u.usuario;
	
	
-------------------- PAÍSES -----------------


CREATE OR REPLACE VIEW vw_paises AS 
	SELECT id, sigla, nome 
	FROM paises ORDER BY nome;
	
	
-------------------- ESTADOS -----------------


CREATE OR REPLACE VIEW vw_estados AS 
	SELECT id, id_pais, sigla, nome 
	FROM estados ORDER BY nome;
	
	
-------------------- MUNICÍPIOS -----------------


CREATE OR REPLACE VIEW vw_municipios AS 
	SELECT id, id_estado, nome 
	FROM municipios ORDER BY nome;

