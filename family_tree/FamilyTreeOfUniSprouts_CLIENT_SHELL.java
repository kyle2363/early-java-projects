package family_tree;

import java.util.*;

public class FamilyTreeOfUniSprouts_CLIENT_SHELL
{
    static FamilyTreeOfUniSprouts_Node root,temp;
    static String names[][] = {{"Jones","ROOT-Node"},
        {"Bill","Jones"},  {"Katy","Jones"}, {"Mike","Jones"}, {"Tom","Jones"},
        {"Dave1","Bill"},  {"Mary","Bill"}, {"Leo","Katy"}, {"Betty","Mike"}, 
        {"Roger","Mike"}, {"Larry","Mary"}, {"Paul","Mary"}, {"Penny","Mary"},
        {"Don","Betty"}, {"Petter","Paul"}, {"Dave2","Don"}
    };    
 
    // ====================================================================
    // =========================== MAIN ==================================== 
    // ====================================================================
    public static void main(String[] args)
    {
        int  playAgain;
        String name, namesList= "\n"; 
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        // Build the Family of UniSprouts Tree       
        buildFamilyTreeOfUniSprouts();
        
        do {
            
            // Gather names
            for (int r=0; r<names.length; r++) {
                namesList += "   " + names[r][0] + "     \t" + names[r][1] + "\n";                
            }
            
            // Output namesList         
            System.out.println(" nameList: \n  Parent Child" + namesList);
          
            printFamilyTreeOfUniSprouts(root);            
            
            // Input name + print all relatives
            System.out.print("\n\n Enter a name from which to get \nGrandParent/Parent/Siblings/Cousins/Children/GrandChildren/"+
                      "Nieces/Nephews: \n");
            name = sc.next();
            printRelatives(name);
                                   
            // Play Again?
            System.out.print("\n\n Play Again? (1==yes, 2==no): ");
            playAgain = sc.nextInt();            
            
        } while (playAgain == 1);
    } // main  

    // ==================== buildFamilyTreeOfUniSprouts ====================== 
    public static void buildFamilyTreeOfUniSprouts()
    {      
        // >>>>>>>>>>>>>>>>>>>>> YOUR CODE HERE <<<<<<<<<<<<<<<<<<<<<<<<<<<   
        root=new FamilyTreeOfUniSprouts_Node(names[0][0]+","+names[0][1],0,null);
        FamilyTreeOfUniSprouts_Node temp2;
        for(int i=1;i<names.length;i++)
        {
            find(names[i][1],root);
            FamilyTreeOfUniSprouts_Node parent=temp;
            if(parent.getChildren()!=null)
            {
                temp2=parent.getChildren();
                while(temp2.getNext()!=null)
                {
                    temp2=temp2.getNext();
                }
            }else
            {
                temp2=parent;
            }
            placeNodeInFamilyTreeOfUniSprouts(parent,new FamilyTreeOfUniSprouts_Node
            (names[i][0]+","+names[i][1],parent.getGenerationLevel()+1,temp2));
        }
    }  // buildFamilyTreeOfUniSprouts()
    
