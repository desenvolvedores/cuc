----------------------------------------------------------------- TRIGGERS DO SISTEMA ------------------------------------------------------------------------


--------------------------- HISTÓRICO INDIVÍDUO IMÓVEL -------------------------------


CREATE OR REPLACE FUNCTION fn_inserir_historico_habitacional_individuo()
RETURNS TRIGGER AS $$
	BEGIN
		INSERT INTO historico_habitacional_individuo (id_individuo, id_imovel) VALUES (OLD.id_individuo, OLD.id_imovel);
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_inserir_historico_habitacional_individuo BEFORE DELETE 
ON public.individuo_imovel FOR EACH ROW
	EXECUTE PROCEDURE public.fn_inserir_historico_habitacional_individuo();
	
	
----------------------------- HISTÓRICO EMPRESA IMÓVEL -------------------------------
	
	
CREATE OR REPLACE FUNCTION fn_inserir_historico_habitacional_empresa()
RETURNS TRIGGER AS $$
	BEGIN
		INSERT INTO historico_habitacional_empresa (id_empresa, id_imovel) VALUES (OLD.id_empresa, OLD.id_imovel);
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_inserir_historico_habitacional_empresa BEFORE DELETE 
ON public.empresa_imovel FOR EACH ROW
	EXECUTE PROCEDURE public.fn_inserir_historico_habitacional_empresa();
	
	
-------------------------------- PERMISSÕES GRUPO -------------------------------
	
	
CREATE OR REPLACE FUNCTION fn_inserir_permissao_grupo()
RETURNS TRIGGER AS $$
	DECLARE
		num_id INTEGER;
		refcursor CURSOR FOR SELECT id FROM grupos;
	BEGIN
		OPEN refcursor;
		LOOP
			FETCH refcursor INTO num_id;
			INSERT INTO grupos_permissoes (id_grupo, id_permissao) VALUES (num_id, NEW.id);
		END LOOP;
		CLOSE refcursor;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_inserir_permissao_grupo AFTER INSERT 
ON public.permissoes FOR EACH ROW
	EXECUTE PROCEDURE public.fn_inserir_permissao_grupo();
	
	
-------------------------------- GRUPO PERMISSÕES -------------------------------


CREATE OR REPLACE FUNCTION fn_inserir_grupo_permissao()
RETURNS TRIGGER AS $$
	DECLARE
		num_id INTEGER;
		refcursor CURSOR FOR SELECT id FROM permissoes;
	BEGIN
		OPEN refcursor;
		LOOP
			FETCH refcursor INTO num_id;
			INSERT INTO grupos_permissoes (id_grupo, id_permissao) VALUES (NEW.id, num_id);
		END LOOP;
		CLOSE refcursor;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_inserir_grupo_permissao AFTER INSERT 
ON public.grupos FOR EACH ROW
	EXECUTE PROCEDURE public.fn_inserir_grupo_permissao();
	
	
-------------------------------------- NÚCLEO -------------------------------------


CREATE OR REPLACE FUNCTION fn_ativar_desativar_registros_nucleo()
RETURNS TRIGGER AS $$
	BEGIN
		UPDATE infraestrutura_urbana SET ativo = NEW.ativo WHERE id_nucleo = NEW.id;
		UPDATE situacao_fundiaria SET ativo = NEW.ativo WHERE id_nucleo = NEW.id;
		UPDATE aspectos_ambientais SET ativo = NEW.ativo WHERE id_nucleo = NEW.id;
		UPDATE acoes_nucleo SET ativo = NEW.ativo WHERE id_nucleo = NEW.id;
		UPDATE programas_habitacionais SET ativo = NEW.ativo WHERE id_nucleo = NEW.id;
		UPDATE anexo_transporte SET ativo = NEW.ativo WHERE id_nucleo = NEW.id;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_ativar_desativar_registros_nucleo AFTER UPDATE 
