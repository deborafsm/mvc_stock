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
import model.model_mouse;
import model.model_teclado;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_teclado {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public dao_teclado() {
        con = connection_stock.getConnection();
    }

    public void addTeclado(model_teclado teclado) {

        try {
            ps = con.prepareStatement("insert into teclado(teclado_marca)values(?)");
            ps.setString(1, teclado.getMarca());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "teclado Inserido com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir teclado" + e);

        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }
//Seleciona TODAS Marcas existentes

    public List<model_teclado> findAll() {
        String sql = "select teclado_marca from teclado";
        List<model_teclado> listTeclado = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_teclado teclado = new model_teclado();
                teclado.setMarca(rs.getString("teclado_marca"));

                listTeclado.add(teclado);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listTeclado;
    }
}
