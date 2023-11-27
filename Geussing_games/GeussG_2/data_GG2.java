package Geussing_games.GeussG_2;

import java.io.*;
import java.util.ArrayList;

public class data_GG2 implements Serializable
{
    String name="",message="";
    private int money,gNumber;//gNumber is actual number
    public int max,low,tempNum;//game Info
    ArrayList<Boolean> isPlay=new ArrayList<>();
    public data_GG2()
    {
        
    }
    public data_GG2(String n, int mo,int num,int m,int numP)
    {
        name=n;
        money=mo;
        gNumber=num;
        max=m;
        low=0;
        System.out.println(gNumber);
        for(int i=0;i<numP;i++)
        {
            isPlay.add(true);
        }
    }
    public void setName(String n)
    {
        name=n;
    }
    public String getMessage()
    {
        return message;
    }
    public boolean isEmpty()
    {
        return money==0;
    }
    public int makegeuss(int n,int bet,int pBank,String na)
    {
        int value=checkNum(n),changeMoney;
        tempNum=n;
        //double percentageBet = bet /(double)pBank;
        changeMoney=bet;//(int) percentageBet*pBank;
        if(value==0)
        {
            money-=changeMoney;
            message="c m "+changeMoney+" "+n+" "+name;
            //first num is correct or not,2nd is high or low,3rd is money, 
            //4th is geuss, 5th is name
            isPlay.set(Integer.parseInt(na.substring(1))-1,false);
            return changeMoney;
        }else
        {
            money+=changeMoney;
            if(value==1)//higher
            {
                message="n h "+changeMoney+" "+n+" "+name;
            }else
            {
                message="n l "+changeMoney+" "+n+" "+name;
            }
            return -1*changeMoney;
        }
    }
    private int checkNum(int n)
    {
        if(n==gNumber)
        {
            return 0;
        }
        if(gNumber<n)
        {
            return 1;
        }else
        {
            return -1;
        }
    }
    
}
