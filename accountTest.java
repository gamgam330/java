
public class accountTest {
	public static void main(String[] args) {
		account obj = new account();
		obj.setName("Tom");
		obj.setBalance(100000);
		System.out.println("이름은" +obj.getName()+" 통장잔고는 "+obj.getBalance()+"입니다. ");
	}
}