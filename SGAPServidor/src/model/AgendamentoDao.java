
package model;


import factory.Conector;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Agendamento;
import modelDominio.Paciente;
import modelDominio.Psicologo;

/*
CRUD
C - CREATE (insert)
R - RETRIEVE (select)
U - UPDATE
D - DELETE
*/

//DAO = Data Access Object
//Classe responsável por acessar os dados de agendamentos no banco de dados

public class AgendamentoDao {

    public boolean excluir(Agendamento a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean excluir(Agendamento a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Agendamento> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean inserir(Agendamento a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
public class Agendamento implements Serializable {

      public static final long serialVersionUID = 123456789L;

    // Status do agendamento
    public static final int PENDENTE = 0;
    public static final int CONFIRMADO = 1;
    public static final int CANCELADO = 2;
    public static final int CONCLUIDO = 3;

    private int codAgendamento;
    private Paciente paciente;
    private Psicologo psicologo;
    private Time horario;
    private java.util.Date dia;
    private int status;

    // Getter e setter do código do agendamento
    public int getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    // Getter e setter do paciente
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Getter e setter do psicólogo
    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    // Getter e setter do horário
    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    // Getter e setter do dia
    public java.util.Date getDia() {
        return dia;
    }

    public void setDia(java.util.Date dia) {
        this.dia = dia;
    }

    // Getter e setter do status
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    // Construtor para SELECTS e UPDATES
    public Agendamento(int codAgendamento, Paciente paciente,
            Psicologo psicologo, Time horario, java.util.Date dia, int status) {

        this.codAgendamento = codAgendamento;
        this.paciente = paciente;
        this.psicologo = psicologo;
        this.horario = horario;
        this.dia = dia;
        this.status = status;
    }

    // Construtor para INSERT
    public Agendamento(Paciente paciente, Psicologo psicologo,
            Time horario, java.util.Date dia, int status) {

        this.paciente = paciente;
        this.psicologo = psicologo;
        this.horario = horario;
        this.dia = dia;
        this.status = status;
    }

    // Construtor para DELETE
    public Agendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    // Mostra os dados do agendamento para facilitar o Debug
    @Override
    public String toString() {
        return "Agendamento{"
                + "codAgendamento=" + codAgendamento
                + ", paciente=" + paciente
                + ", psicologo=" + psicologo
                + ", horario=" + horario
                + ", dia=" + dia
                + ", status=" + status
                + '}';
    }
}

}
