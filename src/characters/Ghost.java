package characters;

import org.newdawn.slick.*;

public class Ghost {
	public Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;
	public int [] ghostDuration = {100, 100}; // expected durations for ghost animations
	private float ghostPosX;
	private float ghostPosY;

	public long vulnerableModeStartTime;
	public boolean markAsVulnerable;

	public static enum Mode { CAGE, NORMAL, VULNERABLE, DIED }
	public Mode mode = Mode.CAGE;


	public Ghost(String imageDir, String color, String extension, float inY, float inX) throws SlickException {
		Image [] ghostWalkRight = new Image[2];
		Image [] ghostWalkDown = new Image[2];
		Image [] ghostWalkLeft = new Image[2];
		Image [] ghostWalkUp = new Image[2];

		for (int img = 0; img < 2; img++)	{
			ghostWalkRight[img] = new Image(imageDir + color + "-ghost/lookright" + extension);
			ghostWalkDown[img]  = new Image(imageDir + color + "-ghost/lookdown" + extension);
			ghostWalkLeft[img]  = new Image(imageDir + color + "-ghost/lookleft" + extension);
			ghostWalkUp[img]    = new Image(imageDir + color + "-ghost/lookup" + extension);
		}

		ghostUp = new Animation(ghostWalkUp, ghostDuration, true);
		ghostDown = new Animation(ghostWalkDown, ghostDuration, true);
		ghostLeft = new Animation(ghostWalkLeft, ghostDuration, true);
		ghostRight = new Animation(ghostWalkRight, ghostDuration, true);

		ghost = ghostDown;

		// set initial position
		ghostPosX = inX; 
		ghostPosY = inY; 
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
		else if (ghostPosY - pac.getY() < 0) {				 
			ghostPosY += delta * .1f;
			ghost = ghostDown;
		}
	}
	
	public void draw() {
		ghost.draw(ghostPosX - 25f, ghostPosY - 25f);
	}

	public void ability(){
		// This is just abstract, 4 ghost will extend
	}

	public void setMode(Mode mode){
		this.mode = mode;
	}

	public void ghostInCage(){

		//need map to evaluate exact where is the cage

		setMode(Mode.CAGE);
	}

	public void startGhostVulnerable(){
		vulnerableModeStartTime = System.currentTimeMillis();
		markAsVulnerable = true;
	}

	public boolean checkGhostVulnerable(){
		return System.currentTimeMillis() - vulnerableModeStartTime <= 8000; //vulnerable in 8 secs
	}

	public void updateGhostVulnerable(){
		if (markAsVulnerable) {
			markAsVulnerable = false;
		}
		if (!checkGhostVulnerable()){
			setMode(Mode.NORMAL);
		}
	}

	public boolean checkedCollidePacman(){

		boolean isCollide = false;

		return isCollide;
	}


	public void ghostDied(){
		// need link with Pacman to test when ghosts die

		setMode(Mode.DIED);
	}

	public float getX() { return ghostPosX; }
	public float getY() { return ghostPosY; }
	
	public void setX(float ghostPosX) { 
		if (this.ghostPosX < ghostPosX) ghost = ghostRight;
		else
		if (this.ghostPosX > ghostPosX) ghost = ghostLeft;
		
		this.ghostPosX = ghostPosX;	
	}
	public void setY (float ghostPosY) { 
		if (this.ghostPosY < ghostPosY) ghost = ghostDown;
		else
		if (this.ghostPosY > ghostPosY) ghost = ghostUp;
		
		this.ghostPosY = ghostPosY;	
	}
}
