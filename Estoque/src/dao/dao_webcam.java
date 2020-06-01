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
import model.model_webcam;

/**
 *
 * @author Usuário
 */
public class dao_webcam {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public dao_webcam() {
        con = connection_stock.getConnection();
    }
    public void addwc(model_webcam webcam) {

        try {
            ps = con.prepareStatement("insert into webcam(webcam_marca)values(?)");
            ps.setString(1, webcam.getMarca_wc());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "webcam Inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir webcam" + e);

        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }
    
    
    
    
    
     //Seleciona TODAS Marcas existentes
    public List<model_webcam> findAll() {
        String sql = "select webcam_marca from webcam";
        List<model_webcam> listwc = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_webcam web = new model_webcam();
                web.setMarca_wc(rs.getString("webcam_marca"));

                listwc.add(web);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listwc;
    }
}
