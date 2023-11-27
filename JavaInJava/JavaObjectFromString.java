package JavaInJava;
import java.net.URI;
import javax.tools.*;
import java.io.IOException;

class JavaObjectFromString extends SimpleJavaFileObject{
    private String contents = null;
public JavaObjectFromString(String className, String contents) throws Exception{
            super(new URI(className), Kind.SOURCE);
this.contents = contents;
    }
public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return contents;
    }
}
