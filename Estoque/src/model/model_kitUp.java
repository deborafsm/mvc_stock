/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class model_kitUp {
    //Vai para tabela PC Defeito
    private String nomePcDef;
    private String cod_pcDef;
    private String marca_pcDef;
    private String modelo_pcDef;
    private String so_pcDef;
    private String garantia_pcDef;
    private String ram_pcDef;
    private String cpu_pcDef;
    private String hd_pcDef;
    private String status_pcDef;
    private String descricao_pcDef;
    //Vai para tabela monitor
    private String id_monitorDef;
    private String marca_monitorDef;
    private String codigo_monitorDef;

    public model_kitUp() {
    }

    public model_kitUp(String nomePcDef, String cod_pcDef, String marca_pcDef, String modelo_pcDef, String so_pcDef, String garantia_pcDef, String ram_pcDef, String cpu_pcDef, String hd_pcDef, String status_pcDef, String descricao_pcDef, String id_monitorDef, String marca_monitorDef, String codigo_monitorDef) {
        this.nomePcDef = nomePcDef;
        this.cod_pcDef = cod_pcDef;
        this.marca_pcDef = marca_pcDef;
        this.modelo_pcDef = modelo_pcDef;
        this.so_pcDef = so_pcDef;
        this.garantia_pcDef = garantia_pcDef;
        this.ram_pcDef = ram_pcDef;
        this.cpu_pcDef = cpu_pcDef;
        this.hd_pcDef = hd_pcDef;
        this.status_pcDef = status_pcDef;
        this.descricao_pcDef = descricao_pcDef;
        this.id_monitorDef = id_monitorDef;
        this.marca_monitorDef = marca_monitorDef;
        this.codigo_monitorDef = codigo_monitorDef;
    }

    public String getNomePcDef() {
        return nomePcDef;
    }

    public void setNomePcDef(String nomePcDef) {
        this.nomePcDef = nomePcDef;
    }

    public String getCod_pcDef() {
        return cod_pcDef;
    }

    public void setCod_pcDef(String cod_pcDef) {
        this.cod_pcDef = cod_pcDef;
    }

    public String getMarca_pcDef() {
        return marca_pcDef;
    }

    public void setMarca_pcDef(String marca_pcDef) {
        this.marca_pcDef = marca_pcDef;
    }

    public String getModelo_pcDef() {
        return modelo_pcDef;
    }

    public void setModelo_pcDef(String modelo_pcDef) {
        this.modelo_pcDef = modelo_pcDef;
    }

    public String getSo_pcDef() {
        return so_pcDef;
    }

    public void setSo_pcDef(String so_pcDef) {
        this.so_pcDef = so_pcDef;
    }

    public String getGarantia_pcDef() {
        return garantia_pcDef;
    }

    public void setGarantia_pcDef(String garantia_pcDef) {
        this.garantia_pcDef = garantia_pcDef;
    }

    public String getRam_pcDef() {
        return ram_pcDef;
    }

    public void setRam_pcDef(String ram_pcDef) {
        this.ram_pcDef = ram_pcDef;
    }

    public String getCpu_pcDef() {
        return cpu_pcDef;
    }

    public void setCpu_pcDef(String cpu_pcDef) {
        this.cpu_pcDef = cpu_pcDef;
    }

    public String getHd_pcDef() {
        return hd_pcDef;
    }

    public void setHd_pcDef(String hd_pcDef) {
        this.hd_pcDef = hd_pcDef;
    }

    public String getStatus_pcDef() {
        return status_pcDef;
    }

    public void setStatus_pcDef(String status_pcDef) {
        this.status_pcDef = status_pcDef;
    }

    public String getDescricao_pcDef() {
        return descricao_pcDef;
    }

    public void setDescricao_pcDef(String descricao_pcDef) {
        this.descricao_pcDef = descricao_pcDef;
    }

    public String getId_monitorDef() {
        return id_monitorDef;
    }

    public void setId_monitorDef(String id_monitorDef) {
        this.id_monitorDef = id_monitorDef;
    }

    public String getMarca_monitorDef() {
        return marca_monitorDef;
    }

    public void setMarca_monitorDef(String marca_monitorDef) {
        this.marca_monitorDef = marca_monitorDef;
    }

    public String getCodigo_monitorDef() {
        return codigo_monitorDef;
    }

    public void setCodigo_monitorDef(String codigo_monitorDef) {
        this.codigo_monitorDef = codigo_monitorDef;
    }
    
    
    
}
