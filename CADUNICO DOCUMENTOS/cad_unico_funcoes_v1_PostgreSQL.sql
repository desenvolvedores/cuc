----------------------------------------------------------------------- FUN«’ES B¡SICAS ----------------------------------------------------------------------


CREATE OR REPLACE FUNCTION remove_acentos(CHARACTER VARYING)
RETURNS CHARACTER VARYING AS $$
	SELECT translate($1, '·ÈÌÛ˙‡ËÏÚ˘„ı‚ÍÓÙÙ‰ÎÔˆ¸Á¡…Õ”⁄¿»Ã“Ÿ√’¬ Œ‘€ƒÀœ÷‹«', 'aeiouaeiouaoaeiooaeioucAEIOUAEIOUAOAEIOOAEIOUC')
$$ LANGUAGE SQL VOLATILE;


----------------------------------------------------------------------- FUN«’ES DO SISTEMA -------------------------------------------------------------------


-------------------- FAMÕLIAS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_familia
(CHAR(3), CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO familias (remocao_familia, situacao_remocao, especifique_remocao) VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_familia_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, remocao_familia, situacao_remocao, especifique_remocao FROM familias WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_familia_por_remocao_familia(CHAR(3))
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, remocao_familia, situacao_remocao, especifique_remocao FROM familias WHERE remocao_familia = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_familia_por_situacao_remocao(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, remocao_familia, situacao_remocao, especifique_remocao FROM familias WHERE situacao_remocao LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_familias()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, remocao_familia, situacao_remocao, especifique_remocao FROM familias;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_familia
(CHAR(3), CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE familias SET remocao_familia = $1, situacao_remocao = $2, especifique_remocao = $3 WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_familia(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM familias WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


--------------------- INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_individuo
(BIGINT, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO individuo (id_familia, responsavel_familia, nome, apelido, idade, sexo, etnia, estado_civil, nome_mae, nome_pai, responsavel, grau_parentesco, prestou_informacao) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_individuo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_familia, responsavel_familia, nome, apelido, idade, sexo, etnia, estado_civil, nome_mae, nome_pai, responsavel, grau_parentesco, prestou_informacao 
		FROM individuo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_individuo_por_cpf(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT i.id, i.id_familia, i.responsavel_familia, i.nome, i.apelido, i.idade, i.sexo, i.etnia, i.estado_civil, i.nome_mae, i.nome_pai, i.responsavel, i.grau_parentesco, i.prestou_informacao 
		FROM individuo AS i INNER JOIN documentos_individuo AS di ON i.id = di.id_individuo WHERE di.num_cpf LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_individuos()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_familia, responsavel_familia, nome, apelido, idade, sexo, etnia, estado_civil, nome_mae, nome_pai, responsavel, grau_parentesco, prestou_informacao 
		FROM individuo;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_individuo
(BIGINT, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE individuo SET id_familia = $1, responsavel_familia = $2, nome = $3, apelido = $4, idade = $5, sexo = $6, etnia = $7, estado_civil = $8, nome_mae = $9, nome_pai = $10, 
		responsavel = $11, grau_parentesco = $12, prestou_informacao = $13 WHERE id = $14;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- NASCIMENTO INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_nascimento_individuo
(BIGINT, DATE, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, DATE, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO nascimento_individuo (id_individuo, dt_nascimento, onde_nasceu, naturalidade, nasc_registrado, cd_cartorio, nm_cartorio, tipo_certidao, 
		dt_reg_certidao, municipio_certidao, uf_certidao, num_termo, num_livro, num_folha) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_nascimento_individuo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, dt_nascimento, onde_nasceu, naturalidade, nasc_registrado, cd_cartorio, nm_cartorio, tipo_certidao, dt_reg_certidao, 
		municipio_certidao, uf_certidao, num_termo, num_livro, num_folha 
		FROM nascimento_individuo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_nascimento_individuo_por_id_individuo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, dt_nascimento, onde_nasceu, naturalidade, nasc_registrado, cd_cartorio, nm_cartorio, tipo_certidao, dt_reg_certidao, 
		municipio_certidao, uf_certidao, num_termo, num_livro, num_folha 
		FROM nascimento_individuo WHERE id_individuo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_nascimento_individuo
(BIGINT, DATE, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, DATE, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE nascimento_individuo SET id_individuo = $1, dt_nascimento = $2, onde_nasceu = $3, naturalidade = $4, nasc_registrado = $5, cd_cartorio = $6, 
		nm_cartorio = $7, tipo_certidao = $8, dt_reg_certidao = $9, municipio_certidao = $10, uf_certidao = $11, num_termo = $12, num_livro = $13, 
		num_folha = $14 WHERE id = $15;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_nascimento_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM nascimento_individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- DOCUMENTOS INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_documentos_individuo
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), DATE, CHAR(14), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHAR(3), CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, DATE, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO documentos_individuo (id_individuo, num_rg, complemento_rg, orgao_emissor_rg, dt_emissao_rg, num_cpf, sts_cpf, num_eleitor, zona_eleitor, 
		secao_eleitor, num_cart_trab, serie_cart_trab, dt_emissao_cart_trab, orgao_emissor_cart_trab, tipo_cart_moto, num_cart_moto, serie_cart_moto, 
		dt_emissao_cart_moto, num_nis, num_pis, num_pasep, inscricao_mcmv) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17, $18, $19, $20, $21, $22);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_individuo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, num_rg, complemento_rg, orgao_emissor_rg, dt_emissao_rg, num_cpf, sts_cpf, num_eleitor, zona_eleitor, 
		secao_eleitor, num_cart_trab, serie_cart_trab, dt_emissao_cart_trab, orgao_emissor_cart_trab, tipo_cart_moto, num_cart_moto, serie_cart_moto, 
		dt_emissao_cart_moto, num_nis, num_pis, num_pasep, inscricao_mcmv 
		FROM documentos_individuo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_individuo_por_id_individuo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, num_rg, complemento_rg, orgao_emissor_rg, dt_emissao_rg, num_cpf, sts_cpf, num_eleitor, zona_eleitor, 
		secao_eleitor, num_cart_trab, serie_cart_trab, dt_emissao_cart_trab, orgao_emissor_cart_trab, tipo_cart_moto, num_cart_moto, serie_cart_moto, 
		dt_emissao_cart_moto, num_nis, num_pis, num_pasep, inscricao_mcmv 
		FROM documentos_individuo WHERE id_individuo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_documentos_individuo
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), DATE, CHAR(14), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHAR(3), CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, DATE, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE documentos_individuo SET id_individuo = $1, num_rg = $2, complemento_rg = $3, orgao_emissor_rg = $4, dt_emissao_rg = $5, num_cpf = $6, 
		sts_cpf = $7, num_eleitor = $8, zona_eleitor = $9, secao_eleitor = $10, num_cart_trab = $11, serie_cart_trab = $12, dt_emissao_cart_trab = $13, 
		orgao_emissor_cart_trab = $14, tipo_cart_moto = $15, num_cart_moto = $16, serie_cart_moto = $17, dt_emissao_cart_moto = $18, num_nis = $19, 
		num_pis = $20, num_pasep = $21, inscricao_mcmv = $22 WHERE id = $23; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_documentos_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM documentos_individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ESCOLARIDADE INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_escolaridade_individuo
(BIGINT, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO escolaridade_individuo (id_individuo, grau_escolaridade, unidade_educacional) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_escolaridade_individuo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, grau_escolaridade, unidade_educacional 
		FROM escolaridade_individuo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_escolaridade_individuo_por_id_individuo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, grau_escolaridade, unidade_educacional  
		FROM escolaridade_individuo WHERE id_individuo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_escolaridade_individuo
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE escolaridade_individuo SET id_individuo = $1, grau_escolaridade = $2, unidade_educacional = $3  
		WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_escolaridade_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM escolaridade_individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- PROFISSIONAL INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_profissional_individuo
(BIGINT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHARACTER VARYING, DECIMAL(10,2), DECIMAL(10,2), 
CHARACTER VARYING, DECIMAL(10,2), DECIMAL(10,2), DECIMAL(10,2), DECIMAL(10,2), DECIMAL(10,2), CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO profissional_individuo (id_individuo, situacao_trabalhista, obs_situacao_trabalhista, tipo_trabalho, obs_tipo_trabalho, nm_trabalho, 
		possui_renda, renda, outras_rendas, tipo_beneficio, doacao_regular, aposentadoria_pensao, seg_desemprego, pensao_alimentar, outros_beneficios, num_bpcloas) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_profissional_individuo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, situacao_trabalhista, obs_situacao_trabalhista, tipo_trabalho, obs_tipo_trabalho, nm_trabalho, possui_renda, 
		renda, outras_rendas, tipo_beneficio, doacao_regular, aposentadoria_pensao, seg_desemprego, pensao_alimentar, outros_beneficios, num_bpcloas
		FROM profissional_individuo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_profissional_individuo_por_id_individuo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, situacao_trabalhista, obs_situacao_trabalhista, tipo_trabalho, obs_tipo_trabalho, nm_trabalho, possui_renda, 
		renda, outras_rendas, tipo_beneficio, doacao_regular, aposentadoria_pensao, seg_desemprego, pensao_alimentar, outros_beneficios, num_bpcloas
		FROM profissional_individuo WHERE id_individuo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_profissional_individuo
(BIGINT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHARACTER VARYING, DECIMAL(10,2), DECIMAL(10,2), 
CHARACTER VARYING, DECIMAL(10,2), DECIMAL(10,2), DECIMAL(10,2), DECIMAL(10,2), DECIMAL(10,2), CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE profissional_individuo SET id_individuo = $1, situacao_trabalhista = $2, obs_situacao_trabalhista = $3, tipo_trabalho = $4, 
		obs_tipo_trabalho = $5, nm_trabalho = $6, possui_renda = $7, renda = $8, outras_rendas = $9, tipo_beneficio = $10, doacao_regular = $11, 
		aposentadoria_pensao = $12, seg_desemprego = $13, pensao_alimentar = $14, outros_beneficios = $15, num_bpcloas = $16 WHERE id = $17;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_profissional_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM profissional_individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- DEFICIENTE INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_deficiente_individuo
(BIGINT, CHAR(3), TEXT, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHARACTER VARYING, CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO deficiente_individuo (id_individuo, deficiente, tipo_deficiencia, obs_tipo_deficiencia, causa_deficiencia, 
		obs_causa_deficiencia, quando_adquiriu, depende_cuidados, cadastro_sepedi) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_deficiente_individuo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, deficiente, tipo_deficiencia, obs_tipo_deficiencia, causa_deficiencia, obs_causa_deficiencia, 
		quando_adquiriu, depende_cuidados, cadastro_sepedi FROM deficiente_individuo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_deficiente_individuo_por_id_individuo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, deficiente, tipo_deficiencia, obs_tipo_deficiencia, causa_deficiencia, obs_causa_deficiencia, 
		quando_adquiriu, depende_cuidados, cadastro_sepedi FROM deficiente_individuo WHERE id_individuo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_deficiente_individuo
(BIGINT, CHAR(3), TEXT, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE deficiente_individuo SET id_individuo = $1, deficiente = $2, tipo_deficiencia = $3, obs_tipo_deficiencia = $4, causa_deficiencia = $5, 
		obs_causa_deficiencia = $6, quando_adquiriu = $7, depende_cuidados = $8, cadastro_sepedi = $9 WHERE id = $10;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_deficiente_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM deficiente_individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ANEXO INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_anexo_individuo
(BIGINT, TEXT, CHAR(1))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO anexo_individuo (id_individuo, caminho, tipo) VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_anexo_individuo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, caminho, tipo FROM anexo_individuo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_individuo_por_id_individuo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, caminho, tipo FROM anexo_individuo WHERE id_individuo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_individuo_por_tipo(BIGINT, CHAR(1))
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, caminho, tipo FROM anexo_individuo WHERE id_individuo = $1 AND tipo = $2;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_anexo_individuo
(BIGINT, TEXT, CHAR(1), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE anexo_individuo SET id_individuo = $1, caminho = $2, tipo = $3 WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_individuo_por_id_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_individuo WHERE id_individuo = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- EMPRESA -----------------


CREATE OR REPLACE FUNCTION fn_inserir_empresa
(CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO empresa (razao_social, nm_fantasia, fundador, dt_fundacao, local_origem) VALUES ($1, $2, $3, $4, $5);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_empresa_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem FROM empresa WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_empresa_por_razao_social(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem FROM empresa WHERE razao_social LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_empresa_por_fantasia(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem FROM empresa WHERE nm_fantasia LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_empresas()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem FROM empresa;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_empresa
(CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE empresa SET razao_social = $1, nm_fantasia = $2, fundador = $3, dt_fundacao = $4, local_origem = $5 WHERE id = $6;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_empresa(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM empresa WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- DOCUMENTOS EMPRESA -----------------


CREATE OR REPLACE FUNCTION fn_inserir_documentos_empresa
(BIGINT, CHAR(18), DATE, CHARACTER VARYING, DATE, CHARACTER VARYING, DATE, DATE)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO documentos_empresa (id_empresa, cnpj, dt_emissao_cnpj, inscricao_estadual, dt_emissao_insc_estadual, alvara, 
		dt_emissao_alvara, dt_validade_alvara) VALUES ($1, $2, $3, $4, $5, $6, $7, $8);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_empresa_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_empresa, cnpj, dt_emissao_cnpj, inscricao_estadual, dt_emissao_insc_estadual, alvara, 
		dt_emissao_alvara, dt_validade_alvara FROM documentos_empresa WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_empresa_por_id_empresa(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_empresa, cnpj, dt_emissao_cnpj, inscricao_estadual, dt_emissao_insc_estadual, alvara, 
		dt_emissao_alvara, dt_validade_alvara FROM documentos_empresa WHERE id_empresa = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_documentos_empresa
(BIGINT, CHAR(18), DATE, CHARACTER VARYING, DATE, CHARACTER VARYING, DATE, DATE, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE documentos_empresa SET id_empresa = $1, cnpj = $2, dt_emissao_cnpj = $3, inscricao_estadual = $4, dt_emissao_insc_estadual = $5, 
		alvara = $6, dt_emissao_alvara = $7, dt_validade_alvara = $8 WHERE id = $9;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_documentos_empresa(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM documentos_empresa WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


------------------------ TELEFONES ---------------------


CREATE OR REPLACE FUNCTION fn_selecionar_telefone_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, id_empresa, tipo_telefone, num_telefone 
		FROM telefones WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_telefone
(CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE telefones SET tipo_telefone = $1, num_telefone = $2 
		WHERE id = $3;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_telefone(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM telefones WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- TELEFONES INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_telefone_individuo
(BIGINT, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO telefones (id_individuo, tipo_telefone, num_telefone) 
		VALUES ($1, $2, $3, $4);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_telefone_por_id_individuo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_individuo, tipo_telefone, num_telefone 
		FROM telefones WHERE id_individuo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_excluir_telefone_por_id_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM telefones WHERE id_individuo = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- TELEFONES EMPRESA -----------------


CREATE OR REPLACE FUNCTION fn_inserir_telefone_empresa
(BIGINT, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO telefones (id_empresa, tipo_telefone, num_telefone) 
		VALUES ($1, $2, $3, $4);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_telefone_por_id_empresa(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_empresa, tipo_telefone, num_telefone 
		FROM telefones WHERE id_empresa = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_excluir_telefone_por_id_empresa(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM telefones WHERE id_empresa = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


---------------- IM”VEL ---------------------


CREATE OR REPLACE FUNCTION fn_inserir_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, DECIMAL(10,2), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO imovel (id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_imovel_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem  
		FROM imovel WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_tipo(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem 
		FROM imovel WHERE tipo_imovel LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_situacao(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem 
		FROM imovel WHERE situacao_imovel LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_num_documento(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem 
		FROM imovel WHERE num_doc_propriedade LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_localidade(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem  
		FROM imovel WHERE localidade LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_endereco(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT i.id, i.id_nucleo, i.tipo_imovel, i.situacao_imovel, i.valor_aluguel, i.tipo_propriedade, i.doc_propriedade, i.num_doc_propriedade, i.construcao, i.localidade, i.paga_iptu, i.ic, i.selagem 
		FROM imovel AS i INNER JOIN endereco_imovel AS ei ON i.id = ei.id_imovel WHERE ei.logradouro LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_cep(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT i.id, i.id_nucleo, i.tipo_imovel, i.situacao_imovel, i.valor_aluguel, i.tipo_propriedade, i.doc_propriedade, i.num_doc_propriedade, i.construcao, i.localidade, i.paga_iptu, i.ic, i.selagem 
		FROM imovel AS i INNER JOIN endereco_imovel AS ei ON i.id = ei.id_imovel WHERE ei.cep LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_bairro(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT i.id, i.id_nucleo, i.tipo_imovel, i.situacao_imovel, i.valor_aluguel, i.tipo_propriedade, i.doc_propriedade, i.num_doc_propriedade, i.construcao, i.localidade, i.paga_iptu, i.ic, i.selagem 
		FROM imovel AS i INNER JOIN endereco_imovel AS ei ON i.id = ei.id_imovel WHERE ei.bairro LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_imoveis()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, tipo_imovel, situacao_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, construcao, localidade, paga_iptu, ic, selagem 
		FROM imovel;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, DECIMAL(10,2), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE imovel SET id_nucleo = $1, tipo_imovel = $2, situacao_imovel = $3, valor_aluguel = $4, tipo_propriedade = $5, doc_propriedade = $6, 
		num_doc_propriedade = $7, construcao = $8, localidade = $9, paga_iptu = $10, ic = $11, selagem = $12 WHERE id = $13;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM imovel WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- COMPOSI«√O IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_composicao_imovel
(BIGINT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT,
INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO composicao_imovel (id_imovel, material_parede, especifique_parede, material_piso, especifique_piso, material_cobertura, especifique_cobertura, 
		num_comodos, num_salas, num_cozinhas, num_quartos, num_banheiros, num_areas_servicos, num_anexos, num_outros_comodos, num_servem_dormitorio) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_composicao_imovel_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, material_parede, especifique_parede, material_piso, especifique_piso, material_cobertura, especifique_cobertura, num_comodos, 
		num_salas, num_cozinhas, num_quartos, num_banheiros, num_areas_servicos, num_anexos, num_outros_comodos, num_servem_dormitorio 
		FROM composicao_imovel WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_composicao_imovel_por_id_imovel(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, material_parede, especifique_parede, material_piso, especifique_piso, material_cobertura, especifique_cobertura, num_comodos, 
		num_salas, num_cozinhas, num_quartos, num_banheiros, num_areas_servicos, num_anexos, num_outros_comodos, num_servem_dormitorio 
		FROM composicao_imovel WHERE id_imovel = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_composicao_imovel
(BIGINT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT,
INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE composicao_imovel SET id_imovel = $1, material_parede = $2, especifique_parede = $3, material_piso = $4, especifique_piso = $5, material_cobertura = $6, 
		especifique_cobertura = $7, num_comodos = $8, num_salas = $9, num_cozinhas = $10, num_quartos = $11, num_banheiros = $12, num_areas_servicos = $13, num_anexos = $14, 
		num_outros_comodos = $15, num_servem_dormitorio = $16 WHERE id = $17;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_composicao_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM composicao_imovel WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ENDERE«O IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_endereco_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(10), 
CHARACTER VARYING, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, DOUBLE PRECISION, DOUBLE PRECISION)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO endereco_imovel (id_imovel, tipo_logradouro, logradouro, numero, complemento, cep, bairro, municipio, uf, tipo_area, latitude, longitude) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_endereco_imovel_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, tipo_logradouro, logradouro, numero, complemento, cep, bairro, municipio, uf, tipo_area, latitude, longitude  
		FROM endereco_imovel WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_endereco_imovel_por_id_imovel(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, tipo_logradouro, logradouro, numero, complemento, cep, bairro, municipio, uf, tipo_area, latitude, longitude  
		FROM endereco_imovel WHERE id_imovel = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_endereco_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(10), 
CHARACTER VARYING, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, DOUBLE PRECISION, DOUBLE PRECISION, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE endereco_imovel SET id_imovel = $1, tipo_logradouro = $2, logradouro = $3, numero = $4, complemento = $5, cep = $6, bairro = $7, municipio = $8, 
		uf = $9, tipo_area = $10, latitude = $11, longitude = $12 WHERE id = $13;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_endereco_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM endereco_imovel WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- SERVI«OS IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_servicos_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO servicos_imovel (id_imovel, existe_pavimentacao, iluminacao_utilizada, abastecimento_agua, tratamento_agua, 
		agua_encanada, existe_banheiro, escoamento_sanitario, tratamento_lixo, presenca_animais) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_servicos_imovel_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, existe_pavimentacao, iluminacao_utilizada, abastecimento_agua, tratamento_agua, 
		agua_encanada, existe_banheiro, escoamento_sanitario, tratamento_lixo, presenca_animais 
		FROM servicos_imovel WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_servicos_imovel_por_id_imovel(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, existe_pavimentacao, iluminacao_utilizada, abastecimento_agua, tratamento_agua, 
		agua_encanada, existe_banheiro, escoamento_sanitario, tratamento_lixo, presenca_animais 
		FROM servicos_imovel WHERE id_imovel = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_servicos_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE servicos_imovel SET id_imovel = $1, existe_pavimentacao = $2, iluminacao_utilizada = $3, abastecimento_agua = $4, tratamento_agua = $5, 
		agua_encanada = $6, existe_banheiro = $7, escoamento_sanitario = $8, tratamento_lixo = $9, presenca_animais = $10 WHERE id = $11;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_servicos_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM servicos_imovel WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ANEXO IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_anexo_imovel
(BIGINT, TEXT, CHAR(1))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO anexo_imovel (id_imovel, caminho, tipo) VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_anexo_imovel_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, caminho, tipo FROM anexo_imovel WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_imovel_por_id_imovel(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, caminho, tipo FROM anexo_imovel WHERE id_imovel = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_imovel_por_tipo(BIGINT, CHAR(1))
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, caminho, tipo FROM anexo_imovel WHERE id_imovel = $1 AND tipo = $2;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_anexo_imovel
(BIGINT, TEXT, CHAR(1), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE anexo_imovel SET id_imovel = $1, caminho = $2, tipo = $3 WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_imovel WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_imovel_por_id_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_imovel WHERE id_imovel = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- DEMOLI«√O IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_demolicao_imovel
(BIGINT, DATE, CHAR(5), CHARACTER VARYING, TEXT, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO demolicao_imovel (id_imovel, dt_demolicao, horario_demolicao, num_processo, motivo, executada_por) 
		VALUES ($1, $2, $3, $4, $5, $6);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_demolicao_imovel_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, dt_demolicao, horario_demolicao, num_processo, motivo, executada_por 
		FROM anexo_imovel WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_demolicao_imovel_por_id_imovel(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_imovel, dt_demolicao, horario_demolicao, num_processo, motivo, executada_por 
		FROM anexo_imovel WHERE id_imovel = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_demolicao_imovel
(BIGINT, DATE, CHAR(5), CHARACTER VARYING, TEXT, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE demolicao_imovel SET id_imovel = $1, dt_demolicao = $2, horario_demolicao = $3, num_processo = $4, motivo = $5, executada_por = $6 
		WHERE id = $7;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_demolicao_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM demolicao_imovel WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ANEXO DEMOLI«√O -----------------


CREATE OR REPLACE FUNCTION fn_inserir_anexo_demolicao
(BIGINT, TEXT, CHAR(1))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO anexo_demolicao (id_demolicao, caminho, tipo) VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_anexo_demolicao_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_demolicao, caminho, tipo FROM anexo_demolicao WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_demolicao_por_id_demolicao(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_demolicao, caminho, tipo FROM anexo_demolicao WHERE id_demolicao = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_demolicao_por_tipo(BIGINT, CHAR(1))
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_demolicao, caminho, tipo FROM anexo_demolicao WHERE id_demolicao = $1 AND tipo = $2;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_anexo_demolicao
(BIGINT, TEXT, CHAR(1), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE anexo_demolicao SET id_demolicao = $1, caminho = $2, tipo = $3 WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_demolicao(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_demolicao WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_demolicao_por_id_demolicao(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_demolicao WHERE id_demolicao = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- INDIVÕDUO IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_individuo_imovel
(BIGINT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO individuo_imovel (id_individuo, id_imovel) 
		VALUES ($1, $2);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_individuo_imovel
(BIGINT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM individuo_imovel WHERE id_individuo = $1 AND id_imovel = $2; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- EMPRESA IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_empresa_imovel
(BIGINT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO empresa_imovel (id_empresa, id_imovel) 
		VALUES ($1, $2);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_empresa_imovel
(BIGINT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM empresa_imovel WHERE id_empresa = $1 AND id_imovel = $2; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


------------------------ N⁄CLEO -------------------------


CREATE OR REPLACE FUNCTION fn_inserir_nucleo
(CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DOUBLE PRECISION, DOUBLE PRECISION, INTEGER, INTEGER, 
CHARACTER VARYING, CHARACTER VARYING, DOUBLE PRECISION, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHAR(3), TEXT, CHARACTER VARYING, CHAR(3), CHAR(3), CHARACTER VARYING, TEXT, CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO nucleo (nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
		renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
		adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17, $18, $19, $20, $21);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_nucleo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
		renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
		adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel 
		FROM nucleo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_nome(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
		renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
		adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel 
		FROM nucleo WHERE nome LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_setor(CHARACTER VARYING)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
		renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
		adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel 
		FROM nucleo WHERE setor_cadastral LIKE $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_nucleos()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
		renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
		adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel 
		FROM nucleo;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_nucleo
(CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DOUBLE PRECISION, DOUBLE PRECISION, INTEGER, INTEGER, 
CHARACTER VARYING, CHARACTER VARYING, DOUBLE PRECISION, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHAR(3), TEXT, CHARACTER VARYING, CHAR(3), CHAR(3), CHARACTER VARYING, TEXT, CHAR(3), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE nucleo SET nome = $1, origem = $2, ocupacao = $3, area_total = $4, area_ocupada = $5, num_domicilios = $6, populacao_estimada = $7, 
		pop_fonte_dados = $8, pop_outra_fonte_dados = $9, renda_populacao = $10, inicio_ocupacao = $11, setor_cadastral = $12, zona = $13, 
		controle_ocupacao = $14, obs_controle_ocupacao = $15, padrao_construtivo = $16, transporte_coletivo = $17, adensamento = $18, 
		adens_fonte_dados = $19, obs_adensamento = $20, uso_incompativel = $21 WHERE id = $22;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_nucleo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM nucleo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ANEXO TRANSPORTE -----------------


CREATE OR REPLACE FUNCTION fn_inserir_anexo_transporte
(BIGINT, TEXT, CHAR(1))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO anexo_transporte (id_nucleo, caminho, tipo) VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_anexo_transporte_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, caminho, tipo FROM anexo_transporte WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_transporte_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, caminho, tipo FROM anexo_transporte WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_transporte_por_tipo(BIGINT, CHAR(1))
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, caminho, tipo FROM anexo_transporte WHERE id_nucleo = $1 AND tipo = $2;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_anexo_transporte
(BIGINT, TEXT, CHAR(1), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE anexo_transporte SET id_nucleo = $1, caminho = $2, tipo = $3 WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_transporte(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_transporte WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_transporte_por_id_nucleo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_transporte WHERE id_nucleo = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- INFRAESTRUTURA URBANA -----------------


CREATE OR REPLACE FUNCTION fn_inserir_infraestrutura_urbana
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO infraestrutura_urbana (id_nucleo, abastecimento_agua, coleta_esgoto, servicos_limpeza, aguas_pluviais_superficial, aguas_pluviais_rede, energia_eletrica, iluminacao_publica) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_infraestrutura_urbana_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, abastecimento_agua, coleta_esgoto, servicos_limpeza, aguas_pluviais_superficial, aguas_pluviais_rede, energia_eletrica, iluminacao_publica 
		FROM infraestrutura_urbana WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_infraestrutura_urbana_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, abastecimento_agua, coleta_esgoto, servicos_limpeza, aguas_pluviais_superficial, aguas_pluviais_rede, energia_eletrica, iluminacao_publica 
		FROM infraestrutura_urbana WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_infraestrutura_urbana
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE infraestrutura_urbana SET id_nucleo = $1, abastecimento_agua = $2, coleta_esgoto = $3, servicos_limpeza = $4, aguas_pluviais_superficial = $5, 
		aguas_pluviais_rede = $6, energia_eletrica = $7, iluminacao_publica = $8 WHERE id = $9; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_infraestrutura_urbana(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM infraestrutura_urbana WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- SITUA«√O FUNDI¡RIA -----------------


CREATE OR REPLACE FUNCTION fn_inserir_situacao_fundiaria
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, DOUBLE PRECISION, 
TEXT, TEXT, TEXT, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), TEXT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO situacao_fundiaria (id_nucleo, propriedade, proprietario, obs_propriedade, decreto_aprovacao, registrado, num_matricula, destinacao_areas, 
		desc_destinacao_areas, desc_zonas_solo, desc_ecologico_economico, processos_judiciais, num_processo, num_ordem, vara, existencia_embargos, obs_judiciais) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_situacao_fundiaria_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, propriedade, proprietario, obs_propriedade, decreto_aprovacao, registrado, num_matricula, destinacao_areas, desc_destinacao_areas, 
		desc_zonas_solo, desc_ecologico_economico, processos_judiciais, num_processo, num_ordem, vara, existencia_embargos, obs_judiciais 
		FROM situacao_fundiaria WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_situacao_fundiaria_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, propriedade, proprietario, obs_propriedade, decreto_aprovacao, registrado, num_matricula, destinacao_areas, desc_destinacao_areas, 
		desc_zonas_solo, desc_ecologico_economico, processos_judiciais, num_processo, num_ordem, vara, existencia_embargos, obs_judiciais 
		FROM situacao_fundiaria WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_situacao_fundiaria
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, DOUBLE PRECISION, 
TEXT, TEXT, TEXT, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), TEXT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE situacao_fundiaria SET id_nucleo = $1, propriedade = $2, proprietario = $3, obs_propriedade = $4, decreto_aprovacao = $5, registrado = $6, num_matricula = $7, 
		destinacao_areas = $8, desc_destinacao_areas = $9, desc_zonas_solo = $10, desc_ecologico_economico = $11, processos_judiciais = $12, num_processo = $13, 
		num_ordem = $14, vara = $15, existencia_embargos = $16, obs_judiciais = $17 WHERE id = $18; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_situacao_fundiaria(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM situacao_fundiaria WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ANEXO ZONEAMENTO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_anexo_zoneamento
(BIGINT, TEXT, CHAR(1))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO anexo_zoneamento (id_fundiaria, caminho, tipo) VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_anexo_zoneamento_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_fundiaria, caminho, tipo FROM anexo_zoneamento WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_zoneamento_por_id_fundiaria(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_fundiaria, caminho, tipo FROM anexo_zoneamento WHERE id_fundiaria = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_zoneamento_por_tipo(BIGINT, CHAR(1))
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_fundiaria, caminho, tipo FROM anexo_zoneamento WHERE id_fundiaria = $1 AND tipo = $2;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_anexo_zoneamento
(BIGINT, TEXT, CHAR(1), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE anexo_zoneamento SET id_fundiaria = $1, caminho = $2, tipo = $3 WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_zoneamento(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_zoneamento WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_zoneamento_por_id_fundiaria(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_zoneamento WHERE id_fundiaria = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ANEXO JUDICIAL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_anexo_judicial
(BIGINT, TEXT, CHAR(1))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO anexo_judicial (id_fundiaria, caminho, tipo) VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_anexo_judicial_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_fundiaria, caminho, tipo FROM anexo_judicial WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_judicial_por_id_fundiaria(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_fundiaria, caminho, tipo FROM anexo_judicial WHERE id_fundiaria = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_judicial_por_tipo(BIGINT, CHAR(1))
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_fundiaria, caminho, tipo FROM anexo_judicial WHERE id_fundiaria = $1 AND tipo = $2;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_anexo_judicial
(BIGINT, TEXT, CHAR(1), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE anexo_judicial SET id_fundiaria = $1, caminho = $2, tipo = $3 WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_judicial(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_judicial WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_anexo_judicial_por_id_fundiaria(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM anexo_judicial WHERE id_fundiaria = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- A«’ES N⁄CLEO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_acoes_nucleo
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHAR(3), CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO acoes_nucleo (id_nucleo, remanejamento, reassentamento, desconstrucao, melhoria_habitacional, 
		fonte_melhoria, recuperacao_ambiental, prad, adequacao_infraestrutura, fonte_adequacao, outros, desc_outros) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_acoes_nucleo_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, remanejamento, reassentamento, desconstrucao, melhoria_habitacional, fonte_melhoria, 
		recuperacao_ambiental, prad, adequacao_infraestrutura, fonte_adequacao, outros, desc_outros FROM acoes_nucleo WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_acoes_nucleo_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, remanejamento, reassentamento, desconstrucao, melhoria_habitacional, fonte_melhoria, 
		recuperacao_ambiental, prad, adequacao_infraestrutura, fonte_adequacao, outros, desc_outros FROM acoes_nucleo WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_acoes_nucleo
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHAR(3), CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE acoes_nucleo SET id_nucleo = $1, remanejamento = $2, reassentamento = $3, desconstrucao = $4, melhoria_habitacional = $5, 
		fonte_melhoria = $6, recuperacao_ambiental = $7, prad = $8, adequacao_infraestrutura = $9, fonte_adequacao = $10, outros = $11, desc_outros = $12 
		WHERE id = $13;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_acoes_nucleo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM acoes_nucleo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- REMANEJAMENTOS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_remanejamento
(BIGINT, CHAR(3), INTEGER, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO remanejamentos (id_acao, estimativa_relocacao, num_remocao_definitiva, num_remocao_provisoria) 
		VALUES ($1, $2, $3, $4);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_remanejamento_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_acao, estimativa_relocacao, num_remocao_definitiva, num_remocao_provisoria FROM remanejamentos WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_remanejamento_por_id_acao(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_acao, estimativa_relocacao, num_remocao_definitiva, num_remocao_provisoria FROM remanejamentos WHERE id_acao = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_remanejamento
(BIGINT, CHAR(3), INTEGER, INTEGER, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE remanejamentos SET id_acao = $1, estimativa_relocacao = $2, num_remocao_definitiva = $3, num_remocao_provisoria = $4 
		WHERE id = $5;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_remanejamento(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM remanejamentos WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- REASSENTAMENTOS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_reassentamento
(BIGINT, CHAR(3), INTEGER, INTEGER, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO reassentamentos (id_acao, estimativa_remocao, num_a_construir, num_provisorias, local_definitivo) 
		VALUES ($1, $2, $3, $4, $5);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_reassentamento_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_acao, estimativa_remocao, num_a_construir, num_provisorias, local_definitivo FROM reassentamentos WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_reassentamento_por_id_acao(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_acao, estimativa_remocao, num_a_construir, num_provisorias, local_definitivo FROM reassentamentos WHERE id_acao = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_reassentamento
(BIGINT, CHAR(3), INTEGER, INTEGER, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE reassentamentos SET id_acao = $1, estimativa_remocao = $2, num_a_construir = $3, num_provisorias = $4, local_definitivo = $5 
		WHERE id = $6;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_reassentamento(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM reassentamentos WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- DESCONSTRU«’ES -----------------


CREATE OR REPLACE FUNCTION fn_inserir_desconstrucao
(BIGINT, INTEGER, TEXT, TEXT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO desconstrucoes (id_acao, num_a_demolir, motivo, processos) 
		VALUES ($1, $2, $3, $4);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_desconstrucao_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_acao, num_a_demolir, motivo, processos FROM desconstrucoes WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_desconstrucao_por_id_acao(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_acao, num_a_demolir, motivo, processos FROM desconstrucoes WHERE id_acao = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_desconstrucao
(BIGINT, INTEGER, TEXT, TEXT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE desconstrucoes SET id_acao = $1, num_a_demolir = $2, motivo = $3, processos = $4 WHERE id = $5; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_desconstrucao(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM desconstrucoes WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ASPECTOS AMBIENTAIS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_aspecto_ambiental
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), DOUBLE PRECISION, DOUBLE PRECISION)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO aspectos_ambientais (id_nucleo, area_risco, app, area_verde, area_agricola, outros, latitude, longitude) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_aspecto_ambiental_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, area_risco, app, area_verde, area_agricola, outros, latitude, longitude 
		FROM aspectos_ambientais WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_aspecto_ambiental_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, area_risco, app, area_verde, area_agricola, outros, latitude, longitude 
		FROM aspectos_ambientais WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_aspecto_ambiental
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), DOUBLE PRECISION, DOUBLE PRECISION, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE aspectos_ambientais SET id_nucleo = $1, area_risco = $2, app = $3, area_verde = $4, area_agricola = $5, 
		outros = $6, latitude = $7, longitude = $8 WHERE id = $9; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_aspecto_ambiental(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM aspectos_ambientais WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


------------------------------ APPS -----------------------------


CREATE OR REPLACE FUNCTION fn_inserir_app
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), TEXT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO apps (id_aspecto_ambiental, corpo_dagua, brejo_charco, topo_morro, enconsta, restinga, outros, especifique_outros) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_app_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_aspecto_ambiental, corpo_dagua, brejo_charco, topo_morro, enconsta, restinga, outros, especifique_outros 
		FROM apps WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_app_por_id_aspecto_ambiental(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_aspecto_ambiental, corpo_dagua, brejo_charco, topo_morro, enconsta, restinga, outros, especifique_outros 
		FROM apps WHERE id_aspecto_ambiental = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_app
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), TEXT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE apps SET id_aspecto_ambiental = $1, corpo_dagua = $2, brejo_charco = $3, topo_morro = $4, enconsta = $5, restinga = $6, 
		outros = $7, especifique_outros = $8 WHERE id = $9;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_app(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM apps WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- ¡REA RISCO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_area_risco
(CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, DOUBLE PRECISION, DOUBLE PRECISION)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO area_risco (cd_setor, grau_risco, vegetacao, processo_instabilizacao, 
		condicoes_solo, existe_pavimentacao, obs_pavimentacao, latitude, longitude) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_area_risco_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, cd_setor, grau_risco, vegetacao, processo_instabilizacao, condicoes_solo, existe_pavimentacao, obs_pavimentacao, latitude, longitude 
		FROM area_risco WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_area_risco
(CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, DOUBLE PRECISION, DOUBLE PRECISION, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE area_risco SET cd_setor = $1, grau_risco = $2, vegetacao = $3, processo_instabilizacao = $4, 
		condicoes_solo = $5, existe_pavimentacao = $6, obs_pavimentacao = $7, latitude = $8, longitude = $9 
		WHERE id = $10;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_area_risco(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM area_risco WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- AMBIENTAL ¡REA RISCO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_ambiental_area_risco
(BIGINT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO ambiental_area_risco (id_aspecto_ambiental, id_area_risco) 
		VALUES ($1, $2);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_ambiental_area_risco
(BIGINT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM ambiental_area_risco WHERE id_aspecto_ambiental = $1 AND id_area_risco = $2;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- PROGRAMAS HABITACIONAIS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_programa_habitacional
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO programas_habitacionais (id_nucleo, material_construcao, producao_moradias, assistencia_tecnica, 
		urb_assentamentos_precarios, complementacao_infraestrutura, regularizacao_fundiaria, cdhu, pmcmv) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_programa_habitacional_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, material_construcao, producao_moradias, assistencia_tecnica, 
		urb_assentamentos_precarios, complementacao_infraestrutura, regularizacao_fundiaria, cdhu, pmcmv  
		FROM programas_habitacionais WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_selecionar_programa_habitacional_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_nucleo, material_construcao, producao_moradias, assistencia_tecnica, 
		urb_assentamentos_precarios, complementacao_infraestrutura, regularizacao_fundiaria, cdhu, pmcmv  
		FROM programas_habitacionais WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_programa_habitacional
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE programas_habitacionais SET id_nucleo = $1, material_construcao = $2, producao_moradias = $3, assistencia_tecnica = $4, 
		urb_assentamentos_precarios = $5, complementacao_infraestrutura = $6, regularizacao_fundiaria = $7, cdhu = $8, pmcmv = $9 
		WHERE id = $10;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_programa_habitacional(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM programas_habitacionais WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- VIAS P⁄BLICAS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_via_publica
(INTEGER, BIGINT, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO vias_publicas (id_recurso, id_nucleo, descricao) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_via_publica_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_recurso, id_nucleo, descricao   
		FROM vias_publicas WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_via_publica_por_id_recurso(INTEGER)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_recurso, id_nucleo, descricao   
		FROM vias_publicas WHERE id_recurso = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_via_publica_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_recurso, id_nucleo, descricao   
		FROM vias_publicas WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_via_publica
(INTEGER, BIGINT, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE vias_publicas SET id_recurso = $1, id_nucleo = $2, descricao = $3 WHERE id = $4; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_via_publica(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM vias_publicas WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- RECURSO MOBILIDADE -----------------


CREATE OR REPLACE FUNCTION fn_inserir_recurso_mobilidade
(CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO recurso_mobilidade (nome) 
		VALUES ($1);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_recurso_mobilidade_por_id(INTEGER)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome 
		FROM recurso_mobilidade WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_recurso_mobilidades()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome 
		FROM recurso_mobilidade;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_recurso_mobilidade
(CHARACTER VARYING, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE recurso_mobilidade SET nome = $1 WHERE id = $2;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_recurso_mobilidade(INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM recurso_mobilidade WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- INSTITUCIONAL SOCIAL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_institucional_social
(INTEGER, BIGINT, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO institucional_social (id_recurso, id_nucleo, descricao) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_institucional_social_por_id(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_recurso, id_nucleo, descricao 
		FROM institucional_social WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_institucional_social_por_id_recurso(INTEGER)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_recurso, id_nucleo, descricao 
		FROM institucional_social WHERE id_recurso = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_procurar_institucional_social_por_id_nucleo(BIGINT)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, id_recurso, id_nucleo, descricao 
		FROM institucional_social WHERE id_nucleo = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_institucional_social
(INTEGER, BIGINT, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE institucional_social SET id_recurso = $1, id_nucleo = $2, descricao = $3 WHERE id = $4; 
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_institucional_social(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM institucional_social WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- RECURSO SOCIAL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_recurso_social
(CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO recurso_social (nome) 
		VALUES ($1);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_recurso_social_por_id(INTEGER)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome 
		FROM recurso_social WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_recurso_sociais()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome 
		FROM recurso_social;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_recurso_social
(CHARACTER VARYING, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE recurso_social SET nome = $1 WHERE id = $2;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_recurso_social(INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM recurso_social WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- SECRETARIAS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_secretaria
(CHARACTER VARYING, TEXT, CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO secretarias (nome, descricao, ativo) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_secretaria_por_id(INTEGER)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, descricao, ativo 
		FROM secretarias WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_secretarias()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, descricao, ativo 
		FROM secretarias;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_secretaria
(CHARACTER VARYING, TEXT, CHAR(3), INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE secretarias SET nome = $1, descricao = $2, ativo = $3 
		WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_secretaria(INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM secretarias WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- GRUPOS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_grupo
(CHARACTER VARYING, TEXT, CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO grupos (nome, descricao, ativo) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_grupo_por_id(INTEGER)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, descricao, ativo 
		FROM grupos WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_grupos()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, descricao, ativo 
		FROM grupos;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_grupo
(CHARACTER VARYING, TEXT, CHAR(3), INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE grupos SET nome = $1, descricao = $2, ativo = $3 
		WHERE id = $4;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_grupo(INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM grupos WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- PERMISS’ES -----------------


CREATE OR REPLACE FUNCTION fn_inserir_permissao
(CHARACTER VARYING, TEXT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO permissoes (nome, descricao) 
		VALUES ($1, $2);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_permissao_por_id(INTEGER)
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, descricao 
		FROM permissoes WHERE id = $1;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_permissoes()
RETURNS refcursor AS $$
DECLARE 
	REF refcursor;
BEGIN
	OPEN REF FOR
		SELECT id, nome, descricao 
		FROM permissoes;
	RETURN REF;
END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_alterar_permissao
(CHARACTER VARYING, TEXT, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE permissoes SET nome = $1, descricao = $2 
		WHERE id = $3;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_permissao(INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM permissoes WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- GRUPOS PERMISS’ES -----------------


CREATE OR REPLACE FUNCTION fn_inserir_grupo_permissao
(INTEGER, INTEGER, CHAR(1))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO grupos_permissoes (id_grupo, id_permissao, permitido) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_grupo_permissao
(CHAR(1), INTEGER, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE grupos_permissoes SET permitido = $1 WHERE id_grupo = $2 AND id_permissao = $3;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_grupo_permissao(INTEGER, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM grupos_permissoes WHERE id_grupo = $1 AND id_permissao = $2;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- USU¡RIOS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_usuario
(INTEGER, INTEGER, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHARACTER VARYING, CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO usuarios (id_grupo, id_secretaria, matricula, senha, foto, nome, email, ativo) 
		VALUES ($1, $2, $3, MD5($4), $5, $6, $7, $8);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_usuario_por_id(INTEGER)
RETURNS refcursor AS $$
	DECLARE 
		REF refcursor;
	BEGIN
		OPEN REF FOR
			SELECT id, id_grupo, id_secretaria, matricula, senha, foto, nome, email, ativo 
			FROM usuarios WHERE id = $1;
		RETURN REF;
	END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_listar_usuarios()
RETURNS refcursor AS $$
	DECLARE 
		REF refcursor;
	BEGIN
		OPEN REF FOR
			SELECT id, id_grupo, id_secretaria, matricula, senha, foto, nome, email, ativo 
			FROM usuarios;
		RETURN REF;
	END;
$$ LANGUAGE PLPGSQL VOLATILE;


CREATE OR REPLACE FUNCTION fn_logon_usuario
(CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	BEGIN
		SELECT id FROM usuarios WHERE matricula = $1 AND senha = MD5($2) AND ativo = 'SIM';
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_usuario
(INTEGER, INTEGER, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE usuarios SET id_grupo = $1, id_secretaria = $2, matricula = $3, senha = MD5($4), foto = $5, nome = $6, email = $7, ativo = $8 
		WHERE id = $9;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_usuario(INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM usuarios WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;

