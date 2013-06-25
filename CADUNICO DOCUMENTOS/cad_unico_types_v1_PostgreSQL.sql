----------------------------------------------------------------- TIPOS DE DADOS DO SISTEMA -------------------------------------------------------------------


CREATE TYPE tp_familia AS (
    id BIGINT,
	remocao_familia CHAR(3),
	situacao_remocao VARCHAR(45),
	especifique_remocao VARCHAR(255)
);


CREATE TYPE tp_individuo AS (
    id BIGINT,
	id_familia BIGINT,
	responsavel_familia CHAR(3),
	nome VARCHAR(255),
	apelido VARCHAR(80),
	idade VARCHAR(20),
	sexo CHAR(2),
	etnia VARCHAR(45),
	estado_civil VARCHAR(45),
	nome_mae VARCHAR(255),
	nome_pai VARCHAR(255),
	responsavel VARCHAR(255),
	grau_parentesco VARCHAR(100),
	prestou_informacao VARCHAR(255)
);


CREATE TYPE tp_certidao_individuo AS (
    id BIGINT,
	id_individuo BIGINT,
	dt_nascimento DATE,
	onde_nasceu VARCHAR(255),
	naturalidade VARCHAR(100),
	nasc_registrado CHAR(3),
	cd_cartorio VARCHAR(20),
	nm_cartorio VARCHAR(255),
	tipo_certidao VARCHAR(45),
	dt_reg_certidao DATE,
	municipio_certidao VARCHAR(80),
	uf_certidao CHAR(2),
	num_termo VARCHAR(20),
	num_livro VARCHAR(20),
	num_folha VARCHAR(20)
);


CREATE TYPE tp_documento_individuo AS (
    id BIGINT,
	id_individuo BIGINT,
	tipo VARCHAR(50),
	numero VARCHAR(20),
	serie VARCHAR(30),
	data_emissao DATE,
	uf_emissao CHAR(2),
	cidade VARCHAR(100),
	orgao_emissor VARCHAR(100),
	zona VARCHAR(50),
	secao VARCHAR(50),
	categoria VARCHAR(10),
	validade VARCHAR(30),
	sts_documento VARCHAR(20)
);

CREATE TYPE tp_escolaridade_individuo AS (
    id BIGINT,
	id_individuo BIGINT,
	le_escreve CHAR(3),
	grau_escolaridade VARCHAR(80),
	unidade_educacional VARCHAR(255)
);


CREATE TYPE tp_profissional_individuo AS (
    id BIGINT,
	id_individuo BIGINT,
	situacao_trabalhista VARCHAR(80),
	obs_situacao_trabalhista TEXT,
	tipo_trabalho VARCHAR(80),
	obs_tipo_trabalho TEXT,
	nm_trabalho VARCHAR(255),
	possui_renda VARCHAR(45),
	renda DECIMAL(10,2),
	outras_rendas DECIMAL(10,2),
	tipo_beneficio VARCHAR(45),
	doacao_regular DECIMAL(10,2),
	aposentadoria_pensao DECIMAL(10,2),
	seg_desemprego DECIMAL(10,2),
	pensao_alimentar DECIMAL(10,2),
	outros_beneficios DECIMAL(10,2),
	num_bpcloas VARCHAR(20)
);


CREATE TYPE tp_deficiente_individuo AS (
    id BIGINT,
	id_individuo BIGINT,
	deficiente CHAR(3),
	tipo_deficiencia TEXT,
	obs_tipo_deficiencia TEXT,
	causa_deficiencia VARCHAR(100),
	obs_causa_deficiencia TEXT,
	quando_adquiriu VARCHAR(20),
	depende_cuidados VARCHAR(80),
	cadastro_sepedi CHAR(3)
);


CREATE TYPE tp_anexo_individuo AS (
    id BIGINT,
	id_individuo BIGINT,
	caminho TEXT,
	tipo CHAR(1)
);


CREATE TYPE tp_empresa AS (
    id BIGINT,
	razao_social VARCHAR(255),
	nm_fantasia VARCHAR(255),
	fundador VARCHAR(255),
	dt_fundacao DATE,
	local_origem VARCHAR(255)
);


CREATE TYPE tp_documento_empresa AS (
    id BIGINT,
	id_empresa BIGINT,
	cnpj CHAR(18),
	dt_emissao_cnpj DATE,
	inscricao_estadual VARCHAR(20),
	dt_emissao_insc_estadual DATE,
	alvara VARCHAR(20),
	dt_emissao_alvara DATE,
	dt_validade_alvara DATE
);


CREATE TYPE tp_telefone AS (
    id BIGINT,
	id_individuo BIGINT,
	id_empresa BIGINT,
	tipo_telefone VARCHAR(45),
	num_telefone VARCHAR(20)
);


