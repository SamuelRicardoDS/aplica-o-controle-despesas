package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Label;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ViewCreateGroup {

	private JFrame frame;

	public ViewCreateGroup() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 852, 480);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(153, 100, 70, 15);
		frame.getContentPane().add(label);
		frame.setLocationRelativeTo(null);
		
		
	}
	public JFrame getCreateGroupFrame() {
		return frame;
	}
}

