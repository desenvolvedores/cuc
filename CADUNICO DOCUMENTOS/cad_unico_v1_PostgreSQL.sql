CREATE DATABASE cadunico;
USE cadunico;


------------------------------------------------------------------ ESTRUTURA DAS TABELAS ---------------------------------------------------------------------


CREATE TABLE nucleo (
	id BIGSERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL DEFAULT '' ,
	origem VARCHAR(20)   NOT NULL DEFAULT '' ,
	ocupacao VARCHAR(255)   NOT NULL DEFAULT '' ,
	area_total DOUBLE PRECISION DEFAULT 0.00 ,
	area_ocupada DOUBLE PRECISION DEFAULT 0.00 ,
	num_domicilios INTEGER   NOT NULL DEFAULT 0 ,
	populacao_estimada INTEGER   NOT NULL DEFAULT 0 ,
	pop_fonte_dados VARCHAR(45)   NOT NULL DEFAULT '' ,
	pop_outra_fonte_dados VARCHAR(255) DEFAULT '' ,
	renda_populacao VARCHAR(100)   NOT NULL DEFAULT '' ,
	inicio_ocupacao VARCHAR(45) DEFAULT '' ,
	setor_cadastral VARCHAR(20)   NOT NULL DEFAULT '' ,
	zona VARCHAR(20)   NOT NULL DEFAULT '' ,
	controle_ocupacao CHAR(3)   NOT NULL DEFAULT 'Não' ,
	obs_controle_ocupacao TEXT    ,
	padrao_construtivo VARCHAR(80)   NOT NULL DEFAULT '' ,
	transporte_coletivo CHAR(3)   NOT NULL DEFAULT 'Não' ,
	adensamento CHAR(3)   NOT NULL DEFAULT 'Não' ,
	adens_fonte_dados VARCHAR(255) DEFAULT '' ,
	obs_adensamento TEXT    ,
	uso_incompativel VARCHAR(500)   NOT NULL DEFAULT '' ,
PRIMARY KEY(id));


CREATE TABLE infraestrutura_urbana (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	abastecimento_agua CHAR(3)   NOT NULL DEFAULT 'Não' ,
	coleta_esgoto CHAR(3)   NOT NULL DEFAULT 'Não' ,
	servicos_limpeza CHAR(3)   NOT NULL DEFAULT 'Não' ,
	aguas_pluviais_superficial CHAR(3)   NOT NULL DEFAULT 'Não' ,
	aguas_pluviais_rede CHAR(3)   NOT NULL DEFAULT 'Não' ,
	energia_eletrica CHAR(3)   NOT NULL DEFAULT 'Não' ,
	iluminacao_publica CHAR(3)   NOT NULL   DEFAULT 'Não' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX infraestrutura_urbana_FK1 ON infraestrutura_urbana (id_nucleo);


CREATE INDEX IFK_nucleo_infraestrutura_urba ON infraestrutura_urbana (id_nucleo);


CREATE TABLE situacao_fundiaria (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	propriedade VARCHAR(20)   NOT NULL DEFAULT '' ,
	proprietario VARCHAR(255)    DEFAULT '' ,
	obs_propriedade TEXT    ,
	decreto_aprovacao VARCHAR(255)    DEFAULT '' ,
	registrado CHAR(3)   NOT NULL DEFAULT 'Não' ,
	num_matricula VARCHAR(20)    DEFAULT '' ,
	destinacao_areas DOUBLE PRECISION    DEFAULT 0.00 ,
	desc_destinacao_areas TEXT    ,
	desc_zonas_solo TEXT    ,
	desc_ecologico_economico TEXT   NOT NULL ,
	processos_judiciais CHAR(3)   NOT NULL DEFAULT 'Não' ,
	num_processo VARCHAR(45)    DEFAULT '' ,
	num_ordem VARCHAR(45)    DEFAULT '' ,
	vara VARCHAR(255)    DEFAULT '' ,
	existencia_embargos CHAR(3)   NOT NULL DEFAULT 'Não' ,
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
	tipo CHAR(1)   NOT NULL   DEFAULT 'D' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_fundiaria)
		REFERENCES situacao_fundiaria(id));


CREATE INDEX anexo_judicial_FK1 ON anexo_judicial (id_fundiaria);


CREATE INDEX IFK_fundiaria_anexo_judicial ON anexo_judicial (id_fundiaria);


