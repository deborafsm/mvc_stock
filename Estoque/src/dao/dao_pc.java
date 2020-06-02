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
import model.model_pc;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_pc {

    private Connection con = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;

    public dao_pc() {
        con = connection_stock.getConnection();

    }

    //Adicionar PC 
    public void addPc(model_pc pc) {
        try {
            ps = con.prepareStatement("insert into pc(datacad,codpc,nome_pc,processador,marca_pc,hd,memoria,so,garantia,status_pc,modelo)values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pc.getDataCad());
            ps.setString(2, pc.getCod());
            ps.setString(3, pc.getNomepc()); //OP
            ps.setString(4, pc.getProcessador());
            ps.setString(5, pc.getMarca());
            ps.setString(6, pc.getHd());
            ps.setString(7, pc.getMemoria());
            ps.setString(8, pc.getSo());
            ps.setString(9, pc.getGarantia());
            ps.setString(10, pc.getStatus());
            ps.setString(11, pc.getModelo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir os dados." + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }

    }

    //Selecionar tudo 
    public List<model_pc> findAll() {
        String sql = "select id_formulario,datacad,codpc,nome_pc,processador,marca_pc,hd ,memoria ,so,garantia,status_pc,modelo from pc";
        List<model_pc> listPc = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                model_pc pc = new model_pc();
                pc.setIdform(rs.getInt("id_formulario"));
                pc.setDataCad(rs.getString("datacad"));
                pc.setCod(rs.getString("codpc"));
                pc.setNomepc(rs.getString("nome_pc"));
                pc.setProcessador(rs.getString("processador"));
                pc.setMarca(rs.getString("marca_pc"));
                pc.setHd(rs.getString("hd"));
                pc.setMemoria(rs.getString("memoria"));
                pc.setSo(rs.getString("so"));
                pc.setGarantia(rs.getString("garantia"));
                pc.setModelo(rs.getString("modelo"));
                pc.setStatus(rs.getString("status_pc"));

                listPc.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listPc;
    }

    //Pesquisa pc
    public java.util.List<model_pc> findPC(String status_pc) {
        java.util.List<model_pc> findPC = new ArrayList<>(); //Array de pcs
        try {   //seleciona por nome do pc 
            ps = con.prepareStatement("SELECT * FROM pc WHERE status_pc like ?"); //Seleciona tdo de pcs
            ps.setString(1, "%" + status_pc + "%");// ? = nome
            rs = ps.executeQuery(); //Result set para se obter o resultado
            while (rs.next()) {//Enquando tiver resultado (linhas)
                model_pc pc = new model_pc();
                //Lista os componentes
                pc.setIdform(rs.getInt("id_formulario"));
                pc.setDataCad(rs.getString("datacad"));
                pc.setCod(rs.getString("codpc"));
                pc.setNomepc(rs.getString("nome_pc"));
                pc.setProcessador(rs.getString("processador"));
                pc.setMarca(rs.getString("marca_pc"));
                pc.setHd(rs.getString("hd"));
                pc.setMemoria(rs.getString("memoria"));
                pc.setSo(rs.getString("so"));
                pc.setGarantia(rs.getString("garantia"));
                pc.setModelo(rs.getString("modelo"));
                pc.setStatus(rs.getString("status_pc"));
                //E adiciona no array list
                findPC.add(pc);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar pc. " + e);//Mostra o erro da logica, ja que só mostra algum resultado
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        //Retora o array 
        return findPC;
    }

    public void deletPc(model_pc pc) {
        //query deleta cliente de acordo com o id
        String sql = "DELETE FROM pc WHERE id_formulario = ?";
        PreparedStatement ps = null;
        try {//tenta fazer a logica abaixo
            ps = con.prepareStatement(sql);
            ps.setInt(1, pc.getIdform()); //pega o codigo do pc
            ps.executeUpdate();//Executa a query
            JOptionPane.showMessageDialog(null, "PC Excluido com sucesso"); //mensagem informando sucesso
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir PC" + e);//mensagem informando falha e o erro causado
        } finally {
            connection_stock.closeConnection(con, ps); //fecha as conexoes utilizadas
        }
    }

}
