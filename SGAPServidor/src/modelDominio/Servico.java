
package modelDominio;

import java.io.Serializable;

public class Servico implements Serializable{
    public static final long serialVersionUD = 123456789L;
    
    private int codServico;
    private String descricao;
    private float preco;

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    //CONSTRUTORES
    
    public Servico(int codServico, String descricao, float preco) { //construtor para SELECTS e UPDATES
        this.codServico = codServico;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Servico(String descricao, float preco) { //construtor para INSERT
        this.descricao = descricao;
        this.preco = preco;
    }

    public Servico(int codServico) { //construtor para DELETES
        this.codServico = codServico;
    }

    @Override
    public String toString() {
        return "Servico{" + "codServico=" + codServico + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
}
