package project_idea.stack_eq_ui;

import java.util.*;

import javax.swing.JOptionPane;

public class Stack2 {

    Stack<String> s1;
    Stack<String> s2;

    public Stack2()
    {
        this("");
    }
    public Stack2(String s)
    {
        s1=new Stack<>();
        s2=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            s1.push(""+s.charAt(i));
        }
    }
    public boolean isBadSelection(int selection)
    {
        return (selection<0 || selection>6);
    }

    public void BadSelectionMsg() {
        JOptionPane.showMessageDialog(null, "Input was incorrect. \n  Please choose again.\n",
                "Bad Input", JOptionPane.INFORMATION_MESSAGE);
    }

    public int menu() {
        int selection = 0;
        String choices = "";

        // print ArrayList choices here, let 0 = quit
        choices += printStack("return stack") + "\n\n\n" + "Your choices are: \n" +
                " (0) Quit \n (1) Add to equation \n (2) Size: number of characters in total \n" +
                " (3) Show step by step solving \n (4) Set an expression at certain substring \n" +
                " (5) Remove an expression at index \n (6) Add an Object at index \n" +
                " \n Please enter your selection.";

        selection = Integer.parseInt(JOptionPane.showInputDialog(null, choices));
        return selection;
    }

    public void doArrayListMethod(int selection) {

        switch (selection) {
            case 0:
                JOptionPane.showMessageDialog(null, "End of Program", "Bye", JOptionPane.PLAIN_MESSAGE);
                break;
            case 1:
                add();
                break;
            case 2:
                size();
                break;
            case 3:
                solve();
                break;
            case 4:
                set();
                break;
            case 5:
                remove();
                break;
            case 6:
                addAtIndex();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Entry.  Try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
                break;
        } // switch

    }
    public void add()
    {

    }
     public void size()
    {
        
    }
     public void solve()
    {
        
    }
     public void set()
    {
        
    }
     public void remove()
    {
        
    }
     public void addAtIndex()
    {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the index value: "));
        String temp = ""+JOptionPane.showInputDialog("Enter the expression: ");
    }
    public String addObjectMenu()
    {
        String n="";
        /*String choice="",value="";
        int selection;

        // Ask user what they would like to add
        /*do {        
            choice = "(1) Character \n (2) Short \n (3) Integer \n (4) Long \n (5) Float \n (6) Double \n (7) Boolean ";
            selection = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Object choice: \n " + choice,"Add: Choose an Object",
                    JOptionPane.INFORMATION_MESSAGE));
            if (selection<=0 || selection>7)
                JOptionPane.showMessageDialog(null, "Please enter only within the proper choice boundaries", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        } while (selection<=0 || selection>7);*/

        n = ""+JOptionPane.showInputDialog("Enter the value: ");
        // add the new node to the tail
        /*switch (selection) {
            case 1: n = new Node(new Character(value.charAt(0))); break;
            case 2: n = new Node(new Short(Short.parseShort(value))); break;
            case 3: n = new Node(new Integer(Integer.parseInt(value))); break;
            case 4: n = new Node(new Long(Long.parseLong(value))); break;
            case 5: n = new Node(new Float(Float.parseFloat(value))); break;
            case 6: n = new Node(new Double(Double.parseDouble(value))); break;
            case 7: n = new Node(new Boolean(value)); break;            
            default: JOptionPane.showMessageDialog(null, "Error!!", "Error", JOptionPane.INFORMATION_MESSAGE); break;                      
        } // switch*/

        return n;
    }
    public String  printStack(String message)
    {
        String output="The Stack is: \n\t",equation="";

        //add print method goal is to not use other data structer but insted return the stack
        //to the state it was at the start of the method
        System.out.println(s1.toString()+"   "+s2.toString());
        int sizeStart=s1.size();
        while(!s2.isEmpty())
            s1.push(s2.pop());
        while(!s1.isEmpty())
        {
            String temp=s1.pop();
            equation=temp+equation;
            s2.push(temp);
        }
        JOptionPane.showMessageDialog(null,message +"\n\n" + output+equation, "",JOptionPane.INFORMATION_MESSAGE);
        return "";
    }
}
