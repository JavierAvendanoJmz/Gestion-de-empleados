/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import modelo.Persona;
import modelo.Registro;

/**
 *
 * @author Usuario
 */
public class RegistroModel extends AbstractTableModel{
    private String[] columnName={"Numero de registro","Numero de empleado","Entrada","Salida"};
    private ArrayList<Registro> data;
    
    public RegistroModel(ArrayList<Registro> data){
        this.data=data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Registro empleado;
        if(this.data.get(i) instanceof Registro){
            empleado = (Registro)this.data.get(i);
        }
        switch(j){
            case 0:
                return this.data.get(i).getId();
            case 1:
                return this.data.get(i).getPersona();
            case 2:
                return this.data.get(i).getEntrada();
            case 3:
                return this.data.get(i).getSalida();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnName[i];
    }
    
}
