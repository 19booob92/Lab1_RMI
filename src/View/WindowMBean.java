package View;

public interface WindowMBean {

	void make();
	
	String getName(); 
	
	boolean isRunned();
	void setRunned(boolean isRunned);
	
	int[] getValues();
	void setValues(int[] values);

	public int getTimeout();
	public void setTimeout(int timeout);
}