CREATE TABLE anexo_zoneamento (
	id BIGSERIAL   NOT NULL ,
	id_fundiaria BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   DEFAULT 'D' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_fundiaria)
		REFERENCES situacao_fundiaria(id));


CREATE INDEX anexo_zoneamento_FK1 ON anexo_zoneamento (id_fundiaria);


CREATE INDEX IFK_fundiaria_anexo_zoneamento ON anexo_zoneamento (id_fundiaria);


CREATE TABLE aspectos_ambientais (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	area_risco CHAR(3)   NOT NULL DEFAULT 'Não' ,
	area_verde CHAR(3)   NOT NULL DEFAULT 'Não' ,
	area_agricola CHAR(3)   NOT NULL DEFAULT 'Não' ,
	outros CHAR(3)   NOT NULL  DEFAULT 'Não' ,
	outros_especifique TEXT   ,
	latitude DOUBLE PRECISION    DEFAULT 0.00 ,
	longitude DOUBLE PRECISION   DEFAULT 0.00 ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX aspectos_ambientais_FK1 ON aspectos_ambientais (id_nucleo);


CREATE INDEX IFK_nucleo_aspectos_ambientais ON aspectos_ambientais (id_nucleo);


CREATE TABLE apps (
	id BIGSERIAL   NOT NULL ,
	id_ambiental BIGINT   NOT NULL ,
	corpo_dagua CHAR(3)   NOT NULL DEFAULT 'Não' ,
	brejo_charco CHAR(3)   NOT NULL DEFAULT 'Não' ,
	topo_morro CHAR(3)   NOT NULL DEFAULT 'Não' ,
	enconsta CHAR(3)   NOT NULL DEFAULT 'Não' ,
	restinga CHAR(3)   NOT NULL DEFAULT 'Não' ,
	outros CHAR(3)   NOT NULL DEFAULT 'Não' ,
	especifique_outros TEXT      ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_aspecto_ambiental)
		REFERENCES aspectos_ambientais(id));


CREATE INDEX apps_FK1 ON apps (id_ambiental);


CREATE INDEX IFK_aspectos_ambientais_apps ON apps (id_ambiental);


CREATE TABLE area_risco (
	id BIGSERIAL   NOT NULL ,
	cd_setor VARCHAR(45)    DEFAULT '' ,
	grau_risco VARCHAR(45)    DEFAULT '' ,
	vegetacao VARCHAR(45)    DEFAULT '' ,
	processo_instabilizacao VARCHAR(45)    DEFAULT '' ,
	condicoes_solo VARCHAR(60)    DEFAULT '' ,
	existe_pavimentacao VARCHAR(20)    NOT NULL DEFAULT '' ,
	obs_pavimentacao VARCHAR(255)     DEFAULT '' ,
	latitude DOUBLE PRECISION    DEFAULT 0.00 ,
	longitude DOUBLE PRECISION   DEFAULT 0.00 ,
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
	remanejamento CHAR(3)   NOT NULL DEFAULT 'Não' ,
	reassentamento CHAR(3)   NOT NULL DEFAULT 'Não' ,
	desconstrucao CHAR(3)   NOT NULL DEFAULT 'Não' ,
	melhoria_habitacional CHAR(3)   NOT NULL DEFAULT 'Não' ,
	fonte_melhoria VARCHAR(255)    DEFAULT '' ,
	recuperacao_ambiental CHAR(3)   NOT NULL DEFAULT 'Não' ,
	prad VARCHAR(255)    DEFAULT '' ,
	adequacao_infraestrutura CHAR(3)   NOT NULL DEFAULT 'Não' ,
	fonte_adequacao VARCHAR(255)    DEFAULT '' ,
	outros CHAR(3)   NOT NULL DEFAULT 'Não' ,
	desc_outros VARCHAR(255)      DEFAULT '' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX acoes_nucleo_FK1 ON acoes_nucleo (id_nucleo);


CREATE INDEX IFK_nucleo_acoes ON acoes_nucleo (id_nucleo);


CREATE TABLE reassentamentos (
	id BIGSERIAL   NOT NULL ,
	id_acao BIGINT   NOT NULL ,
	estimativa_remocao CHAR(3)   NOT NULL DEFAULT 'Não' ,
	num_a_construir INTEGER   NOT NULL DEFAULT 0 ,
	num_provisorias INTEGER   NOT NULL DEFAULT 0 ,
	local_definitivo VARCHAR(255)   NOT NULL   DEFAULT '' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_acao)
		REFERENCES acoes_nucleo(id));


