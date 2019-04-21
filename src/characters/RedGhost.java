package characters;

import org.newdawn.slick.SlickException;

import utils.*;

import java.util.Random;

public class RedGhost extends Ghost {
    // RedGhost chases within 2*X steps in the direction of Pacman
    Random rn;

    public RedGhost(String imageDir, String color, String extension, float inY, float inX) throws SlickException {
        super(imageDir,color, extension, inY, inX);

        rn = new Random(System.currentTimeMillis());
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
        else {
            // chasing pac at [y, x] position
            int [] pac = new int[2];
            pac[0] = (int) (Pac.getY()/50.0f);
            pac[1] = (int) (Pac.getX()/50.0f);

            // chasing 2*X steps within Pacman's direction
            int X = 4,
                    X_n = rn.nextInt() % X;
            int sign = (X_n < 0 ? -1 : 1);

            int ahead = 0;
            switch(Pac.getState()) {
                case 0: // Pacman is moving down
                    for (; ahead < X_n && Utils.movable(pac, sign*(ahead+1), 0); ahead++);
                    pac[0] += ahead;
                    break;
                case 1: // Pacman is moving right
                    for (; ahead < X_n && Utils.movable(pac, 0, sign*(ahead+1)); ahead++);
                    pac[1] += ahead;
                    break;
                case 2: // Pacman is moving up
                    for (; ahead < X_n && Utils.movable(pac, -sign*(ahead+1), 0); ahead++);
                    pac[0] -= ahead;
                    break;
                case 3: // Pacman is moving left
                    for (; ahead < X_n && Utils.movable(pac, 0, -sign*(ahead+1)); ahead++);
                    pac[1] -= ahead;
                    break;
            }

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