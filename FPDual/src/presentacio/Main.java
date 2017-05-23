package presentacio;

import java.util.Scanner;

import model.UsuariDAO;

public class Main {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		UsuariDAO uDAO = new UsuariDAO();
		String nif="", pw="";
		int correcte = 0;
		do{
			correcte=0;
			System.out.print("NIF: ");
			nif = in.nextLine();
			if(nif.length()==9){
				int i=0;
				Object[] obj = uDAO.consultaNifs(nif);
				while(correcte==0 && i<obj.length){
					if(nif.equals(obj[i])){
						System.out.print("Password: ");
						pw = in.nextLine();
						if(!uDAO.iniciSessio(nif, pw)){
							System.out.println("PW INCORRECTE");
							correcte=1;
						}else{
							correcte=2;
							System.out.println("Benvingut al sistema de registre d’hores");
							
						}
					}i++;
				}
				if(correcte==0 && i==obj.length){
					System.out.println("No hi ha el NIF");
				}
			}else{
				System.out.println("NIF no v�lid");
				correcte=0;
			}			
		}while(correcte==0 || correcte==1);
		
		
		opcionsCase();

	}
		
		private static void opcionsCase() {
			boolean correcte2 = true;
			MantenimentCentres MC = new MantenimentCentres();
			MantenimentAlumne ma = new MantenimentAlumne();
			MantenimentTutors mt=new MantenimentTutors();

			int opcio = 0;

			System.out.println("1.- Manteniment de Centres.'Sisco'");
			System.out.println("2.- Manteniment de Alumnes.'Joan'");
			System.out.println("3.- Manteniment de Tutors.'Sergi'");
			System.out.println("4.- Manteniment de Activitats.'Thiago'");
			System.out.println("5.- Tancar Aplicacio");
			do {
				opcio = in.nextInt();
				
				switch (opcio) {
				case 1:
					System.out.println("Opcio 1 triada");
					MC.FormulariCentres();
					break;
				case 2:
					System.out.println("Opcio 2 triada");
					break;
				case 3:
					System.out.println("Opcio 3 triada");
					mt.opcions();
					break;
				case 4:
					System.out.println("Opcio 4 triada");
					break;

				case 5:
					System.out.println("Opcio 5 triada. Tancant Aplicacio...");
					correcte2 = true;
					break;

				default:
					System.out.println("Tens que triar una de les 5 opcions.");
					break;
				}
			} while (correcte2 == false);
			// GDB.tancarConnexio();
		
				
		}
		
}
	
	


