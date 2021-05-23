# ChatClientAndServer
A chat client and server allowing back and forward messaging coded in Java. Final project for Network Technologies module.

Completed for the Network Technologies module, this chat client and server allows back and forward communication
between two terminals. The server should start first and listens for any incoming connections from a client.
Once a connection has been established, both client and server use threads to send and receive messages which
allows one to send multiple messages without upsetting flow of communication.

To run this program:<br>
1 Download project folder.<br>
2 Navigate to src/ie/gmit/dip folder in command prompt.<br>
3 Enter command..   javac *.java
4 Navigate up three levels to the src folder.<br>
5 Enter command..   java ie.gmit.dip.ChatServer<br>
6 Open new command prompt at src folder<br>
6 Enter command..   java ChatClient<br>
7 Both command prompt windows can now talk to each other.<br>
