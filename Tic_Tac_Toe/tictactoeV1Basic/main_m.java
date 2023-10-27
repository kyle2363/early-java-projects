import java.util.*;
public class main_m
{
    public static final int J=4,K=4,L=3,M=3;//x,y,in row, max
    public static void main(String[] args)
    {
        char[][] borad=new char[J][K];
        ArrayList<Piece_v3> pieces=new ArrayList<>();
        boolean gameend=false;
        Scanner c=new Scanner(System.in);
        int count=0;
        for(int i=0;i<borad[0].length;i++)
        {
            for(int j=0;j<borad.length;j++)
            {
                borad[i][j]='_';
            }
        }
        printborad(borad);
        while(!gameend)
        {
            pieces.add(input(c,1,count,pieces));
            if(count>=M)
            {
                borad[pieces.get(0).getY()][pieces.get(0).getX()]='_';
                pieces.remove(0);
            }
            updateChar(pieces,borad);
            printborad(borad);
            check(borad,pieces,'X');
            pieces.add(input(c,2,count,pieces));
            if(count>=M)
            {
                borad[pieces.get(0).getY()][pieces.get(0).getX()]='_';
                pieces.remove(0);
            }
            updateChar(pieces,borad);
            check(borad,pieces,'O');
            printborad(borad);
            count++;
        }
    }
    public static void check(char[][] b,ArrayList<Piece_v3> p,char cha)
    {
        System.out.println();
        Piece_v3 temp=p.get(p.size()-1);
        int inRow=1;
        for(int i=1;i<=L;i++)
        {
            if(temp.getY()-i>=0 && cha == b[temp.getY()-i][temp.getX()])
            {
                inRow++;
            }
            if(temp.getY()+i<b[0].length && cha == b[temp.getY()+i][temp.getX()])
            {
                inRow++;
            }
        }
        if(inRow>=L)
        {
            System.out.println(cha+" Wins");
        }
        inRow=1;
        for(int i=1;i<=L;i++)
        {
            if(temp.getX()-i>=0 && cha == b[temp.getY()][temp.getX()-i])
            {
                inRow++;
            }
            if(temp.getX()+i<b.length && cha == b[temp.getY()][temp.getX()+i])
            {
                inRow++;
            }
            
        }
        if(inRow>=L)
        {
            System.out.println(cha+" Wins");
        }
        inRow=1;
        for(int i=1;i<=L;i++)
        {
            if(temp.getX()-i>=0 && temp.getY()-i>=0 && cha == b[temp.getY()-i][temp.getX()-i])
            {
                inRow++;
            }
            if(temp.getX()+i<b.length && temp.getY()+i<b[0].length && cha == b[temp.getY()+i][temp.getX()+i])
            {
                inRow++;
            }
            
        }
        if(inRow>=L)
        {
            System.out.println(cha+" Wins");
        }
        inRow=1;
        for(int i=1;i<=L;i++)
        {
            if(temp.getX()+i<b.length && temp.getY()-i>=0 && cha == b[temp.getY()-i][temp.getX()+i])
            {
                inRow++;
            }
            if(temp.getX()-i>=0 && temp.getY()+i<b[0].length && cha == b[temp.getY()+i][temp.getX()-i])
            {
                inRow++;
            }
        }
        if(inRow>=L)
        {
            System.out.println(cha+" Wins");
        }
    }
    public static void updateChar(ArrayList<Piece_v3> p, char[][] b)
    {
        for(Piece_v3 n:p)
        {
            b[n.getY()][n.getX()]=n.getP();
        }
    }
    public static Piece_v3 input(Scanner c,int n,int count,ArrayList<Piece_v3> pi)
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
        if(info.indexOf(" ")==-1)
        {
            System.out.println("Invalid, pick another");
            return input(c,n,count,pi);
        }
        int x=Integer.parseInt(info.substring(0,info.indexOf(' ')));
        int y=Integer.parseInt(info.substring(info.indexOf(' ')+1,info.length()));
        for(Piece_v3 p2:pi)
        {
            if(p2.getX()==x && p2.getY()==y)
            {
                System.out.println("Spot taken, pick another");
                return input(c,n,count,pi);
            }
        }
        return new Piece_v3(p,x,y,count);
    }
    public static void printborad(char[][] b)
    {
        for(int i=0;i<b.length*3+2;i++)
        {
            System.out.print("-");
        }
        System.out.println();
        for(int i=0;i<b[0].length;i++)
        {
            System.out.print("|");
            for(int j=0;j<b.length;j++)
            {
                System.out.print("_"+b[i][j]+"_");
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i=0;i<b.length*3+2;i++)
        {
            System.out.print("-");
        }
    }
}
