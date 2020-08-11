/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.dao_operador;
import javax.swing.JOptionPane;
import model.model_operador;

/**
 *
 * @author jobhome
 */
public class controler_cadOperador {

    dao_operador dao;

    public controler_cadOperador() {
        dao = new dao_operador();
    }
    public boolean verificaDados(model_operador operador){
        if (operador.getNome_operador().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o nome do aluno");
            return false;
        }
        dao.addOp(operador);
        return true;
    }
}
