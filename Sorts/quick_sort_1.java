package Sorts;

import java.util.*;

public class quick_sort_1
{

    public static void main(String[] args)
    {
        int a[]={37,2,6,4,89,8,10,12,68,45};
    
        System.out.println("\n\n\t\t QUICKSORT");
        printList(a,"original");
        quickSort(a,0,a.length-1);
        printList(a,"sorted");

        System.out.println("\n\n");
    }


    // ************** printList *************** 
    public static void printList(int a[],String word)
    {
        System.out.println( "\n\n\t The " + word + " list: ");
        for (int i=0; i<a.length; i++){
            System.out.print(a[i]);
            if (i!=a.length-1) 
                System.out.print( ", ");
        }
        System.out.print("\n");
    }
    
    // ***************** swap ***************** 
    public static void swap(int a[], int start,int end)
    {
        int temp=a[start];
            
        a[start]=a[end];
        a[end] = temp;
    
    }
    
    // ***************** partition ***************** 
    public static int partition(int a[], int start, int end)
    // Return position of correctly placed element.
    {
        
        // >>>>>>>>>>>>>>>>>>>>> YOUR CODE HERE! <<<<<<<<<<<<<<<<<<<<<<<
        int num=a[start],index,indexNum=start,temp;
        while(true)
        {
            index=end;
            while(a[index]>num)
            {
                index--;
            }
            if(index==indexNum)
            {
                return index;
            }
            temp=a[index];
            a[index]=num;
            a[indexNum]=temp;
            indexNum=index;
            index=start;
            while(a[index]<num)
            {
                index++;
            }
            if(index==indexNum)
            {
                return index;
            }
            temp=a[index];
            a[index]=num;
            a[indexNum]=temp;
            indexNum=index;
            System.out.println(Arrays.toString(a));
        }
        //System.out.println(start+" "+end+" | "+index);
        //System.out.println(Arrays.toString(a));
        //return index;
    }
    
    // ***************** quickSort ***************** 
    public static void quickSort(int a[], int start, int end)
    {
        int placed;
    
        placed = partition(a,start,end);
        if (placed!=start) quickSort(a,start,placed-1);
        if (placed!=end) quickSort(a,placed+1,end);
    }

} // QuickSort

