
package modelDominio;

import java.io.Serializable;
import java.util.Date;

public class Agendamento implements Serializable {
    public static final long serialVersionUD = 123456789L;
    
    private int codAgendamento;
    private Cliente cliente; 
    private Pet pet;
    private Servico servico;
    private Date dataHora;
    private float valorPago;

    public int getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public Agendamento(int codAgendamento, Cliente cliente, Pet pet, Servico servico, Date dataHora, float valorPago) {
        this.codAgendamento = codAgendamento;
        this.cliente = cliente;
        this.pet = pet;
        this.servico = servico;
        this.dataHora = dataHora;
        this.valorPago = valorPago;
    }

    public Agendamento(Cliente cliente, Pet pet, Servico servico, Date dataHora, float valorPago) {
        this.cliente = cliente;
        this.pet = pet;
        this.servico = servico;
        this.dataHora = dataHora;
        this.valorPago = valorPago;
    }

    public Agendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "codAgendamento=" + codAgendamento + ", cliente=" + cliente + ", pet=" + pet + ", servico=" + servico + ", dataHora=" + dataHora + ", valorPago=" + valorPago + '}';
    }
    
    
}
