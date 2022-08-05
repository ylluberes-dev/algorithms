import java.io.File;
import java.io.FileWriter;

public class TestException {

    public static void main(String[] args) {
        String value = null;
        try {
           String a =  doSomeshing();
           Exception x = new Exception();
        }catch (Exception e){
            System.out.println("Logging message: "+e.getMessage());
           // Logging message: null
        }
    }

    public static String doSomeshing () throws Exception {
        String a = null;
        try{
            FileWriter writer = new FileWriter(new File(""));
            a.trim();
        }catch (Exception e) {
            throw (e);
        }
        return "hola";
    }
}
