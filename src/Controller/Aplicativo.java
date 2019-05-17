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
public class Aplicativo {
    
    private int id;
    private String nome;
    private String desenvolvedor;
    private int nr_downloads;
    
     public Aplicativo() {}
     
     public Aplicativo(int id, String nome, String desenvolvedor, int nr_downloads){
        this.id = id;
        this.nome = nome;
        this.desenvolvedor = desenvolvedor;
        this.nr_downloads = nr_downloads;
    
      }

    
     
     /*Get*/
     public int getId(){ return id; }     
     public String getNome() { return nome;}     
     public String getDesenvolvedor(){return desenvolvedor;}     
     public int getNr_Downloads(){return nr_downloads;}
     
     /*set*/
     public void setId(int id){ this.id = id; }
     public void setNome(String nome){this.nome = nome;}
     public void setDesenvolvedor(String desenvolvedor){this.desenvolvedor = desenvolvedor;}
     public void setNr_Downloads(int nr_downloads){this.nr_downloads = nr_downloads;}
     
     @Override
     public String toString() {
        return "Aplicativo: " 
                + this.id + " - " 
                + this.nome + " - " 
                + this.desenvolvedor + " (" 
                + this.nr_downloads + ")";
    }
         
}
