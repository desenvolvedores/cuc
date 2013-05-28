CREATE DATABASE cadunico;
USE cadunico;


------------------------------------------------------------------ ESTRUTURA DAS TABELAS ---------------------------------------------------------------------


CREATE TABLE nucleo (
	id BIGSERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL ,
	origem VARCHAR(20)   NOT NULL ,
	ocupacao VARCHAR(255)    ,
	area_total DOUBLE PRECISION    ,
	area_ocupada DOUBLE PRECISION    ,
	num_domicilios INTEGER    ,
	populacao_estimada INTEGER    ,
	pop_fonte_dados VARCHAR(45)   NOT NULL ,
	pop_outra_fonte_dados VARCHAR(255)    ,
	renda_populacao VARCHAR(45)   NOT NULL ,
	inicio_ocupacao VARCHAR(45)    ,
	setor_cadastral VARCHAR(20)    ,
	zona VARCHAR(20)   NOT NULL ,
	controle_ocupacao CHAR(3)    ,
	obs_controle_ocupacao TEXT    ,
	padrao_construtivo VARCHAR(80)   NOT NULL ,
	transporte_coletivo CHAR(3)   NOT NULL ,
	adensamento CHAR(3)   NOT NULL ,
	adens_fonte_dados VARCHAR(255)    ,
	obs_adensamento TEXT    ,
	uso_incompativel CHAR(3)   NOT NULL   ,
PRIMARY KEY(id));


CREATE TABLE infraestrutura_urbana (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	abastecimento_agua CHAR(3)   NOT NULL ,
	coleta_esgoto CHAR(3)   NOT NULL ,
	servicos_limpeza CHAR(3)   NOT NULL ,
	aguas_pluviais_superficial CHAR(3)   NOT NULL ,
	aguas_pluviais_rede CHAR(3)   NOT NULL ,
	energia_eletrica CHAR(3)   NOT NULL ,
	iluminacao_publica CHAR(3)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX infraestrutura_urbana_FK1 ON infraestrutura_urbana (id_nucleo);


CREATE INDEX IFK_nucleo_infraestrutura_urba ON infraestrutura_urbana (id_nucleo);


CREATE TABLE situacao_fundiaria (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	propriedade VARCHAR(20)   NOT NULL ,
	proprietario VARCHAR(255)    ,
	obs_propriedade TEXT    ,
	decreto_aprovacao VARCHAR(255)    ,
	registrado CHAR(3)   NOT NULL ,
	num_matricula VARCHAR(20)    ,
	destinacao_areas DOUBLE PRECISION    ,
	desc_destinacao_areas TEXT    ,
	desc_zonas_solo TEXT    ,
	desc_ecologico_economico TEXT    ,
	processos_judiciais CHAR(3)   NOT NULL ,
	num_processo VARCHAR(45)    ,
	num_ordem VARCHAR(45)    ,
	vara VARCHAR(255)    ,
	existencia_embargos CHAR(3)   NOT NULL ,
	obs_judiciais TEXT      ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX situacao_fundiaria_FK1 ON situacao_fundiaria (id_nucleo);


CREATE INDEX IFK_nucleo_situacao_fundiaria ON situacao_fundiaria (id_nucleo);


CREATE TABLE anexo_judicial (
	id BIGSERIAL   NOT NULL ,
	id_fundiaria BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_fundiaria)
		REFERENCES situacao_fundiaria(id));


CREATE INDEX anexo_judicial_FK1 ON anexo_judicial (id_fundiaria);


CREATE INDEX IFK_fundiaria_anexo_judicial ON anexo_judicial (id_fundiaria);


CREATE TABLE anexo_zoneamento (
	id BIGSERIAL   NOT NULL ,
	id_fundiaria BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_fundiaria)
		REFERENCES situacao_fundiaria(id));


CREATE INDEX anexo_zoneamento_FK1 ON anexo_zoneamento (id_fundiaria);


