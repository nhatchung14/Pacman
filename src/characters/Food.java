package characters;

import board.Size;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Food {
    private float foodPosX;
    private float foodPosY;

    public float getFoodPosX() {
        return foodPosX;
    }

    public void setFoodPosX(float foodPosX) {
        this.foodPosX = foodPosX;
    }

    public float getFoodPosY() {
        return foodPosY;
    }

    public void setFoodPosY(float foodPosY) {
        this.foodPosY = foodPosY;
    }

    // Draw food func
    public void drawFood()throws SlickException{
        Image food = new Image("image/food/food.png");
        //food.draw(50, 50);
        //food.draw(50, 150);
        for (int i = 0; i < 18;i++){
            for (int j = 0; j < 30;j++){
                if (Size.getInstance().board_matrix[i][j] != -1){
                    food.draw(10 + j*50,10 + i*50); // j is x axis, i is y axis
                    setFoodPosX(10 + j*50);
                    setFoodPosY(10 + i*50);
                }
            }
        }
    }


}
