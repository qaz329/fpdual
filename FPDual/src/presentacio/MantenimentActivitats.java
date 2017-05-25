package presentacio;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controlador.Constants;
import controlador.GestorDB;
import model.ActivitatDAO;

public class MantenimentActivitats {
	
	private GestorDB gestordb = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	private int opcio;
	private String sentenciaSQL=null;
	private ActivitatDAO act = new ActivitatDAO();
	private Scanner sc = new Scanner(System.in);
	
	public void Activitats() {
		boolean sortir=false;
		do{
			System.out.println("\nMenu de manteniment d'Activitats\n");
			System.out.println("\t1.- Alta");
			System.out.println("\t2.- Baixa");
			System.out.println("\t3.- Llistat");
			System.out.println("\t4.- Sortir");
			System.out.print("\nSelecciona una opció: ");
			
			opcio = sc.nextInt();
			switch(opcio){
			case 1:
				Alta();
				break;
			case 2:
				Baixa();
				break;
			case 3:
				Llistat();
				break;
			case 4:
				System.out.println("Ha sortit del manteniment d'activitats.");
				sortir = true;
				break;
			default:
				System.out.println("Has de triar una opció entre 1-4\n");
			}
		}while(!sortir);

	}

	private void Llistat() {
		List<String> Activitats = new ArrayList<String>();
		Activitats = act.llistaActivitat();
		int i;
		System.out.println("\n-------------------------------------");
		System.out.println("ID\tCodi\tDescripció");
		
		for(i=0;i<Activitats.size();i++)
			System.out.println(Activitats.get(i));
		System.out.println("-------------------------------------");
	}

	private void Baixa() {
		int id=0;
		InputStreamReader isr1 = new InputStreamReader(System.in);
		BufferedReader br1 = new BufferedReader(isr1);
		try {
			System.out.println("ID's: "+act.consultarID());
			System.out.print("\nSelecciona l'ID de l'activitat a donar de baixa: ");
			id=Integer.parseInt(br1.readLine());
			act.baixaActivitat(id);
		} catch (IOException e) {
			System.err.println("Error en la baixa "+e.toString());
		}
	}

	private void Alta() {
		String codi="";
		String desc="";
		int id=0;
		List<Integer> dades = new ArrayList<Integer>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try{
			System.out.println("Introdueix el codi de l'activitat(Ex: Excursio->EXC1): ");
			codi = br.readLine();
			System.out.println("Introdueix una descripció de l'activitat: ");
			desc = br.readLine();
			act.altaActivitat(codi, desc);
			dades=act.otorgarID();
			id=dades.get(0);
			System.out.println("ID otorgat: "+id);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
