package Bit2c.utils;


import Enums.API;
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
        var inputStream = getClass().getClassLoader().getResourceAsStream("bit2c_keys.properties");
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
        return this.getApiKey(API.ONE) != null && this.getApiSec(API.ONE) != null;
    }



    public String getApiKey (API api) {


        switch (api){
            case ONE:{
                return this.props.getProperty("Key_2c_LIMIT_ONE");

            }

            case TWO:{
                return this.props.getProperty("Key_2c_LIMIT_TWO");

            }

            case THREE:{
                return this.props.getProperty("Key_2c_LIMIT_THREE");

            }

            case FOUR:{
                return this.props.getProperty("Key_2c_LIMIT_FOUR");

            }

        }

   return null;

    }


    public String getApiSec (API api) {


        switch (api){
            case ONE:{
                return this.props.getProperty("Sec_2c_LIMIT_ONE");

            }

            case TWO:{
                return this.props.getProperty("Sec_2c_LIMIT_TWO");

            }

            case THREE:{
                return this.props.getProperty("Sec_2c_LIMIT_THREE");

            }

            case FOUR:{
                return this.props.getProperty("Sec_2c_LIMIT_FOUR");

            }

        }

        return null;

    }




}
