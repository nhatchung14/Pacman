package characters;

import org.newdawn.slick.SlickException;
import java.util.Random;

public class BrownGhost extends Ghost {
    // BrownGhost moves randomly across the board (wall block is off)
    private int rangeX = 1400;
    private int rangeY = 800;
    private float nextX;
    private float nextY;

    private Random rn;

    public BrownGhost(String imageDir,String color, String extension, float inY, float inX) throws SlickException {
        super(imageDir,color, extension, inY, inX);

        rn = new Random(System.currentTimeMillis());
        nextY = inY;
        nextX = inX;
    }

    @Override
    public void moves(Pacman Pac, int delta) {
        float newGhostY = getY();
        float newGhostX = getX();

        if (Math.sqrt((getX() - Pac.getX())*(getX() - Pac.getX()) +
                (getY() - Pac.getY())*(getY() - Pac.getY()))/50.0f
                < 4.0f)
        {
            if (getX() - Pac.getX() > 0)
                newGhostX -= delta * .15f;
            else if (getX() - Pac.getX() < 0)
                newGhostX += delta * .15f;

            if (getY() - Pac.getY() > 0)
                newGhostY -= delta * .15f;
            else if (getY() - Pac.getY() < 0)
                newGhostY += delta * .15f;
        }
        else
        {
            // when ghost is within 5 pixels of distance to destination -> new destination
            if (Math.sqrt((getX() - nextX)*(getX() - nextX) +
                    (getY() - nextY)*(getY() - nextY)) < 5.0f)
            {
                nextX = rn.nextFloat() * rangeX;
                nextY = rn.nextFloat() * rangeY;
            }
            if (getX() - nextX > 0)
                newGhostX -= delta * .1f;
            else if (getX() - nextX < 0)
                newGhostX += delta * .1f;

            if (getY() - nextY > 0)
                newGhostY -= delta * .1f;
            else if (getY() - nextY < 0)
                newGhostY += delta * .1f;
        }

        this.setX(newGhostX);
        this.setY(newGhostY);
    }
}