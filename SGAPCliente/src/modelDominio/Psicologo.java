package modelDominio;

import java.io.Serializable;
import java.sql.Time;

public class Psicologo implements Serializable {

    public static final long serialVersionUID = 123456789L;

    private int codPsicologo;
    private String crp;
    private String nome;
    private String contato;
    private String cnpj;
    private String email;
    private String senha;
    private String especialidade;
    private Time horarioInicial;
    private Time horarioFinal;
    private float valor;

    // Getter e setter do código do psicólogo
    public int getCodPsicologo() {
        return codPsicologo;
    }

    public void setCodPsicologo(int codPsicologo) {
        this.codPsicologo = codPsicologo;
    }

    // Getter e setter do CRP
    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
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

    // Getter e setter do CNPJ
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    // Getter e setter da especialidade
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // Getter e setter do horário inicial
    public Time getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Time horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    // Getter e setter do horário final
    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    // Getter e setter do valor da consulta
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    // Construtor para SELECTS e UPDATES
    public Psicologo(int codPsicologo, String crp, String nome, String contato, String cnpj, String email, String senha,
            String especialidade, Time horarioInicial, Time horarioFinal, float valor) {

        this.codPsicologo = codPsicologo;
        this.crp = crp;
        this.nome = nome;
        this.contato = contato;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.especialidade = especialidade;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.valor = valor;
    }

    // Construtor para INSERT
    public Psicologo(String crp, String nome, String contato, String cnpj, String email, String senha, String especialidade,
            Time horarioInicial, Time horarioFinal, float valor) {

        this.crp = crp;
        this.nome = nome;
        this.contato = contato;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.especialidade = especialidade;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.valor = valor;
    }

    // Construtor para DELETE
    public Psicologo(int codPsicologo) {
        this.codPsicologo = codPsicologo;
    }

    // Dados do psicólogo
    @Override
    public String toString() {
        return "Psicologo{" + "codPsicologo=" + codPsicologo + ", crp=" + crp + ", nome=" + nome + ", contato=" + contato + ", cnpj="
                + cnpj + ", email=" + email + ", senha=" + senha + ", especialidade=" + especialidade + ", horarioInicial=" + 
                horarioInicial+ ", horarioFinal=" + horarioFinal + ", valor=" + valor + '}';
    }
}
