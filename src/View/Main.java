/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Banco;
import Model.BancoDAO;
import static java.lang.System.out;
import java.util.List;

/**
 *
 * @author 31932835
 */
public class Main {
    public static void msin(String args[]){
        BancoDAO dao = new BancoDAO();
        List<Banco> bancos = dao.lerTodos();
        out.println(bancos.size());
        
    } /*ler o banco*/
    
}
