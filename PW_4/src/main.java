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
	JButton btn1 = new JButton("AC Milan");
	JButton btn2 = new JButton("Real Madrid");
	JLabel results = new JLabel("Result: 0 X 0");
	JLabel lastScorer = new JLabel("Last Scorer: N/A");
	Label winner = new Label("Winner: DRAW");
	int Milan = 0;
	int Madrid = 0;
	
	String whoWinning() {
		if(Milan > Madrid)
			return "AC Milan";
		if(Milan < Madrid)
			return "Real Madrid";
			return "DRAW";
	}
	public TaskFrame()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		winner.setAlignment(1);
		results.setAlignmentX(Component.CENTER_ALIGNMENT);
		lastScorer.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(results);
		panel.add(lastScorer);
		panel.add(winner);
		
		btn1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Milan++;
				lastScorer.setText("Last Scorer: AC Milan");
				winner.setText("Winner: " + whoWinning());
				results.setText("Result " + Milan +" X " + Madrid);	
			}
		});
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Madrid++;
				lastScorer.setText("Last Scorer: Real Madrid");
				winner.setText("Winner: " + whoWinning());
				results.setText("Result: " + Milan +" X " + Madrid);	
			}
		});
		
		add(btn1,BorderLayout.WEST);
		add(btn2,BorderLayout.EAST);
		add(panel,BorderLayout.CENTER);
		
		setSize(800,500);
	}
}
