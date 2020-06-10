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
import model.model_monitorDef;
import model.model_pcDef;

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
               
                kit.setCod_monitor(rs.getString("cod_monitor"));
                kit.setMarca_monior(rs.getString("marca_monitor"));
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
}
