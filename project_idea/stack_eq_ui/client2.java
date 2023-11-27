package project_idea.stack_eq_ui;

import javax.swing.JOptionPane;
import java.util.*;

public class client2 {

    public static void main(String[] args) {
        int selection;
        Stack2 a=new Stack2("1+1");
        do {

            do {
                   selection = a.menu();    
                   if (a.isBadSelection(selection))
                       a.BadSelectionMsg();
            } while (a.isBadSelection(selection));      
     
            a.doArrayListMethod(selection);  
            a.printStack("here");
         }while (selection != 0);
    }
}
