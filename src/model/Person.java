/**
 * 
 */
package model;

/**
 * @author sven
 *
 */
public class Person {
	private String name;
	private String photo;
	private String addresse;
 	
	/**
	 * @param name
	 * @param addresse
	 */
	public Person(String name, String addresse, String photo) {
		this.name = name;
		this.addresse = addresse;
		this.photo = photo;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the addresse
	 */
	public String getAddresse() {
		return addresse;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getPhoto() {
		// TODO Auto-generated method stub
		return photo;
	}
	
}
