package ie.gmit.dip;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author Conor Keating
 * 
 */

public class ChatClient {
	private String hostname;
	private int port;

	public ChatClient(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public static void main(String[] args) {
		System.out.println("***************************************************************");
		System.out.println("**************Welcome to my simple chat facility!**************");
		System.out.println("***************************************************************");

		String host;
		int port;
		if (args.length == 2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		} else {
			host = "localhost";
			port = 7;
		}

		ChatClient myClient = new ChatClient(host, port);
		myClient.go();
	}

	public void go() {
		try {
			Socket socket = new Socket(hostname, port);

			System.out.println("INFO: Connected to server...");
			System.out.println("INFO: You may begin sending messages.");

			new GetMessage(socket).start();
			new SendMessage(socket).start();

		} catch (UnknownHostException ex) {
			System.out.println("ERROR: Server not found.");
		} catch (IOException ex) {
			System.out.println("ERROR: Server not responding.");
			System.exit(0);
		}
	}

}
