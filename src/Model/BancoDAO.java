/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31932835
 */
public class BancoDAO {
    
    private PreparedStatement stmt;
    private Connection conexao;
    String url = "jdbc:derby://localhost:1527/projeto_prog";
    String usuario = "aluno";
    String senha = "aluno";
    
    public BancoDAO()
    {}
    
    public Connection getConexao() {
        if (conexao != null)
            return conexao;

        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            out.println("Drive JDBC carregado!");
            java.sql.Connection conexao = DriverManager.getConnection(url,usuario, senha);
            out.println("Conexão Estabelecida com sucesso");
           
       } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                out.println("Driver não encontrado");
            } catch (SQLException ex){
                ex.printStackTrace();
                out.println("Erro de conexão");
            }
        return conexao;
        }
    
    public void close() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
            conexao = null;
        }
  }

}
