package Exe5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClientSideApp {

	public static void main(String[] args) {
		
		System.out.println("----------------UDP Client Side------------------");
		
		try {

			// Create the socket object to transmit the data.
			DatagramSocket datagramSocket = new DatagramSocket();

			// Get IP address
			InetAddress ip = InetAddress.getLocalHost();
			
			// Declare port no
			int portNo = 1234;

			// Convert the String input into the byte array
			String text = "Selamat Beribadah Di Bulan Ramadhan";
			byte buf[] = text.getBytes();

			// Create datagrampacket utk send ke server
			DatagramPacket outPacket = new DatagramPacket(buf, buf.length, ip, portNo);

			// Send datagram packet to server
			System.out.println("\nSending '" + text + "' to the server.\n");
			datagramSocket.send(outPacket);
			
			//create object UDP to receive from server
			byte receiveBuf [] = new byte [1000];
			DatagramPacket inputPacket = new DatagramPacket (receiveBuf, receiveBuf.length);
			
			//receive data dari server
			datagramSocket.receive(inputPacket);
			
			//get number of word
			String textCount = new String (inputPacket.getData());
			//display
			System.out.print("Number of words in the sentence : " +textCount);
			
			datagramSocket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}