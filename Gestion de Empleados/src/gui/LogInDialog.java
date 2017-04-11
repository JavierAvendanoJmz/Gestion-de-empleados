/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.Controlador;

/**
 *
 * @author Usuario
 */
public class LogInDialog extends JDialog{
    
    private JTextField txtUser;
    private JTextField txtPass;
    private JButton btnLogIn;
    
    public LogInDialog(JFrame owner) {
        super(owner,"Iniciar sesión",true);
        super.setSize(50, 150);
        super.setLayout(new FlowLayout());
        
        this.txtUser = new JTextField(5);
        this.txtPass = new JTextField(5);
        this.btnLogIn = new JButton("Iniciar sesión");
        
        this.btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(new Controlador().validarUsuario(txtUser.getText(), txtPass.getText())) { //Comparar user y pass
                	
                    new AdministracionDialog(owner); 
                    LogInDialog.this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(LogInDialog.this, "Usuario y/o contraseña incorrectos");
                    txtUser.setText("");
                    txtPass.setText("");
                }
            }
        });
        
        super.add(this.txtUser);
        super.add(this.txtPass);
        super.add(this.btnLogIn);
        
        super.setVisible(true);
    } 
}
