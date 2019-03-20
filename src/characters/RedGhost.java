package characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class RedGhost extends Ghost {

    public RedGhost(String imageDir, String color, String extension) throws SlickException {
        super(imageDir, color, extension);

//        Image[] ghostWalkRight = new Image[2];
//        Image [] ghostWalkDown = new Image[2];
//        Image [] ghostWalkLeft = new Image[2];
//        Image [] ghostWalkUp = new Image[2];
//
//        for (int img = 0; img < 2; img++)	{
//            ghostWalkRight[img] = new Image(imageDir + "red-ghost/lookright" + extension);
//            ghostWalkDown[img]  = new Image(imageDir + "red-ghost/lookdown" + extension);
//            ghostWalkLeft[img]  = new Image(imageDir + "red-ghost/lookleft" + extension);
//            ghostWalkUp[img]    = new Image(imageDir + "red-ghost/lookup" + extension);
//        }
//
//
//        ghostUp = new Animation(ghostWalkRight, ghostDuration, true);
//        ghostDown = new Animation(ghostWalkDown, ghostDuration, true);
//        ghostLeft = new Animation(ghostWalkLeft, ghostDuration, true);
//        ghostRight = new Animation(ghostWalkUp, ghostDuration, true);
//
//        ghost = ghostDown;
    }
}
