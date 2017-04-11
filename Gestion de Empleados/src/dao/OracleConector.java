/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OracleConector {
    
    private Connection conexion;
    
    public OracleConector() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","visual","pass");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OracleConector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OracleConector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }
    
}
