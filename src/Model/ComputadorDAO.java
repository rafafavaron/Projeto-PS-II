/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Computador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAO {
	private PreparedStatement stmInsert;
    private PreparedStatement stmSelect;
    private PreparedStatement stmUpdate;
    private PreparedStatement stmDelete;
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ComputadorDAO(BancoDAO conexao){
    	
    	try {
            Connection conn = conexao.getConexao();
            
            String sqlInsert = "INSERT INTO tb_computador VALUES (id,marca,processador,qtd_ram, tam_disco)";
            sqlInsert += "VALUES (?,?,?,?,?)";
            String sqlSelect = "SELECT * FROM tb_computador";
            String sqlUpdate = "UPDATE tb_computador SET marca=?, processador=?, qtd_ram=?,tam_disco=? ";
            sqlUpdate += "WHERE id=?";
            String sqlDelete = "DELETE FROM tb_computador WHERE id=?";
            
            this.stmInsert = conn.prepareStatement(sqlInsert);
            this.stmSelect = conn.prepareStatement(sqlSelect);
            this.stmUpdate = conn.prepareStatement(sqlUpdate);
            this.stmDelete = conn.prepareStatement(sqlDelete);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Computador> lerTodos() {
        try{
            ResultSet rs = this.stmSelect.executeQuery();
            List<Computador> computador = new ArrayList<>();
            
            while(rs.next()) {
            	Computador aux = new Computador();
                aux.setId(rs.getInt("id"));
                aux.setMarca(rs.getString("marca"));
                aux.setProcessador(rs.getString("processador"));
                aux.setQtd_ram(rs.getInt("qtd_ram"));
                aux.setTam_disco(rs.getInt("tam_disco"));
                computador.add(aux);
            }
            return computador;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Computador criar(Computador p) {
        try{
        	this.stmInsert.setInt(1, p.getId());
            this.stmInsert.setString(2, p.getMarca());
            this.stmInsert.setString(3, p.getProcessador());
            this.stmInsert.setInt(4, p.getQtd_ram());
            this.stmInsert.setInt(5, p.getTam_disco());
            
            
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
    
    public boolean atualizar(Computador p) {
        try{
            this.stmUpdate.setString(1, p.getMarca());
            this.stmUpdate.setString(2, p.getProcessador());
            this.stmUpdate.setInt(3, p.getQtd_ram());
            this.stmUpdate.setInt(4, p.getTam_disco());
            this.stmUpdate.setLong(5, p.getId());
            
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
