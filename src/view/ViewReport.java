package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ViewReport {

	private JFrame frame;
	private JTable table;

	public ViewReport() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 33, 177, 218);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblRelatorio = new JLabel("Relatorio");
		lblRelatorio.setBounds(136, 12, 70, 15);
		frame.getContentPane().add(lblRelatorio);
		
		JLabel label = new JLabel("");
		label.setBounds(68, 120, 70, 15);
		frame.getContentPane().add(label);
        frame.setLocationRelativeTo(null);
	}
}
