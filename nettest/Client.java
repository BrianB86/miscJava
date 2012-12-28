package nettest;
import java.io.*;
import java.net.*;

public class Client {
	
	public Client() {
		try {
			Socket socket = new Socket("127.0.0.1", 10000);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				String str = "hello";
				out.println(str);
				if (str.equals("stop")) break;
				System.out.println(in.readLine());	
				}
				
			line.close();
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args){
		new Client();
		
	}
	
}
