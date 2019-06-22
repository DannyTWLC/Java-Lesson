import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App {
	private final String ID = "Danny";
	private final String PASS = "abc";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\Users\\jarka\\Documents\\Lesson\\Java\\Accounting App\\Image Sources\\theme.jpg").getImage());
		
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
		frame.getContentPane().add(loginPanel);
		
		idField = new JTextField();
		idField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		idField.setBounds(1223, 311, 296, 43);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passField.setBounds(1223, 391, 296, 43);
		passField.setBorder(null);
		loginPanel.add(passField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(1184, 440, 25, 25);
		loginPanel.add(chckbxNewCheckBox);
		
		JButton logInBtn = new JButton("");
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ID.equals(idField.getText()) && PASS.equals(passField.getText())){
					JOptionPane.showMessageDialog(null,"You are logged In!");
					loginPanel.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null,"You Failed to Log In");
				}
			}
		});
		logInBtn.setBorder(null);
		logInBtn.setBounds(1183, 467, 338, 38);
		loginPanel.add(logInBtn);
		logInBtn.setIcon(new ImageIcon("C:\\Users\\jarka\\Documents\\Lesson\\Java\\Accounting App\\Image Sources\\button.jpg"));
		logInBtn.setPressedIcon(new ImageIcon("C:\\Users\\jarka\\Documents\\Lesson\\Java\\Accounting App\\Image Sources\\btnClicked.jpg"));
		frame.pack();
	}
}
