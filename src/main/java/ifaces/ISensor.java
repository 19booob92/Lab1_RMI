package ifaces;



public interface ISensor extends MainInterface {
	
	boolean start();
	boolean stop();
	String getReading();
	void setPosition(String position);
	String getPosition();
	int getNumber();
}
