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
		consultaSQL="INSERT INTO tutor (Id_usuari,Tecnologia) "+
					"SELECT Id_usuari,'"+t+"' "+
					"FROM usuari "+
					"WHERE NIF='"+nif+"';";
		g.modificarRegistre(consultaSQL);
		
	}
	
	public void baixaTutor(int id){
		
		consultaSQL="DELETE FROM tutor WHERE id_usuari="+id+";";
		g.modificarRegistre(consultaSQL);
		consultaSQL="DELETE FROM usuari WHERE id_usuari="+id+";";
		g.modificarRegistre(consultaSQL);
		
	}
	
	public List<String> consultaTutor(){
		consultaSQL="SELECT t.Id_usuari,t.tecnologia,u.nom,u.NIF FROM tutor AS t,usuari AS u WHERE t.Id_usuari=u.Id_usuari;";
		ResultSet rs;
		List<String> dades = new ArrayList<String>();
		try {
			rs=g.consultaRegistres(consultaSQL);
			while(rs.next()){
				String d="";
				d+=rs.getInt("Id_usuari")+"\t";
				d+=rs.getString("Tecnologia")+"\t";
				d+=rs.getString("Nom")+"\t";
				d+=rs.getString("NIF");
				dades.add(d);
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
	
	public void tancarConn(){
		g.tancarConnexio();
	}
}