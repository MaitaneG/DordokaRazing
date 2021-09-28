package eus.uni.dam;

import java.io.BufferedReader;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
		String sql = "SELECT product_product.id, name FROM product_product inner join product_template on product_product.id = product_template.id order by product_product.id asc";
	       
	    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_aproba", "openpg", "openpgpwd");
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	      	  Produktua p1= new Produktua(rs.getInt("id"),rs.getString("name"));        	  
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
		String filename = "Produktuak.csv";
		PrintWriter outputStream = null;

		/*try {
			ClassPathResource fileResource = new ClassPathResource(filename);
			outputStream = new PrintWriter(new FileWriter(fileResource.getFile()));*/

			try {
			      File myObj = new File("Produktuak.csv");
			      myObj.createNewFile();			      
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			try {
			      FileWriter writer = new FileWriter( filename);
			      writer.write("ID PRODUKTU ; DESKRIPZIOA \n");
			      
			      for(Produktua p: produktuak) {
			    	  writer.write(p.getIdProd() + ";" + p.getDeskripzioa() + ".\n");
			      }
			      
			      writer.close();
			      System.out.println("Successfully wrote to the file.");
			      
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }

			
			/*String l;
			for (Produktua p : produktuak) {
				outputStream.println(p.getIdProd() + "," + p.getDeskripzioa() + ".");
			}*/

			/*} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (outputStream != null) {
				outputStream.close();
				System.out.println("Datuak gorde dira " + filename +" fitxategian.");
			}
		}*/
	}
}
