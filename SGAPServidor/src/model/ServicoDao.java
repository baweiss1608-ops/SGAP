package model;

import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Servico;

/*
CRUD
C - CREATE (insert)
R - RETRIEVE (select)
U - UPDATE
D - DELETE
*/

public class ServicoDao {
   private Connection con;
    
    public ServicoDao(){
        con = Conector.getConnection(); //estabelecendo conexão com o banco
    }
    
    public ArrayList<Servico> getLista(){
        //CONSULTAR A TABELA DE SERVIÇO NO BANCO DE DADOS, VAMOS RODAR O SCRIPT "SELECT* FROM SERVIÇO" 
        ArrayList<Servico> lista = new ArrayList<Servico>(); //lista de serviços
        try {
            String sql = "select * from servico";
            PreparedStatement stmt = con.prepareStatement(sql); //preparando a string sql para ser executada
            ResultSet res = stmt.executeQuery(); //executa o script preparado
            while(res.next()){ //percorre o resultado
                Servico s = new Servico(res.getInt("codservico"), //cria os servicos
                                        res.getString("descricao"),
                                        res.getFloat("preco"));
                System.out.println(s);
                lista.add(s); //adicionando o serviço na listagem
            }
            
            //fechando conexões
            res.close();
            stmt.close();
            con.close();
            
            return lista;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
    
    public boolean inserir(Servico s){
        try {
            String sql = "insert into servico (descricao, preco) values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            //trocar os parametros
            stmt.setString(1, s.getDescricao() );
            stmt.setFloat(2, s.getPreco());
            //executar o script
            stmt.execute();
            
            
            //fechar tudo
            stmt.close();
            con.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean editar(Servico s){
        try {
            String sql = "update servico set descricao = ?, preco = ? where codservico = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            //trocar os parametros
            stmt.setString(1, s.getDescricao() );
            stmt.setFloat(2, s.getPreco());
            stmt.setInt(3, s.getCodServico());
            //executar o script
            stmt.execute();
            
            
            //fechar tudo
            stmt.close();
            con.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean excluir(Servico s){
        try {
            String sql = "delete from servico where codservico = ?"; //script para deletar um serviço
            PreparedStatement stmt = con.prepareStatement(sql);
            //trocar os parametros
            stmt.setInt(1, s.getCodServico());
            //executar o script
            stmt.execute();
                      
            //fechar tudo
            stmt.close();
            con.close();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
}
