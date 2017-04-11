package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Departamento;
import modelo.Persona;

public class DAODepartamento {
	
	public ArrayList<Departamento> buscarDepartamentos() {
    	String consulta = "SELECT * FROM DEPARTAMENTO";
		DataSource ds = new DataSourceOracle();
		ResultSet rs = (ResultSet) 
			ds.ejecutarConsulta(consulta);
		ArrayList<Departamento> lista = new ArrayList<Departamento>();
		try {
	        while (rs.next()) {
	        	Departamento departamento = new Departamento();
	        	departamento.setId(String.valueOf(rs.getInt("DEPA_ID")));
				departamento.setNombre(rs.getString("DEPA_NOMBRE"));
				lista.add(departamento);
	        }
	        ds.cerrarConeccion();
		} catch (SQLException e) {			
	            e.printStackTrace();
		}
	    return lista;
	}

}
