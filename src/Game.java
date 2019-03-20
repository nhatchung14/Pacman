import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import board.Size;

public class Game extends StateBasedGame
{
    public static final String gameName = "Pacman";
    public static final int menu = 0;
    public static final int play = 1;
    public Game(String gameName)
    {
        super(gameName);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
    	this.getState(menu).init(gc, this);
    	this.getState(play).init(gc, this);
    	this.enterState(menu);
    }
    
    public static void main(String[] arguments)
    {
        try
        {
        	Size size = Size.getInstance();
        	AppGameContainer myGame = new AppGameContainer(new Game(gameName));
        	myGame.setDisplayMode(size.srceen_width, size.srceen_height, false);
        	myGame.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

    
}