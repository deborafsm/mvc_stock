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
public class model_head {
    private String cod_head;
    private String marca_head;

    public model_head(String cod_head, String marca_head) {
        this.cod_head = cod_head;
        this.marca_head = marca_head;
    }

    

    public String getCod_head() {
        return cod_head;
    }

    public void setCod_head(String cod_head) {
        this.cod_head = cod_head;
    }

    public model_head() {
    }

    public String getMarca_head() {
        return marca_head;
    }

    public void setMarca_head(String marca_head) {
        this.marca_head = marca_head;
    }

    @Override
    public String toString() {
        return getMarca_head();
    }
    
}
