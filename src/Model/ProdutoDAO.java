/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Computador;
import Controller.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
	private PreparedStatement stmInsert;
    private PreparedStatement stmSelect;
    private PreparedStatement stmUpdate;
    private PreparedStatement stmDelete;
    
    @SuppressWarnings("CallToPrintStackTrace")
    public ProdutoDAO(BancoDAO conexao){
    	try {
            Connection conn = conexao.getConexao();
            
            String sqlInsert = "INSERT INTO tb_produto VALUES (id,descricao,marca,preco)";
            sqlInsert += "VALUES (?,?,?,?)";
            String sqlSelect = "SELECT * FROM tb_produto";
            String sqlUpdate = "UPDATE tb_produto SET descricao=?, marca=?, preco=? ";
            sqlUpdate += "WHERE id=?";
            String sqlDelete = "DELETE FROM tb_produto WHERE id=?";
            
            this.stmInsert = conn.prepareStatement(sqlInsert);
            this.stmSelect = conn.prepareStatement(sqlSelect);
            this.stmUpdate = conn.prepareStatement(sqlUpdate);
            this.stmDelete = conn.prepareStatement(sqlDelete);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Produto> lerTodos() {
        try{
            ResultSet rs = this.stmSelect.executeQuery();
            List<Produto> produto = new ArrayList<>();
            
            while(rs.next()) {
            	Produto aux = new Produto();
                aux.setId(rs.getInt("id"));
                aux.setDescricao(rs.getString("descricao"));
                aux.setMarca(rs.getString("marca"));
                aux.setPreco(rs.getFloat("preco"));
                produto.add(aux);
            }
            return produto;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Produto criar(Produto p) {
        try{
        	this.stmInsert.setInt(1, p.getId());
            this.stmInsert.setString(2, p.getMarca());
            this.stmInsert.setString(3, p.getDescricao());
            this.stmInsert.setFloat(4, p.getPreco());
            
            
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
    
    public boolean atualizar(Produto p) {
        try{
            this.stmUpdate.setString(1, p.getMarca());
            this.stmUpdate.setString(2, p.getDescricao());
            this.stmUpdate.setFloat(3, p.getPreco());
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