CREATE INDEX IFK_fundiaria_anexo_zoneamento ON anexo_zoneamento (id_fundiaria);


CREATE TABLE aspectos_ambientais (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	area_risco CHAR(3)   NOT NULL ,
	app CHAR(3)   NOT NULL ,
	app_qual TEXT    ,
	area_verde CHAR(3)   NOT NULL ,
	area_agricola CHAR(3)   NOT NULL ,
	outros CHAR(3)   NOT NULL   ,
	latitude DOUBLE PRECISION    ,
	longitude DOUBLE PRECISION   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX aspectos_ambientais_FK1 ON aspectos_ambientais (id_nucleo);


CREATE INDEX IFK_nucleo_aspectos_ambientais ON aspectos_ambientais (id_nucleo);


CREATE TABLE area_risco (
	id BIGSERIAL   NOT NULL ,
	cd_setor VARCHAR(45)    ,
	grau_risco VARCHAR(45)    ,
	vegetacao VARCHAR(45)    ,
	processo_instabilizacao VARCHAR(45)    ,
	condicoes_solo VARCHAR(60)    ,
	existe_pavimentacao VARCHAR(20)    ,
	obs_pavimentacao VARCHAR(255)     ,
	latitude DOUBLE PRECISION    ,
	longitude DOUBLE PRECISION   ,
PRIMARY KEY(id));


CREATE TABLE ambiental_area_risco (
	id_aspecto_ambiental BIGINT   NOT NULL ,
	id_area_risco BIGINT   NOT NULL   ,
PRIMARY KEY(id_aspecto_ambiental, id_area_risco)    ,
	FOREIGN KEY(id_aspecto_ambiental)
		REFERENCES aspectos_ambientais(id),
	FOREIGN KEY(id_area_risco)
		REFERENCES area_risco(id));


CREATE INDEX ambiental_area_risco_FK1 ON ambiental_area_risco (id_aspecto_ambiental);
CREATE INDEX ambiental_area_risco_FK2 ON ambiental_area_risco (id_area_risco);


CREATE INDEX IFK_ambiental_area_risco ON ambiental_area_risco (id_aspecto_ambiental);
CREATE INDEX IFK_area_risco_ambiental ON ambiental_area_risco (id_area_risco);


CREATE TABLE acoes_nucleo (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	remanejamento CHAR(3)   NOT NULL ,
	reassentamento CHAR(3)   NOT NULL ,
	desconstrucao CHAR(3)   NOT NULL ,
	melhoria_habitacional CHAR(3)   NOT NULL ,
	fonte_melhoria VARCHAR(255)    ,
	recuperacao_ambiental CHAR(3)   NOT NULL ,
	prad VARCHAR(255)    ,
	adequacao_infraestrutura CHAR(3)   NOT NULL ,
	fonte_adequacao VARCHAR(255)    ,
	outros CHAR(3)   NOT NULL ,
	desc_outros VARCHAR(255)      ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX acoes_nucleo_FK1 ON acoes_nucleo (id_nucleo);


CREATE INDEX IFK_nucleo_acoes ON acoes_nucleo (id_nucleo);


CREATE TABLE reassentamentos (
	id BIGSERIAL   NOT NULL ,
	id_acao BIGINT   NOT NULL ,
	estimativa_remocao CHAR(3)   NOT NULL ,
	num_a_construir INTEGER   NOT NULL ,
	num_provisorias INTEGER   NOT NULL ,
	local_definitivo VARCHAR(255)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_acao)
		REFERENCES acoes_nucleo(id));


CREATE INDEX reassentamentos_FK1 ON reassentamentos (id_acao);


CREATE INDEX IFK_acao_nucleo_reassentamento ON reassentamentos (id_acao);


CREATE TABLE remanejamentos (
	id BIGSERIAL   NOT NULL ,
	id_acao BIGINT   NOT NULL ,
	estimativa_relocacao CHAR(3)   NOT NULL ,
	num_remocao_definitiva INTEGER   NOT NULL ,
	num_remocao_provisoria INTEGER   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_acao)
		REFERENCES acoes_nucleo(id));


