
/**
 * Write a description of class tri_test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tri_test
{
    public static void main()
    {
        star1(5,5,5);
    }
    public static void star1(int amountofstars,int row, int ogAmount)
    {
        if(amountofstars<=0 && row>=0)
        {
            System.out.println();
            star1(ogAmount-1,row-1,ogAmount-1);
        }else if (amountofstars>0)
        {
            System.out.print("*");
            star1(amountofstars-1,row,ogAmount);
            //star1();
        }
    }
}
