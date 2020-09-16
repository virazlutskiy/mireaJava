package lab_5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class main {

	public static void main(String[] args) {
		new TaskFrame().setVisible(true);
	}

}
class TaskFrame extends JFrame
{
	JTextField textField = new JTextField("HIII");
	JButton btn1 = new JButton("Search");
	
	String filePath = "";
	public TaskFrame()
	{
		JLabel picLabel = new JLabel();
		JPanel panel = new JPanel();
		
		btn1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				filePath = textField.getText().replaceAll("\", ", "\\");
				ImageIcon myIcon = new ImageIcon(filePath);
				picLabel.setIcon(myIcon);
				System.out.println(filePath);
			}
		});
		add(picLabel,BorderLayout.CENTER);
		panel.add(textField);
		panel.add(btn1);
		add(panel,BorderLayout.SOUTH);
		setSize(800,500);
	}
}