CREATE TYPE tp_imovel AS (
    id BIGINT,
	id_nucleo BIGINT,
	tipo_imovel VARCHAR(60),
	situacao_imovel VARCHAR(45),
	valor_aluguel DECIMAL(10,2),
	tipo_propriedade VARCHAR(45),
	doc_propriedade VARCHAR(60),
	num_doc_propriedade VARCHAR(45),
	construcao VARCHAR(20),
	localidade VARCHAR(255),
	paga_iptu CHAR(3),
	ic VARCHAR(20),
	selagem VARCHAR(20)
);


CREATE TYPE tp_composicao_imovel AS (
    id BIGINT,
	id_imovel BIGINT,
	material_parede VARCHAR(100),
	especifique_parede TEXT,
	material_piso VARCHAR(100),
	especifique_piso TEXT,
	material_cobertura VARCHAR(100),
	especifique_cobertura TEXT,
	num_comodos INTEGER,
	num_salas INTEGER,
	num_cozinhas INTEGER,
	num_quartos INTEGER,
	num_banheiros INTEGER,
	num_areas_servicos INTEGER,
	num_anexos INTEGER,
	num_outros_comodos INTEGER,
	num_servem_dormitorio INTEGER
);


CREATE TYPE tp_endereco_imovel AS (
    id BIGINT,
	id_imovel BIGINT,
	tipo_logradouro VARCHAR(50),
	logradouro VARCHAR(255),
	numero VARCHAR(20),
	complemento VARCHAR(255),
	cep CHAR(10),
	bairro VARCHAR(80),
	municipio VARCHAR(80),
	uf CHAR(2),
	tipo_area VARCHAR(20),
	latitude DOUBLE PRECISION,
	longitude DOUBLE PRECISION
);


CREATE TYPE tp_servico_imovel AS (
    id BIGINT,
	id_imovel BIGINT,
	existe_pavimentacao VARCHAR(45),
	iluminacao_utilizada VARCHAR(45),
	abastecimento_agua VARCHAR(45),
	tratamento_agua VARCHAR(45),
	agua_encanada VARCHAR(45),
	existe_banheiro CHAR(3),
	escoamento_sanitario VARCHAR(45),
	tratamento_lixo VARCHAR(45),
	presenca_animais VARCHAR(45)
);


CREATE TYPE tp_demolicao_imovel AS (
    id BIGINT,
	id_imovel BIGINT,
	dt_demolicao DATE,
	horario_demolicao CHAR(5),
	num_processo VARCHAR(20),
	motivo TEXT,
	executada_por VARCHAR(255)
);


CREATE TYPE tp_anexo_demolicao AS (
    id BIGINT,
	id_demolicao BIGINT,
	caminho TEXT,
	tipo CHAR(1)
);


CREATE TYPE tp_anexo_imovel AS (
    id BIGINT,
	id_imovel BIGINT,
	caminho TEXT,
	tipo CHAR(1)
);


CREATE TYPE tp_nucleo AS (
    id BIGINT,
	nome VARCHAR(255),
	origem VARCHAR(20),
	ocupacao VARCHAR(255),
	area_total DOUBLE PRECISION,
	area_ocupada DOUBLE PRECISION,
	num_domicilios INTEGER,
	populacao_estimada INTEGER,
	pop_fonte_dados VARCHAR(45),
	pop_outra_fonte_dados VARCHAR(255),
	renda_populacao VARCHAR(45),
	inicio_ocupacao VARCHAR(45),
	setor_cadastral VARCHAR(20),
	zona VARCHAR(20),
	controle_ocupacao CHAR(3),
	obs_controle_ocupacao TEXT,
	padrao_construtivo VARCHAR(80),
	transporte_coletivo CHAR(3),
	adensamento CHAR(3),
	adens_fonte_dados VARCHAR(255),
	obs_adensamento TEXT,
	uso_incompativel CHAR(3)
);


CREATE TYPE tp_infraestrutura_urbana AS (
    id BIGINT,
	id_nucleo BIGINT,
	abastecimento_agua CHAR(3),
	coleta_esgoto CHAR(3),
	servicos_limpeza CHAR(3),
	aguas_pluviais_superficial CHAR(3),
	aguas_pluviais_rede CHAR(3),
	energia_eletrica CHAR(3),
	iluminacao_publica CHAR(3)
);


CREATE TYPE tp_situacao_fundiaria AS (
    id BIGINT,
	id_nucleo BIGINT,
	propriedade VARCHAR(20),
	proprietario VARCHAR(255),
	obs_propriedade TEXT,
	decreto_aprovacao VARCHAR(255),
	registrado CHAR(3),
	num_matricula VARCHAR(20),
	destinacao_areas DOUBLE PRECISION,
	desc_destinacao_areas TEXT,
	desc_zonas_solo TEXT,
	desc_ecologico_economico TEXT,
	processos_judiciais CHAR(3),
	num_processo VARCHAR(45),
	num_ordem VARCHAR(45),
	vara VARCHAR(255),
	existencia_embargos CHAR(3),
	obs_judiciais TEXT
);


