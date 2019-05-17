/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author 31932835
 */
public class Produto {
    
    private int id;
    private String descricao;
    private String marca;
    private float preco;
   
    	public Produto(){}
    
        public Produto(int id, String descricao, String marca, float preco){
        this.setId(id);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setPreco(preco);
    }
        
        /*Get*/
		public int getId() {return id;}
		public String getDescricao() {return descricao;	}
		public float getPreco() {return preco;}
		public String getMarca() {return marca;}
		
		/*set*/
		public void setId(int id) {this.id = id;}		
		public void setDescricao(String descricao) {this.descricao = descricao;}
		public void setPreco(float preco) {this.preco = preco;}		
		public void setMarca(String marca) {this.marca = marca;}
    
		@Override
        public String toString() {
           return "Produto: " 
                   + this.id + " - " 
                   + this.descricao + " - " 
                   + this.marca + "- " 
                   + this.preco;
       }
}
