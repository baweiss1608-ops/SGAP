
package modelDominio;

import java.io.Serializable;

public class Usuario implements Serializable{ //Serializable permite que objetos dessa classe sejam transmitidos pela rede
    
    public static final long serialVersionUID = 123456789L; //serialVersionUID é o número da versão dessa classe
    
    private int codUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;

    //método getter e setter serve para conseguir acessar esses dados pq são privados
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //precisamos de 4 CONSTRUTORES

    public Usuario(String nomeUsuario, String email, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }
    
    //para editar ou fazer updates. Também é para SELECTS
    public Usuario(int codUsuario, String nomeUsuario, String email, String senha) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }
    
    //para deletar
    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    //para fazer login
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    //fazer print pelo sout. usar para Debug(corrigir erros)
    @Override
    public String toString() {
        return "Usuario{" + "codUsuario=" + codUsuario + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", senha=" + senha + '}';
    }
        
}