CREATE INDEX reassentamentos_FK1 ON reassentamentos (id_acao);


CREATE INDEX IFK_acao_nucleo_reassentamento ON reassentamentos (id_acao);


CREATE TABLE remanejamentos (
	id BIGSERIAL   NOT NULL ,
	id_acao BIGINT   NOT NULL ,
	estimativa_relocacao CHAR(3)   NOT NULL DEFAULT 'Não' ,
	num_remocao_definitiva INTEGER   NOT NULL DEFAULT 0 ,
	num_remocao_provisoria INTEGER   NOT NULL   DEFAULT 0 ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_acao)
		REFERENCES acoes_nucleo(id));


CREATE INDEX remanejamentos_FK1 ON remanejamentos (id_acao);


CREATE INDEX IFK_acao_nucleo_remanejamento ON remanejamentos (id_acao);


CREATE TABLE desconstrucoes (
	id BIGSERIAL   NOT NULL ,
	id_acao BIGINT   NOT NULL ,
	num_a_demolir INTEGER   NOT NULL DEFAULT 0 ,
	motivo TEXT   NOT NULL ,
	processos TEXT   NOT NULL   ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_acao)
		REFERENCES acoes_nucleo(id));


CREATE INDEX desconstrucoes_FK1 ON desconstrucoes (id_acao);


CREATE INDEX IFK_acao_nucleo_desconstrucao ON desconstrucoes (id_acao);


CREATE TABLE recurso_mobilidade (
	id SERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL   DEFAULT '' ,
PRIMARY KEY(id));


CREATE TABLE vias_publicas (
	id_nucleo BIGINT   NOT NULL ,
	id_recurso INTEGER   NOT NULL   ,
	descricao VARCHAR(255)   NOT NULL DEFAULT ''   ,
	PRIMARY KEY(id_nucleo, id_recurso)    ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id),
	FOREIGN KEY(id_recurso)
		REFERENCES recurso_mobilidade(id)
);


CREATE INDEX vias_publicas_FK1 ON vias_publicas (id_nucleo);
CREATE INDEX vias_publicas_FK2 ON vias_publicas (id_recurso);


CREATE INDEX IFK_nucleo_recurso_mobilidade ON vias_publicas (id_nucleo);
CREATE INDEX IFK_recurso_mobilidade_nucleo ON vias_publicas (id_recurso);

CREATE TABLE recurso_social (
	id SERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL   ,
PRIMARY KEY(id));


CREATE TABLE institucional_social (
	id_nucleo BIGINT   NOT NULL ,
	id_recurso INTEGER   NOT NULL ,
	nome VARCHAR(255)   NOT NULL DEFAULT ''  ,
	PRIMARY KEY(id_nucleo, id_recurso)    ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id),
	FOREIGN KEY(id_recurso)
		REFERENCES recurso_social(id)
);


CREATE INDEX institucional_social_FK1 ON institucional_social (id_nucleo);
CREATE INDEX institucional_social_FK2 ON institucional_social (id_recurso);


CREATE INDEX IFK_nucleo_recurso_social ON institucional_social (id_nucleo);
CREATE INDEX IFK_recurso_social_nucleo ON institucional_social (id_recurso);


