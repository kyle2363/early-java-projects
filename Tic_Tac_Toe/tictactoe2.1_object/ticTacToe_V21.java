import java.util.*;
public class ticTacToe_V21 
{
    public int J=1000,K=1000,L=3,M=4 ;//x,y,in row, max
    TreeMap<Integer,LinkedList<Piece_V21>> b;
    Scanner c=new Scanner(System.in);
    Piece_V21 tempPiece;
    int count,minx,maxx=0,miny,maxy=0;
    boolean gameend=false;
    public ticTacToe_V21(int j,int k, int l, int m)
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
    public void check(char cha,Piece_V21 p)
    {
        //System.out.println(p);
        a:for(int i=-1;i<2;i++)
        {
            if(b.get(p.getX()+i)!=null)
            {
                for(Piece_V21 n:b.get(p.getX()+i))
                {
                    if(n.getX()!=p.getX()||n.getY()!=p.getY())
                    {
                        if(n.getP()==cha&& n.getY()<=p.getY()+1&&n.getY()>=p.getY()-1)
                        {
                            int row=1+check2(cha,p,n.getX()-p.getX(),n.getY()-p.getY());
                            //System.out.println(row);
                            if(row>=L)
                            {
                                System.out.println("\n"+cha+" got "+row+" in a row so "+cha+"wins");
                                gameend=true;
                                break a;
                            }
                        }
                    }
                }
            }
        }
    }
    public int check2(char cha,Piece_V21 p,int x,int y)
    {
        return checkr(cha,p,x,y)+checkr(cha,p,-x,-y);
    }
    public int checkr(char cha,Piece_V21 p,int x,int y)//x=change in x and y= change in y
    {
        //System.out.println("change "+x+" "+y);
        //ArrayList<Piece> temp=b.get(p.getX()+x);
        boolean value=false;
        Piece_V21 next=null;
        if(b.get(p.getX()+x)==null)//temp==null)
        {
            return 0;
        }
        for(Piece_V21 n:b.get(p.getX()+x))//temp)
        {
            if(n.getP()==cha && n.getX()==p.getX()+x && n.getY()==p.getY()+y)
            {
                value=true;
                next=n;
            }
        }
        if(value)
        {
            return 1+checkr(cha,next,x,y);
        }else
        {
            return 0;
        }
    }
    public void removeFirst(int x)
    {
        Set<Integer> s= b.keySet();
        for(int n:s)
        {
            if(b.get(n).get(0).getNum()==x)
            {
                b.get(n).remove(0);
            }
        }
    }
    public void printborad()
    {
        Collection<LinkedList<Piece_V21>> s=b.values();
        LinkedList<Piece_V21> temp=new LinkedList<>();
        int width=0,length=0,maxSpace=1;
        String space=" ";
        for(LinkedList<Piece_V21> n:s)
        {
            temp.addAll(n);
        }
        for(Piece_V21 n:temp)
        {
            if(maxSpace<n.getX())
            {
                while(maxSpace<n.getX())
                {
                    maxSpace*=10;
                }
            }
        }
        for(int i=10;i<=maxSpace;i*=10)
        {
            space+=" ";
        }
        length=maxy;//extra but keep for change later
        width=maxx;
        //System.out.println(maxx+" "+maxy+" "+minx+" "+miny);
        char[][] charTemp=new char[length+1-miny][width+1-minx];
        for(Piece_V21 n:temp)
        {
            charTemp[n.getY()-miny][n.getX()-minx]=n.getP();
        }
        System.out.print(space+" ");
        for(int i=1;i<=charTemp.length;i++)
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
                System.out.print("_"+charTemp[i][j]+"_");
                if(charTemp[i][j]==0)
                {
                    System.out.print("_");
                }
                System.out.print(space);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(space);
        //tweak this 
        for(int i=0;i<charTemp.length*space.length();i++)
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
    public Piece_V21 input(int n)
    {
        String info=c.nextLine();
        char p;
        if(n==1)
        {
            p='X';
        }else
        {
            p='O';
        }
        if(info.indexOf(" ")==-1||info.indexOf(" ")==info.length()-1||
        Integer.parseInt(info.substring(0,info.indexOf(' ')))>J||
        Integer.parseInt(info.substring(info.indexOf(' ')+1,info.length()))>K)
        {
            System.out.println("Invalid, pick another");
            return input(n);
        }
        int x=Integer.parseInt(info.substring(0,info.indexOf(' ')));
        int y=Integer.parseInt(info.substring(info.indexOf(' ')+1,info.length()));
        if(b.get(x)==null)
        {
            b.put(x,new LinkedList<Piece_V21>());
        }
        Piece_V21 temp=new Piece_V21(p,x,y,count);
        for(Piece_V21 n2:b.get(temp.getX()))
        {
            if(n2.getX()==temp.getX()&&n2.getY()==temp.getY())
            {
                System.out.println("Invalid, pick another");
                return input(n);
            }
        }
        b.get(x).add(temp);//addAll(temp2);
        checkMinMax(temp);
        return temp;
    }
    public void checkMinMax(Piece_V21 temp)
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
