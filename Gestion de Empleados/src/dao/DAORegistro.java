package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Persona;
import modelo.Registro;

public class DAORegistro {

	public DAORegistro() {
	        
	}
    
    public ArrayList<Registro> buscarRegistros(String id) {
		String consulta = "SELECT * FROM ES WHERE PERS_ID = " + id;
		DataSource ds = new DataSourceOracle();
		ResultSet rs = (ResultSet) 
			ds.ejecutarConsulta(consulta);
		ArrayList<Registro> lista = new ArrayList<Registro>();
		try {
	        while (rs.next()) {
				Registro registro = new Registro();
				registro.setId(String.valueOf(rs.getInt("ES_ID")));
				registro.setPersona(String.valueOf(rs.getInt("PERS_ID")));
				registro.setEntrada(String.valueOf(rs.getString("ES_ENTRADA")));
				registro.setSalida(String.valueOf(rs.getString("ES_SALIDA")));
				lista.add(registro);
	        }
	        ds.cerrarConeccion();
		} catch (SQLException e) {			
	            e.printStackTrace();
		}
	    return lista;
	}
    
    private int nReg(String s) {
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
    
    public int registrarEntrada(Registro r) {
    	String consulta = "INSERT INTO ES (ES_ID, PERS_ID, ES_ENTRADA) VALUES ("+(nReg("ES")+1)+", "+r.getPersona()+
    			", TO_DATE('"+r.getEntrada()+"', 'DD/MM/YYYY HH24:MI:SS'))";
    	DataSource ds = new DataSourceOracle();
    	int resultado = ds.ejecutarActualizacion(consulta);
    	try {
			ds.cerrarConeccion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return resultado;
    }
    
   public int registrarSalida(Registro r) {
    	String consulta = "UPDATE ES SET ES_SALIDA = (TO_DATE('"+r.getSalida()+"', 'DD/MM/YYYY HH24:MI:SS')) "
    			+ "WHERE PERS_ID = "+r.getPersona()+" AND ES_SALIDA IS NULL";
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
