package Geussing_games.GeussG_1;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.io.*;
import java.net.*;

public class GuessingGameShow_THREE_CLIENT_THREADS_Executor_withLocksAndInnerClasses_SHELL
{

    //needs another class to run
    public  void main()
    {    
        int max=1000000;
        int numberOfPlayers = 3;
        int playersActualNumber;        
        int playersStartingBank = 100;
        Thread t;
        GuessingGameShow_PlayerThread_withBank p;  
        ExecutorService executor = Executors.newFixedThreadPool(numberOfPlayers);
        GuessingGameShow_PlayerThread_withBank threadArray[] =
            new GuessingGameShow_PlayerThread_withBank[numberOfPlayers];

        for (int i=1; i<=numberOfPlayers; i++)
        {
            playersActualNumber = (int) (Math.random()*max+1);
            p = new GuessingGameShow_PlayerThread_withBank
            ("P"+i,playersActualNumber,max,playersStartingBank);  
            System.out.println(p.getName());
            t = new Thread(p);  // ... so 'p' can be put into a Thread.            
            threadArray[i-1] = p; 
            executor.execute(t);   
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        // i   

        // Stop all threads
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
            
        executor.shutdown();
        while(!executor.isTerminated()) {
            try
            {
                // stall / wait for all threads to stop
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }        
        System.out.println("\n\n\t Sort and Print threadArray: ");       
        Arrays.sort(threadArray, new threadPlayersBank_Comparator()); 

        for (GuessingGameShow_PlayerThread_withBank gpt : threadArray)
        {
            System.out.println("Name = " + gpt.getName() + ": " + 
                "ActualNumber = " + gpt.getActualNumber() + "   " + 
                "GuessNumber = " + gpt.getGuessNumber() + "   " +
                "GuessCount = " + gpt.getGuessCount() + "   " +   
                "PlayersBank = " + gpt.getPlayersBank() + "   " + 
                "gpt/this = " + gpt);
        }      
        System.exit(0);

    } // main    

    // ******************************************************************
    // ************************* INNER CLASSES  ************************* 
    // ******************************************************************    

    public  class GuessingGameShow_PlayerThread_withBank implements Runnable 
    { 
        // ------------------------------------------------------------
        int guessCount,bankval=100;
        int actualNumber, guessNumber=0,low,high=Integer.MAX_VALUE, playersBank=0,playersBet=0;
        String name;
        boolean isPlay=true;
        public GuessingGameShow_PlayerThread_withBank(String name, int num1, int max,int startbank)
        {
            this.name=name;
            actualNumber=-1;
            high=max;
            playersBank=startbank;
        }
        // ------------------------------------------------------------
        //               get() methods go here
        // ------------------------------------------------------------        
        public String getName()
        {
            return name;
        }

        public int getGuessNumber()
        {
            return guessNumber;
        }

        public int getGuessCount()
        {
            return guessCount;
        }

        public int getActualNumber()
        {
            return actualNumber;
        }

        public int getPlayersBet()
        {
            return playersBet;
        }

        public int getPlayersBank()
        {
            return playersBank;
        }
        // ------------------------------------------------------------
        //               Other methods go here         
        // ------------------------------------------------------------
        public void addToPlayersBank(int x) 
        {
            playersBank+=x;
        }

        public void subtractFromPlayersBank(int x)
        {
            playersBank-=x;
        }

        public void run() 
        {
            try
            {
                Socket client=new Socket("localhost", 8000);
                String resultingString="";

                ObjectOutputStream  cOut= new 
                    ObjectOutputStream(client.getOutputStream());
                ObjectInputStream cIn= new 
                    ObjectInputStream(client.getInputStream());
                while (guessNumber!=actualNumber && playersBank!=0 && bankval!=0)
                {
                    Random r=new Random();
                    double ra=((int)(Math.random()*100))/100.0;
                    playersBet=(int)(ra*playersBank);
                    if(playersBet==0)
                    {
                        playersBet=1;
                    }
                    //System.out.println("wait");
                    data_GG d=(data_GG)cIn.readObject();
                    //System.out.println("recive");
                    high=d.max;
                    low=d.low;
                    //System.out.println(high+" "+low);
                    guessNumber=low+r.nextInt(high-low);
                    //System.out.println("bet "+playersBet);
                    int change=d.makegeuss(guessNumber, playersBet, playersBank,name);
                    //System.out.println(change);
                    playersBank+=change;
                    if(playersBank==0)
                    {
                        d.isPlay.set(Integer.parseInt(name.substring(1))-1,false);
                    }
                    System.out.println(d.isPlay);
                    String msg=d.getMessage();
                    //System.out.println(msg);
                    cOut.writeObject(d);
                    
                    guessCount++;
                    playersBet=Math.abs(change);
                    
                    resultingString = name + ": guessNumber = " + guessNumber + 
                    "\t guessCount = " + guessCount +
                    "\t playersBet = " + playersBet;

                    if (msg.charAt(2)=='l') {
                        low=guessNumber;
                        resultingString += " Guess too LOW! You lose " + playersBet +
                        " playersBank = " + playersBank;
                    } else if (msg.charAt(2)=='h') {
                        high=guessNumber;
                        resultingString += " Guess too HIGH! You lose " + playersBet + 
                        " playersBank = " + playersBank;                
                    } else {  // (guessNumber == actualNumber)
                        resultingString += " CORRECT! You win!"; 
                        guessNumber=-1;
                    }

                    System.out.println(resultingString + " Thread: " + this);

                } // while (guessNumber!=actualNumber && playersBet!=0))
                isPlay=false;
                /*if (bankval==0) {
                    System.out.println(">>>>> bigBank.getBankBalance()==0!!!  Game OVER!!!" 
                        + " Thread: " + this);
                }*/
                System.out.println(">>>>> " + name + ": Your guessCount = " + guessCount +
                    " actualNumber = " + actualNumber +
                    " playersBank = " + playersBank); 
            }
            catch (Exception e){}
        } // run - thread dies
    }  // GuessingGameShow_PlayerThread_withBank
} // GuessingGameShow_THREE_CLIENT_THREADS_Executor_Locks 