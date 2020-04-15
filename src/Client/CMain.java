package Client;

import java.net.Socket;

import Manager.Setting;


public class CMain {

	public static void main(String[] args) throws Exception {
		Socket withServer = null;
		withServer = new Socket("1.247.118.30",12345);
		System.out.println("�����Ƕ� ��Ʈ�ѹ� ����");
		new ClientChat(withServer);
		//new Login();
		//new Setting();
	}

}
