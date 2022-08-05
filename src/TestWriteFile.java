import java.io.BufferedWriter;
import java.io.FileWriter;

public class TestWriteFile {


    public static void main(String[] args) {
        try {
            String path = "/interfaces/prod/service/HRL/debug_output.txt";
            String str = "World";
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));


            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
