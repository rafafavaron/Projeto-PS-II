/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Aplicativo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AplicativoDAO {
    private PreparedStatement stmInsert;
    private PreparedStatement stmSelect;
    private PreparedStatement stmUpdate;
    private PreparedStatement stmDelete;
    
    @SuppressWarnings("CallToPrintStackTrace")
    public AplicativoDAO(BancoDAO conexao) {
        try {
            Connection conn = conexao.getConexao();
            
            String sqlInsert = "INSERT INTO tb_aplicativo VALUES (id,nome,desenvolvedor,nr_downloads)";
            sqlInsert += "VALUES (?,?,?,?)";
            String sqlSelect = "SELECT * FROM tb_aplicativo";
            String sqlUpdate = "UPDATE tb_aplicativo SET nome=?, desenvolvedor=?, nr_downloads=?";
            sqlUpdate += "WHERE id=?";
            String sqlDelete = "DELETE FROM tb_aplicativo WHERE id=?";
            
            this.stmInsert = conn.prepareStatement(sqlInsert);
            this.stmSelect = conn.prepareStatement(sqlSelect);
            this.stmUpdate = conn.prepareStatement(sqlUpdate);
            this.stmDelete = conn.prepareStatement(sqlDelete);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Aplicativo> lerTodos() {
        try{
            ResultSet rs = this.stmSelect.executeQuery();
            List<Aplicativo> aplicativo = new ArrayList<>();
            
            while(rs.next()) {
                Aplicativo aux = new Aplicativo();
                aux.setId(rs.getInt("id"));
                aux.setNome(rs.getString("nome"));
                aux.setDesenvolvedor(rs.getString("desenvolvedor"));
                aux.setNr_Downloads(rs.getInt("nr_downloads"));
                aplicativo.add(aux);
            }
            return aplicativo;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Aplicativo criar(Aplicativo p) {
        try{
            this.stmInsert.setString(1, p.getNome());
            this.stmInsert.setString(2, p.getDesenvolvedor());
            this.stmInsert.setInt(3, p.getNr_Downloads());
            
            
            this.stmInsert.executeUpdate();
            ResultSet rs = this.stmInsert.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                p.setId(id);
                return p;
            } 
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean atualizar(Aplicativo p) {
        try{
            this.stmUpdate.setString(1, p.getNome());
            this.stmUpdate.setString(2, p.getDesenvolvedor());
            this.stmUpdate.setInt(3, p.getNr_Downloads());
            this.stmUpdate.setLong(4, p.getId());
            
            return this.stmUpdate.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public boolean apagar(long id) {
        try{
            this.stmDelete.setLong(1, id);
            return this.stmDelete.executeUpdate() > 0;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

