
/**
 * Write a description of class piece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Piece_V1
{
    private int x,y,num;
    private char p;
    public Piece_V1(char p,int x, int y, int num)
    {
        this.p=p;
        this.x=x;
        this.y=y;
        this.num=num;
    }
    public Piece_V1()
    {
        this(' ',0,0,0);
    }
    public void resetPiece(char p,int x, int y, int num)
    {
        this.p=p;
        this.x=x;
        this.y=y;
        this.num=num;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public char getP()
    {
        return p;
    }
    public int getNum()
    {
        return num;
    }
    public String toString()
    {
        return x+" "+y+" "+num+" "+p;
    }
}
