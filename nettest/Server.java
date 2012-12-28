package nettest;

import java.net.*;
import java.io.*;

public class Server {
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	long startTime = System.nanoTime();
	long endTime;

	public Server() {
		try {
			ServerSocket ss = new ServerSocket(10000);
			while (true) {
				socket = ss.accept();
				endTime = System.nanoTime();
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				while (true) {
					String line = in.readLine();
					if (line.equals("stop"))
						break;
					out.println("your input is : " + line);
					long duration = endTime - startTime;
					out.println("Time:" + duration);
				}
				out.close();
				in.close();
				socket.close();
			}
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) throws IOException {
		new Server();
	}
}