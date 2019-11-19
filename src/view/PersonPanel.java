/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import model.Person;
/**
 * @author sven
 * http://zetcode.com/java/imageicon/
 */
public class PersonPanel extends JPanel {
	Person person;
	private JLabel lblName;
	private JLabel lblAddress;
	private ImagePanel img;
	private JLabel lblTyp;
	
	/**
	 * custom panel derivate with picture
	 * @author sven
	 *
	 */
	class ImagePanel extends JPanel{
		
		ImageIcon icon;
		String fileName;
			
		public ImagePanel(String file) {
			super();
			loadImage(this.fileName);
	        initPanel();
	        setMinimumSize(new Dimension(300, 120));
	    }

	    public void loadImage(String file) {
	    	//https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon#18335435
	    	this.fileName = file;
	    	ImageIcon tIcon = new ImageIcon(fileName); 
	    	Image img = tIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
	        icon = new ImageIcon(img);
	    }
	    
	    private void initPanel() {
	        //setPreferredSize(new Dimension(300, 300));
	    }    

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        icon.paintIcon(this, g, 0, 0);
	    }	
		
	}
	
	public PersonPanel(Person p) {
		super();
		
		if ( p != null) {
			person = p;
		}
		else {
			System.out.println("nobody home. create dummy person");
			person = new Person("","","resources/nobody.png");
		}
		setBorder(new CompoundBorder(null, new EmptyBorder(10, 10, 10, 10)));
		setLayout(new BorderLayout());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(0, 2));
		infoPanel.add(new JLabel("Typ"));
		lblTyp = new JLabel(person.getClass().getSimpleName());
		infoPanel.add(lblTyp);
		infoPanel.add(new JLabel("Name"));
		lblName = new JLabel(person.getName());
		infoPanel.add(lblName);
		infoPanel.add(new JLabel("Adresse"));
		lblAddress = new JLabel(person.getAddresse());
		infoPanel.add(lblAddress);
		infoPanel.setMinimumSize(new Dimension(400,60));
		this.add(infoPanel, BorderLayout.NORTH);
		
		try {
			img = new ImagePanel(person.getPhoto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.add(img, BorderLayout.CENTER);
		
	}
		
	public void setPerson(Person person) {
		this.person = person;
		lblTyp.setText(person.getClass().getSimpleName());
		lblName.setText(person.getName());
		lblAddress.setText(person.getAddresse());
		img.loadImage(person.getPhoto());
		System.out.println("new person set: "+person);
		this.repaint();
	}
}
