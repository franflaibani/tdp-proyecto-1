package gui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 30, 5));
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		init();
		setVisible(true);
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 186);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		contentPane.add(tabbedPane);
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/tdp.png"));
		setIconImage(icon.getImage());
		
		// Initialize labels
		JLabel LULabel = new JLabel("LU");
		LULabel.setBounds(10, 22, 80, 14);
		tabInformation.add(LULabel);
		
		JLabel LastNameLabel = new JLabel("Apellido");
		LastNameLabel.setBounds(10, 47, 80, 14);
		tabInformation.add(LastNameLabel);
		
		JLabel NameLabel = new JLabel("Nombre");
		NameLabel.setBounds(10, 72, 80, 14);
		tabInformation.add(NameLabel);
		
		JLabel EmailLabel = new JLabel("E-mail");
		EmailLabel.setBounds(10, 97, 80, 14);
		tabInformation.add(EmailLabel);
		
		JLabel GithubURLLabel = new JLabel("Github URL");
		GithubURLLabel.setBounds(10, 122, 80, 14);
		tabInformation.add(GithubURLLabel);
		
		JLabel DateLabel = new JLabel("");
		DateLabel.setBounds(5, 193, 430, 17);
		contentPane.add(DateLabel);
		
		// Initialize date
		LocalTime timeNow = LocalTime.now();
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate dateToday = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
		DateLabel.setText("Esta ventana fue generada el "+ dateToday.format(dateFormat)+" a las "+timeNow.format(timeFormat));
		
		// Initialize photo
		JLabel pictureLabel = new JLabel();
		pictureLabel.setBounds(445, 34, 140, 150);
		contentPane.add(pictureLabel);
		try{
			BufferedImage img = ImageIO.read(getClass().getClassLoader().getResource(studentData.getPathPhoto()));
			Image dimg = img.getScaledInstance(pictureLabel.getWidth(), pictureLabel.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon simg = new ImageIcon(dimg);
			pictureLabel.setIcon(simg);
		}catch (IOException e){
			e.printStackTrace();
		}
		
		// Initialize textfields
		JTextField LU = new JTextField(studentData.getId()+"");
		LU.setBounds(100, 19, 295, 20);
		tabInformation.add(LU);
		LU.setColumns(10);
		LU.setEditable(false);
		
		JTextField LastName = new JTextField(studentData.getLastName());
		LastName.setColumns(10);
		LastName.setBounds(100, 44, 295, 20);
		tabInformation.add(LastName);
		LastName.setEditable(false);
		
		JTextField Name = new JTextField(studentData.getFirstName());
		Name.setColumns(10);
		Name.setBounds(100, 69, 295, 20);
		tabInformation.add(Name);
		Name.setEditable(false);
		
		JTextField Email = new JTextField(studentData.getMail());
		Email.setColumns(10);
		Email.setBounds(100, 94, 295, 20);
		tabInformation.add(Email);
		Email.setEditable(false);
		
		JTextField GithubURL = new JTextField(studentData.getGithubURL());
		GithubURL.setColumns(10);
		GithubURL.setBounds(100, 119, 295, 20);
		tabInformation.add(GithubURL);
		GithubURL.setEditable(false);
	}
}
