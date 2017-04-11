package controller;

import java.util.ArrayList;
import java.util.List;

import dao.*;
import modelo.*;

public class Controlador {
	
	public ArrayList<Registro> getRegistros(String id) {
		DAORegistro dao = new DAORegistro();		
		ArrayList<Registro> l = dao.buscarRegistros(id);
		return l;
	}
	
	public ArrayList<Persona> getEmpleados() {
		DAOPersona dao = new DAOPersona();		
		ArrayList l = dao.getEmpleados();
		return l;
	}
	
	public String[] buscarDepartamentos() {
		DAODepartamento dao = new DAODepartamento();
		ArrayList<Departamento> l = dao.buscarDepartamentos();
		String[] s = new String[l.size()];
		for(int i=0; i<l.size(); i++) {
			s[i] = l.get(i).getNombre();
		}
		return s;
	}
	
	public void registrarEmpleado(Persona p) {
		p.setActivo("1");
		p.setTipo("3");
		DAOPersona dao = new DAOPersona();
		dao.agregarPersona(p);
	}
	
	public int checarEntrada(String id, String r) {
		DAORegistro dao = new DAORegistro();
		Registro reg = new Registro();
		reg.setPersona(id);
		reg.setEntrada(r);
		int i = dao.registrarEntrada(reg);
		return i;
	}
	
	public int checarSalida(String id, String r, String s) {
		DAORegistro dao = new DAORegistro();
		Registro reg = new Registro();
		reg.setPersona(id);
		reg.setEntrada(s);
		reg.setSalida(r);		
		int i = dao.registrarSalida(reg);
		return i;
	}
	
	public boolean validarUsuario(String usuario, String pass) {
		DAOPersona dao = new DAOPersona();
		Persona p = dao.buscarPersonas(usuario, pass);
		return p.getId().equals("1");
	}

}