    public static void find(String p,FamilyTreeOfUniSprouts_Node current)
    {
        if(current!=null)
        {
            if(current.getName().toLowerCase().
            substring(0,current.getName().indexOf(',')).equals(p.toLowerCase()))
            {
                temp=current;
            }else
            {
                find(p,current.getChildren());
                find(p,current.getNext());
            }
        }
    }
    // ============== placeNodeInFamilyTreeOfUniSprouts  ================= 
    public static void placeNodeInFamilyTreeOfUniSprouts
    (FamilyTreeOfUniSprouts_Node parent, FamilyTreeOfUniSprouts_Node child)
    {    
        // >>>>>>>>>>>>>>>>>>>>> YOUR CODE HERE <<<<<<<<<<<<<<<<<<<<<<<<<<<  
        if(parent.getChildren()==null)
        {
            parent.setChildren(child);
        }else
        {
            FamilyTreeOfUniSprouts_Node cur=parent.getChildren();
            while(cur.getNext()!=null)
            {
                cur=cur.getNext();
            }
            cur.setNext(child);
        }
    } // placeNodeInFamilyTreeOfUniSprouts()
    static FamilyTreeOfUniSprouts_Node ref;
    // ========================= printRelatives =============================== 
    public static void printRelatives(String name)
    {    
        // >>>>>>>>>>>>>>>>>>>>> YOUR CODE HERE <<<<<<<<<<<<<<<<<<<<<<<<<<<    
        find(name,root);
        ref=temp;
        int gen=ref.getGenerationLevel();
        FamilyTreeOfUniSprouts_Node current;
        System.out.println(ref.getName());
        System.out.println("\nGrandParents");
        if(gen<=1)
        {
            System.out.println("none");
        }else
        {
            current=ref;
            while(current.getGenerationLevel()!=gen-2)
            {
                current=current.getPrevious();
            }
            System.out.println(current.getName());
        }
        System.out.println("\nParents");
        if(gen<=0)
        {
            System.out.println("none");
        }else
        {
            current=ref;
            while(current.getGenerationLevel()!=gen-1)
            {
                current=current.getPrevious();
            }
            System.out.println(current.getName());
        }
        System.out.println("\nSiblings");
        if(ref.getNext()==null&&ref.getPrevious()==null || ref.getPrevious().getGenerationLevel()!=gen)
        {
            System.out.println("none");
        }else
        {
            current=ref.getPrevious();
            while(current.getGenerationLevel()==gen)
            {
                System.out.println(current.getName());
                current=current.getPrevious();
            }
            current=ref.getNext();
            if(current!=null)
            {
                while(current!=null&&current.getGenerationLevel()==gen)
                {
                    System.out.println(current.getName());
                    current=current.getNext();
                }
            }
        }
        System.out.println("\nCousins");
        if(ref.getGenerationLevel()!=0)
        {
            findgen(ref.getGenerationLevel(),root);
        }
        System.out.println("\nChildren");
        if(ref.getChildren()==null)
        {
            System.out.println("none");
        }else
        {
            current=ref.getChildren();
            while(current!=null)
            {
                System.out.println(current.getName());
                current=current.getNext();
            }
        }
        System.out.println("\nGrandChildren");
        findgrandkid(ref.getGenerationLevel()+2,ref.getChildren());
        System.out.println("\nNieces+Nephew");
        if(ref.getNext()!=null || ref.getPrevious()!=null)
        {
            findn(ref.getGenerationLevel()+1,findparent(ref).getChildren());
        }
    }  // printRelatives()
    public static FamilyTreeOfUniSprouts_Node findparent(FamilyTreeOfUniSprouts_Node current)
    {
        while(current!=null && current.getGenerationLevel()!=ref.getGenerationLevel()-1)
        {
            current=current.getPrevious();
        }
        return current;
    }
    public static void findgen(int x,FamilyTreeOfUniSprouts_Node current)
    {
        if(current!=null)
        {
            if(current.equals(findparent(ref)))
            {
                findgen(x,current.getNext());
            }else
            {
                if(current.getGenerationLevel()==x)
                {
                    System.out.println(current.getName());
                    findgen(x,current.getChildren());
                    findgen(x,current.getNext());
                }else
                {
                    findgen(x,current.getChildren());
                    findgen(x,current.getNext());
                }
            }
        }
    }
    public static void findn(int x,FamilyTreeOfUniSprouts_Node current)
    {
        if(current!=null)
        {
            if(current.equals(ref))
            {
                findn(x,current.getNext());
            }else
            {
                if(current.getGenerationLevel()==x)
                {
                    System.out.println(current.getName());
                    findn(x,current.getChildren());
                    findn(x,current.getNext());
                }else
                {
                    findn(x,current.getChildren());
                    findn(x,current.getNext());
                }
            }
        }
    }
    public static void findgrandkid(int x,FamilyTreeOfUniSprouts_Node current)
    {
        if(current!=null)
        {
                if(current.getGenerationLevel()==x)
                {
                    System.out.println(current.getName());
                    findgen(x,current.getChildren());
                    findgen(x,current.getNext());
                }else
                {
                    findgen(x,current.getChildren());
                    findgen(x,current.getNext());
                }
        }
    }
    // ============ printFamilyTreeOfUniSprouts — Created by Liam Bloom =============
    public static void printFamilyTreeOfUniSprouts(FamilyTreeOfUniSprouts_Node current) {
        for (String row : subtreeToString(current))
            System.out.println(row);
    } // printFamilyTreeOfUniSprouts()

