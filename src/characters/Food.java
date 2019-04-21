package characters;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Food {
    private int col;
    private int row;
    private Image food;


    public Food(int col, int row){
        this.col = col;
        this.row = row;
    }

    public void init() throws SlickException {
        food = new Image("image/food/food.png");

    }

}
