package utils;

import board.*;
import java.util.Queue;
import java.util.LinkedList;

public class Utils {
	// 0 = down // 1 = right
	// 2 = up   // 3 = left
	private static int [] di = {1, 0, 0, -1};
	private static int [] dj = {0, 1, -1, 0};
	
	// getting the Board
	private static Size Board = Size.getInstance();
	
	public static int[] getOptimalDirection(int[] pac, int[] ghost) {
		// deep copy another matrix so the original won't be disturbed as we operate
		int [][] matrix_nav = Board.matrix_copy(); 
		
		// arrays of size 2 to indicate [y, x] position  
		int [] cur = new int[2], 
			   nxt = new int[2];
		int [] res = {ghost[0], ghost[1]}; // return variable 
		
		// using Breadth First Search ghosts can find the shortest path to reach Pacman
		Queue <int[]> Q = new LinkedList <int[]>(); 
		
		Q.add(pac); matrix_nav[pac[0]][pac[1]] = 1; // initial sate
		
		while (Q.size() > 0) {
			cur = Q.remove(); // get value in front of Q and remove
			
			for (int k = 0; k < 4; k++) // 4 directions
			{ 
				nxt[0] = cur[0] + di[k];
				nxt[1] = cur[1] + dj[k];
				
				if (nxt[0] >= 0 && nxt[0] < 18 && nxt[1] >= 0 && nxt[1] < 30 && matrix_nav[nxt[0]][nxt[1]] == 0) // within bounds, untouched, not blocked 
				{
					matrix_nav[nxt[0]][nxt[1]] = matrix_nav[cur[0]][cur[1]] + 1;
					
					int [] tmp = {nxt[0], nxt[1]};
					Q.add(tmp);
				}
			}
		}
		
		cur = ghost;
		for (int k = 0; k < 4; k++) {
			nxt[0] = cur[0] + di[k];
			nxt[1] = cur[1] + dj[k];
			
			if (nxt[0] >= 0 && nxt[0] < 18 && nxt[1] >= 0 && nxt[1] < 30 && matrix_nav[nxt[0]][nxt[1]] == matrix_nav[cur[0]][cur[1]] - 1) {
				res = nxt;
				break;
			}
		}
		
		return res;
	}
	
	// false if out of bounds or blocked 
	public static boolean movable(int [] pos, int dy, int dx) {
		return pos[0] + dy < 18 && pos[0] + dy >= 0 && 
			   pos[1] + dx < 30 && pos[1] + dx >= 0 && 
			   Board.board_matrix[pos[0] + dy][pos[1] + dx] != -1;
	}
	
	// 
	public static boolean isBlocked(int Y, int X) {
		return Board.board_matrix[Y][X] == -1;
	}
}
