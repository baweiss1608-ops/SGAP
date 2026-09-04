
package model;

import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Paciente;

/*
CRUD
C - CREATE (insert)
R - RETRIEVE (select)
U - UPDATE
D - DELETE

DAO = Data Access Object
É a classe responsável por acessar o banco de dados.
*/

public class PacienteDao {
    private Connection con; // guarda a conexão com o banco

    // Construtor
    public PacienteDao() {
        con = Conector.getConnection(); // estabelece a conexão com o banco
    }

    // Método para listar todos os pacientes
    public ArrayList<Paciente> getLista() {

        ArrayList<Paciente> lista = new ArrayList<>();

        try {

            // Busca todos os pacientes no banco
            String sql = "select * from pacientes order by id_paciente";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Executa o SELECT
            ResultSet res = stmt.executeQuery();

            // Percorre os pacientes encontrados
            while (res.next()) {

                Paciente p = new Paciente(
                        res.getInt("id_paciente"),
                        res.getString("nome"),
                        res.getString("contato"),
                        res.getString("cpf"),
                        res.getString("contato_emergencia"),
                        res.getString("email"),
                        res.getString("senha")
                );

                System.out.println(p);

                lista.add(p);
            }

            // Fecha as conexões
            res.close();
            stmt.close();
            con.close();

            return lista;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // Método para fazer login do paciente
    public Paciente login(Paciente paciente) {

        Paciente pacienteLogado = null;

        try {

            // Procura o paciente pelo email e senha
            String sql = "select * from pacientes "
                    + "where email = ? and senha = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Troca as interrogações pelos dados do login
            stmt.setString(1, paciente.getEmail());
            stmt.setString(2, paciente.getSenha());

            // Executa o SELECT
            ResultSet res = stmt.executeQuery();

            // Se encontrou o paciente
            if (res.next()) {

                pacienteLogado = new Paciente(
                        res.getInt("id_paciente"),
                        res.getString("nome"),
                        res.getString("contato"),
                        res.getString("cpf"),
                        res.getString("contato_emergencia"),
                        res.getString("email"),
                        res.getString("senha")
                );

                System.out.println(pacienteLogado);
            }

            // Fecha as conexões
            res.close();
            stmt.close();
            con.close();

            return pacienteLogado;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // Método para inserir um novo paciente
    public boolean inserir(Paciente p) {

        try {

            // Script para cadastrar um paciente
            String sql = "insert into pacientes "
                    + "(cpf, contato, contato_emergencia, nome, email, senha) "
                    + "values (?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Troca as interrogações pelos dados do paciente
            stmt.setString(1, p.getCpf());
            stmt.setString(2, p.getContato());
            stmt.setString(3, p.getContatoEmergencia());
            stmt.setString(4, p.getNome());
            stmt.setString(5, p.getEmail());
            stmt.setString(6, p.getSenha());

            // Executa o INSERT
            stmt.execute();

            // Fecha a conexão
            stmt.close();
            con.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // Método para editar os dados do paciente
    public boolean editar(Paciente p) {

        try {

            // Script para atualizar o paciente
            String sql = "update pacientes set "
                    + "cpf = ?, "
                    + "contato = ?, "
                    + "contato_emergencia = ?, "
                    + "nome = ?, "
                    + "email = ?, "
                    + "senha = ? "
                    + "where id_paciente = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Troca as interrogações pelos novos dados
            stmt.setString(1, p.getCpf());
            stmt.setString(2, p.getContato());
            stmt.setString(3, p.getContatoEmergencia());
            stmt.setString(4, p.getNome());
            stmt.setString(5, p.getEmail());
            stmt.setString(6, p.getSenha());
            stmt.setInt(7, p.getCodPaciente());

            // Executa o UPDATE
            stmt.execute();

            // Fecha a conexão
            stmt.close();
            con.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    // Método para excluir um paciente
    public boolean excluir(Paciente p) {

        try {

            // Script para deletar um paciente
            String sql = "delete from pacientes where id_paciente = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Informa qual paciente será excluído
            stmt.setInt(1, p.getCodPaciente());

            // Executa o DELETE
            stmt.execute();

            // Fecha a conexão
            stmt.close();
            con.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
