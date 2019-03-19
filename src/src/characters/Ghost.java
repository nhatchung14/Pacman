package characters;

import org.newdawn.slick.*;

public class Ghost {
	private Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;
	private int [] ghostDuration = {100, 100}; // expected durations for ghost animations
	private float ghostPosX = 100;
	private float ghostPosY = 100;
	public Ghost() throws SlickException {
		Image[] ghostWalkRight = {new Image("./image/ghost_0_0.png"), 
					 			  new Image("./image/ghost_0_1.png")};
		Image[] ghostWalkDown = {new Image("./image/ghost_1_0.png"), 
								 new Image("./image/ghost_1_1.png")};
		Image[] ghostWalkLeft = {new Image("./image/ghost_2_0.png"), 
								 new Image("./image/ghost_2_1.png")};
		Image[] ghostWalkUp	 = {new Image("./image/ghost_3_0.png"), 
								new Image("./image/ghost_3_1.png")};
		
		ghostUp = new Animation(ghostWalkRight, ghostDuration, true);
		ghostDown = new Animation(ghostWalkDown, ghostDuration, true);
		ghostLeft = new Animation(ghostWalkLeft, ghostDuration, true);
		ghostRight = new Animation(ghostWalkUp, ghostDuration, true);
		
		ghost = ghostDown;
	}
	
	public void moves(Pacman pac, int delta) {
		// moving ghost closer (very basic)
		if (ghostPosX - pac.getX() > 0) {
			ghostPosX -= delta * .1f;
			ghost = ghostLeft;
		}
		else if (ghostPosX - pac.getX() < 0) {				 
			ghostPosX += delta * .1f;
			ghost = ghostRight;
		}
		
		if (ghostPosY - pac.getY() > 0) {
			ghostPosY -= delta * .1f;
			ghost = ghostUp;
		}
		else if (ghostPosX - pac.getY() < 0) {				 
			ghostPosY += delta * .1f;
			ghost = ghostDown;
		}
	}
	
	public void draw() {
		ghost.draw(ghostPosX, ghostPosY);
	}
	
	public float getX() { return ghostPosX; }
	public float getY() { return ghostPosY; }
}
