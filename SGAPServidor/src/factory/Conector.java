
package factory;

import java.sql.*; //importando as bibliotecas do jdbc

public class Conector {
     private static Connection con; //objeto que guarda a conexão com o banco. 
    //está como static para não precisar declarar um objeto de conector para usar
    
    public static Connection getConnection (){ //método que de fato faz a conexão com o banco
    //está como static para não precisar declarar um objeto de conector para usar
    
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "petshop";
            String usuario = "root";
            String senha = "";
            
            //fazendo conexão
            con = DriverManager.getConnection(url+banco, usuario, senha);
            return con;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
