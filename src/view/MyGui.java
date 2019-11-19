package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.AdminPersonal;
import model.Dozent;
import model.Person;
import model.Student;

import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import javax.swing.JTextField;

/**
 * GUI demo for filtered custom data container
 * @author sven
 *
 */
public class MyGui extends JFrame {

	private JPanel contentPane;
	private JList<Person> list;
	private DefaultListModel allePersonenModell;
	private JLabel lblFilter;
	private JComboBox<String> comboBox;
	private PersonPanel infoPanel;
	private JTextField textField;
	private JButton btnFiltern;
	private JLabel lblSuchstringname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGui frame = new MyGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Generiere");
	
		panel.add(btnNewButton);
		
		lblFilter = new JLabel("Filter");
		panel.add(lblFilter);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Alle", "Studenten", "Personal", "Dozenten"}));
		
		panel.add(comboBox);
		
		lblSuchstringname = new JLabel("Suchstring");
		panel.add(lblSuchstringname);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		btnFiltern = new JButton("Filtern");
		
		panel.add(btnFiltern);
		
		allePersonenModell = new DefaultListModel();
		
		list = new JList<Person>(allePersonenModell);
		list.addListSelectionListener(new ListSelectionListener() {			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("selection changed");
				infoPanel.setPerson((Person)list.getSelectedValue());				
			}
		});
		
		JScrollPane scrolly = new JScrollPane();
		scrolly.setViewportView(list);
		contentPane.add(scrolly, BorderLayout.WEST);
		
		infoPanel = new PersonPanel((Person)list.getSelectedValue());
		contentPane.add(infoPanel, BorderLayout.CENTER);
		
		setTitle("GUI Basteleien");
		
	}
	
	private void fillDummyData() {
		String[] studenten = {"Hans Heiri","Max Muster","Lars Lustig", "Dieter Durstig","Nora Nerdig"};
		int matr = 121;
		for (String student : studenten )
			allePersonenModell.addElement(new Student(student,"", "resources/"+student.split(" ")[0].toLowerCase()+".png", matr++));
		
		String[] dozenten = {"Marlis Mässig", "Dirk Dunkel","Daniel Dürftig", "Willi Würfel"};
		for (String doz : dozenten)
			allePersonenModell.addElement(new Dozent(doz,"", "resources/darth.png", 4000));
		
		String[] admins = {"Möp Möp", "Mip Mip","Mup Mup", "Mää Mää"};
		for (String ad : admins)
			allePersonenModell.addElement(new AdminPersonal(ad,"", "resources/me.jpg", 6000));
		
		comboBox.setSelectedIndex(0);
	}

}
