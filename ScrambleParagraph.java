import java.util.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class ScrambleParagraph   
{
    static String originalParagraph = "According to a research at an English University, it does not matter in what order the letters in a word are, the only important thing is that the first and last letter is at the right place.  The rest can be a total mess and you can still read it without a problem. This is because we do not read every letter by itself, but the word as-a-whole!";
    static String characters=",.!'()\"-";
    public static void main()
    {
        String scrambledParagraph="";
    
        scrambledParagraph = scrambleParagraph(originalParagraph);
        System.out.println(scrambledParagraph);
    } // main
    
    // ===========================================================
    public static String scrambleParagraph(String p)
    {
        // >>>>>>>>>> YOUR CODE HERE <<<<<<<<<<
        return scrambleSentence(p);
    }
    public static String scrambleSentence(String s)
    {
        // >>>>>>>>>> YOUR CODE HERE <<<<<<<<<<
        StringTokenizer st=new StringTokenizer(s);
        String s1="";
        while(st.hasMoreTokens())
        {
            s1+=scrambleWord(st.nextToken())+" ";
        }
        return s1;
    }
    public static String scrambleWord(String w)
    {
        Random r=new Random();
        int symbol;
        if(w.length()<=3||w.length()<5&&w.indexOf('-')>=0)
        {
            return w;
        }
        String sc="";
        ArrayList<Character> temp=new ArrayList();
        if(characters.indexOf(w.charAt(w.length()-1))==-1)
        {
            symbol=0;
        }else
        {
            symbol=1;
        }
        for(int i=0;i<w.length();i++)
        {
            temp.add(w.charAt(i));
        }
        for(int i=0;i<w.length()*5+1;i++)
        {
            int num=temp.size()-(3+symbol);
            if(num<=0)
            {
                num=1;
            }
            int ra=r.nextInt(num)+1;
            int tempChar=temp.get(ra);
            if(!temp.contains('-')&&temp.get(ra)!='-'&&temp.get(ra)!='-')
            {
                temp.remove(ra);
                temp.add(ra+1,(char)tempChar);
            }else
            {
                temp.remove(ra);
                temp.add(7,(char)(105));
                break;
            }
        }
        for(Character n:temp)
        {
            sc+=n;
        }
        return sc;
    }
} 

