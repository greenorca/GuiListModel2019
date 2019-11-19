package model;

public class AdminPersonal extends Personal {

	int gehalt;
	
	public AdminPersonal(String name, String addresse, String photo, int gehalt) {
		super(name, addresse, photo);
		// TODO Auto-generated constructor stub
		this.gehalt = gehalt;
	}

}
