/**
 * 
 */
package model;

/**
 * @author sven
 *
 */
public class Student extends Person {

	private int matrikelNr;
	/**
	 * @param name
	 * @param addresse
	 */
	public Student(String name, String addresse, String photo, int matrikelNr) {
		super(name, addresse, photo);
		this.matrikelNr = matrikelNr;
	}
	
	@Override
	public String toString() {
		return "Student: "+ getName() + "; Matrikel: "+matrikelNr;
	}

}
