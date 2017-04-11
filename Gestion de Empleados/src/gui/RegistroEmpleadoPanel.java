/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import controller.Controlador;
import modelo.Departamento;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class RegistroEmpleadoPanel extends JPanel{
    //private JTextField txtNoEmpleado;
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JComboBox cmbDepartamento;
    private JFormattedTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtHorario;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    
    public RegistroEmpleadoPanel(){
        super(); 
        super.setLayout(new BorderLayout());
        this.txtNombre = new JTextField(5);
        this.txtPaterno = new JTextField(5);
        this.txtMaterno = new JTextField(5);
        this.txtEmail = new JTextField(5);
        this.txtHorario = new JTextField(5);
        
        NumberFormat formato = NumberFormat.getInstance();
        formato.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(formato);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        this.txtTelefono = new JFormattedTextField(formatter);
        this.txtTelefono.setColumns(5);
        
        String[] s = new Controlador().buscarDepartamentos();
        this.cmbDepartamento = new JComboBox(s);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        panel.add(new JLabel("Apellido paterno"));
        panel.add(this.txtPaterno);
        panel.add(new JLabel("Apellido materno"));
        panel.add(this.txtMaterno);
        panel.add(new JLabel("Nombre(s)"));
        panel.add(this.txtNombre);
        panel.add(new JLabel("Email"));
        panel.add(this.txtEmail);
        panel.add(new JLabel("Telefono"));
        panel.add(this.txtTelefono);
        panel.add(new JLabel("Departamento"));
        panel.add(this.cmbDepartamento);
        
        super.add(panel,BorderLayout.CENTER);
        super.add(this.crearPnlBotones(),BorderLayout.SOUTH);
    }
    
    private JPanel crearPnlBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.btnCancelar = new JButton("Cancelar");
        this.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                RegistroEmpleadoPanel.super.setVisible(false);
                RegistroEmpleadoPanel.super.repaint();
            }
        });
        this.btnRegistrar = new JButton("Registrar");
        
        
        this.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	
                Persona p = new Persona();
                
                p.setNombre(txtNombre.getText());
                p.setPaterno(txtPaterno.getText());
                p.setMaterno(txtMaterno.getText());
                p.setEmail(txtEmail.getText());
                p.setTelefono(txtTelefono.getText());
                p.setEmail(txtEmail.getText());
                p.setDepartamento(""+(cmbDepartamento.getSelectedIndex()+1));
                new Controlador().registrarEmpleado(p);
            }
        });
        
        panel.add(this.btnCancelar);
        panel.add(this.btnRegistrar);
        
        return panel;
    }
}
