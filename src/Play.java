
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import characters.*;

public class Play extends BasicGameState{ 
	Image map; // the map

	Pacman pac; // Pacman

	Ghost ghostBlue;
	Ghost ghostBrown;
	Ghost ghostRed;
	Ghost ghostYellow;
	
	// creating a ghost
	Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;
	int [] ghostDuration = {100, 100}; // expected durations for ghost animations
	float ghostPosX = 100;
	float ghostPosY = 100;
	
	public Play(int state) {}
	
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        map = new Image("image/map/map.png");

		// pac part

        pac = new Pacman("image/pacman/", ".png");


        //ghost part
        ghostBlue = new Ghost("src/image/","blue",".png");
		ghostBrown = new Ghost("src/image/","brown",".png");
		ghostYellow = new Ghost("src/image/","brown",".png");
		ghostRed = new Ghost("src/image/","brown",".png");

        
/*
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
		*/
	}
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
	    map.draw(0,0);
		pac.draw();
		ghostBlue.draw();
		ghostRed.draw();
		ghostBrown.draw();
		ghostYellow.draw();

		//ghost.draw(ghostPosX, ghostPosY);
	}
	
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();
		
		// pac's movements
		pac.moves(input, delta);

		ghostBrown.moves(pac,delta);
		ghostBlue.moves(pac,delta);
		ghostRed.moves(pac,delta);
		ghostYellow.moves(pac,delta);
		
		// moving ghost closer (very basic)
		if (ghostPosX - pac.getX() > 0) 
			ghostPosX -= delta * .1f;
		else if (ghostPosX - pac.getX() < 0)					 
			ghostPosX += delta * .1f;
		
		if (ghostPosY - pac.getY() > 0) 
			ghostPosY -= delta * .1f;
		else if (ghostPosX - pac.getY() < 0)					 
			ghostPosY += delta * .1f;
	}
	
	public int getID() {
		return 1;
	}
}
