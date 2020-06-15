/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jobhome
 */
public class model_monitorDef {

    private String id_monitor;
    private String cod_monitor;
    private String marca_monitor;
    private String status;
    private String descricao;
    private String id_kit;
    private String lacre;
    private String nome_operador;
    private String email;
    private String data;

    public model_monitorDef() {
    }

    public model_monitorDef(String id_monitor, String cod_monitor, String marca_monitor, String status, String descricao, String id_kit, String lacre, String nome_operador, String email, String data) {
        this.id_monitor = id_monitor;
        this.cod_monitor = cod_monitor;
        this.marca_monitor = marca_monitor;
        this.status = status;
        this.descricao = descricao;
        this.id_kit = id_kit;
        this.lacre = lacre;
        this.nome_operador = nome_operador;
        this.email = email;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

  
   

    public String getId_monitor() {
        return id_monitor;
    }

    public void setId_monitor(String id_monitor) {
        this.id_monitor = id_monitor;
    }

    public String getCod_monitor() {
        return cod_monitor;
    }

    public void setCod_monitor(String cod_monitor) {
        this.cod_monitor = cod_monitor;
    }

    
    public String getId_kit() {
        return id_kit;
    }

    public void setId_kit(String id_kit) {
        this.id_kit = id_kit;
    }

    public String getLacre() {
        return lacre;
    }

    public void setLacre(String lacre) {
        this.lacre = lacre;
    }

    public String getNome_operador() {
        return nome_operador;
    }

    public void setNome_operador(String nome_operador) {
        this.nome_operador = nome_operador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarca_monitor() {
        return marca_monitor;
    }

    public void setMarca_monitor(String marca_monitor) {
        this.marca_monitor = marca_monitor;
    }

  
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
