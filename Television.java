public class Television {
		private int channel;
		private int volume;
		private boolean onOff;
		
		Television(int channel1, int volume1, boolean onOff1){
			channel = channel1;
			volume = volume1;
			onOff = onOff1;
		}
		void print() {
			System.out.println("ä���� "+channel+"�̰� ������ "+volume+"�Դϴ�.");
		}
		/*int getChannel() {
			return channel;
		}
		void setChannel(int ch) {
			channel = ch;
		}*/
}