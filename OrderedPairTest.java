package ÀÚ¹Ù;

public class OrderedPairTest<T, K> {
	private T key;
	private K value;
	OrderedPairTest(T key, K value){
		this.key = key;
		this.value = value;
	}
	
	public T getKey() {
		return key;
	}
	public K getValue() {
		return value;
	}
	
	
	public static void main(String[] args) {
		OrderedPairTest<String, Integer> p1 = new OrderedPairTest<String, Integer>("mykeyy", 12345678);
		System.out.println(p1.getKey()+" "+p1.getValue());
	}
}
  