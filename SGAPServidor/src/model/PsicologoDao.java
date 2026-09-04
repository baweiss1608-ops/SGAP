
package model;
import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Psicologo;

/*
CRUD
C - CREATE (insert)
R - RETRIEVE (select)
U - UPDATE
D - DELETE

DAO = Data Access Object
É a classe responsável por acessar o banco de dados.
*/
public class PsicologoDao {
     private Connection con; // guarda a conexão com o banco

    // Construtor
    public PsicologoDao() {
        con = Conector.getConnection(); // estabelece a conexão com o banco
    }

    // Método para listar todos os psicólogos
    public ArrayList<Psicologo> getLista() {

        ArrayList<Psicologo> lista = new ArrayList<>();

        try {

            // Busca todos os psicólogos no banco
            String sql = "select * from psicologos order by id_psicologo";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Executa o SELECT
            ResultSet res = stmt.executeQuery();

            // Percorre os psicólogos encontrados
            while (res.next()) {

                Psicologo p = new Psicologo(
                        res.getInt("id_psicologo"),
                        res.getString("crp"),
                        res.getString("nome"),
                        res.getString("contato"),
                        res.getString("cnpj"),
                        res.getString("email"),
                        res.getString("senha"),
                        res.getString("especialidade"),
                        res.getTime("horario_inicial"),
                        res.getTime("horario_final"),
                        res.getFloat("valor_cobrado")
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

    // Método para fazer login do psicólogo
    public Psicologo login(Psicologo psicologo) {

        Psicologo psicologoLogado = null;

        try {

            // Procura o psicólogo pelo email e senha
            String sql = "select * from psicologos "
                    + "where email = ? and senha = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Troca as interrogações pelos dados do login
            stmt.setString(1, psicologo.getEmail());
            stmt.setString(2, psicologo.getSenha());

            // Executa o SELECT
            ResultSet res = stmt.executeQuery();

            // Se encontrou o psicólogo
            if (res.next()) {

                psicologoLogado = new Psicologo(
                        res.getInt("id_psicologo"),
                        res.getString("crp"),
                        res.getString("nome"),
                        res.getString("contato"),
                        res.getString("cnpj"),
                        res.getString("email"),
                        res.getString("senha"),
                        res.getString("especialidade"),
                        res.getTime("horario_inicial"),
                        res.getTime("horario_final"),
                        res.getFloat("valor_cobrado")
                );

                System.out.println(psicologoLogado);
            }

            // Fecha as conexões
            res.close();
            stmt.close();
            con.close();

            return psicologoLogado;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // Método para inserir um novo psicólogo
    public boolean inserir(Psicologo p) {

        try {

            // Script para cadastrar um psicólogo
            String sql = "insert into psicologos "
                    + "(crp, cnpj, especialidade, contato, horario_inicial, "
                    + "horario_final, valor_cobrado, nome, email, senha) "
                    + "values (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Troca as interrogações pelos dados do psicólogo
            stmt.setString(1, p.getCrp());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getEspecialidade());
            stmt.setString(4, p.getContato());
            stmt.setTime(5, p.getHorarioInicial());
            stmt.setTime(6, p.getHorarioFinal());
            stmt.setFloat(7, p.getValor());
            stmt.setString(8, p.getNome());
            stmt.setString(9, p.getEmail());
            stmt.setString(10, p.getSenha());

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

    // Método para editar os dados do psicólogo
    public boolean editar(Psicologo p) {

        try {

            // Script para atualizar o psicólogo
            String sql = "update psicologos set "
                    + "crp = ?, "
                    + "cnpj = ?, "
                    + "especialidade = ?, "
                    + "contato = ?, "
                    + "horario_inicial = ?, "
                    + "horario_final = ?, "
                    + "valor_cobrado = ?, "
                    + "nome = ?, "
                    + "email = ?, "
                    + "senha = ? "
                    + "where id_psicologo = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Troca as interrogações pelos novos dados
            stmt.setString(1, p.getCrp());
            stmt.setString(2, p.getCnpj());
            stmt.setString(3, p.getEspecialidade());
            stmt.setString(4, p.getContato());
            stmt.setTime(5, p.getHorarioInicial());
            stmt.setTime(6, p.getHorarioFinal());
            stmt.setFloat(7, p.getValor());
            stmt.setString(8, p.getNome());
            stmt.setString(9, p.getEmail());
            stmt.setString(10, p.getSenha());
            stmt.setInt(11, p.getCodPsicologo());

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

    // Método para excluir um psicólogo
    public boolean excluir(Psicologo p) {

        try {

            // Script para deletar um psicólogo
            String sql = "delete from psicologos where id_psicologo = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            // Informa qual psicólogo será excluído
            stmt.setInt(1, p.getCodPsicologo());

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
