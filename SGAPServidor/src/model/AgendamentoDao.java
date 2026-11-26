package model;

import factory.Conector;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Agendamento;
import modelDominio.Paciente;
import modelDominio.Psicologo;

/*
DAO = Data Access Object
Classe responsável por acessar os dados de agendamentos no banco de dados.
*/
public class AgendamentoDao {

    private Connection con; // guarda a conexão com o banco

    // Construtor
    public AgendamentoDao() {
        con = Conector.getConnection();
    }

    // Lista todos os agendamentos, já com paciente e psicólogo preenchidos
    public ArrayList<Agendamento> getLista() {

        ArrayList<Agendamento> lista = new ArrayList<>();

        try {
            // left join no paciente: horário sem paciente (id_paciente nulo) também aparece
            String sql = "select a.id_agendamento, a.horario, a.data, a.status, "
                    + "p.id_paciente, p.nome as nome_paciente, p.contato as contato_paciente, "
                    + "p.cpf, p.contato_emergencia, p.email as email_paciente, "
                    + "p.senha as senha_paciente, "
                    + "s.id_psicologo, s.crp, s.nome as nome_psicologo, "
                    + "s.contato as contato_psicologo, s.cnpj, "
                    + "s.email as email_psicologo, s.senha as senha_psicologo, "
                    + "s.especialidade, s.horario_inicial, s.horario_final, s.valor_cobrado "
                    + "from agendamentos a "
                    + "left join pacientes p on p.id_paciente = a.id_paciente "
                    + "join psicologos s on s.id_psicologo = a.id_psicologo "
                    + "order by a.id_agendamento";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {

                // paciente fica nulo quando o horário ainda não tem paciente
                Paciente paciente = null;
                int idPaciente = res.getInt("id_paciente");
                if (!res.wasNull()) {
                    paciente = new Paciente(
                            idPaciente,
                            res.getString("nome_paciente"),
                            res.getString("contato_paciente"),
                            res.getString("cpf"),
                            res.getString("contato_emergencia"),
                            res.getString("email_paciente"),
                            res.getString("senha_paciente")
                    );
                }

                Psicologo psicologo = new Psicologo(
                        res.getInt("id_psicologo"),
                        res.getString("crp"),
                        res.getString("nome_psicologo"),
                        res.getString("contato_psicologo"),
                        res.getString("cnpj"),
                        res.getString("email_psicologo"),
                        res.getString("senha_psicologo"),
                        res.getString("especialidade"),
                        res.getTime("horario_inicial"),
                        res.getTime("horario_final"),
                        res.getFloat("valor_cobrado")
                );

                Agendamento a = new Agendamento(
                        res.getInt("id_agendamento"),
                        paciente,
                        psicologo,
                        res.getTime("horario"),
                        res.getDate("data"),
                        res.getInt("status")
                );

                lista.add(a);
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

    // Insere um novo agendamento
    public boolean inserir(Agendamento a) {

        try {
            String sql = "insert into agendamentos "
                    + "(id_paciente, id_psicologo, data, horario, status) "
                    + "values (?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            if (a.getPaciente() != null) {
                stmt.setInt(1, a.getPaciente().getCodPaciente());
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setInt(2, a.getPsicologo().getCodPsicologo());
            stmt.setDate(3, new java.sql.Date(a.getDia().getTime()));
            stmt.setTime(4, a.getHorario());
            stmt.setInt(5, a.getStatus());

            stmt.execute();

            stmt.close();
            con.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Edita um agendamento
    public boolean editar(Agendamento a) {

        try {
            String sql = "update agendamentos set "
                    + "id_paciente = ?, "
                    + "id_psicologo = ?, "
                    + "data = ?, "
                    + "horario = ?, "
                    + "status = ? "
                    + "where id_agendamento = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            if (a.getPaciente() != null) {
                stmt.setInt(1, a.getPaciente().getCodPaciente());
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setInt(2, a.getPsicologo().getCodPsicologo());
            stmt.setDate(3, new java.sql.Date(a.getDia().getTime()));
            stmt.setTime(4, a.getHorario());
            stmt.setInt(5, a.getStatus());
            stmt.setInt(6, a.getCodAgendamento());

            stmt.execute();

            stmt.close();
            con.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Exclui um agendamento
    public boolean excluir(Agendamento a) {

        try {
            String sql = "delete from agendamentos where id_agendamento = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, a.getCodAgendamento());

            stmt.execute();

            stmt.close();
            con.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}