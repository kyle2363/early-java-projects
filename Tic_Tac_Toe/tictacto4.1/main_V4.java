import java.util.*;

public class main_V4
{
    public static void main(String[] args)
    {
        startAndGetInput();
    }
    public static void startAndGetInput()
    {
        @SuppressWarnings("resource")
        Scanner c=new Scanner(System.in);
        int j=1000,k=1000,l=3,m=5;
        System.out.println("Type \"c\" (custom) or \"d\"(default) to start");
        String one=c.next();
        if(one.equals("custom"))
        {
            System.out.println("J=");
            j=c.nextInt();
            System.out.println("K=");
            k=c.nextInt();
            System.out.println("L");
            l=c.nextInt();
            System.out.println("M");
            m=c.nextInt();
        }
        ticTacToe_V4 game1=new ticTacToe_V4(j,k,l,m);
        game1.run();
    }
}
