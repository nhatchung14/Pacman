import org.lwjgl.util.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.image.BufferedImage;

// WARNING: NOT YET

public class Ghosts extends BasicGameState {

    public long vulnerableModeStartTime;
    public boolean markAsVulnerable;
    public BufferedImage frame;
    public BufferedImage[] frames;
    public int direction = 0;

    public static enum Mode {CAGE, NORMAL, VULNERABLE, DIED}
    public Mode mode = Mode.CAGE;
    public Point [] initialPositions = {
        new Point(18,11), new Point(16,14),
        new Point(18,14), new Point(20,14)};

    public Ghosts() {

    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }


    private void setMode(Mode mode){
        this.mode = mode;
    }
    public void updatePlaying(){
        switch (mode){
            case CAGE: updateGhostCage(); break;
            case NORMAL: updateGhostNormal();break;
            case DIED: updateGhostDied();break;
            case VULNERABLE: updateGhostVulnerable(); break;
        }
        updateAnimation();
    }

    public void updateAnimation() {
//        int frameIndex = 0;
//        switch (mode){
//            case CAGE:
//            case NORMAL:
//                frameIndex = 2 * direction + (int)(System.nanoTime()*0.0000001) % 2;
//                if (!markAsVulnerable) {
//                    break;
//                }
//            case VULNERABLE:
//                if (System.currentTimeMillis() - vulnerableModeStartTime > 5000) {
//                    frameIndex = 8 + (int) (System.nanoTime() * 0.00000002) % 4;
//                }
//                else {
//                    frameIndex = 8 + (int) (System.nanoTime() * 0.00000001) % 2;
//                }
//                break;
//            case DIED:
//                frameIndex = 12 + direction;
//                break;
//        }
//        frame = frames[frameIndex];
    }

    public void updateGhostDied() {
    }

    public void updateGhostVulnerable() {
        if (markAsVulnerable){
            markAsVulnerable = false;
        }
        if (!checkVulnerableModeTime()){
            setMode(Mode.NORMAL);
        }
    }

    public void updateGhostNormal() {
    }

    public void updateGhostCage() {
    }

    public boolean checkVulnerableModeTime(){
        return System.currentTimeMillis() - vulnerableModeStartTime <= 8000;
    }
    public void startGhostVulnerableMode(){
        vulnerableModeStartTime = System.currentTimeMillis();
        markAsVulnerable = true;
    }
    public void died(){
        setMode(Mode.DIED);
    }
}
