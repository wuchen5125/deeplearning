package deaplearning.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {

	public static void main(String[] args) throws IOException {
		try {
			DatagramSocket server = new DatagramSocket(3000,InetAddress.getLocalHost());
			byte[] b = new byte[1024];
			DatagramPacket p = new DatagramPacket(b, b.length);
			server.receive(p);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
