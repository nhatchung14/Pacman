package characters;

import org.newdawn.slick.*;
import utils.Utils;

public class Pacman {
	public Animation pac, pacUp, pacDown, pacLeft, pacRight;
	private int [] pacDuration = {100, 100}; // expected durations for pac animations
	private float pacPosX = 725;
	private float pacPosY = 75;
	public int score=0;
	public int lives=3;
	public Image life;


	private int x, y;

	public Pacman(String imageDir, String extension) throws SlickException {
		Image[] pacWalkRight = new Image[2];
		Image[] pacWalkDown  = new Image[2];
		Image[] pacWalkLeft  = new Image[2];
		Image[] pacWalkUp    = new Image[2];
		for (int img = 0; img < 2; img++)	{
			pacWalkRight[img] = new Image(imageDir + "pacman_right_"  + Integer.toString(img) + extension);
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

	// 0 is down, 1 is right
	// 2 is up,   3 is left
	public int getState() {
		if (pac == pacDown) 	  return 0;
		else if (pac == pacRight) return 1;
		else if (pac == pacUp)    return 2;
		else if (pac == pacLeft)  return 3;

		return -1; // bugged
	}

	public void moves(Input input, int delta) {
		// pac's movements
		if (input.isKeyDown(Input.KEY_UP)) {
			pac = pacUp;
			// consider the rear of the image pacPosY-10  instead of the center pacPoY
			y = (int) ((pacPosY-10 - delta * 0.25f)/50.0f); // next y position
			x = (int) ((pacPosX)/50.0f);

			// if Pacman's next expected position is out of bounds or blocked
			if (pacPosY > 0 && y >= 0 && !Utils.isBlocked(y, x)) {
				pacPosY -= delta * .25f;
			}
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			pac = pacDown;
			// consider the rear of the image pacPosY+10  instead of the center pacPoY
			y = (int) ((pacPosY+10 + delta * 0.25f)/50.0f);  // next y position
			x = (int) ((pacPosX)/50.0f);

			// if Pacman's next expected position is out of bounds or blocked
			if (pacPosY < 850 && y < 18 && !Utils.isBlocked(y, x)) {
				pacPosY += delta * .25f;
			}
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			pac = pacLeft;
			// consider the rear of the image pacPosX-10  instead of the center pacPoX
			y = (int) ((pacPosY)/50.0f);
			x = (int) ((pacPosX-10 - delta * 0.25f)/50.0f); // next x position

			// if Pacman's next expected position is out of bounds or blocked
			if (pacPosX > 0 && x >= 0 && !Utils.isBlocked(y, x)) {
				pacPosX -= delta * .25f;
			}
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			pac = pacRight;
			// consider the rear of the image pacPosX+10  instead of the center pacPoX
			y = (int) ((pacPosY)/50.0f);
			x = (int) ((pacPosX+10 + delta * 0.25f)/50.0f); // next x position

			// if Pacman's next expected position is out of bounds or blocked
			if (pacPosX < 1500 && x < 30 && !Utils.isBlocked(y, x)) {
				pacPosX += delta * .25f;
			}
		}

	}


	public void draw() {
		pac.draw(pacPosX-25, pacPosY-25);
	}

	public float getX() { return pacPosX; }
	public float getY() { return pacPosY; }
	public void anotherlife(){
		pacPosX = 725;
		pacPosY = 75;
	}
}