
package view;

import controller.TrataClienteController;
import factory.Conector;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

//Essa é a classe principal do servidor. Ou seja, é a primeira a ser executada quando o servidor iniciar.

public class Principal {
    public static void main(String[] args) {
        ServerSocket servidor; //Objeto do servidor socket
        int idUnico = 0;
         //Teste de conexão com o banco
        if (Conector.getConnection() != null){
            System.out.println("Conectado com sucesso no banco de dados");
        }
        
        try { //Corrige o erro do servidor
            servidor = new ServerSocket(12345); //Iniciando o servidor socket na porta 12345
            System.out.println("Servidor inicializando. Aguradando conexão dos clientes");
            
            while (true) { //É um while (true) pois eu quero receber infinitas conexões de clientes
                Socket cliente = servidor.accept(); //Esperando conexão de cliente
                System.out.println("Um novo cliente conectou: " +cliente);
                idUnico++;
                System.out.println("Iniciando uma nova Thread para o cliente " +idUnico);
                TrataClienteController tcc = new TrataClienteController(cliente, idUnico);
                tcc.start();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
   
    
}
