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
public class model_pc {

    private int idform;
    private int id;
    private String dataCad;
    private String nomepc;
    private String marca;
    private String modelo;
    private String cod;
    private String hd;
    private String memoria;
    private String so;
    private String processador;
    private String codPC;
    private String garantia;
    private String status;

    public model_pc() {
    }

    public model_pc(int idform, String dataCad, String nomepc, String marca, String modelo, String cod, String hd, String memoria, String so, String processador, String codPC, String garantia, String status) {
        this.idform = idform;
        this.dataCad = dataCad;
        this.nomepc = nomepc;
        this.marca = marca;
        this.modelo = modelo;
        this.cod = cod;
        this.hd = hd;
        this.memoria = memoria;
        this.so = so;
        this.processador = processador;
        this.codPC = codPC;
        this.garantia = garantia;
        this.status = status;
    }

    public model_pc(int idform, int id, String dataCad, String nomepc, String marca, String modelo, String cod, String hd, String memoria, String so, String processador, String codPC, String garantia, String status) {
        this.idform = idform;
        this.id = id;
        this.dataCad = dataCad;
        this.nomepc = nomepc;
        this.marca = marca;
        this.modelo = modelo;
        this.cod = cod;
        this.hd = hd;
        this.memoria = memoria;
        this.so = so;
        this.processador = processador;
        this.codPC = codPC;
        this.garantia = garantia;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    
    public void setIdform(int idform) {
        this.idform = idform;
    }

    public int getIdform() {
        return idform;
    }

    

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }

    public String getNomepc() {
        return nomepc;
    }

    public void setNomepc(String nomepc) {
        this.nomepc = nomepc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
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

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getCodPC() {
        return codPC;
    }

    public void setCodPC(String codPC) {
        this.codPC = codPC;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
