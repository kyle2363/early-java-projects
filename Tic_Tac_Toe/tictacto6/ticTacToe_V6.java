import java.util.*;
public class ticTacToe_V6 
{
    //ideas 
    //done print with count,remove links completly by using contains,
    //update remove first with links
    public int J=3,K=3,L=3,M=5 ;//x,y,in row, max
    TreeMap<Integer,LinkedHashSet<Piece_V6>> b;
    Scanner c=new Scanner(System.in);
    Piece_V6 tempPiece,cfront,cend,tempRemove;
    int count,minx,maxx=0,miny,maxy=0,offSet=0;
    boolean gameend=false;
    public ticTacToe_V6(int j,int k, int l, int m)
    {
        J=j; K=k;
        L=l; M=m;
        minx=k;miny=j;
        b=new TreeMap<>();//key of treemap is x for y call the value and check the Piece object
    }
    public void run()
    {
        //System.out.println(M+" "+L);
        count=0;
        gameend=false;
        printboradE();
        while(!gameend)
        {
            tempPiece=input(1);
            if(count>=M*2)
            {
                removeFirst(count-M*2);
                offSet++;
            }
            printborad();
            check('X',tempPiece);
            count++;
            tempPiece=input(2);
            if(count>=M*2)
            {
                removeFirst(count-M*2);
                offSet++;
            }
            printborad();
            check('O',tempPiece);
            count++;
        }
    }
    public void check(char cha,Piece_V6 p)
    {
        //System.out.println(p);
        int row=0;
        Piece_V6 temp=new Piece_V6(p.getP(),p.getX(),p.getY(),0);
        for(int i=-1;i<2;i++)
        {
            if(b.get(p.getY()+i)!=null)
            {
                for(int j=-1;j<2;j++)
                {
                    temp.setX(p.getX()+j);
                    temp.setY(p.getY()+i);
                    if(b.get(p.getY()+i)!=null&&
                    b.get(p.getY()+i).contains(temp)&&!p.equals(temp))
                    {
                        int rowtemp=checkRec(j,i,p,temp,1)+checkRec(-j,-i,p,temp,1);
                        //System.out.println(rowtemp);
                        if(rowtemp>row)
                        {
                            row=rowtemp;
                        }
                    }
                }
            }
        }
        System.out.println(row);
        if(row>=L-1)
        {
            System.out.println("\n"+cha+" got "+(row+1)+" in a row so "+cha+" wins");
            gameend=true;
        }
    }
    public int checkRec(int x,int y,Piece_V6 ref,Piece_V6 temp,int d)//d=distance from ref
    {
        temp.setX(ref.getX()+(x*d));
        temp.setY(ref.getY()+(y*d));
        if(b.get(ref.getY()+y*d)==null || !b.get(ref.getY()+y*d).contains(temp))
        {
            return 0;
        }else
        {
            return  1+checkRec(x,y,ref,temp,d+1);
        }
    }
    public void removeFirst(int x)
    {
        tempRemove=cfront;
        cfront=cfront.getNext();
        b.get(tempRemove.getY()).remove(tempRemove);
    }
    public void printborad()
    {
        Collection<LinkedHashSet<Piece_V6>> s=b.values();
        TreeSet<Piece_V6> temp=new TreeSet<>();
        Piece_V6 refPiece;
        int width=0,length=0,maxSpace=1;
        String space=" ";
        for(LinkedHashSet<Piece_V6> n:s)
        {
            temp.addAll(n);
        }
        System.out.println(temp);
        Iterator<Piece_V6> itrTemp=temp.iterator();
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
                    System.out.print(refPiece.getP()+""+(refPiece.getNum()-offSet));
                    if(itrTemp.hasNext())
                    {
                        refPiece=itrTemp.next();
                    }
                }else
                {
                    System.out.print("__");
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
    public Piece_V6 input(int n)
    {
        String info=c.nextLine();
        int x=0,y=0;
        char p;
        if(n==1){ p='X'; }else{ p='O'; }
        try{
            x=Integer.parseInt(info.substring(0,info.indexOf(' ')));
            y=Integer.parseInt(info.substring(info.indexOf(' ')+1,info.length()));
        }catch(Exception e){
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
            b.put(y,new LinkedHashSet<Piece_V6>());
        }
        Piece_V6 temp=new Piece_V6(p,x,y,count);
        if(b.get(y).contains(temp)||b.get(y).contains(new Piece_V6('X',x,y,count))
           ||b.get(y).contains(new Piece_V6('O',x,y,count)))
        {
            System.out.println("Invalid, pick another");
            return input(n);
        }
        if(count==0)
        {
            cfront=temp;
            cend=temp;
        }else
        {
            cend.setNext(temp);
            cend=temp;
        }
        b.get(y).add(temp);
        checkMinMax(temp);
        return temp;
    }
    public void checkMinMax(Piece_V6 temp)
    {
        if(minx>temp.getX()){
            minx=temp.getX();
        }
        if(maxx<temp.getX()){
            maxx=temp.getX();
        }
        if(miny>temp.getY()){
            miny=temp.getY();
        }
        if(maxy<temp.getY()){
            maxy=temp.getY();
        }
    }
}
