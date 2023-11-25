package Arrays.LLandTreeAsArray;

public class TreeNodeLL {
    private int myValue;
    private int myLeft;
    private int myRight;
    public TreeNodeLL()
    {
        this(-1,-1,-1);
    }
    public TreeNodeLL(int x,int y,int z)
    {
        myValue=x;
        myLeft=y;
        myRight=z;
    }
    public int getData()
    {
        return myValue;
    }
    public int getLeft()
    {
        return myLeft;
    }
    public int getRight()
    {
        return myRight;
    }
    public void setLeft(int x)
    {
        myLeft=x;
    }
    public void setRight(int x)
    {
        myRight=x;
    }
    public void setData(int x)
    {
       myValue=x;
    }
    public String toString()
    {
        return myValue+" "+myLeft+" "+myRight;
    }
}
