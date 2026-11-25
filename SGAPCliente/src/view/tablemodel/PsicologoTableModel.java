/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import modelDominio.Psicologo;
/**
 *
 * @author ferna
 */
public class PsicologoTableModel extends AbstractTableModel{
     private ArrayList<Psicologo> lista;

    public PsicologoTableModel(ArrayList<Psicologo> lista) {
        this.lista = lista;
    }

    public int getRowCount() {
        return lista.size();
    }

    public int getColumnCount() {
        return 10;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Psicologo s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getCodPsicologo();
            case 1:
                return s.getCrp();
            case 2:
                return s.getNome();
            case 3:
                return s.getContato();
            case 4:
                return s.getCnpj();
            case 5:
                return s.getEmail();
            case 6:
                return s.getSenha();
            case 7:
                return s.getEspecialidade();
            case 8:
                return s.getHorarioInicial();
            case 9:
                return s.getHorarioFinal();
            case 10:
                return s.getValor();
            default:
                return "none";
        }
    }

    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "crp";
            case 2:
                return "Nome";
            case 3:
                return "Contato";
            case 4:
                return "Cnpj";
            case 5:
                return "Email";
            case 6:
                return "Senha";
            case 7:
                return "Especialidade";
            case 8:
                return "Horario Inicial";
            case 9:
                return "Horario Final";
            case 10:
                return "Valor";
            default:
                return "none";
        }
    }

    public Psicologo getPsicologo(int linha) {
        return lista.get(linha);
    }
}

