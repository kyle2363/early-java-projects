package Geussing_games.GeussG_2;

 // threadGuessCount_Comparator: compare one thread's guessCount to another   
import java.util.*;

public class threadPlayersBank_Comparator implements Comparator<GuessingGameShow_THREE_CLIENT_THREADS_Executor_withLocksAndInnerClasses_SHELL.GuessingGameShow_PlayerThread_withBank>
{
    // >>>>>>>>>> YOUR CODE HERE <<<<<<<<<<
    public int compare
    (GuessingGameShow_THREE_CLIENT_THREADS_Executor_withLocksAndInnerClasses_SHELL.GuessingGameShow_PlayerThread_withBank t1,
    GuessingGameShow_THREE_CLIENT_THREADS_Executor_withLocksAndInnerClasses_SHELL.GuessingGameShow_PlayerThread_withBank t2)
    {
        return t1.guessCount-t2.guessCount;
    }
}

