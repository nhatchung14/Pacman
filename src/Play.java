import board.Size;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;
import characters.*;
import utils.GhostFactory;
import java.awt.Font;

public class Play extends BasicGameState{
	Image map; // the map

	Pacman pac; // Pacman

	Food food; // Food

	Ghost ghostBlue;
	Ghost ghostBrown;
	Ghost ghostRed;
	Ghost ghostYellow;

	//exit window;
	public Shape menubutton,exitbutton;
	public Size Board=Size.getInstance();
	public TrueTypeFont font;
	Image gameover;
	public String menu="Menu",exit="Exit";

	// set inital out side screen
	public int gameoverX=2000,gameoverY=2000;

	public Play(int state) {}

	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		map = new Image("image/map/map.png");

		food = new Food();
		// pac part
		pac = new Pacman("image/pacman/", ".png");

		//ghost part
		ghostBlue 	= GhostFactory.newGhost("image/","blue",	".png", 75, 75);
		ghostYellow = GhostFactory.newGhost("image/","yellow",	".png", 475, 825);
		ghostRed 	= GhostFactory.newGhost("image/","red",		".png", 825, 1025);
		ghostBrown 	= GhostFactory.newGhost("image/","brown",	".png", 210, 1331);


		// exit window
		exitbutton=new org.newdawn.slick.geom.Rectangle(Board.exit_buttonX, Board.exit_buttonY, Board.exit_button_width, Board.exit_button_height);
		menubutton= new org.newdawn.slick.geom.Rectangle(Board.exit_menu_buttonX, Board.exit_menu_buttonY, Board.exit_button_width, Board.exit_button_height);
		font =  new TrueTypeFont(new Font("Trajan Pro", Font.PLAIN, 30),true);
		gameover= new Image("image/gameover/gameover.png");
	}

	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		map.draw(0,0);

		pac.draw();

		// draw food
		food.drawFood();
		// draw ghost
		ghostBlue.draw();
		ghostRed.draw();
		ghostBrown.draw();
		ghostYellow.draw();

		//exit
		gameover.draw(gameoverX,gameoverY);
		if (checkWithAllGhost(pac,ghostBrown,ghostBlue,ghostRed,ghostYellow)){
			g.setColor(Color.black);
			g.fill(menubutton);
			g.fill(exitbutton);
			g.setLineWidth(20);
			g.setColor(Color.red);
			g.draw(menubutton);
			g.draw(exitbutton);
			g.setFont(font);
			int xPos = Mouse.getX();
			int yPos = Mouse.getY();
			// menu button
			if ((xPos >= Board.exit_menu_buttonX && xPos <= Board.exit_menu_buttonX+Board.exit_button_width) && (yPos >= Board.srceen_height-Board.exit_menu_buttonY-Board.exit_button_height && yPos <= Board.srceen_height-Board.exit_menu_buttonY)) {
				g.setColor(Color.red);
				g.drawString(menu, Board.exit_menu_buttonX+100, Board.exit_menu_buttonY+25);
			}
			else
			{
				g.setColor(Color.white);
				g.drawString(menu, Board.exit_menu_buttonX+100, Board.exit_menu_buttonY+25);
			}
			//exit button
			if ((xPos >= Board.exit_buttonX && xPos <= Board.exit_buttonX+Board.exit_button_width) && (yPos >= Board.srceen_height-Board.exit_buttonY-Board.exit_button_height && yPos <= Board.srceen_height-Board.exit_buttonY)) {
				g.setColor(Color.red);
				g.drawString(exit, Board.exit_buttonX+100, Board.exit_buttonY+25);
			}
			else
			{
				g.setColor(Color.white);
				g.drawString(exit, Board.exit_buttonX+100, Board.exit_buttonY+25);
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();
		// check pos before move
		if (checkWithAllGhost(pac,ghostBrown,ghostBlue,ghostRed,ghostYellow)){
			gameoverX=Board.exit_title_x;
			gameoverY=Board.exit_title_y;
			int xPos = Mouse.getX();
			int yPos = Mouse.getY();
			//check click on menu
			if ((xPos >= Board.exit_menu_buttonX && xPos <= Board.exit_menu_buttonX+Board.exit_button_width) && (yPos >= Board.srceen_height-Board.exit_menu_buttonY-Board.exit_button_height && yPos <= Board.srceen_height-Board.exit_menu_buttonY)) {
				if (input.isMouseButtonDown(0)) {
					game.enterState(0);
				}
			}
			//check click exit
			if ((xPos >= Board.exit_buttonX && xPos <= Board.exit_buttonX+Board.exit_button_width) && (yPos >= Board.srceen_height-Board.exit_buttonY-Board.exit_button_height && yPos <= Board.srceen_height-Board.exit_buttonY)) {
				if (input.isMouseButtonDown(0)) {
					gc.exit();
				}
			}
		}
		else{
			// pac's movements
			pac.moves(input, delta);
			// ghosts's movements
			ghostBrown.moves(pac,delta);
			ghostBlue.moves(pac,delta);
			ghostRed.moves(pac,delta);
			ghostYellow.moves(pac,delta);
		}
	}
	// check with all ghost, 4 funct of checkedCollidePacman
	public boolean checkWithAllGhost(Pacman pac, Ghost ghostBrown,Ghost ghostBlue,Ghost ghostRed,Ghost ghostYellow){
		if (checkedCollidePacman(pac, ghostBrown) ||checkedCollidePacman(pac, ghostBlue) || checkedCollidePacman(pac, ghostRed)||checkedCollidePacman(pac, ghostYellow)){
			return true;
		}
		return false;
	}

	// when pacman collide with ghost, but need add something in this method
	public boolean checkedCollidePacman(Pacman pac, Ghost ghost){
		boolean isCollide = false;

		if (Math.abs(pac.getX() - ghost.getX()) <= 50 && Math.abs(pac.getY() - ghost.getY()) <= 50){
			isCollide = true;
		}
		return isCollide;
	}
	// Check eat food
	public boolean checkedEatFood(Pacman pac, Food food){
		boolean isCollide = false;

		if (Math.abs(pac.getX() - food.getFoodPosX()) == 0 && Math.abs(pac.getY() - food.getFoodPosY()) == 0){
			isCollide = true;
		}
		return isCollide;
	}


	public int getID() {
		return 1;
	}

}