/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import controller.Controlador;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class BuscarPanel extends JPanel{
    private JTable tblEmpleados;
        
    public BuscarPanel() {
        super();
        super.setLayout(new BorderLayout());
        super.add(this.crearTablePanel(),BorderLayout.CENTER);
//        super.add(this.crearPnlBuscar(),BorderLayout.SOUTH);
        
    }
    
    private JScrollPane crearTablePanel() {
        EmpleadoModel model = new EmpleadoModel(new Controlador().getEmpleados());
        this.tblEmpleados = new JTable(model);
        this.tblEmpleados.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            	Persona c = new Persona();
                c.setId(tblEmpleados.getValueAt(tblEmpleados.getSelectedRow(), 0).toString());
//                try {
//                    Contacto nContacto = controlador.getContactos().get(controlador.buscarContacto(c));
//                    if (nContacto != null) {
//                        cDialog = new ContactoDialog(MainFrame.this, nContacto);
//                        cDialog.setTitle(nContacto.getNombre());
//                        cDialog.setListener(new ContactoListener() {
//                            @Override
//                            public void guardarClicked(Contacto contacto, Contacto cEditado) {
//                                try {
//                                    controlador.editarContacto(contacto, cEditado);
//                                } catch (ContactoNoEncontradoException ex) {
//                                    JOptionPane.showMessageDialog(MainFrame.this, "No se puede modificar el contacto en este momento");
//                                } catch (ContactoYaExistenteException ex) {
//                                    JOptionPane.showMessageDialog(MainFrame.this, "No se puede modificar el contacto en este momento");
//                                }
//                            }
//
//                            @Override
//                            public void eliminarClicked(Contacto contacto) {
//                                try {
//                                    controlador.eliminarContacto(contacto);
//                                } catch (ContactoNoEncontradoException ex) {
//                                    JOptionPane.showMessageDialog(MainFrame.this, "No se puede modificar el contacto en este momento");
//                                }
//                            }
//                        });
//                        cDialog.setVisible(true);
//                    }
//                } catch (ContactoNoEncontradoException ex) {
//                    JOptionPane.showMessageDialog(MainFrame.this, "No se puede modificar el contacto en este momento");
//                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        return new JScrollPane(tblEmpleados);
    }
    
//    private JPanel crearPnlBuscar() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//        JTextField txtCriterio = new JTextField(5);
//        JButton btnBuscar = new JButton("Buscar");
//        
//        panel.add(new JLabel("Buscar: "));
//        panel.add(txtCriterio);
//        panel.add(btnBuscar);
//        
//        return panel;
//    }
}
