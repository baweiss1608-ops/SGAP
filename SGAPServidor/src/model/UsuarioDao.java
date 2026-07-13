
package model;

import java.util.ArrayList;
import factory.Conector;
import java.sql.*;
import modelDominio.Administrador;
import modelDominio.Cliente;
import modelDominio.Usuario;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//DAO = Data Acess Object
//Classe responsável por acessar os dados e transformar em objetos

public class UsuarioDao {
     private Connection con; //atributo q guarda a conexão com o banco (feita na factory)

    public UsuarioDao() { //método construtor
        con = Conector.getConnection(); //Estabele a conexão com o banco       
    }

    public Usuario login(Usuario user) {   //método para fazer login (vai consultar no banco paa ver se o usuário existe)
        Usuario userLogado = null; //usuário selecionado do banco de dados

        try {
            String sql = "select * from usuario where email = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql); //preparando o script sql para trocar os parametros (interrogações)
            stmt.setString(1, user.getEmail()); //trocar parametros
            stmt.setString(2, user.getSenha()); //trocar parametros

            ResultSet res = stmt.executeQuery(); //executar o script //todo o resultado do select será guardado na variável res

            if (res.next()) {
                //o usuário existe e foi conectado
                //se não existe, não entra nesse if
                if (res.getInt("tipo") == 0) { //"tipo" é o nome do campo dentro do sql
                    // é um administrador
                    userLogado = new Administrador(res.getInt("codusuario"),
                            res.getString("nomeusuario"),
                            res.getString("email"),
                            res.getString("senha"));
                } else {
                    // é um cliente
                    userLogado = new Cliente(res.getInt("codusuario"),
                            res.getString("nomeusuario"),
                            res.getString("email"),
                            res.getString("senha"));
                }

                System.out.println(userLogado); //fazendo um print do objeto
            }
            //fechando conexões
            res.close();
            stmt.close();
            con.close();
            return userLogado; //devolvendo o usuario que foi encontrado

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario> getLista() {
        Usuario userLogado = null;
        ArrayList<Usuario> lista = new ArrayList<>();
       try {
        String sql = "select * from usuario";
        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet res = stmt.executeQuery();

        while (res.next()) {
            Usuario user;

            if (res.getInt("tipo") == 0) {
                user = new Administrador(
                        res.getInt("codusuario"),
                        res.getString("nomeusuario"),
                        res.getString("email"),
                        res.getString("senha"));
            } else {
                user = new Cliente(
                        res.getInt("codusuario"),
                        res.getString("nomeusuario"),
                        res.getString("email"),
                        res.getString("senha"));
            }

            lista.add(user);
        }

        res.close();
        stmt.close();

        return lista;

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

            
            public boolean inserir(Usuario u) {
    try {
        String sql = "insert into usuario (nomeusuario, email, senha, tipo) values (?, ?, ?, 1)";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, u.getNomeUsuario());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());

        stmt.execute();
        stmt.close();

        return true;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}
