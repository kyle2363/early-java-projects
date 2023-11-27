package Geussing_games.GeussG_2;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class Bank
      {
      private static Lock lock = new ReentrantLock();  
      private int bankBalance;
      
         public Bank(int b)
         {
             bankBalance = b;
         }
         public int getBankBalance()
         {
             return bankBalance;
         }
         public void bet(GuessingGameShow_THREE_CLIENT_THREADS_Executor_withLocksAndInnerClasses_SHELL.GuessingGameShow_PlayerThread_withBank p)
         {
             lock.lock();
             System.out.println("bank used");
             double percentageBet = p.getPlayersBet() / p.getPlayersBank();
             if (p.getGuessNumber()==p.getActualNumber())
             {
                 p.addToPlayersBank((int)(percentageBet*bankBalance));
                 bankBalance -= (percentageBet*bankBalance);
             } else {
                 p.subtractFromPlayersBank((int)p.getPlayersBet());
                 bankBalance += p.getPlayersBet();                
             }
             p.bankval=bankBalance;
             lock.unlock();
         } // bet 
       // Bank

} // GuessingGameShow_THREE_CLIENT_THREADS_Executor_Locks
