package Server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Manager.Setting;

public class SMain {

	public static void main(String[] args) throws Exception {
		ServerSocket serverS = null;
		Socket withClient = null;
		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("1.247.118.30", 12345));

		ArrayList<Socket> cList = new ArrayList<>();
		ServerCenter sc =new ServerCenter();
		while (true) {
			System.out.println("서버 대기중");
			withClient = serverS.accept();
			cList.add(withClient);
			System.out.println(cList);
			System.out.println(withClient.getInetAddress() + "클라이언트 접속 함");
			ServerChat s = new ServerChat(withClient, sc);
			s.start();

		}
	}

}