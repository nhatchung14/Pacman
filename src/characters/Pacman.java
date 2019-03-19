package characters;

import java.math.*;
import org.newdawn.slick.*;
import board.*;

public class Pacman {
	private Size Board;
	
	private Animation pac, pacUp, pacDown, pacLeft, pacRight;
	private int [] pacDuration = {100, 100}; // expected durations for pac animations
	private float pacPosX = 725;
	private float pacPosY = 75;
	
	private int x, y;
	
	public Pacman(String imageDir, String extension) throws SlickException {
		Board = Size.getInstance(); // the board
				
		Image[] pacWalkRight = new Image[2];
		Image[] pacWalkDown  = new Image[2];
		Image[] pacWalkLeft  = new Image[2];
		Image[] pacWalkUp    = new Image[2];
		for (int img = 0; img < 2; img++)	{
			pacWalkRight[img] = new Image(imageDir +"pacman_right_"  + Integer.toString(img) + extension);
			pacWalkDown[img]  = new Image(imageDir + "pacman_down_"  + Integer.toString(img) + extension); 
			pacWalkLeft[img]  = new Image(imageDir + "pacman_left_"  + Integer.toString(img) + extension); 
			pacWalkUp[img]    = new Image(imageDir + "pacman_up_" 	 + Integer.toString(img) + extension); 
		}
		
		pacUp = new Animation(pacWalkUp, pacDuration, true);
		pacDown = new Animation(pacWalkDown, pacDuration, true);
		pacLeft = new Animation(pacWalkLeft, pacDuration, true);
		pacRight = new Animation(pacWalkRight, pacDuration, true);
		pac = pacRight;
	}
	
	public void moves(Input input, int delta) {
		// pac's movements
		if (input.isKeyDown(Input.KEY_UP)) {
			pac = pacUp;
			
			y = (int) ((pacPosY - delta * 0.25f)/50.0f); // next y position
			x = (int) ((pacPosX)/50.0f);
			if (pacPosY > 0 && y >= 0 && Board.board_matrix[y][x] != -1) {
				pacPosY -= delta * .25f;
			}
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			pac = pacDown;
			
			y = (int) ((pacPosY + delta * 0.25f)/50.0f);  // next y position
			x = (int) ((pacPosX)/50.0f);
			if (pacPosY < 850 && y < 18 && Board.board_matrix[y][x] != -1) {
				pacPosY += delta * .25f;
			}
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			pac = pacLeft;
			
			y = (int) ((pacPosY)/50.0f);
			x = (int) ((pacPosX - delta * 0.25f)/50.0f); // next x position
			if (pacPosX > 0 && x >= 0 && Board.board_matrix[y][x] != -1) {
				pacPosX -= delta * .25f;
			}
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			pac = pacRight;
			
			y = (int) ((pacPosY)/50.0f);
			x = (int) ((pacPosX + delta * 0.25f)/50.0f); // next x position
			if (pacPosX < 1500 && x < 30 && Board.board_matrix[y][x] != -1) {
				pacPosX += delta * .25f;
			}
		}
		
	}
	
	public void draw() {
		pac.draw(pacPosX-25, pacPosY-25);
	}
	
	public float getX() { return pacPosX; }
	public float getY() { return pacPosY; }
}
