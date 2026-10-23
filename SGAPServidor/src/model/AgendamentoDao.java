
package model;


import factory.Conector;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import modelDominio.Agendamento;
import modelDominio.Paciente;
import modelDominio.Psicologo;

/*
CRUD
C - CREATE (insert)
R - RETRIEVE (select)
U - UPDATE
D - DELETE
*/

//DAO = Data Access Object
//Classe responsável por acessar os dados de agendamentos no banco de dados

public class AgendamentoDao {

       public ArrayList<Agendamento> getLista() {
    throw new UnsupportedOperationException();
}

public boolean inserir(Agendamento a) {
    throw new UnsupportedOperationException();
}

public boolean editar(Agendamento a) {
    throw new UnsupportedOperationException();
}

public boolean excluir(Agendamento a) {
    throw new UnsupportedOperationException();
}
    
}
