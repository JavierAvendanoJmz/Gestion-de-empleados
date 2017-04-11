/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class AdministracionDialog extends JDialog {

    private JMenuBar mnbBarra;
    private JPanel pnlTrabajo;
    private RegistroEmpleadoPanel pnlRegistro;
    private BuscarPanel pnlBuscar;
    private RegistrosPanel pnlRegistros;

    public AdministracionDialog(JFrame owner) {
        super(owner, "Administración", true);
        super.setSize(1000, 500);
        
        this.mnbBarra = new JMenuBar();
        this.mnbBarra.add(this.crearMenuArchivo());
        this.mnbBarra.add(this.crearMenuEmpleados());
        this.mnbBarra.add(this.crearMenuReportes());
        
        this.pnlTrabajo = new JPanel();
        
        super.add(this.mnbBarra,BorderLayout.NORTH);
        super.add(this.pnlTrabajo, BorderLayout.CENTER);
        super.setVisible(true);
    }

    private JMenu crearMenuArchivo() {
        JMenu menu = new JMenu("Archivo");

        return menu;
    }

    private JMenu crearMenuEmpleados() {
        JMenu menu = new JMenu("Empleados");
        
        JMenuItem mniRegistrar = new JMenuItem("Registrar");
        mniRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnlRegistro = new RegistroEmpleadoPanel(); 
                pnlTrabajo.removeAll();
                pnlTrabajo.add(pnlRegistro);
                AdministracionDialog.super.setVisible(true);
            }
        });
        JMenuItem mniBuscar = new JMenuItem("Buscar");
        mniBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnlBuscar = new BuscarPanel(); 
                pnlTrabajo.removeAll();
                pnlTrabajo.add(pnlBuscar);
                AdministracionDialog.super.setVisible(true);
            }
        });

        menu.add(mniRegistrar);
        menu.add(mniBuscar);
        
        return menu;
    }

    private JMenu crearMenuReportes() {
        JMenu menu = new JMenu("Reportes");

        JMenuItem mniES = new JMenuItem("Entrada/Salida por empleado");
        
        mniES.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String id = JOptionPane.showInputDialog(AdministracionDialog.this,"Id de empleado","1");
        		pnlRegistros = new RegistrosPanel(id); 
                pnlTrabajo.removeAll();
                pnlTrabajo.add(pnlRegistros);
                AdministracionDialog.super.setVisible(true);
        	}
        });
        
        menu.add(mniES);
        
        return menu;
    }

}
