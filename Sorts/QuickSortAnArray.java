package Sorts;

public class QuickSortAnArray
{
    public static void main(String[] args)
    {
        int nums[ ] = {8, 4, 12, 2, 6, 10, 14, 1, 3, 5,7,9, 11, 13, 15};
        int sorted[ ] = new int[nums.length];
	for (int i=0; i<nums.length; i++)
		sorted[i] = i;
	printList(nums, sorted,"UNsorted");
	quickSort(nums,sorted,0,nums.length-1);
	printList(nums, sorted,"SORTED");

    } // main
	
    public static void printList(int nums[ ], int sorted[ ], String message)
    {
        System.out.println(" This is the  " + message + " array:  ");

	// >>>>> your code here <<<<<
        //   Print ‘nums’ via the values acting as pointers 
        //               inside of ‘sorted’
        System.out.print("["+nums[sorted[0]]);
        for(int i=1;i<nums.length;i++)
        {
            System.out.print(", "+nums[sorted[i]]);
        }
        System.out.println("]");
	System.out.print("\n");
    }

    // Keeping ‘nums’ EXACTLY as is, quickSort will move the ‘sorted’ 
    // arrays values around to express nums as sorted.
    public static void quickSort(int nums[ ], int sorted[ ],int start,int end)
    {	
    	// >>>>> your code here <<<<<
    	int center;
    	center=partition(nums,sorted,start,end);
    	if(center!=start)
    	{
    	    quickSort(nums,sorted,start,center-1);
    	}
    	if(center!=end)
    	{
    	    quickSort(nums,sorted,center+1,end);
    	}
    }
    public static int partition(int nums[ ], int a[ ],int start,int end)
    {
        int num=nums[a[start]],index,indexNum=start,temp;
        while(true)
        {
            index=end;
            while(nums[a[index]]>num)
            {
                index--;
            }
            if(nums[a[index]]==num)
            {
                return index;
            }
            temp=a[index];
            a[index]=a[indexNum];
            a[indexNum]=temp;
            indexNum=index;
            index=start;
            while(nums[a[index]]<num)
            {
                index++;
            }
            if(nums[a[index]]==num)
            {
                return index;
            }
            temp=a[index];
            a[index]=a[indexNum];
            a[indexNum]=temp;
            indexNum=index;
        }
    }

} // QuickSortAnArray
