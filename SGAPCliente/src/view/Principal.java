
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Principal {

    /*
    O ccont é um objeto de conexão controller.
    Ele é público e static para que seja possível
    chamá-lo de qualquer lugar sem a necessidade
    de criar um objeto de Principal.
    */
    public static ConexaoController ccont;

    public static void main(String[] args) {

        // Fazer a conexão com o servidor
        try {

            // Cria conexão com o servidor
            Socket socket = new Socket("localhost", 12345);

            // Cria o objeto out para enviar comandos
            // para o servidor
            ObjectOutputStream out =
                    new ObjectOutputStream(socket.getOutputStream());

            // Cria o objeto in para receber respostas
            // do servidor
            ObjectInputStream in =
                    new ObjectInputStream(socket.getInputStream());

            // Inicia o ConexaoController
            ccont = new ConexaoController(out, in);

            // Abre a primeira tela do sistema
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);

        } catch (Exception e) {

            // Mostrar o erro caso aconteça algum problema
            // na conexão com o servidor
            e.printStackTrace();
        }
    }
}