CREATE INDEX remanejamentos_FK1 ON remanejamentos (id_acao);


CREATE INDEX IFK_acao_nucleo_remanejamento ON remanejamentos (id_acao);


CREATE TABLE desconstrucoes (
	id BIGSERIAL   NOT NULL ,
	id_acao BIGINT   NOT NULL ,
	num_a_demolir INTEGER   NOT NULL ,
	motivo TEXT   NOT NULL ,
	processos TEXT   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_acao)
		REFERENCES acoes_nucleo(id));


CREATE INDEX desconstrucoes_FK1 ON desconstrucoes (id_acao);


CREATE INDEX IFK_acao_nucleo_desconstrucao ON desconstrucoes (id_acao);


CREATE TABLE recurso_mobilidade (
	id SERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL   ,
PRIMARY KEY(id));


CREATE TABLE vias_publicas (
	id BIGSERIAL   NOT NULL ,
	id_recurso INTEGER   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	descricao VARCHAR(255)   NOT NULL   ,
PRIMARY KEY(id)    ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id),
	FOREIGN KEY(id_recurso)
		REFERENCES recurso_mobilidade(id));


CREATE INDEX vias_publicas_FK1 ON vias_publicas (id_nucleo);
CREATE INDEX vias_publicas_FK2 ON vias_publicas (id_recurso);


CREATE INDEX IFK_nucleo_vias_publicas ON vias_publicas (id_nucleo);
CREATE INDEX IFK_recurso_vias_publicas ON vias_publicas (id_recurso);

CREATE TABLE recurso_social (
	id SERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL   ,
PRIMARY KEY(id));


CREATE TABLE institucional_social (
	id BIGSERIAL   NOT NULL ,
	id_recurso INTEGER   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	descricao VARCHAR(255)   NOT NULL   ,
PRIMARY KEY(id)    ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id),
	FOREIGN KEY(id_recurso)
		REFERENCES recurso_social(id));


CREATE INDEX institucional_social_FK1 ON institucional_social (id_nucleo);
CREATE INDEX institucional_social_FK2 ON institucional_social (id_recurso);


CREATE INDEX IFK_nucleo_institucional_socia ON institucional_social (id_nucleo);
CREATE INDEX IFK_recurso_institucional_soci ON institucional_social (id_recurso);


