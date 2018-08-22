import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
public class Main extends Canvas implements Runnable{
	public static final int width = 800;
	public static final int height = 800;
	private Thread thread;
	private boolean running = false;

	public PieceManager pm;

	public Main(){
		pm = new PieceManager();
		//MouseInput mi = new MouseInput(handler);
		//this.addKeyListener(new KeyInput(handler));
		//this.addMouseMotionListener(mi);
		//this.addMouseListener(mi);

	 	new Ventana(width, height, "Don Chuy's Legendary Taco", this);
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta --;
			}
			if (running){
				render();
			frames ++;
			}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	private void tick(){
		PieceManager.tick();
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);

		PieceManager.render(g);
		
		g.dispose();
		bs.show();
	}
	public static void main(String[]args){
		new Main();
	}
	
}