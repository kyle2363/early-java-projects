package Arrays.inOutDouble;

import java.util.*;

public class NumbersInOutDoubleLL_SHELL
{

    public static void main()
    {
        int k;//, diff1, diff2;
        //boolean added, deleted;
        DoubleLLNode front;//,nNext;
        DoubleLLNode c,n,p,temp;  // current, next, previous   
        Scanner sc = new Scanner(System.in);

    
        // Set head
        System.out.print("To start the DoubleLLNode list, enter a positive k: ");
        k = sc.nextInt();       
        front = new DoubleLLNode(k);
        
        System.out.print("\n Enter next k (0 to end input): ");
        k = sc.nextInt();
        
        while (k != 0) {         
            if (k > 0) {
                c=front;
                while(c.getNext()!=null&& c.getInfo()<k)
                {
                    c=c.getNext();
                }
                System.out.print(" c at"+c.getInfo());
                temp=new DoubleLLNode(k);
                if(c.getNext()==null&&k>c.getInfo())
                {
                    temp.setPrevious(c);
                    c.setNext(temp);
                }else
                {
                    temp.setNext(c);
                    c.getPrevious().setNext(temp);
                    temp.setPrevious(c.getPrevious());
                    c.setPrevious(temp);
                }
            } else {  // k < 0
              
                // >>>>>>>>>>>>>>>>>>> YOUR CODE HERE <<<<<<<<<<<<<<                
                k=Math.abs(k);
                c=front;
                while(c.getNext()!=null&& c.getInfo()<k)
                {
                    c=c.getNext();
                }
                System.out.println(c.getInfo());
                if(c.getInfo()==k)
                {
                    if(c.getNext()!=null)
                    {
                        if(c==front)
                        {
                            front=c.getNext();
                            front.setPrevious(null);
                        }else
                        {
                            c.getNext().setPrevious(c.getPrevious());
                            c.getPrevious().setNext(c.getNext());
                        }
                    }else
                    {
                        c.getPrevious().setNext(null);
                    }
                }else
                {
                    if(c.getNext()!=null && c.getPrevious()!=null)
                    {
                        if(k-c.getPrevious().getInfo()
                        <c.getNext().getInfo()-k)//closer to left
                        {
                            temp=c.getPrevious();
                            temp.getPrevious().setNext(c);
                            c.setPrevious(temp.getPrevious());
                            temp.setNext(null);
                            temp.setPrevious(null);
                            temp=null;
                        }else
                        {
                            temp=c.getPrevious();
                            c.getNext().setPrevious(temp);
                            temp.setNext(c.getNext());
                            c.setNext(null);
                            c.setPrevious(null);
                            c=null;
                        }
                    }else
                    {
                        if(c.getInfo()>k)
                        {
                            temp=c.getPrevious();
                            temp.getPrevious().setNext(c);
                            c.setPrevious(temp.getPrevious());
                            temp.setNext(null);
                            temp.setPrevious(null);
                            temp=null;
                        }else
                        {
                            
                        }
                    }
                }
            }  // k < 0

            System.out.print("\n\n The current DoubleLLNode list: ");
            for (n=front; n!=null; n=n.getNext())
            {
                System.out.print(n + ", ");
            }
            System.out.println();
            
            System.out.print("\n Enter next k (0 to end input): ");
            k = sc.nextInt();           
            
        } // while (k != 0)
    
        System.out.println("Thx for playing DoubleLLNode!!");
    } // main
   
}  // NumbersInOutSingleLL        
