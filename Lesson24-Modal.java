// Modal class

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Modal extends JDialog{
	public Modal(Window parent, JLabel label){
		super(parent, "Modal Practice", ModalityType.APPLICATION_MODAL);
		setSize(400,260);
		setLayout(null);
		JLabel lb = new JLabel("Enter Text");
		lb.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lb.setBounds(100,30,200,50);
		JTextField field = new JTextField(10);
		field.setBounds(100,80,200, 30);
		
		JButton btn = new JButton("Change?");
		btn.setBounds(100,130, 200, 40);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				label.setText(field.getText());
				dispose();
			}
			
		});
		
		add(field);
		add(btn);
		add(lb);
	}
}


// ModalPractice Class

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ModalPractice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModalPractice window = new ModalPractice();
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
	public ModalPractice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Modal Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(94, 29, 212, 44);
		panel.add(lblNewLabel);
		
		JButton btn = new JButton("Open Modal");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modal m = new Modal(frame, lblNewLabel);
				m.setVisible(true);
			}
		});
		btn.setBounds(94, 117, 212, 58);
		panel.add(btn);
		
	}
}
