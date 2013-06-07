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