CREATE TABLE programas_habitacionais (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	material_construcao CHAR(3)   NOT NULL DEFAULT 'Não' ,
	producao_moradias CHAR(3)   NOT NULL DEFAULT 'Não' ,
	assistencia_tecnica CHAR(3)   NOT NULL DEFAULT 'Não' ,
	urb_assentamentos_precarios CHAR(3)   NOT NULL DEFAULT 'Não' ,
	complementacao_infraestrutura CHAR(3)   NOT NULL DEFAULT 'Não' ,
	regularizacao_fundiaria CHAR(3)   NOT NULL DEFAULT 'Não' ,
	cdhu CHAR(3)   NOT NULL DEFAULT 'Não' ,
	pmcmv CHAR(3)   NOT NULL   DEFAULT 'Não' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX programas_habitacionais_FK1 ON programas_habitacionais (id_nucleo);


CREATE INDEX IFK_nucleo_programas_habitacio ON programas_habitacionais (id_nucleo);


CREATE TABLE anexo_transporte (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   DEFAULT 'D' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX anexo_transporte_FK1 ON anexo_transporte (id_nucleo);


CREATE INDEX IFK_nucleo_anexo_transporte ON anexo_transporte (id_nucleo);


CREATE TABLE imovel (
	id BIGSERIAL   NOT NULL ,
	id_nucleo BIGINT   NOT NULL ,
	tipo_imovel VARCHAR(60)    NOT NULL DEFAULT '' ,
	situacao_imovel VARCHAR(45)    NOT NULL DEFAULT '' ,
	valor_aluguel DECIMAL(10,2)    DEFAULT 0.00 ,
	tipo_propriedade VARCHAR(45)    DEFAULT '' ,
	doc_propriedade VARCHAR(60)    DEFAULT '' ,
	num_doc_propriedade VARCHAR(45)    DEFAULT '' ,
	construcao VARCHAR(20)    DEFAULT '' ,
	localidade VARCHAR(255)    DEFAULT '' ,
	paga_iptu CHAR(3)    NOT NULL DEFAULT 'Não' ,
	ic VARCHAR(20)      DEFAULT '' ,
	selagem VARCHAR(20)     DEFAULT '' ,
	atendente VARCHAR(100)    DEFAULT '' ,
	atendente_atualizacao VARCHAR(100)    DEFAULT '' ,
	dt_atualizacao DATE    ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_nucleo)
		REFERENCES nucleo(id));


CREATE INDEX imovel_FK2 ON imovel (id_nucleo);


CREATE INDEX IFK_nucleo_imovel ON imovel (id_nucleo);


CREATE TABLE composicao_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	material_parede VARCHAR(100)    NOT NULL DEFAULT '' ,
	especifique_parede TEXT    ,
	material_piso VARCHAR(100)    NOT NULL DEFAULT '' ,
	especifique_piso TEXT    ,
	material_cobertura VARCHAR(100)    NOT NULL DEFAULT '' ,
	especifique_cobertura TEXT    ,
	num_comodos INTEGER    NOT NULL  DEFAULT 0 ,
	num_salas INTEGER    NOT NULL  DEFAULT 0 ,
	num_cozinhas INTEGER    NOT NULL  DEFAULT 0 ,
	num_quartos INTEGER    NOT NULL  DEFAULT 0 ,
	num_banheiros INTEGER    NOT NULL  DEFAULT 0 ,
	num_areas_servicos INTEGER    NOT NULL  DEFAULT 0 ,
	num_anexos INTEGER    NOT NULL  DEFAULT 0 ,
	num_outros_comodos INTEGER    NOT NULL  DEFAULT 0 ,
	num_servem_dormitorio INTEGER      NOT NULL  DEFAULT 0 ,
PRIMARY KEY(id, id_imovel)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX composicao_FK1 ON composicao_imovel (id_imovel);


CREATE INDEX IFK_composicao_imovel ON composicao_imovel (id_imovel);


CREATE TABLE endereco_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	tipo_logradouro VARCHAR(50)    NOT NULL DEFAULT '' ,
	logradouro VARCHAR(255)    NOT NULL DEFAULT '' ,
	numero VARCHAR(20)    NOT NULL DEFAULT '' ,
	complemento VARCHAR(255)    DEFAULT '' ,
	cep CHAR(10)    DEFAULT '' ,
	bairro VARCHAR(80)    NOT NULL DEFAULT '' ,
	municipio VARCHAR(80)    NOT NULL DEFAULT '' ,
	uf CHAR(2)    NOT NULL DEFAULT '' ,
	tipo_area VARCHAR(20)      NOT NULL DEFAULT '' ,
	latitude DOUBLE PRECISION    DEFAULT 0.00 ,
	longitude DOUBLE PRECISION   DEFAULT 0.00 ,
PRIMARY KEY(id, id_imovel)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX endereco_imovel_FK1 ON endereco_imovel (id_imovel);


CREATE INDEX IFK_endereco_imovel ON endereco_imovel (id_imovel);


CREATE TABLE servicos_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	existe_pavimentacao VARCHAR(45)    NOT NULL DEFAULT '' ,
	qual_pavimentacao VARCHAR(45)    DEFAULT '' ,
	iluminacao_utilizada VARCHAR(45)    NOT NULL DEFAULT '' ,
	especifique_iluminacao VARCHAR(255)    DEFAULT '' ,
	abastecimento_agua VARCHAR(45)    NOT NULL DEFAULT '' ,
	tratamento_agua VARCHAR(45)    NOT NULL DEFAULT '' ,
	agua_encanada VARCHAR(45)    NOT NULL DEFAULT '' ,
	existe_banheiro CHAR(3)    NOT NULL DEFAULT 'Não' ,
	escoamento_sanitario VARCHAR(45)    NOT NULL DEFAULT '' ,
	tratamento_lixo VARCHAR(45)    NOT NULL DEFAULT '' ,
	presenca_animais VARCHAR(45)      DEFAULT '' ,
PRIMARY KEY(id, id_imovel)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX servicos_FK1 ON servicos_imovel (id_imovel);


CREATE INDEX IFK_servicos_imovel ON servicos_imovel (id_imovel);


CREATE TABLE demolicao_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	dt_demolicao DATE    ,
	horario_demolicao CHAR(5)    DEFAULT '' ,
	num_processo VARCHAR(20)    DEFAULT '' ,
	motivo TEXT    ,
	executada_por VARCHAR(255)      DEFAULT '' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX demolicao_imovel_FK1 ON demolicao_imovel (id_imovel);


CREATE INDEX IFK_demolicao_imovel ON demolicao_imovel (id_imovel);


CREATE TABLE anexo_demolicao (
	id BIGSERIAL   NOT NULL ,
	id_demolicao BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   DEFAULT 'D' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_demolicao)
		REFERENCES demolicao_imovel(id));


