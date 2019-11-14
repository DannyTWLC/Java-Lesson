import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class App {
	private final String ID = "Danny";
	private final String PASS = "abc";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
	private JPanel currPanel;
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
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("C:\\Users\\Daniel Yoo\\Desktop\\Study\\Java\\workspace\\AccountingApp3\\Image Sources\\theme.jpg").getImage());
		currPanel = loginPanel;
		
		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
		ImagePanel tranPanel = new ImagePanel(new ImageIcon("C:\\Users\\Daniel Yoo\\Desktop\\Study\\Java\\workspace\\AccountingApp3\\Image Sources\\Activation.jpg").getImage());
		frame.getContentPane().add(tranPanel);
		
		
		tranPanel.setVisible(false);
		ImagePanel sumPanel = new ImagePanel(new ImageIcon("C:\\Users\\Daniel Yoo\\Desktop\\Study\\Java\\workspace\\AccountingApp3\\Image Sources\\Activation.jpg").getImage());
		frame.getContentPane().add(sumPanel);
		
		
		sumPanel.setVisible(false);
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
					currPanel.setVisible(false);
					sumPanel.setVisible(true);
					currPanel = sumPanel;
				}else{
					JOptionPane.showMessageDialog(null,"You Failed to Log In");
				}
			}
		});
		logInBtn.setBorder(null);
		logInBtn.setBounds(1183, 467, 338, 38);
		loginPanel.add(logInBtn);
		logInBtn.setIcon(new ImageIcon("C:\\Users\\Daniel Yoo\\Desktop\\Study\\Java\\workspace\\AccountingApp3\\Image Sources\\button.jpg"));
		logInBtn.setPressedIcon(new ImageIcon("C:\\Users\\Daniel Yoo\\Desktop\\Study\\Java\\workspace\\AccountingApp3\\Image Sources\\btnClicked.jpg"));
		
		// Summary 
		
		JButton tranBtn = new JButton("");
		tranBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				tranPanel.setVisible(true);
				currPanel = tranPanel;
			}
		});
		tranBtn.setIcon(new ImageIcon("C:\\Users\\Daniel Yoo\\Desktop\\Study\\Java\\workspace\\AccountingApp3\\Image Sources\\transaction.jpg"));
		tranBtn.setBounds(29, 182, 259, 40);
		tranBtn.setBorder(null);
		sumPanel.add(tranBtn);
		
		// Transaction
		
		JButton sumBtn = new JButton("");
		sumBtn.setIcon(new ImageIcon("C:\\Users\\Daniel Yoo\\Desktop\\Study\\Java\\workspace\\AccountingApp3\\Image Sources\\summary.jpg"));
		sumBtn.setBorder(null);
		sumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				sumPanel.setVisible(true);
				currPanel = sumPanel;
			}
		});
		sumBtn.setBounds(29, 123, 259, 40);
		tranPanel.add(sumBtn);
		
		frame.pack();
	}
}
