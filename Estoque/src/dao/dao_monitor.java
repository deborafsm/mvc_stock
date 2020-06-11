/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.connection_stock;
import java.awt.HeadlessException;
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
            ps = con.prepareStatement("insert into monitor(cod_monitor,marca_monitor,modelo_monitor)values(?,?,?)");

            ps.setString(1, monitor.getCod());
            ps.setString(2, monitor.getMarca_monitor());
            ps.setString(3, monitor.getModelo());

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
        String sql = "select id_monitor,cod_monitor , marca_monitor, modelo_monitor from monitor";
        List<model_monitor> listMon = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_monitor monitor = new model_monitor();
                monitor.setId(rs.getString("id_monitor"));
                monitor.setCod(rs.getString("cod_monitor"));
                monitor.setMarca_monitor(rs.getString("marca_monitor"));
                monitor.setModelo(rs.getString("modelo_monitor"));
                listMon.add(monitor);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMon;
    }

        //Para Pesquisar todos os monitores
    public List<model_monitor> searchMonitor(String cod_monitor) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<model_monitor> listMon = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM monitor WHERE cod_monitor like ?");
            ps.setString(1, "%" + cod_monitor + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                model_monitor monitor = new model_monitor();
                monitor.setId(rs.getString("id_monitor"));
                monitor.setCod(rs.getString("cod_monitor"));
                monitor.setMarca_monitor(rs.getString("marca_monitor"));
                monitor.setModelo(rs.getString("modelo_monitor"));
                listMon.add(monitor);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMon;
    }
    //Deleta Monitor
     public void deleteMonitor(model_monitor monitor) {
        PreparedStatement ps = null;
        String sql = "DELETE FROM monitor WHERE id_monitor= ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, monitor.getId()); 
            ps.executeUpdate();//Executa a query
            JOptionPane.showMessageDialog(null, "Monitor removido com sucesso!"); 
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir PC" + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }
     
     //Editar Monitor
     public void updateMonitor(model_monitor monitor) {
        PreparedStatement ps = null;
        //UPDATE `estoque`.`monitor` SET `cod_monitor` = '31333' WHERE (`id_monitor` = '1');
        String sql = "UPDATE monitor SET cod_monitor= ?, marca_monitor = ?,modelo_monitor =?\n"
                + "WHERE id_monitor  = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, monitor.getCod());
            ps.setString(2, monitor.getMarca_monitor());
            ps.setString(3, monitor.getModelo());
            ps.setString(4, monitor.getId());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Monitor Alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }

}
