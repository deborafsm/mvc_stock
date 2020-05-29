/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuário
 */
public class model_webcam {

    private String cod_webcam;
    private String marca_wc;

    public model_webcam() {
    }

    public model_webcam(String cod_webcam, String marca_wc) {
        this.cod_webcam = cod_webcam;
        this.marca_wc = marca_wc;
    }

    public String getCod_webcam() {
        return cod_webcam;
    }

    public void setCod_webcam(String cod_webcam) {
        this.cod_webcam = cod_webcam;
    }

    public String getMarca_wc() {
        return marca_wc;
    }

    public void setMarca_wc(String marca_wc) {
        this.marca_wc = marca_wc;
    }

    @Override
    public String toString() {
        return getMarca_wc();
    }

}
