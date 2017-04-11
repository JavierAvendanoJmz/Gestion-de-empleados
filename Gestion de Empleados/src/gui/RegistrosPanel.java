/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import controller.Controlador;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class RegistrosPanel extends JPanel{
	
    private JTable tblRegistros;
    private String id;
    
    public RegistrosPanel(String id) {
        super();        
        super.setLayout(new BorderLayout());
        this.id = id;
        super.add(this.crearPnlTabla(),BorderLayout.CENTER);
    }
    
    private JScrollPane crearPnlTabla() {
        RegistroModel model = new RegistroModel(new Controlador().getRegistros(id));
        this.tblRegistros = new JTable(model);
        this.tblRegistros.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Persona c = new Persona();
                c.setId(tblRegistros.getValueAt(tblRegistros.getSelectedRow(), 0).toString());
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
        return new JScrollPane(tblRegistros);
    }
}