CREATE INDEX anexo_demolicao_FK1 ON anexo_demolicao (id_demolicao);


CREATE INDEX IFK_demolicao_anexos ON anexo_demolicao (id_demolicao);


CREATE TABLE anexo_imovel (
	id BIGSERIAL   NOT NULL ,
	id_imovel BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   DEFAULT 'D' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_imovel)
		REFERENCES imovel(id));


CREATE INDEX anexo_imovel_FK1 ON anexo_imovel (id_imovel);


CREATE INDEX IFK_anexo_imovel ON anexo_imovel (id_imovel);


CREATE TABLE familias (
	id BIGSERIAL   NOT NULL ,
	remocao_familia CHAR(3)   NOT NULL DEFAULT 'Não' ,
	situacao_remocao VARCHAR(45)    DEFAULT '' ,
	especifique_remocao VARCHAR(255)      DEFAULT '' ,
	atendente VARCHAR(255)  NOT NULL    DEFAULT '' ,
	dt_atendimento DATE  NOT NULL    ,
	atendente_atualizacao VARCHAR(255)  NOT NULL    DEFAULT '' ,
	dt_atualizacao DATE  NOT NULL    ,
PRIMARY KEY(id));


CREATE TABLE individuo (
	id BIGSERIAL   NOT NULL ,
	id_familia BIGINT   NOT NULL ,
	responsavel_familia CHAR(3)   NOT NULL  DEFAULT 'Não' ,
	nome VARCHAR(255)    NOT NULL  DEFAULT '' ,
	apelido VARCHAR(80)    DEFAULT '' ,
	idade VARCHAR(20)    DEFAULT '' ,
	sexo CHAR(2)    NOT NULL  DEFAULT '' ,
	etnia VARCHAR(45)    NOT NULL  DEFAULT '' ,
	estado_civil VARCHAR(45)    NOT NULL  DEFAULT '' ,
	nome_mae VARCHAR(255)    DEFAULT '' ,
	nome_pai VARCHAR(255)    DEFAULT '' ,
	responsavel VARCHAR(255)    NOT NULL  DEFAULT '' ,
	grau_parentesco VARCHAR(100)    NOT NULL  DEFAULT '' ,
	observacoes TEXT  ,
	prestou_informacao VARCHAR(255)      NOT NULL  DEFAULT '' ,
	cpf_informante CHAR(15)  DEFAULT '' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_familia)
		REFERENCES familias(id));


CREATE INDEX individuo_FK1 ON individuo (id_familia);


CREATE INDEX IFK_familias_individuo ON individuo (id_familia);


CREATE TABLE certidao_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	dt_nascimento DATE    ,
	onde_nasceu VARCHAR(255)    NOT NULL  DEFAULT '' ,
	naturalidade VARCHAR(100)    DEFAULT '' ,
	nasc_registrado CHAR(3)    NOT NULL  DEFAULT 'Não' ,
	cd_cartorio VARCHAR(20)    DEFAULT '' ,
	nm_cartorio VARCHAR(255)    DEFAULT '' ,
	tipo_certidao VARCHAR(45)    DEFAULT '' ,
	dt_reg_certidao DATE    ,
	municipio_certidao VARCHAR(80)    DEFAULT '' ,
	uf_certidao CHAR(2)    DEFAULT '' ,
	num_termo VARCHAR(20)    DEFAULT '' ,
	num_livro VARCHAR(20)    DEFAULT '' ,
	num_folha VARCHAR(20)      DEFAULT '' ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX certidao_individuo_FK1 ON certidao_individuo (id_individuo);


