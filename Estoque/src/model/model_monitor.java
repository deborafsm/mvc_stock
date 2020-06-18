/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 *@author Debora Freire T.I JobHome
 */
public class model_monitor {
    private String marca_monitor;
    private String modelo;
    private String id;
    private String cod;
    private String status_monitor;
    

    public model_monitor() {
    }

    public model_monitor(String marca_monitor, String modelo, String id, String cod) {
        this.marca_monitor = marca_monitor;
        this.modelo = modelo;
        this.id = id;
        this.cod = cod;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getStatus_monitor() {
        return status_monitor;
    }

    public void setStatus_monitor(String status_monitor) {
        this.status_monitor = status_monitor;
    }

    
    
    public String getMarca_monitor() {
        return marca_monitor;
    }

    public void setMarca_monitor(String marca_monitor) {
        this.marca_monitor = marca_monitor;
    }
   
    
    
}
