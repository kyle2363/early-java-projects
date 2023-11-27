package Arrays.Wraper_class;

/**
* This "Node" holds 'myValue' which is a ptr to an object, and a ptr to 
* the next Node in the ArrayList.
*/
public class Node_WC
{
private Object myValue; // this is a ptr to an Object
private Node_WC next;

    /*** Constructor for objects of class Node */
    public Node_WC()
    {
        myValue = null;  // set default values
        next = null;
    }
    public Node_WC(Object x)
    {
        myValue = x;
        next = null;
    }
    
    void setNext(Node_WC n)
    {
        next = n;
    }
    void setMyValue(Object x)
    {
        myValue = x;
    }
    public void setMyValueObject(Object x)
    {
        myValue = x;
    }
    
    Node_WC getNext()
    {    
        return next;
    }
    String getMyValue()
    {
        return myValue.toString();
    }
    Object getMyValueObject()
    {
        return myValue;
    }
    
}

