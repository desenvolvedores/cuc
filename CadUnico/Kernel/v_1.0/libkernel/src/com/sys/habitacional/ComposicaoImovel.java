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
public class ComposicaoImovel {
    
    private String type;
    private long id;
    private String materialParede;
    private String especifiqueParede;
    private String materialPiso;
    private String especifiquePiso;
    private String materialCobertura;
    private String especifiqueCobertura;
    private int numeroComodos;
    private int numeroSalas;
    private int numeroCozinhas;
    private int numeroQuartos;
    private int numeroBanheiros;
    private int numeroAreasServicos;
    private int numeroAnexos;
    private int numeroOutrosComodos;
    private int numeroServemDormitorio;
    private Imovel imovel;
    
    public ComposicaoImovel() {
        this.type = "composicaoimovel";
        this.id = 0l;
        this.materialParede = "";
        this.especifiqueParede = "";
        this.materialPiso = "";
        this.especifiquePiso = "";
        this.materialCobertura = "";
        this.especifiqueCobertura = "";
        this.numeroComodos = 0;
        this.numeroSalas = 0;
        this.numeroCozinhas = 0;
        this.numeroQuartos = 0;
        this.numeroBanheiros = 0;
        this.numeroAreasServicos = 0;
        this.numeroAnexos = 0;
        this.numeroOutrosComodos = 0;
        this.numeroServemDormitorio = 0;
        this.imovel = null;
    }
    
    public ComposicaoImovel(Imovel imovel) {
        this.type = "composicaoimovel";
        this.id = 0l;
        this.materialParede = "";
        this.especifiqueParede = "";
        this.materialPiso = "";
        this.especifiquePiso = "";
        this.materialCobertura = "";
        this.especifiqueCobertura = "";
        this.numeroComodos = 0;
        this.numeroSalas = 0;
        this.numeroCozinhas = 0;
        this.numeroQuartos = 0;
        this.numeroBanheiros = 0;
        this.numeroAreasServicos = 0;
        this.numeroAnexos = 0;
        this.numeroOutrosComodos = 0;
        this.numeroServemDormitorio = 0;
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

    public String getMaterialParede() {
        return materialParede;
    }

    public void setMaterialParede(String materialParede) {
        this.materialParede = materialParede;
    }

    public String getEspecifiqueParede() {
        return especifiqueParede;
    }

    public void setEspecifiqueParede(String especifiqueParede) {
        this.especifiqueParede = especifiqueParede;
    }

    public String getMaterialPiso() {
        return materialPiso;
    }

    public void setMaterialPiso(String materialPiso) {
        this.materialPiso = materialPiso;
    }

    public String getEspecifiquePiso() {
        return especifiquePiso;
    }

    public void setEspecifiquePiso(String especifiquePiso) {
        this.especifiquePiso = especifiquePiso;
    }

    public String getMaterialCobertura() {
        return materialCobertura;
    }

    public void setMaterialCobertura(String materialCobertura) {
        this.materialCobertura = materialCobertura;
    }

    public String getEspecifiqueCobertura() {
        return especifiqueCobertura;
    }

    public void setEspecifiqueCobertura(String especifiqueCobertura) {
        this.especifiqueCobertura = especifiqueCobertura;
    }

    public int getNumeroComodos() {
        return numeroComodos;
    }

    public void setNumeroComodos(int numeroComodos) {
        this.numeroComodos = numeroComodos;
    }

    public int getNumeroSalas() {
        return numeroSalas;
    }

    public void setNumeroSalas(int numeroSalas) {
        this.numeroSalas = numeroSalas;
    }

    public int getNumeroCozinhas() {
        return numeroCozinhas;
    }

    public void setNumeroCozinhas(int numeroCozinhas) {
        this.numeroCozinhas = numeroCozinhas;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public int getNumeroBanheiros() {
        return numeroBanheiros;
    }

    public void setNumeroBanheiros(int numeroBanheiros) {
        this.numeroBanheiros = numeroBanheiros;
    }

    public int getNumeroAreasServicos() {
        return numeroAreasServicos;
    }

    public void setNumeroAreasServicos(int numeroAreasServicos) {
        this.numeroAreasServicos = numeroAreasServicos;
    }

    public int getNumeroAnexos() {
        return numeroAnexos;
    }

    public void setNumeroAnexos(int numeroAnexos) {
        this.numeroAnexos = numeroAnexos;
    }

    public int getNumeroOutrosComodos() {
        return numeroOutrosComodos;
    }

    public void setNumeroOutrosComodos(int numeroOutrosComodos) {
        this.numeroOutrosComodos = numeroOutrosComodos;
    }

    public int getNumeroServemDormitorio() {
        return numeroServemDormitorio;
    }

    public void setNumeroServemDormitorio(int numeroServemDormitorio) {
        this.numeroServemDormitorio = numeroServemDormitorio;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
    
}
