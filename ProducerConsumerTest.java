package 자바;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		(new Thread(new Producer(buffer))).start();								//생산자 스레드 생성 후 스타트
		(new Thread(new Consumer(buffer))).start();								//소비자 스레드 생성 후 스타트
	}
}																			

class Consumer implements Runnable{
	private Buffer buffer;
	public Consumer(Buffer drop) {
		this.buffer = drop;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			int data = buffer.get();
			System.out.println("소비자 : "+data+"번 케익을 소비하였습니다.");
			
			try {
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e) {}
		}
	}
}

class Producer implements Runnable{
	private Buffer buffer;
	public Producer(Buffer drop) {
		this.buffer = drop;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			buffer.put(i);
			System.out.println("생산자 : "+i+"번 케익을 생산하였습니다.");
			
			try {
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e) {}
		}
	}
}

class Buffer{																	//동시 진행이라 막 출력이 되어야 하는데 버퍼로 잡아줬음.
	private int data;														
	private boolean empty = true;
	public synchronized int get() {
		while(empty) {															//empty 변수가 true라 여긴 걸리고
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		empty = true;
		notifyAll();
		return data;
	}
	
	public synchronized void put(int data) {
		while(!empty) {															//여긴 false가 나와서 안걸리고 통과함
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		empty = false;															//이거 false로 만들면 다시 get함수가 안걸림
		this.data = data;
		notifyAll();
	}
}