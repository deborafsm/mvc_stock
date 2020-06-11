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
import javax.swing.JOptionPane;
import model.model_operador;

/**
 *
 * @author Debora Freire T.I JobHome
 */
public class dao_operador {
    private Connection con = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;
    public dao_operador() {
        con = connection_stock.getConnection();
    }
    
    //insert 
    public void addPc(model_operador op) {
        try {
            ps = con.prepareStatement("INSERT INTO operador(`id_operador`, `nome_operador`,"
                    + " `email_operador`, `tel`, `celular`, `endereco`, `cep`, "
                    + "`numero`, `complemento`, `referencia`, `bairro`, `cidade`, "
                    + "`estado`, `setor`, `cargo`, `status_operador`, `empresa`, "
                    + "`supervisor`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, op.getNome_operador());
            ps.setString(2,op.getEmail());
            ps.setString(3,op.getTel());
            ps.setString(4, op.getCelular());
            ps.setString(5,op.getEnd());
            ps.setString(6, op.getCep());
            ps.setString(7,op.getNum());
            ps.setString(8,op.getComplemento());
            ps.setString(8,op.getReferencia());
            ps.setString(9,op.getBairro());
            ps.setString(10,op.getCidade());
            ps.setString(11,op.getEstado());
            ps.setString(12,op.getSetor());
            ps.setString(13,op.getCargo());
            ps.setString(14,op.getStatus());
            ps.setString(15,op.getEmpresa());
            ps.setString(16,op.getSupervisor());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso !");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir os dados." + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }

    }
    //update
    //delete
    //select 
    //find

    
    
}
