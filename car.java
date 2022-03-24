
public class car {
	String color = "»¡°­";
	int gear = 2;
	int speed = 80;
	public String toString() {
		return "Car [color =" +color+", speed=" +speed+ ", gear=" +gear+ "]";
	}

	void changeGear(int G) {
		gear = G;
	}

	void speedUp() {
		speed += 5;
	}

	void speedDown() {
		speed -= 5;
	}
}