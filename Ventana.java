import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event;
public class Ventana extends Canvas implements ActionListener{
	
	public Ventana(int width, int height, String title, Main game){
		JFrame frame = new JFrame(title);
		JButton b = new JButton("Jugar");

		b.setBounds(75, 300, 100, 30);
		frame.add(b);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == b){
			game.start();
		}
	}
	
}