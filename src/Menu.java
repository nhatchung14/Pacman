import org.lwjgl.input.Mouse;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.*;
import java.awt.Font;

import board.Size;

public class Menu extends BasicGameState{
	public Size size=Size.getInstance();
	public Image background,title,paclogo;
	public String button="Play";
	public Shape rec;
	public TrueTypeFont font;

	public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		background= new Image("image/menu/background.png");
		 rec= new org.newdawn.slick.geom.Rectangle(size.menu_rec_x, size.menu_rec_y, size.menu_rec_wdth, size.menu_rec_height);
		font =  new TrueTypeFont(new Font("Helvetica", Font.PLAIN, 30),true);
		title=new Image("image/menu/title.png");
		paclogo=new Image("image/menu/paclogo.png");
	}
	
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		background.draw(0,0);
		title.draw(450,50);
		paclogo.draw(550,330);
		g.setColor(Color.black);
		g.fill(rec);
		g.setLineWidth(20);
		g.setColor(Color.cyan);
		g.draw(rec);

		g.setFont(font);

		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		if ((xPos >= size.menu_rec_x && xPos <= size.menu_rec_wdth+size.menu_rec_x) && (yPos >= size.srceen_height-size.menu_rec_y-size.menu_rec_wdth && yPos <= size.srceen_height-size.menu_rec_y)) {
			g.setColor(Color.yellow);
			g.drawString(button, size.menu_rec_x+120, size.menu_rec_y+25);
		}
		else
		{
			g.setColor(Color.white);
			g.drawString(button, size.menu_rec_x+120, size.menu_rec_y+25);
		}
	}

	
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		Input input = gc.getInput();
		
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		if ((xPos >= size.menu_rec_x && xPos <= size.menu_rec_wdth+size.menu_rec_x) && (yPos >= size.srceen_height-size.menu_rec_y-size.menu_rec_wdth && yPos <= size.srceen_height-size.menu_rec_y)) {

			if (input.isMouseButtonDown(0)) {
				game.enterState(1);
			}
		}
	}
	
	public int getID() {
		return 0;
	}
}
