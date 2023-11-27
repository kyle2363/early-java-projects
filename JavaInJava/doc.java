package JavaInJava;
import java.io.*;
import java.util.*;
import javax.tools.*;
import javax.tools.JavaCompiler.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.net.URL;
import java.net.*;
import java.lang.reflect.*;
public class doc
{
    //work in progress
    public static void main(String args[])
    {
        try{
            int i=0;
            while(true)
            {
                File f=new File("C:\\Users\\Sae\\Documents\\GitHub\\CS_Portfolio\\JavaInJava\\code.txt");
                Scanner myReader = new Scanner(f);
                String s="";
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    s+=data;
                }
                System.out.println(i);
                //com.runCode(s);
                com.runCode("import java.nio.file.*;\nimport java.io.*;\nimport java.lang.*;\n class TestClass{" +
                        "    public static void main() throws Exception{" +
                        "        System.out.println(" + "\"test\"" +"+\""+i+"\"" +          ");" +
                        "File f=new File(\"C:\\\\Users\\\\Sae\\\\Documents\\\\bluej projects\\\\Spring Project 2023\\\\java in java\\\\output.txt\");"+
                        "FileWriter myWriter = new FileWriter(\"C:\\\\Users\\\\Sae\\\\Documents\\\\bluej projects\\\\Spring Project 2023\\\\java in java\\\\output.txt\");"+
                        "myWriter.write(\"works\"+\" "+i+" \");"+
                        "myWriter.close();"+
                        "}" +
                        "}");
                i++;
                Thread.sleep(5000);
                f=null;
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}