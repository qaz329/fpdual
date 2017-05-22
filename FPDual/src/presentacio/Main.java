package presentacio;

import java.util.ArrayList;
import java.util.Scanner;

import model.UsuariDAO;

public class Main {

	public static void main(String[] args) {
		UsuariDAO uDAO = new UsuariDAO();
		Scanner in = new Scanner(System.in);
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
				System.out.println("NIF no vàlid");
				correcte=0;
			}			
		}while(correcte==0 || correcte==1);
		System.out.println("MENU");
		System.out.println("1 - Manteniment de centres");
		System.out.println("2 - Manteniment d'alumnes");
		System.out.println("3 - Manteniment de tutors");
		System.out.println("4 - Manteniment d'activitats test");
				
		in.close();
		
	}

}
