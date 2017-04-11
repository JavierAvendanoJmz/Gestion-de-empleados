/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class RelojPanel extends JPanel{
    private NumeroLabel lblHora;
    private NumeroLabel lblMinuto;
    private NumeroLabel lblSegundo;
    private Thread hilo;
    private int hora;
    private int minuto;
    private int segundo;
    public RelojPanel(){
        super();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        this.hora = now.getHour();
        this.minuto = now.getMinute();
        this.segundo = now.getSecond();
        this.lblHora = new NumeroLabel(this.hora);
        this.lblMinuto = new NumeroLabel(this.minuto);
        this.lblSegundo = new NumeroLabel(this.segundo);
        this.hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    avanzar();
                    lblHora.setValor(hora);
                    lblMinuto.setValor(minuto);
                    lblSegundo.setValor(segundo);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }
        });
        
        JLabel lblPunto = new JLabel(":");
        lblPunto.setFont(new Font("Tahoma",30,30));
        
        JLabel lblPunto2 = new JLabel(":");
        lblPunto2.setFont(new Font("Tahoma",30,30));
        
        super.add(this.lblHora);
        super.add(lblPunto);
        super.add(this.lblMinuto);
        super.add(lblPunto2);
        super.add(this.lblSegundo);
        hilo.start();
    }
    
    private void avanzar() {
        this.segundo++;
        if(this.segundo == 60 ){
            this.minuto++;
            this.segundo = 0;
            if(this.minuto == 60){
                this.hora++;
                this.minuto = 0;
                if(hora == 24){
                    hora = 0;
                }
            }
        }
    }
}
