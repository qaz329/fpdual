package presentacio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controlador.Constants;
import controlador.GestorDB;

public class MantenimentTutors {
	GestorDB GDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	boolean opcio=false;
	String consultaSQL;
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(isr);
	
	public MantenimentTutors(){
		super();
	}
	
	public void opcions(){
		System.out.println("Quina opció vols realitzar? ");
		System.out.println("1.-Alta");
		System.out.println("2.-Baixa");
		System.out.println("3.-Llistat");
		System.out.println("4.-Sortir");
		String consulta="";
		int opcio = 0;
		try {
			consulta=br.readLine();
			opcio=Integer.parseInt(consulta);
		} catch (IOException e) {
			System.out.println("Error introduir opcio "+e.toString());
		}
		switch(opcio){
		case 1:
			alta();
		}
	}
	
	public void alta(){
		String nif;
		String pass;
		String nom;
		String pCog;
		String sCog;
		String data;
		String mail;
		boolean correcte=false;
		try {
			do{
				System.out.print("Introdueix el NIF de l'usuari a crear (8 numeros i 1 lletra): ");
				nif=br.readLine();
				correcte=true;
				if(nif.length()<9 || nif.length()>9){
					System.out.println("NIF no vàlid");
					correcte=false;
				}else if(!Character.isLetter(nif.charAt(9))){
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
			correcte=false;
			do{
				int i = 0;
				System.out.print("Introdueix la data (Any-mes-dia): ");
				data=br.readLine();
				correcte=true;
				if(data.length()>10 || data.length()<10){
					correcte=false;
					System.out.println("Data no valida.");
				}else if(!Character.isLetter(data.charAt(4)) || !Character.isLetter(data.charAt(7))){
					correcte=false;
					System.out.println("Data no valida. ");
					i=Integer.parseInt(data.substring(5, 6));
				}else{
					for(int c=0;c<3;c++){
						if(Character.isLetter(data.charAt(c))){
							correcte=false;
						}
					}
					for(int c=5;c<6;c++){
						if(Character.isLetter(data.charAt(c))){
							correcte=false;
						}
					}
					for(int c=8;c<9;c++){
						if(Character.isLetter(data.charAt(c))){
							correcte=false;
						}
					}
				}
			}while(!correcte);
			System.out.print("Introdueix el mail de l'usuari: ");
			mail=br.readLine();
			
			consultaSQL="INSERT INTO usuari VALUES(Id_usuari,'"+nif+"','"+pass+"','"+nom+"','"+pCog+"','"+sCog+"','"+data+"','"+mail+"');";
			
	} catch (IOException e) {
		System.out.println("Error Alta"+e.toString());
	}
			
			
	}
	
}
