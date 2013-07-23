/*
 * Classe pertencente à API "libkernel" que é utilizada no projeto CadUnico. 
 * A API cadkernel é o conjunto padrão de todas as classes e pacotes que 
 * constituem a estrutura principal do sistema CadUnico.
 */
package com.sys.habitacional;

/**
 *
 * @author William Oliveira
 * 
 * @version 1.0
 */
public class ServicoImovel {
    
    private String type;
    private long id;
    private String existePavimentacao;
    private String qualPavimentacao;
    private String iluminacaoUtilizada;
    private String especifiqueIluminacao;
    private String abastecimentoAgua;
    private String tratamentoAgua;
    private String aguaEncanada;
    private String existeBanheiro;
    private String escoamentoSanitario;
    private String tratamentoLixo;
    private String presencaAnimais;
    private Imovel imovel;
    
    public ServicoImovel() {
        this.type = "servicoimovel";
        this.id = 0l;
        this.existePavimentacao = "";
        this.qualPavimentacao = "";
        this.iluminacaoUtilizada = "";
        this.especifiqueIluminacao = "";
        this.abastecimentoAgua = "";
        this.tratamentoAgua = "";
        this.aguaEncanada = "";
        this.existeBanheiro = "";
        this.escoamentoSanitario = "";
        this.tratamentoLixo = "";
        this.presencaAnimais = "";
        this.imovel = null;
    }
    
    public ServicoImovel(Imovel imovel) {
        this.type = "servicoimovel";
        this.id = 0l;
        this.existePavimentacao = "";
        this.qualPavimentacao = "";
        this.iluminacaoUtilizada = "";
        this.especifiqueIluminacao = "";
        this.abastecimentoAgua = "";
        this.tratamentoAgua = "";
        this.aguaEncanada = "";
        this.existeBanheiro = "";
        this.escoamentoSanitario = "";
        this.tratamentoLixo = "";
        this.presencaAnimais = "";
        this.imovel = imovel;
    }
    
    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExistePavimentacao() {
        return existePavimentacao;
    }

    public void setExistePavimentacao(String existePavimentacao) {
        this.existePavimentacao = existePavimentacao;
    }
    
    public String getQualPavimentacao() {
        return qualPavimentacao;
    }

    public void setQualPavimentacao(String qualPavimentacao) {
        this.qualPavimentacao = qualPavimentacao;
    }

    public String getIluminacaoUtilizada() {
        return iluminacaoUtilizada;
    }

    public void setIluminacaoUtilizada(String iluminacaoUtilizada) {
        this.iluminacaoUtilizada = iluminacaoUtilizada;
    }
    
    public String getEspecifiqueIluminacao() {
        return especifiqueIluminacao;
    }

    public void setEspecifiqueIluminacao(String especifiqueIluminacao) {
        this.especifiqueIluminacao = especifiqueIluminacao;
    }

    public String getAbastecimentoAgua() {
        return abastecimentoAgua;
    }

    public void setAbastecimentoAgua(String abastecimentoAgua) {
        this.abastecimentoAgua = abastecimentoAgua;
    }

    public String getTratamentoAgua() {
        return tratamentoAgua;
    }

    public void setTratamentoAgua(String tratamentoAgua) {
        this.tratamentoAgua = tratamentoAgua;
    }

    public String getAguaEncanada() {
        return aguaEncanada;
    }

    public void setAguaEncanada(String aguaEncanada) {
        this.aguaEncanada = aguaEncanada;
    }

    public String getExisteBanheiro() {
        return existeBanheiro;
    }

    public void setExisteBanheiro(String existeBanheiro) {
        this.existeBanheiro = existeBanheiro;
    }

    public String getEscoamentoSanitario() {
        return escoamentoSanitario;
    }

    public void setEscoamentoSanitario(String escoamentoSanitario) {
        this.escoamentoSanitario = escoamentoSanitario;
    }

    public String getTratamentoLixo() {
        return tratamentoLixo;
    }

    public void setTratamentoLixo(String tratamentoLixo) {
        this.tratamentoLixo = tratamentoLixo;
    }

    public String getPresencaAnimais() {
        return presencaAnimais;
    }

    public void setPresencaAnimais(String presencaAnimais) {
        this.presencaAnimais = presencaAnimais;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
    
}
