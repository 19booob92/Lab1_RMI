package ifaces;


import java.util.ArrayList;
import java.util.HashMap;

public interface IRegistry {

	int registerObject(Object sensor, int category); // 1 : sensor
																			// 0 : monitor
	boolean unRegister(int number);				// < 0 : blad
	void getObjects(int category);
}
