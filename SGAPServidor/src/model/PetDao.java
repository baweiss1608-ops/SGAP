
package model;

import java.sql.*;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Cliente;
import modelDominio.Pet;
import modelDominio.Servico;
import modelDominio.Usuario;

/*
CRUD
C - CREATE (insert)
R - RETRIEVE (select)
U - UPDATE
D - DELETE
 */

public class PetDao {
    private Connection con; //atributo q guarda a conexão com o banco (feita na factory)

    public PetDao() { //método construtor
        con = Conector.getConnection(); //Estabele a conexão com o banco         
    }

    public ArrayList<Pet> getLista() {
        ArrayList<Pet> lista = new ArrayList<>();
        try {
            String sql = "select * from pet"
                    + " join usuario on (usuario.codusuario = pet.coddono)"
                    + " order by pet.codpet ";
            PreparedStatement stmt = con.prepareStatement(sql);  //preparando a string sql para ser executada
            ResultSet res = stmt.executeQuery(); //executa o script preparado
            while (res.next()) { //pdrcorre o resultadp
                Usuario user = null;
                if (res.getInt("tipo") == 0) {
                    //administrador
                    user = new Administrador(res.getInt("codusuario"),
                            res.getString("nomeusuario"),
                            res.getString("email"),
                            res.getString("senha"));
                } else {
                    //cliente
                    user = new Cliente(res.getInt("codusuario"),
                            res.getString("nomeusuario"),
                            res.getString("email"),
                            res.getString("senha"));
                }
                Pet pet = new Pet(res.getInt("codpet"),
                        res.getString("nomepet"),
                        res.getString("especie"),
                        res.getString("raca"),
                        user,
                        res.getBytes("foto"));
                System.out.println(pet);
                lista.add(pet);
            }
            res.close();
            stmt.close();
            con.close();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean inserir(Pet p) {
        try {
            String sql = "insert into pet (nomepet, especie, raca, foto, coddono) values (?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            //trocar os parametros
            stmt.setString(1, p.getNomePet());
            stmt.setString(2, p.getEspecie());
            stmt.setString(3, p.getRaca());
            stmt.setBytes(4, p.getFoto());
            stmt.setInt(5, p.getDono().getCodUsuario());
            
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

    public boolean editar(Pet p) {
        try {
            String sql = "update pet set nomepet = ?, especie=?, raca=?, foto=?, coddono=? where codpet = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            //trocar os parametros
            stmt.setString(1, p.getNomePet());
            stmt.setString(2, p.getEspecie());
            stmt.setString(3, p.getRaca());
            stmt.setBytes(4, p.getFoto());            
            stmt.setInt(5, p.getDono().getCodUsuario());
            stmt.setInt(6, p.getCodPet());
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

    public boolean excluir(Pet p) {
        try {
            String sql = "delete from pet where codpet = ?"; //script para deletar um serviço
            PreparedStatement stmt = con.prepareStatement(sql);
            //trocar os parametros
            stmt.setInt(1, p.getCodPet());
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
