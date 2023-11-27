package Arrays.Circle_linkedList;

public class Node2r {
    private int data;
    private Node2r next,previous;
    public Node2r()
    {
        this(0);
    }
    public Node2r(int d)
    {
        data=d;
    }
    public Node2r(Node2r n,Node2r p,int d)
    {
        data=d;
        next=n;
        previous=p;
    }
    public int getData()
    {
        return data;
    }
    public Node2r getNext()
    {
        return next;
    }
    public Node2r getPrevious()
    {
        return previous;
    }
    public void setNext(Node2r n)
    {
        next=n;
    }
    public void setPrevious(Node2r n)
    {
        previous=n;
    }
    
}
