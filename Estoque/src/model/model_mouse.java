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
public class model_mouse {
    private String marca_mouse;

    public model_mouse() {
    }

    public model_mouse(String marca_mouse) {
        this.marca_mouse = marca_mouse;
    }

    public String getMarca_mouse() {
        return marca_mouse;
    }

    public void setMarca_mouse(String marca_mouse) {
        this.marca_mouse = marca_mouse;
    }

    @Override
    public String toString() {
        return getMarca_mouse();
    }
    
    
    
    
}
