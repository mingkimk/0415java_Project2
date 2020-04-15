package Server;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;


public class ServerChat extends Thread {
	private Socket withClient = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String id = null;
	private String[] check = null;
	private ServerCenter sc = null;

	ServerChat(Socket withClient,ServerCenter sc) {
		this.withClient = withClient;
		this.sc=sc;
		// streamSet();
	}

	@Override
	public void run() {
		streamSet();
		// receive();
		// send();
	}

	public void streamSet() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {

						reMsg = withClient.getInputStream();

						byte[] reBuffer = new byte[1024];
						reMsg.read(reBuffer);

						ByteArrayInputStream bais = new ByteArrayInputStream(reBuffer);

						ObjectInputStream ois = new ObjectInputStream(bais);

						Object o = ois.readObject();
						if (o != null) {
							check = (String[]) o;
							for (int i = 0; i < check.length; i++) {
								System.out.println(check[i]);
								id=check[0];
							}
							String txt = "�������� �Ǿ����ϴ�.";
							sendMsg = withClient.getOutputStream();
							sendMsg.write(txt.getBytes());
							sc.select(check);
						}


						InetAddress c_ip = withClient.getInetAddress();
						String ip = c_ip.getHostAddress();
						
						System.out.println(id + "�� �α��� (" + ip + ")");
					}



				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
}