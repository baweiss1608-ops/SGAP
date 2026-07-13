
package modelDominio;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {
    public static final long serialVersionUD = 123456789L;

    public Administrador(String nomeUsuario, String email, String senha) {
        super(nomeUsuario, email, senha);
    }

    public Administrador(int codUsuario, String nomeUsuario, String email, String senha) {
        super(codUsuario, nomeUsuario, email, senha);
    }

    public Administrador(int codUsuario) {
        super(codUsuario);
    }

    public Administrador(String email, String senha) {
        super(email, senha);
    }

    @Override
    public String toString() {
        return super.toString() + "Administrador{" + '}'; //super.toString: puxa o método toString da classe usuário
    }
        
}
