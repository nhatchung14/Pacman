import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CakeyGhost extends Ghosts {

    Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        Image[] ghostWalkRight = {new Image("./image/ghost_3_0.png"),
                new Image("./image/ghost_3_1.png")};
        Image[] ghostWalkDown = {new Image("./image/ghost_3_2.png"),
                new Image("./image/ghost_3_3.png")};
        Image[] ghostWalkLeft = {new Image("./image/ghost_3_4.png"),
                new Image("./image/ghost_3_5.png")};
        Image[] ghostWalkUp	 = {new Image("./image/ghost_3_6.png"),
                new Image("./image/ghost_3_7.png")};

    }

}
