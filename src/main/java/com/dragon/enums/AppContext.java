package main.java.com.enums;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by huangzhibo on 27/05/2017.
 */
public enum AppContext {

    INSTANCE;

    private volatile Properties properties = new Properties();

    public void init(){
        InputStream is = this.getClass().getResourceAsStream("./test.properties");
        if (null != is){
            try {
                this.properties.clear();
                this.properties.load(is);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    is.close();
                }catch (Throwable t){
                    t.printStackTrace();
                }
            }
        }
    }

    public String getConfigValue(String key){
        return this.properties.getProperty(key);
    }
}
