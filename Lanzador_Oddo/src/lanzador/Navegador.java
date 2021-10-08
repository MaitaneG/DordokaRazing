package lanzador;

import java.io.File;

public class Navegador {
	public static void main(String[] args) {
		String url = args[0];				
		char backup = (args[1].toCharArray())[0];							//Aldagaien deklarazioa
		ProcessBuilder pb, pb2;
		

		//String directory = "C:\\Users\\kalboetxeaga.ager\\Documents\\aab\\newDordoka3\\DordokaRazing\\odoKonekxioa";

		try {
			
			pb = new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"" , url);		//Prozesu bat sortzen da ProcessBuilder erabiliz
			//pb.redirectOutput(new File(fichResultado));															//Chrome aplikazioa exekutatzen du eta url a pasatzen dio parametro bezala horrela chrome horrialde horretara joango da
			pb.redirectError(new File("error_logs\\Odoo_Error_log.txt"));											//Odook izan dituen erroreak fitxategi batera bidaltzen ditu
			pb.start();	//proceso ha iniciado
			System.out.println("ok");
			
			
			if(backup == 'b') {	


				String value = System.getenv("USERPROFILE");														//Ordenagailua erabiltzen hari den erabiltzailearen ruta
				pb2 = new ProcessBuilder(value + "\\Documents\\DordokaRazing\\odoKonekxioa\\ejecutador.bat");		//Hemen batch fitxategi bat exekutatzeko prozesu bat habiarazten da. Batch honek odooKonexioa proiektuko karpetara joango da eta mvn comandu baten bidez spring boot aplikazioa exekutatzen du backgroundean

				
				pb2.redirectError(new File("error_logs\\Java_Error_log.txt"));										//Erroreak Java error logera bidaltzen dira
				pb2.start();
				System.out.println("Backup created" );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
