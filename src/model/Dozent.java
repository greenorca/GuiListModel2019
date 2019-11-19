/**
 * 
 */
package model;

/**
 * 
 * @author sven
 *
 */
public class Dozent extends Personal {

		private int gehalt;
	/**
	 * @param name
	 * @param addresse
	 */
	public Dozent(String name, String addresse, String photo, int gehalt) {
		super(name, addresse, photo);
		this.gehalt = gehalt;
	}
	
	@Override
	public String toString() {
		return "Dozent: "+ getName();
	}

	/**
	 * @return the gehalt
	 */
	public int getGehalt() {
		return gehalt;
	}

	/**
	 * @param gehalt the gehalt to set
	 */
	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}

}
