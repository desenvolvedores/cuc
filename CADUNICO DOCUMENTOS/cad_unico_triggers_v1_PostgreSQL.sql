----------------------------------------------------------------- TRIGGERS DO SISTEMA ------------------------------------------------------------------------


----------------------- INDIVÍDUO IMÓVEL -------------------------------


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
	
	
------------------------- EMPRESA IMÓVEL -------------------------------
	
	
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

