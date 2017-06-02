package presentacio;

import java.util.Scanner;

import model.UsuariDAO;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		UsuariDAO uDAO = new UsuariDAO();
		String nif = "", pw = "";
		int correcte = 0;
		do {
			correcte = 0;
			System.out.print("NIF: ");
			nif = in.nextLine();
			if (nif.length() == 9) {
				int i = 0;
				Object[] obj = uDAO.consultaNifs(nif);
				while (0 == correcte && i < obj.length) {
					if (nif.equals(obj[i])) {
						System.out.print("Password: ");
						pw = in.nextLine();
						if (!uDAO.iniciSessio(nif, pw)) {
							System.out.println("PW INCORRECTE");
							correcte = 1;
						} else {
							correcte = 2;
							System.out.println("Benvingut al sistema de registre d’hores");

						}
					}
					i++;
				}
				if (correcte == 0 && i == obj.length) {
					System.out.println("No hi ha el NIF");
				}
			} else {
				System.out.println("NIF no v�lid");
				correcte = 0;
			}
		} while (correcte == 0 || correcte == 1);

		opcionsCase();

	}

	public static void opcionsCase() {
		boolean correcte2 = true;
		MantenimentCentres mantenimentCentres = new MantenimentCentres();
		MantenimentAlumne mantenimentAlumne = new MantenimentAlumne();
		MantenimentTutors mantenimentTutors = new MantenimentTutors();
		MantenimentActivitats mantenimentActivitats = new MantenimentActivitats();

		int opcio = 0;

		System.out.println("1.- Manteniment de Centres.'Sisco'");
		System.out.println("2.- Manteniment d'Alumnes.'Joan'");
		System.out.println("3.- Manteniment de Tutors.'Sergi'");
		System.out.println("4.- Manteniment d'Activitats.'Thiago'");
		System.out.println("5.- Tancar Aplicacio");
		do {
			opcio = in.nextInt();

			switch (opcio) {
			case 1:
				System.out.println("Opció 1 triada");
				mantenimentCentres.FormulariCentres();
				break;
			case 2:
				System.out.println("Opció 2 triada");
				in.nextLine();
				mantenimentAlumne.menuAlumne();
				break;
			case 3:
				System.out.println("Opció 3 triada");
				mantenimentTutors.opcions();
				break;
			case 4:
				System.out.println("Opció 4 triada");
				mantenimentActivitats.Activitats();
				break;

			case 5:
				System.out.println("Opció 5 triada. Tancant l'Aplicació...");
				correcte2 = true;
				break;

			default:
				System.out.println("Has de triar una de les 5 opcions.");
				break;
			}
		} while (correcte2 == false);

	}

}
