/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataSourceOracle  implements DataSource{

    private Connection conexion;
    private Statement st;
    
    public DataSourceOracle() {
        try {
            conexion = new OracleConector().getConexion();
            st = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DataSourceOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object ejecutarConsulta(String consulta) {
        ResultSet rs = null;
        try {
        	System.out.println(consulta);
            rs = this.st.executeQuery(consulta);			
        } catch(Exception e) {
            e.printStackTrace();
        }
        return (Object) rs;
    }

    public int ejecutarActualizacion(String consulta) {
        int rs = 0;
        try {
        	System.out.println(consulta);
            rs = this.st.executeUpdate(consulta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public void cerrarConeccion() throws SQLException {
        conexion.close();
    }
    
}
