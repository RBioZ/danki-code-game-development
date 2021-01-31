package com.rbioz.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.rbioz.main.Game;

public class Player extends Entity{
	
	public boolean right,up,left,down;
	public int right_dir = 0,left_dir = 1;
	public int dir = right_dir;
	
	public double speed = 1.4;
	
	private int frames = 0,maxFrames = 3,index = 0,maxIndex = 3;
	private boolean moved = false;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;
 	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		rightPlayer = new BufferedImage[5];
		leftPlayer = new BufferedImage[5];
		
		rightPlayer[0] = Game.spritesheet.getSprite(32, 0, 16, 16);
		rightPlayer[1] = Game.spritesheet.getSprite(48, 0, 16, 16);
		rightPlayer[2] = Game.spritesheet.getSprite(0, 16, 16, 16);
		rightPlayer[3] = Game.spritesheet.getSprite(16, 16, 16, 16);
		rightPlayer[4] = Game.spritesheet.getSprite(32, 16, 16, 16);
		
		leftPlayer[0] = Game.spritesheet.getSprite(48, 16, 16, 16);
		leftPlayer[1] = Game.spritesheet.getSprite(0, 32, 16, 16);
		leftPlayer[2] = Game.spritesheet.getSprite(16, 32, 16, 16);
		leftPlayer[3] = Game.spritesheet.getSprite(32, 32, 16, 16);
		leftPlayer[4] = Game.spritesheet.getSprite(48, 32, 16, 16);
		
	}

	public void tick() {
		moved = false;
		if(right) {
			moved = true;
			dir = right_dir;
			x+=speed;
		}
		else if(left) {
			moved = true;
			dir = left_dir;
			x-=speed;
		}
		if(up) {
			moved = true;
			y -= speed;
		}
		else if(down) {
			moved = true;
			y += speed; 
		}
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
		if(moved == false) {
			index = 0;
		}
	}
	
	public void render(Graphics g) {
		if(dir == right_dir) {
			g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
		}
		else if(dir == left_dir) {
			g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}
	}
}
