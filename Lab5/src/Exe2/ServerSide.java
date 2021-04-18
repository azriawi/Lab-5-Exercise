package Exe2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class ServerSide {


	public static void main(String[] args) {
		
			
			try {
				
				// Port to receive and respond to request
				
				int portNo = 4646;
				ServerSocket serverSocket = new ServerSocket(portNo);
				System.out.println("\n-----------------Server Side------------------------\n");
				System.out.println("Ready for request...");
				System.out.println("Running...");
				
				String validate;
				int itemProductID=0;
				
				// Server need to be alive forever thus the while(true)
				while (true) {
					
					// Accept client request for connection
					Socket socket = serverSocket.accept();
					
					// Create input stream to read object
					ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
					
					// Read object from stream and cast to Location
					ItemProduct ip = (ItemProduct) objectIS.readObject();
					
					//create object for class Validation
					Validation validatename = new Validation();
					
					//to validate the name of product 
					validate = validatename.validateItemName(ip);
					
					// Process object and give product ID
					ip.setItemProductID(++itemProductID);
					
					
					// Create output stream to send object
					ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
					objectOS.writeObject(ip);
					objectOS.writeObject(validate);
					objectOS.flush();
					
					//display
					System.out.println(" Validation Result: " + validate);
					System.out.println("Ready for next request");
					
					// Close all streams
					objectIS.close();
					objectOS.close();
					
				}
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	

	}

