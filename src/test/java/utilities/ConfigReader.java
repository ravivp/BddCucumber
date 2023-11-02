package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties prop;

    public  Properties initProp(){

        prop=new Properties();
        try {
            FileInputStream fileLocation=new FileInputStream("src/test/resources/config.properties");
            //C:\Users\Windows\IdeaProjects\goodyear\src\test\resources\config.properties

            prop.load(fileLocation);
        } catch (FileNotFoundException e) {
           e.printStackTrace();
           System.out.println(e);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return  prop;
    }


}
