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
public class com {
    //static String s="C:\\Users\\sproc\\Documents\\bluej projects\\Spring Project 2023\\java in java\\TextClass.class";
    //static String[] sa=new String[1];
    static JavaObjectFromString javaFileObject;
    static String code;
    public static void runCode(String codeS) throws Exception {
        try{
            javaFileObject=null;
            code=null;
            code=codeS;
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            DiagnosticCollector diagnosticsCollector =
                new DiagnosticCollector();
            StandardJavaFileManager fileManager  =
                compiler.getStandardFileManager(null, null, null);
            JavaFileObject javaObjectFromString = getJavaFileContentsAsString(codeS);
            Iterable fileObjects = Arrays.asList(javaObjectFromString);
            CompilationTask task = compiler.getTask(null, fileManager, null, null, null, fileObjects);
            Boolean result = task.call();
            //sa[0]=s;
            try {
                URL[] urls = {new URL("file:C:\\Users\\Sae\\Documents\\bluej projects\\Spring Project 2023\\java in java\\TestClass/")};
                ClassLoader cl_old = Thread.currentThread().getContextClassLoader();
                ClassLoader cl_new = new URLClassLoader(urls,cl_old);
                Class compiledClass = cl_new.loadClass("TestClass");
                Method myMethod = compiledClass.getMethod("main");
                Object tmp = myMethod.invoke(null);
                cl_old=null;
                cl_new=null;
                compiledClass=null;
                myMethod=null;
                tmp=null;
            } catch (Exception ex) {
                System.out.println("error "+ex.getCause());
                //Logger.getLogger(ITaskCompile.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(result == true){
                System.out.println("Compilation has succeeded");
            }else{
                System.out.println("Compilation fails.");
            }
            javaObjectFromString.delete();
            File f=new File("TestClass.class");
            f.delete();
            //File[] fa= listFiles.
        }catch(Exception e)
        {
            PrintStream out = new PrintStream(new FileOutputStream
            ("C:\\Users\\Sae\\Documents\\bluej projects\\Spring Project 2023\\java in java\\output_3.txt"));
            System.setOut(out);
            System.setErr(out);
            System.out.println("error");
        }
    }

    static SimpleJavaFileObject getJavaFileContentsAsString(String s) throws Exception {
        StringBuilder javaFileContents = new StringBuilder(s);
        JavaObjectFromString javaFileObject = null;
        try{
            javaFileObject = new JavaObjectFromString("TestClass", javaFileContents.toString());
        }catch(Exception exception){
            //exception.printStackTrace();
            PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\Sae\\Documents\\bluej projects\\Spring Project 2023\\java in java\\output_com.txt"));
            System.setOut(out);
            System.setErr(out);
        }
        return javaFileObject;
    }
}
