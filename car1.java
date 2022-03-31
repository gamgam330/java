
public class car1 {
	private String model;
	private String color;
	private int speed;
	
	private int id;
	private static int numbers = 0;
	
	public car1(String m, String c, int s) {
		model = m;
		color = c;
		speed = s;
		
		id = ++numbers; 
	}
	public static int getNumberOfCars() {
		return numbers;
	}
}
