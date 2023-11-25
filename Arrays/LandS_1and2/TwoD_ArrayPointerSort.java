package Arrays.LandS_1and2;

public class TwoD_ArrayPointerSort {
    public static void main(String[] args)
    {
        int[][] a=new int[2][10];
        int[] temp={25,35,30,40,10,37,26,32,5,50};
        for(int i=0;i<temp.length;i++)
        {
            a[0][i]=temp[i];
            a[1][i]=-1;
        }
        print(a);
        System.out.println();
        sort(a);
        print2(a);
    }
    public static void sort(int[][] a)
    {
        for(int i=0;i<a[0].length;i++)
        {
            int index=0,min=Integer.MAX_VALUE;
            for(int j=0;j<a[0].length;j++)
            {
                if(a[1][j]==-1&& a[0][j]<min)
                {
                    index=j;
                    min=a[0][j];
                }
            }
            a[1][index]=i;
        }
    }
    public static void print(int[][] a)
    {
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print2(int[][] a)
    {
        for(int i=0;i<a[0].length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                if(a[1][j]==i)
                {
                    System.out.print(a[0][j]+" ");
                }
            }
        }
        System.out.println();
    }
}
