package ifaces;

import java.util.List;


public interface IMonitor extends MainInterface {

    void change();
    void stateChange(List<String> sensors);
    int getNumber();
}
