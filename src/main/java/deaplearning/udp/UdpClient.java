package deaplearning.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(3000);
			DatagramPacket dp = new DatagramPacket("hs".getBytes(), "hs".getBytes().length,
					InetAddress.getLocalHost(),3000);
			ds.send(dp);
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
