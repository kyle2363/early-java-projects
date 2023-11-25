package Arrays.LLandTreeAsArray;
import java.util.*;

//import javax.swing.tree.TreeNode;
public class MainLL_Tree {
    public static void main(String[] args)
    {
        part1();
        part2();
    }
    public static void part1()
    {
        ArrayList<LLNode> a=new ArrayList<>();
        int index=-1,min=Integer.MAX_VALUE,index2;
        a.add(new LLNode(7,-1));
        a.add(new LLNode(2,-1));
        a.add(new LLNode(16,-1));
        a.add(new LLNode(11,-1));
        for(int j=0;j<a.size();j++)
        {
            if(a.get(j).getNext()==-1&&a.get(j).getData()<min)
            {
                min=a.get(j).getData();
                index=j;
            }
        }
        for(int i=0;i<a.size()*2;i++)//try to fix so dont need to go through 2x
        {
            index2=-1;
            min=Integer.MAX_VALUE;
            for(int j=0;j<a.size();j++)
            {
                if(a.get(j).getNext()==-1&&a.get(j).getData()<min)
                {
                    min=a.get(j).getData();
                    index2=j;
                }
            }
            a.get(index).setNext(index2);
            index=index2;
        }
        System.out.println(a);
    }
    public static void part2()
    {
        int numbers[ ] = {75, 50,  25, 100, 200, 300, 35, 150, 10, 20, 125};
        ArrayList<TreeNodeLL> a = new ArrayList<TreeNodeLL>( );
        for(int i=0;i<numbers.length;i++)
        {
            a.add(new TreeNodeLL(numbers[i],-1,-1));
        }
        for(int i=1;i<numbers.length;i++)
        {
            part2rec(a,numbers[i],i,0);
        }
        System.out.println();
        part2print(a);
    }
    public static void part2rec(ArrayList<TreeNodeLL> a,int num,int index,int x)
    {
        if(num>a.get(x).getData())
        {
            if(a.get(x).getRight()!=-1)
            {
                part2rec(a,num,index,a.get(x).getRight());
            }else
            {
                a.get(x).setRight(index);
            }
        }else
        {
            if(a.get(x).getLeft()!=-1)
            {
                part2rec(a,num,index,a.get(x).getLeft());
            }else
            {
                a.get(x).setLeft(index);
            }
        }
    }
    public static void part2print(ArrayList<TreeNodeLL> a)
    {
        System.out.println();
        for(int i=0;i<a.size();i++)
        {
            System.out.print(a.get(i).getData()+" ");
        }
        System.out.println();
        for(int i=0;i<a.size();i++)
        {
            System.out.print(a.get(i).getLeft()+" ");
        }
        System.out.println();
        for(int i=0;i<a.size();i++)
        {
            System.out.print(a.get(i).getRight()+" ");
        }
        System.out.println();
        part2print2(a,0);
        part2print3(a,0,0);
    }
    public static void part2print2(ArrayList<TreeNodeLL> a,int x)
    {
        if(x!=-1)
        {
            part2print2(a,a.get(x).getLeft());
            System.out.print(a.get(x).getData()+" ");
            part2print2(a,a.get(x).getRight());
        }
    }
    public static void part2print3(ArrayList<TreeNodeLL> a,int x,int s)
    {
        if(x!=-1)
        {
            part2print3(a,a.get(x).getRight(),s+1);
            for(int i=0;i<s;i++)
            {
                System.out.print("\t");
            }
            System.out.println(a.get(x).getData()+" ");
            part2print3(a,a.get(x).getLeft(),s+1);
        }
    }
}
