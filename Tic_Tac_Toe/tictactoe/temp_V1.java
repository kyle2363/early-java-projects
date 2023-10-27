import java.util.ArrayList;

/**
 * Write a description of class temp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class temp_V1
{
    static int L=0;
    public static void main()
    {
        check(null,null,'x');
    }
    public static void check(char[][] b,ArrayList<Piece_v3> p,char cha)
    {
        System.out.println();
        Piece_v3 temp=p.get(p.size()-1);
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
}