CREATE INDEX IFK_certidao_individuo ON certidao_individuo (id_individuo);


CREATE TABLE documentos_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	tipo VARCHAR(50)  NOT NULL   DEFAULT '' ,
	numero VARCHAR(20)  NOT NULL   DEFAULT '' ,
	serie VARCHAR(30)   DEFAULT '' ,
	data_emissao DATE   ,
	uf_emissao CHAR(2)   DEFAULT '' ,
	cidade VARCHAR(100)   DEFAULT '' ,
	orgao_emissor VARCHAR(100)   DEFAULT '' ,
	zona VARCHAR(50)   DEFAULT '' ,
	secao VARCHAR(50)   DEFAULT '' ,
	categoria VARCHAR(10)   DEFAULT '' ,
	validade VARCHAR(30)   DEFAULT '' ,
	sts_documento VARCHAR(20)   DEFAULT '' ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX documentos_individuo_FK1 ON documentos_individuo (id_individuo);


CREATE INDEX IFK_documentos_individuo ON documentos_individuo (id_individuo);


CREATE TABLE escolaridade_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	grau_escolaridade VARCHAR(80)    NOT NULL  DEFAULT '' ,
	unidade_educacional VARCHAR(255)      DEFAULT '' ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX escolaridade_individuo_FK1 ON escolaridade_individuo (id_individuo);


CREATE INDEX IFK_escolaridade_individuo ON escolaridade_individuo (id_individuo);


CREATE TABLE profissional_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	situacao_trabalhista VARCHAR(80)    NOT NULL DEFAULT '' ,
	obs_situacao_trabalhista TEXT    ,
	tipo_trabalho VARCHAR(80)    DEFAULT '' ,
	obs_tipo_trabalho TEXT    ,
	nm_trabalho VARCHAR(255)   DEFAULT '' ,
	possui_renda VARCHAR(45)    DEFAULT '' ,
	renda DECIMAL(10,2)    NOT NULL  DEFAULT 0.00  ,
	outras_rendas DECIMAL(10,2)    NOT NULL  DEFAULT 0.00  ,
	tipo_beneficio VARCHAR(45)    DEFAULT '' ,
	doacao_regular DECIMAL(10,2)    NOT NULL  DEFAULT 0.00  ,
	aposentadoria_pensao DECIMAL(10,2)    NOT NULL  DEFAULT 0.00  ,
	seg_desemprego DECIMAL(10,2)    NOT NULL  DEFAULT 0.00  ,
	pensao_alimentar DECIMAL(10,2)    NOT NULL  DEFAULT 0.00  ,
	outros_beneficios DECIMAL(10,2)    NOT NULL  DEFAULT 0.00  ,
	num_bpcloas VARCHAR(20)      DEFAULT '' ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX profissional_individuo_FK1 ON profissional_individuo (id_individuo);


CREATE INDEX IFK_profissional_individuo ON profissional_individuo (id_individuo);


CREATE TABLE deficiente_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	deficiente CHAR(3)    DEFAULT 'Não' ,
	deficiencia_fisica CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	deficiencia_mental CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	transtorno_mental CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	sindrome_down CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	cegueira CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	baixa_visao CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	surdez_severa CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	surdez_moderada CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	obs_tipo_deficiencia TEXT    ,
	causa_deficiencia VARCHAR(100)    DEFAULT '' ,
	obs_causa_deficiencia TEXT    ,
	quando_adquiriu VARCHAR(20)    DEFAULT '' ,
	cuidados_familia CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	cuidados_especializado CHAR(3)  NOT NULL   DEFAULT 'Não' ,
	cuidados_vizinho CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	cuidados_instituicao CHAR(3)  NOT NULL    DEFAULT 'Não' ,
	cuidados_outros CHAR(3)  NOT NULL   DEFAULT 'Não' ,
	cadastro_sepedi VARCHAR(20)      DEFAULT '' ,
PRIMARY KEY(id, id_individuo)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX deficiente_individuo_FK1 ON deficiente_individuo (id_individuo);


