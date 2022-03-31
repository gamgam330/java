public class Box {
	int width;
	int length;
	int height;
	
	void Box(int width1, int length1, int height1){
		this.width = width1;
		this.length = length1;
		this.height = height1;
	}
	
	boolean isSameBox(Box obj) {
		if((width == obj.width) & (obj.length == length) & (obj.height == height)) {
		 	return true;
		}
		else {
			return false;
		}
	}
}
