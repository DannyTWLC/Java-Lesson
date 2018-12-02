// Customer class source code
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	public static void main(String[] args) {
		createTable();
		createCustomer("Danny","123456789","Male","23","Random Note....");
		ArrayList<String> list = getCustomers();
		for(String item: list){
			System.out.println(item);
		}
		createCustomer("Daivd","4441122211","Female","25","Important Customer");
		list = getCustomers();
		for(String item: list){
			System.out.println(item);
		}
	}
	
	public static ArrayList<String> getCustomers(){
		try{
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while(results.next()){
				list.add("Name : "+ results.getString("name") +
						" Phone "+ results.getString("phone") + 
						" Gender : "+ results.getString("gender"));
			}
			System.out.println("The data has been fetched");
			return list;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createCustomer(String name, String phone, String gender, String age, String note ){
		try{
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(name, phone, gender, age, note) "
					+ "VALUE "
					+ "('"+name+"','"+phone+"','"+gender+"','"+age+"','"+note+"')");
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void createTable(){
		try{
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255),"
					+ "phone varChar(255),"
					+ "gender varChar(255),"
					+ "age varChar(255),"
					+ "note varChar(255),"
					+ "PRIMARY KEY(id))");
			create.execute();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			System.out.println("Table successfully created");
		}
	}

	
	public static Connection getConnection(){
		try{
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9264705";
			String user = "sql9264705";
			String pass = "BFhzg1jJiJ";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The Connection Successful");
			return con;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}


// 스윙 Source code
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Customer_App {

	private JFrame frame;
	private JTextField id;
	private JPasswordField password;
	private JTextField name;
	private JTextField phone;
	private JTextField age;
	private JTextField birthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("D:/lesson/Java/Swing Lessons/image/welcome.jpg").getImage());
		welcomePanel.setBounds(0, 0, 954, 605);
		frame.setSize(welcomePanel.getWidth(),welcomePanel.getHeight());
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 954, 605);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		JLabel lblWelcomeThisIs = new JLabel("Welcome This is Main Panel");
		lblWelcomeThisIs.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblWelcomeThisIs.setBounds(262, 27, 459, 53);
		mainPanel.add(lblWelcomeThisIs);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblName.setBounds(152, 93, 190, 43);
		mainPanel.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAge.setBounds(152, 175, 190, 43);
		mainPanel.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblGender.setBounds(152, 261, 190, 43);
		mainPanel.add(lblGender);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPhone.setBounds(502, 93, 190, 43);
		mainPanel.add(lblPhone);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblBirthday.setBounds(502, 175, 190, 43);
		mainPanel.add(lblBirthday);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNote.setBounds(502, 261, 190, 43);
		mainPanel.add(lblNote);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 19));
		name.setBounds(301, 93, 204, 43);
		mainPanel.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		phone.setColumns(10);
		phone.setBounds(665, 93, 204, 43);
		mainPanel.add(phone);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 19));
		age.setColumns(10);
		age.setBounds(301, 175, 204, 43);
		mainPanel.add(age);
		
		birthday = new JTextField();
		birthday.setFont(new Font("Tahoma", Font.PLAIN, 19));
		birthday.setColumns(10);
		birthday.setBounds(665, 175, 204, 43);
		mainPanel.add(birthday);
		
		JComboBox gender = new JComboBox(new String[]{"Male","Female"});
		gender.setFont(new Font("Tahoma", Font.PLAIN, 19));
		gender.setBackground(Color.WHITE);
		gender.setBounds(301, 261, 204, 43);
		mainPanel.add(gender);
		
		JTextArea note = new JTextArea();
		note.setBounds(665, 263, 204, 180);
		mainPanel.add(note);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTxt = name.getText();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String bTxt = birthday.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String noteTxt = note.getText();
				
			}
		});
		btnNewButton.setBounds(444, 490, 212, 53);
		mainPanel.add(btnNewButton);
		frame.getContentPane().add(welcomePanel);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Lato", Font.BOLD, 30));
		lblLogIn.setBounds(394, 271, 168, 47);
		welcomePanel.add(lblLogIn);
		
		id = new JTextField();
		id.setFont(new Font("Lato", Font.PLAIN, 30));
		id.setToolTipText("Enter ID");
		id.setBounds(327, 337, 250, 40);
		welcomePanel.add(id);
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(327, 387, 250, 40);
		welcomePanel.add(password);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Lato", Font.BOLD, 30));
		lblId.setBounds(262, 337, 85, 40);
		welcomePanel.add(lblId);
		
		JLabel lblPs = new JLabel("PS :");
		lblPs.setFont(new Font("Lato", Font.BOLD, 30));
		lblPs.setBounds(259, 385, 85, 40);
		welcomePanel.add(lblPs);
		
		JButton btnLogIn = new JButton("");
		btnLogIn.setIcon(new ImageIcon("D:\\Lesson\\Java\\Swing Lessons\\image\\loginbutton.png"));
		btnLogIn.setPressedIcon(new ImageIcon("D:\\Lesson\\Java\\Swing Lessons\\image\\loginbutton_click.png"));
		btnLogIn.setBounds(361, 450, 187, 40);
		btnLogIn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals("Danny")&&Arrays.equals(password.getPassword(),"hello".toCharArray())){
					System.out.println("Welcom Danny");
					welcomePanel.setVisible(false);
					mainPanel.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"You failed to log in");
				}
				
			}
			
		});
		
		
		welcomePanel.add(btnLogIn);
		frame.setJMenuBar(menuBar());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public JMenuBar menuBar(){
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		
		bar.add(fileMenu);
		bar.add(aboutMenu);
		
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		return bar;
	}
}

class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img){
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth(){
		return img.getWidth(null);
	}
	
	public int getHeight(){
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
	
}