CREATE INDEX IFK_deficiente_individuo ON deficiente_individuo (id_individuo);


CREATE TABLE anexo_individuo (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NOT NULL ,
	caminho TEXT   NOT NULL ,
	tipo CHAR(1)   NOT NULL   DEFAULT 'D' ,
PRIMARY KEY(id)  ,
	FOREIGN KEY(id_individuo)
		REFERENCES individuo(id));


CREATE INDEX anexo_individuo_FK1 ON anexo_individuo (id_individuo);


CREATE INDEX IFK_anexo_individuo ON anexo_individuo (id_individuo);


CREATE TABLE empresa (
	id BIGSERIAL   NOT NULL ,
	razao_social VARCHAR(255)    NOT NULL DEFAULT '' ,
	nm_fantasia VARCHAR(255)    NOT NULL DEFAULT '' ,
	fundador VARCHAR(255)    DEFAULT '' ,
	dt_fundacao DATE    ,
	local_origem VARCHAR(255)     DEFAULT '' ,
PRIMARY KEY(id));


CREATE TABLE documentos_empresa (
	id BIGSERIAL   NOT NULL ,
	id_empresa BIGINT   NOT NULL ,
	tipo VARCHAR(50)  NOT NULL   DEFAULT '' ,
	numero VARCHAR(20)  NOT NULL   DEFAULT '' ,
	serie VARCHAR(30)  DEFAULT '' ,
	data_emissao DATE   ,
	uf_emissao CHAR(2)  DEFAULT '' ,
	cidade VARCHAR(100)  DEFAULT '' ,
	orgao_emissor VARCHAR(100)  DEFAULT '' ,
	zona VARCHAR(50)   DEFAULT '' ,
	secao VARCHAR(50)   DEFAULT '' ,
	categoria VARCHAR(10)   DEFAULT '' ,
	validade VARCHAR(30)   DEFAULT '' ,
	sts_documento VARCHAR(20)   DEFAULT '' ,
PRIMARY KEY(id, id_empresa)  ,
	FOREIGN KEY(id_empresa)
		REFERENCES empresa(id));


CREATE INDEX documentos_empresa_FK1 ON documentos_empresa (id_empresa);


CREATE INDEX IFK_documentos_empresa ON documentos_empresa (id_empresa);


