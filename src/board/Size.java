package board;

public class Size {
    // static variable single_instance of type Singleton
    private static Size single_instance = null;

    // variable of type String
    public int srceen_width = 1500;
    public int srceen_height = 900;
    // menu part
    public int menu_rec_wdth = 300;
    public int menu_rec_height = 100;
    public int menu_rec_x = 600, menu_rec_y = 600;

    //exit part
    public int exit_title_x=250,exit_title_y=100;
    public int exit_button_width=300,exit_button_height=100;
    public int exit_menu_buttonX=exit_title_x+100,exit_menu_buttonY=exit_title_y+400;
    public int exit_buttonX=exit_title_x+600,exit_buttonY=exit_title_y+400;


    public int[][] board_matrix = new int[18][30];

    // private constructor restricted to this class itself
    private Size() {
        refresh();
    }
    
    public void refresh() {
    	for (int i = 0; i < 18; i++) {
    		for (int j = 0; j < 30; j++)
    			board_matrix[i][j] = 0;
    	}
    	
    	// blockages
        board_matrix[0][0] = board_matrix[0][1] = board_matrix[0][2] = board_matrix[0][3] = board_matrix[0][4] = board_matrix[0][5] = board_matrix[0][6] = board_matrix[0][7] = board_matrix[0][8] = board_matrix[0][9] = board_matrix[0][10] = board_matrix[0][11] = board_matrix[0][12] = board_matrix[0][13] = board_matrix[0][15] = board_matrix[0][16] = board_matrix[0][17] = board_matrix[0][18] = board_matrix[0][19] = board_matrix[0][20] = board_matrix[0][21] = board_matrix[0][22] = board_matrix[0][23] = board_matrix[0][24] = board_matrix[0][25] = board_matrix[0][26] = board_matrix[0][27] = board_matrix[0][28] = board_matrix[0][29] =
                board_matrix[1][0] = board_matrix[1][4] = board_matrix[1][6] = board_matrix[1][7] = board_matrix[1][9] = board_matrix[1][19] = board_matrix[1][23] = board_matrix[1][25] = board_matrix[1][29] =
                        board_matrix[2][0] = board_matrix[2][2] = board_matrix[2][6] = board_matrix[2][9] = board_matrix[2][11] = board_matrix[2][12] = board_matrix[2][13] = board_matrix[2][15] = board_matrix[2][16] = board_matrix[2][27] = board_matrix[2][28] = board_matrix[2][29] =
                                board_matrix[3][0] = board_matrix[3][3] = board_matrix[3][9] = board_matrix[3][13] = board_matrix[3][15] = board_matrix[3][19] = board_matrix[3][24] = board_matrix[3][26] = board_matrix[3][29] =
                                        board_matrix[4][0] = board_matrix[4][2] = board_matrix[4][4] = board_matrix[4][7] = board_matrix[4][8] = board_matrix[4][9] = board_matrix[4][12] = board_matrix[4][13] = board_matrix[4][15] = board_matrix[4][17] = board_matrix[4][18] = board_matrix[4][19] = board_matrix[4][20] = board_matrix[4][22] = board_matrix[4][25] = board_matrix[4][28] = board_matrix[4][29] =
                                                board_matrix[5][0] = board_matrix[5][4] = board_matrix[5][19] = board_matrix[5][25] = board_matrix[5][29] =
                                                        board_matrix[6][0] = board_matrix[6][2] = board_matrix[6][4] = board_matrix[6][6] = board_matrix[6][7] = board_matrix[6][10] = board_matrix[6][11] = board_matrix[6][12] = board_matrix[6][13] = board_matrix[6][14] = board_matrix[6][15] = board_matrix[6][16] = board_matrix[6][17] = board_matrix[6][20] = board_matrix[6][21] = board_matrix[6][22] = board_matrix[6][27] = board_matrix[6][29] =
                                                                board_matrix[7][0] = board_matrix[7][6] = board_matrix[7][7] = board_matrix[7][10] = board_matrix[7][17] = board_matrix[7][18] = board_matrix[7][20] = board_matrix[7][22] = board_matrix[7][24] = board_matrix[7][28] = board_matrix[7][29] =
                                                                        board_matrix[8][0] = board_matrix[8][2] = board_matrix[8][3] = board_matrix[8][4] = board_matrix[8][8] = board_matrix[8][10] = board_matrix[8][12] = board_matrix[8][13] = board_matrix[8][14] = board_matrix[8][15] = board_matrix[8][19] =
                                                                                board_matrix[9][4] = board_matrix[9][7] = board_matrix[9][10] = board_matrix[9][12] = board_matrix[9][15] = board_matrix[9][20] = board_matrix[9][21] = board_matrix[9][23] = board_matrix[9][24] = board_matrix[9][26] = board_matrix[9][28] = board_matrix[9][29] =
                                                                                        board_matrix[10][0] = board_matrix[10][2] = board_matrix[10][4] = board_matrix[10][6] = board_matrix[10][11] = board_matrix[10][12] = board_matrix[10][15] = board_matrix[10][17] = board_matrix[10][18] = board_matrix[10][23] = board_matrix[10][24] = board_matrix[10][26] = board_matrix[10][29] =
                                                                                                board_matrix[11][0] = board_matrix[11][8] = board_matrix[11][11] = board_matrix[11][12] = board_matrix[11][15] = board_matrix[11][17] = board_matrix[11][20] = board_matrix[11][23] = board_matrix[11][24] = board_matrix[11][29] =
                                                                                                        board_matrix[12][0] = board_matrix[12][2] = board_matrix[12][5] = board_matrix[12][10] = board_matrix[12][17] = board_matrix[12][20] = board_matrix[12][22] = board_matrix[12][25] = board_matrix[12][27] = board_matrix[12][29] =
                                                                                                                board_matrix[13][0] = board_matrix[13][2] = board_matrix[13][4] = board_matrix[13][5] = board_matrix[13][6] = board_matrix[13][8] = board_matrix[13][10] = board_matrix[13][11] = board_matrix[13][13] = board_matrix[13][14] = board_matrix[13][17] = board_matrix[13][19] = board_matrix[13][29] =
                                                                                                                        board_matrix[14][0] = board_matrix[14][5] = board_matrix[14][9] = board_matrix[14][12] = board_matrix[14][15] = board_matrix[14][20] = board_matrix[14][22] = board_matrix[14][26] = board_matrix[14][28] = board_matrix[14][29] =
                                                                                                                                board_matrix[15][0] = board_matrix[15][3] = board_matrix[15][7] = board_matrix[15][24] = board_matrix[15][29] =
                                                                                                                                        board_matrix[16][0] = board_matrix[16][2] = board_matrix[16][3] = board_matrix[16][5] = board_matrix[16][8] = board_matrix[16][11] = board_matrix[16][13] = board_matrix[16][14] = board_matrix[16][17] = board_matrix[16][19] = board_matrix[16][22] = board_matrix[16][28] = board_matrix[16][29] =
                                                                                                                                                board_matrix[17][0] = board_matrix[17][1] = board_matrix[17][2] = board_matrix[17][3] = board_matrix[17][4] = board_matrix[17][5] = board_matrix[17][6] = board_matrix[17][7] = board_matrix[17][8] = board_matrix[17][9] = board_matrix[17][10] = board_matrix[17][11] = board_matrix[17][12] = board_matrix[17][13] = board_matrix[17][14] = board_matrix[17][15] = board_matrix[17][16] = board_matrix[17][17] = board_matrix[17][19] = board_matrix[17][20] = board_matrix[17][21] = board_matrix[17][22] = board_matrix[17][23] = board_matrix[17][24] = board_matrix[17][25] = board_matrix[17][26] = board_matrix[17][27] = board_matrix[17][28] = board_matrix[17][29] =
                                                                                                                                                        -1;
    }
    
    // static method to create instance of Singleton class
    public static Size getInstance() {
        if (single_instance == null)
            single_instance = new Size();
        return single_instance;
    }

    // return a deep binary copy of board_matrix
    public int[][] matrix_copy() {
        int[][] result = new int[18][30];
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 30; j++) {
                result[i][j] = board_matrix[i][j];
                if (result[i][j] > 0) 
                	result[i][j] = 0;
            }
        }
        return result;
    }
    
    public void setPositionVal(int i, int j, int val) {
    	  // if at that pos, the val != 1 which mean pacman eat food, and add score 25
        if(board_matrix[i][j] != val)
    	    pacman.score += 25;
        board_matrix[i][j] = val;
    }
    
}
