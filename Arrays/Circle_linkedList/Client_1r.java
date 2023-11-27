package Arrays.Circle_linkedList;

import java.util.*;
public class Client_1r
{
    public static void main()
    {
        Scanner c=new Scanner(System.in);
        System.out.println("Size?");
        Node1r front=new Node1r(1),end=front,current=front;
        int size=c.nextInt(),rotate;
        String value="a";
        for(int i=front.getData()+1;i<=size+1;i++)
        {
            current=front;
            while(current.getNext()!=null)
            {
                current=current.getNext();
            }
            current.setNext(new Node1r(i));
        }
        current.setNext(front);
        end=current;
        while(value.charAt(0)=='a')
        {
            current=front;
            System.out.println("The numbers are: ");
            while(current.getNext()!=null&& current!=end)
            {
                System.out.print(current.getData()+", ");
                current=current.getNext();
            }
            System.out.print(end.getData());
            System.out.println("\nType a to rotate or b to leave");
            value=c.next();
            if(value.charAt(0)=='a')
            {
                System.out.println("What is the rotate value?");
                rotate=c.nextInt();
                if(rotate>0)
                {
                    for(int i=0;i<rotate;i++)
                    {
                        front=front.getNext();
                        end=end.getNext();
                    }
                }
                if(rotate<0)
                {
                    for(int i=0;i<size+rotate;i++)
                    {
                        front=front.getNext();
                        end=end.getNext();
                    }
                }
            }
        }
    }
}

