package presentacio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
				System.out.println("\nQuina opció vols realitzar? ");
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
					llistat();
					break;
				
				case 4:
					sortir=true;
					break;
				default:
					System.out.println("Tens que triar una de les 4 opcions.");
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
				}else{
					for(int i=0;i<8;i++){
						if(!Character.isDigit(nif.charAt(i))){
							correcte=false;
						}
					}
					if(correcte==false){
						System.out.println("NIF no vàlid");
					}
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
			t.altaTutor(nif,tecno);
			
		} catch (IOException e) {
		System.out.println("Error Alta "+e.toString());
		}
	}
	
	public void baixa(){
		String nif;
		int id;
		try {
			System.out.println("Introdueix el NIF del tutor a donar de baixa: ");
			nif=br.readLine();
			id=u.consultaID(nif);
			t.baixaTutor(id);
			System.out.println("Baixa realitzada");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public void llistat(){
		List<String>llista=new ArrayList<String>();
		llista=t.consultaTutor();
		System.out.println("ID\tTecno\tNom\tNIF");
		System.out.println("----------------------------------------");
		for(int i=0;i<llista.size();i++){
			System.out.println(llista.get(i));
		}
		//System.out.println(llista);
	}
	
}
