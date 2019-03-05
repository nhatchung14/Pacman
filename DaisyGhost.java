import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DaisyGhost extends Ghosts{

    Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        Image[] ghostWalkRight = {new Image("./image/ghost_1_0.png"),
                new Image("./image/ghost_1_1.png")};
        Image[] ghostWalkDown = {new Image("./image/ghost_1_2.png"),
                new Image("./image/ghost_1_3.png")};
        Image[] ghostWalkLeft = {new Image("./image/ghost_1_4.png"),
                new Image("./image/ghost_1_5.png")};
        Image[] ghostWalkUp	 = {new Image("./image/ghost_1_6.png"),
                new Image("./image/ghost_1_7.png")};

    }

}
