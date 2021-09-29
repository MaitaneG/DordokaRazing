package lanzador;

import java.io.File;



public class Lanzador {
	public void lanzarOddo( String url) {
		ProcessBuilder pb;
		try {
			
			pb = new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" \"http://212.81.192.58:5432/NewTel1\"");
			//pb.redirectOutput(new File(fichResultado));
			pb.redirectError(new File("Error_log.txt"));
			pb.start();//proceso ha iniciado
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Lanzador l = new Lanzador();
		l.lanzarOddo("\"http://212.81.192.58:5432/NewTel1\"");
		System.out.println("Ok");
	}
	

}
