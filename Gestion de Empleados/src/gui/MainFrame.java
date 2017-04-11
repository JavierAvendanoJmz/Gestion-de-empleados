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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.*;

import controller.Controlador;

/**
 *
 * @author Usuario
 */
public class MainFrame extends JFrame{
    
    private RelojPanel pnlReloj;
    private JTextField txtNumeroEmpleado;
    private JButton btnChecarEntrada;
    private JButton btnChecarSalida;
    
    public MainFrame(){
        super("Reloj checador v1.0");
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500,200);
        
        this.pnlReloj = new RelojPanel();
        this.txtNumeroEmpleado = new JTextField(5);
        this.btnChecarEntrada = new JButton("Checar entrada");
        this.btnChecarSalida = new JButton("Checar salida");
        
        btnChecarEntrada.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		LocalDate dia = LocalDate.now();
        		LocalTime hora = LocalTime.now();
        		String s = new String();
        		String d = new String();
        		String m = new String();
        		if(dia.getDayOfMonth()<10)
        			d+="0"+dia.getDayOfMonth();
        		else
        			d+=""+dia.getDayOfMonth();
        		if(dia.getMonthValue()<10)
        			m+="0"+dia.getMonthValue();
        		else
        			m+=""+dia.getMonthValue();
        		s += d+"/"+m+"/"+dia.getYear()+" ";
        		s += hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond();
        		System.out.println(s);
        		int i = new Controlador().checarEntrada(txtNumeroEmpleado.getText(), s);
        		System.out.println(i);
        	}
        });
        
        btnChecarSalida.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		LocalDate dia = LocalDate.now();
        		LocalTime hora = LocalTime.now();
        		String salida = new String();
        		String s = new String();
        		String d = new String();
        		String m = new String();
        		if(dia.getDayOfMonth()<10)
        			d+="0"+dia.getDayOfMonth();
        		else
        			d+=""+dia.getDayOfMonth();
        		if(dia.getMonthValue()<10)
        			m+="0"+dia.getMonthValue();
        		else
        			m+=""+dia.getMonthValue();
        		salida += d+"/"+m+"/"+dia.getYear()+" ";
        		s += salida;
        		s += hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond();
        		System.out.println(s);
        		int i = new Controlador().checarSalida(txtNumeroEmpleado.getText(), s, salida);
        		System.out.println(i);
        	}
        });
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Número de empleado"));
        panel.add(this.txtNumeroEmpleado);
        panel.add(this.btnChecarEntrada);
        panel.add(this.btnChecarSalida);
        
        JPanel pnl = new JPanel();
        pnl.setLayout(new BorderLayout());
        pnl.add(this.crearPnlBotones(),BorderLayout.NORTH);
        pnl.add(this.pnlReloj);
        
        super.add(pnl,BorderLayout.NORTH);
        super.add(panel);
        super.setVisible(true);
    }
    
    private JPanel crearPnlBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAdministracion = new JButton("Administración");
        
        btnAdministracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new LogInDialog(MainFrame.this);
            }
        });
        panel.add(btnAdministracion);
        
        return panel;
    }
}

class Test {
    public static void main(String[] args) {
        new MainFrame();
    }
}