CREATE TABLE telefones (
	id BIGSERIAL   NOT NULL ,
	id_individuo BIGINT   NULL ,
	id_empresa BIGINT   NULL ,
	tipo_telefone VARCHAR(45)   NOT NULL DEFAULT '' ,
	num_telefone VARCHAR(20)   NOT NULL   DEFAULT '' ,
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


CREATE TABLE departamentos (
	id SERIAL   NOT NULL ,
	sigla VARCHAR(10)  UNIQUE NOT NULL DEFAULT '' ,
	nome VARCHAR(255)   NOT NULL DEFAULT '' ,
	descricao TEXT    ,
	ativo CHAR(3)   NOT NULL   DEFAULT 'Sim' ,
PRIMARY KEY(id));


CREATE TABLE grupos (
	id SERIAL   NOT NULL ,
	nome VARCHAR(255)   NOT NULL DEFAULT '' ,
	descricao TEXT    ,
	ativo CHAR(3)   NOT NULL  DEFAULT 'Sim' ,
PRIMARY KEY(id));


CREATE TABLE permissoes (
	id SERIAL   NOT NULL ,
	nome VARCHAR(20)   NOT NULL DEFAULT '' ,
	descricao VARCHAR(255)   DEFAULT '' ,
PRIMARY KEY(id));


CREATE TABLE grupos_permissoes (
	id_grupo INTEGER   NOT NULL ,
	id_permissao INTEGER   NOT NULL   ,
	permitido CHAR(1)   NOT NULL   DEFAULT 'N'   ,
PRIMARY KEY(id_grupo, id_permissao)    ,
	FOREIGN KEY(id_permissao)
		REFERENCES permissoes(id)
			ON DELETE CASCADE 
			ON UPDATE CASCADE,
	FOREIGN KEY(id_grupo)
		REFERENCES grupos(id)
			ON DELETE CASCADE 
			ON UPDATE CASCADE
);


CREATE INDEX grupos_permissoes_FK1 ON grupos_permissoes (id_permissao);
CREATE INDEX grupos_permissoes_FK2 ON grupos_permissoes (id_grupo);


CREATE INDEX IFK_permissoes_grupos ON grupos_permissoes (id_permissao);
CREATE INDEX IFK_grupos_permissoes ON grupos_permissoes (id_grupo);


CREATE TABLE usuarios (
	id SERIAL   NOT NULL ,
	id_grupo INTEGER   NOT NULL ,
	id_departamento INTEGER   NOT NULL ,
	usuario VARCHAR(20)   NOT NULL DEFAULT '' ,
	senha VARCHAR(32)   NOT NULL DEFAULT '' ,
	foto TEXT    ,
	nome VARCHAR(255)   NOT NULL DEFAULT '' ,
	email VARCHAR(255)    DEFAULT '' ,
	ativo CHAR(3)   NOT NULL   DEFAULT 'Sim' ,
PRIMARY KEY(id, id_grupo, id_departamento)    ,
	FOREIGN KEY(id_grupo)
		REFERENCES grupos(id),
	FOREIGN KEY(id_departamento)
		REFERENCES departamentos(id));


CREATE INDEX usuarios_FK1 ON usuarios (id_grupo);
CREATE INDEX usuarios_FK2 ON usuarios (id_departamento);


CREATE INDEX IFK_grupos_usuarios ON usuarios (id_grupo);
CREATE INDEX IFK_departamentos_usuarios ON usuarios (id_departamento);


INSERT INTO recurso_mobilidade (nome) VALUES 
('Ciclovia'),
('Ciclofaixa'),
('Via Pavimentada'),
('Via Perenizada'),
('Estrada'),
('Rodovia'),
('Obra em Via');


INSERT INTO recurso_social (nome) VALUES 
('CRAS'),
('PSF'),
('CEI'),
('EMEI'),
('EMEF'),
('E.E.'),
('Praça'),
('Equipamento de Lazer'),
('Esporte e Recereação'),
('Próprio Municipal'),
('ONG'),
('Instituição'),
('Associação');


INSERT INTO departamentos (sigla, nome, descricao, ativo) VALUES 
('GABIN', 'Gabinete do Prefeito', '', 'Sim'),
('SECAD', 'Secretaria de Administração', '', 'Sim'),
('SECAS', 'Secretaria de Assitência Social', '', 'Sim'),
('SAJUR', 'Secretaria de Assuntos Jurídicos', '', 'Sim'),
('SEPEDI', 'Secretaria dos Direitos das Pessoas com Deficiência e do Idoso', '', 'Sim'),
('SEDUC', 'Secretaria da Educação', '', 'Sim'),
('SECER', 'Secretaria de Esportes e Recreação', '', 'Sim'),
('SEFAZ', 'Secretaria da Fazenda', '', 'Sim'),
('SECHAB', 'Secretaria de Habitação e Patrimônio', '', 'Sim'),
('SEMAAP', 'Secretaria de Meio Ambiente, Agricultura e Pesca', '', 'Sim'),
('SECOP', 'Secretaria de Obras Públicas', '', 'Sim'),
('SEPEG', 'Secretaria do Planejamento, Economia e Gestão', '', 'Sim'),
('SESAU', 'Secretaria de Saúde', '', 'Sim'),
('SESEP', 'Secretaria de Serviços Públicos', '', 'Sim'),
('SETRAN', 'Secretaria de Trânsito', '', 'Sim'),
('SETUR', 'Secretaria de Turismo', '', 'Sim'),
('SEURB', 'Secretaria de Urbanismo', '', 'Sim');


INSERT INTO grupos (nome, descricao, ativo) VALUES 
('Administradores', 'Os usuários deste grupo tem permissão total no sistema.', 'Sim');


INSERT INTO permissoes (nome, descricao) VALUES 
('Grupos', 'Gerenciar grupos de usuários do sistema.'),
('Usuários', 'Gerenciar usuários do sistema.'),
('Departamentos', 'Gerenciar secretarias.'),
('Recursos de Acesso', 'Gerenciar recursos de acesso.'),
('Recursos Sociais', 'Gerenciar recursos sociais.');


INSERT INTO grupos_permissoes (id_grupo, id_permissao, permitido) VALUES 
(1, 1, 'S'),
(1, 2, 'S'),
(1, 3, 'S');


INSERT INTO usuarios (id_grupo, id_departamento, usuario, senha, foto, nome, email, ativo) VALUES 
(1, 1, 'root', MD5('CadHab100%'), '', 'Administrador', 'postmaster@caraguatatuba.sp.gov.br', 'Sim');

