----------------------------------------------------------------------- FUN«’ES B¡SICAS ----------------------------------------------------------------------


CREATE OR REPLACE FUNCTION remove_acentos(CHARACTER VARYING)
RETURNS CHARACTER VARYING AS $$
	SELECT translate($1, '·ÈÌÛ˙‡ËÏÚ˘„ı‚ÍÓÙÙ‰ÎÔˆ¸Á¡…Õ”⁄¿»Ã“Ÿ√’¬ Œ‘€ƒÀœ÷‹«', 'aeiouaeiouaoaeiooaeioucAEIOUAEIOUAOAEIOOAEIOUC')
$$ LANGUAGE SQL VOLATILE;


CREATE OR REPLACE FUNCTION checa_data(CHARACTER VARYING)
RETURNS CHARACTER VARYING AS $$
	BEGIN
		IF $1 = '__/__/____' OR $1 = '____-__-__' THEN 
			RETURN '0001-01-01';
		ELSE
			RETURN $1;
		END IF;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION checa_hora(CHARACTER VARYING)
RETURNS CHARACTER VARYING AS $$
	BEGIN
		IF $1 = '__:__:__' THEN 
			RETURN '00:00:00';
		ELSE
			RETURN $1;
		END IF;
	END;
$$ LANGUAGE PLPGSQL;


----------------------------------------------------------------------- FUN«’ES DO SISTEMA -------------------------------------------------------------------


-------------------- FAMÕLIAS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_familia
(CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHARACTER VARYING, DATE)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO familias (remocao_familia, situacao_remocao, especifique_remocao, atendente, dt_atendimento, atendente_atualizacao, dt_atualizacao) 
		VALUES ($1, $2, $3, $4, $5, $6, $7);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_familia_por_id(BIGINT)
RETURNS SETOF tp_familia AS $$
DECLARE
    linha tp_familia;
BEGIN
    FOR linha IN SELECT id, remocao_familia, situacao_remocao, especifique_remocao, atendente, dt_atendimento, atendente_atualizacao, dt_atualizacao 
	FROM familias WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_familia_por_remocao_familia(CHAR(3))
RETURNS SETOF tp_familia AS $$
DECLARE
    linha tp_familia;
BEGIN
    FOR linha IN SELECT id, remocao_familia, situacao_remocao, especifique_remocao, atendente, dt_atendimento, atendente_atualizacao, dt_atualizacao 
	FROM familias WHERE remocao_familia = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_familia_por_situacao_remocao(CHARACTER VARYING)
RETURNS SETOF tp_familia AS $$
DECLARE
    linha tp_familia;
BEGIN
    FOR linha IN SELECT id, remocao_familia, situacao_remocao, especifique_remocao, atendente, dt_atendimento, atendente_atualizacao, dt_atualizacao 
	FROM familias WHERE situacao_remocao LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_familia
(CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHARACTER VARYING, DATE, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE familias SET remocao_familia = $1, situacao_remocao = $2, especifique_remocao = $3, atendente = $4, 
		dt_atendimento = $5, atendente_atualizacao = $6, dt_atualizacao = $7 WHERE id = $8;
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
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHAR(15))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO individuo (id_familia, responsavel_familia, nome, apelido, idade, sexo, etnia, estado_civil, 
		nome_mae, nome_pai, responsavel, grau_parentesco, observacoes, prestou_informacao, cpf_informante) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_individuo_por_id(BIGINT)
RETURNS SETOF tp_individuo AS $$
DECLARE
    linha tp_individuo;
BEGIN
    FOR linha IN SELECT id, id_familia, responsavel_familia, nome, apelido, idade, sexo, etnia, estado_civil, 
	nome_mae, nome_pai, responsavel, grau_parentesco, observacoes, prestou_informacao, cpf_informante 
	FROM individuo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_individuo
