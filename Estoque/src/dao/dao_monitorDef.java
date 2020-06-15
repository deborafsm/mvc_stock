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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.model_kitSaida;
import model.model_monitorDef;

/**
 *
 * @author jobhome
 */
public class dao_monitorDef {

    private Connection con = null;

    public dao_monitorDef() {
        con = connection_stock.getConnection();
    }

    //Selecionar KIT
    public java.util.List<model_monitorDef> selecionaKit() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        java.util.List<model_monitorDef> selectKit = new ArrayList<>();
        try {
            ps = con.prepareStatement("select id_kit,lacre,nome_operador,email,\n"
                    + "id_monitor,cod_monitor,marca_monitor from kit");

            rs = ps.executeQuery();

            while (rs.next()) {
                model_monitorDef kit = new model_monitorDef();
                kit.setId_kit(rs.getString("id_kit"));
                kit.setLacre(rs.getString("lacre"));
                kit.setNome_operador(rs.getString("nome_operador"));
                kit.setEmail(rs.getString("email"));
                kit.setId_monitor(rs.getString("id_monitor"));
                kit.setCod_monitor(rs.getString("cod_monitor"));
                kit.setMarca_monitor(rs.getString("marca_monitor"));
                selectKit.add(kit);
            }
        } catch (Exception e) {
            System.out.println("Erro ao mostrar KIT. " + e);
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        //Retora o array 
        return selectKit;
    }

    public void addMonitorDef(model_monitorDef monitor) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement("insert into monitordef(cod_monitor,data_defeito ,marca_monitor, descricao, statusm, nome, email)values(?,?,?,?,?,?,?)");

            ps.setString(1, monitor.getCod_monitor());
            ps.setString(2, monitor.getData());
            ps.setString(3, monitor.getMarca_monitor());
            ps.setString(4, monitor.getDescricao());
            ps.setString(5, monitor.getStatus());
            ps.setString(6, monitor.getNome_operador());
            ps.setString(7, monitor.getEmail());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir defeito de monitor:" + e);

        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }
    //Atualiza Monitor

    public void atualizaMonKIT(model_monitorDef mondef) {
        PreparedStatement ps = null;
        String sql = "UPDATE kit SET id_monitor =?,marca_monitor =?,cod_monitor =? WHERE id_kit  =?;";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, mondef.getId_monitor());
            ps.setString(2, mondef.getMarca_monitor());
            ps.setString(3, mondef.getCod_monitor());
            ps.setString(4, mondef.getId_kit());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kit Alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Kit" + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }

    public void updateMonitor(model_kitSaida kit) {//Query de atualizar cliente
        PreparedStatement ps = null;
        try {//tenta a logica abaixo
            ps = con.prepareStatement("UPDATE monitor SET status_monitor = ?  WHERE cod_monitor = ? ");
            //Permissão para atualizar apenas os componentes abaixo
            ps.setString(1, kit.getStatus());
            ps.setString(2, kit.getCod_monitor());
            //Executando a instrução sql
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Monitor atualizado com sucesso");//Mostra a mensagem ao usuario de sucesso 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Monitor" + e); //Mostra a mensagem de falha
        } finally {//Fecha as conexões
            connection_stock.closeConnection(con, ps);
        }
    }

    //Pesquisar KIT
    public List<model_monitorDef> findOperador(String nome_operador) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<model_monitorDef> findOp = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM kit WHERE nome_operador like ?");//  ps = con.prepareStatement
            ps.setString(1, "%" + nome_operador + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                model_monitorDef kit = new model_monitorDef();

                kit.setId_kit(rs.getString("id_kit"));
                kit.setLacre(rs.getString("lacre"));
                kit.setNome_operador(rs.getString("nome_operador"));
                kit.setEmail(rs.getString("email"));
                kit.setId_monitor(rs.getString("id_monitor"));
                kit.setCod_monitor(rs.getString("cod_monitor"));
                kit.setMarca_monitor(rs.getString("marca_monitor"));
                findOp.add(kit);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar operador(a) " + e);
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        //Retora o array 
        return findOp;
    }
    //Pesquisar Monitor
    public List<model_monitorDef> findMonitor(String cod_monitor) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<model_monitorDef> findMon = new ArrayList<>();
        try {
            String m = "No Estoque";
            ps = con.prepareStatement("SELECT * FROM monitor WHERE cod_monitor like ?");//  ps = con.prepareStatement
            ps.setString(1, "%" + cod_monitor + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                model_monitorDef kit = new model_monitorDef();
                kit.setId_monitor(rs.getString("id_monitor"));
                kit.setCod_monitor(rs.getString("cod_monitor"));
                kit.setMarca_monitor(rs.getString("marca_monitor"));
                findMon.add(kit);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar operador(a) " + e);
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        //Retora o array 
        return findMon;
    }

}
