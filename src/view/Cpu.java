package view;

public class Cpu {

	private native float getCpu();

	public static void main(String[] args) {
		
		System.load("/home/booob/workspace/ZiarnaZBIOSu/src/view/dll.so");
		Cpu cpu = new Cpu();
		
		System.out.println(cpu.getCpu());
	}

}
