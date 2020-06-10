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
import model.model_mouse;
import model.model_teclado;
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

    //Faz a inserção de kit no banco de dados
    public void addKit(model_kitSaida kit) {
        String sql = "INSERT INTO kit(data_kit, status_kit, id_operador, nome_operador, telefone, email, endereco, cargo, setor, supervisor, operacao,nome_pc, cod_pc, marca_pc, modelo_pc,"
                + " processador, memoria, so, hd, garantia, marca_monitor, marca_teclado, marca_mouse, marca_head, marca_webcam, qnt_vga, qnt_e, rede,lacre,id_monitor,cod_monitor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement(sql);
            //Dados que serão inseridos
            ps.setString(1, kit.getDatakitSaida());
            ps.setString(2, kit.getStatus());
            //OPERADOR
            ps.setString(3, kit.getId_operador());
            ps.setString(4, kit.getNome());
            ps.setString(5, kit.getTelefone());
            ps.setString(6, kit.getEmail());
            ps.setString(7, kit.getEndereco());
            ps.setString(8, kit.getCargo());
            ps.setString(9, kit.getSetor());
            ps.setString(10, kit.getSupervisor());
            ps.setString(11, kit.getEmpresa());
            //PC
            ps.setString(12, kit.getNomepc());
            ps.setString(13, kit.getCod_pc());
            ps.setString(14, kit.getMarca());
            ps.setString(15, kit.getModelo());
            ps.setString(16, kit.getProcessador());
            ps.setString(17, kit.getMemoria());
            ps.setString(18, kit.getSo());
            ps.setString(19, kit.getHd());
            ps.setString(20, kit.getGarantia());
            //MONITOR

            ps.setString(21, kit.getMarcamon());
            //TECLADO
            ps.setString(22, kit.getMarcateclado());
//            MOUSE
            ps.setString(23, kit.getMarcamouse());
//            HEAD
            ps.setString(24, kit.getMarca_head());
//            WEBCAM
            ps.setString(25, kit.getMarcaweccam());
//            CABOS
            ps.setString(26, kit.getQntVga());
            ps.setString(27, kit.getQntEnergia());
            ps.setString(28, kit.getRede());

//          LACRE
            ps.setString(29, kit.getLacre());

            ps.setString(30, kit.getId_monitor());
            ps.setString(31, kit.getCod_monitor());

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
        String sql = ("select nome_pc,codpc,marca_pc,modelo,processador,memoria,so,hd,garantia from pc where status_pc = " + "'" + valor + "'");
        List<model_kitSaida> listMonitorKit = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setNome(rs.getString("nome_pc"));
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

    //Seleciona todos os monitores que estão no estoque
    public List<model_kitSaida> findAllMonitor() {//Metodo Tipo lista
        String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do monitor (verificando se o mesmo está no estoque )

        String sql = ("select id_monitor,cod_monitor,marca_monitor from monitor where status_monitor = " + "'" + valor + "'");
        List<model_kitSaida> listMonitorKit = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_kitSaida pc = new model_kitSaida();
                pc.setId_monitor(rs.getString("id_monitor"));
                pc.setCod_monitor(rs.getString("cod_monitor"));
                pc.setMarcamon(rs.getString("marca_monitor"));

                listMonitorKit.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMonitorKit;
    }

    //Seleciona todos operadores que estão OK
    public List<model_kitSaida> findAllOp() {//Metodo Tipo lista
        String valor = "Ok";
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select id_operador,nome_operador,tel,email_operador,endereco,cargo,setor,supervisor,empresa from operador where status_operador = " + "'" + valor + "'");
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
                pc.setEmpresa(rs.getString("empresa"));
                listOp.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listOp;
    }

    //Seleciona marca dos mouses
    public List<model_mouse> findMouse() {//Metodo Tipo lista

        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select marca_mouse from mouse");
        List<model_mouse> listMouse = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_mouse pc = new model_mouse();

                pc.setMarca_mouse(rs.getString("marca_mouse"));
                listMouse.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listMouse;
    }

    //Seleciona todas as marcas dos teclados
    public List<model_teclado> findTeclado() {//Metodo Tipo lista
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select teclado_marca  from teclado");
        List<model_teclado> listTeclado = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_teclado pc = new model_teclado();

                pc.setMarca(rs.getString("teclado_marca"));
                listTeclado.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listTeclado;
    }

    //Seleciona as marcas dos heads
    public List<model_head> findHead() {//Metodo Tipo lista
        //String valor = "No Estoque";
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select head_marca from head");
        List<model_head> listHead = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_head pc = new model_head();
                pc.setMarca_head(rs.getString("head_marca"));
                listHead.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listHead;
    }

    //Seleciona as marcas da webcam
    public List<model_webcam> findWebCam() {//Metodo Tipo lista
        //Seleciona apenas o Codigo e o status do operador
        String sql = ("select webcam_marca from webcam ");
        List<model_webcam> listwebcam = new ArrayList<>();//Cria lista
        //Tenta fazer uma con com o bd
        try {
            //Chama a variavel com a query
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model_webcam pc = new model_webcam();
                pc.setMarca_wc(rs.getString("webcam_marca"));

                listwebcam.add(pc);
            }
        } catch (SQLException e) {
            System.out.println("Erro" + e);//Erro
        } finally {
            connection_stock.closeConnection(con, ps, rs);
        }
        return listwebcam;
    }

    //Faz a atualização do pc de "Estoque" para "Saida"
    public void updatePC(model_kitSaida kit) {//Query de atualizar cliente
        PreparedStatement ps = null;
        try {//tenta a logica abaixo
            ps = con.prepareStatement("UPDATE pc SET status_pc = ?  WHERE codpc = ? ");
            //Permissão para atualizar apenas os componentes abaixo
            ps.setString(1, kit.getStatus());
            ps.setString(2, kit.getCod_pc());
            //Executando a instrução sql
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "PC atualizado com sucesso");//Mostra a mensagem ao usuario de sucesso 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + e); //Mostra a mensagem de falha
        } finally {//Fecha as conexões
            connection_stock.closeConnection(con, ps);
        }
    }

    //Faz atualização das operadoras 
    public void updateOp(model_kitSaida kit) {//Query de atualizar cliente
        PreparedStatement ps = null;
        try {//tenta a logica abaixo
            ps = con.prepareStatement("UPDATE operador SET status_operador = ?  WHERE id_operador = ? ");
            //Permissão para atualizar apenas os componentes abaixo
            ps.setString(1, kit.getStatus());
            ps.setString(2, kit.getId_operador());
            //Executando a instrução sql
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Operador  atualizado com sucesso");//Mostra a mensagem ao usuario de sucesso 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + e); //Mostra a mensagem de falha
        } finally {//Fecha as conexões
            connection_stock.closeConnection(con, ps);
        }
    }

    //Faz a atualização do status do monitor
    public void updateMonitor(model_kitSaida kit) {//Query de atualizar cliente
        PreparedStatement ps = null;
        try {//tenta a logica abaixo
            ps = con.prepareStatement("UPDATE monitor SET status_monitor  = ?  WHERE cod_monitor = ? ");
            //Permissão para atualizar apenas os componentes abaixo
            ps.setString(1, kit.getStatus());
            ps.setString(2, kit.getCod_monitor());
            //Executando a instrução sql
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Status Monitor atualizado com sucesso");//Mostra a mensagem ao usuario de sucesso 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + e); //Mostra a mensagem de falha
        } finally {//Fecha as conexões
            connection_stock.closeConnection(con, ps);
        }
    }
 
}
