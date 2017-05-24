package presentacio;

import java.util.List;
import java.util.Scanner;

import model.AlumneDAO;
import model.CentreDAO;
import model.TutorDAO;
import model.UsuariDAO;

public class MantenimentAlumne {
	private Scanner in = new Scanner(System.in);
	private AlumneDAO aDAO = new AlumneDAO();
	private UsuariDAO uDAO = new UsuariDAO();
	private TutorDAO tDAO = new TutorDAO();
	private CentreDAO cDAO = new CentreDAO();
	
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
		String nif, pw, nom, cognom1, cognom2, alta, mail, inici, fi, id1, id2;
		List<Integer> llistaTutors = tDAO.consultaIDTutor();
		List<Integer> llistaCentres = cDAO.consultaIDCentre();

		int idcentre=0, idtutor=0;
		boolean correcte = false;
		in.nextLine();
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
		System.out.print("ID del tutor "+llistaTutors+": ");
		id1 = in.nextLine();
		System.out.print("ID del centre "+llistaCentres+": ");
		id2 = in.nextLine();

		do{ 				// xxxx-xx-xx
			System.out.print("Data inici (yyyy-mm-dd): ");
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
			System.out.print("Data final (yyyy-mm-dd): ");
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
		
		idcentre = Integer.parseInt(id2);
		idtutor = Integer.parseInt(id1);
				
		uDAO.altaUsuari(nif, pw, cognom2, cognom1, cognom2, mail);
		aDAO.altaAlumne(inici, fi, idtutor, idcentre, nif);
		
		
	}
	
	public void altraOperacio() {
		String opc;
		System.out.print("\nVols fer una altra operacio? (s/n): ");
		opc = in.nextLine();
		switch (opc) {
		case "s":case "S":case "si":case "Si":case "SI":case "sI":
			System.out.println("------------------------------------------------------------------------");
			this.menuAlumne();
			break;
		case "n":case "N":case "no":case "No":case "NO":case "nO":
			System.out.println("Fins una altra!");
			break;
		default:
			System.out.println("Opció incorrecta, sortint...");
		}

	}

	
	public void baixaAlumne(){
		List<String> llista = aDAO.consultaIDAlumne();
		int id;
		System.out.println("--------------------------");
		for(int i=0; i<llista.size(); i++){
			System.out.println(llista.get(i));
		}
		System.out.print("Quin alumne vols donar de baixa? (id): ");
		id = in.nextInt();
		aDAO.baixaAlumne(id);
		in.nextLine();
		this.altraOperacio();
	}

	
	public void consultaAlumnes() {
		Object[] obj = aDAO.consultaAlumnes();
		int linies = obj.length / (obj.length / 2);
		System.out.println("ID\tNOM\tCOGNOM\tINICI\t\tFINAL\t\tCENTRE\tID TUTOR");
		System.out.println("------------------------------------------------------------------------");
		for (int l = 0; l < obj.length; l++) {
			if (l % 7 == 0 && l != 0) {
				System.out.println();
			}
			System.out.print(obj[l] + "\t");
		}
		System.out.println("\n------------------------------------------------------------------------");
		in.nextLine();
		this.altraOperacio();
	}
}
