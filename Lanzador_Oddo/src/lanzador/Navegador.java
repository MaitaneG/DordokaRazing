package lanzador;

import java.io.File;

public class Navegador {
	public static void main(String[] args) {
		String url = args[0];
		char backup = (args[1].toCharArray())[0];
		ProcessBuilder pb, pb2;
		String directory = "ruta/archivo.jar";
		try {
			
			pb = new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"" , url);
			//pb.redirectOutput(new File(fichResultado));
			pb.redirectError(new File("error_logs\\Odoo_Error_log.txt"));
			pb.start();//proceso ha iniciado
			System.out.println("ok");
			
			if(backup == 'b') {
				pb2 = new ProcessBuilder("java.exe", "-jar",directory);
				
				pb2.redirectError(new File("error_logs\\Java_Error_log.txt"));
				pb2.start();
				System.out.println("Backup created" );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