CREATE TABLE programas_habitacionais (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	material_construcao CHAR(3)   NOT NULL ,
	producao_moradias CHAR(3)   NOT NULL ,
	assistencia_tecnica CHAR(3)   NOT NULL ,
	urb_assentamentos_precarios CHAR(3)   NOT NULL ,
	complementacao_infraestrutura CHAR(3)   NOT NULL ,
	regularizacao_fundiaria CHAR(3)   NOT NULL ,
	cdhu CHAR(3)   NOT NULL ,
	pmcmv CHAR(3)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX programas_habitacionais_FK1 ON programas_habitacionais (id_nucleo);


CREATE INDEX IFK_nucleo_programas_habitacio ON programas_habitacionais (id_nucleo);


CREATE TABLE anexo_transporte (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX anexo_transporte_FK1 ON anexo_transporte (id_nucleo);


CREATE INDEX IFK_nucleo_anexo_transporte ON anexo_transporte (id_nucleo);


CREATE TABLE imovel (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	tipo_imovel VARCHAR(60)    ,
	situacao_imovel VARCHAR(45)    ,
	valor_aluguel DECIMAL(10,2)    ,
	tipo_propriedade VARCHAR(45)    ,
	doc_propriedade VARCHAR(60)    ,
	num_doc_propriedade VARCHAR(45)    ,
	construcao VARCHAR(20)    ,
	localidade VARCHAR(255)    ,
	paga_iptu CHAR(3)    ,
	ic VARCHAR(20)      ,
	selagem VARCHAR(20)     ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX imovel_FK2 ON imovel (id_nucleo);


CREATE INDEX IFK_nucleo_imovel ON imovel (id_nucleo);


CREATE TABLE composicao_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	material_parede VARCHAR(100)    ,
	especifique_parede TEXT    ,
	material_piso VARCHAR(100)    ,
	especifique_piso TEXT    ,
	material_cobertura VARCHAR(100)    ,
	especifique_cobertura TEXT    ,
	num_comodos INTEGER    ,
	num_salas INTEGER    ,
	num_cozinhas INTEGER    ,
	num_quartos INTEGER    ,
	num_banheiros INTEGER    ,
	num_areas_servicos INTEGER    ,
	num_anexos INTEGER    ,
	num_outros_comodos INTEGER    ,
	num_servem_dormitorio INTEGER      ,
PRIMARY KEY(id, id_imovel)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX composicao_FK1 ON composicao_imovel (id_imovel);


CREATE INDEX IFK_composicao_imovel ON composicao_imovel (id_imovel);


CREATE TABLE endereco_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	tipo_logradouro VARCHAR(50)    ,
	logradouro VARCHAR(255)    ,
	numero VARCHAR(20)    ,
	complemento VARCHAR(255)    ,
	cep CHAR(10)    ,
	bairro VARCHAR(80)    ,
	municipio VARCHAR(80)    ,
	uf CHAR(2)    ,
	tipo_area VARCHAR(20)      ,
	latitude DOUBLE PRECISION    ,
	longitude DOUBLE PRECISION   ,
PRIMARY KEY(id, id_imovel)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX endereco_imovel_FK1 ON endereco_imovel (id_imovel);


CREATE INDEX IFK_endereco_imovel ON endereco_imovel (id_imovel);


CREATE TABLE servicos_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	existe_pavimentacao VARCHAR(45)    ,
	iluminacao_utilizada VARCHAR(45)    ,
	abastecimento_agua VARCHAR(45)    ,
	tratamento_agua VARCHAR(45)    ,
	agua_encanada VARCHAR(45)    ,
	existe_banheiro CHAR(3)    ,
	escoamento_sanitario VARCHAR(45)    ,
	tratamento_lixo VARCHAR(45)    ,
	presenca_animais VARCHAR(45)      ,
PRIMARY KEY(id, id_imovel)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX servicos_FK1 ON servicos_imovel (id_imovel);


CREATE INDEX IFK_servicos_imovel ON servicos_imovel (id_imovel);


CREATE TABLE demolicao_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	dt_demolicao DATE    ,
	horario_demolicao CHAR(5)    ,
	num_processo VARCHAR(20)    ,
	motivo TEXT    ,
	executada_por VARCHAR(255)      ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX demolicao_imovel_FK1 ON demolicao_imovel (id_imovel);


CREATE INDEX IFK_demolicao_imovel ON demolicao_imovel (id_imovel);


CREATE TABLE anexo_demolicao (
	id BIGSERIAL   NOT NULL ,
	id_demolicao BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_demolicao)
		REFERENCES demolicao_imovel(id));


CREATE INDEX anexo_demolicao_FK1 ON anexo_demolicao (id_demolicao);


CREATE INDEX IFK_demolicao_anexos ON anexo_demolicao (id_demolicao);


CREATE TABLE anexo_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX anexo_imovel_FK1 ON anexo_imovel (id_imovel);


CREATE INDEX IFK_anexo_imovel ON anexo_imovel (id_imovel);


CREATE TABLE familias (
	id BIGSERIAL   NOT NULL ,
	remocao_familia CHAR(3)   NOT NULL ,
	situacao_remocao VARCHAR(45)    ,
	especifique_remocao VARCHAR(255)      ,
PRIMARY KEY(id));


CREATE TABLE individuo (
	id BIGSERIAL   NOT NULL ,
	id_familia BIGINT   NOT NULL ,
	nome VARCHAR(255)    ,
	apelido VARCHAR(80)    ,
	idade VARCHAR(20)    ,
	sexo CHAR(2)    ,
	etnia VARCHAR(45)    ,
	estado_civil VARCHAR(45)    ,
	nome_mae VARCHAR(255)    ,
	nome_pai VARCHAR(255)    ,
	responsavel VARCHAR(255)    ,
	grau_parentesco VARCHAR(100)    ,
	prestou_informacao VARCHAR(255)      ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_familia)
		REFERENCES familias(id));


CREATE INDEX individuo_FK1 ON individuo (id_familia);


CREATE INDEX IFK_familias_individuo ON individuo (id_familia);


CREATE TABLE nascimento_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	dt_nascimento DATE    ,
	onde_nasceu VARCHAR(255)    ,
	naturalidade VARCHAR(100)    ,
	nasc_registrado CHAR(3)    ,
	cd_cartorio VARCHAR(20)    ,
	nm_cartorio VARCHAR(255)    ,
	tipo_certidao VARCHAR(45)    ,
	dt_reg_certidao DATE    ,
	municipio_certidao VARCHAR(80)    ,
	uf_certidao CHAR(2)    ,
	num_termo VARCHAR(20)    ,
	num_livro VARCHAR(20)    ,
	num_folha VARCHAR(20)      ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX nascimento_individuo_FK1 ON nascimento_individuo (id_individuo);


CREATE INDEX IFK_nascimento_individuo ON nascimento_individuo (id_individuo);


CREATE TABLE documentos_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	num_rg VARCHAR(20)    ,
	complemento_rg VARCHAR(255)    ,
	orgao_emissor_rg CHAR(3)    ,
	dt_emissao_rg DATE    ,
	num_cpf CHAR(14)    ,
	sts_cpf VARCHAR(20)    ,
	num_eleitor VARCHAR(20)    ,
	zona_eleitor VARCHAR(5)    ,
	secao_eleitor VARCHAR(5)    ,
	num_cart_trab VARCHAR(20)    ,
	serie_cart_trab VARCHAR(5)    ,
	dt_emissao_cart_trab DATE    ,
	orgao_emissor_cart_trab CHAR(3)    ,
	tipo_cart_moto VARCHAR(5)    ,
	num_cart_moto VARCHAR(20)    ,
	serie_cart_moto VARCHAR(5)    ,
	dt_emissao_cart_moto DATE    ,
	num_nis VARCHAR(20)    ,
	num_pis VARCHAR(20)    ,
	num_pasep VARCHAR(20)    ,
	inscricao_mcmv VARCHAR(20)      ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX documentos_individuo_FK1 ON documentos_individuo (id_individuo);


CREATE INDEX IFK_documentos_individuo ON documentos_individuo (id_individuo);


CREATE TABLE escolaridade_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	grau_escolaridade VARCHAR(80)    ,
	unidade_educacional VARCHAR(255)      ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX escolaridade_individuo_FK1 ON escolaridade_individuo (id_individuo);


CREATE INDEX IFK_escolaridade_individuo ON escolaridade_individuo (id_individuo);


CREATE TABLE profissional_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	situacao_trabalhista VARCHAR(80)    ,
	obs_situacao_trabalhista TEXT    ,
	tipo_trabalho VARCHAR(80)    ,
	obs_tipo_trabalho TEXT    ,
	nm_trabalho VARCHAR(255)    ,
	possui_renda VARCHAR(45)    ,
	renda DECIMAL(10,2)    ,
	outras_rendas DECIMAL(10,2)    ,
	tipo_beneficio VARCHAR(45)    ,
	doacao_regular DECIMAL(10,2)    ,
	aposentadoria_pensao DECIMAL(10,2)    ,
	seg_desemprego DECIMAL(10,2)    ,
	pensao_alimentar DECIMAL(10,2)    ,
	outros_beneficios DECIMAL(10,2)    ,
	num_bpcloas VARCHAR(20)      ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX profissional_individuo_FK1 ON profissional_individuo (id_individuo);


CREATE INDEX IFK_profissional_individuo ON profissional_individuo (id_individuo);


CREATE TABLE deficiente_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	deficiente CHAR(3)    ,
	tipo_deficiencia TEXT    ,
	obs_tipo_deficiencia TEXT    ,
	causa_deficiencia VARCHAR(100)    ,
	obs_causa_deficiencia TEXT    ,
	quando_adquiriu VARCHAR(20)    ,
	depende_cuidados VARCHAR(80)    ,
	cadastro_sepedi CHAR(3)      ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX deficiente_individuo_FK1 ON deficiente_individuo (id_individuo);


CREATE INDEX IFK_deficiente_individuo ON deficiente_individuo (id_individuo);


CREATE TABLE anexo_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX anexo_individuo_FK1 ON anexo_individuo (id_individuo);


CREATE INDEX IFK_anexo_individuo ON anexo_individuo (id_individuo);


CREATE TABLE empresa (
	id BIGSERIAL   NOT NULL ,
	razao_social VARCHAR(255)    ,
	nm_fantasia VARCHAR(255)    ,
	fundador VARCHAR(255)    ,
	dt_fundacao DATE    ,
	local_origem VARCHAR(255)      ,
PRIMARY KEY(id));


CREATE TABLE documentos_empresa (
	id BIGSERIAL   NOT NULL ,
	id_empresa BIGINT   NOT NULL ,
	cnpj CHAR(18)    ,
	dt_emissao_cnpj DATE    ,
	inscricao_estadual VARCHAR(20)    ,
	dt_emissao_insc_estadual DATE    ,
	alvara VARCHAR(20)    ,
	dt_emissao_alvara DATE    ,
	dt_validade_alvara DATE      ,
PRIMARY KEY(id, id_empresa)  ,
	FOREIGN KEY(id_empresa)
		REFERENCES empresa(id));


CREATE INDEX documentos_empresa_FK1 ON documentos_empresa (id_empresa);


CREATE INDEX IFK_documentos_empresa ON documentos_empresa (id_empresa);


CREATE TABLE telefones (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NULL ,
	id_empresa BIGINT   NULL ,
	tipo_telefone VARCHAR(45)   NOT NULL ,
	num_telefone VARCHAR(20)   NOT NULL   ,
PRIMARY KEY(id)    ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id),
	FOREIGN KEY(id_empresa)
		REFERENCES empresa(id));


