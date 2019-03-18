import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
	public Size size=Size.getInstance();
	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.fillRect(75, 100, 100, 100);
		g.drawString("Play!", 105, 75);
	}
	
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();
		
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		if ((xPos >= 75 && xPos <= 175) && (yPos >= size.srceen_height-100-size.menu_rec_wdth && yPos <= size.srceen_height-100)) {
			if (input.isMouseButtonDown(0)) {
				game.enterState(1);
			}
		}
	}
	
	public int getID() {
		return 0;
	}
}
