package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import modelDominio.Psicologo;
import modelDominio.Agendamento;
import modelDominio.Atendimento;
import modelDominio.Paciente;
import model.PsicologoDao;
import model.PacienteDao;
import model.AgendamentoDao;
import model.AtendimentoDao;

public class TrataClienteController extends Thread {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket socket;
    private int idUnico;

    public TrataClienteController(Socket socket, int idUnico) { //Método construtor
        this.socket = socket;
        this.idUnico = idUnico;

        try {
            this.in = new ObjectInputStream(this.socket.getInputStream());
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // É o método que é executado quando eu iniciar a thread
    public void run() {
        System.out.println("Esperando comandos do cliente " + idUnico);
        String comando; //Váriável para guardar os comandos vindos do cliente (listaPets, InserePet...)

        try {
            comando = (String) in.readObject(); // Recebe o comando do cliente e espera até chegar
            while (!comando.equalsIgnoreCase("fim")) { // Enquanto o comando não for fim, ele fica dentro do loop
                System.out.println("Cliente " + idUnico + " enviou o comando " + comando);
                // TODO: retornaremos aqui quando implementarmos os comandos da comunicação com o cliente.

                // Aqui teremos vários ifs e elses testando os comandos recebidos.
                // NÃO APAGAR A PRÓXIMA LINHA POIS ELA FAZ A RELEITURA DO PRÓXIMO COMANDO
                comando = (String) in.readObject();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fechando conexões com o cliente
        try {
            System.out.println("Cliente " + idUnico + " fechou a conexão");
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
