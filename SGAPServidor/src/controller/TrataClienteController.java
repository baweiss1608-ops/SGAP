
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.ServicoDao;
import model.UsuarioDao;
import model.PetDao;
import modelDominio.Servico;
import modelDominio.Usuario;
import modelDominio.Pet;

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
            comando = (String) in.readObject(); //Recebe o comando do cliente e espera até chegar
            while (!comando.equalsIgnoreCase("fim")) { //Enquanto o comando não for fim, ele fica dentro do loop
                System.out.println("Cliente " + idUnico + "enviou o comando " + comando);
                //TO DO: retornaremos aqui quando implementarmos os comandos da comunicação com o cliente. Aqui teremos vários ifs, elses testando os comandos recebidos

                if (comando.equalsIgnoreCase("UsuarioLogin")) { //testando os comandos recebidos
                    out.writeObject("ok"); //devolvendo um ok
                    Usuario user = (Usuario) in.readObject(); //recebendo o usuario que esta tentando fazer o login no sistema
                    //consultando no banco para verificar se o usuario existe
                    UsuarioDao usDao = new UsuarioDao();
                    Usuario userLogado = usDao.login(user);
                    out.writeObject(userLogado);
                } else if (comando.equalsIgnoreCase("ServicoLista")) {
                    ServicoDao sDao = new ServicoDao();
                    ArrayList<Servico> lista = new ArrayList<Servico>();
                    lista = sDao.getLista();
                    out.writeObject(lista);
                } else if (comando.equalsIgnoreCase("ServicoInserir")) {
                    out.writeObject("ok");
                    Servico s = (Servico) in.readObject(); //recebendo o servico do ciente
                    ServicoDao sDao = new ServicoDao(); //criando o servico dao
                    boolean res = sDao.inserir(s); //chamando o inserir e passando o servico como parametro
                    out.writeObject(res); //retornando o servico para o clinte 
                } else if (comando.equalsIgnoreCase("ServicoEditar")) {
                    out.writeObject("ok");
                    Servico s = (Servico) in.readObject(); //recebendo o servico do ciente
                    ServicoDao sDao = new ServicoDao(); //criando o servico dao
                    boolean res = sDao.editar(s); //chamando o editar e passando o servico como parametro
                    out.writeObject(res); //retornando o servico para o clinte 
                } else if (comando.equalsIgnoreCase("ServicoExcluir")) {
                    out.writeObject("ok");
                    Servico s = (Servico) in.readObject(); //recebendo o servico do ciente
                    ServicoDao sDao = new ServicoDao(); //criando o servico dao
                    boolean res = sDao.excluir(s); //chamando o editar e passando o servico como parametro
                    out.writeObject(res); //retornando o servico para o clinte 
                } else if (comando.equalsIgnoreCase("PetLista")) {
                    PetDao pDao = new PetDao();
                    ArrayList<Pet> lista = pDao.getLista();
                    out.writeObject(lista);
                } else if (comando.equalsIgnoreCase("PetInserir")) {
                    out.writeObject("ok");
                    Pet p = (Pet) in.readObject();
                    System.out.println(p);
                    PetDao pDao = new PetDao();
                    boolean res = pDao.inserir(p);
                    out.writeObject(res);
                } else if (comando.equalsIgnoreCase("PetEditar")) {
                    out.writeObject("ok");
                    Pet p = (Pet) in.readObject();
                    System.out.println(p);
                    PetDao pDao = new PetDao();
                    boolean res = pDao.editar(p);
                    out.writeObject(res);
                } else if (comando.equalsIgnoreCase("PetExcluir")) {
                    out.writeObject("ok");
                    Pet p = (Pet) in.readObject();
                    PetDao pDao = new PetDao();
                    boolean res = pDao.excluir(p);
                    out.writeObject(res);
                } else if (comando.equalsIgnoreCase("UsuarioLista")) {
                    UsuarioDao uDao = new UsuarioDao();
                    ArrayList<Usuario> lista = uDao.getLista();
                    out.writeObject(lista);
                } else if (comando.equalsIgnoreCase("UsuarioInserir")) {
                    out.writeObject("ok");
                    Usuario u = (Usuario) in.readObject();
                    UsuarioDao uDao = new UsuarioDao();
                    boolean res = uDao.inserir(u);
                    out.writeObject(res);
                }

                // // NÃO APAGAR A PRÓXIMA LINHA POIS ELA FAZ A RELEITURA DO PRÓXIMO COMANDO
                comando = (String) in.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //fechando conexoes com o cliente
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
