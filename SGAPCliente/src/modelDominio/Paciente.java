
package modelDominio;

import java.io.Serializable;

public class Paciente  implements Serializable {
     public static final long serialVersionUID = 123456789L;

    private int codPaciente;
    private String nome;
    private String contato;
    private String cpf;
    private String contatoEmergencia;
    private String email;
    private String senha;

    // Getter e setter do código do paciente
    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    // Getter e setter do nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e setter do contato
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    // Getter e setter do CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter e setter do contato de emergência
    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    // Getter e setter do email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter e setter da senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Construtor para SELECTS e UPDATES
    public Paciente(int codPaciente, String nome, String contato, String cpf,
            String contatoEmergencia, String email, String senha) {

        this.codPaciente = codPaciente;
        this.nome = nome;
        this.contato = contato;
        this.cpf = cpf;
        this.contatoEmergencia = contatoEmergencia;
        this.email = email;
        this.senha = senha;
    }

    // Construtor para INSERT
    public Paciente(String nome, String contato, String cpf,
            String contatoEmergencia, String email, String senha) {

        this.nome = nome;
        this.contato = contato;
        this.cpf = cpf;
        this.contatoEmergencia = contatoEmergencia;
        this.email = email;
        this.senha = senha;
    }

    // Construtor para DELETE
    public Paciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    // Construtor para LOGIN
    public Paciente(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Paciente{" 
                + "codPaciente=" + codPaciente
                + ", nome=" + nome
                + ", contato=" + contato
                + ", cpf=" + cpf
                + ", contatoEmergencia=" + contatoEmergencia
                + ", email=" + email
                + '}';
    }
    
}
