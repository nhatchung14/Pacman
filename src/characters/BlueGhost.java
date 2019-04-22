package characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import utils.*;

public class BlueGhost extends Ghost {
    // BlueGhost chases Pacman using BFS

    public BlueGhost(String imageDir, String color, String extension, float inY, float inX) throws SlickException {
        super(imageDir,color, extension, inY, inX);
    }

    @Override
    public void moves(Pacman Pac, int delta) {
        float newGhostY = getY();
        float newGhostX = getX();

        // movement when very near
        if (Math.sqrt((getX() - Pac.getX())*(getX() - Pac.getX()) +
                (getY() - Pac.getY())*(getY() - Pac.getY()))/50.0f
                < 2.0)
        {
            if (getX() - Pac.getX() > 0)
                newGhostX -= delta * .2f;
            else if (getX() - Pac.getX() < 0)
                newGhostX += delta * .2f;

            if (getY() - Pac.getY() > 0)
                newGhostY -= delta * .2f;
            else if (getY() - Pac.getY() < 0)
                newGhostY += delta * .2f;
        }
        else // movement with some distance
        {
            // pac [y, x] position
            int [] pac = new int[2];
            pac[0] = (int) (Pac.getY()/50.0f);
            pac[1] = (int) (Pac.getX()/50.0f);

            // ghost's [y, x] position
            int [] ghost = new int[2];
            ghost[0] = (int) (getY()/50.0f);
            ghost[1] = (int) (getX()/50.0f);

            // ghost's new position
            int[] newPos = Utils.getOptimalDirection(pac, ghost);

            newGhostY += (newPos[0] - ghost[0])*delta*.15f;
            newGhostX += (newPos[1] - ghost[1])*delta*.15f;
        }

        // if next position is blocked then there wouldn't be changes
        if (Utils.isBlocked((int) (newGhostY/50.0f), (int) (newGhostX/50.0f))) {
            newGhostY = getY();
            newGhostX = getX();
        }

        this.setY(newGhostY);
        this.setX(newGhostX);
    }
}