package Arrays.LandS_1and2;
import java.util.*;

/**
 * Write a description of class main2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LargestSmallest1And2
{
    public static void main(String[] args)
    {
        int input=getInput(),max1,max2,min1,min2;
        int[] a={input,input,input,input};//max1,max2,min1,min2
        NodeALS front=new NodeALS(null,null,input),current,temp;
        print(front,a);
        while(input!=-1)
        {
            //System.out.println(front);
            input=getInput();
            current=front;
            temp=front;
            while(current.getNext()!=null && current.getData()<input)
            {
                temp=current;
                current=current.getNext();
            }
            if(current==front)
            {
                if(input>front.getData())
                {
                    front.setNext(new NodeALS(null,front,input));
                }else
                {
                    front=new NodeALS(temp,null,input);
                }
            }else
            {
                current.setNext(new NodeALS(null,current,input));
            }
            
            if(input>a[0])
            {
                if(a[0]>a[1])
                {
                    a[1]=a[0];
                }
                a[0]=input;
            }else
            {
                if(input>a[1])
                {
                    a[1]=input;
                }
            }
            if(input<a[2])
            {
                if(a[2]<a[3])
                {
                    min2=a[2];
                }
                a[2]=input;
            }else
            {
                if(input<a[3])
                {
                    min2=input;
                }
            }
            if(a[2]==a[3])
            {
                a[3]=input;
            }
            print(front,a);
        }
    }
    public static int getInput()
    {
        Scanner c=new Scanner(System.in);
        System.out.println("\nPick a number");
        return c.nextInt();
    }
    public static void print(NodeALS f,int[] a)
    {
        System.out.println
        ("L1 = "+a[0]+", L2 = "+a[1]+", S1 = "+a[2]+", S2 = "+a[3]+"   List:");
        NodeALS current=f;
        System.out.print("[");
        while(current.getNext()!=null)
        {
            System.out.print(current.getData()+" ");
            current=current.getNext();
        }
        System.out.print(current.getData());
        System.out.println("]");
    }
}
