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
import model.model_operador;

/**
 *
 * @author jobhome
 */
public class dao_operador {

    private Connection con = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;

    public dao_operador() {
        con = connection_stock.getConnection();
    }

    //insert 
    public void addOp(model_operador op) {
        try {
            ps = con.prepareStatement("INSERT INTO operador(data_cad ,nome_operador, email_operador, tel, celular, endereco, "
                    + "cep, numero, complemento, referencia, bairro, cidade, estado, setor, cargo, status_operador,"
                    + " empresa, supervisor,cpf)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )");

            ps.setString(1, op.getDatacad());
            ps.setString(2, op.getNome_operador());
            ps.setString(3, op.getEmail());
            ps.setString(4, op.getTel());
            ps.setString(5, op.getCelular());
            ps.setString(6, op.getEnd());
            ps.setString(7, op.getCep());
            ps.setString(8, op.getNum());
            ps.setString(9, op.getComplemento());
            ps.setString(10, op.getReferencia());
            ps.setString(11, op.getBairro());
            ps.setString(12, op.getCidade());
            ps.setString(13, op.getEstado());
            ps.setString(14, op.getSetor());
            ps.setString(15, op.getCargo());
            ps.setString(16, op.getStatus());
            ps.setString(17, op.getEmpresa());
            ps.setString(18, op.getSupervisor());
            ps.setString(19, op.getCpf());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel inserir os dados." + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }

    }

    //update 
    //Update pc
    public void updateoperador(model_operador op) {
        PreparedStatement ps = null;
        String sql = "UPDATE operador SET nome_operador=?, email_operador=?, tel=?, celular=?,"
                + " endereco=?, cep=?, numero=?, complemento=?, referencia=?, bairro=?, cidade=?, estado=?, setor=?, cargo=?, "
                + "status_operador=?, empresa=?, supervisor =? WHERE id_operador =?;";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, op.getNome_operador());
            ps.setString(2, op.getEmail());
            ps.setString(3, op.getTel());
            ps.setString(4, op.getCelular());
            ps.setString(5, op.getEnd());
            ps.setString(6, op.getCep());
            ps.setString(7, op.getNum());
            ps.setString(8, op.getComplemento());
            ps.setString(9, op.getReferencia());
            ps.setString(10, op.getBairro());
            ps.setString(11, op.getCidade());
            ps.setString(12, op.getEstado());
            ps.setString(13, op.getSetor());
            ps.setString(14, op.getCargo());
            ps.setString(15, op.getStatus());
            ps.setString(16, op.getEmpresa());
            ps.setString(17, op.getSupervisor());
            ps.setString(18, op.getId_operador());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operador alterado com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);
        } finally {
            connection_stock.closeConnection(con, ps);
        }
    }

    //remove
    public void deleteOperador(model_operador op) {
        //query deleta cliente de acordo com o id
        PreparedStatement ps = null;
        String sql = "DELETE FROM operador WHERE id_operador = ?";

        try {//tenta fazer a logica abaixo
            ps = con.prepareStatement(sql);
            ps.setString(1, op.getId_operador()); //pega o codigo do pc
            ps.executeUpdate();//Executa a query
            JOptionPane.showMessageDialog(null, "Operador excluido com sucesso"); //mensagem informando sucesso
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);//mensagem informando falha e o erro causado
        } finally {
            connection_stock.closeConnection(con, ps); //fecha as conexoes utilizadas
        }
    }

    //selecionar td 
    public List<model_operador> selectOperador() {
        String sql = "Select  id_operador, nome_operador, email_operador, tel, celular, endereco, "
                + "cep, numero, complemento, referencia, bairro, cidade, estado, setor, cargo,"
                + " status_operador,"
                + " empresa, supervisor from operador";
        List<model_operador> listOp = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                model_operador op = new model_operador();
                op.setId_operador(rs.getString("id_operador"));
                op.setNome_operador(rs.getString("nome_operador"));
                op.setEmail(rs.getString("email_operador"));
                op.setTel(rs.getString("tel"));
                op.setCelular(rs.getString("celular"));
                op.setEnd(rs.getString("endereco"));
                op.setCep(rs.getString("cep"));
                op.setNum(rs.getString("numero"));
                op.setComplemento(rs.getString("complemento"));
                op.setReferencia(rs.getString("referencia"));
                op.setBairro(rs.getString("bairro"));
                op.setCidade(rs.getString("cidade"));
                op.setEstado(rs.getString("estado"));
                op.setSetor(rs.getString("setor"));
                op.setCargo(rs.getString("cargo"));
                op.setStatus(rs.getString("status_operador"));
                op.setEmpresa(rs.getString("empresa"));
                op.setSupervisor(rs.getString("supervisor"));
                listOp.add(op);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listOp;
    }

    //Prqwuisar
    public List<model_operador> findOperador(String nome) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<model_operador> listaFindOp = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM operador WHERE nome_operador like ?");
            ps.setString(1, "%" + nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                model_operador op = new model_operador();
                op.setId_operador(rs.getString("id_operador"));
                op.setNome_operador(rs.getString("nome_operador"));
                op.setEmail(rs.getString("email_operador"));
                op.setTel(rs.getString("tel"));
                op.setCelular(rs.getString("celular"));
                op.setEnd(rs.getString("endereco"));
                op.setCep(rs.getString("cep"));
                op.setNum(rs.getString("numero"));
                op.setComplemento(rs.getString("complemento"));
                op.setReferencia(rs.getString("referencia"));
                op.setBairro(rs.getString("bairro"));
                op.setCidade(rs.getString("cidade"));
                op.setEstado(rs.getString("estado"));
                op.setSetor(rs.getString("setor"));
                op.setCargo(rs.getString("cargo"));
                op.setStatus(rs.getString("status_operador"));
                op.setEmpresa(rs.getString("empresa"));
                op.setSupervisor(rs.getString("supervisor"));
                listaFindOp.add(op);
            }
        } catch (Exception e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listaFindOp;
    }
}
