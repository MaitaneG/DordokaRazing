package lanzador;

import java.io.File;

public class Navegador {
	public static void main(String[] args) {
		String url = args[0];
		ProcessBuilder pb;
		try {
			
			pb = new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" " + url);
			//pb.redirectOutput(new File(fichResultado));
			pb.redirectError(new File("Error_log.txt"));
			pb.start();//proceso ha iniciado
			System.out.println("ok");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
