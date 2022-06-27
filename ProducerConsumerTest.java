package �ڹ�;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		(new Thread(new Producer(buffer))).start();								//������ ������ ���� �� ��ŸƮ
		(new Thread(new Consumer(buffer))).start();								//�Һ��� ������ ���� �� ��ŸƮ
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
			System.out.println("�Һ��� : "+data+"�� ������ �Һ��Ͽ����ϴ�.");
			
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
			System.out.println("������ : "+i+"�� ������ �����Ͽ����ϴ�.");
			
			try {
				Thread.sleep((int)(Math.random()*100));
			}catch(InterruptedException e) {}
		}
	}
}

class Buffer{																	//���� �����̶� �� ����� �Ǿ�� �ϴµ� ���۷� �������.
	private int data;														
	private boolean empty = true;
	public synchronized int get() {
		while(empty) {															//empty ������ true�� ���� �ɸ���
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		empty = true;
		notifyAll();
		return data;
	}
	
	public synchronized void put(int data) {
		while(!empty) {															//���� false�� ���ͼ� �Ȱɸ��� �����
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		empty = false;															//�̰� false�� ����� �ٽ� get�Լ��� �Ȱɸ�
		this.data = data;
		notifyAll();
	}
}