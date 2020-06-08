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
import javax.swing.JOptionPane;
import model.model_pc;
import model.model_pcDef;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_pcDef {

    private Connection con = null;

    public dao_pcDef() {
        con = connection_stock.getConnection();
    }

    public void inserirPCDefeito(model_pcDef pcDef) {
        String sql = "insert into defeitopc(cod_pc, datadef, marca, \n"
                + " modelo, so, garantia, ram, processador, hd, \n"
                + " statusd, descricao)values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pcDef.getCod_pcDef());
            ps.setString(2, pcDef.getDatadef());
            ps.setString(3, pcDef.getMarca_pcDef());
            ps.setString(4, pcDef.getModelo_pcDef());
            ps.setString(5, pcDef.getSo_pcDef());
            ps.setString(6, pcDef.getGarantia_pcDef());
            ps.setString(7, pcDef.getRam_pcDef());
            ps.setString(8, pcDef.getCpu_pcDef());
            ps.setString(9, pcDef.getHd_pcDef());
            ps.setString(10, pcDef.getStatus_pcDef());
            ps.setString(11, pcDef.getDescricao_pcDef());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Defeito inserido com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Aluno " + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }

    //Pesquisar Operadora
    public java.util.List<model_pcDef> pesquisaOperador(String nome_operador) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        //Array lista adicionada
        java.util.List<model_pcDef> pesquisarOperadora = new ArrayList<>(); //Array de alunos
        try {   //seleciona por nome da operadora
            ps = con.prepareStatement("SELECT * FROM kit WHERE nome_operador like ?");
            ps.setString(1, "%" + nome_operador + "%");// ? = nome
            rs = ps.executeQuery(); //Result set para se obter o resultado
            while (rs.next()) {//Enquando tiver resultado (linhas)
                model_pcDef kit = new model_pcDef();
                
                kit.setId_kit(rs.getString("id_kit"));
                kit.setLacre(rs.getString("lacre"));
                kit.setNome_operador(rs.getString("nome_operador"));
                kit.setEmail(rs.getString("email"));
                kit.setNomePcDef(rs.getString("nome_pc"));
                kit.setCod_pcDef("cod_pc");
                kit.setMarca_pcDef("marca_pc");
                kit.setModelo_pcDef("modelo_pc");
                kit.setCpu_pcDef("processador");
                kit.setRam_pcDef("memoria");
                kit.setSo_pcDef("so");
                kit.setHd_pcDef("hd");
                kit.setGarantia_pcDef("garantia");
                
                pesquisarOperadora.add(kit);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar operadora. " + e);
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        //Retora o array 
        return pesquisarOperadora;
    }

    //Selecionar KIT
    public java.util.List<model_pcDef> selecionaKit() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        java.util.List<model_pcDef> selectKit = new ArrayList<>();
        try {
            ps = con.prepareStatement("select id_kit,lacre,nome_operador,email,\n"
                    + "cod_pc,nome_pc,marca_pc,modelo_pc,processador,hd,memoria,\n"
                    + "so,garantia from kit");

            rs = ps.executeQuery();

            while (rs.next()) {
                model_pcDef kit = new model_pcDef();
                kit.setId_kit(rs.getString("id_kit"));
                kit.setLacre(rs.getString("lacre"));
                kit.setNome_operador(rs.getString("nome_operador"));
                kit.setEmail(rs.getString("email"));
                kit.setCod_pcDef(rs.getString("cod_pc"));
                kit.setNomePcDef(rs.getString("nome_pc"));
                kit.setMarca_pcDef(rs.getString("marca_pc"));
                kit.setModelo_pcDef(rs.getString("modelo_pc"));
                kit.setCpu_pcDef(rs.getString("processador"));
                kit.setHd_pcDef(rs.getString("hd"));
                kit.setRam_pcDef(rs.getString("memoria"));
                kit.setSo_pcDef(rs.getString("so"));
                kit.setGarantia_pcDef(rs.getString("garantia"));
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

    public java.util.List<model_pc> selectPC() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String valor = "No Estoque";
        String sql = ("select nome_pc,codpc,marca_pc,modelo,processador,memoria,so,"
                + "hd,garantia from pc where status_pc = " + "'" + valor + "'");
        java.util.List<model_pc> selectPC = new ArrayList<>();
        try {
             ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_pc pc = new model_pc();
                pc.setNomepc(rs.getString("nome_pc"));
                pc.setCodPC(rs.getString("codpc"));
                pc.setMarca(rs.getString("marca_pc"));
                pc.setModelo(rs.getString("modelo"));
                pc.setProcessador(rs.getString("processador"));
                pc.setMemoria(rs.getString("memoria"));
                pc.setSo(rs.getString("so"));
                pc.setHd(rs.getString("hd"));
                pc.setGarantia(rs.getString("garantia"));
                selectPC.add(pc);
            }
        } catch (Exception e) {
            System.out.println("Erro ao mostrar PC. " + e);
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        //Retora o array 
        return selectPC;
    }

    public void updateStud(model_pcDef nome_operador) {
        PreparedStatement ps = null;
        String sql = "UPDATE kit\n"
                + "SET lacre = ?,nome_operador = ?,email  = ?,\n"
                + "cod_pc = ?,nome_pc = ?,marca_pc = ?,modelo_pc = ?,\n"
                + "processador = ?,hd = ?,memoria = ?,\n"
                + "so = ?,garantia = ?\n"
                + "WHERE id_kit  = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nome_operador.getLacre());
            ps.setString(2, nome_operador.getNome_operador());
            ps.setString(3, nome_operador.getEmail());
            ps.setString(4, nome_operador.getCod_pcDef());
            ps.setString(5, nome_operador.getNomePcDef());
            ps.setString(6, nome_operador.getMarca_pcDef());
            ps.setString(7, nome_operador.getModelo_pcDef());
            ps.setString(8, nome_operador.getSo_pcDef());
            ps.setString(9, nome_operador.getHd_pcDef());
            ps.setString(10, nome_operador.getRam_pcDef());
            ps.setString(11, nome_operador.getSo_pcDef());
            ps.setString(12, nome_operador.getGarantia_pcDef());

            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Kit Alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Kit" + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }

    }

}
