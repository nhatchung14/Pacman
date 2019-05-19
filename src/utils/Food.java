package utils;

import board.Size;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Food {

    // Draw food func
    public static void drawFood(float x, float y) throws SlickException {
    	int norm_x = (int) (x / 50.0f);
    	int norm_y = (int) (y / 50.0f);
    	Size.getInstance().setPositionVal( norm_y, norm_x, 1);
    	
        Image food = new Image("image/food/food.png");
        for (int i = 0; i < 18;i++){
            for (int j = 0; j < 30;j++){
                if (Size.getInstance().board_matrix[i][j] == 0){
                    food.draw(10 + j*50,10 + i*50); // j is x axis, i is y axis
                }
            }
        }
    }

    
}