ON public.nucleo FOR EACH ROW
	EXECUTE PROCEDURE public.fn_ativar_desativar_registros_nucleo();
	
	
-------------------------------------- SITUAÇÃO FUNDIÁRIA -------------------------------------


CREATE OR REPLACE FUNCTION fn_ativar_desativar_registros_situacao_fundiaria()
RETURNS TRIGGER AS $$
	BEGIN
		UPDATE anexo_judicial SET ativo = NEW.ativo WHERE id_fundiaria = NEW.id;
		UPDATE anexo_zoneamento SET ativo = NEW.ativo WHERE id_fundiaria = NEW.id;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_ativar_desativar_registros_situacao_fundiaria AFTER UPDATE 
ON public.situacao_fundiaria FOR EACH ROW
	EXECUTE PROCEDURE public.fn_ativar_desativar_registros_situacao_fundiaria();
	
	
-------------------------------------- AÇÃO NÚCLEO -------------------------------------


CREATE OR REPLACE FUNCTION fn_ativar_desativar_registros_acoes_nucleo()
RETURNS TRIGGER AS $$
	BEGIN
		UPDATE remanejamentos SET ativo = NEW.ativo WHERE id_acao = NEW.id;
		UPDATE reassentamentos SET ativo = NEW.ativo WHERE id_acao = NEW.id;
		UPDATE desconstrucoes SET ativo = NEW.ativo WHERE id_acao = NEW.id;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_ativar_desativar_registros_acoes_nucleo AFTER UPDATE 
ON public.acoes_nucleo FOR EACH ROW
	EXECUTE PROCEDURE public.fn_ativar_desativar_registros_acoes_nucleo();
	
	
-------------------------------------- ASPECTOS AMBIENTAIS -------------------------------------


CREATE OR REPLACE FUNCTION fn_ativar_desativar_registros_aspectos_ambientais()
RETURNS TRIGGER AS $$
	BEGIN
		UPDATE ambiental_area_risco SET ativo = NEW.ativo WHERE id_ambiental = NEW.id;
		UPDATE apps SET ativo = NEW.ativo WHERE id_ambiental = NEW.id;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_ativar_desativar_registros_aspectos_ambientais AFTER UPDATE 
ON public.aspectos_ambientais FOR EACH ROW
	EXECUTE PROCEDURE public.fn_ativar_desativar_registros_aspectos_ambientais();
	
	
-------------------------------------- IMÓVEL ---------------------------------------------------


CREATE OR REPLACE FUNCTION fn_ativar_desativar_registros_imovel()
RETURNS TRIGGER AS $$
	BEGIN
		UPDATE composicao_imovel SET ativo = NEW.ativo WHERE id_imovel = NEW.id;
		UPDATE endereco_imovel SET ativo = NEW.ativo WHERE id_imovel = NEW.id;
		UPDATE servicos_imovel SET ativo = NEW.ativo WHERE id_imovel = NEW.id;
		UPDATE demolicao_imovel SET ativo = NEW.ativo WHERE id_imovel = NEW.id;
		UPDATE anexo_imovel SET ativo = NEW.ativo WHERE id_imovel = NEW.id;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_ativar_desativar_registros_imovel AFTER UPDATE 
ON public.imovel FOR EACH ROW
	EXECUTE PROCEDURE public.fn_ativar_desativar_registros_imovel();
	
	
-------------------------------------- DEMOLIÇÃO IMÓVEL --------------------------------------


CREATE OR REPLACE FUNCTION fn_ativar_desativar_registros_demolicao_imovel()
RETURNS TRIGGER AS $$
	BEGIN
		UPDATE anexo_demolicao SET ativo = NEW.ativo WHERE id_demolicao = NEW.id;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;


CREATE TRIGGER tg_ativar_desativar_registros_demolicao_imovel AFTER UPDATE 
ON public.demolicao_imovel FOR EACH ROW
	EXECUTE PROCEDURE public.fn_ativar_desativar_registros_demolicao_imovel();
	
	