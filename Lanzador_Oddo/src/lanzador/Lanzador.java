package lanzador;

import java.io.File;



public class Lanzador {
	public void lanzarOddo( String url, char c) {
		ProcessBuilder pb, pb2;
		try {
			
			String directory= System.getProperty("user.dir") + "\\bin\\";
			
			//pb2 = new ProcessBuilder("");
			//pb2.start();
	
			pb = new ProcessBuilder("java.exe", "-cp", directory, "lanzador.Navegador", url, Character.toString(c));
			//pb.redirectOutput(new File(fichResultado));
			pb.redirectError(new File("Error_log.txt"));
			pb.start();//proceso ha iniciado
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Lanzador l = new Lanzador();
		
		l.lanzarOddo(" \"http://25.32.59.79:8069/web/login\" ", 'b' );
		System.out.println("Ok");
	}
	

}
