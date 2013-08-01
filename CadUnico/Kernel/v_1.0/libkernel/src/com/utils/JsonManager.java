/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.utils;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class JsonManager {
    
    public JsonManager() {
        
    }
    
    public String parseJson(com.common.Endereco endereco) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(endereco);
        
    }
    
    public String parseJson(com.common.EnderecoImovel endereco) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(endereco);
        
    }
    
    public String parseJson(com.common.Telefone telefone) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(telefone);
        
    }
    
    public String parseJson(com.common.TelefoneEmpresa telefone) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(telefone);
        
    }
    
    public String parseJson(com.common.TelefoneIndividuo telefone) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(telefone);
        
    }
    
    public String parseJson(com.doc.Anexo anexo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexo);
        
    }
    
    public String parseJson(com.doc.AnexoDemolicao anexo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexo);
        
    }
    
    public String parseJson(com.doc.AnexoImovel anexo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexo);
        
    }
    
    public String parseJson(com.doc.AnexoIndividuo anexo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexo);
        
    }
    
    public String parseJson(com.doc.AnexoJudicial anexo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexo);
        
    }
    
    public String parseJson(com.doc.AnexoTransporte anexo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexo);
        
    }
    
    public String parseJson(com.doc.AnexoZoneamento anexo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexo);
        
    }
    
    public String parseJson(com.sys.habitacional.ComposicaoImovel composicao) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(composicao);
        
    }
    
    public String parseJson(com.sys.habitacional.DemolicaoImovel demolicao) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(demolicao);
        
    }
    
    public String parseJson(com.sys.habitacional.Imovel imovel) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(imovel);
        
    }
    
    public String parseJson(com.sys.habitacional.ServicoImovel servico) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(servico);
        
    }
    
    public String parseJson(com.sys.social.DeficienteIndividuo deficiente) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(deficiente);
        
    }
    
    public String parseJson(com.sys.social.DocumentoEmpresa documento) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(documento);
        
    }
    
    public String parseJson(com.sys.social.DocumentoIndividuo documento) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(documento);
        
    }
    
    public String parseJson(com.sys.social.Empresa empresa) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(empresa);
        
    }
    
    public String parseJson(com.sys.social.EscolaridadeIndividuo escolaridade) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(escolaridade);
        
    }
    
    public String parseJson(com.sys.social.Familia familia) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(familia);
        
    }
    
    public String parseJson(com.sys.social.Individuo individuo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(individuo);
        
    }
    
    public String parseJson(com.sys.social.CertidaoIndividuo certidao) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(certidao);
        
    }
    
    public String parseJson(com.sys.social.ProfissionalIndividuo profissional) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(profissional);
        
    }
    
    public String parseJson(com.sys.urbano.AcaoNucleo acao) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(acao);
        
    }
    
    public String parseJson(com.sys.urbano.App app) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(app);
        
    }
    
    public String parseJson(com.sys.urbano.AreaRisco area) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(area);
        
    }
    
    public String parseJson(com.sys.urbano.AspectoAmbiental aspecto) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(aspecto);
        
    }
    
    public String parseJson(com.sys.urbano.Desconstrucao desconstrucao) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(desconstrucao);
        
    }
    
    public String parseJson(com.sys.urbano.InfraestruturaUrbana infraestrutura) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(infraestrutura);
        
    }
    
    public String parseJson(com.sys.urbano.InstitucionalSocial institucional) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(institucional);
        
    }
    
    public String parseJson(com.sys.urbano.Nucleo nucleo) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(nucleo);
        
    }
    
    public String parseJson(com.sys.urbano.ProgramaHabitacional programa) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(programa);
        
    }
    
    public String parseJson(com.sys.urbano.Reassentamento reassentamento) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(reassentamento);
        
    }
    
    public String parseJson(com.sys.urbano.RecursoMobilidade recurso) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(recurso);
        
    }
    
    public String parseJson(com.sys.urbano.RecursoSocial recurso) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(recurso);
        
    }
    
    public String parseJson(com.sys.urbano.Remanejamento remanejamento) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(remanejamento);
        
    }
    
    public String parseJson(com.sys.urbano.SituacaoFundiaria fundiaria) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(fundiaria);
        
    }
    
    public String parseJson(com.sys.urbano.ViaPublica via) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(via);
        
    }
    
    public String parseJsonListaEndereco(java.util.List<com.common.Endereco> enderecos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(enderecos);
        
    }
    
    public String parseJsonListaEnderecoImovel(java.util.List<com.common.EnderecoImovel> enderecos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(enderecos);
        
    }
    
    public String parseJsonListaTelefone(java.util.List<com.common.Telefone> telefones) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(telefones);
        
    }
    
    public String parseJsonListaTelefoneEmpresa(java.util.List<com.common.TelefoneEmpresa> telefones) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(telefones);
        
    }
    
    public String parseJsonListaTelefoneIndividuo(java.util.List<com.common.TelefoneIndividuo> telefones) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(telefones);
        
    }
    
    public String parseJsonListaAnexo(java.util.List<com.doc.Anexo> anexos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexos);
        
    }
    
    public String parseJsonListaAnexoDemolicao(java.util.List<com.doc.AnexoDemolicao> anexos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexos);
        
    }
    
    public String parseJsonListaAnexoImovel(java.util.List<com.doc.AnexoImovel> anexos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexos);
        
    }
    
    public String parseJsonListaAnexoIndividuo(java.util.List<com.doc.AnexoIndividuo> anexos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexos);
        
    }
    
    public String parseJsonListaAnexoJudicial(java.util.List<com.doc.AnexoJudicial> anexos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexos);
        
    }
    
    public String parseJsonListaAnexoTransporte(java.util.List<com.doc.AnexoTransporte> anexos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexos);
        
    }
    
    public String parseJsonListaAnexoZoneamento(java.util.List<com.doc.AnexoZoneamento> anexos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(anexos);
        
    }
    
    public String parseJsonListaComposicaoImovel(java.util.List<com.sys.habitacional.ComposicaoImovel> composicoes) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(composicoes);
        
    }
    
    public String parseJsonListaDemolicaoImovel(java.util.List<com.sys.habitacional.DemolicaoImovel> demolicoes) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(demolicoes);
        
    }
    
    public String parseJsonListaImovel(java.util.List<com.sys.habitacional.Imovel> imoveis) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(imoveis);
        
    }
    
    public String parseJsonListaServicoImovel(java.util.List<com.sys.habitacional.ServicoImovel> servicos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(servicos);
        
    }
    
    public String parseJsonListaDeficienteIndividuo(java.util.List<com.sys.social.DeficienteIndividuo> deficientes) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(deficientes);
        
    }
    
    public String parseJsonListaDocumentoEmpresa(java.util.List<com.sys.social.DocumentoEmpresa> documentos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(documentos);
        
    }
    
    public String parseJsonListaDocumentoIndividuo(java.util.List<com.sys.social.DocumentoIndividuo> documentos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(documentos);
        
    }
    
    public String parseJsonListaEmpresa(java.util.List<com.sys.social.Empresa> empresas) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(empresas);
        
    }
    
    public String parseJsonListaEscolaridadeIndividuo(java.util.List<com.sys.social.EscolaridadeIndividuo> escolaridades) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(escolaridades);
        
    }
    
    public String parseJsonListaFamilia(java.util.List<com.sys.social.Familia> familias) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(familias);
        
    }
    
    public String parseJsonListaIndividuo(java.util.List<com.sys.social.Individuo> individuos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(individuos);
        
    }
    
    public String parseJsonListaCertidaoIndividuo(java.util.List<com.sys.social.CertidaoIndividuo> certidoes) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(certidoes);
        
    }
    
    public String parseJsonListaProfissionalIndividuo(java.util.List<com.sys.social.ProfissionalIndividuo> profissionais) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(profissionais);
        
    }
    
    public String parseJsonListaAcaoNucleo(java.util.List<com.sys.urbano.AcaoNucleo> acoes) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(acoes);
        
    }
    
    public String parseJsonListaApp(java.util.List<com.sys.urbano.App> apps) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(apps);
        
    }
    
    public String parseJsonListaAreaRisco(java.util.List<com.sys.urbano.AreaRisco> areas) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(areas);
        
    }
    
    public String parseJsonListaAspectoAmbiental(java.util.List<com.sys.urbano.AspectoAmbiental> aspectos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(aspectos);
        
    }
    
    public String parseJsonListaDesconstrucao(java.util.List<com.sys.urbano.Desconstrucao> desconstrucoes) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(desconstrucoes);
        
    }
    
    public String parseJsonListaInfraestruturaUrbana(java.util.List<com.sys.urbano.InfraestruturaUrbana> infraestruturas) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(infraestruturas);
        
    }
    
    public String parseJsonListaInstitucionalSocial(java.util.List<com.sys.urbano.InstitucionalSocial> institucionais) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(institucionais);
        
    }
    
    public String parseJsonListaNucleo(java.util.List<com.sys.urbano.Nucleo> nucleos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(nucleos);
        
    }
    
    public String parseJsonListaProgramaHabitacional(java.util.List<com.sys.urbano.ProgramaHabitacional> programas) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(programas);
        
    }
    
    public String parseJsonListaReassentamento(java.util.List<com.sys.urbano.Reassentamento> reassentamentos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(reassentamentos);
        
    }
    
    public String parseJsonListaRecursoMobilidade(java.util.List<com.sys.urbano.RecursoMobilidade> recursos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(recursos);
        
    }
    
    public String parseJsonListaRecursoSocial(java.util.List<com.sys.urbano.RecursoSocial> recursos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(recursos);
        
    }
    
    public String parseJsonListaRemanejamento(java.util.List<com.sys.urbano.Remanejamento> remanejamentos) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(remanejamentos);
        
    }
    
    public String parseJsonListaSituacaoFundiaria(java.util.List<com.sys.urbano.SituacaoFundiaria> fundiarias) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(fundiarias);
        
    }
    
    public String parseJsonListaViaPublica(java.util.List<com.sys.urbano.ViaPublica> vias) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.writeValueAsString(vias);
        
    }
    
    public com.common.Endereco parseEndereco(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.common.Endereco.class);
        
    }
    
    public com.common.EnderecoImovel parseEnderecoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.common.EnderecoImovel.class);
        
    }
    
    public com.common.Telefone parseTelefone(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.common.Telefone.class);
        
    }
    
    public com.common.TelefoneEmpresa parseTelefoneEmpresa(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.common.TelefoneEmpresa.class);
        
    }
    
    public com.common.TelefoneIndividuo parseTelefoneIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.common.TelefoneIndividuo.class);
        
    }
    
    public com.doc.Anexo parseAnexo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.doc.Anexo.class);
        
    }
    
    public com.doc.AnexoDemolicao parseAnexoDemolicao(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.doc.AnexoDemolicao.class);
        
    }
    
    public com.doc.AnexoImovel parseAnexoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.doc.AnexoImovel.class);
        
    }
    
    public com.doc.AnexoIndividuo parseAnexoIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.doc.AnexoIndividuo.class);
        
    }
    
    public com.doc.AnexoJudicial parseAnexoJudicial(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.doc.AnexoJudicial.class);
        
    }
    
    public com.doc.AnexoTransporte parseAnexoTransporte(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.doc.AnexoTransporte.class);
        
    }
    
    public com.doc.AnexoZoneamento parseAnexoZoneamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.doc.AnexoZoneamento.class);
        
    }
    
    public com.sys.habitacional.ComposicaoImovel parseComposicaoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.habitacional.ComposicaoImovel.class);
        
    }
    
    public com.sys.habitacional.DemolicaoImovel parseDemolicaoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.habitacional.DemolicaoImovel.class);
        
    }
    
    public com.sys.habitacional.Imovel parseImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.habitacional.Imovel.class);
        
    }
    
    public com.sys.habitacional.ServicoImovel parseServicoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.habitacional.ServicoImovel.class);
        
    }
    
    public com.sys.social.DeficienteIndividuo parseDeficienteIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.DeficienteIndividuo.class);
        
    }
    
    public com.sys.social.DocumentoEmpresa parseDocumentoEmpresa(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.DocumentoEmpresa.class);
        
    }
    
    public com.sys.social.DocumentoIndividuo parseDocumentoIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.DocumentoIndividuo.class);
        
    }
    
    public com.sys.social.Empresa parseEmpresa(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.Empresa.class);
        
    }
    
    public com.sys.social.EscolaridadeIndividuo parseEscolaridadeIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.EscolaridadeIndividuo.class);
        
    }
    
    public com.sys.social.Familia parseFamilia(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.Familia.class);
        
    }
    
    public com.sys.social.Individuo parseIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.Individuo.class);
        
    }
    
    public com.sys.social.CertidaoIndividuo parseCertidaoIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.CertidaoIndividuo.class);
        
    }
    
    public com.sys.social.ProfissionalIndividuo parseProfissionalIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.social.ProfissionalIndividuo.class);
        
    }
    
    public com.sys.urbano.AcaoNucleo parseAcaoNucleo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.AcaoNucleo.class);
        
    }
    
    public com.sys.urbano.App parseApp(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.App.class);
        
    }
    
    public com.sys.urbano.AreaRisco parseAreaRisco(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.AreaRisco.class);
        
    }
    
    public com.sys.urbano.AspectoAmbiental parseAspectoAmbiental(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.AspectoAmbiental.class);
        
    }
    
    public com.sys.urbano.Desconstrucao parseDesconstrucao(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.Desconstrucao.class);
        
    }
    
    public com.sys.urbano.InfraestruturaUrbana parseInfraestruturaUrbana(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.InfraestruturaUrbana.class);
        
    }
    
    public com.sys.urbano.InstitucionalSocial parseInstitucionalSocial(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.InstitucionalSocial.class);
        
    }
    
    public com.sys.urbano.Nucleo parseNucleo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager(); 
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.Nucleo.class);
        
    }
    
    public com.sys.urbano.ProgramaHabitacional parseProgramaHabitacional(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.ProgramaHabitacional.class);
        
    }
    
    public com.sys.urbano.Reassentamento parseReassentamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.Reassentamento.class);
        
    }
    
    public com.sys.urbano.RecursoMobilidade parseRecursoMobilidade(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.RecursoMobilidade.class);
        
    }
    
    public com.sys.urbano.RecursoSocial parseRecursoSocial(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.RecursoSocial.class);
        
    }
    
    public com.sys.urbano.Remanejamento parseRemanejamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.Remanejamento.class);
        
    }
    
    public com.sys.urbano.SituacaoFundiaria parseSituacaoFundiaria(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.SituacaoFundiaria.class);
        
    }
    
    public com.sys.urbano.ViaPublica parseViaPublica(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(txtMgr.removeSpecialCharacters(json), com.sys.urbano.ViaPublica.class);
        
    }
    
    public java.util.List<com.common.Endereco> parseListaEndereco(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.common.Endereco>>() {});
        
    }
    
    public java.util.List<com.common.EnderecoImovel> parseListaEnderecoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.common.EnderecoImovel>>() {});
        
    }
    
    public java.util.List<com.common.Telefone> parseListaTelefone(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.common.Telefone>>() {});
        
    }
    
    public java.util.List<com.common.TelefoneEmpresa> parseListaTelefoneEmpresa(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.common.TelefoneEmpresa>>() {});
        
    }
    
    public java.util.List<com.common.TelefoneIndividuo> parseListaTelefoneIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.common.TelefoneIndividuo>>() {});
        
    }
    
    public java.util.List<com.doc.Anexo> parseListaAnexo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.doc.Anexo>>() {});
        
    }
    
    public java.util.List<com.doc.AnexoDemolicao> parseListaAnexoDemolicao(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.doc.AnexoDemolicao>>() {});
        
    }
    
    public java.util.List<com.doc.AnexoImovel> parseListaAnexoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.doc.AnexoImovel>>() {});
        
    }
    
    public java.util.List<com.doc.AnexoIndividuo> parseListaAnexoIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.doc.AnexoIndividuo>>() {});
        
    }
    
    public java.util.List<com.doc.AnexoJudicial> parseListaAnexoJudicial(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.doc.AnexoJudicial>>() {});
        
    }
    
    public java.util.List<com.doc.AnexoTransporte> parseListaAnexoTransporte(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.doc.AnexoTransporte>>() {});
        
    }
    
    public java.util.List<com.doc.AnexoZoneamento> parseListaAnexoZoneamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.doc.AnexoZoneamento>>() {});
        
    }
    
    public java.util.List<com.sys.habitacional.ComposicaoImovel> parseListaComposicaoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.habitacional.ComposicaoImovel>>() {});
        
    }
    
    public java.util.List<com.sys.habitacional.DemolicaoImovel> parseListaDemolicaoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.habitacional.DemolicaoImovel>>() {});
        
    }
    
    public java.util.List<com.sys.habitacional.Imovel> parseListaImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.habitacional.Imovel>>() {});
        
    }
    
    public java.util.List<com.sys.habitacional.ServicoImovel> parseListaServicoImovel(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.habitacional.ServicoImovel>>() {});
        
    }
    
    public java.util.List<com.sys.social.DeficienteIndividuo> parseListaDeficienteIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.DeficienteIndividuo>>() {});
        
    }
    
    public java.util.List<com.sys.social.DocumentoEmpresa> parseListaDocumentoEmpresa(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.DocumentoEmpresa>>() {});
        
    }
    
    public java.util.List<com.sys.social.DocumentoIndividuo> parseListaDocumentoIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.DocumentoIndividuo>>() {});
        
    }
    
    public java.util.List<com.sys.social.Empresa> parseListaEmpresa(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.Empresa>>() {});
        
    }
    
    public java.util.List<com.sys.social.EscolaridadeIndividuo> parseListaEscolaridadeIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.EscolaridadeIndividuo>>() {});
        
    }
    
    public java.util.List<com.sys.social.Familia> parseListaFamilia(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.Familia>>() {});
        
    }
    
    public java.util.List<com.sys.social.Individuo> parseListaIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.Individuo>>() {});
        
    }
    
    public java.util.List<com.sys.social.CertidaoIndividuo> parseListaCertidaoIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.CertidaoIndividuo>>() {});
        
    }
    
    public java.util.List<com.sys.social.ProfissionalIndividuo> parseListaProfissionalIndividuo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.social.ProfissionalIndividuo>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.AcaoNucleo> parseListaAcaoNucleo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.AcaoNucleo>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.App> parseListaApp(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.App>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.AreaRisco> parseListaAreaRisco(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.AreaRisco>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.AspectoAmbiental> parseListaAspectoAmbiental(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.AspectoAmbiental>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.Desconstrucao> parseListaDesconstrucao(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.Desconstrucao>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.InfraestruturaUrbana> parseListaInfraestruturaUrbana(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.InfraestruturaUrbana>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.InstitucionalSocial> parseListaInstitucionalSocial(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.InstitucionalSocial>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.Nucleo> parseListaNucleo(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.Nucleo>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.ProgramaHabitacional> parseListaProgramaHabitacional(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.ProgramaHabitacional>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.Reassentamento> parseListaReassentamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.Reassentamento>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.RecursoMobilidade> parseListaRecursoMobilidade(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.RecursoMobilidade>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.RecursoSocial> parseListaRecursoSocial(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.RecursoSocial>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.Remanejamento> parseListaRemanejamento(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.Remanejamento>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.SituacaoFundiaria> parseListaSituacaoFundiaria(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.SituacaoFundiaria>>() {});
        
    }
    
    public java.util.List<com.sys.urbano.ViaPublica> parseListaViaPublica(String json) 
            throws com.fasterxml.jackson.core.JsonGenerationException, 
            com.fasterxml.jackson.databind.JsonMappingException, 
            java.io.IOException {
        
        com.data.TextManager txtMgr = new com.data.TextManager();
        json = txtMgr.removeSpecialCharacters(json);
        json = "[" + json + "]";
        
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<com.sys.urbano.ViaPublica>>() {});
        
    }
    
}
