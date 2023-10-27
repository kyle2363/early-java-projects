
public class Piece_V6 implements Comparable<Piece_V6>
{
    private int x,y,num;
    private char p;
    private Piece_V6 next;
    public Piece_V6(char p,int x, int y, int num)
    {
        this.p=p;
        this.x=x;
        this.y=y;
        this.num=num;
    }
    public Piece_V6()
    {
        this(' ',0,0,0);
    }
    
    public void setX(int x)
    {
        this.x=x;
    }
    public void setY(int y)
    {
        this.y=y;
    }
    
    public void setNext(Piece_V6 p2)
    {
        next=p2;
    }
    public Piece_V6 getNext()
    {
        return next;
    }
    public int compareTo(Piece_V6 p2)
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
    @Override 
    public boolean equals(Object p)
    {
        Piece_V6 p2=(Piece_V6)p;
        return x==p2.getX() && y==p2.getY() && this.p==p2.getP();
    }
    @Override
    public int hashCode()
    {
        return x*y*p;
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
