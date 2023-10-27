import java.util.*;
public class main_V1
{
    public static final int J=3,K=3,L=3,M=5 ;//x,y,in row, max
    public static void main(String[] args)
    {
        char[][] borad=new char[J][K];
        ArrayList<Piece_V22> pieces=new ArrayList<>();
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
    public static void check(char[][] b,ArrayList<Piece_V22> p,char cha)
    {
        System.out.println();
        Piece_V22 temp=p.get(p.size()-1);
        int inRow=1,inRowFlat=1,inRowfs=1,inRowbs=1;
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
            if(temp.getX()-i>=0 && cha == b[temp.getY()][temp.getX()-i])
            {
                inRowFlat++;
            }
            if(temp.getX()+i<b.length && cha == b[temp.getY()][temp.getX()+i])
            {
                inRowFlat++;
            }
            if(temp.getX()-i>=0 && temp.getY()-i>=0 && cha == b[temp.getY()-i][temp.getX()-i])
            {
                inRowfs++;
            }
            if(temp.getX()+i<b.length && temp.getY()+i<b[0].length && cha == b[temp.getY()+i][temp.getX()+i])
            {
                inRowfs++;
            }
            if(temp.getX()+i<b.length && temp.getY()-i>=0 && cha == b[temp.getY()-i][temp.getX()+i])
            {
                inRowbs++;
            }
            if(temp.getX()-i>=0 && temp.getY()+i<b[0].length && cha == b[temp.getY()+i][temp.getX()-i])
            {
                inRowbs++;
            }
        }
        if(inRow>=L||inRowfs>=L||inRowbs>=L||inRowFlat>=L)
        {
            System.out.println(cha+" Wins");
        }
    }
    public static void updateChar(ArrayList<Piece_V22> p, char[][] b)
    {
        for(Piece_V22 n:p)
        {
            b[n.getY()][n.getX()]=n.getP();
        }
    }
    public static Piece_V22 input(Scanner c,int n,int count,ArrayList<Piece_V22> pi)
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
        for(Piece_V22 p2:pi)
        {
            if(p2.getX()==x && p2.getY()==y)
            {
                System.out.println("Spot taken, pick another");
                return input(c,n,count,pi);
            }
        }
        return new Piece_V22(p,x,y,count);
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
