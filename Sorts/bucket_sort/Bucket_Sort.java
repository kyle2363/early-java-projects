package Sorts.bucket_sort;
import java.util.*;

public class Bucket_Sort {
    public static void main(String[] args)
    {
        Node front=getInput();
        System.out.println("Before:\n");
        print(front);
        Sort s=new Sort(front);
        Node front2=s.start();
        System.out.println("\n\nFinal is\n");
        print(front2);
    }
    public static Node getInput()
    {
        Scanner c=new Scanner(System.in);
        System.out.println("Type a number or -1 to exit");
        int input= c.nextInt();
        Node f=new Node(input),current=f;
        while(input!=-1)
        {
            System.out.println("Type a number or -1 to exit and sort");
            input=c.nextInt();
            if(input==-1)
            {
                break;
            }
            current.setNext(new Node(null,current,input));
            current=current.getNext();
        }
        return f;
    }
    public static void print(Node f)
    {
        Node current=f;
        System.out.print(current.getData()+" ");
        while(current.getNext()!=null)
        {
            current=current.getNext();
            System.out.print(current.getData()+" ");
        }
    }

}
