
package modelDominio;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable{
     public static final long serialVersionUD = 123456789L;

    public Cliente(String nomeUsuario, String email, String senha) {
        super(nomeUsuario, email, senha);
    }

    public Cliente(int codUsuario, String nomeUsuario, String email, String senha) {
        super(codUsuario, nomeUsuario, email, senha);
    }

    public Cliente(int codUsuario) {
        super(codUsuario);
    }

    public Cliente(String email, String senha) {
        super(email, senha);
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente{" + '}';
    }
}
