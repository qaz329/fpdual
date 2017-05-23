package presentacio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controlador.Constants;
import controlador.GestorDB;
import model.TutorDAO;
import model.UsuariDAO;

public class MantenimentTutors {
	GestorDB GDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	UsuariDAO u=new UsuariDAO();
	TutorDAO t=new TutorDAO();
	boolean opcio=false;
	String consultaSQL;
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	
	public MantenimentTutors(){
		super();
	}
	
	public void opcions(){
		String consulta="";
		int opcio = 0;
		boolean sortir=false;
		try {
			do{
				System.out.println("Quina opció vols realitzar? ");
				System.out.println("1.-Alta");
				System.out.println("2.-Baixa");
				System.out.println("3.-Llistat");
				System.out.println("4.-Sortir");
				consulta=br.readLine();
				opcio=Integer.parseInt(consulta);
				switch(opcio){
				case 1:
					alta();
					break;
					
				case 2:
					baixa();
					break;
			
				case 3:
					break;
				
				case 4:
					sortir=true;
					break;
				}
				
			}while(!sortir);
			
		}catch (IOException e) {
		System.out.println("Error introduir opcio "+e.toString());
		}
	}
	
	public void alta(){
		String nif;
		String pass;
		String nom;
		String pCog;
		String sCog;
		String mail;
		String tecno;
		boolean correcte=false;
		try {
			do{
				System.out.print("Introdueix el NIF de l'usuari a crear (8 numeros i 1 lletra): ");
				nif=br.readLine();
				correcte=true;
				if(nif.length()<9 || nif.length()>9){
					System.out.println("NIF no vàlid");
					correcte=false;
				}else if(!Character.isLetter(nif.charAt(8))){
					System.out.println("NIF no vàlid");
					correcte=false;
				}
			}while(!correcte);
			System.out.print("Introdueix la password per a l'usuari: ");
			pass=br.readLine();
			
			System.out.print("Introdueix el nom de l'usuari: ");
			nom=br.readLine();
			
			System.out.print("Introdueix el primer cognom de l'usuari: ");
			pCog=br.readLine();
			
			System.out.print("Introdueix el segon cognom de l'usuari: ");
			sCog=br.readLine();
			
			System.out.print("Introdueix el mail de l'usuari: ");
			mail=br.readLine();
			
			u.altaUsuari(nif, pass, nom, pCog, sCog, mail);
			System.out.println("Alta usuari realitzada.");
			
			System.out.println("Introdueix la tecnologia del tutor a afegir: ");
			tecno=br.readLine();
			
			t.altaTutor(tecno);
			
		} catch (IOException e) {
		System.out.println("Error Alta "+e.toString());
		}
	}
	
	public void baixa(){
		System.out.println("");
	}
	
}
