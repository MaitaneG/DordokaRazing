package eus.uni.dam;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class ProduktuaDaoTextFile implements ProduktuaDao {

	String fitxategia = "Peliak.csv";
	public List<Produktua> produktuak = new ArrayList<>();

	ProduktuaDaoTextFile() {

	};

	public Collection<Produktua> getProduktuak() {
		return produktuak;
	};

	/**
	 * Hasieran, fitxategia irakurri eta datuak memorian, zerrenda baten kargatuko
	 * dira. Stream-ak erabiliz.
	 * 
	 */
	@PostConstruct
	public void init() {
		String sql = "select product_product.id , product_template.name as deskripzioa, product_template.list_price , stock_quant.quantity as kantitatea, product_category.name as kategoria\n"
				+ "from product_product inner join product_template on product_product.id = product_template.id inner join stock_quant on product_product.id = stock_quant.product_id inner join product_category on product_template.categ_id =product_category.id\n"
				+ "where stock_quant.location_id=8\n"
				+ "order by product_product.id asc;";

		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://25.32.59.79:5432/NewTel1", "openpg", "openpgpwd"); 
				//Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gauzak", "openpg", "openpgpwd");
				Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Produktua p1 = new Produktua(rs.getInt("id"), rs.getString("deskripzioa"),rs.getDouble("kantitatea"),rs.getDouble("list_price"),rs.getString("kategoria"));
				produktuak.add(p1);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * Memorian, aurretik kargatu dugun zerrenda itzultzen du metodo honek
	 * 
	 */
	public Collection<Produktua> findAll() {
		return produktuak;
	}

	/**
	 * Pelikula berri bat txertatzen du memoriako zerrendan
	 * 
	 * @param pelicula
	 */
	public void insert(Produktua produktua) {
		produktuak.add(produktua);
	};

	/**
	 * Pelikulen zerrendan id berdina daukan pelikula bilatu eta aldatu
	 * 
	 * @param pelicula
	 */
	public void edit(Produktua produktua) {
		// TO-DO
	};

	/**
	 * Pelikulen zerrendatik, id hori daukana bilatu eta ezabatu
	 * 
	 * @param id
	 */
	public void delete(long id) {
		// TO-DO
	};

	/**
	 * Katalogoa berriz behar ez dugunean, memorian daukagun zerrenda testu
	 * fitxategi baten egingo dugu persistente.
	 * 
	 */
	@PreDestroy
	public void destroy() {
		String filename = "../NewTelApp/app/src/main/assets/Produktuak.csv";
		File myObj = new File(filename);
		try {
			File logFile = new File ("logs/logs.txt");
			if(!logFile.exists()) {
				logFile.createNewFile();
				FileWriter logWriter = new FileWriter("logs/logs.txt");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formattedDateTime =(LocalDateTime.now()).format(formatter);
				String toWrite= "- " + formattedDateTime + ", Orain, " + produktuak.size() + " produktu exportatu dira.\n";	
				logWriter.write(toWrite);
				logWriter.close();
				System.out.println("log created");
				
			}else {
				
				Scanner logReader = new Scanner(myObj);
				String line;
				ArrayList<String> datuakLog = new ArrayList<>();
				List<Produktua> produktuakLog = new ArrayList<>();
				String logTxt="";
				int idCount1=0;
				int idCount2=0;
				List<Produktua> falta = new ArrayList<>();
				
				while((logReader.hasNextLine())) {
					line = logReader.nextLine();
					
					if(Character.isDigit(line.charAt(0))){ 					//tituloa kentzeko

	                    line=line.substring(0, line.length()-1); 
	                    datuakLog.add(line);								//logem datuen listara sartu
	                    String[] strings = line.split(";");					//excel en tabulazioak kendu
	                    produktuakLog.add(new Produktua((Integer.parseInt(strings[0])),strings[1],Double.parseDouble(strings[4]), Double.parseDouble(strings[3]),strings[2]));  //produktu bat sortu
	                }					//p.getIdProd() + ";" + p.getDeskripzioa() + ";" + p.getKategoria() + ";" + p.getPrezioa()+ ";" + p.getKantitatea() + 
				}
				for(Produktua p : produktuak) {
					idCount1 += p.getIdProd();
				}for(Produktua p : produktuakLog) {
					idCount2 += p.getIdProd();
				}
				if(produktuak.size() > produktuakLog.size()) {			//datubaseko produktuen kantitatea lehenago fitxategian baino handiagoa bada, x produktu gehitu ditugu, 
					for(Produktua p: produktuak) {
						if(!produktuakLog.contains(p)) {
							falta.add(p);
						}
					}
					int suma= produktuak.size() - produktuakLog.size();
					logTxt = logTxt + suma + " produktu gehitu dira(" + falta.toString() + ")" ;
					
					
				}else if(produktuak.size() < produktuakLog.size()) {		//berriz fitxategian produktu gehiago badaude datubasetik fitxategi hoiek ezabatu dira
					
					for(Produktua p: produktuakLog) {
						if(!produktuak.contains(p)) {
							falta.add(p);
						}
					}
					int resta = produktuakLog.size() - produktuakLog.size();
					logTxt = logTxt + resta + " produktu ezabatu dira(" + falta.toString() + ")";
						
				}else if(produktuak.size() == produktuakLog.size() && idCount1 == idCount2) {
					
					logTxt = "Ez da egon aldaketarik.";
				}else {
						for(Produktua p: produktuakLog) {
							if(!produktuak.contains(p)) {
								falta.add(p);
							}
						}
					logTxt = "Aldaketak egon dira";
				}
				//FileWriter logWriter = new FileWriter("C:\\Users\\kalboetxeaga.ager\\Documents\\aab\\newDdordoka\\DordokaRazing\\odoKonekxioa\\logs.txt", true);
				BufferedWriter logWriter = new BufferedWriter(new FileWriter("logs/logs.txt", true));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formattedDateTime =(LocalDateTime.now()).format(formatter);
				String toWrite= "\n- " + formattedDateTime + ", Orain, " + produktuak.size() + " produktu daude.\n \t" + logTxt;
				logWriter.append(toWrite);
				logWriter.close();
				System.out.println("Log writted");//Azkenean zenbat produktu dauden eta ea ezabatu edo gehitu diren
				
				
			}
			
			
		}catch(IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		


		/*try {
			File myObj = new File("Produktuak.csv");
			myObj.createNewFile();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}*/
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write("ID PRODUKTU ; DESKRIPZIOA ; KATEGORIA ; PREZIOA ; KANTITATEA \n");

			for (Produktua p : produktuak) {
				writer.write(p.getIdProd() + ";" + p.getDeskripzioa() + ";" + p.getKategoria() + ";" + p.getPrezioa()+ ";" + p.getKantitatea() + "\n");
			}

			writer.close();
			System.out.println("Successfully wrote to the file.");

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}

