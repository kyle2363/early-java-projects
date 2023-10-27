public class Piece_V22
{
    private int x,y,num;
    private char p;
    //private Piece upLeft,upMid,upRight,left,right,downLeft,downmid,downright;
    public Piece_V22(char p,int x, int y, int num)
    {
        this.p=p;
        this.x=x;
        this.y=y;
        this.num=num;
    }
    public Piece_V22()
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