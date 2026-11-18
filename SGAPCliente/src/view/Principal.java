
package view;

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.*;

public class Principal {
    
    /*O ccont é um objeto de conexão controller, ele é público e static para que 
    seja possível chamá-lo de qualquer lugar sem a necessidade de criar um objeto de principal*/
    public static ConexaoController ccont; 
    public static void main(String[] args) {
        
        //fazer a conexao com o servidor
        try {
            //1. criar conexao com o servidor
            System.out.println("0");
            Socket socket = new Socket("localhost", 12345);
            //2. criando o objeto out para enviar comandos para o servidor
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("0.1");
            //3. criando o objeto in para receber respostas do servidor
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println("1");
            // iniciar o conexao controller
            ccont = new ConexaoController(out, in);
            System.out.println("2");
            
            // abrir a primeira tela do sistema
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);

                    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
