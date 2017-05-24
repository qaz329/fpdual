package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlador.Constants;
import controlador.GestorDB;

public class CentreDAO {
	GestorDB gestorDB;
	public CentreDAO(){
		gestorDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	}
	
	public List<Integer> consultaIDCentre(){
		String consultaSQL="SELECT id_centre FROM centre;";
		ResultSet rs;
		List<Integer> dades = new ArrayList<Integer>();
		try {
			rs=gestorDB.consultaRegistres(consultaSQL);
			while(rs.next()){
				dades.add(rs.getInt("id_centre"));			}
		} catch (SQLException e) {
			System.out.println("Error consulta id centre "+e.toString());
		}
		return dades;
	}
}
