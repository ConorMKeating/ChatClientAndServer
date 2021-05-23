package ie.gmit.dip;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author Conor Keating
 *
 */

public class SendMessage extends Thread {
	private Socket myConnection;
	private PrintStream p;
	private Scanner s = new Scanner(System.in);

	public SendMessage(Socket socket) {
		this.myConnection = socket;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String myText = s.nextLine();
				p = new PrintStream(myConnection.getOutputStream());
				p.println(myText);
				if (myText.equals("\\q")) {
					System.out.println("Chat ended.");
					System.out.println("***************************************************************");
					System.out.println("**********Thanks for using this simple chat facility!**********");
					System.out.println("***************************************************************");
					System.exit(0);
				}

			}
		}

		catch (IOException e) {
			System.out.println("ERROR: An Input/Output error occured.");
			System.exit(0);
		}

	}

}
