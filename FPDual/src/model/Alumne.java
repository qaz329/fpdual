package model;

public class Alumne extends Usuari {

	private int idAlumne;
	private String dataInici;
	private String dataFi;
	Centre centre;
	Tutor tutor;
		
	public Alumne() {
		super();
	}
	
	public Alumne(Usuari u, String dataInici, String dataFi, Centre centre, Tutor tutor) {
		super(u.getNIF(), u.getPasswd(), u.getNom(), u.getCognom1(), u.getCognom2(), u.getMail());

		this.dataInici = dataInici;
		this.dataFi = dataFi;
		this.centre = centre;
		this.tutor = tutor;
	}
	
	public int getIdAlumne() {
		return idAlumne;
	}
	public void setIdAlumne(int idAlumne) {
		this.idAlumne = idAlumne;
	}
	public int getIdUsuari(){
		return super.getIdUsuari();
	}
	public String getDataInici() {
		return dataInici;
	}
	public void setDataInici(String dataInici) {
		this.dataInici = dataInici;
	}
	public String getDataFi() {
		return dataFi;
	}
	public void setDataFi(String dataFi) {
		this.dataFi = dataFi;
	}
	public Centre getCentre() {
		return centre;
	}
	public void setCentre(Centre centre) {
		this.centre = centre;
	}
	public Tutor getTutor() {
		return tutor;
	}
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	
}
