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
		String sql = "select product_product.id , product_template.name as deskripzioa, product_template.list_price , stock_quant.quantity as kantitatea, product_category.name as kategoria\n"
				+ "from product_product inner join product_template on product_product.id = product_template.id inner join stock_quant on product_product.id = stock_quant.product_id inner join product_category on product_template.categ_id =product_category.id\n"
				+ "where stock_quant.location_id=8\n"
				+ "order by product_product.id asc;";

		try (//Connection conn = DriverManager.getConnection("jdbc:postgresql://25.32.59.79:5432/NewTel1", "openpg", "openpgpwd"); 
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gauzak", "openpg", "openpgpwd");
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
		String filename = "../NewTelApp/input/Produktuak.csv";

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
