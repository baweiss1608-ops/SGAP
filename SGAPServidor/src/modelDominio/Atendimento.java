
package modelDominio;

import java.io.Serializable;

public class Atendimento implements Serializable {

      public static final long serialVersionUID = 123456789L;

    private int codAtendimento;
    private Agendamento agendamento;
    private String relato;
    private float precoCobrado;

    // Getter e setter do código do atendimento
    public int getCodAtendimento() {
        return codAtendimento;
    }

    public void setCodAtendimento(int codAtendimento) {
        this.codAtendimento = codAtendimento;
    }

    // Getter e setter do agendamento
    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    // Getter e setter do relato
    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    // Getter e setter do preço cobrado
    public float getPrecoCobrado() {
        return precoCobrado;
    }

    public void setPrecoCobrado(float precoCobrado) {
        this.precoCobrado = precoCobrado;
    }

    // Construtor para SELECTS e UPDATES
    public Atendimento(int codAtendimento, Agendamento agendamento,
            String relato, float precoCobrado) {

        this.codAtendimento = codAtendimento;
        this.agendamento = agendamento;
        this.relato = relato;
        this.precoCobrado = precoCobrado;
    }

    // Construtor para INSERT
    public Atendimento(Agendamento agendamento,
            String relato, float precoCobrado) {

        this.agendamento = agendamento;
        this.relato = relato;
        this.precoCobrado = precoCobrado;
    }

    // Construtor para DELETE
    public Atendimento(int codAtendimento) {
        this.codAtendimento = codAtendimento;
    }

    // Mostra os dados do atendimento para facilitar o Debug
    @Override
    public String toString() {
        return "Atendimento{"
                + "codAtendimento=" + codAtendimento
                + ", agendamento=" + agendamento
                + ", relato=" + relato
                + ", precoCobrado=" + precoCobrado
                + '}';
    }
}
