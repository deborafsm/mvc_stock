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

        String sql = "insert into defeitopc(cod_pc, datadef,nome_pc, marca, \n"
                + " modelo, so, garantia, ram, processador, hd, \n"
                + " statusd, descricao,email,nome_operador)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pcDef.getCod_pcDef());
            ps.setString(2, pcDef.getDatadef());
            ps.setString(3, pcDef.getNomePcDef());
            ps.setString(4, pcDef.getMarca_pcDef());
            ps.setString(5, pcDef.getModelo_pcDef());
            ps.setString(6, pcDef.getSo_pcDef());
            ps.setString(7, pcDef.getGarantia_pcDef());
            ps.setString(8, pcDef.getRam_pcDef());
            ps.setString(9, pcDef.getCpu_pcDef());
            ps.setString(10, pcDef.getHd_pcDef());
            ps.setString(11, pcDef.getStatus_pcDef());
            ps.setString(12, pcDef.getDescricao_pcDef());
            ps.setString(13, pcDef.getEmail());
            ps.setString(14, pcDef.getNomePcDef());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Defeito inserido com sucesso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Defeito " + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }

    //Pesquisar Operadora
    public java.util.List<model_pcDef> pesquisaOperador(String nome_operador) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.util.List<model_pcDef> pesquisarOperadora = new ArrayList<>();
        try {
            String sql =("SELECT * FROM kit WHERE nome_operador like ?");
            ps.setString(1, "%" + nome_operador + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                model_pcDef kit = new model_pcDef();
                kit.setId_kit(rs.getString("id_kit"));
                kit.setLacre(rs.getString("lacre"));
                kit.setNome_operador(rs.getString("nome_operador"));
                kit.setEmail(rs.getString("email"));
                kit.setNomePcDef(rs.getString("nome_pc"));
                kit.setCod_pcDef(rs.getString("cod_pc"));
                kit.setMarca_pcDef(rs.getString("marca_pc"));
                kit.setModelo_pcDef(rs.getString("modelo_pc"));
                kit.setCpu_pcDef(rs.getString("processador"));
                kit.setRam_pcDef(rs.getString("memoria"));
                kit.setSo_pcDef(rs.getString("so"));
                kit.setHd_pcDef(rs.getString("hd"));
                kit.setGarantia_pcDef(rs.getString("garantia"));
                pesquisarOperadora.add(kit);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar operador(a). " + e);
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return pesquisarOperadora;
    }

    //Pesquisar PC
    public java.util.List<model_pc> pesquisarPc(String cod_pc) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        java.util.List<model_pc> pesquisarPC = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM pc WHERE codpc like ?");
            ps.setString(1, "%" + cod_pc + "%");
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
                pesquisarPC.add(pc);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar o pc. " + e);
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return pesquisarPC;
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

    public void atualizaKIT(model_pc pcnv) {
        PreparedStatement ps = null;
        String sql = "UPDATE kit SET nome_pc = ?, cod_pc = ?,marca_pc = ?,modelo_pc = ?,\n"
                + "processador = ?,memoria = ?,so = ?,hd = ?,garantia = ?\n"
                + "WHERE id_kit  = ?;";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, pcnv.getNomepc());
            ps.setString(2, pcnv.getCod());
            ps.setString(3, pcnv.getMarca());
            ps.setString(4, pcnv.getModelo());
            ps.setString(5, pcnv.getProcessador());
            ps.setString(6, pcnv.getMemoria());
            ps.setString(7, pcnv.getSo());
            ps.setString(8, pcnv.getHd());
            ps.setString(9, pcnv.getGarantia());
            ps.setInt(10, pcnv.getIdform());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kit Alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Kit" + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }

    }

}
