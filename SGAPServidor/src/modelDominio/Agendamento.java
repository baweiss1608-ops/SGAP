package modelDominio;

import java.io.Serializable;
import java.util.Date;

public class Agendamento implements Serializable {

    public static final long serialVersionUID = 123456789L;
    private int codAgendamento;
    private Paciente paciente;
    private Psicologo psicologo;
    private Date dataHora;
    private String status;

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

    // Getter e setter da data e hora do agendamento
    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    // Getter e setter do status do agendamento
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Construtor para SELECTS e UPDATES
    public Agendamento(int codAgendamento, Paciente paciente, Psicologo psicologo, Date dataHora, String status) {
        this.codAgendamento = codAgendamento;
        this.paciente = paciente;
        this.psicologo = psicologo;
        this.dataHora = dataHora;
        this.status = status;
    }

    // Construtor para INSERT
    public Agendamento(Paciente paciente, Psicologo psicologo, Date dataHora, String status) {
        this.paciente = paciente;
        this.psicologo = psicologo;
        this.dataHora = dataHora;
        this.status = status;
    }

    // Construtor para DELETE
    public Agendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "codAgendamento=" + codAgendamento + ", paciente=" + paciente + ", psicologo=" + psicologo + ", dataHora=" 
                                                                                                    + dataHora + ", status=" + status + '}';
    }

}
