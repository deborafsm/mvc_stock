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
    private String marca_monior;
    private String id_kit;
    private String lacre;
    private String nome_operador;
    private String email;

    public model_monitorDef() {
    }

    public model_monitorDef(String id_monitor, String cod_monitor, String marca_monior, String id_kit, String lacre, String nome_operador, String email) {
        this.id_monitor = id_monitor;
        this.cod_monitor = cod_monitor;
        this.marca_monior = marca_monior;
        this.id_kit = id_kit;
        this.lacre = lacre;
        this.nome_operador = nome_operador;
        this.email = email;
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

    public String getMarca_monior() {
        return marca_monior;
    }

    public void setMarca_monior(String marca_monior) {
        this.marca_monior = marca_monior;
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

}
