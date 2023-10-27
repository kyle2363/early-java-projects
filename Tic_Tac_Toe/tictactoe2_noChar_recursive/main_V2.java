import java.util.*;

public class main_V2
{
    public static final int J=1000,K=1000,L=3,M=4 ;//x,y,in row, max
    public static void main(String[] args)
    {
        TreeMap<Integer,ArrayList<Piece_V2>> b=new TreeMap<>();
        //key of treemap is x for y call the value and check the Piece object
        Scanner c=new Scanner(System.in);
        boolean gameend=false;
        int count=0;
        printboradE();
        Piece_V2 tempPiece;
        while(!gameend)
        {
            tempPiece=input(c,1,count,b);
            if(count>=M*2)
            {
                removeFirst(count-M*2,b);
            }
            printborad(b);
            check(b,'X',tempPiece);
            count++;
            tempPiece=input(c,2,count,b);
            if(count>=M*2)
            {
                removeFirst(count-M*2,b);
            }
            printborad(b);
            check(b,'O',tempPiece);
            count++;
        }
    }
    public static void check(TreeMap<Integer,ArrayList<Piece_V2>> b, char cha,Piece_V2 p)
    {
        //System.out.println(p);
        a:for(int i=-1;i<2;i++)//constant loop
        {
            if(b.get(p.getX()+i)!=null)
            {
                for(Piece_V2 n:b.get(p.getX()+i))
                {
                    if(n.getX()!=p.getX()||n.getY()!=p.getY())
                    {
                        if(n.getP()==cha&& n.getY()<=p.getY()+1&&n.getY()>=p.getY()-1)
                        {
                            int row=1+check2(b,cha,p,n.getX()-p.getX(),n.getY()-p.getY());
                            //System.out.println(row);
                            if(row>=L)
                            {
                                System.out.println(cha+" got "+row+" in a row so "+cha+"wins");
                                break a;
                            }
                        }
                    }
                }
            }
        }
    }
    public static int check2(TreeMap<Integer,ArrayList<Piece_V2>>b,char cha,Piece_V2 p,int x,int y)
    {
        return checkr(b,cha,p,x,y)+checkr(b,cha,p,-x,-y);
    }
    public static int checkr(TreeMap<Integer,ArrayList<Piece_V2>>b,char cha,Piece_V2 p,int x,int y)//x=change in x and y= change in y
    {
        //System.out.println("change "+x+" "+y);
        //ArrayList<Piece> temp=b.get(p.getX()+x);
        boolean value=false;
        Piece_V2 next=null;
        if(b.get(p.getX()+x)==null)//temp==null)
        {
            return 0;
        }
        for(Piece_V2 n:b.get(p.getX()+x))//temp)
        {
            if(n.getP()==cha && n.getX()==p.getX()+x && n.getY()==p.getY()+y)
            {
                value=true;
                next=n;
            }
        }
        if(value)
        {
            return 1+checkr(b,cha,next,x,y);
        }else
        {
            return 0;
        }
    }
    public static void removeFirst(int x,TreeMap<Integer,ArrayList<Piece_V2>> b)
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
    public static void printborad(TreeMap<Integer,ArrayList<Piece_V2>> b)
    {
        Collection<ArrayList<Piece_V2>> s=b.values();
        ArrayList<Piece_V2> temp=new ArrayList<>();
        int width=0,minx=0,maxx=0,miny,maxy=0,length=0,maxSpace=1;
        String space=" ";
        for(ArrayList<Piece_V2> n:s)
        {
            temp.addAll(n);
        }
        for(Piece_V2 n:temp)
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
        minx=temp.get(0).getX();
        miny=temp.get(0).getY();
        //try to improve, one idea is have globel var for min max that is check when piece is placed
        // rather than every time it is printed,  need to put everything in a object though
        for(Piece_V2 n:temp)//can be made more efficent 
        {
            if(minx>n.getX())
            {
                minx=n.getX();
            }
            if(maxx<n.getX())
            {
                maxx=n.getX();
            }
            if(miny>n.getY())
            {
                miny=n.getY();
            }
            if(maxy<n.getY())
            {
                maxy=n.getY();
            }
        }
        length=maxy;//extra but keep for change later
        width=maxx;
        //System.out.println(length+1-miny+" "+(width+1-minx));
        char[][] charTemp=new char[length+1-miny][width+1-minx];
        for(Piece_V2 n:temp)
        {
            charTemp[n.getY()-miny][n.getX()-minx]=n.getP();
        }
        System.out.print(space+" ");
        for(int i=0;i<charTemp.length;i++)
        {
            System.out.print("-");
            System.out.print(minx+i);
            System.out.print("-");
            System.out.print(space.substring(0,space.length()-1));
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
    public static void printboradE()
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
    public static Piece_V2 input
    (Scanner c,int n,int count,TreeMap<Integer,ArrayList<Piece_V2>> b)
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
            return input(c,n,count,b);
        }
        int x=Integer.parseInt(info.substring(0,info.indexOf(' ')));
        int y=Integer.parseInt(info.substring(info.indexOf(' ')+1,info.length()));
        if(b.get(x)==null)
        {
            b.put(x,new ArrayList<Piece_V2>());
        }
        Piece_V2 temp=new Piece_V2(p,x,y,count);
        for(Piece_V2 n2:b.get(temp.getX()))
        {
            if(n2.getX()==temp.getX()&&n2.getY()==temp.getY())
            {
                System.out.println("Invalid, pick another");
                return input(c,n,count,b);
            }
        }
        b.get(x).add(temp);//addAll(temp2);
        return temp;
    }
}
