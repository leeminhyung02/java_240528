package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test3 {

	public static void main(String[] args) {

		String ip;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
