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
public class model_movstock {
    /*select id_kit,lacre,nome_operador,endereco,email,cod_pc,
marca_pc,processador,hd,memoria,so,garantia,marca_monitor,
marca_teclado,marca_mouse,marca_head,marca_webcam from 
kit;*/
    private String id_kit;
    private String lacre;
    private String nome_operador;
    private String endereco;
    private String email;
    private String cod_pc;
    private String nome_pc;
    private String marca_pc;
    private String processador;
    private String hd;
    private String memoria;
    private String so;
    private String garantia;
    private String marca_monitor;
    private String marca_teclado;
    private String marca_mouse;
    private String marca_head;
    private String marca_webcam;
    

    public model_movstock() {
    }

    public model_movstock(String id_kit, String lacre, String nome_operador, String endereco, String email, String cod_pc, String nome_pc, String marca_pc, String processador, String hd, String memoria, String so, String garantia, String marca_monitor, String marca_teclado, String marca_mouse, String marca_head, String marca_webcam) {
        this.id_kit = id_kit;
        this.lacre = lacre;
        this.nome_operador = nome_operador;
        this.endereco = endereco;
        this.email = email;
        this.cod_pc = cod_pc;
        this.nome_pc = nome_pc;
        this.marca_pc = marca_pc;
        this.processador = processador;
        this.hd = hd;
        this.memoria = memoria;
        this.so = so;
        this.garantia = garantia;
        this.marca_monitor = marca_monitor;
        this.marca_teclado = marca_teclado;
        this.marca_mouse = marca_mouse;
        this.marca_head = marca_head;
        this.marca_webcam = marca_webcam;
    }

    public String getNome_pc() {
        return nome_pc;
    }

    public void setNome_pc(String nome_pc) {
        this.nome_pc = nome_pc;
    }

    public String getMarca_mouse() {
        return marca_mouse;
    }

    public void setMarca_mouse(String marca_mouse) {
        this.marca_mouse = marca_mouse;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCod_pc() {
        return cod_pc;
    }

    public void setCod_pc(String cod_pc) {
        this.cod_pc = cod_pc;
    }

    public String getMarca_pc() {
        return marca_pc;
    }

    public void setMarca_pc(String marca_pc) {
        this.marca_pc = marca_pc;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getMarca_monitor() {
        return marca_monitor;
    }

    public void setMarca_monitor(String marca_monitor) {
        this.marca_monitor = marca_monitor;
    }

    public String getMarca_teclado() {
        return marca_teclado;
    }

    public void setMarca_teclado(String marca_teclado) {
        this.marca_teclado = marca_teclado;
    }

    public String getMatca_mouse() {
        return marca_mouse;
    }

    public void setMatca_mouse(String marca_mouse) {
        this.marca_mouse = marca_mouse;
    }

    public String getMarca_head() {
        return marca_head;
    }

    public void setMarca_head(String marca_head) {
        this.marca_head = marca_head;
    }

    public String getMarca_webcam() {
        return marca_webcam;
    }

    public void setMarca_webcam(String marca_webcam) {
        this.marca_webcam = marca_webcam;
    }
    

}
