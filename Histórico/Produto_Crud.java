
import static java.lang.System.out;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Produto_Crud {
         public static void main(String[] args ){
        try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                out.println("Drive JDBC carregado!");
                        
                String url = "jdbc:derby://localhost:1527/projeto_prog";
                String usuario = "aluno";
                String senha = "aluno";
                java.sql.Connection conexao = DriverManager.getConnection(url,usuario, senha);
                out.println("Conexão Estabelecida com sucesso");
                
                String sqlInsert = "INSERT INTO tb_produto VALUES (id,descricao,marca,preco)";
                sqlInsert += "VALUES (?,?,?,?)";
                String sqlSelect = "SELECT * FROM tb_produto";
                String sqlUpdate = "UPDATE tb_produto SET descricao=?, marca=?, preco=?";
                sqlUpdate += "WHERE id=?";
                String sqlDelete = "DELETE FROM tb_produto WHERE id=?";
                
                PreparedStatement stmInsert = conexao.prepareStatement(sqlInsert);
                PreparedStatement stmSelect = conexao.prepareStatement(sqlSelect);
                PreparedStatement stmUpdate = conexao.prepareStatement(sqlUpdate);
                PreparedStatement stmDelete = conexao.prepareStatement(sqlDelete);
                
                boolean querSair = false;
                Scanner sc = new Scanner(System.in);
                while (!querSair) {
                    out.println("/Menu: ");
                    out.println("1) Criar produto");
                    out.println("2) Ler produto");
                    out.println("3) Atualizar produto");
                    out.println("4) Apagar produto");
                    out.println("5) Sair");
                    out.println("Opção escolhida: ");
                    int opcao = Integer.parseInt(sc.nextLine());
                    
                    if (opcao == 1) {
                        out.println("Descrição do produto: ");
                        String descricao = sc.nextLine();
                        out.println("Marca do produto: ");
                        String marca = sc.nextLine();
                        out.println("Preço do produto: ");
                        int preco = Integer.parseInt(sc.nextLine());                        
                        
                        stmInsert.setString(1,descricao);
                        stmInsert.setString(2, marca);
                        stmInsert.setInt(3, preco);                        
                        int retorno = stmInsert.executeUpdate();
                        out.println("Produto inserido: "+ retorno);                        
                    }
                    else if (opcao ==2){
                        ResultSet rs = stmSelect.executeQuery();
                        out.print("PRODUTOS");
                        while(rs.next()){
                            Long id = rs.getLong("Id");
                            String descricao = rs.getString("descricao");
                            String marca = rs.getString("marca");
                            int preco = rs.getInt("preco");                            
                            out.println(id + " - " + descricao + " - " + marca + " - " + preco);
                        }
                        rs.close();
                    } else if (opcao ==3){
                        out.println("id do produto a ser atualizado: ");
                        long id = Long.parseLong(sc.nextLine());
                        out.println("nova descrição: ");
                        String descricao = sc.nextLine();
                        out.println("nova marca: ");
                        String marca = sc.nextLine();
                        out.println("novo preço: ");
                        int preco = Integer.parseInt(sc.nextLine());
                        
                        stmUpdate.setString(1,descricao);
                        stmUpdate.setString(2,marca);
                        stmUpdate.setInt(3,preco);
                        stmUpdate.setLong(4,id);
                        int retorno = stmUpdate.executeUpdate();
                        out.println("Dados atualizados "+ retorno);
                    } else if (opcao ==4) {
                        out.println("id do produto a ser apagado: ");
                        long id = Long.parseLong(sc.nextLine());
                        
                        stmDelete.setLong(1,id);
                        int retorno = stmDelete.executeUpdate();
                        out.println("Produto apagado: " + retorno);
                    } else if (opcao ==5) {
                        querSair = true;
                    } else {
                        out.println("Opção invalida");
                    }
                                       
                } conexao.close();
                
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                out.println("Driver não encontrado");
            } catch (SQLException ex){
                ex.printStackTrace();
                out.println("Erro de conexão");
            }
        }
}

    

