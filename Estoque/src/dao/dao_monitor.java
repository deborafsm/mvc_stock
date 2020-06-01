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
import model.model_monitor;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_monitor {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public dao_monitor() {
        con = connection_stock.getConnection();

    }

    public void addMonitor(model_monitor monitor) {

        try {
            ps = con.prepareStatement("insert into monitor(marca_monitor)values(?)");
            ps.setString(1, monitor.getMarca_monitor());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Monitor Inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Monitor" + e);

        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }

    //Seleciona TODAS Marcas existentes
    public List<model_monitor> findAll() {
        String sql = "select marca_monitor from monitor";
        List<model_monitor> listMon = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_monitor monitor = new model_monitor();
                monitor.setMarca_monitor(rs.getString("marca_monitor"));

                listMon.add(monitor);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMon;
    }

}


