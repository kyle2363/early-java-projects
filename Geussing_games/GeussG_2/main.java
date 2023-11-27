package Geussing_games.GeussG_2;

import java.util.*;
import java.io.*;
import java.net.*;

public class main
{
    Bank bigBank;
    public void main()throws IOException
    {
        System.out.println("Start server");
        int port=8000,max,i,numP=4;
        ServerSocket server;
        server=new ServerSocket(port);
        bigBank=new Bank(100);
        i=1;
        
        max=100000;
        ArrayList<clientMan> a=new ArrayList<>();
        data_GG2 d=new data_GG2("",100,(int)(Math.random()*max+1),max,numP);
        for(int j=0;j<numP;j++)
        {
            Socket clientSocket=server.accept();
            System.out.println("found a client");
            main.clientMan c=new clientMan(clientSocket,"P"+i);
            Thread t= new Thread(c);
            a.add(c);
            //t.start();
            System.out.println("added "+c.name);
            i++;
            if(i>numP+1)
            {
                i=1;
                a=new ArrayList<clientMan>();
            }
        }
        while(true)
        {
            Random r=new Random();
            int rNum=r.nextInt(a.size());
            System.out.println(rNum);
            if(d.isPlay.get(rNum))
            {
                clientMan temp=a.get(rNum);
                temp.send(d);
                d=temp.recive();
                if(d.message.charAt(2)=='h')
                {
                    d.max=d.tempNum;
                }else
                {
                    d.low=d.tempNum;
                }
            }
        }
    }
    public class clientMan implements Runnable
    {
        Socket client;
        String name;
        ObjectInputStream cIn;
        ObjectOutputStream cOut;
        data_GG2 currentData;
        public clientMan(Socket x,String n)
        {
            client=x;
            name=n;
            try{
                cIn= new ObjectInputStream(client.getInputStream());
                cOut= new ObjectOutputStream(client.getOutputStream());
            }catch(Exception e)
            {

            }
        }

        public void send(data_GG2 d)
        {
            try
            {
                cOut.writeObject(d);
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }

        public data_GG2 recive()
        {
            try
            {
                currentData=(data_GG2)cIn.readObject();
            }
            catch (Exception ioe)
            {
                ioe.printStackTrace();
            }
            return currentData;
        }

        public void run()
        {
            try
            {
                while(true)
                {
                    currentData=(data_GG2)cIn.readObject();
                }
            }catch(Exception e)
            {

            }
        }
    }
}