CREATE TYPE tp_anexo_zoneamento AS (
    id BIGINT,
	id_fundiaria BIGINT,
	caminho TEXT,
	tipo CHAR(1)
);


CREATE TYPE tp_anexo_judicial AS (
    id BIGINT,
	id_fundiaria BIGINT,
	caminho TEXT,
	tipo CHAR(1)
);


CREATE TYPE tp_acao_nucleo AS (
    id BIGINT,
	id_nucleo BIGINT,
	remanejamento CHAR(3),
	reassentamento CHAR(3),
	desconstrucao CHAR(3),
	melhoria_habitacional CHAR(3),
	fonte_melhoria VARCHAR(255),
	recuperacao_ambiental CHAR(3),
	prad VARCHAR(255),
	adequacao_infraestrutura CHAR(3),
	fonte_adequacao VARCHAR(255),
	outros CHAR(3),
	desc_outros VARCHAR(255)
);


CREATE TYPE tp_remanejamento AS (
    id BIGINT,
	id_acao BIGINT,
	estimativa_relocacao CHAR(3),
	num_remocao_definitiva INTEGER,
	num_remocao_provisoria INTEGER
);


CREATE TYPE tp_reassentamento AS (
    id BIGINT,
	id_acao BIGINT,
	estimativa_remocao CHAR(3),
	num_a_construir INTEGER,
	num_provisorias INTEGER,
	local_definitivo VARCHAR(255)
);


CREATE TYPE tp_desconstrucao AS (
    id BIGINT,
	id_acao BIGINT,
	num_a_demolir INTEGER,
	motivo TEXT,
	processos TEXT
);


CREATE TYPE tp_aspecto_ambiental AS (
    id BIGINT,
	id_nucleo BIGINT,
	area_risco CHAR(3),
	app CHAR(3),
	area_verde CHAR(3),
	area_agricola CHAR(3),
	outros CHAR(3),
	latitude DOUBLE PRECISION,
	longitude DOUBLE PRECISION
);


CREATE TYPE tp_app AS (
    id BIGINT,
	id_aspecto_ambiental BIGINT,
	corpo_dagua CHAR(3),
	brejo_charco CHAR(3),
	topo_morro CHAR(3),
	enconsta CHAR(3),
	restinga CHAR(3),
	outros CHAR(3),
	especifique_outros TEXT
);


CREATE TYPE tp_area_risco AS (
    id BIGINT,
	cd_setor VARCHAR(45),
	grau_risco VARCHAR(45),
	vegetacao VARCHAR(45),
	processo_instabilizacao VARCHAR(45),
	condicoes_solo VARCHAR(60),
	existe_pavimentacao VARCHAR(20),
	obs_pavimentacao VARCHAR(255),
	latitude DOUBLE PRECISION,
	longitude DOUBLE PRECISION
);


CREATE TYPE tp_programa_habitacional AS (
    id BIGINT,
	id_nucleo BIGINT,
	material_construcao CHAR(3),
	producao_moradias CHAR(3),
	assistencia_tecnica CHAR(3),
	urb_assentamentos_precarios CHAR(3),
	complementacao_infraestrutura CHAR(3),
	regularizacao_fundiaria CHAR(3),
	cdhu CHAR(3),
	pmcmv CHAR(3)
);


CREATE TYPE tp_via_publica AS (
    id BIGINT,
	id_recurso INTEGER,
	id_nucleo BIGINT,
	descricao VARCHAR(255)
);


CREATE TYPE tp_recurso_mobilidade AS (
    id INTEGER,
	nome VARCHAR(255)
);


CREATE TYPE tp_institucional_social AS (
    id BIGINT,
	id_recurso INTEGER,
	id_nucleo BIGINT,
	descricao VARCHAR(255)
);


CREATE TYPE tp_recurso_social AS (
    id INTEGER,
	nome VARCHAR(255)
);


CREATE TYPE tp_anexo_transporte AS (
    id BIGINT,
	id_nucleo BIGINT,
	caminho TEXT,
	tipo CHAR(1)
);


CREATE TYPE tp_secretaria AS (
    id INTEGER,
	nome VARCHAR(255),
	descricao TEXT,
	ativo CHAR(3)
);


CREATE TYPE tp_grupo AS (
    id INTEGER,
	nome VARCHAR(255),
	descricao TEXT,
	ativo CHAR(3)
);


CREATE TYPE tp_permissao AS (
    id INTEGER,
	nome VARCHAR(20),
	descricao VARCHAR(255)
);


CREATE TYPE tp_usuario AS (
    id INTEGER,
	id_grupo INTEGER,
	id_secretaria INTEGER,
	matricula VARCHAR(20),
	senha VARCHAR(32),
	foto TEXT,
	nome VARCHAR(255),
	email VARCHAR(255),
	ativo CHAR(3)
);

