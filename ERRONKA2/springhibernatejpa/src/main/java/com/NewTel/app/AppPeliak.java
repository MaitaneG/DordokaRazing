package com.NewTel.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.sampled.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
	public static SaleOrderLineDao saoLineDao;
	public static ApplicationContext appContext;
	public static ApplicationContext appContext2;

	public static List<ProductProduct> products;
	public static List<ResPartner> clients;
	public static List<SaleOrder> sales;
	public static List<SaleOrderLine> salesLines;

	public static boolean bExported=false;
	public static boolean pExported=false;
	public static boolean sExported=false;

	public static String path = "config.xml";

	public static void main(String[] args) {
		appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_Postgres.class);

		productDao = appContext.getBean(ProductProductDao.class);
		salesDao = appContext.getBean(SaleOrderDao.class);
		saoLineDao = appContext.getBean(SaleOrderLineDao.class);

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

			System.out.println(
					"\n\n\n\n\n\n\t\t XML SORTZAILEA:\n\tAukeratu zer exportatu nahi duzun(1,...):\n1-Bezeroak\n2-Produktuak\n3-Salmentak\n\n4-Eginda");
			while (!exit) {
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

				try {
					th.sleep(3000);
					//xmlSortu(aukerak);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (xmlSortu(aukerak)) { //= true

				System.out.println("Ezin izan da xml fitxategia sortu.");}
				else{
					//updateDB();
					openSound();
			}
				exit = true;

			}

		}

		// Hemen un AsyncTask?

	}

	public static boolean xmlSortu(List<String> aukerak) {

		boolean success = false;
		System.out.println("\n\n\n\n\tXML FITXATEGIA SORTZEN");
		if (aukerak.contains("bezeroak")) {
			clients = new ArrayList<ResPartner>();
		clients = resPartnerDao.getAll();}
		if (aukerak.contains("produktuak")){
			products = new ArrayList<ProductProduct>();
			products = productDao.getAll();}
		if (aukerak.contains("salmentak")){
			sales = new ArrayList<SaleOrder>();
			sales = salesDao.getAll();
			salesLines = new ArrayList<SaleOrderLine>();
			salesLines = saoLineDao.getAll();}
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

			Element battr = document.createElement("exported");
			if (clients!= null)
				battr.setTextContent("true");
			else
				battr.setTextContent("false");
			bezeroa.appendChild(battr);

			// produktua
			Element produktua = document.createElement("produktuak");
			root.appendChild(produktua);
			Element pattr = document.createElement("exported");

			if (products!= null)
				pattr.setTextContent("true");
			else
				pattr.setTextContent("false");
			produktua.appendChild(pattr);

			// salmentak
			Element salmenta = document.createElement("salmentak");
			root.appendChild(salmenta);
			Element sattr = document.createElement("exported");

			if (sales!= null)
				sattr.setTextContent("true");
			else
				sattr.setTextContent("false");
			salmenta.appendChild(sattr);

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
		SaleOrderLineDao saoLineDao;
		
		
		productDao = appContext2.getBean(ProductProductDao.class);
		
		salesDao = appContext2.getBean(SaleOrderDao.class);

		saoLineDao = appContext2.getBean(SaleOrderLineDao.class);

		resPartnerDao = appContext2.getBean(ResPartnerDao.class);

		try {
			if (clients!=null)
				for (ResPartner rp : clients)
					resPartnerDao.update(rp);
			if ( products!=null)					//!products.isEmpty() ||
				for (ProductProduct p : products)
					productDao.update(p);
			if ( sales!=null)						//!sales.isEmpty() ||
				for (SaleOrder s : sales)
					salesDao.update(s);
				for(SaleOrderLine s : salesLines)
					saoLineDao.update(s);

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
				"\n\n\n\n\n\n\t\tKAIXO!\n\n\tHiadanik badaukagu aurreko konfigurazioa gordeta\nErabiltzea nahi duzu(bai/ez)?");
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

				//updateDB();
				openSound();
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
	public static void openSound(){
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {

					File sound = new File("sounds/Gemidos.wav");//"sounds/Download_succeed.wav"
					AudioInputStream stream;
					AudioFormat format;
					DataLine.Info info;
					Clip clip;

					stream = AudioSystem.getAudioInputStream(sound);
					format = stream.getFormat();
					info = new DataLine.Info(Clip.class, format);
					clip = (Clip) AudioSystem.getLine(info);
					clip.open(stream);
					clip.start();

//			for(int x=0; x < 1000;){
//
//		}


				}
				catch (Exception e) {
					//whatevers
					e.printStackTrace();
				}
			}
		});

		try {
			th.start();//soinuaren haria hasi
			Thread.sleep(4000);//programa nagusia gelditu soinua erreproduzitzeko
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
