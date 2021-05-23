package ie.gmit.dip;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Conor Keating
 *
 */

public class ChatServer {
	private int port;

	public ChatServer(int port) {
		this.port = port;
	}

	public static void main(String[] args) {
		System.out.println("***************************************************************");
		System.out.println("**************Welcome to my simple chat facility!**************");
		System.out.println("***************************************************************");

		int port;
		if (args.length == 1) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 7;
		}

		ChatServer server = new ChatServer(port);
		server.go();
	}

	public void go() {
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("INFO: Server waiting for client to connect...");
			Socket socket = serverSocket.accept();
			System.out.println("INFO: Client connected");
			System.out.println("INFO: You may begin sending messages.");

			new SendMessage(socket).start();
			new GetMessage(socket).start();

			serverSocket.close();

		} catch (IOException e) {
			System.out.println("ERROR: Connection lost.");
			System.exit(0);
		}
	}

}
