import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/darora/git/Reops/DeeJava/src/test/resources/PropertyFile.properties");

        prop.load(fis);
        System.out.println(prop.getProperty("browser"));
    }
}
