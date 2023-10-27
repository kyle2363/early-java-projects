import java.util.*;
public class Piece_v3 implements Comparable<Piece_v3>
{
    private int x,y,num;
    private char p;
    private Piece_v3[] pA;// upLeft,upMid,upRight,left,right,downLeft,downmid,downright;
    public Piece_v3(char p,int x, int y, int num)
    {
        this.p=p;
        this.x=x;
        this.y=y;
        this.num=num;
        pA=new Piece_v3[10];
    }
    public Piece_v3()
    {
        this(' ',0,0,0);
    }
    
    public void link(Piece_v3 p2,int x)//x=location in array
    {
        System.out.println(x+" "+toString()+" "+p2);
        pA[x]=p2;
    }
    public int checkaround()
    {
        int max=0;
        System.out.println(Arrays.toString(pA));
        for(int i=0;i<8;i++)
        {
            if(pA[x]!=null)
            {
                if(checknext(i)>max)
                {
                }
            }
        }
        return max;
    }
    public int checknext(int x)
    {
        if(pA[x]==null)
        {
            return 0;
        }
        System.out.println(toString()+Arrays.toString(pA));
        return 1+pA[x].checknext(x);
    }
    public int compareTo(Piece_v3 p2)
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
