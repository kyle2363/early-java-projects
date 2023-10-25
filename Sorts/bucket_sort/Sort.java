package Sorts.bucket_sort;

public class Sort
{
    int[] a;
    Node[] buckets= new Node[10];   // To create the reference to the array.
    Node front,current,end,current2;
    int max,place=10;
    public Sort(Node f)
    {
        front=f;
    }
    public Sort()
    {
        front=null;
    }
    public Node start()
    {
        for (int i=0;  i < buckets.length;  i++)  // To fill the array with the ten base buckets.
            buckets[i] = new Node();
        current=front;
        while(current.getNext()!=null)
        {
            current=current.getNext();
            if(current.getData()>max)
            {
                max=current.getData();
            }
        }
        end=current;
        do
        {
            sort();
            place*=10;
        }while(max/place!=0);
        return front;
    }
    public void sort()
    {
        current=front;
        int num;
        while(current.getNext()!=null)
        {
            front=current.getNext();
            num=(current.getData()%place)/(place/10);
            front.setPrevious(null);
            current2=buckets[num];
            while(current2.getNext()!=null)
            {
                current2=current2.getNext();
            }
            current.setNext(null);
            current2.setNext(current);
            current.setPrevious(current2);
            current=front;
        }
        if(front.getNext()==null)
        {
            front=null;
            num=(current.getData()%place)/(place/10);
            current2=buckets[num];
            while(current2.getNext()!=null)
            {
                current2=current2.getNext();
            }
            current.setNext(null);
            current2.setNext(current);
            current.setPrevious(current2);
            current=front;
        }
        for(int i=0;i<buckets.length;i++)
        {
            if(buckets[i].getNext()!=null)
            {
                current2=buckets[i].getNext();
                current2.setPrevious(null);
                buckets[i].setNext(null);
                if(front==null)
                {
                    front=current2;
                }else
                {
                    current=front;
                    while(current.getNext()!=null)
                    {
                        current=current.getNext();
                    }
                    current2.setPrevious(current);
                    current.setNext(current2);
                }
            }
        }
        current=front;
        while(current.getNext()!=null)
        {
            current=current.getNext();
        }
        end=current;
    }
    public void print(Node f)
    {
        Node current=f;
        System.out.print("\n"+current.getData()+" ");
        while(current.getNext()!=null)
        {
            current=current.getNext();
            System.out.print(current.getData()+" ");
        }
        System.out.println("\n");
    }
    public void Printbucket()
    {
        for(int i=0;i<buckets.length;i++)
        {
            Node current=buckets[i];
            System.out.print(i+"->");
            while(current.getNext()!=null)
            {
                current=current.getNext();
                System.out.print(current.getData()+" ");
            }
            System.out.println();
        }
    }
}
