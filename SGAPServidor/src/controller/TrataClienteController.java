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

    public TrataClienteController(Socket socket, int idUnico) {
        // Método construtor
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
        // É o método executado quando a thread é iniciada
        System.out.println("Esperando comandos do cliente " + idUnico);

        String comando;

        try {
            comando = (String) in.readObject();

            while (!comando.equalsIgnoreCase("fim")) {

                System.out.println("Cliente " + idUnico
                        + " enviou o comando " + comando);

                // LOGIN DO PSICÓLOGO
                if (comando.equalsIgnoreCase("PsicologoLogin")) {
                    out.writeObject("ok");

                    Psicologo p = (Psicologo) in.readObject();

                    PsicologoDao pDao = new PsicologoDao();
                    Psicologo psicologoLogado = pDao.login(p);

                    out.writeObject(psicologoLogado);

                // LISTA DE PSICÓLOGOS
                } else if (comando.equalsIgnoreCase("PsicologoLista")) {

                    PsicologoDao pDao = new PsicologoDao();
                    ArrayList<Psicologo> lista = pDao.getLista();

                    out.writeObject(lista);

                // INSERIR PSICÓLOGO
                } else if (comando.equalsIgnoreCase("PsicologoInserir")) {
                    out.writeObject("ok");

                    Psicologo p = (Psicologo) in.readObject();

                    PsicologoDao pDao = new PsicologoDao();
                    boolean res = pDao.inserir(p);

                    out.writeObject(res);

                // EDITAR PSICÓLOGO
                } else if (comando.equalsIgnoreCase("PsicologoEditar")) {
                    out.writeObject("ok");

                    Psicologo p = (Psicologo) in.readObject();

                    PsicologoDao pDao = new PsicologoDao();
                    boolean res = pDao.editar(p);

                    out.writeObject(res);

                // EXCLUIR PSICÓLOGO
                } else if (comando.equalsIgnoreCase("PsicologoExcluir")) {
                    out.writeObject("ok");

                    Psicologo p = (Psicologo) in.readObject();

                    PsicologoDao pDao = new PsicologoDao();
                    boolean res = pDao.excluir(p);

                    out.writeObject(res);

                // LOGIN DO PACIENTE
                } else if (comando.equalsIgnoreCase("PacienteLogin")) {
                    out.writeObject("ok");

                    Paciente p = (Paciente) in.readObject();

                    PacienteDao pDao = new PacienteDao();
                    Paciente pacienteLogado = pDao.login(p);

                    out.writeObject(pacienteLogado);

                // LISTA DE PACIENTES
                } else if (comando.equalsIgnoreCase("PacienteLista")) {

                    PacienteDao pDao = new PacienteDao();
                    ArrayList<Paciente> lista = pDao.getLista();

                    out.writeObject(lista);

                // INSERIR PACIENTE
                } else if (comando.equalsIgnoreCase("PacienteInserir")) {
                    out.writeObject("ok");

                    Paciente p = (Paciente) in.readObject();

                    PacienteDao pDao = new PacienteDao();
                    boolean res = pDao.inserir(p);

                    out.writeObject(res);

                // EDITAR PACIENTE
                } else if (comando.equalsIgnoreCase("PacienteEditar")) {
                    out.writeObject("ok");

                    Paciente p = (Paciente) in.readObject();

                    PacienteDao pDao = new PacienteDao();
                    boolean res = pDao.editar(p);

                    out.writeObject(res);

                // EXCLUIR PACIENTE
                } else if (comando.equalsIgnoreCase("PacienteExcluir")) {
                    out.writeObject("ok");

                    Paciente p = (Paciente) in.readObject();

                    PacienteDao pDao = new PacienteDao();
                    boolean res = pDao.excluir(p);

                    out.writeObject(res);

                // LISTA DE AGENDAMENTOS
                } else if (comando.equalsIgnoreCase("AgendamentoLista")) {

                    AgendamentoDao aDao = new AgendamentoDao();
                    ArrayList<Agendamento> lista = aDao.getLista();

                    out.writeObject(lista);

                // INSERIR AGENDAMENTO
                } else if (comando.equalsIgnoreCase("AgendamentoInserir")) {
                    out.writeObject("ok");

                    Agendamento a = (Agendamento) in.readObject();

                    AgendamentoDao aDao = new AgendamentoDao();
                    boolean res = aDao.inserir(a);

                    out.writeObject(res);

                // EDITAR AGENDAMENTO
                } else if (comando.equalsIgnoreCase("AgendamentoEditar")) {
                    out.writeObject("ok");

                    Agendamento a = (Agendamento) in.readObject();

                    AgendamentoDao aDao = new AgendamentoDao();
                    boolean res = aDao.editar(a);

                    out.writeObject(res);

                // EXCLUIR AGENDAMENTO
                } else if (comando.equalsIgnoreCase("AgendamentoExcluir")) {
                    out.writeObject("ok");

                    Agendamento a = (Agendamento) in.readObject();

                    AgendamentoDao aDao = new AgendamentoDao();
                    boolean res = aDao.excluir(a);

                    out.writeObject(res);

                // LISTA DE ATENDIMENTOS
                } else if (comando.equalsIgnoreCase("AtendimentoLista")) {

                    AtendimentoDao aDao = new AtendimentoDao();
                    ArrayList<Atendimento> lista = aDao.getLista();

                    out.writeObject(lista);

                // INSERIR ATENDIMENTO
                } else if (comando.equalsIgnoreCase("AtendimentoInserir")) {
                    out.writeObject("ok");

                    Atendimento a = (Atendimento) in.readObject();

                    AtendimentoDao aDao = new AtendimentoDao();
                    boolean res = aDao.inserir(a);

                    out.writeObject(res);

                // EDITAR ATENDIMENTO
                } else if (comando.equalsIgnoreCase("AtendimentoEditar")) {
                    out.writeObject("ok");

                    Atendimento a = (Atendimento) in.readObject();

                    AtendimentoDao aDao = new AtendimentoDao();
                    boolean res = aDao.editar(a);

                    out.writeObject(res);

                // EXCLUIR ATENDIMENTO
                } else if (comando.equalsIgnoreCase("AtendimentoExcluir")) {
                    out.writeObject("ok");

                    Atendimento a = (Atendimento) in.readObject();

                    AtendimentoDao aDao = new AtendimentoDao();
                    boolean res = aDao.excluir(a);

                    out.writeObject(res);
                }

                // NÃO APAGAR A PRÓXIMA LINHA,
                // POIS ELA FAZ A RELEITURA DO PRÓXIMO COMANDO
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
