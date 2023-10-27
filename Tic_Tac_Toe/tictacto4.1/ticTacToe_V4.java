import java.util.*;
public class ticTacToe_V4 
{
    //version 5.0  changes since last:
    public int J=3,K=3,L=3,M=4 ;//x,y,in row, max
    TreeMap<Integer,LinkedHashSet<Piece_V4>> b;
    Scanner c=new Scanner(System.in);
    Piece_V4 tempPiece;
    int count,minx,maxx=0,miny,maxy=0;
    boolean gameend=false;
    public ticTacToe_V4(int j,int k, int l, int m)
    {
        J=j; K=k;
        L=l; M=m;
        minx=k;miny=j;
        b=new TreeMap<>();//key of treemap is x for y call the value and check the Piece object
    }
    public void run()
    {
        count=0;
        gameend=false;
        printboradE();
        while(!gameend)
        {
            tempPiece=input(1);
            if(count>=M*2)
            {
                removeFirst(count-M*2);
            }
            printborad();
            check('X',tempPiece);
            count++;
            tempPiece=input(2);
            if(count>=M*2)
            {
                removeFirst(count-M*2);
            }
            printborad();
            check('O',tempPiece);
            count++;
        }
    }
    public void check(char cha,Piece_V4 p)
    {
        //System.out.println(p);
        int row=0;
        for(int i=0;i<4;i++)
        {
            if(p.checknext(i)>row)
            {
                row=p.checknext(i)+p.checknext(8-i);
            }
            //System.out.println(row);
        }
        if(row>=L-1)
        {
            System.out.println("\n"+cha+" got "+(row+1)+" in a row so "+cha+" wins");
            gameend=true;
        }
    }
    public void removeFirst(int x)
    {
        Set<Integer> s= b.keySet();
        for(int n:s)
        {
            if(b.get(n).stream().findFirst().get().getNum()==x)
            {
                System.out.println("check code here");
                b.get(n).remove(0);
            }
        }
    }
    public void printborad()
    {
        Collection<LinkedHashSet<Piece_V4>> s=b.values();
        TreeSet<Piece_V4> temp=new TreeSet<>();
        Piece_V4 refPiece;
        int width=0,length=0,maxSpace=1;
        String space=" ";
        for(LinkedHashSet<Piece_V4> n:s)
        {
            temp.addAll(n);
        }
        Iterator<Piece_V4> itrTemp=temp.iterator();
        refPiece=itrTemp.next();
        while(maxSpace<maxx)//n.getX())
        {
            maxSpace*=10;
        }
        for(int i=10;i<=maxSpace;i*=10)
        {
            space+=" ";
        }
        length=maxy;//extra but keep for change later
        width=maxx;
        System.out.print(space+" ");
        for(int i=1;i<=maxx-minx+1;i++)
        {
            System.out.print("-");
            System.out.print(minx+i-1);
            System.out.print("-");
            System.out.print(" ");
            for(int j=i;j<maxx;j*=10)
            {
                System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0;i<length+1-miny;i++)
        {
            System.out.print(i+miny);
            for(int j=i+miny;j<maxSpace;j=j*10)
            {
                System.out.print(" ");
                if(j==0)
                {
                    j++;  
                }
            }
            System.out.print("|");
            for(int j=0;j<width+1-minx;j++)
            {
                System.out.print("_");
                if(refPiece.getX()==j+minx&&refPiece.getY()==i+miny)
                {
                    System.out.print(refPiece.getP());
                    if(itrTemp.hasNext())
                    {
                        refPiece=itrTemp.next();
                    }
                }else
                {
                    System.out.print("_");
                }
                System.out.print("_"+space);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(space);
        //tweak this 
        for(int i=0;i<maxx-minx+1;i++)
        {
            System.out.print("---");
        }
    }
    public void printboradE()
    {
        for(int i=0;i<5;i++)
        {
            System.out.print("-");
        }
        System.out.println();
        for(int i=0;i<1;i++)
        {
            System.out.print("|");
            System.out.print("___");
            System.out.print("|");
            System.out.println();
        }
        for(int i=0;i<5;i++)
        {
            System.out.print("-");
        }
    }
    public Piece_V4 input(int n)
    {
        String info=c.nextLine();
        int x=0,y=0;
        char p;
        if(n==1)
        {
            p='X';
        }else
        {
            p='O';
        }
        try
        {
            x=Integer.parseInt(info.substring(0,info.indexOf(' ')));
            y=Integer.parseInt(info.substring(info.indexOf(' ')+1,info.length()));
        }catch(Exception e)
        {
            System.out.println("Invalid, pick another");
            return input(n);
        }
        if(Integer.parseInt(info.substring(0,info.indexOf(' ')))>J||
        Integer.parseInt(info.substring(info.indexOf(' ')+1,info.length()))>K)
        {
            System.out.println("Above Max, pick another");
            return input(n);
        }
        if(x<=0||y<=0)
        {
            System.out.println("Invalid, pick another");
            return input(n);
        }
        if(b.get(y)==null)
        {
            b.put(y,new LinkedHashSet<Piece_V4>());
        }
        Piece_V4 temp=new Piece_V4(p,x,y,count);
        if(b.get(y).contains(temp))
        {
            System.out.println("Invalid, pick another");
            return input(n);
        }
        Link(temp,p);
        b.get(y).add(temp);
        checkMinMax(temp);
        return temp;
    }
    public void Link(Piece_V4 temp,char cha)
    {
        for(int i=-1;i<2;i++)
        {
            if(b.get(temp.getY()+i)!=null)
            {
                for(Piece_V4 n:b.get(temp.getY()+i))
                {
                    if(n.getP()==cha && n.getX()<=temp.getX()+1&&n.getX()>=temp.getX()-1)
                    {
                        temp.link(n,((n.getX()-temp.getX()+2)*(i+2))-1);
                        n.link(temp,((temp.getX()-n.getX())+2)*(3-(i+1)));
                    }
                }
            }
        }
    }
    public void checkMinMax(Piece_V4 temp)
    {
        if(minx>temp.getX())
        {
            minx=temp.getX();
        }
        if(maxx<temp.getX())
        {
            maxx=temp.getX();
        }
        if(miny>temp.getY())
        {
            miny=temp.getY();
        }
        if(maxy<temp.getY())
        {
            maxy=temp.getY();
        }
    }
}
