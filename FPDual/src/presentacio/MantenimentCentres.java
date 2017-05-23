package presentacio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Constants;
import controlador.GestorDB;

public class MantenimentCentres {
	GestorDB GDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);

	boolean correcte = true;
	int opcio = 0, idcentre = 0, codi = 0, telefon = 0, sortir = 0, i = 0;
	String nom = null, triar, web = null, sentenciaSQL = null, operacio;

	InputStreamReader isr0 = new InputStreamReader(System.in);
	BufferedReader br0 = new BufferedReader(isr0);

	public MantenimentCentres() {

	}

	public void FormulariCentres() {

		do {
			sortir = 0;
			System.out.println("Menu de Manteniment de Centres.");
			System.out.println("\t1.- Alta");
			System.out.println("\t2.- Baixa");
			System.out.println("\t3.- Llistat");
			System.out.println("\t4.- Sortir");
			System.out.println("Selecciona una opcio:");
			try {
				opcio = Integer.parseInt(br0.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (opcio) {
			case 1:
				correcte = true;
				opcio1();
				break;

			case 2:
				correcte = true;
				opcio2();
				break;

			case 3:
				correcte = true;
				opcio3();
				break;

			case 4:
				System.out.println("Adeu!");
				sortir = 1;
				break;

			default:
				System.out.println("Tens que triar una de les 4 opcions.");
				correcte = false;
				break;
			}
			if (sortir == 0) {
				System.out.println("Vols realitzar alguna altra operacio? 'si'/'no'");

				try {
					operacio = br0.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Altra operacio : " + operacio);
			}
		} while (operacio.equals("si"));

		System.out.println("Adeu!");

	}

	private void opcio1() {
		System.out.println("Opcio 'ALTA'");
		ResultSet retorn;
		int hies = 0;
		String comprova = "";
		boolean enters = false;

		System.out.print("Vols entrar 'en' una ID o vols que sigui automatica 'au' ? ");

		try {
			triar = br0.readLine();

			do {

				if (triar.equals("en")) {
					System.out.print("Entra la ID del Centre: ");
					do {
						comprova = br0.readLine();
						enters = MantenimentCentres.isNumeric(comprova);
						if (enters) {
							idcentre = Integer.parseInt(comprova);
							String consultarid = "SELECT * FROM centre WHERE Id_centre LIKE " + idcentre + ";";
							retorn = GDB.consultaRegistres(consultarid);
							try {
								i = 0;
								while (retorn.next()) {
									i++;
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println("Nomes pots entrar Numeros Enters.");
						}
					} while (!enters);

				}

				if (i == 0) {
					hies = 1;
					System.out.print("Entra El Nom del Centre: ");

					nom = br0.readLine();

					do {
						System.out.print("Entra el Codi del Centre: ");
						comprova = br0.readLine();
						enters = MantenimentCentres.isNumeric(comprova);
						if (enters) {
							codi = Integer.parseInt(comprova);
						} else {
							System.out.println("Nomes pots entrar Numeros Enters.");
						}
					} while (!enters);

					do {
						System.out.print("Entra el Telefon del Centre: ");
						comprova = br0.readLine();
						enters = MantenimentCentres.isNumeric(comprova);
						if (enters) {
							telefon = Integer.parseInt(comprova);
						} else {
							System.out.println("Nomes pots entrar Numeros Enters.");
						}
					} while (!enters);
					System.out.print("Entra la Web del Centre: ");

					web = br0.readLine();

					correcte = true;

					if (triar.equals("en")) {
						sentenciaSQL = "INSERT INTO centre (Id_centre, Nom, Codi, Telefon, Web) " + "VALUES(" + idcentre
								+ ", '" + nom + "', " + codi + ", " + telefon + ", '" + web + "');";
						GDB.modificarRegistre(sentenciaSQL);
						System.out.println("Alta realitzada correctament Amb ID.");

					}
					if (triar.equals("au")) {
						sentenciaSQL = "INSERT INTO centre (Nom, Codi, Telefon, Web) " + "VALUES('" + nom + "', " + codi
								+ ", " + telefon + ", '" + web + "');";
						GDB.modificarRegistre(sentenciaSQL);
						System.out.println("Alta realitzada correctament Sense ID.");

					}
				} else {
					System.out.println();
					System.out.println("La ID que a introduit ja existeix, tria'n una de diferent.");
					System.out.println();
					hies = 0;
				}

			} while (hies == 0);

		} catch (

		IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void opcio2() {
		System.out.println("Opcio 'BAIXA'");
		ResultSet retorn;
		boolean correcte = false;
		int cont = 0;

		do {
			try {

				String consultarid = "SELECT Nom FROM centre;";
				retorn = GDB.consultaRegistres(consultarid);

				System.out.println("Centres Actuals:");
				System.out.print("\t");
				try {
					while (retorn.next()) {
						System.out.print(retorn.getString(1) + ", ");
						cont++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("\tHi ha un total de " + cont + " centres.");
				System.out.println();

				System.out.print("Entra El Nom del Centre a fer la BAIXA: ");
				nom = br0.readLine();

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// -----------------------------------------------------------------------
			System.out.println("nom: " + nom);

			String consultarid = "SELECT Nom FROM centre WHERE Nom LIKE " + nom + ";";
			retorn = GDB.consultaRegistres(consultarid);

			i = 0;
			// s

			try {
				while (retorn.next()) { // ERROR NULL
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (i == 0) {
				System.out.println("El nom no es troba a la BDD.");
				correcte = false;
			} else {
				correcte = true;
				System.out.println("Les dades entrades son: ");
				System.out.println("Nom: " + nom);
				sentenciaSQL = "DELETE FROM centre WHERE Nom LIKE '" + nom + "';";
				GDB.modificarRegistre(sentenciaSQL);
				System.out.println("Baixa realitzada correctament.");
			}
		} while (!correcte);

		// -----------------------------------------------------------------------

	}

	private void opcio3() {
		System.out.println("Opcio 'LLISTAT'");
		sentenciaSQL = "SELECT * FROM centre";
		ResultSet rs = GDB.consultaRegistres(sentenciaSQL);
		try {
			System.out.println("id \t\tNom \t\tCodi \t\tTelefon \t\tWeb");
			while (rs.next()) {
				for (int i = 1; i <= 5; i++) {
					if (i > 1)
						System.out.print(" \t\t");
					String columnValue = rs.getString(i);
					System.out.print(columnValue);
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
