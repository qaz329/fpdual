package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlador.Constants;
import controlador.GestorDB;

public class CentreDAO {
	GestorDB gestorDB;
	String sentenciaSQL;

	public CentreDAO() {

	}

	public List<Integer> consultaIDCentre() {
		gestorDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
		String consultaSQL = "SELECT id_centre FROM centre;";
		ResultSet rs;
		List<Integer> dades = new ArrayList<Integer>();
		try {
			rs = gestorDB.consultaRegistres(consultaSQL);
			while (rs.next()) {
				dades.add(rs.getInt("id_centre"));
			}
		} catch (SQLException e) {
			System.out.println("Error consulta id centre " + e.toString());
		}
		return dades;
	}

	public int altaCentreEntradaId(int idcentre, String nom, int codi, int telefon, String web) {
		int e = 0;
		sentenciaSQL = "INSERT INTO centre (Id_centre, Nom, Codi, Telefon, Web) VALUES(" + idcentre + ", '" + nom
				+ "', " + codi + ", " + telefon + ", '" + web + "');";
		e = gestorDB.modificarRegistre(sentenciaSQL);
		return e;

	}

	public void altaCentreAuto(String nom, int codi, int telefon, String web) {
		sentenciaSQL = "INSERT INTO centre (Nom, Codi, Telefon, Web) " + "VALUES('" + nom + "', " + codi + ", "
				+ telefon + ", '" + web + "');";
		gestorDB.modificarRegistre(sentenciaSQL);
	}

	public int consultaIDAlta(boolean enters, String comprova, int idcentre) {
		ResultSet retorn;
		int i = 0;
		idcentre = Integer.parseInt(comprova);
		String consultarid = "SELECT * FROM centre WHERE Id_centre LIKE " + idcentre + ";";
		retorn = gestorDB.consultaRegistres(consultarid);
		try {
			i = 0;
			while (retorn.next()) {
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<String> consultarNoms() {
		ResultSet retorn;
		String consultaSQL = "SELECT Nom FROM centre;";
		List<String> dades = new ArrayList<String>();
		try {
			retorn = gestorDB.consultaRegistres(consultaSQL);
			while (retorn.next()) {
				dades.add(retorn.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Error consulta noms" + e.toString());
		}
		return dades;
	}

	public int consultarRegNom(String nom) {
		ResultSet retorn;
		int i = 0;
		String consultarid = "SELECT Nom FROM centre WHERE Nom LIKE '" + nom + "';";

		try {
			retorn = gestorDB.consultaRegistres(consultarid);

			while (retorn.next()) { // ERROR NULL
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int donarBaixa(String nom) {
		int i = 0;
		sentenciaSQL = "DELETE FROM centre WHERE Nom LIKE '" + nom + "';";
		i = gestorDB.modificarRegistre(sentenciaSQL);
		return i;
	}

	public ResultSet consultarCentres() {
		String consultaSQL = "SELECT * FROM centre";
		return gestorDB.consultaRegistres(consultaSQL);
	}

}
