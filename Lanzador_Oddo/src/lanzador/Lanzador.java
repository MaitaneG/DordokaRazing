package lanzador;

import java.io.File;



public class Lanzador {
	/**
	 * Metodo honek processBuilder objetuak gauzatzen ditu bidalitako bi parametroekin
	 * @param url da nabigatzailea zabaltzerakoan redirekzionatzeko helbidea
	 * @param c b (bai), e(ez) ea beste aplikazioa exekutatzea nahi duzun
	 */
	public void lanzarOddo( String url, char c) {  
		ProcessBuilder pb, pb2;												//Prozesuen deklarazioa
		try {
			
			String directory= System.getProperty("user.dir") + "\\bin\\";	//Proiektuaren oraingo ruta
			
			//pb2 = new ProcessBuilder("");
			//pb2.start();
	
			pb = new ProcessBuilder("java.exe", "-cp", directory, "lanzador.Navegador", url, Character.toString(c));	//prozesu berri bat proiektuko beste klase bat exekutatzen duena, urla eta char-a bidaltzen dio
			//pb.redirectOutput(new File(fichResultado));
			pb.redirectError(new File("Error_log.txt"));					//Erroreak Error_log fitxategian idazten dira
			pb.start();//proceso ha iniciado
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Lanzador l = new Lanzador();										//Klaseko objetu berri bat sortu
		
		l.lanzarOddo(" \"http://25.32.59.79:8069/web/login\" ", 'b' );		//Metodoari deitu
		System.out.println("Ok");
	}
	

}
