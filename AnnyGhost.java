import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class AnnyGhost extends Ghosts {

    Animation ghost, ghostUp, ghostDown, ghostLeft, ghostRight;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        Image[] ghostWalkRight = {new Image("./image/ghost_2_0.png"),
                new Image("./image/ghost_2_1.png")};
        Image[] ghostWalkDown = {new Image("./image/ghost_2_2.png"),
                new Image("./image/ghost_2_3.png")};
        Image[] ghostWalkLeft = {new Image("./image/ghost_2_4.png"),
                new Image("./image/ghost_2_5.png")};
        Image[] ghostWalkUp	 = {new Image("./image/ghost_2_6.png"),
                new Image("./image/ghost_2_7.png")};

    }

}
