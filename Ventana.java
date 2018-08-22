import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ventana extends Canvas implements ActionListener{

	private JButton b;
	private Main game;
	private JFrame frame;
	
	public Ventana(int width, int height, String title, Main game){
		frame = new JFrame(title);
		b = new JButton("Jugar");
		this.game = game;

		b.setBounds(225, 200, 150, 100);
		frame.add(b);
		b.addActionListener(this);

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
			frame.remove(b);
		}
	}
	
}