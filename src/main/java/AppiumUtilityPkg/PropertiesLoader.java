package AppiumUtilityPkg;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	private static String Filepath = "F:\\SHIV NEWSCRIPTS\\AppiumMavenProject\\src\\main\\java\\ConfigPkg\\Server.properties";

    public String getProperties(String Key) throws IOException
    {
     Properties prop = new Properties();
     
     FileInputStream fis = new FileInputStream(Filepath);
     
     prop.load(fis);
     
     String property = prop.getProperty(Key);
     
     return property;    
    }


}