    public static String[] subtreeToString(FamilyTreeOfUniSprouts_Node node) {
        final List<String[]> subtrees = new LinkedList<>();
        int rowCount = 0;
        int colCount = 0;
        for (FamilyTreeOfUniSprouts_Node c = node.getChildren(); c != null; c = c.getNext()) {
            final String[] subtree = subtreeToString(c);
            rowCount = Math.max(subtree.length, rowCount);
            colCount += subtree[0].length();
            subtrees.add(subtree);
        }
        if (rowCount == 0)
            rowCount++;
        else
            rowCount += 2;
        final String[] rowStrings = new String[rowCount];
        final String name = node.getName();
        colCount += subtrees.size() - 1;
        if (name.length() > colCount) {
            if (rowCount > 1)   {
                final String[] firstCol = subtrees.get(0);
                final String firstBorder = " ".repeat((name.length() - colCount) / 2);
                for (int i = 0; i < firstCol.length; i++)
                    firstCol[i] = firstBorder + firstCol[i];
                
                final String[] lastCol = subtrees.get(subtrees.size() - 1);
                final String lastBorder = " ".repeat((name.length() - colCount + 1) / 2);
                for (int i = 0; i < lastCol.length; i++)
                    lastCol[i] += lastBorder;
            }
            colCount = name.length();
        }
        rowStrings[0] = " ".repeat((colCount - name.length()) / 2)
            + name
            + " ".repeat((colCount - name.length() + 1) / 2);
        if (rowCount > 1) {
            final StringBuilder[] builders = new StringBuilder[rowStrings.length - 2];
            for (int i = 0; i < builders.length; i++)
                builders[i] = new StringBuilder(colCount);
            final char[] branchChars = new char[colCount];
            for (int i = 0; i < branchChars.length; i++)
                branchChars[i] = '\u2500';
            final int center = (colCount - 1) / 2;
            int i = 0;
            final ListIterator<String[]> iter = subtrees.listIterator();
            while (iter.hasNext()) {
                final boolean isFirst = !iter.hasPrevious();
                final String[] col = iter.next();
                final int subColSize = col[0].length();
                final boolean isLast = !iter.hasNext();
                final int subCenter = (subColSize - 1) / 2;

                char centerChar = '\u252c';
                if (isFirst ^ isLast) {
                    if (isFirst) {
                        centerChar = '\u250c';
                        for (int j = 0; j < subCenter; j++)
                            branchChars[j] = ' ';
                    }
                    else { // isLast
                        centerChar = '\u2510';
                        for (int j = i + subCenter; j < branchChars.length; j++)
                            branchChars[j] = ' ';
                    }
                }
                else if (isFirst && isLast) {
                    centerChar = ' ';
                    for (int j = 0; j < branchChars.length; j++)
                        branchChars[j] = ' ';
                }
                branchChars[i + subCenter] = centerChar;

                for (int j = 0; j < col.length; j++) {
                    builders[j].append(col[j]);
                    assert col[j].length() == subColSize;
                }
                for (int j = col.length; j < builders.length; j++)
                    builders[j].append(" ".repeat(subColSize));

                if (!isLast) {
                    for (StringBuilder builder : builders)
                        builder.append(' ');
                }
                
                i += subColSize + 1;
            }

            char centerChar;
            switch (branchChars[center]) {
                case '\u2500':
                    centerChar = '\u2534';
                    break;
                case '\u252c': 
                    centerChar = '\u253c';
                    break;
                case ' ':
                    centerChar = '\u2502';
                    break;
                default:
                    throw new IllegalStateException("Illegal central character '" + branchChars[center] + "' in \"" + new String(branchChars) + '"');
            }

            branchChars[center] = centerChar;

            rowStrings[1] = new String(branchChars);

            for (i = 0; i < builders.length; i++)
                rowStrings[i + 2] = builders[i].toString();
        }

        return rowStrings;
    }

}  // FamilyTreeOfUniSprouts_CLIENT
