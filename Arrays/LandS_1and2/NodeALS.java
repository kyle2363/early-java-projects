package Arrays.LandS_1and2;

public class NodeALS
{
    private NodeALS next,previous;
    private int data;
    public NodeALS()
    {
        this(null,null,0);
    }
    public NodeALS(NodeALS n,NodeALS p,int d)
    {
        next=n;
        previous=p;
        data=d;
    }
    public int getData()
    {
        return data;
    }
    public NodeALS getNext()
    {
        return next;
    }
    public NodeALS getPrevious()
    {
        return previous;
    }
    public void setNext(NodeALS n)
    {
        next=n;
    }
    public void setPrevious(NodeALS p)
    {
        previous=p;
    }
    public String toString()
    {
        String s="this is "+data;
        try
        {
            s+=", next is "+next.getData();
        }catch(Exception e)
        {
            s+=", next is null";
        }
        try
        {
            s+=", Previous is "+previous.getData();
        }catch(Exception e)
        {
            s+=", Previous is null";
        }
        return s;
    }
}

