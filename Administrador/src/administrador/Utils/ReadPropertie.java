/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Merlin
 */
public class ReadPropertie {
    String result = "";
    InputStream inputStream;
    String propFileName = "resources/config.properties";
    
    public String getPropertie(String key){
        
    try{
        
        Properties prop = new Properties();
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if(inputStream != null){
        prop.load(inputStream);
        }
        else{
            throw new FileNotFoundException("Properties " + propFileName + " not found.");
        }
    return prop.getProperty(key);
    }
    catch(Exception e){
    return e.getMessage();
    }
    }
}
