package game_logic_start;

public class Game implements Runnable {

	private boolean isRunning;
	private Thread thread;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.start();
	}
	
	public synchronized void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public void tick() {
		System.out.println("Tick");
	}
	
	public void render() {
		System.out.println("Render");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			tick();
			render();
		}
	}

}
