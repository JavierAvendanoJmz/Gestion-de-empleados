/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class NumeroLabel extends JLabel{
    
    public NumeroLabel(Integer n){
        super(String.valueOf(n));
        super.setFont(new Font("Tahoma",30,30));
        super.setBounds(new Rectangle(100, 50));
    }
    
    public void setValor(Integer v){
        super.setText(String.valueOf(v));
    }
}
