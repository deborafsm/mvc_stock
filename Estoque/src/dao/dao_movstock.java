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
import model.model_movstock;

/**
 *
 * * @author Debora Freire T.I JobHome
 */
public class dao_movstock {

    //Variaveis de conexão /statement /result set
    private Connection con = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;

    public dao_movstock() {
        con = connection_stock.getConnection();
    }
    /*
        1 - Select All 
        2 - Contar "SAIDA" SELECT COUNT(status_kit)  FROM kit WHERE status_kit='Saida';
        3 - Contar "No Estoque" select COUNT(status_pc)  FROM pc WHERE status_pc = 'No Estoque';
        
    */ 
    
    
    
    //Select All
    public List<model_movstock> findAll() {//Metodo Tipo lista

        //Seleciona apenas o Codigo e o status do pc (verificando se o mesmo está no estoque )
        String sql = ("select id_kit,lacre,nome_operador,endereco,email,cod_pc, nome_pc,\n"
                + "marca_pc,processador,hd,memoria,so,garantia,marca_monitor,\n"
                + "marca_teclado,marca_mouse,marca_head,marca_webcam from \n"
                + "kit ");
        List<model_movstock> listmov = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_movstock mov = new model_movstock();
                mov.setId_kit(rs.getString("id_kit"));
                mov.setLacre(rs.getString("lacre"));
                mov.setNome_operador(rs.getString("nome_operador"));
                mov.setEndereco(rs.getString("endereco"));
                mov.setEmail(rs.getString("email"));
                mov.setCod_pc(rs.getString("cod_pc"));
                mov.setNome_pc(rs.getString("nome_pc"));
                mov.setMarca_pc(rs.getString("marca_pc"));
                mov.setProcessador(rs.getString("processador"));
                mov.setHd(rs.getString("hd"));
                mov.setMemoria(rs.getString("memoria"));
                mov.setSo(rs.getString("so"));
                mov.setGarantia(rs.getString("garantia"));
                mov.setMarca_monitor(rs.getString("marca_monitor"));
                mov.setMarca_teclado(rs.getString("marca_teclado"));
                mov.setMatca_mouse(rs.getString("marca_mouse"));
                mov.setMarca_head(rs.getString("marca_head"));
                mov.setMarca_webcam(rs.getString("marca_webcam"));
                listmov.add(mov);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listmov;
    }
}