(BIGINT, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHAR(15), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE individuo SET id_familia = $1, responsavel_familia = $2, nome = $3, apelido = $4, idade = $5, sexo = $6, etnia = $7, estado_civil = $8, nome_mae = $9, nome_pai = $10, 
		responsavel = $11, grau_parentesco = $12, observacoes = $13, prestou_informacao = $14, cpf_informante = $15 WHERE id = $16;
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


-------------------- CERTID√O INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_certidao_individuo
(BIGINT, DATE, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, DATE, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO certidao_individuo (id_individuo, dt_nascimento, onde_nasceu, naturalidade, nasc_registrado, cd_cartorio, nm_cartorio, tipo_certidao, 
		dt_reg_certidao, municipio_certidao, uf_certidao, num_termo, num_livro, num_folha) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_certidao_individuo_por_id(BIGINT) 
RETURNS SETOF tp_certidao_individuo AS $$
DECLARE
    linha tp_certidao_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, dt_nascimento, onde_nasceu, naturalidade, nasc_registrado, cd_cartorio, nm_cartorio, tipo_certidao, dt_reg_certidao, 
	municipio_certidao, uf_certidao, num_termo, num_livro, num_folha 
	FROM certidao_individuo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_certidao_individuo_por_id_individuo(BIGINT) 
RETURNS SETOF tp_certidao_individuo AS $$
DECLARE
    linha tp_certidao_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, dt_nascimento, onde_nasceu, naturalidade, nasc_registrado, cd_cartorio, nm_cartorio, tipo_certidao, dt_reg_certidao, 
	municipio_certidao, uf_certidao, num_termo, num_livro, num_folha 
	FROM certidao_individuo WHERE id_individuo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_certidao_individuo
(BIGINT, DATE, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, DATE, CHARACTER VARYING, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE certidao_individuo SET id_individuo = $1, dt_nascimento = $2, onde_nasceu = $3, naturalidade = $4, nasc_registrado = $5, cd_cartorio = $6, 
		nm_cartorio = $7, tipo_certidao = $8, dt_reg_certidao = $9, municipio_certidao = $10, uf_certidao = $11, num_termo = $12, num_livro = $13, 
		num_folha = $14 WHERE id = $15;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_certidao_individuo(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM certidao_individuo WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- DOCUMENTOS INDIVÕDUO -----------------


CREATE OR REPLACE FUNCTION fn_inserir_documentos_individuo
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHAR(2), CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO documentos_individuo (id_individuo, tipo, numero, serie, data_emissao, uf_emissao, cidade, 
		orgao_emissor, zona, secao, categoria, validade, sts_documento) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_individuo_por_id(BIGINT)
RETURNS SETOF tp_documento_individuo AS $$
DECLARE
    linha tp_documento_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, tipo, numero, serie, data_emissao, uf_emissao, cidade, 
		orgao_emissor, zona, secao, categoria, validade, sts_documento 
	FROM documentos_individuo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_individuo_por_id_individuo(BIGINT)
RETURNS SETOF tp_documento_individuo AS $$
DECLARE
    linha tp_documento_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, tipo, numero, serie, data_emissao, uf_emissao, cidade, 
		orgao_emissor, zona, secao, categoria, validade, sts_documento 
	FROM documentos_individuo WHERE id_individuo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_documentos_individuo
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE documentos_individuo SET id_individuo = $1, tipo = $2, numero = $3, serie = $4, data_emissao = $5, uf_emissao = $6, 
		cidade = $7, orgao_emissor = $8, zona = $9, secao = $10, categoria = $11, validade = $12, sts_documento = $13 
		WHERE id = $14; 
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
(BIGINT, CHAR(3), CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO escolaridade_individuo (id_individuo, le_escreve, grau_escolaridade, unidade_educacional) 
		VALUES ($1, $2, $3, $4);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_escolaridade_individuo_por_id(BIGINT)
RETURNS SETOF tp_escolaridade_individuo AS $$
DECLARE
    linha tp_escolaridade_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, le_escreve, grau_escolaridade, unidade_educacional FROM escolaridade_individuo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_escolaridade_individuo_por_id_individuo(BIGINT)
RETURNS SETOF tp_escolaridade_individuo AS $$
DECLARE
    linha tp_escolaridade_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, le_escreve, grau_escolaridade, unidade_educacional FROM escolaridade_individuo WHERE id_individuo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_escolaridade_individuo
(BIGINT, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE escolaridade_individuo SET id_individuo = $1, le_escreve = $2, grau_escolaridade = $3, unidade_educacional = $4  
		WHERE id = $5;
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
RETURNS SETOF tp_profissional_individuo AS $$
DECLARE
    linha tp_profissional_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, situacao_trabalhista, obs_situacao_trabalhista, tipo_trabalho, obs_tipo_trabalho, nm_trabalho, possui_renda, 
	renda, outras_rendas, tipo_beneficio, doacao_regular, aposentadoria_pensao, seg_desemprego, pensao_alimentar, outros_beneficios, num_bpcloas
	FROM profissional_individuo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_profissional_individuo_por_id_individuo(BIGINT)
RETURNS SETOF tp_profissional_individuo AS $$
DECLARE
    linha tp_profissional_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, situacao_trabalhista, obs_situacao_trabalhista, tipo_trabalho, obs_tipo_trabalho, nm_trabalho, possui_renda, 
	renda, outras_rendas, tipo_beneficio, doacao_regular, aposentadoria_pensao, seg_desemprego, pensao_alimentar, outros_beneficios, num_bpcloas
	FROM profissional_individuo WHERE id_individuo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), TEXT, 
CHARACTER VARYING, TEXT, CHARACTER VARYING, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO deficiente_individuo (id_individuo, deficiente, deficiencia_fisica, deficiencia_mental, transtorno_mental, sindrome_down, 
		cegueira, baixa_visao, surdez_severa, surdez_moderada, obs_tipo_deficiencia, causa_deficiencia, obs_causa_deficiencia, quando_adquiriu, 
		cuidados_familia, cuidados_especializado, cuidados_vizinho, cuidados_instituicao, cuidados_outros, cadastro_sepedi) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17, $18, $19, $20);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_deficiente_individuo_por_id(BIGINT)
RETURNS SETOF tp_deficiente_individuo AS $$
DECLARE
    linha tp_deficiente_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, deficiente, deficiencia_fisica, deficiencia_mental, transtorno_mental, sindrome_down, 
	cegueira, baixa_visao, surdez_severa, surdez_moderada, obs_tipo_deficiencia, causa_deficiencia, obs_causa_deficiencia, quando_adquiriu, 
	cuidados_familia, cuidados_especializado, cuidados_vizinho, cuidados_instituicao, cuidados_outros, cadastro_sepedi 
	FROM deficiente_individuo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_deficiente_individuo_por_id_individuo(BIGINT)
RETURNS SETOF tp_deficiente_individuo AS $$
DECLARE
    linha tp_deficiente_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, deficiente, deficiencia_fisica, deficiencia_mental, transtorno_mental, sindrome_down, 
	cegueira, baixa_visao, surdez_severa, surdez_moderada, obs_tipo_deficiencia, causa_deficiencia, obs_causa_deficiencia, quando_adquiriu, 
	cuidados_familia, cuidados_especializado, cuidados_vizinho, cuidados_instituicao, cuidados_outros, cadastro_sepedi 
	FROM deficiente_individuo WHERE id_individuo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_deficiente_individuo
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), TEXT, 
CHARACTER VARYING, TEXT, CHARACTER VARYING, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE deficiente_individuo SET id_individuo = $1, deficiente = $2, deficiencia_fisica = $3, deficiencia_mental = $4, transtorno_mental = $5, 
		sindrome_down = $6, cegueira = $7, baixa_visao = $8, surdez_severa = $9, surdez_moderada = $10, obs_tipo_deficiencia = $11, causa_deficiencia = $12, 
		obs_causa_deficiencia = $13, quando_adquiriu = $14, cuidados_familia = $15, cuidados_especializado = $16, cuidados_vizinho = $17, 
		cuidados_instituicao = $18, cuidados_outros = $19, cadastro_sepedi = $20 WHERE id = $21;
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
RETURNS SETOF tp_anexo_individuo AS $$
DECLARE
    linha tp_anexo_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, caminho, tipo FROM anexo_individuo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_individuo_por_id_individuo(BIGINT)
RETURNS SETOF tp_anexo_individuo AS $$
DECLARE
    linha tp_anexo_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, caminho, tipo FROM anexo_individuo WHERE id_individuo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_individuo_por_tipo(BIGINT, CHAR(1))
RETURNS SETOF tp_anexo_individuo AS $$
DECLARE
    linha tp_anexo_individuo;
BEGIN
    FOR linha IN SELECT id, id_individuo, caminho, tipo FROM anexo_individuo WHERE id_individuo = $1 AND tipo = $2 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_empresa AS $$
DECLARE
    linha tp_empresa;
BEGIN
    FOR linha IN SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem FROM empresa WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_empresa_por_razao_social(CHARACTER VARYING)
RETURNS SETOF tp_empresa AS $$
DECLARE
    linha tp_empresa;
BEGIN
    FOR linha IN SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem FROM empresa WHERE razao_social LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_empresa_por_fantasia(CHARACTER VARYING)
RETURNS SETOF tp_empresa AS $$
DECLARE
    linha tp_empresa;
BEGIN
    FOR linha IN SELECT id, razao_social, nm_fantasia, fundador, dt_fundacao, local_origem FROM empresa WHERE nm_fantasia LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHAR(2), CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO documentos_empresa (id_empresa, tipo, numero, serie, data_emissao, uf_emissao, cidade, 
		orgao_emissor, zona, secao, categoria, validade, sts_documento) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_empresa_por_id(BIGINT)
RETURNS SETOF tp_documento_empresa AS $$
DECLARE
    linha tp_documento_empresa;
BEGIN
    FOR linha IN SELECT id, id_empresa, tipo, numero, serie, data_emissao, uf_emissao, cidade, 
	orgao_emissor, zona, secao, categoria, validade, sts_documento FROM documentos_empresa WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_documentos_empresa_por_id_empresa(BIGINT)
RETURNS SETOF tp_documento_empresa AS $$
DECLARE
    linha tp_documento_empresa;
BEGIN
    FOR linha IN SELECT id, id_empresa, tipo, numero, serie, data_emissao, uf_emissao, cidade, 
	orgao_emissor, zona, secao, categoria, validade, sts_documento FROM documentos_empresa WHERE id_empresa = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_documentos_empresa
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DATE, CHAR(2), CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE documentos_empresa SET id_empresa = $1, tipo = $2, numero = $3, serie = $4, data_emissao = $5, uf_emissao = $6, 
		cidade = $7, orgao_emissor = $8, zona = $9, secao = $10, categoria = $11, validade = $12, sts_documento = $13 WHERE id = $14;
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


CREATE OR REPLACE FUNCTION fn_selecionar_telefone_individuo_por_id(BIGINT)
RETURNS SETOF tp_telefone AS $$
DECLARE
    linha tp_telefone;
BEGIN
    FOR linha IN SELECT id, id_individuo, tipo_telefone, num_telefone FROM telefones WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_telefone_por_id_individuo(BIGINT)
RETURNS SETOF tp_telefone AS $$
DECLARE
    linha tp_telefone;
BEGIN
    FOR linha IN SELECT id, id_individuo, id_empresa, tipo_telefone, num_telefone FROM telefones WHERE id_individuo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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


CREATE OR REPLACE FUNCTION fn_selecionar_telefone_empresa_por_id(BIGINT)
RETURNS SETOF tp_telefone AS $$
DECLARE
    linha tp_telefone;
BEGIN
    FOR linha IN SELECT id, id_empresa, tipo_telefone, num_telefone FROM telefones WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_telefone_por_id_empresa(BIGINT)
RETURNS SETOF tp_telefone AS $$
DECLARE
    linha tp_telefone;
BEGIN
    FOR linha IN SELECT id, id_individuo, id_empresa, tipo_telefone, num_telefone FROM telefones WHERE id_empresa = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
(BIGINT, CHARACTER VARYING, DOUBLE PRECISION, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING,  
CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS BIGINT AS $$
	DECLARE 
		last_id BIGINT DEFAULT 0;
	BEGIN
		INSERT INTO imovel (id_nucleo, tipo_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, 
		num_doc_propriedade, localidade, paga_iptu, ic, selagem, atendente, atendente_atualizacao, dt_atualizacao) 
		VALUES ($1, $2, CAST($3 AS DECIMAL(10,2)), $4, $5, $6, $7, $8, $9, $10, $11, $12, CAST($13 AS DATE));
		SELECT CURRVAL(pg_get_serial_sequence('imovel', 'id')) INTO last_id;
		RETURN last_id;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_imovel_por_id(BIGINT)
RETURNS SETOF tp_imovel AS $$
DECLARE
    linha tp_imovel;
BEGIN
    FOR linha IN SELECT id, id_nucleo, tipo_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade,  
	localidade, paga_iptu, ic, selagem, atendente, atendente_atualizacao, dt_atualizacao FROM imovel WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_tipo(CHARACTER VARYING)
RETURNS SETOF tp_imovel AS $$
DECLARE
    linha tp_imovel;
BEGIN
    FOR linha IN SELECT id, id_nucleo, tipo_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade,  
	localidade, paga_iptu, ic, selagem, atendente, atendente_atualizacao, dt_atualizacao FROM imovel WHERE tipo_imovel LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_num_documento(CHARACTER VARYING)
RETURNS SETOF tp_imovel AS $$
DECLARE
    linha tp_imovel;
BEGIN
    FOR linha IN SELECT id, id_nucleo, tipo_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, localidade, 
	paga_iptu, ic, selagem, atendente, atendente_atualizacao, dt_atualizacao FROM imovel WHERE num_doc_propriedade LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_localidade(CHARACTER VARYING)
RETURNS SETOF tp_imovel AS $$
DECLARE
    linha tp_imovel;
BEGIN
    FOR linha IN SELECT id, id_nucleo, tipo_imovel, valor_aluguel, tipo_propriedade, doc_propriedade, num_doc_propriedade, 
	localidade, paga_iptu, ic, selagem, atendente, atendente_atualizacao, dt_atualizacao FROM imovel WHERE localidade LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_logradouro(CHARACTER VARYING)
RETURNS SETOF tp_imovel AS $$
DECLARE
    linha tp_imovel;
BEGIN
    FOR linha IN SELECT i.id, i.id_nucleo, i.tipo_imovel, i.valor_aluguel, i.tipo_propriedade, i.doc_propriedade, i.num_doc_propriedade, 
	i.localidade, i.paga_iptu, i.ic, i.selagem, i.atendente, i.atendente_atualizacao, i.dt_atualizacao FROM imovel AS i 
	INNER JOIN endereco_imovel AS ei ON i.id = ei.id_imovel 
	WHERE ei.logradouro LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_cep(CHARACTER VARYING)
RETURNS SETOF tp_imovel AS $$
DECLARE
    linha tp_imovel;
BEGIN
    FOR linha IN SELECT i.id, i.id_nucleo, i.tipo_imovel, i.valor_aluguel, i.tipo_propriedade, i.doc_propriedade, i.num_doc_propriedade, 
	i.localidade, i.paga_iptu, i.ic, i.selagem, i.atendente, i.atendente_atualizacao, i.dt_atualizacao FROM imovel AS i 
	INNER JOIN endereco_imovel AS ei ON i.id = ei.id_imovel 
	WHERE ei.cep LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_imovel_por_bairro(CHARACTER VARYING)
RETURNS SETOF tp_imovel AS $$
DECLARE
    linha tp_imovel;
BEGIN
    FOR linha IN SELECT i.id, i.id_nucleo, i.tipo_imovel, i.valor_aluguel, i.tipo_propriedade, i.doc_propriedade, i.num_doc_propriedade, 
	i.localidade, i.paga_iptu, i.ic, i.selagem, i.atendente, i.atendente_atualizacao, i.dt_atualizacao FROM imovel AS i 
	INNER JOIN endereco_imovel AS ei ON i.id = ei.id_imovel 
	WHERE ei.bairro LIKE $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_imovel
(BIGINT, CHARACTER VARYING, DECIMAL(10,2), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE imovel SET id_nucleo = $1, tipo_imovel = $2, valor_aluguel = $3, tipo_propriedade = $4, 
		doc_propriedade = $5, num_doc_propriedade = $6, localidade = $7, paga_iptu = $8, ic = $9, selagem = $10, 
		atendente = $11, atendente_atualizacao = $12, dt_atualizacao = CAST($13 AS DATE) WHERE id = $14;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_imovel(BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE imovel SET ativo = 'N' WHERE id = $1;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- COMPOSI«√O IM”VEL -----------------


CREATE OR REPLACE FUNCTION fn_inserir_composicao_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT,
INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO composicao_imovel (id_imovel, construcao, material_parede, especifique_parede, material_piso, especifique_piso, material_cobertura, especifique_cobertura, 
		num_comodos, num_salas, num_cozinhas, num_quartos, num_banheiros, num_areas_servicos, num_anexos, num_outros_comodos, num_servem_dormitorio) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_composicao_imovel_por_id(BIGINT)
RETURNS SETOF tp_composicao_imovel AS $$
DECLARE
    linha tp_composicao_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, construcao, material_parede, especifique_parede, material_piso, especifique_piso, material_cobertura, especifique_cobertura, 
	num_comodos, num_salas, num_cozinhas, num_quartos, num_banheiros, num_areas_servicos, num_anexos, num_outros_comodos, num_servem_dormitorio 
	FROM composicao_imovel WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_composicao_imovel_por_id_imovel(BIGINT)
RETURNS SETOF tp_composicao_imovel AS $$
DECLARE
    linha tp_composicao_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, construcao,  material_parede, especifique_parede, material_piso, especifique_piso, material_cobertura, especifique_cobertura, 
	num_comodos, num_salas, num_cozinhas, num_quartos, num_banheiros, num_areas_servicos, num_anexos, num_outros_comodos, num_servem_dormitorio 
	FROM composicao_imovel WHERE id_imovel = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_composicao_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT, CHARACTER VARYING, TEXT,
INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, INTEGER, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE composicao_imovel SET id_imovel = $1, construcao = $2, material_parede = $3, especifique_parede = $4, material_piso = $5, especifique_piso = $6, 
		material_cobertura = $7, especifique_cobertura = $8, num_comodos = $9, num_salas = $10, num_cozinhas = $11, num_quartos = $12, num_banheiros = $13, 
		num_areas_servicos = $14, num_anexos = $15, num_outros_comodos = $16, num_servem_dormitorio = $17 WHERE id = $18;
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
(BIGINT, BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHAR(10), CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO endereco_imovel (id_imovel, id_municipio, tipo_logradouro, logradouro, numero, complemento, cep, bairro, tipo_area, latitude, longitude) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_endereco_imovel_por_id(BIGINT)
RETURNS SETOF tp_endereco_imovel AS $$
DECLARE
    linha tp_endereco_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, id_municipio, tipo_logradouro, logradouro, numero, complemento, cep, bairro, tipo_area, latitude, longitude   
	FROM endereco_imovel WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_endereco_imovel_por_id_imovel(BIGINT)
RETURNS SETOF tp_endereco_imovel AS $$
DECLARE
    linha tp_endereco_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, id_municipio, tipo_logradouro, logradouro, numero, complemento, cep, bairro, tipo_area, latitude, longitude  
	FROM endereco_imovel WHERE id_imovel = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_endereco_imovel
(BIGINT, BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHAR(10), 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE endereco_imovel SET id_imovel = $1, id_municipio = $2, tipo_logradouro = $3, logradouro = $4, numero = $5, complemento = $6, cep = $7, bairro = $8, 
		tipo_area = $9, latitude = $10, longitude = $11 WHERE id = $12;
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
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO servicos_imovel (id_imovel, existe_pavimentacao, qual_pavimentacao, iluminacao_utilizada, especifique_iluminacao, abastecimento_agua, 
		tratamento_agua, agua_encanada, existe_banheiro, escoamento_sanitario, tratamento_lixo, caes, gatos, aves, suinos, insetos, ratos, cobras) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17, $18);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_servicos_imovel_por_id(BIGINT)
RETURNS SETOF tp_servico_imovel AS $$
DECLARE
    linha tp_servico_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, existe_pavimentacao, qual_pavimentacao, iluminacao_utilizada, especifique_iluminacao, abastecimento_agua, 
	tratamento_agua, agua_encanada, existe_banheiro, escoamento_sanitario, tratamento_lixo, caes, gatos, aves, suinos, insetos, ratos, cobras 
	FROM servicos_imovel WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_servicos_imovel_por_id_imovel(BIGINT)
RETURNS SETOF tp_servico_imovel AS $$
DECLARE
    linha tp_servico_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, existe_pavimentacao, qual_pavimentacao, iluminacao_utilizada, especifique_iluminacao, abastecimento_agua, 
	tratamento_agua, agua_encanada, existe_banheiro, escoamento_sanitario, tratamento_lixo, caes, gatos, aves, suinos, insetos, ratos, cobras 
	FROM servicos_imovel WHERE id_imovel = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_servicos_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHARACTER VARYING, CHAR(3), CHARACTER VARYING, CHARACTER VARYING, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE servicos_imovel SET id_imovel = $1, existe_pavimentacao = $2, qual_pavimentacao = $3, iluminacao_utilizada = $4, especifique_iluminacao = $5, 
		abastecimento_agua = $6, tratamento_agua = $7, agua_encanada = $8, existe_banheiro = $9, escoamento_sanitario = $10, tratamento_lixo = $11, 
		caes = $12, gatos = $13, aves = $14, suinos = $15, insetos = $16, ratos = $17, cobras = $18 WHERE id = $19;
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
RETURNS SETOF tp_anexo_imovel AS $$
DECLARE
    linha tp_anexo_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, caminho, tipo FROM anexo_imovel WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_imovel_por_id_imovel(BIGINT)
RETURNS SETOF tp_anexo_imovel AS $$
DECLARE
    linha tp_anexo_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, caminho, tipo FROM anexo_imovel WHERE id_imovel = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_imovel_por_tipo(BIGINT, CHAR(1))
RETURNS SETOF tp_anexo_imovel AS $$
DECLARE
    linha tp_anexo_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, caminho, tipo FROM anexo_imovel WHERE id_imovel = $1 AND tipo = $2 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO demolicao_imovel (id_imovel, dt_demolicao, horario_demolicao, num_processo, motivo, executada_por) 
		VALUES ($1, CAST(checa_data($2) AS DATE), CAST(checa_hora($3) AS TIME), $4, $5, $6);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_demolicao_imovel_por_id(BIGINT)
RETURNS SETOF tp_demolicao_imovel AS $$
DECLARE
    linha tp_demolicao_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, dt_demolicao, horario_demolicao, num_processo, motivo, executada_por FROM anexo_imovel WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_demolicao_imovel_por_id_imovel(BIGINT)
RETURNS SETOF tp_demolicao_imovel AS $$
DECLARE
    linha tp_demolicao_imovel;
BEGIN
    FOR linha IN SELECT id, id_imovel, dt_demolicao, horario_demolicao, num_processo, motivo, executada_por FROM anexo_imovel WHERE id_imovel = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_demolicao_imovel
(BIGINT, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, TEXT, CHARACTER VARYING, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE demolicao_imovel SET id_imovel = $1, dt_demolicao = CAST(checa_data($2) AS DATE), 
		horario_demolicao = CAST(checa_hora($3) AS TIME), num_processo = $4, motivo = $5, executada_por = $6 
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
RETURNS SETOF tp_anexo_demolicao AS $$
DECLARE
    linha tp_anexo_demolicao;
BEGIN
    FOR linha IN SELECT id, id_demolicao, caminho, tipo FROM anexo_demolicao WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_demolicao_por_id_demolicao(BIGINT)
RETURNS SETOF tp_anexo_demolicao AS $$
DECLARE
    linha tp_anexo_demolicao;
BEGIN
    FOR linha IN SELECT id, id_demolicao, caminho, tipo FROM anexo_demolicao WHERE id_demolicao = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_demolicao_por_tipo(BIGINT, CHAR(1))
RETURNS SETOF tp_anexo_demolicao AS $$
DECLARE
    linha tp_anexo_demolicao;
BEGIN
    FOR linha IN SELECT id, id_demolicao, caminho, tipo FROM anexo_demolicao WHERE id_demolicao = $1 AND tipo = $2 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHAR(3), TEXT, CHARACTER VARYING, CHAR(3), CHAR(3), CHARACTER VARYING, TEXT, CHARACTER VARYING)
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
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE id = $1  AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_nome(CHARACTER VARYING)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(remove_acentos(nome)) LIKE UPPER(remove_acentos($1)) 
	AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_setor(CHARACTER VARYING)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(remove_acentos(setor_cadastral)) LIKE UPPER(remove_acentos($1)) 
	AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_zona(CHARACTER VARYING)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(remove_acentos(zona)) LIKE UPPER(remove_acentos($1)) 
	AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_origem(CHARACTER VARYING)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(remove_acentos(origem)) LIKE UPPER(remove_acentos($1)) 
	AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_ocupacao(CHARACTER VARYING)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(remove_acentos(ocupacao)) LIKE UPPER(remove_acentos($1)) 
	AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_padrao_construtivo(CHARACTER VARYING)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(remove_acentos(padrao_construtivo)) LIKE UPPER(remove_acentos($1)) 
	AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_por_renda_populacao(CHARACTER VARYING)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
    FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(remove_acentos(renda_populacao)) LIKE UPPER(remove_acentos($1)) 
	AND ativo = 'Y' LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_nucleo_existente_por_nome(CHARACTER VARYING, BIGINT)
RETURNS SETOF tp_nucleo AS $$
DECLARE
    linha tp_nucleo;
BEGIN
	FOR linha IN SELECT id, nome, origem, ocupacao, area_total, area_ocupada, num_domicilios, populacao_estimada, pop_fonte_dados, pop_outra_fonte_dados, 
	renda_populacao, inicio_ocupacao, setor_cadastral, zona, controle_ocupacao, obs_controle_ocupacao, padrao_construtivo, transporte_coletivo, 
	adensamento, adens_fonte_dados, obs_adensamento, uso_incompativel FROM nucleo WHERE UPPER(nome) = UPPER($1) AND id != $2 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_nucleo
(CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, DOUBLE PRECISION, DOUBLE PRECISION, INTEGER, INTEGER, 
CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, CHARACTER VARYING, 
CHAR(3), TEXT, CHARACTER VARYING, CHAR(3), CHAR(3), CHARACTER VARYING, TEXT, CHARACTER VARYING, BIGINT)
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
		UPDATE nucleo SET ativo = 'N' WHERE id = $1;
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
RETURNS SETOF tp_anexo_transporte AS $$
DECLARE
    linha tp_anexo_transporte;
BEGIN
    FOR linha IN SELECT id, id_nucleo, caminho, tipo FROM anexo_transporte WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_transporte_por_id_nucleo(BIGINT)
RETURNS SETOF tp_anexo_transporte AS $$
DECLARE
    linha tp_anexo_transporte;
BEGIN
    FOR linha IN SELECT id, id_nucleo, caminho, tipo FROM anexo_transporte WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_transporte_por_tipo(BIGINT, CHAR(1))
RETURNS SETOF tp_anexo_transporte AS $$
DECLARE
    linha tp_anexo_transporte;
BEGIN
    FOR linha IN SELECT id, id_nucleo, caminho, tipo FROM anexo_transporte WHERE id_nucleo = $1 AND tipo = $2 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_infraestrutura_urbana AS $$
DECLARE
    linha tp_infraestrutura_urbana;
BEGIN
    FOR linha IN SELECT id, id_nucleo, abastecimento_agua, coleta_esgoto, servicos_limpeza, aguas_pluviais_superficial, aguas_pluviais_rede, 
	energia_eletrica, iluminacao_publica FROM infraestrutura_urbana WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_infraestrutura_urbana_por_id_nucleo(BIGINT)
RETURNS SETOF tp_infraestrutura_urbana AS $$
DECLARE
    linha tp_infraestrutura_urbana;
BEGIN
    FOR linha IN SELECT id, id_nucleo, abastecimento_agua, coleta_esgoto, servicos_limpeza, aguas_pluviais_superficial, aguas_pluviais_rede, 
	energia_eletrica, iluminacao_publica FROM infraestrutura_urbana WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_situacao_fundiaria AS $$
DECLARE
    linha tp_situacao_fundiaria;
BEGIN
    FOR linha IN SELECT id, id_nucleo, propriedade, proprietario, obs_propriedade, decreto_aprovacao, registrado, num_matricula, destinacao_areas, desc_destinacao_areas, 
		desc_zonas_solo, desc_ecologico_economico, processos_judiciais, num_processo, num_ordem, vara, existencia_embargos, obs_judiciais 
		FROM situacao_fundiaria WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_situacao_fundiaria_por_id_nucleo(BIGINT)
RETURNS SETOF tp_situacao_fundiaria AS $$
DECLARE
    linha tp_situacao_fundiaria;
BEGIN
    FOR linha IN SELECT id, id_nucleo, propriedade, proprietario, obs_propriedade, decreto_aprovacao, registrado, num_matricula, destinacao_areas, desc_destinacao_areas, 
		desc_zonas_solo, desc_ecologico_economico, processos_judiciais, num_processo, num_ordem, vara, existencia_embargos, obs_judiciais 
		FROM situacao_fundiaria WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_anexo_zoneamento AS $$
DECLARE
    linha tp_anexo_zoneamento;
BEGIN
    FOR linha IN SELECT id, id_fundiaria, caminho, tipo FROM anexo_zoneamento WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_zoneamento_por_id_fundiaria(BIGINT)
RETURNS SETOF tp_anexo_zoneamento AS $$
DECLARE
    linha tp_anexo_zoneamento;
BEGIN
    FOR linha IN SELECT id, id_fundiaria, caminho, tipo FROM anexo_zoneamento WHERE id_fundiaria = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_zoneamento_por_tipo(BIGINT, CHAR(1))
RETURNS SETOF tp_anexo_zoneamento AS $$
DECLARE
    linha tp_anexo_zoneamento;
BEGIN
    FOR linha IN SELECT id, id_fundiaria, caminho, tipo FROM anexo_zoneamento WHERE id_fundiaria = $1 AND tipo = $2 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_anexo_judicial AS $$
DECLARE
    linha tp_anexo_judicial;
BEGIN
    FOR linha IN SELECT id, id_fundiaria, caminho, tipo FROM anexo_judicial WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_judicial_por_id_fundiaria(BIGINT)
RETURNS SETOF tp_anexo_judicial AS $$
DECLARE
    linha tp_anexo_judicial;
BEGIN
    FOR linha IN SELECT id, id_fundiaria, caminho, tipo FROM anexo_judicial WHERE id_fundiaria = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_anexo_judicial_por_tipo(BIGINT, CHAR(1))
RETURNS SETOF tp_anexo_judicial AS $$
DECLARE
    linha tp_anexo_judicial;
BEGIN
    FOR linha IN SELECT id, id_fundiaria, caminho, tipo FROM anexo_judicial WHERE id_fundiaria = $1 AND tipo = $2 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_acao_nucleo AS $$
DECLARE
    linha tp_acao_nucleo;
BEGIN
    FOR linha IN SELECT id, id_nucleo, remanejamento, reassentamento, desconstrucao, melhoria_habitacional, fonte_melhoria, 
	recuperacao_ambiental, prad, adequacao_infraestrutura, fonte_adequacao, outros, desc_outros FROM acoes_nucleo WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_acoes_nucleo_por_id_nucleo(BIGINT)
RETURNS SETOF tp_acao_nucleo AS $$
DECLARE
    linha tp_acao_nucleo;
BEGIN
    FOR linha IN SELECT id, id_nucleo, remanejamento, reassentamento, desconstrucao, melhoria_habitacional, fonte_melhoria, 
	recuperacao_ambiental, prad, adequacao_infraestrutura, fonte_adequacao, outros, desc_outros FROM acoes_nucleo WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_remanejamento AS $$
DECLARE
    linha tp_remanejamento;
BEGIN
    FOR linha IN SELECT id, id_acao, estimativa_relocacao, num_remocao_definitiva, num_remocao_provisoria FROM remanejamentos WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_remanejamento_por_id_acao(BIGINT)
RETURNS SETOF tp_remanejamento AS $$
DECLARE
    linha tp_remanejamento;
BEGIN
    FOR linha IN SELECT id, id_acao, estimativa_relocacao, num_remocao_definitiva, num_remocao_provisoria FROM remanejamentos WHERE id_acao = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_reassentamento AS $$
DECLARE
    linha tp_reassentamento;
BEGIN
    FOR linha IN SELECT id, id_acao, estimativa_remocao, num_a_construir, num_provisorias, local_definitivo FROM reassentamentos WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_reassentamento_por_id_acao(BIGINT)
RETURNS SETOF tp_reassentamento AS $$
DECLARE
    linha tp_reassentamento;
BEGIN
    FOR linha IN SELECT id, id_acao, estimativa_remocao, num_a_construir, num_provisorias, local_definitivo FROM reassentamentos WHERE id_acao = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_desconstrucao AS $$
DECLARE
    linha tp_desconstrucao;
BEGIN
    FOR linha IN SELECT id, id_acao, num_a_demolir, motivo, processos FROM desconstrucoes WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_desconstrucao_por_id_acao(BIGINT)
RETURNS SETOF tp_desconstrucao AS $$
DECLARE
    linha tp_desconstrucao;
BEGIN
    FOR linha IN SELECT id, id_acao, num_a_demolir, motivo, processos FROM desconstrucoes WHERE id_acao = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
(BIGINT, CHAR(3), CHAR(3), CHAR(3), TEXT, DOUBLE PRECISION, DOUBLE PRECISION)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO aspectos_ambientais (id_nucleo, area_verde, area_agricola, outros, outros_especifique, latitude, longitude) 
		VALUES ($1, $2, $3, $4, $5, $6, $7);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_aspecto_ambiental_por_id(BIGINT)
RETURNS SETOF tp_aspecto_ambiental AS $$
DECLARE
    linha tp_aspecto_ambiental;
BEGIN
    FOR linha IN SELECT id, id_nucleo, area_verde, area_agricola, outros, outros_especifique, latitude, longitude 
	FROM aspectos_ambientais WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_aspecto_ambiental_por_id_nucleo(BIGINT)
RETURNS SETOF tp_aspecto_ambiental AS $$
DECLARE
    linha tp_aspecto_ambiental;
BEGIN
    FOR linha IN SELECT id, id_nucleo, area_verde, area_agricola, outros, outros_especifique, latitude, longitude 
	FROM aspectos_ambientais WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_aspecto_ambiental
(BIGINT, CHAR(3), CHAR(3), CHAR(3), TEXT, DOUBLE PRECISION, DOUBLE PRECISION, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE aspectos_ambientais SET id_nucleo = $1, area_verde = $2, area_agricola = $3, 
		outros = $4, outros_especifique = $5, latitude = $6, longitude = $7 WHERE id = $8; 
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
		INSERT INTO apps (id_ambiental, corpo_dagua, brejo_charco, topo_morro, enconsta, restinga, outros, especifique_outros) 
		VALUES ($1, $2, $3, $4, $5, $6, $7, $8);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_app_por_id(BIGINT)
RETURNS SETOF tp_app AS $$
DECLARE
    linha tp_app;
BEGIN
    FOR linha IN SELECT id, id_ambiental, corpo_dagua, brejo_charco, topo_morro, enconsta, restinga, outros, especifique_outros 
	FROM apps WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_app_por_id_aspecto_ambiental(BIGINT)
RETURNS SETOF tp_app AS $$
DECLARE
    linha tp_app;
BEGIN
    FOR linha IN SELECT id, id_ambiental, corpo_dagua, brejo_charco, topo_morro, enconsta, restinga, outros, especifique_outros 
	FROM apps WHERE id_ambiental = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_app
(BIGINT, CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), CHAR(3), TEXT, BIGINT)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE apps SET id_ambiental = $1, corpo_dagua = $2, brejo_charco = $3, topo_morro = $4, enconsta = $5, restinga = $6, 
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
RETURNS SETOF tp_area_risco AS $$
DECLARE
    linha tp_area_risco;
BEGIN
    FOR linha IN SELECT id, cd_setor, grau_risco, vegetacao, processo_instabilizacao, condicoes_solo, existe_pavimentacao, obs_pavimentacao, 
	latitude, longitude FROM area_risco WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_programa_habitacional AS $$
DECLARE
    linha tp_programa_habitacional;
BEGIN
    FOR linha IN SELECT id, id_nucleo, material_construcao, producao_moradias, assistencia_tecnica, urb_assentamentos_precarios, 
	complementacao_infraestrutura, regularizacao_fundiaria, cdhu, pmcmv FROM programas_habitacionais WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_programa_habitacional_por_id_nucleo(BIGINT)
RETURNS SETOF tp_programa_habitacional AS $$
DECLARE
    linha tp_programa_habitacional;
BEGIN
    FOR linha IN SELECT id, id_nucleo, material_construcao, producao_moradias, assistencia_tecnica, urb_assentamentos_precarios, 
	complementacao_infraestrutura, regularizacao_fundiaria, cdhu, pmcmv FROM programas_habitacionais WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
(BIGINT, INTEGER, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO vias_publicas (id_nucleo, id_recurso, descricao) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_via_publica_por_id(BIGINT)
RETURNS SETOF tp_via_publica AS $$
DECLARE
    linha tp_via_publica;
BEGIN
    FOR linha IN SELECT id, id_recurso, id_nucleo, descricao FROM vias_publicas WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_via_publica_por_id_nucleo(BIGINT)
RETURNS SETOF tp_via_publica_completa AS $$
DECLARE
    linha tp_via_publica_completa;
BEGIN
    FOR linha IN SELECT v.id AS id, v.id_nucleo AS id_nucleo, v.id_recurso AS id_recurso, rm.nome AS nome_recurso, v.descricao AS descricao 
	FROM vias_publicas AS v 
	INNER JOIN recurso_mobilidade AS rm ON v.id_recurso = rm.id
	WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_via_publica_por_id_recurso(INTEGER)
RETURNS SETOF tp_via_publica AS $$
DECLARE
    linha tp_via_publica;
BEGIN
    FOR linha IN SELECT id, id_recurso, id_nucleo, descricao FROM vias_publicas WHERE id_recurso = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_via_publica
(BIGINT, INTEGER, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE vias_publicas SET descricao = $3, id_recurso = $2 WHERE id = $1; 
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
RETURNS SETOF tp_recurso_mobilidade AS $$
DECLARE
    linha tp_recurso_mobilidade;
BEGIN
    FOR linha IN SELECT id, nome FROM recurso_mobilidade WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_recurso_mobilidade_por_nome(CHARACTER VARYING)
RETURNS SETOF tp_recurso_mobilidade AS $$
DECLARE
    linha tp_recurso_mobilidade;
BEGIN
    FOR linha IN SELECT id, nome FROM recurso_mobilidade WHERE UPPER(remove_acentos(nome)) = UPPER(remove_acentos($1)) LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
(BIGINT, INTEGER, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO institucional_social (id_nucleo, id_recurso, nome) 
		VALUES ($1, $2, $3);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_institucional_social_por_id(BIGINT)
RETURNS SETOF tp_institucional_social AS $$
DECLARE
    linha tp_institucional_social;
BEGIN
    FOR linha IN SELECT id, id_recurso, id_nucleo, nome FROM institucional_social WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_institucional_social_por_id_nucleo(BIGINT)
RETURNS SETOF tp_institucional_social_completo AS $$
DECLARE
    linha tp_institucional_social_completo;
BEGIN
    FOR linha IN SELECT i.id AS id, i.id_nucleo AS id_nucleo, i.id_recurso AS id_recurso, rs.nome AS nome_recurso, i.nome AS nome  
	FROM institucional_social AS i 
	INNER JOIN recurso_social AS rs ON i.id_recurso = rs.id 
	WHERE id_nucleo = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_institucional_social_por_id_recurso(INTEGER)
RETURNS SETOF tp_institucional_social AS $$
DECLARE
    linha tp_institucional_social;
BEGIN
    FOR linha IN SELECT id, id_recurso, id_nucleo, nome FROM institucional_social WHERE id_recurso = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_institucional_social
(BIGINT, INTEGER, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE institucional_social SET nome = $3, id_recurso = $2 WHERE id = $1;
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
RETURNS SETOF tp_recurso_social AS $$
DECLARE
    linha tp_recurso_social;
BEGIN
    FOR linha IN SELECT id, nome FROM recurso_social WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_recurso_social_por_nome(CHARACTER VARYING)
RETURNS SETOF tp_recurso_social AS $$
DECLARE
    linha tp_recurso_social;
BEGIN
    FOR linha IN SELECT id, nome FROM recurso_social WHERE UPPER(remove_acentos(nome)) = UPPER(remove_acentos($1)) LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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


-------------------- DEPARTAMENTOS -----------------


CREATE OR REPLACE FUNCTION fn_inserir_departamento
(CHARACTER VARYING, CHARACTER VARYING, TEXT, CHAR(3))
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		INSERT INTO departamentos (sigla, nome, descricao, ativo) 
		VALUES ($1, $2, $3, $4);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_departamento_por_id(INTEGER)
RETURNS SETOF tp_departamento AS $$
DECLARE
    linha tp_departamento;
BEGIN
    FOR linha IN SELECT id, sigla, nome, descricao, ativo FROM departamentos WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_departamento_por_sigla(CHARACTER VARYING)
RETURNS SETOF tp_departamento AS $$
DECLARE
    linha tp_departamento;
BEGIN
    FOR linha IN SELECT id, sigla, nome, descricao, ativo FROM departamentos WHERE UPPER(remove_acentos(sigla)) = UPPER(remove_acentos($1)) LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_departamento_por_nome(CHARACTER VARYING)
RETURNS SETOF tp_departamento AS $$
DECLARE
    linha tp_departamento;
BEGIN
    FOR linha IN SELECT id, sigla, nome, descricao, ativo FROM departamentos WHERE UPPER(remove_acentos(nome)) LIKE UPPER(remove_acentos($1)) LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_departamento
(CHARACTER VARYING, CHARACTER VARYING, TEXT, CHAR(3), INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE departamentos SET sigla = $1, nome = $2, descricao = $3, ativo = $4 
		WHERE id = $5;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_excluir_departamento(INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		DELETE FROM departamentos WHERE id = $1;
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
RETURNS SETOF tp_grupo AS $$
DECLARE
    linha tp_grupo;
BEGIN
    FOR linha IN SELECT id, nome, descricao, ativo FROM grupos WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_grupo_por_nome(CHARACTER VARYING)
RETURNS SETOF tp_grupo AS $$
DECLARE
    linha tp_grupo;
BEGIN
    FOR linha IN SELECT id, nome, descricao, ativo FROM grupos WHERE UPPER(remove_acentos(nome)) = UPPER(remove_acentos($1)) LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
RETURNS SETOF tp_permissao AS $$
DECLARE
    linha tp_permissao;
BEGIN
    FOR linha IN SELECT id, nome, descricao FROM permissoes WHERE id = $1 LOOP
        RETURN NEXT linha;
    END LOOP;
    RETURN;
END;
$$ LANGUAGE PLPGSQL;


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
		INSERT INTO usuarios (id_grupo, id_departamento, usuario, senha, foto, nome, email, ativo) 
		VALUES ($1, $2, $3, MD5($4), $5, $6, $7, $8);
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_usuario_por_id(INTEGER)
RETURNS SETOF tp_usuario AS $$
	DECLARE
		linha tp_usuario;
	BEGIN
		FOR linha IN SELECT id, id_grupo, id_departamento, usuario, senha, foto, nome, email, ativo FROM usuarios WHERE id = $1 LOOP
			RETURN NEXT linha;
		END LOOP;
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_usuario_por_nomeusuario(CHARACTER VARYING)
RETURNS SETOF tp_usuario AS $$
	DECLARE
		linha tp_usuario;
	BEGIN
		FOR linha IN SELECT id, id_grupo, id_departamento, usuario, senha, foto, nome, email, ativo FROM usuarios WHERE UPPER(remove_acentos(usuario)) = UPPER(remove_acentos($1)) LOOP
			RETURN NEXT linha;
		END LOOP;
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_usuario_completo_por_nomeusuario(CHARACTER VARYING)
RETURNS TABLE (
	u_id INTEGER,
	u_usuario VARCHAR(20),
	u_senha VARCHAR(32),
	u_foto TEXT,
	u_nome VARCHAR(255),
	u_email VARCHAR(255),
	u_ativo CHAR(3),
	d_id INTEGER,
	d_sigla VARCHAR(10),
	d_nome VARCHAR(255),
	d_descricao TEXT,
	d_ativo CHAR(3),
	g_id INTEGER,
	g_nome VARCHAR(255),
	g_descricao TEXT,
	g_ativo CHAR(3)
) AS $$
	BEGIN
		RETURN QUERY SELECT u.id, u.usuario, u.senha, u.foto, u.nome, u.email, u.ativo, 
		d.id, d.sigla, d.nome, d.descricao, d.ativo, 
		g.id, g.nome, g.descricao, g.ativo  
		FROM usuarios AS u 
		INNER JOIN departamentos AS d ON u.id_departamento = d.id 
		INNER JOIN grupos AS g ON u.id_grupo = g.id 
		WHERE UPPER(remove_acentos(u.usuario)) = UPPER(remove_acentos($1));
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_usuario_completo_por_nomeusuario(CHARACTER VARYING)
RETURNS TABLE (
	u_id INTEGER,
	u_usuario VARCHAR(20),
	u_senha VARCHAR(32),
	u_foto TEXT,
	u_nome VARCHAR(255),
	u_email VARCHAR(255),
	u_ativo CHAR(3),
	d_id INTEGER,
	d_sigla VARCHAR(10),
	d_nome VARCHAR(255),
	d_descricao TEXT,
	d_ativo CHAR(3),
	g_id INTEGER,
	g_nome VARCHAR(255),
	g_descricao TEXT,
	g_ativo CHAR(3)
) AS $$
	BEGIN
		RETURN QUERY SELECT u.id, u.usuario, u.senha, u.foto, u.nome, u.email, u.ativo, 
		d.id, d.sigla, d.nome, d.descricao, d.ativo, 
		g.id, g.nome, g.descricao, g.ativo  
		FROM usuarios AS u 
		INNER JOIN departamentos AS d ON u.id_departamento = d.id 
		INNER JOIN grupos AS g ON u.id_grupo = g.id 
		WHERE UPPER(remove_acentos(u.usuario)) LIKE UPPER(remove_acentos('%' || $1 || '%'));
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_usuario_completo_por_nome(CHARACTER VARYING)
RETURNS TABLE (
	u_id INTEGER,
	u_usuario VARCHAR(20),
	u_senha VARCHAR(32),
	u_foto TEXT,
	u_nome VARCHAR(255),
	u_email VARCHAR(255),
	u_ativo CHAR(3),
	d_id INTEGER,
	d_sigla VARCHAR(10),
	d_nome VARCHAR(255),
	d_descricao TEXT,
	d_ativo CHAR(3),
	g_id INTEGER,
	g_nome VARCHAR(255),
	g_descricao TEXT,
	g_ativo CHAR(3)
) AS $$
	BEGIN
		RETURN QUERY SELECT u.id, u.usuario, u.senha, u.foto, u.nome, u.email, u.ativo, 
		d.id, d.sigla, d.nome, d.descricao, d.ativo, 
		g.id, g.nome, g.descricao, g.ativo  
		FROM usuarios AS u 
		INNER JOIN departamentos AS d ON u.id_departamento = d.id 
		INNER JOIN grupos AS g ON u.id_grupo = g.id 
		WHERE UPPER(remove_acentos(u.nome)) LIKE UPPER(remove_acentos('%' || $1 || '%'));
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_procurar_usuario_completo_por_email(CHARACTER VARYING)
RETURNS TABLE (
	u_id INTEGER,
	u_usuario VARCHAR(20),
	u_senha VARCHAR(32),
	u_foto TEXT,
	u_nome VARCHAR(255),
	u_email VARCHAR(255),
	u_ativo CHAR(3),
	d_id INTEGER,
	d_sigla VARCHAR(10),
	d_nome VARCHAR(255),
	d_descricao TEXT,
	d_ativo CHAR(3),
	g_id INTEGER,
	g_nome VARCHAR(255),
	g_descricao TEXT,
	g_ativo CHAR(3)
) AS $$
	BEGIN
		RETURN QUERY SELECT u.id, u.usuario, u.senha, u.foto, u.nome, u.email, u.ativo, 
		d.id, d.sigla, d.nome, d.descricao, d.ativo, 
		g.id, g.nome, g.descricao, g.ativo  
		FROM usuarios AS u 
		INNER JOIN departamentos AS d ON u.id_departamento = d.id 
		INNER JOIN grupos AS g ON u.id_grupo = g.id 
		WHERE UPPER(remove_acentos(u.email)) LIKE UPPER(remove_acentos('%' || $1 || '%'));
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_logon_usuario
(CHARACTER VARYING, CHARACTER VARYING)
RETURNS SETOF tp_usuario AS $$
	DECLARE
		linha tp_usuario;
	BEGIN
		FOR linha IN SELECT id, id_grupo, id_departamento, usuario, senha, foto, nome, email, ativo FROM usuarios 
		WHERE usuario = $1 AND senha = MD5($2) AND ativo = 'Sim' LOOP
			RETURN NEXT linha;
		END LOOP;
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_usuario
(INTEGER, INTEGER, CHARACTER VARYING, TEXT, CHARACTER VARYING, CHARACTER VARYING, CHAR(3), INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE usuarios SET id_grupo = $1, id_departamento = $2, usuario = $3, foto = $4, nome = $5, email = $6, ativo = $7 
		WHERE id = $8;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_foto_usuario
(TEXT, INTEGER)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE usuarios SET foto = $1 WHERE id = $2;
		GET DIAGNOSTICS affected_rows := ROW_COUNT;
		RETURN affected_rows;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_alterar_senha_usuario
(CHARACTER VARYING, CHARACTER VARYING)
RETURNS INTEGER AS $$
	DECLARE 
		affected_rows INTEGER DEFAULT 0;
	BEGIN
		UPDATE usuarios SET senha = MD5($1) 
		WHERE usuario = $2;
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


-------------------- ESTADOS -----------------


CREATE OR REPLACE FUNCTION fn_procurar_estado_por_id_pais(INTEGER)
RETURNS SETOF tp_estado AS $$
	DECLARE
		linha tp_estado;
	BEGIN
		FOR linha IN SELECT id, id_pais, sigla, nome FROM estados WHERE id_pais = $1 LOOP
			RETURN NEXT linha;
		END LOOP;
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_estado_id(CHARACTER VARYING)
RETURNS SETOF tp_estado AS $$
	DECLARE
		linha tp_estado;
	BEGIN
		FOR linha IN SELECT id FROM estados WHERE nome = $1 LOOP
			RETURN NEXT linha;
		END LOOP;
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


-------------------- MUNICÕPIOS -----------------


CREATE OR REPLACE FUNCTION fn_procurar_municipio_por_id_estado(BIGINT)
RETURNS SETOF tp_municipio AS $$
	DECLARE
		linha tp_municipio;
	BEGIN
		FOR linha IN SELECT id, id_estado, nome FROM municipios WHERE id_estado = $1 ORDER BY nome ASC LOOP
			RETURN NEXT linha;
		END LOOP;
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;


CREATE OR REPLACE FUNCTION fn_selecionar_municipio_id(CHARACTER VARYING, BIGINT)
RETURNS SETOF tp_municipio AS $$
	DECLARE
		linha tp_municipio;
	BEGIN
		FOR linha IN SELECT id FROM municipios WHERE nome = $1 AND id_estado = $2 LOOP
			RETURN NEXT linha;
		END LOOP;
		RETURN;
	END;
$$ LANGUAGE PLPGSQL;