CREATE INDEX telefones_FK1 ON telefones (id_individuo);
CREATE INDEX telefones_FK2 ON telefones (id_empresa);


CREATE INDEX IFK_individuo_telefones ON telefones (id_individuo);
CREATE INDEX IFK_empresa_telefones ON telefones (id_empresa);


CREATE TABLE individuo_imovel (
	id_individuo BIGINT   NOT NULL ,
	id_imovel BIGINT   NOT NULL   ,
PRIMARY KEY(id_individuo, id_imovel)    ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id),
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX individuo_imovel_FK1 ON individuo_imovel (id_individuo);
CREATE INDEX individuo_imovel_FK2 ON individuo_imovel (id_imovel);


CREATE INDEX IFK_individuo_imovel ON individuo_imovel (id_individuo);
CREATE INDEX IFK_imovel_individuo ON individuo_imovel (id_imovel);


CREATE TABLE empresa_imovel (
	id_empresa BIGINT   NOT NULL ,
	id_imovel BIGINT   NOT NULL   ,
PRIMARY KEY(id_empresa, id_imovel)    ,
	FOREIGN KEY(id_empresa)
		REFERENCES empresa(id),
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX empresa_imovel_FK1 ON empresa_imovel (id_empresa);
CREATE INDEX empresa_imovel_FK2 ON empresa_imovel (id_imovel);


CREATE INDEX IFK_empresa_imovel ON empresa_imovel (id_empresa);
CREATE INDEX IFK_imovel_empresa ON empresa_imovel (id_imovel);


CREATE TABLE historico_habitacional_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	id_imovel BIGINT   NOT NULL   ,
	dt_entrada DATE   ,
	dt_saida DATE   ,
PRIMARY KEY(id, id_individuo, id_imovel)    ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id),
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX historico_habitacional_individuo_FK1 ON historico_habitacional_individuo (id_individuo);
CREATE INDEX historico_habitacional_individuo_FK2 ON historico_habitacional_individuo (id_imovel);


