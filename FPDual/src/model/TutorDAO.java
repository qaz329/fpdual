package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controlador.Constants;
import controlador.GestorDB;

public class TutorDAO {
	String consultaSQL;
	Statement stmt;
	GestorDB g;
	
	public TutorDAO(){
		g=new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	}

	public void altaTutor(String nif,String t){
		System.out.println(t);
		System.out.println(nif);
		consultaSQL="INSERT INTO tutor (id_usuari,tecnologia) "+
				"SELECT Id_usuari,'"+t+"' "+
				"FROM usuari "+
				"WHERE NIF LIKE '"+nif+"'";
		g.modificarRegistre(consultaSQL);
		
	}
	
	public void baixaTutor(int id){
		
		consultaSQL="DELETE FROM tutor WHERE id_usuari="+id+";";
		g.modificarRegistre(consultaSQL);
		consultaSQL="DELETE FROM usuari WHERE id_usuari="+id+";";
		g.modificarRegistre(consultaSQL);

	}
	
	public List<String> consultaTutor(){
		consultaSQL="SELECT * FROM tutor;";
		ResultSet rs;
		List<String> dades = new ArrayList<String>();
		try {
			rs=g.consultaRegistres(consultaSQL);
			while(rs.next()){
				dades.add(rs.getString("Id_usuari"));
				dades.add(rs.getString("Tecnologia"));
			}
		} catch (SQLException e) {
			System.out.println("Error consulta tutor "+e.toString());
		}
		return dades;
	}
	
	public List<Integer> consultaIDTutor(){
		consultaSQL="SELECT id_usuari FROM tutor;";
		ResultSet rs;
		List<Integer> dades = new ArrayList<Integer>();
		try {
			rs=g.consultaRegistres(consultaSQL);
			while(rs.next()){
				dades.add(rs.getInt("id_usuari"));			}
		} catch (SQLException e) {
			System.out.println("Error consulta id tutor "+e.toString());
		}
		return dades;
	}
}
