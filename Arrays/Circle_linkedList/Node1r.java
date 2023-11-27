package Arrays.Circle_linkedList;

public class Node1r
{
    private int data;
    private Node1r next;
    public Node1r()
    {
        this(0);
    }
    public Node1r(int d)
    {
        data=d;
    }
    public int getData()
    {
        return data;
    }
    public Node1r getNext()
    {
        return next;
    }
    public void setNext(Node1r n)
    {
        next=n;
    }
    
}
