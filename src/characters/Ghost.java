package characters;

import org.newdawn.slick.*;

public class Ghost {
	public Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;
	public int [] ghostDuration = {100, 100}; // expected durations for ghost animations
	private float ghostPosX;
	private float ghostPosY;

	public long vulnerableModeStartTime; // vulnerable start time
	public boolean markAsVulnerable; // check vulnerable
	public boolean pacmanEatFood = true; // just temporary wait pacman eat food mode

	public static enum Mode {NORMAL, VULNERABLE, DIED } // 3 MODE
	public Mode mode = Mode.NORMAL; // initialize mode normal


	public Ghost(String imageDir, String color, String extension, float inY, float inX) throws SlickException {

		// just test this 2 function
//		startGhostVulnerable(imageDir,color,extension);
//		updateGhostVulnerable(imageDir,color,extension);

		// Ghost normal image part
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

	// if pacman eat special food ghost vulnerable
	// NEED TO LINK WITH PACMAN CLASS OR FOOD CLASS
	// pacmanEatFood is just temp

	// Method Start Ghost vulnerable

	public void startGhostVulnerable(String imageDir, String color, String extension) throws SlickException {


		if (pacmanEatFood){
			vulnerableModeStartTime = System.currentTimeMillis(); // Start Vulnerable
			markAsVulnerable = true; // mark as true if pacman eat big food

			// Change image to scared image

			Image [] scaredGhostWalkRight = new Image[2];
			Image [] scaredGhostWalkDown = new Image[2];
			Image [] scaredGhostWalkLeft = new Image[2];
			Image [] scaredGhostWalkUp = new Image[2];

			for (int img = 0; img < 2; img++)	{
				scaredGhostWalkRight[img] = new Image(imageDir + color + "-ghost/scared" + extension);
				scaredGhostWalkDown[img] = new Image(imageDir + color + "-ghost/scared" + extension);
				scaredGhostWalkLeft[img] = new Image(imageDir + color + "-ghost/scared" + extension);
				scaredGhostWalkUp[img] = new Image(imageDir + color + "-ghost/scared" + extension);
			}

			ghostUp = new Animation(scaredGhostWalkUp, ghostDuration, true);
			ghostDown = new Animation(scaredGhostWalkDown, ghostDuration, true);
			ghostLeft = new Animation(scaredGhostWalkLeft, ghostDuration, true);
			ghostRight = new Animation(scaredGhostWalkRight, ghostDuration, true);

			if (checkedCollidePacman()){    // is pacman collide with ghost in scare mode -> ghost die
				ghostDied();
			}
// Call method scare move when pacman eat big food
			ghostScaredMove();
		}
	}

	public boolean checkGhostVulnerable(){
		return System.currentTimeMillis() - vulnerableModeStartTime <= 5000; //vulnerable in 5 secs
	}

	// after 5 secs ghost become normal

	// Method update vulnerable mode
	public void updateGhostVulnerable(String imageDir, String color, String extension) throws SlickException{

		if (!checkGhostVulnerable()){
			markAsVulnerable = false;
			setMode(Mode.NORMAL);

			// image of ghost set back to normal

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

		}
	}

	// when pacman collide with ghost, but need add something in this method
	public boolean checkedCollidePacman(){

		boolean isCollide = true;

		return isCollide;
	}


	public void ghostDied(){
		// need link with Pacman to test when ghosts die
		// how to make ghost disappear ?
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

	public void ghostScaredMove(){
		// implement move for ghost so that when they scare, they will move away from pacman

	}
}