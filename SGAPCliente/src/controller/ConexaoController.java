
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Psicologo;
import modelDominio.Paciente;
import modelDominio.Agendamento;
import modelDominio.Atendimento;

// é a classe que se comunica com o servidor, enviando comandos e recebendo respostas
public class ConexaoController {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Psicologo psicologoLogado;

    public Psicologo getPsicologoLogado() {
        return psicologoLogado;
    }

    public void setPsicologoLogado(Psicologo psicologoLogado) {
        this.psicologoLogado = psicologoLogado;
    }

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    // método para realizar o login do psicólogo
    public Psicologo psicologoLogin(Psicologo psicologo) {

        try {
            out.writeObject("PsicologoLogin"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(psicologo); // enviar o psicólogo que está tentando fazer login
            Psicologo psicologoLogado = (Psicologo) in.readObject(); // receber o psicólogo logado
            return psicologoLogado;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // método para listar os psicólogos
    public ArrayList<Psicologo> psicologoLista() {

        try {
            out.writeObject("PsicologoLista"); // enviar o comando para o servidor
            ArrayList<Psicologo> lista = (ArrayList<Psicologo>) in.readObject();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // método para inserir um psicólogo
    public boolean psicologoInserir(Psicologo p) {

        try {
            out.writeObject("PsicologoInserir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(p); // enviar o psicólogo
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para editar um psicólogo
    public boolean psicologoEditar(Psicologo p) {

        try {
            out.writeObject("PsicologoEditar"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(p); // enviar o psicólogo
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para excluir um psicólogo
    public boolean psicologoExcluir(Psicologo p) {

        try {
            out.writeObject("PsicologoExcluir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(p); // enviar o psicólogo
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para listar os pacientes
    public ArrayList<Paciente> pacienteLista() {

        try {
            out.writeObject("PacienteLista"); // enviar o comando para o servidor
            ArrayList<Paciente> lista = (ArrayList<Paciente>) in.readObject();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // método para inserir um paciente
    public boolean pacienteInserir(Paciente p) {

        try {
            out.writeObject("PacienteInserir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(p); // enviar o paciente
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para editar um paciente
    public boolean pacienteEditar(Paciente p) {

        try {
            out.writeObject("PacienteEditar"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(p); // enviar o paciente
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para excluir um paciente
    public boolean pacienteExcluir(Paciente p) {

        try {
            out.writeObject("PacienteExcluir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(p); // enviar o paciente
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para listar os agendamentos
    public ArrayList<Agendamento> agendamentoLista() {

        try {
            out.writeObject("AgendamentoLista"); // enviar o comando para o servidor
            ArrayList<Agendamento> lista = (ArrayList<Agendamento>) in.readObject();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // método para inserir um agendamento
    public boolean agendamentoInserir(Agendamento a) {

        try {
            out.writeObject("AgendamentoInserir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(a); // enviar o agendamento
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para editar um agendamento
    public boolean agendamentoEditar(Agendamento a) {

        try {
            out.writeObject("AgendamentoEditar"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(a); // enviar o agendamento
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para excluir um agendamento
    public boolean agendamentoExcluir(Agendamento a) {

        try {
            out.writeObject("AgendamentoExcluir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(a); // enviar o agendamento
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para listar os atendimentos
    public ArrayList<Atendimento> atendimentoLista() {

        try {
            out.writeObject("AtendimentoLista"); // enviar o comando para o servidor
            ArrayList<Atendimento> lista = (ArrayList<Atendimento>) in.readObject();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // método para inserir um atendimento
    public boolean atendimentoInserir(Atendimento a) {

        try {
            out.writeObject("AtendimentoInserir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(a); // enviar o atendimento
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para editar um atendimento
    public boolean atendimentoEditar(Atendimento a) {

        try {
            out.writeObject("AtendimentoEditar"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(a); // enviar o atendimento
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // método para excluir um atendimento
    public boolean atendimentoExcluir(Atendimento a) {

        try {
            out.writeObject("AtendimentoExcluir"); // enviar o comando para o servidor
            in.readObject(); // receber o ok
            out.writeObject(a); // enviar o atendimento
            boolean res = (boolean) in.readObject(); // receber o resultado
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
