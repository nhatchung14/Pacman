public class Size
{
    // static variable single_instance of type Singleton 
    private static Size single_instance = null;

    // variable of type String 
    public int srceen_width=1500;
    public int srceen_height=900;
    public int menu_rec_wdth=100;
    public int menu_rec_height=100;
    public  int[][] board_matrix= new int[30][18];
   /* public int[] moveable= {board_matrix[0][14],
                            board_matrix[1][1],board_matrix[1][2],board_matrix[1][3],board_matrix[1][5],board_matrix[1][8],board_matrix[1][10],board_matrix[1][11],board_matrix[1][12],board_matrix[1][13],board_matrix[1][14],board_matrix[1][15],board_matrix[1][16],board_matrix[1][17],board_matrix[1][18],board_matrix[1][20],board_matrix[1][21],board_matrix[1][22],board_matrix[1][24],board_matrix[1][26],board_matrix[1][27],board_matrix[1][28],
                            board_matrix[2][1],board_matrix[2][3],board_matrix[2][4],board_matrix[2][5],board_matrix[2][7],board_matrix[2][8],board_matrix[2][10],board_matrix[2][14],board_matrix[2][17],board_matrix[2][18],board_matrix[2][19],board_matrix[2][20],board_matrix[2][22],board_matrix[2][23],board_matrix[2][24],board_matrix[2][25],board_matrix[2][26],
                            board_matrix[4][1],board_matrix[4][3],board_matrix[4][5],board_matrix[4][6],board_matrix[4][10],board_matrix[4][11],board_matrix[4][14],board_matrix[4][16],board_matrix[4][21],board_matrix[4][23],board_matrix[4][24],board_matrix[4][26],board_matrix[4][27],
                            board_matrix[5][1],board_matrix[5][2],board_matrix[5][3],board_matrix[5][5],board_matrix[5][6],board_matrix[5][7],board_matrix[5][8],board_matrix[5][9],board_matrix[5][10],board_matrix[5][11],board_matrix[5][12],board_matrix[5][13],board_matrix[5][14],board_matrix[5][15],board_matrix[5][16],board_matrix[5][17],board_matrix[5][18],board_matrix[5][20],board_matrix[5][21],board_matrix[5][22],board_matrix[5][23],board_matrix[5][24],board_matrix[5][26],board_matrix[5][27],board_matrix[5][28],
                            board_matrix[6][1],board_matrix[6][3],board_matrix[6][5],board_matrix[6][8],board_matrix[6][9],board_matrix[6][18],board_matrix[6][19],board_matrix[6][23],board_matrix[6][24],board_matrix[6][25],board_matrix[6][26],board_matrix[6][28],
                            board_matrix[7][1],board_matrix[7][2],board_matrix[7][3],board_matrix[7][4],board_matrix[7][5],board_matrix[7][8],board_matrix[7][9],board_matrix[7][11],board_matrix[7][12],board_matrix[7][13],board_matrix[7][14],board_matrix[7][15],board_matrix[7][16],board_matrix[7][19],board_matrix[7][21],board_matrix[7][23],board_matrix[7][25],board_matrix[7][26],board_matrix[7][27],
                            board_matrix[8][0],board_matrix[8][1],board_matrix[8][5],board_matrix[8][6],board_matrix[8][7],board_matrix[8][9],board_matrix[8][11],board_matrix[8][16],board_matrix[8][17],board_matrix[8][18],board_matrix[8][20],board_matrix[8][21],board_matrix[8][22],board_matrix[8][23],board_matrix[8][24],board_matrix[8][25],board_matrix[8][26],board_matrix[8][27],board_matrix[8][28],board_matrix[8][29],
                            board_matrix[9][1],board_matrix[9][2],board_matrix[9][3],board_matrix[9][5],board_matrix[9][6],board_matrix[9][8],board_matrix[9][9],board_matrix[9][11],board_matrix[9][13],board_matrix[9][14],board_matrix[9][16],board_matrix[9][17],board_matrix[9][18],board_matrix[9][19],board_matrix[9][22],board_matrix[9][25],board_matrix[9][27],
                            board_matrix[10][1],board_matrix[10][3],board_matrix[10][5],board_matrix[10][7],board_matrix[10][8],board_matrix[10][9],board_matrix[10][10],board_matrix[10][13],board_matrix[10][14],board_matrix[10][16],board_matrix[10][19],board_matrix[10][20],board_matrix[10][21],board_matrix[10][22],board_matrix[10][25],board_matrix[10][27],board_matrix[10][28],
                            board_matrix[11][1],board_matrix[11][2],board_matrix[11][3],board_matrix[11][4],board_matrix[11][5],board_matrix[11][6],board_matrix[11][7],board_matrix[11][9],board_matrix[11][10],board_matrix[11][13],board_matrix[11][14],board_matrix[11][16],board_matrix[11][18],board_matrix[11][19],board_matrix[11][21],board_matrix[11][22],board_matrix[11][25],board_matrix[11][26],board_matrix[11][27],board_matrix[11][28],
                            board_matrix[12][1],board_matrix[12][3],board_matrix[12][4],board_matrix[12][6],board_matrix[12][7],board_matrix[12][8],board_matrix[12][9],board_matrix[12][11],board_matrix[12][12],board_matrix[12][13],board_matrix[12][14],board_matrix[12][15],board_matrix[12][16],board_matrix[12][18],board_matrix[12][19],board_matrix[12][21],board_matrix[12][23],board_matrix[12][24],board_matrix[12][26],board_matrix[12][28],
                            board_matrix[13][1],board_matrix[13][3],board_matrix[13][7],board_matrix[13][9],board_matrix[13][12],board_matrix[13][15],board_matrix[13][16],board_matrix[13][18],board_matrix[13][20],board_matrix[13][21],board_matrix[13][22],board_matrix[13][23],board_matrix[13][24],board_matrix[13][25],board_matrix[13][26],board_matrix[13][27],board_matrix[13][28],
                            board_matrix[14][1],board_matrix[14][2],board_matrix[14][3],board_matrix[14][4],board_matrix[14][6],board_matrix[14][7],board_matrix[14][8],board_matrix[14][10],board_matrix[14][11],board_matrix[14][13],board_matrix[14][14],board_matrix[14][16],board_matrix[14][17],board_matrix[14][18],board_matrix[14][19],board_matrix[14][21],board_matrix[14][23],board_matrix[14][24],board_matrix[14][25],board_matrix[14][27],
                            board_matrix[15][1],board_matrix[15][2],board_matrix[15][4],board_matrix[15][5],board_matrix[15][6],board_matrix[15][8],board_matrix[15][9],board_matrix[15][10],board_matrix[15][11],board_matrix[15][12],board_matrix[15][13],board_matrix[15][14],board_matrix[15][15],board_matrix[15][16],board_matrix[15][17],board_matrix[15][18],board_matrix[15][19],board_matrix[15][20],board_matrix[15][21],board_matrix[15][22],board_matrix[15][23],board_matrix[15][25],board_matrix[15][26],board_matrix[15][27],board_matrix[15][28],
                            board_matrix[16][1],board_matrix[16][4],board_matrix[16][6],board_matrix[16][7],board_matrix[16][9],board_matrix[16][10],board_matrix[16][12],board_matrix[16][15],board_matrix[16][16],board_matrix[16][18],board_matrix[16][20],board_matrix[16][21],board_matrix[16][23],board_matrix[16][24],board_matrix[16][25],board_matrix[16][26],board_matrix[16][27],
                            board_matrix[17][18]};


    public int[] cant_move= {board_matrix[0][0],board_matrix[0][1],board_matrix[0][2],board_matrix[0][3],board_matrix[0][4],board_matrix[0][5],board_matrix[0][6],board_matrix[0][7],board_matrix[0][8],board_matrix[0][9],board_matrix[0][10],board_matrix[0][11],board_matrix[0][12],board_matrix[0][13],board_matrix[0][15],board_matrix[0][16],board_matrix[0][17],board_matrix[0][18],board_matrix[0][19],board_matrix[0][20],board_matrix[0][21],board_matrix[0][22],board_matrix[0][23],board_matrix[0][24],board_matrix[0][25],board_matrix[0][26],board_matrix[0][27],board_matrix[0][28],board_matrix[0][29],
                            board_matrix[1][0],board_matrix[1][4],board_matrix[1][6],board_matrix[1][7],board_matrix[1][9],board_matrix[1][19],board_matrix[1][23],board_matrix[1][25],board_matrix[1][29],
                            board_matrix[2][0],board_matrix[2][2],board_matrix[2][6],board_matrix[2][9],board_matrix[2][11],board_matrix[2][12],board_matrix[2][13],board_matrix[2][15],board_matrix[2][16],board_matrix[2][21],board_matrix[2][27],board_matrix[2][28],board_matrix[2][29],
                            board_matrix[4][0],board_matrix[4][2],board_matrix[4][4],board_matrix[4][7],board_matrix[4][8],board_matrix[4][9],board_matrix[4][12],board_matrix[4][13],board_matrix[4][15],board_matrix[4][17],board_matrix[4][18],board_matrix[4][19],board_matrix[4][20],board_matrix[4][22],board_matrix[4][25],board_matrix[4][28],board_matrix[4][29],
                            board_matrix[5][0],board_matrix[5][4],board_matrix[5][19],board_matrix[5][25],board_matrix[5][29],
                            board_matrix[6][0],board_matrix[6][2],board_matrix[6][4],board_matrix[6][6],board_matrix[6][7],board_matrix[6][10],board_matrix[6][11],board_matrix[6][12],board_matrix[6][13],board_matrix[6][14],board_matrix[6][15],board_matrix[6][16],board_matrix[6][17],board_matrix[6][20],board_matrix[6][21],board_matrix[6][22],board_matrix[6][27],board_matrix[6][29],
                            board_matrix[7][0],board_matrix[7][6],board_matrix[7][7],board_matrix[7][10],board_matrix[7][17],board_matrix[7][18],board_matrix[7][20],board_matrix[7][22],board_matrix[7][24],board_matrix[7][28],board_matrix[7][29],
                            board_matrix[8][2],board_matrix[8][3],board_matrix[8][4],board_matrix[8][8],board_matrix[8][10],board_matrix[8][12],board_matrix[8][13],board_matrix[8][14],board_matrix[8][15],board_matrix[8][19],
                            board_matrix[9][0],board_matrix[9][4],board_matrix[9][7],board_matrix[9][10],board_matrix[9][12],board_matrix[9][15],board_matrix[9][20],board_matrix[9][21],board_matrix[9][23],board_matrix[9][24],board_matrix[9][26],board_matrix[9][28],board_matrix[9][29],
                            board_matrix[10][0],board_matrix[10][2],board_matrix[10][4],board_matrix[10][6],board_matrix[10][11],board_matrix[10][12],board_matrix[10][15],board_matrix[10][17],board_matrix[10][18],board_matrix[10][23],board_matrix[10][24],board_matrix[10][26],board_matrix[10][29],
                            board_matrix[11][0],board_matrix[11][8],board_matrix[11][11],board_matrix[11][12],board_matrix[11][15],board_matrix[11][17],board_matrix[11][20],board_matrix[11][23],board_matrix[11][24],board_matrix[11][29],
                            board_matrix[12][0],board_matrix[12][2],board_matrix[12][5],board_matrix[12][10],board_matrix[12][17],board_matrix[12][20],board_matrix[12][22],board_matrix[12][25],board_matrix[12][27],board_matrix[12][29],
                            board_matrix[13][0],board_matrix[13][2],board_matrix[13][4],board_matrix[13][5],board_matrix[13][6],board_matrix[13][8],board_matrix[13][10],board_matrix[13][11],board_matrix[13][13],board_matrix[13][14],board_matrix[13][17],board_matrix[13][19],board_matrix[13][29],
                            board_matrix[14][0],board_matrix[14][5],board_matrix[14][9],board_matrix[14][12],board_matrix[14][15],board_matrix[14][20],board_matrix[14][22],board_matrix[14][26],board_matrix[14][28],board_matrix[14][29],
                            board_matrix[15][0],board_matrix[15][3],board_matrix[15][7],board_matrix[15][24],board_matrix[15][29],
                            board_matrix[16][0],board_matrix[16][2],board_matrix[16][3],board_matrix[16][5],board_matrix[16][8],board_matrix[16][11],board_matrix[16][13],board_matrix[16][14],board_matrix[16][17],board_matrix[16][19],board_matrix[16][22],board_matrix[16][28],board_matrix[16][29],
                            board_matrix[17][0],board_matrix[17][1],board_matrix[17][2],board_matrix[17][3],board_matrix[17][4],board_matrix[17][5],board_matrix[17][6],board_matrix[17][7],board_matrix[17][8],board_matrix[17][9],board_matrix[17][10],board_matrix[17][11],board_matrix[17][12],board_matrix[17][13],board_matrix[17][14],board_matrix[17][15],board_matrix[17][16],board_matrix[17][17],board_matrix[17][19],board_matrix[17][20],board_matrix[17][21],board_matrix[17][22],board_matrix[17][23],board_matrix[17][24],board_matrix[17][25],board_matrix[17][26],board_matrix[17][27],board_matrix[17][28],board_matrix[17][29]};
*/


    // private constructor restricted to this class itself 
    private Size()
    {
    }

    // static method to create instance of Singleton class 
    public static Size getInstance()
    {
        if (single_instance == null)
            single_instance = new Size();
        return single_instance;
    }
} 