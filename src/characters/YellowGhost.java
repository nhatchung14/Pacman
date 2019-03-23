package characters;

import org.newdawn.slick.SlickException;

import utils.*;

import java.util.Random;

public class YellowGhost extends Ghost {
	// YellowGhost moves randomly across the board (wall blocked is on)
	Random rd;
	int [] nxt;
	
    public YellowGhost(String imageDir, String color, String extension, float inY, float inX) throws SlickException {
        super(imageDir,color, extension, inY, inX);
        rd = new Random(System.currentTimeMillis());
        nxt = new int[2];
        nxt[0] = (int) (inY/50.0f); 
        nxt[1] = (int) (inX/50.0f);
    }
    
    @Override
    public void moves(Pacman Pac, int delta) {
    	float newGhostY = getY();
    	float newGhostX = getX();
    	
    	// movement when very near Pacman
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
	    	// going to random [y, x] position
    		while (((((int) (newGhostY/50.0f)) == nxt[0] && 
    				 ((int) (newGhostX/50.0f)) == nxt[1])) || 
    				    Utils.isBlocked(nxt[0], nxt[1])) 
    		{
		    	nxt[0] = (rd.nextInt() % 18 + 18) % 18; 
				nxt[1] = (rd.nextInt() % 30 + 30) % 30;
	    	}
			
			// ghost's [y, x] position
			int [] ghost = new int[2];
			ghost[0] = (int) (getY()/50.0f);
			ghost[1] = (int) (getX()/50.0f);
			
			// ghost's new position
			int[] newPos = Utils.getOptimalDirection(nxt, ghost);
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
