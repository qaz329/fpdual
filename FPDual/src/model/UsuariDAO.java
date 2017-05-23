package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Constants;
import controlador.GestorDB;

public class UsuariDAO {

	GestorDB gestorDB;
	
	public UsuariDAO(){
		gestorDB = new GestorDB(Constants.SERVER, Constants.PORT, Constants.BD);
	}
	
	public boolean iniciSessio(String nif, String pw){
		try {
			ResultSet rs = null;
			String consultaSQL = "SELECT * FROM usuari WHERE NIF='"+nif+"' AND password='"+pw+"'";
			rs = gestorDB.consultaRegistres(consultaSQL);
			
			if(rs.first()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void altaUsuari(Usuari u){
		String consultaSQL="INSERT INTO Usuari VALUES(Id_usuari,'"+u.getNIF()+"','"+u.getPasswd()+"','"
															+u.getNom()+"','"+u.getPrimer_cognom()+"','"
															+u.getSegon_cognom()+"','"+u.getData_alta()+"','"+u.getMail()+"');";
		try {
			gestorDB.modificarRegistre(consultaSQL);
		} catch (SQLException e) {
			System.out.println("Error insert usuari "+e.toString());
		}
	}
	
	public Object[] consultaNifs(String nif){
		ResultSet rs = null;
		String consultaSQL = "SELECT NIF FROM usuari";
		rs = gestorDB.consultaRegistres(consultaSQL);
		ArrayList<Object> fila = new ArrayList<>();
		int i=0;
		try{
			while(rs.next()){
				for(i=0; i<1; i++){
					fila.add(rs.getObject(i+1));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return fila.toArray();
	}
}
