/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPersona {

    public DAOPersona() {
        
    }
    
    public Persona buscarPersonas(String usuario, String pass) {
    	String consulta = "SELECT * FROM PERSONAS WHERE PERS_USUARIO = '"+usuario+"' AND PERS_CONTRA = '"+pass+"'";
    	DataSource ds = new DataSourceOracle();
		ResultSet rs = (ResultSet) ds.ejecutarConsulta(consulta);
		Persona persona = new Persona();
		try {
			if(rs.next()) {
				persona.setId(String.valueOf(rs.getInt("PERS_ID")));
			}
			ds.cerrarConeccion();
		} catch (SQLException e) {
			
		}
		return persona;
    }
    
    public ArrayList<Persona> getEmpleados() {
    	String consulta = "SELECT * FROM PERSONAS";
		DataSource ds = new DataSourceOracle();
		ResultSet rs = (ResultSet) 
			ds.ejecutarConsulta(consulta);
		ArrayList<Persona> lista = new ArrayList<Persona>();
		try {
	        while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(String.valueOf(rs.getInt("PERS_ID")));
				persona.setDepartamento(String.valueOf(rs.getInt("DEPA_ID")));
				persona.setNombre(rs.getString("PERS_NOMBRE"));
				persona.setPaterno(rs.getString("PERS_PATERNO"));
				persona.setMaterno(rs.getString("PERS_MATERNO"));
				persona.setEntrada(rs.getString("PERS_ENTRADA"));
				persona.setSalida(rs.getString("PERS_SALIDA"));
				persona.setTelefono(rs.getString("PERS_TELEFONO"));
				persona.setEmail(rs.getString("PERS_EMAIL"));
				persona.setActivo(rs.getString("PERS_ACTIVO"));
				persona.setUsuario(rs.getString("PERS_USUARIO"));
				persona.setContra(rs.getString("PERS_CONTRA"));
				persona.setTipo(rs.getString("PERS_TIPO"));
				lista.add(persona);
	        }
	        ds.cerrarConeccion();
		} catch (SQLException e) {			
	            e.printStackTrace();
		}
	    return lista;
	}
    
    public ArrayList<Persona> buscarPersona(String args) {
    	String consulta = null;
    	try {
    		int i = Integer.valueOf(args);
    		consulta = "SELECT * FROM PERSONAS WHERE PERS_ID = " + String.valueOf(i);
    	} catch(NumberFormatException ex){
    		consulta = "SELECT * FROM PERSONAS WHERE PERS_NOMBRE"
    				+ " LIKE('%"+args+"%') OR PERS_PATERNO LIKE('%"+args+"%') OR PERS_MATERNO LIKE('%"+args+"%')";
    	}
		DataSource ds = new DataSourceOracle();
		ResultSet rs = (ResultSet) 
			ds.ejecutarConsulta(consulta);
		ArrayList<Persona> lista = new ArrayList<Persona>();
		try {
	        while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(String.valueOf(rs.getInt("PERS_ID")));
				persona.setDepartamento(String.valueOf(rs.getInt("DEPA_ID")));
				persona.setNombre(rs.getString("PERS_NOMBRE"));
				persona.setPaterno(rs.getString("PERS_PATERNO"));
				persona.setMaterno(rs.getString("PERS_MATERNO"));
				persona.setEntrada(rs.getString("PERS_ENTRADA"));
				persona.setSalida(rs.getString("PERS_SALIDA"));
				persona.setTelefono(rs.getString("PERS_TELEFONO"));
				persona.setEmail(rs.getString("PERS_EMAIL"));
				persona.setActivo(rs.getString("PERS_ACTIVO"));
				persona.setUsuario(rs.getString("PERS_USUARIO"));
				persona.setContra(rs.getString("PERS_CONTRA"));
				persona.setTipo(rs.getString("PERS_TIPO"));
				lista.add(persona);
	        }
	        ds.cerrarConeccion();
		} catch (SQLException e) {			
	            e.printStackTrace();
		}
	    return lista;
	}
    
    public int nReg(String s) {
    	String consulta = "SELECT COUNT(*) NUMERO FROM "+s;
		DataSource ds = new DataSourceOracle();
		ResultSet rs = (ResultSet) 
			ds.ejecutarConsulta(consulta);
		int i = 0;
		try {
	        while (rs.next()) {
				i = rs.getInt("NUMERO");
	        }
	        ds.cerrarConeccion();
		} catch (SQLException e) {			
	            e.printStackTrace();
		}
	    return i;
    }
    
    public int agregarPersona(Persona p) {
    	String consulta = "INSERT INTO PERSONAS VALUES ("+(nReg("PERSONAS")+1)+", "+p.getDepartamento()+    			
    			", '"+p.getNombre()+"', '"+p.getPaterno()+"', '"+p.getMaterno()+"', '"+p.getEntrada()+
    			"', '"+p.getSalida()+"', '"+p.getTelefono()+"', '"+p.getEmail()+"', "+
    			p.getActivo()+", '"+p.getUsuario()+"', '"+p.getContra()+"', "+p.getTipo()+")";
    	DataSource ds = new DataSourceOracle();
    	int resultado = ds.ejecutarActualizacion(consulta);
    	try {
			ds.cerrarConeccion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return resultado;
    }
    
    public int eliminarPersona(String id) {
    	String consulta = "UPDATE PERSONAS SET PERS_ACTIVO = 0 WHERE PERS_ID = " + id;
    	DataSource ds = new DataSourceOracle();
    	int resultado = ds.ejecutarActualizacion(consulta);
    	try {
			ds.cerrarConeccion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return resultado;
    }
}
