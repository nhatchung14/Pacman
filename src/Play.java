
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	// creating pac 
	Animation pac, pacUp, pacDown, pacLeft, pacRight;
	int [] pacDuration = {100, 100, 100, 100}; // expected durations for pac animations
	float pacPosX = 0;
	float pacPosY = 0;
	
	// creating a ghost
	Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;
	int [] ghostDuration = {100, 100}; // expected durations for ghost animations
	float ghostPosX = 100;
	float ghostPosY = 100;
	
	public Play(int state) {}
	
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		// pac part
		Image[] pacWalkRight = {new Image("./image/pacman_0_0.png"), 
							 	new Image("./image/pacman_0_1.png"), 
							 	new Image("./image/pacman_0_2.png"), 
							 	new Image("./image/pacman_0_3.png")};
		Image[] pacWalkDown	 = {new Image("./image/pacman_1_0.png"), 
			 					new Image("./image/pacman_1_1.png"), 
			 					new Image("./image/pacman_1_2.png"), 
			 					new Image("./image/pacman_1_3.png")};
		Image[] pacWalkLeft = {new Image("./image/pacman_2_0.png"), 
			 					new Image("./image/pacman_2_1.png"), 
			 					new Image("./image/pacman_2_2.png"), 
			 					new Image("./image/pacman_2_3.png")};
		Image[] pacWalkUp	 = {new Image("./image/pacman_3_0.png"), 
								new Image("./image/pacman_3_1.png"), 
								new Image("./image/pacman_3_2.png"), 
								new Image("./image/pacman_3_3.png")};
		
		pacUp = new Animation(pacWalkUp, pacDuration, true);
		pacDown = new Animation(pacWalkDown, pacDuration, true);
		pacLeft = new Animation(pacWalkLeft, pacDuration, true);
		pacRight = new Animation(pacWalkRight, pacDuration, true);
		
		pac = pacDown;
		
		// ghost part
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
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		pac.draw(pacPosX, pacPosY);
		ghost.draw(ghostPosX, ghostPosY);
	}
	
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();
		
		// pac's movements
		if (input.isKeyDown(Input.KEY_UP)) {
			pac = pacUp;
			pacPosY -= delta * .25f; 
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			pac = pacDown;
			pacPosY += delta * .25f;
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			pac = pacLeft;
			pacPosX -= delta * .25f;
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			pac = pacRight;
			pacPosX += delta * .25f;
		}
		
		// moving ghost closer (very basic)
		if (ghostPosX - pacPosX > 0) 
			ghostPosX -= delta * .1f;
		else if (ghostPosX - pacPosX < 0)					 
			ghostPosX += delta * .1f;
		
		if (ghostPosY - pacPosY > 0) 
			ghostPosY -= delta * .1f;
		else if (ghostPosX - pacPosX < 0)					 
			ghostPosY += delta * .1f;
	}
	
	public int getID() {
		return 1;
	}
}
