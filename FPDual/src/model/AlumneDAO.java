package model;

import controlador.Constants;
import controlador.GestorDB;

public class AlumneDAO {
	GestorDB gestorDB;
	
	public AlumneDAO(){
		gestorDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	}
	
	public void altaAlumne(String inici, String fi, int id_tutor, int id_centre, String nif){
		id_tutor=2;
		id_centre=1;
		String consultaSQL = "INSERT INTO alumne(id_usuari,data_inici,data_fi,id_centre,id_tutor) "
				+ "SELECT id_usuari, '"+inici+"','"+fi+"', "+id_centre+", "+id_tutor+" "
				+ "FROM usuari WHERE NIF LIKE '"+nif+"'";
		gestorDB.modificarRegistre(consultaSQL);
		
	}
}
