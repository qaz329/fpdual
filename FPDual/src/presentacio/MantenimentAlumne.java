package presentacio;

import java.util.Date;
import java.util.Scanner;

import model.AlumneDAO;

public class MantenimentAlumne {
	Scanner in = new Scanner(System.in);
	AlumneDAO aDAO = new AlumneDAO();
	
	public void menuAlumne(){
		int opc;
		System.out.println("1 - Alta");
		System.out.println("2 - Baixa");
		System.out.println("3 - Llistat");
		System.out.println("Selecciona una opció: ");
		opc = in.nextInt();
		switch(opc){
		case 1:
			altaAlumne();
			break;
		case 2:
			baixaAlumne();
			break;
		case 3:
			consultaAlumnes();
			break;
		default:
		}
	}
	
	public void altaAlumne(){
		String nif, pw, nom, cognom1, cognom2, alta, mail, inici, fi;
		boolean correcte = false;
		System.out.print("NIF: ");
		nif = in.nextLine();
		System.out.print("Nom: ");
		nom = in.nextLine();
		System.out.print("Primer cognom: ");
		cognom1 = in.nextLine();
		System.out.print("Segon cognom: ");
		cognom2 = in.nextLine();
		System.out.print("Contrassenya: ");
		pw = in.nextLine();
		System.out.print("e-Mail: ");
		mail = in.nextLine();
		do{ 				// xxxx-xx-xx
			System.out.print("Data inici: ");
			inici = in.nextLine();
			if(inici.length()==10){
				if(inici.charAt(4)=='-' && inici.charAt(7)=='-'){
					if(Character.isDigit(inici.charAt(0))){
						if(Character.isDigit(inici.charAt(1))){
							if(Character.isDigit(inici.charAt(2))){
								if(Character.isDigit(inici.charAt(3))){
									if(Character.isDigit(inici.charAt(5))){
										if(Character.isDigit(inici.charAt(6))){
											if(Character.isDigit(inici.charAt(8))){
												if(Character.isDigit(inici.charAt(9))){
													correcte = true;
												}else{
													correcte = false;
												}
											}else{
												correcte = false;
											}
										}else{
											correcte = false;
										}
									}else{
										correcte = false;
									}
								}else{
									correcte = false;
								}
							}else{
								correcte = false;
							}
						}else{
							correcte = false;
						}
					}else{
						correcte = false;
					}
				}else{
					correcte = false;
				}
			}else{
				correcte = false;
			}
		}while(!correcte);
		do{ 				// xxxx-xx-xx
			System.out.print("Data final: ");
			fi = in.nextLine();
			if(fi.length()==10){
				if(fi.charAt(4)=='-' && fi.charAt(7)=='-'){
					if(Character.isDigit(fi.charAt(0))){
						if(Character.isDigit(fi.charAt(1))){
							if(Character.isDigit(fi.charAt(2))){
								if(Character.isDigit(fi.charAt(3))){
									if(Character.isDigit(fi.charAt(5))){
										if(Character.isDigit(fi.charAt(6))){
											if(Character.isDigit(fi.charAt(8))){
												if(Character.isDigit(fi.charAt(9))){
													correcte = true;
												}else{
													correcte = false;
												}
											}else{
												correcte = false;
											}
										}else{
											correcte = false;
										}
									}else{
										correcte = false;
									}
								}else{
									correcte = false;
								}
							}else{
								correcte = false;
							}
						}else{
							correcte = false;
						}
					}else{
						correcte = false;
					}
				}else{
					correcte = false;
				}
			}else{
				correcte = false;
			}
		}while(!correcte);
		
		
		
		
		
		
		
		
	}
	
	public void baixaAlumne(){
		
	}
	
	public void consultaAlumnes(){
		
	}
}
