package Sorts.bucket_sort;
public class Node
{
    public Node next,previous;
    public int data;
    public Node()
    {
        this(null,null,0);
    }
    public Node(int x)
    {
        this(null,null,x);
    }
    public Node(Node n, Node p,int x)
    {
        next=n;
        previous=p;
        data=x;
    }
    public Node getNext()
    {
        return next;
    }
    public Node getPrevious()
    {
        return previous;
    }
    public int getData()
    {
        return data;
    }
    public void setNext(Node n)
    {
        next=n;
    }
    public void setPrevious(Node p)
    {
        previous=p;
    }
}


