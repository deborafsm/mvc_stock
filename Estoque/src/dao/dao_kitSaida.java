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
import model.model_head;
import model.model_kitSaida;
import model.model_webcam;

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
        String sql = ("select id_formulario,codpc,marca_pc,modelo,processador,memoria,so,hd,garantia from pc where status_pc = " + "'" + valor + "'");
        List<model_kitSaida> listMonitorKit = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setId_pc(rs.getString("id_formulario"));
                pc.setCod_pc(rs.getString("codpc"));
                pc.setMarca(rs.getString("marca_pc"));
                pc.setModelo(rs.getString("modelo"));
                pc.setProcessador(rs.getString("processador"));
                pc.setMemoria(rs.getString("memoria"));
                pc.setSo(rs.getString("so"));
                pc.setHd(rs.getString("hd"));
                pc.setGarantia(rs.getString("garantia"));

                listMonitorKit.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMonitorKit;
    }
    //Pesquisar Pc Por código

    //select monitor
    public List<model_kitSaida> findAllMonitor() {//Metodo Tipo lista
        String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do monitor (verificando se o mesmo está no estoque )

        String sql = ("select id_marca,cod_monitor,marca_monitor, modelo from monitor where status_monitor = " + "'" + valor + "'");
        List<model_kitSaida> listMonitorKit = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setId_monitor(rs.getString("id_marca"));
                pc.setCod_monitor(rs.getString("cod_monitor"));
                pc.setMarcamon(rs.getString("marca_monitor"));
                pc.setModelmon(rs.getString("modelo"));
                listMonitorKit.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMonitorKit;
    }
    //select operadora
    public List<model_kitSaida> findAllOp() {//Metodo Tipo lista
        String valor = "Ok";
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select id_operador,nome_operador,tel,email_operador,endereco,cargo,setor,supervisor from operador where status_operador = " + "'" + valor + "'");
        List<model_kitSaida> listOp = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setId_operador(rs.getString("id_operador"));
                pc.setNome(rs.getString("nome_operador"));
                pc.setTelefone(rs.getString("tel"));
                pc.setEmail(rs.getString("email_operador"));
                pc.setEndereco(rs.getString("endereco"));
                pc.setCargo(rs.getString("cargo"));
                pc.setSetor(rs.getString("setor"));
                pc.setSupervisor(rs.getString("supervisor"));
                listOp.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listOp;
    }
    //select mouse
       public List<model_kitSaida> findMouse() {//Metodo Tipo lista
        String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select cod_mouse ,marca_mouse from mouse where status_envio_mouse = " + "'" + valor + "'");
        List<model_kitSaida> listMouse = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setCod_mouse(rs.getString("cod_mouse"));
                pc.setMarcamouse(rs.getString("marca_mouse"));
                listMouse.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMouse;
    }
    //select teclado
       public List<model_kitSaida> findTeclado() {//Metodo Tipo lista
        String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select teclado_cod, teclado_marca from teclado where status_envio_teclado = " + "'" + valor + "'");
        List<model_kitSaida> listTeclado = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setCod_teclado(rs.getString("teclado_cod"));
                pc.setMarcateclado(rs.getString("teclado_marca"));
                listTeclado.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listTeclado;
    }
    //select head
        public List<model_head> findHead() {//Metodo Tipo lista
        String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select head_cod from head where status_envio_head = " + "'" + valor + "'");
        List<model_head> listHead = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_head pc = new model_head();
                pc.setCod_head(rs.getString("head_cod"));
                listHead.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listHead;
    }
    //select webcam
       public List<model_kitSaida> findWebCam() {//Metodo Tipo lista
        String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select webcam_cod from webcam where status_envio_webcam = " + "'" + valor + "'");
        List<model_kitSaida> listwebcam = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setCod_webcam(rs.getString("webcam_cod"));
                
                listwebcam.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listwebcam;
    }
    //insert cabos
    //update status
}
