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
import model.model_kitSaida;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_kitSaida {

    //Variaveis de conexão /statement /result set
    private Connection con = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;

    public dao_kitSaida() {
        con = connection_stock.getConnection();
    }
    //Insert 
    public void addKit(model_kitSaida kit) {
        try {
            ps = con.prepareStatement("insert into kitExit(datekit,id_pc,cod_pc,id_mon,cod_mon,cod_mouse,cod_teclado,"
                    + "id_head,cod_webcam,id_op,nome,tel,email,cargo,setor,supervisor,statuskit,qnt_en,qnt_vga)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //Dados que serão inseridos
            ps.setString(1, kit.getDatakitSaida());
            ps.setString(2, kit.getId_pc());
            ps.setString(3, kit.getCod_pc());
            ps.setString(4, kit.getId_monitor());
            ps.setString(5, kit.getCod_monitor());
            ps.setString(6, kit.getCod_mouse());
            ps.setString(7, kit.getCod_teclado());
            ps.setString(8, kit.getId_head());
            ps.setString(9, kit.getCod_webcam());
            ps.setString(10, kit.getId_operador());
            ps.setString(11, kit.getNome());
            ps.setString(12, kit.getTelefone());
            ps.setString(13, kit.getEmail());
            ps.setString(14, kit.getCargo());
            ps.setString(15, kit.getSetor());
            ps.setString(16, kit.getSupervisor());
            ps.setString(17, kit.getStatus());
            ps.setString(18, kit.getQntEnergia());
            ps.setString(19, kit.getQntVga());
            //Executa a Query
            ps.executeUpdate();
            //Sucesso
            JOptionPane.showMessageDialog(null, "Kit inserido com sucesso !");

        } catch (Exception e) {//Tratamento erro
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir os dados." + e);
        } finally {
            connection_stock.closeConnection(con, ps);//Fechar a conexao 
        }

    }
    //Selecionar tudo que está no estoque
    public List<model_kitSaida> findAll() {//Metodo Tipo lista
        String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do pc (verificando se o mesmo está no estoque )
        String sql = ("select codpc,status_pc from pc where status_pc = " + "'" + valor + "'");
        List<model_kitSaida> listPcKit = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                //pc.setIdform(rs.getString("id_formulario"));
                pc.setCod_pc(rs.getString("codpc"));
                pc.setStatus(rs.getString("status_pc"));
                listPcKit.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listPcKit;
    }
    //Pesquisar Pc Por código
    
    
    //select monitor
    //select operadora
    //select mouse
    //select teclado
    //select head
    //select webcam
    //insert cabos
    //update status
}
