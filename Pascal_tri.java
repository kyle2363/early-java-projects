//Kyle Huang
public class Pascal_tri{
    public static void main(String[] args) 
    {
        System.out.println("Tri #1");
        p1(9);
        System.out.println();
        System.out.println("Tri #2");
        p2(9);
        System.out.println();
        System.out.println("Tri #3");
        p3(9);
        System.out.println();
        System.out.println("Tri #4");
        p4(7);
    }
    public static void p1(int r)//rows count
    {
        int[][] p1=new int[r][r*2+1];
        p1[0][r]=1;
        for(int i=1;i<r;i++)
        {
            for(int j=p1.length-i;j<p1.length*2;j+=2)
            {
                    if(j>0&&j<p1.length*2)
                    {
                        p1[i][j]=p1[i-1][j-1]+p1[i-1][j+1];
                    }else
                    {
                        p1[i][j]=1;
                    }
                
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<=p1.length*2;j++)
            {
                if(p1[i][j]==0)
                {
                    System.out.print("   ");
                }else{
                    if(p1[i][j]<10)
                    {
                        System.out.print(p1[i][j]+"  ");
                    }else
                    {
                        System.out.print(p1[i][j]+" ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void p2(int r)//rows count
    {
        int[][] p1=new int[r][r];
        p1[0][0]=1;
        for(int i=1;i<r;i++)
        {
            for(int j=0;j<p1.length;j++)
            {
                    if(j>0&&j<p1.length*2)
                    {
                        p1[i][j]=p1[i-1][j-1]+p1[i-1][j];
                    }else
                    {
                        p1[i][j]=1;
                    }
                
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<p1.length;j++)
            {
                if(p1[i][j]==0)
                {
                    System.out.print("   ");
                }else{
                    if(p1[i][j]<10)
                    {
                        System.out.print(p1[i][j]+"  ");
                    }else
                    {
                        System.out.print(p1[i][j]+" ");
                    }
                }
            }
            System.out.println();
        }
        for(int i=0;i<r;i++)
        {
            for(int k=0;k<r*2-i*2;k++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<p1.length;j++)
            {
                if(p1[i][j]==0)
                {
                    System.out.print("   ");
                }else{
                    if(p1[i][j]<10)
                    {
                        System.out.print(p1[i][j]+"   ");
                    }else
                    {
                        System.out.print(p1[i][j]+"  ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void p3(int r)//rows count
    {
        int[][] p1=new int[r][r/2+1];
        p1[0][0]=1;
        for(int i=1;i<r;i++)
        {
            for(int j=0;j<=i/2;j++)
            {
                    if(j>0&&j<i/2)
                    {
                        p1[i][j]=p1[i-1][j-1]+p1[i-1][j];
                    }else
                    {
                        if(j==0)
                        {
                            p1[i][j]=1;
                        }else
                        {
                            if(i%2==0)
                            {
                                p1[i][j]=(p1[i-1][j-1])*2;
                            }else
                            {
                                p1[i][j]=p1[i-1][j-1]+p1[i-1][j];
                            }
                        }
                    }
                
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<r/2+1;j++)
            {
                if(p1[i][j]==0)
                {
                    System.out.print("   ");
                }else
                {
                    System.out.print(p1[i][j]+" ");
                }
            }
            System.out.println();
        }
        p3print(r,p1);
    }
    public static void p3print(int r,int[][]p1)
    {
        for(int i=0;i<r;i++)
        {
            for(int k=0;k<r*2-i*2;k++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<r/2+1;j++)
            {
                if(p1[i][j]==0)
                {
                    
                }else
                {
                    if(p1[i][j]<10)
                    {
                        System.out.print(p1[i][j]+"   ");
                    }else
                    {
                        System.out.print(p1[i][j]+"  ");
                    }
                }
            }
            if(i%2==0)
            {
                for(int j=i/2-1;j>=0;j--)
                {
                    if(p1[i][j]==0)
                    {
                        
                    }else
                    {
                        if(p1[i][j]<10)
                        {
                            System.out.print(p1[i][j]+"   ");
                        }else
                        {
                            System.out.print(p1[i][j]+"  ");
                        }
                    }
                }
            }else
            {
                for(int j=r/2;j>=0;j--)
                {
                    if(p1[i][j]==0)
                    {
                        
                    }else
                    {
                        if(p1[i][j]<10)
                        {
                            System.out.print(p1[i][j]+"   ");
                        }else
                        {
                            System.out.print(p1[i][j]+"  ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
    public static void p4(int r)//rows count
    {
        int[][] p1=new int[r][r/2+1];
        p1[0][0]=2;
        for(int i=1;i<r;i++)
        {
            for(int j=0;j<i/2+1;j++)
            {
                    if(j>0&&j<i/2)
                    {
                        p1[i][j]=p1[i-1][j-1]+p1[i-1][j];
                    }else
                    {
                        if(j==0)
                        {
                            p1[i][j]=p1[i-1][j]+1;
                        }else
                        {
                            if(i%2==0)
                            {
                                p1[i][j]=(p1[i-1][j-1])*2;
                            }else
                            {
                                p1[i][j]=p1[i-1][j-1]+p1[i-1][j];
                            }
                        }
                    }
                
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<r/2+1;j++)
            {
                if(p1[i][j]==0)
                {
                    System.out.print("   ");
                }else
                {
                    System.out.print(p1[i][j]+" ");
                }
            }
            System.out.println();
        }
        p4Print(r,p1);
    }
    public static void p4Print(int r,int[][] p1)
    {
        for(int k=0;k<r*2+4;k++)
            {
                System.out.print(" ");
            }
        System.out.println("1"+"  ");
        for(int i=-1;i<r;i++)
        {
            for(int k=0;k<r*2-i*2;k++)
            {
                System.out.print(" ");
            }
            System.out.print("1"+"   ");
            if(i>=0)
            {
                for(int j=0;j<r/2+1;j++)
                {
                    if(p1[i][j]==0)
                    {
                        
                    }else
                    {
                        if(p1[i][j]<10)
                        {
                            System.out.print(p1[i][j]+"   ");
                        }else
                        {
                            System.out.print(p1[i][j]+"  ");
                        }
                    }
                }
                if(i%2==0)
                {
                    for(int j=i/2-1;j>=0;j--)
                    {
                        if(p1[i][j]==0)
                        {
                            
                        }else
                        {
                            if(p1[i][j]<10)
                            {
                                System.out.print(p1[i][j]+"   ");
                            }else
                            {
                                System.out.print(p1[i][j]+"  ");
                            }
                        }
                    }
                }else
                {
                    for(int j=r/2;j>=0;j--)
                    {
                        if(p1[i][j]==0)
                        {
                            
                        }else
                        {
                            if(p1[i][j]<10)
                            {
                                System.out.print(p1[i][j]+"   ");
                            }else
                            {
                                System.out.print(p1[i][j]+"  ");
                            }
                        }
                    }
                }
            }
            System.out.print("1");
            System.out.println();
        }
    }
}
