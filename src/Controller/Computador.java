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
public class Computador {
    private int id;
    private String marca;
    private String processador;
    private int qtd_ram;
    private int tam_disco;
    

    	public Computador() {}
    
        public Computador(int id, String marca, String processador, int qtd_ram, int tam_disco){
        this.id = id;
        this.marca = marca;
        this.processador = processador;
        this.qtd_ram = qtd_ram;
        this.tam_disco = tam_disco;
    }
    
        public int getId(){ return id; }     
        public String getMarca() { return marca;}     
        public String getProcessador(){return processador;}     
        public int getQtd_ram(){return qtd_ram;}
        public int getTam_disco(){return tam_disco;}
        
        /*set*/
        public void setId(int id){ this.id = id; }
        public void setMarca(String marca){this.marca = marca;}
        public void setProcessador(String processador){this.processador = processador;}
        public void setQtd_ram(int qtd_ram){this.qtd_ram = qtd_ram;}
        public void setTam_disco(int tam_disco){this.tam_disco = tam_disco;}
        
        @Override
        public String toString() {
           return "Computador: " 
                   + this.id + " - " 
                   + this.marca + " - " 
                   + this.processador + "- " 
                   + this.qtd_ram + "-"
            	   + this.tam_disco + ")";
       }
}
