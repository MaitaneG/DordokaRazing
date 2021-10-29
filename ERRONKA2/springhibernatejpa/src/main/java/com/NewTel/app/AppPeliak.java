package com.NewTel.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eus.uni.dam.*;
import com.NewTel.Model.*;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"eus.uni.dam"})
@SpringBootApplication
public class AppPeliak {

	public static ProductProductDao productDao;
	public static SaleOrderDao salesDao;
	public static ResPartnerDao resPartnerDao;
	public static ApplicationContext appContext;
	public static ApplicationContext appContext2;

	public static List<ProductProduct> products;
	public static List<ResPartner> clients;
	public static List<SaleOrder> sales;

	public static boolean bExported=false;
	public static boolean pExported=false;
	public static boolean sExported=false;

	public static String path = "ruta xml";

	public static void main(String[] args) {
		appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_Postgres.class);

		productDao = appContext.getBean(ProductProductDao.class);
		salesDao = appContext.getBean(SaleOrderDao.class);
		resPartnerDao = appContext.getBean(ResPartnerDao.class);
		File file = new File(path);
		if (!file.exists())
			menuOsoaBistaratu();
		else
			menuaBistaratu();

		// ((AnnotationConfigApplicationContext) appContext).close();
		/**
		 * appContext = new
		 * AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_SqlServer.class);
		 * productDao = appContext.getBean(ProductProductDao.class); salesDao =
		 * appContext.getBean(SaleOrderDao.class); resPartnerDao =
		 * appContext.getBean(ResPartnerDao.class);
		 **/

	}

	public static void menuOsoaBistaratu() {
		int election;
		List<String> aukerak = new ArrayList<String>();
		boolean exit = false;
		Scanner sc = new Scanner(System.in);

		// Menua bistaratu
		while (!exit) {
			System.out.println(
					"\t\t XML SORTZAILEA:\n\tAukeratu zer exportatu nahi duzun(1,...):\n1-Bezeroak\n2-Produktuak\n3-Salmentak\n\n4-Eginda");
			election = sc.nextInt();

			switch (election) {
			case 1:
				System.out.println("Bezeroak aukeratu duzu.");
				aukerak.add("bezeroak");
				break;
			case 2:
				System.out.println("Produktuak aukeratu dituzu");
				aukerak.add("produktuak");
				break;
			case 3:
				System.out.println("Salmentak aukeratu dituzu");
				aukerak.add("salmentak");
				break;
			case 4:
				Thread th = new Thread("datuak gordetzen...");

				/*try {
					th.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				if (!xmlSortu(aukerak))
					System.out.println("Ezin izan da xml fitxategia sortu.");
				updateDB();
				exit = true;

			}

		}

		// Hemen un AsyncTask?

	}

	public static boolean xmlSortu(List<String> aukerak) {

		boolean success = false;
		System.out.println("\n\n\n\n\tXML FITXATEGIA SORTZEN");
		if (aukerak.contains("bezeroak"))
			clients = new ArrayList<ResPartner>();
			clients = resPartnerDao.getAll();
		if (aukerak.contains("produktuak"))
			products = new ArrayList<ProductProduct>();
			products = productDao.getAll();
		if (aukerak.contains("salmentak"))
			sales = new ArrayList<SaleOrder>();
			sales = salesDao.getAll();
		// xml sortzeko kodigoa:

		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

			Document document = (Document) documentBuilder.newDocument();

			// elemento raiz:
			Element root = document.createElement("CONFIGURATION");
			document.appendChild(root);

			// bezeroa
			Element bezeroa = document.createElement("bezeroak");
			root.appendChild(bezeroa);

			Element attr = document.createElement("exported");
			if (!clients.isEmpty() || clients!= null)
				attr.setTextContent("true");
			else
				attr.setTextContent("false");
			bezeroa.appendChild(attr);

			// produktua
			Element produktua = document.createElement("produktuak");
			root.appendChild(produktua);

			if (!products.isEmpty())
				attr.setTextContent("true");
			else
				attr.setTextContent("false");
			produktua.appendChild(attr);

			// salmentak
			Element salmenta = document.createElement("salmentak");
			root.appendChild(salmenta);

			if (!sales.isEmpty())
				attr.setTextContent("true");
			else
				attr.setTextContent("false");
			salmenta.appendChild(attr);

			// Create xml
			TransformerFactory transformers = TransformerFactory.newInstance();
			Transformer bambelbi = transformers.newTransformer();
			DOMSource doomSlayer = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(path));

			bambelbi.transform(doomSlayer, streamResult);
			System.out.println("\t\t FITXATEGIA SORTU DA " + path + " RUTAN");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			success = false;
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
			success = false;
		}

		return success;
	}
 // server? jdbc:sqlserver//DESKTOP-UJGJBG5\\sqlexpress;databaseName=NewTel
	//DESKTOP-UJGJBG5\admin USER
	public static boolean updateDB() {
		boolean success = true;
		((AnnotationConfigApplicationContext) appContext).close();

		appContext2 = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_SqlServer.class);
		ProductProductDao productDao;
		SaleOrderDao salesDao;
		ResPartnerDao resPartnerDao;
		
		
		productDao = appContext2.getBean(ProductProductDao.class);
		
		salesDao = appContext2.getBean(SaleOrderDao.class);
	
		resPartnerDao = appContext2.getBean(ResPartnerDao.class);

		try {
			if (clients!=null)
				for (ResPartner rp : clients)
					resPartnerDao.create(rp);
			if ( products!=null)					//!products.isEmpty() ||
				for (ProductProduct p : products)
					productDao.create(p);
			if ( sales!=null)						//!sales.isEmpty() ||
				for (SaleOrder s : sales)
					salesDao.create(s);

		} catch (Exception ex) {
			ex.printStackTrace();
			success = false;
		}
//jdbc:sqlserver//25.32.59.79\sqlexpress:1433;databaseName=NewTel
		((AnnotationConfigApplicationContext) appContext2).close();
		return success;
	}

	public static void menuaBistaratu() {
		irakurriXML();
		System.out.println(
				"\t\tKAIXO!\n\n\tHiadanik badaukagu aurreko konfigurazioa gordeta\nErabiltzea nahi duzu(bai/ez)?");
		Scanner sc = new Scanner(System.in);

		String aukera = sc.next().toLowerCase();
		if (aukera.equals("bai") || aukera.equals("b")) {
			// movida xml de configuracion

			try {
				if (bExported) {
					clients = new ArrayList<ResPartner>();
					clients = resPartnerDao.getAll();}
				if (pExported) {
					products = new ArrayList<ProductProduct>();
					products = productDao.getAll();}
				if (sExported) {
					sales = new ArrayList<SaleOrder>();
					sales = salesDao.getAll();}

				updateDB();
			} catch (Exception ex) {
				System.out.println("Errorea datubase prozesuan (menuaBistaratu)");
				ex.printStackTrace();
			}

		} else if (aukera.equals("ez") || aukera.equals("e")) {
			System.out.println("Ongi da, aurreko menua zabaltzen...");
		menuOsoaBistaratu();
		}

	}

	public static void irakurriXML() {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db;
		try {

			db = dbf.newDocumentBuilder();

			Document doc = db.parse(new File(path));

			doc.getDocumentElement().normalize();

			NodeList bezList = doc.getElementsByTagName("bezeroak");

			// bezero tag bat baino gehiago balego

			Node nodo = bezList.item(0);

			if (nodo.getNodeType() == Node.ELEMENT_NODE) {

				Element bezeroa = (Element) nodo;

				// get staff's attribute
				if(bezeroa.getFirstChild()!=null)
				bExported = Boolean.parseBoolean(bezeroa.getFirstChild().getTextContent());

			}
			NodeList prodList = doc.getElementsByTagName("produktuak");

			// bezero tag bat baino gehiago balego

			nodo = prodList.item(0);

			if (nodo.getNodeType() == Node.ELEMENT_NODE) {

				Element produktua = (Element) nodo;

				// get staff's attribute
				if(produktua.getFirstChild()!=null)
				pExported =  Boolean.parseBoolean(produktua.getFirstChild().getTextContent());

			}
			NodeList saleList = doc.getElementsByTagName("salmentak");

			// bezero tag bat baino gehiago balego

			nodo = saleList.item(0);

			if (nodo.getNodeType() == Node.ELEMENT_NODE) {

				Element salmenta = (Element) nodo;

				// get staff's attribute
				if(salmenta.getFirstChild()!=null)
				sExported =  Boolean.parseBoolean(salmenta.getFirstChild().getTextContent());

			}

		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			System.out.println("Ez Dakit zer gertatu den");
			e.printStackTrace();

		}

	}

}
