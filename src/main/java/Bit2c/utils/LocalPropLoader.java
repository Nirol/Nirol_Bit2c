package Bit2c.utils;



import lombok.Data;
import lombok.var;

import java.io.IOException;
import java.util.Properties;

@Data
public class LocalPropLoader
{
    private Properties props;

    public LocalPropLoader () {
        this.props = new Properties();
        var inputStream = getClass().getClassLoader().getResourceAsStream("keys.properties");
        if (inputStream != null) {
            try {
                props.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Key file not found in the classpath");
        }
        if (!keysFound()) {
            System.out.println("Keys couldn't be found in key file. Private methods won't work");
        }
    }



    public boolean keysFound () {
        return this.getApiKey() != null && this.getApiSec() != null;
    }


    public String getApiKey () { return this.props.getProperty("key");}
    public String getApiSec () {
        return this.props.getProperty("secret");
    }




}
