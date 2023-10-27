
public class Piece_V4 implements Comparable<Piece_V4>
{
    private int x,y,num;
    private char p;
    private Piece_V4[] pA;// upLeft,upMid,upRight,left,right,downLeft,downmid,downright;
    public Piece_V4(char p,int x, int y, int num)
    {
        this.p=p;
        this.x=x;
        this.y=y;
        this.num=num;
        pA=new Piece_V4[10];
    }
    public Piece_V4()
    {
        this(' ',0,0,0);
    }
    
    public void link(Piece_V4 p2,int x)//x=location in 3x3
    {
        //System.out.println(x+" "+toString()+" "+p2);
        pA[x]=p2;
        //0 3 6
        //1   7
        //2 5 8
    }
    public int checknext(int x)
    {
        if(pA[x]==null)
        {
            return 0;
        }
        return 1+pA[x].checknext(x);
    }
    public int compareTo(Piece_V4 p2)
    {
        if(y!=p2.getY())
        {
            return y-p2.getY();
        }else
        {
            return x-p2.getX();
        }
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
