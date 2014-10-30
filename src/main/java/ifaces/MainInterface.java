package ifaces;

import java.util.List;



public interface MainInterface {

    void stateChange(List<String> sensors);
    void register();
    void unregister();
    
}
