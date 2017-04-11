/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class EmpleadoModel extends AbstractTableModel {
    private String[] columnName={"Numero de empleado","Paterno","Materno","Nombre","Departamento","Telefono","Email","Horario"};
    private ArrayList<Persona> data;
    
    public EmpleadoModel(ArrayList<Persona> data){
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
    	Persona empleado;
        if(this.data.get(i) instanceof Persona){
            empleado = (Persona)this.data.get(i);
        }
        switch(j){
            case 0:
                return this.data.get(i).getId();
            case 1:
                return this.data.get(i).getPaterno();
            case 2:
                return this.data.get(i).getMaterno();
            case 3:
                return this.data.get(i).getNombre();
            case 4:
                return this.data.get(i).getDepartamento().toString();
            case 5:
                return this.data.get(i).getTelefono();
            case 6:
                return this.data.get(i).getEmail();
            case 7:
                return this.data.get(i).getEntrada()+" - "+this.data.get(i).getSalida();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnName[i];
    }
    
}
