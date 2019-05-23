import board.Size;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;
import characters.*;
import utils.Food;
import utils.GhostFactory;

import java.awt.*;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.InputStream;

public class Play extends BasicGameState{
	Image map; // the map

	Pacman pac; // Pacman

	Ghost ghostBlue;
	Ghost ghostBrown;
	Ghost ghostRed;
	Ghost ghostYellow;

	//exit window;
	public Shape menubutton,exitbutton;
	public Size Board=Size.getInstance();
	public TrueTypeFont exitfont,scorefont;
	Image gameover;
	public String menu="Menu",exit="Exit",score="";

	// set inital out side screen
	public int gameoverX=2000,gameoverY=2000;

	public Play(int state) {}
/*
	public  Font importfont() throws Exception{

        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("roboto-bold.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
        scorefont = new TrueTypeFont(new Font("Trajan Pro", Font.PLAIN, 30),true);

    }
*/
	public void init(GameContainer gc, StateBasedGame game) throws SlickException  {
		map = new Image("image/map/map.png");

		// pac part
		pac = new Pacman("image/pacman/", ".png");

		//ghost part
		ghostBlue 	= GhostFactory.newGhost("image/","blue",	".png", 75, 75);
		ghostYellow = GhostFactory.newGhost("image/","yellow",	".png", 475, 825);
		ghostRed 	= GhostFactory.newGhost("image/","red",		".png", 825, 1025);
		ghostBrown 	= GhostFactory.newGhost("image/","brown",	".png", 210, 1331);


		// declare exit window with 2 button, draw outside first if collie then change pos to inside screen
		exitbutton=new org.newdawn.slick.geom.Rectangle(Board.exit_buttonX, Board.exit_buttonY, Board.exit_button_width, Board.exit_button_height);
		menubutton= new org.newdawn.slick.geom.Rectangle(Board.exit_menu_buttonX, Board.exit_menu_buttonY, Board.exit_button_width, Board.exit_button_height);
		exitfont =  new TrueTypeFont(new Font("Trajan Pro", Font.PLAIN, 30),true);
		scorefont = new TrueTypeFont(new Font("Trajan Pro", Font.PLAIN, 30),true);
		gameover= new Image("image/gameover/gameover.png");
	}

	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		map.draw(0,0);

		pac.draw();

		// draw food
		Food.drawFood(pac.getX(), pac.getY(), pac);
		
		// draw ghost
		ghostBlue.draw();
		ghostRed.draw();
		ghostBrown.draw();
		ghostYellow.draw();

		// score
        g.setColor(Color.white);
        g.setFont(scorefont);
        g.drawString(score+pac.score,1430,8);
		//exit

		drawexit(g);
	}

	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();
		// check pos before move
		if (checkWithAllGhost(pac,ghostBrown,ghostBlue,ghostRed,ghostYellow)){
			// check pac pos vs ghost pos, if true draw exit in the screen
			gameoverX=Board.exit_title_x;
			gameoverY=Board.exit_title_y;
			int xPos = Mouse.getX();
			int yPos = Mouse.getY();
			//check click on menu
			if ((xPos >= Board.exit_menu_buttonX && xPos <= Board.exit_menu_buttonX+Board.exit_button_width) && (yPos >= Board.srceen_height-Board.exit_menu_buttonY-Board.exit_button_height && yPos <= Board.srceen_height-Board.exit_menu_buttonY)) {
				if (input.isMouseButtonDown(0)) {
					game.getState(1).init(gc,game); // reset state
					game.enterState(0);
				}
			}
			//check click exit
			if ((xPos >= Board.exit_buttonX && xPos <= Board.exit_buttonX+Board.exit_button_width) && (yPos >= Board.srceen_height-Board.exit_buttonY-Board.exit_button_height && yPos <= Board.srceen_height-Board.exit_buttonY)) {
				if (input.isMouseButtonDown(0)) {
					gc.exit(); // exit game
				}
			}
		}
		// continue moving
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
	public void drawexit(Graphics g){
		if (checkWithAllGhost(pac,ghostBrown,ghostBlue,ghostRed,ghostYellow)){
			gameover.draw(gameoverX,gameoverY);
			g.setColor(Color.black);
			g.fill(menubutton); //fill background of "menubutton" rec = black
			g.fill(exitbutton);	//fill background of "exitbutton" rec = black
			g.setLineWidth(20);
			g.setColor(Color.red);
			g.draw(menubutton);	//draw "menubutton" rec + red linewidth
			g.draw(exitbutton);	//draw "exitbutton" rec + red linewidth
			g.setFont(exitfont);
			int xPos = Mouse.getX();
			int yPos = Mouse.getY();
			// menu button
			if ((xPos >= Board.exit_menu_buttonX && xPos <= Board.exit_menu_buttonX+Board.exit_button_width) && (yPos >= Board.srceen_height-Board.exit_menu_buttonY-Board.exit_button_height && yPos <= Board.srceen_height-Board.exit_menu_buttonY)) {
				g.setColor(Color.red); // if mouse cusor in rec String "menu" = red
				g.drawString(menu, Board.exit_menu_buttonX+100, Board.exit_menu_buttonY+25);
			}
			else
			{
				g.setColor(Color.white); // if mouse cusor not in rec String "menu" = white
				g.drawString(menu, Board.exit_menu_buttonX+100, Board.exit_menu_buttonY+25);
				// draw "menu" String in the middle of rec
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
				// draw "exit" String in the middle of rec
			}
			g.setColor(Color.white);
				// set font color back to white as default
		}
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
//	public boolean checkedEatFood(Pacman pac, Food food){
//		boolean isCollide = false;
//
//		if (Math.abs(pac.getX() - food.getFoodPosX()) == 0 && Math.abs(pac.getY() - food.getFoodPosY()) == 0){
//			isCollide = true;
//		}
//		return isCollide;
//	}


	public int getID() {
		return 1;
	}

}