package Arrays.Circle_linkedList;

import java.util.*;
public class Client_2r {
    public static void main(String[] args)
    {
        Scanner c=new Scanner(System.in);
        System.out.println("Size?");
        Node2r front=new Node2r(1),end=front,current=front;
        int size=c.nextInt(),rotate;
        String value="a";
        for(int i=front.getData()+1;i<=size+1;i++)
        {
            current=front;
            while(current.getNext()!=null)
            {
                current=current.getNext();
            }
            current.setNext(new Node2r(null,current,i));
        }
        current.setNext(front);
        front.setPrevious(current);
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
                    for(int i=rotate;i<0;i++)
                    {
                        front=front.getPrevious();
                        end=end.getPrevious();
                    }
                }
            }
        }
    }
}
