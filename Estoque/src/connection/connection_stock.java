/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class connection_stock {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estoque";
    private static final String USER = "root";
    private static final String PASS = "";
//Pega a conexao
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) { //Multicath para juntas as duas exceções 
            throw new RuntimeException("Erro na conexão: ", ex); //Mostra uma mensagem e a execeções 
        }
    }
//Fecha a conexao 
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                //tem alguma coisa aberta
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro" + ex);

            }
        }
    }
//Fecha a conexao e ps
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                //tem alguma coisa aberta
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro" + ex);

            }
        }
    }
//Fecha a conexao, ps e rs
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                //tem alguma coisa aberta
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro" + ex);

            }
        }
    }

}
