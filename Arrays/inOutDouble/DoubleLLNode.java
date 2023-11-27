package Arrays.inOutDouble;

public class DoubleLLNode
{
    private int myInfo;
    private DoubleLLNode previous, next;

    DoubleLLNode() { 
        myInfo = 0;
        previous = null;
        next = null; 
    }    

    DoubleLLNode(int i)
    {
        myInfo = i;
        previous = null;
        next = null;
    }  

    public int getInfo()
    {
        return myInfo;   
    }

    public DoubleLLNode getPrevious()
    {
        return previous;
    }

    public DoubleLLNode getNext()
    {
        return next;   
    }    

    public void setPrevious(DoubleLLNode m)
    {
        previous = m;   
    }    

    public void setNext(DoubleLLNode m)
    {
        next = m;   
    }

    public String toString()
    {
        return "" + myInfo;
    }
}
