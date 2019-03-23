
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import characters.*;
import utils.GhostFactory;

public class Play extends BasicGameState{ 
	Image map; // the map

	Pacman pac; // Pacman

	Ghost ghostBlue;
	Ghost ghostBrown;
	Ghost ghostRed;
	Ghost ghostYellow;
	
	public Play(int state) {}
	
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        map = new Image("image/map/map.png");

		// pac part
        pac = new Pacman("image/pacman/", ".png");

        //ghost part
        ghostBlue 	= GhostFactory.newGhost("image/","blue",	".png", 75, 75);
		ghostYellow = GhostFactory.newGhost("image/","yellow",	".png", 475, 825);
		ghostRed 	= GhostFactory.newGhost("image/","red",		".png", 825, 1025);
		ghostBrown 	= GhostFactory.newGhost("image/","brown",	".png", 210, 1331);
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

		// ghosts's movements
		ghostBrown.moves(pac,delta);
		ghostBlue.moves(pac,delta);
		ghostRed.moves(pac,delta);
		ghostYellow.moves(pac,delta);
		
	}
	
	public int getID() {
		return 1;
	}
}
