public class Size
{
    // static variable single_instance of type Singleton 
    private static Size single_instance = null;

    // variable of type String 
    public int srceen_width=1500;
    public int srceen_height=900;
    public int menu_rec_wdth=100;
    public int menu_rec_height=100;
    public  int[][] a= new int[30][18];
    public int[] moveable= new int{a[15][0]
                                  ,a[15][1]
                                  ,a[15][2]
                                  ,a[15][3]
                                  ,a[15][4]
                                  ,a[14][5],a[15][5]};


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