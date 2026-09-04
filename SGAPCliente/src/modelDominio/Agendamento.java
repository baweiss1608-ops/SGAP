package modelDominio;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

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
    private Date dia;
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
    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
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
            Psicologo psicologo, Time horario, Date dia, int status) {

        this.codAgendamento = codAgendamento;
        this.paciente = paciente;
        this.psicologo = psicologo;
        this.horario = horario;
        this.dia = dia;
        this.status = status;
    }

    // Construtor para INSERT
    public Agendamento(Paciente paciente, Psicologo psicologo,
            Time horario, Date dia, int status) {

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
