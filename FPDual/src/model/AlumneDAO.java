package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controlador.Constants;
import controlador.GestorDB;

public class AlumneDAO {
	GestorDB gestorDB;
	
	public AlumneDAO(){
		gestorDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	}
	
	public void altaAlumne(String inici, String fi, int id_tutor, int id_centre, String nif){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date start=null, end=null;
		
		try {
			start = format.parse(inici);
			end = format.parse(fi);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String consultaSQL = "INSERT INTO alumnes(id_usuari,data_inici,data_fi,id_centre,id_tutor) "
				+ "SELECT id_usuari, '"+start+"','"+end+"', "+id_centre+", "+id_tutor+" "
				+ "FROM usuari WHERE NIF LIKE '"+nif+"'";
		gestorDB.modificarRegistre(consultaSQL);
		
	}
}