CREATE INDEX IFK_individuo_historico_individuo ON historico_habitacional_individuo (id_individuo);
CREATE INDEX IFK_imovel_historico_individuo ON historico_habitacional_individuo (id_imovel);


CREATE TABLE historico_habitacional_empresa (
	id BIGSERIAL   NOT NULL ,
	id_empresa BIGINT   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	dt_entrada DATE    ,
	dt_saida DATE      ,
PRIMARY KEY(id, id_empresa, id_imovel)    ,
	FOREIGN KEY(id_empresa)
		REFERENCES empresa(id),
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX historico_habitacional_empresa_FK1 ON historico_habitacional_empresa (id_empresa);
CREATE INDEX historico_habitacional_empresa_FK2 ON historico_habitacional_empresa (id_imovel);


CREATE INDEX IFK_empresa_historico_empresa ON historico_habitacional_empresa (id_empresa);
CREATE INDEX IFK_imovel_historico_empresa ON historico_habitacional_empresa (id_imovel);


CREATE TABLE secretarias (
	id SERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL ,
	descricao TEXT    ,
	ativo CHAR(3)   NOT NULL   ,
PRIMARY KEY(id));


CREATE TABLE grupos (
	id SERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL ,
	descricao TEXT    ,
	ativo CHAR(3)   NOT NULL   ,
PRIMARY KEY(id));


CREATE TABLE permissoes (
	id SERIAL   NOT NULL ,
	nome VARCHAR(20)   NOT NULL ,
	descricao VARCHAR(255)    ,
PRIMARY KEY(id));


CREATE TABLE grupos_permissoes (
	id_grupo INTEGER   NOT NULL ,
	id_permissao INTEGER   NOT NULL   ,
	permitido CHAR(1)   NOT NULL   ,
PRIMARY KEY(id_grupo, id_permissao)    ,
	FOREIGN KEY(id_permissao)
		REFERENCES permissoes(id),
	FOREIGN KEY(id_grupo)
		REFERENCES grupos(id));


CREATE INDEX grupos_permissoes_FK1 ON grupos_permissoes (id_permissao);
CREATE INDEX grupos_permissoes_FK2 ON grupos_permissoes (id_grupo);


CREATE INDEX IFK_permissoes_grupos ON grupos_permissoes (id_permissao);
CREATE INDEX IFK_grupos_permissoes ON grupos_permissoes (id_grupo);


CREATE TABLE usuarios (
	id SERIAL   NOT NULL ,
	id_grupo INTEGER   NOT NULL ,
	id_secretaria INTEGER   NOT NULL ,
	matricula VARCHAR(20)   NOT NULL ,
	senha VARCHAR(20)   NOT NULL ,
	foto TEXT    ,
	nome VARCHAR(255)   NOT NULL ,
	email VARCHAR(255)    ,
	ativo CHAR(3)   NOT NULL   ,
PRIMARY KEY(id, id_grupo, id_secretaria)    ,
	FOREIGN KEY(id_grupo)
		REFERENCES grupos(id),
	FOREIGN KEY(id_secretaria)
		REFERENCES secretarias(id));


CREATE INDEX usuarios_FK1 ON usuarios (id_grupo);
CREATE INDEX usuarios_FK2 ON usuarios (id_secretaria);


CREATE INDEX IFK_grupos_usuarios ON usuarios (id_grupo);
CREATE INDEX IFK_secretarias_usuarios ON usuarios (id_secretaria);

