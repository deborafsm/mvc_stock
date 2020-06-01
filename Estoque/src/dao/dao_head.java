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
import model.model_head;
import model.model_teclado;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_head {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public dao_head() {
        con = connection_stock.getConnection();
    }
    public void addHead(model_head head) {

        try {
            ps = con.prepareStatement("insert into head(head_marca)values(?)");
            ps.setString(1, head.getMarca_head());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Head Inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Head" + e);

        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }
    //Seleciona TODAS Marcas existentes

    public List<model_head> findAll() {
        String sql = "select head_marca from head";
        List<model_head> listHead = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_head head = new model_head();
                head.setMarca_head(rs.getString("head_marca"));

                listHead.add(head);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listHead;
    }
}

