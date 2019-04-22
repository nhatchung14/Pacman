package utils;

import org.newdawn.slick.SlickException;
import characters.*;

public class GhostFactory {
    public static Ghost newGhost(String imageDir,
                                 String color,
                                 String extension,
                                 float inX, float inY) throws SlickException
    {
        if 		(color == "blue")
            return new BlueGhost(imageDir, color, extension, inX, inY);
        else if (color == "brown")
            return new BrownGhost(imageDir, color, extension, inX, inY);
        else if (color == "yellow")
            return new YellowGhost(imageDir, color, extension, inX, inY);
        else if (color == "red")
            return new RedGhost(imageDir, color, extension, inX, inY);

        return null;
    }
}