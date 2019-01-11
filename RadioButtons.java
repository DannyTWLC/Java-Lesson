import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtons {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JRadioButton korBtn = new JRadioButton("Korean");
		JRadioButton engBtn = new JRadioButton("English");
		JRadioButton chiBtn = new JRadioButton("Chinese");
		ButtonGroup group = new ButtonGroup();
		
		korBtn.setActionCommand("kor");
		engBtn.setActionCommand("eng");
		chiBtn.setActionCommand("chi");
		
		group.add(korBtn);
		group.add(engBtn);
		group.add(chiBtn);
		Font font = new Font("Arial", Font.BOLD, 24);
		korBtn.setFont(font);
		engBtn.setFont(font);
		chiBtn.setFont(font);
		
		engBtn.setSelected(true);
		
		korBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand());
			}
			
		});
		engBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand());
			}
			
		});
		chiBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.out.println(group.getSelection().getActionCommand());
			}
			
		});
		
		panel.add(korBtn);
		panel.add(engBtn);
		panel.add(chiBtn);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
