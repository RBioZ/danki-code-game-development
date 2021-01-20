package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(200, 110, 40, 10);
	}
}
