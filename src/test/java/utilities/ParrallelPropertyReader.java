package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ParrallelPropertyReader {

    public static ThreadLocal<Properties> properties=new ThreadLocal<Properties>();

  public  static void initializePropertyFile() {
      Properties property=new Properties();

      try {
          FileInputStream fileLocation = new FileInputStream("src/test/resources/config.properties");
          property.load(fileLocation);
          properties.set(property);
      } catch (FileNotFoundException e) {

      } catch (IOException e) {

      }

  }

}
