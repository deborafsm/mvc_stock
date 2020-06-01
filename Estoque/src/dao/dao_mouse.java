/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.connection_stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.model_mouse;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_mouse {
    //Add Mouse
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public dao_mouse() {
        con = connection_stock.getConnection();
    }
     public void addMouse(model_mouse mouse) {

        try {
            ps = con.prepareStatement("insert into mouse(marca_mouse)values(?)");
            ps.setString(1, mouse.getMarca_mouse());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mouse Inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Mouse" + e);

        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }
     
     //Seleciona TODAS Marcas existentes
    public List<model_mouse> findAll() {
        String sql = "select marca_mouse from mouse";
        List<model_mouse> listMouse = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_mouse mouse = new model_mouse();
                mouse.setMarca_mouse(rs.getString("marca_mouse"));

                listMouse.add(mouse);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMouse;
    }
}
