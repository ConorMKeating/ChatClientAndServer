package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 
 * @author Conor Keating
 *
 */

public class GetMessage extends Thread {
	private Socket theSocket;
	private BufferedReader br;

	public GetMessage(Socket socket) {
		this.theSocket = socket;
	}

	@Override
	public void run() {
		try {
			while (true) {
				br = new BufferedReader(new InputStreamReader(this.theSocket.getInputStream()));
				String sentence = br.readLine();
				if (sentence.equals("\\q")) {
					System.out.println("Chat ended.");
					System.out.println("***************************************************************");
					System.out.println("**********Thanks for using this simple chat facility!**********");
					System.out.println("***************************************************************");
					System.exit(0);
				}
				System.out.println("----RECEIVED: " + sentence);
			}
		} catch (IOException e) {
			System.out.println("ERROR: Chat facility disconnected.");
			System.exit(0);
		}
	}

}
