package Arrays.LLandTreeAsArray;

public class LLNode {
    private int myValue;
      private int myNext;
      public LLNode()
      {
          this(0,-1);
      }
      public LLNode(int x,int y)
      {
          myValue=x;
          myNext=y;
      }
      public int getData()
      {
          return myValue;
      }
      public int getNext()
      {
          return myNext;
      }
      public void setNext(int x)
      {
          myNext=x;
      }
      public void setData(int x)
      {
          myValue=x;
      }
      public String toString()
      {
          return myValue+" "+myNext;
      }
}
