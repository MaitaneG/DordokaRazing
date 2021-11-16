package com.NewTel.app;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import javax.sound.sampled.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.NewTel.song.Festi;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eus.uni.dam.*;
import com.NewTel.dao.*;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"eus.uni.dam"})
@SpringBootApplication
public class AppNewTel {
    //Aldagaien deklarazioa

    public static ProductProductDao productDao;     //Dao-ak eta application context- ak
    public static SaleOrderDao salesDao;
    public static ResPartnerDao resPartnerDao;
    public static SaleOrderLineDao saoLineDao;
    public static PurchaseOrderDao purchaseOrderDao;
    public static PurchaseOrderLineDao purchaseOrderLineDao;

    private static RunHelper runHelper;
    public static ApplicationContext appContext;
    public static ApplicationContext appContext2;
    //ArrayListak
    public static List<ProductProduct> products;
    public static List<ResPartner> clients;
    public static List<SaleOrder> sales;
    public static List<SaleOrderLine> salesLines;
    public static List<PurchaseOrder> purchases;
    public static List<PurchaseOrderLine> purchasesLines;

    //Booleano batzuk
    public static boolean bExported = false;
    public static boolean pExported = false;
    public static boolean puExported = false;
    public static boolean sExported = false;
    //xml-en  rutak
    public static String path = "config.xml";
    public static String logPath = "logs/log.xml";

    public static Festi song = new Festi();         //Abestiaren klasea

    public static Semaphore s = new Semaphore(1); //Semaforoa sarrera baterekin









    public static void main(String[] args) {

        song.setPriority(Thread.MAX_PRIORITY);      //Abestiaren hariari prioritate handiena emango diogu, horrela
        // programa nagusia baino garrantzitsuagoa izango da eta hasieratik entzungo da
        song.start();

        appContext = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_Postgres.class);  //kontextua eta postgres daoak abiarazi
       //
        runHelper = appContext.getBean(RunHelper.class);
        purchaseOrderDao = appContext.getBean(PurchaseOrderDao.class);
        purchaseOrderLineDao = appContext.getBean(PurchaseOrderLineDao.class);
        productDao = appContext.getBean(ProductProductDao.class);
        salesDao = appContext.getBean(SaleOrderDao.class);
        saoLineDao = appContext.getBean(SaleOrderLineDao.class);

        resPartnerDao = appContext.getBean(ResPartnerDao.class);
        runMain(args);










//        File file = new File(path);  // Konfigurazio xml a
//
//        if (!file.exists()) {        //ea XML konfigurazio Fitxategia existitzen den konprobatzen du
//            runMain(args);
//        } else {
//            menuaBistaratu();
//        }

    }

    /***
     * Menua lehen aldiz bistaratzen duzunean erabiltzen den menua //deprecated
     */
    public static void menuOsoaBistaratu() {
        int election;
        List<String> aukerak = new ArrayList<String>();     //erabiltzaileak aukeratuko dituen objetuak esportatzeko
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        // Menua bistaratu

        System.out.println(
                "\n\n\n\n\n\n\t\t XML SORTZAILEA:\n\tAukeratu zer exportatu nahi duzun(1,...):\n1-Bezeroak\n2-Produktuak\n3-Salmentak\n\n4-Eginda");
        while (!exit) {
            election = sc.nextInt();                    //Erabiltzaileraren inputa

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
                    System.out.println("Erosketak aukeratu dituzu");
                    aukerak.add("erosketak");
                case 5:
                    Thread th = new Thread("datuak gordetzen...");
//                    if (!song.isAlive()) {                                  //Aukeraketa amaitzean abestia martxan ez badago
//                        song.run();                                         //martxan jartzen du
//                    }
                    try {
                        th.sleep(2000);

                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    if (!xmlSortu(aukerak)) {                            // xml metodoak ezin izan badu xmla sortu:

                        System.out.println("Ezin izan da xml fitxategia sortu.");
                    } else {                                            // bestela:

                        updateDB();
                        logMaker();
                        openSound(1);
                    }
                    exit = true;                                        //Amaiera

            }

        }

        // Hemen un AsyncTask?

    }



    /**
     * Metodo honek xml konfigurazio fitxategia sortzen du
     *
     * @param aukerak Erabiltzaileak aukeratu dituen aukerak
     * @return Fitxategia sortu da eta ez da arazorik egon
     */
    public static boolean xmlSortu(List<String> aukerak) {

        boolean success = false;

        /**
         * Hemen, aukerak analizatzen du ea zer aukera aukeratu diren
         * Aukeratuta badago objetu horren arraylist a dagokion dao-a erabiliz betetzen da.
         */
        System.out.println("\n\n\n\n\tXML FITXATEGIA SORTZEN");
        Thread bezSelect = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    s.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (aukerak.contains("bezeroak")) {
                    clients = new ArrayList<ResPartner>();
                    clients = resPartnerDao.getAll(); //Hibernate jpa

                }
                s.release();
            }
        });
        Thread prodSelect = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (aukerak.contains("produktuak")) {
                    products = new ArrayList<ProductProduct>();
                    products = productDao.getAll();
                }
                s.release();
            }
        });
        Thread saleSelect = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (aukerak.contains("salmentak")) {
                    sales = new ArrayList<SaleOrder>();
                    sales = salesDao.getAll();
                    salesLines = new ArrayList<SaleOrderLine>();
                    salesLines = saoLineDao.getAll();
                }
                s.release();
            }
        });
        Thread purchaseSelect = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (aukerak.contains("erosketak")){
                    purchases = new ArrayList<PurchaseOrder>();
                    purchases = purchaseOrderDao.getAll();
                    purchasesLines = new ArrayList<PurchaseOrderLine>();
                    purchasesLines = purchaseOrderLineDao.getAll();
                }
                s.release();
            }
        });
        try {
            bezSelect.start();
            bezSelect.join();

            prodSelect.start();
            prodSelect.join();

            saleSelect.start();
            saleSelect.join();

            purchaseSelect.start();
            purchaseSelect.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // xml sortzeko kodigoa:

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = (Document) documentBuilder.newDocument();       //Dokumentu berri bat sortzen da.

            // elemento nagusia:
            Element root = document.createElement("CONFIGURATION");
            document.appendChild(root);

            // bezeroa
            Element bezeroa = document.createElement("bezeroak");
            root.appendChild(bezeroa);

            /**
             * ea exportatu dugun begiratzen du arraylist a konprobatuz:
             */
            Element battr = document.createElement("exported");
            if (clients != null)
                battr.setTextContent("true");
            else
                battr.setTextContent("false");
            bezeroa.appendChild(battr);

            // produktua
            Element produktua = document.createElement("produktuak");
            root.appendChild(produktua);
            Element pattr = document.createElement("exported");

            if (products != null)
                pattr.setTextContent("true");
            else
                pattr.setTextContent("false");
            produktua.appendChild(pattr);

            // salmentak
            Element salmenta = document.createElement("salmentak");
            root.appendChild(salmenta);
            Element sattr = document.createElement("exported");

            if (sales != null)
                sattr.setTextContent("true");
            else
                sattr.setTextContent("false");
            salmenta.appendChild(sattr);

            // erosketak
            Element erosketak = document.createElement("erosketak");
            root.appendChild(erosketak);
            Element eattr = document.createElement("exported");

            if(purchases != null)
                eattr.setTextContent("true");
            else
                eattr.setTextContent("false");

            erosketak.appendChild(eattr);

            // Create xml
            TransformerFactory transformers = TransformerFactory.newInstance();
            Transformer bambelbi = transformers.newTransformer();
            DOMSource doomSlayer = new DOMSource(document);                 //-> xmlan idatziko diren datuaj
            StreamResult streamResult = new StreamResult(new File(path)); //Ondorioa (xml fitxategia) stream baten bidez
            // aukeratutako rutan idazten da.
            bambelbi.transform(doomSlayer, streamResult);
            System.out.println("\t\t FITXATEGIA SORTU DA " + path + " RUTAN");
            success = true;

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
            success = false;
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
            success = false;
        }

        return success;
    }

    /**
     * Metodo honek aukeratutako aukerak MS Sql Serverrera igotzen dira.
     *
     * @return Atazak arrakasta izan badu:
     */
    public static boolean updateDB() {
        boolean success = true;
        /**
         * Postgresentzat erabiltzen dugun ApplicationContexta ixten dugu errekurtsoak berreskuratzeko
         * eta beste aplication context bat zabaltzen dugu MS sql serverrera konekxioa egoteko
         */
        ((AnnotationConfigApplicationContext) appContext).close();

        appContext2 = new AnnotationConfigApplicationContext(DatuBasearenKonfigurazioa_SqlServer.class);
        ProductProductDao productDao;
        SaleOrderDao salesDao;
        ResPartnerDao resPartnerDao;
        SaleOrderLineDao saoLineDao;
        PurchaseOrderDao purchaseOrderDao;
        PurchaseOrderLineDao purchaseOrderLineDao;


        productDao = appContext2.getBean(ProductProductDao.class);

        salesDao = appContext2.getBean(SaleOrderDao.class);

        saoLineDao = appContext2.getBean(SaleOrderLineDao.class);

        resPartnerDao = appContext2.getBean(ResPartnerDao.class);

        purchaseOrderDao = appContext2.getBean(PurchaseOrderDao.class);

        purchaseOrderLineDao = appContext2.getBean(PurchaseOrderLineDao.class);
                                                            //update bakoitzean semaforoaren bidez updateak ordenatuta joango dira
        try {
            Thread partnerUpdate = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (clients != null) {                //Exportatzeko zer dagoen begiratzen du
                        for (ResPartner rp : clients)
                            // if( rp.getCustomerRank()!=null) if( rp.getCustomerRank()!=0)
                            resPartnerDao.update(rp);
                    }
                    s.release();
                }
            });


            Thread prodUpdate = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (products != null) {
                        for (ProductProduct p : products)
                            productDao.update(p);
                    }
                    s.release();
                }
            });


            Thread salesUpdate= new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        s.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (sales != null) {
                        for (SaleOrder s : sales)
                            salesDao.update(s);
                        for (SaleOrderLine s : salesLines)
                            saoLineDao.update(s);
                    }
                    s.release();
                }
            });



            Thread purchaseUpdate = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(purchases != null){
                        for (PurchaseOrder p : purchases)
                            purchaseOrderDao.update(p);
                        for (PurchaseOrderLine p : purchasesLines)
                            purchaseOrderLineDao.update(p);
                    }
                    s.release();
                }
            });


            partnerUpdate.start();
            partnerUpdate.join();                                   //Haria hasi eta itxaron amaitu harte

            prodUpdate.start();
            prodUpdate.join();

            salesUpdate.start();
            salesUpdate.join();

            purchaseUpdate.start();
            purchaseUpdate.join();

        } catch (Exception ex) {
            ex.printStackTrace();
            success = false;
        }

        ((AnnotationConfigApplicationContext) appContext2).close(); //MS sql serverreako erabili dugun aplikazioaren
        // kontextua ixten dugu
        return success;
    }

    /**
     * Aplikazioa lehenago exekutatu bada menu hau bistaratuko da //deprecated
     */
    public static void menuaBistaratu() {
        irakurriXML();                          //Xml fitxategia irakurriko du
        System.out.println(
                "\n\n\n\n\n\n\t\tKAIXO!\n\n\tHiadanik badaukagu aurreko konfigurazioa gordeta\nErabiltzea nahi duzu(bai/ez)?");
        Scanner sc = new Scanner(System.in);

        String aukera = sc.next().toLowerCase();    //Erabiltzailearen input -a
        if (aukera.equals("bai") || aukera.equals("b")) {
            // movida xml de configuracion
//            if (!song.isAlive()) {                  //Abestia amaitu bada berriz hasi.
//                song.run();
//            }
            try {
                if (bExported) {                            //Ea zer objetu exportatu diren begiratzen du.
                    clients = new ArrayList<ResPartner>();
                    clients = resPartnerDao.getAll();
                }
                if (pExported) {
                    products = new ArrayList<ProductProduct>();
                    products = productDao.getAll();
                }
                if (sExported) {
                    sales = new ArrayList<SaleOrder>();
                    sales = salesDao.getAll();
                    salesLines = new ArrayList<SaleOrderLine>();
                    salesLines = saoLineDao.getAll();
                }if(puExported) {
                    purchases = new ArrayList<PurchaseOrder>();
                    purchases = purchaseOrderDao.getAll();
                    purchasesLines = new ArrayList<PurchaseOrderLine>();
                    purchasesLines = purchaseOrderLineDao.getAll();
                }
                updateDB();                             //Aurreko menuan bezala
                logMaker();
                openSound(1);
            } catch (Exception ex) {
                System.out.println("Errorea datubase prozesuan (menuaBistaratu)");
                ex.printStackTrace();
            }

        } else if (aukera.equals("ez") || aukera.equals("e")) {     //Erabiltzaileak beste konfigurazio bat erabili nahi badu
            System.out.println("Ongi da, aurreko menua zabaltzen...");
            menuOsoaBistaratu();
        }

    }

    /**
     * Metodo honek ihadanik sortutako konfigurazio xml -a irakurtzen du
     */
    public static void irakurriXML() {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db;
        try {

            db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(path));        //sortutako dokumentua atxikitzen diogu

            doc.getDocumentElement().normalize();

            NodeList bezList = doc.getElementsByTagName("bezeroak");    //Objetu desberdinak bilatzen ditugu xmlan zehar
            // bezero tag edo elementu bat baino gehiago balego

            Node nodo = bezList.item(0);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                Element bezeroa = (Element) nodo;

                // get staff's attribute
                if (bezeroa.getFirstChild() != null)        //booleanoei ea exportatuta dauden jartzen diogu informazioa
                                                            //zuzenean dokumentutik hartuta
                    bExported = Boolean.parseBoolean(bezeroa.getFirstChild().getTextContent());

            }
            NodeList prodList = doc.getElementsByTagName("produktuak");

            // bezero tag bat baino gehiago balego

            nodo = prodList.item(0);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                Element produktua = (Element) nodo;

                // get staff's attribute
                if (produktua.getFirstChild() != null)
                    pExported = Boolean.parseBoolean(produktua.getFirstChild().getTextContent());

            }
            NodeList saleList = doc.getElementsByTagName("salmentak");

            // bezero tag bat baino gehiago balego

            nodo = saleList.item(0);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                Element salmenta = (Element) nodo;

                // get staff's attribute
                if (salmenta.getFirstChild() != null)
                    sExported = Boolean.parseBoolean(salmenta.getFirstChild().getTextContent());

            }
            NodeList purchaseList = doc.getElementsByTagName("purchases");

            // bezero tag bat baino gehiago balego

            nodo = saleList.item(0);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {

                Element erosketa = (Element) nodo;

                // get staff's attribute
                if (erosketa.getFirstChild() != null)
                    puExported = Boolean.parseBoolean(erosketa.getFirstChild().getTextContent());

            }

        } catch (SAXException | IOException | ParserConfigurationException e) {
            // TODO Auto-generated catch block
            System.out.println("Ez Dakit zer gertatu den");
            e.printStackTrace();

        }

    }

    /**
     * Metodo honek soinu bat abiarazten du hari moduan
     */
    public static void openSound(int soundType) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File sound= null;
                    if(soundType == 1) {
                      sound  = new File("sounds/Download_succeed.wav");
                    }else if(soundType == 2){                                       //fitxategia asignatu
                        sound = new File("sounds/Gemidos.wav");

                    }
                    AudioInputStream stream;                                        //Audio motako stream bat sortu
                    AudioFormat format;                                             //Formatua ezartzeko (wav)
                    DataLine.Info info;                                             //Clip klaseak behar duen soinuaren konfigurazio informazioa
                    Clip clip;                                                      // wav fitxategia kudeatzeko klasea

                    stream = AudioSystem.getAudioInputStream(sound);
                    format = stream.getFormat();
                    info = new DataLine.Info(Clip.class, format);
                    clip = (Clip) AudioSystem.getLine(info);
                    clip.open(stream);
                    clip.start();
                    System.out.println("PROGRAM FINISHED");
                    Thread.sleep(200);


                } catch (Exception e) {
                    //whatevers
                    e.printStackTrace();
                }
            }
        });

        try {
            th.start();                               //soinuaren haria hasi
            Thread.sleep(4000);                 //programa nagusia gelditu soinua erreproduzitzeko 3000 para el otro sonido
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo honek log fitxategi bat sortzen du xml formatuan
     */
    public static void logMaker() {

        File log = new File(logPath);   //Fitxategi objetu bat fitxategia egongo den lekuan
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = null;

            documentBuilder = documentFactory.newDocumentBuilder();

            if (!log.exists()) { //Log -a lehenago sortuta ez badago

                Document document = (Document) documentBuilder.newDocument(); //Dokumentu berri bat sortzen da lehenago ezarritako rutan
                Element root = document.createElement("LOG");
                document.appendChild(root);
                Element logtxt = document.createElement("Exportazioa");
                LocalDateTime date = LocalDateTime.now();
                String txt = date.toString() + ", ";
                if (clients != null) {
                    txt = txt + clients.size() + " clients were exported ";
                }
                if (products != null) {
                    txt = txt + products.size() + " products were exported ";
                }
                if (purchases != null){
                    txt = txt + purchases.size() + " purchases were exported ";
                }
                if (sales != null) {
                    txt = txt + sales.size() + " sales were exported";
                }
                if (clients == null && products == null && sales == null) {
                    txt = txt + "I dont know you haven´t exported anything";
                }

                logtxt.setTextContent(txt);
                root.appendChild(logtxt);

                TransformerFactory transformers = TransformerFactory.newInstance(); //Lehenago bezela xml fitxategia sortzen da
                Transformer bambelbi = transformers.newTransformer();
                DOMSource doomSlayer = new DOMSource(document);
                StreamResult streamResult = new StreamResult(log);
                bambelbi.transform(doomSlayer, streamResult);

            } else {
                /**
                 * Fitxategia sortuta badago
                 */
                Document document = documentBuilder.parse(log); //ihadanik sortuta dagoen xml fitxategia erabiltzen da
                Element root = document.getDocumentElement();
                Element rootElement = document.getDocumentElement();

                Element logtxt = document.createElement("Exportazioa");
                LocalDate date = LocalDate.now();
                String txt = date.toString() + ", ";
                if (clients != null) {
                    txt = txt + clients.size() + " clients were exported ";
                }
                if (products != null) {
                    txt = txt + products.size() + " products were exported ";
                }
                if (sales != null) {
                    txt = txt + sales.size() + " sales were exported";
                }
                if (clients == null && products == null && sales == null) {
                    txt = txt + "I dont know you haven´t exported anything";
                }
                logtxt.setTextContent(txt);
                rootElement.appendChild(logtxt);

                root.appendChild(logtxt);

                DOMSource source = new DOMSource(document);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                StreamResult result = new StreamResult(log);
                transformer.transform(source, result);  //Lehenago zegoen fitxategiari log -aren informazioa gehitzen dio

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * Programa exekutatzerakoan erabiltzaileak sartutako inputa kudeatzen duen metodoa
     * @param args user provided arguments
     */
    private static void runMain(String[] args){
        List<String> argumentos = Arrays.asList(args);
        //runHelper = new RunHelper();
//        if (args.length < 1) {
//            System.out.println("Syntax error, type -h or -help for help");
//            runHelper.getHelper();
//        }
                List<String> aukerak = new ArrayList<>();
                if (args.length == 1){
                switch(args[0].toLowerCase()){
                    case "-h" :
                    case "-help":
                        System.out.println(runHelper.getHelper());

                        System.exit(-1);
                        break;
                    case "-b":
                        clients = resPartnerDao.getAll();
                        aukerak.add("bezeroak");

                        break;
                    case "-p":
                        products = productDao.getAll();
                        aukerak.add("produktuak");
                        break;
                    case "-s":
                        sales = salesDao.getAll();
                        salesLines = saoLineDao.getAll();
                        aukerak.add("salmentak");

                        break;
                    case "-e":
                        purchases = purchaseOrderDao.getAll();
                        purchasesLines = purchaseOrderLineDao.getAll();
                        aukerak.add("erosketak");
                        break;
                    case "-a":
                        clients = resPartnerDao.getAll();
                        products = productDao.getAll();
                        sales = salesDao.getAll();
                        salesLines = saoLineDao.getAll();
                        purchases = purchaseOrderDao.getAll();
                        purchasesLines = purchaseOrderLineDao.getAll();
                        aukerak.add("bezeroak");
                        aukerak.add("produktuak");
                        aukerak.add("salmentak");
                        aukerak.add("erosketak");

                        break;
                    case "-sapo":
                        System.out.println("\n\n\n\n\n\n\n\nJaja pringauu");
                        openSound(2);
                        System.exit(-1);
                        break;
                    default:
                        System.out.println("Syntax error");
                        System.out.println(runHelper.getHelper());
                        System.exit(-1);
                        break;
            }
            xmlSortu(aukerak);
            updateDB();
            logMaker();
            openSound(1);

//            }else if(args.length % 2 != 0){
//            System.out.println("Syntax error");
//            System.out.println(runHelper.getHelper());

        }else if(!argumentos.contains("sapo") && args.length > 3 ){
            System.out.println("Syntax error");
            System.out.println(runHelper.getHelper());
            System.exit(-1);
        }else if(args.length == 0){
            File file = new File(path);
            if(file.exists()){
                Scanner sc = new Scanner(System.in);
                System.out.println("Konfigurazioa gordeta daukagu erabiltzea nahi duzu?\n\t\t(b/e)");
                String election = sc.next();
                if(election.equals("b")){
                    try {
                        if (bExported) {                            //Ea zer objetu exportatu diren begiratzen du.
                            clients = new ArrayList<ResPartner>();
                            clients = resPartnerDao.getAll();
                        }
                        if (pExported) {
                            products = new ArrayList<ProductProduct>();
                            products = productDao.getAll();
                        }
                        if (sExported) {
                            sales = new ArrayList<SaleOrder>();
                            sales = salesDao.getAll();
                            salesLines = new ArrayList<SaleOrderLine>();
                            salesLines = saoLineDao.getAll();
                        }
                        if (puExported){
                            purchases = new ArrayList<PurchaseOrder>();
                            purchases = purchaseOrderDao.getAll();
                            purchasesLines = new ArrayList<PurchaseOrderLine>();
                            purchasesLines = purchaseOrderLineDao.getAll();
                        }
                        updateDB();                             //Aurreko menuan bezala
                        logMaker();
                        openSound(1);
                    } catch (Exception ex) {
                        System.out.println("Errorea datubase prozesuan (menuaBistaratu)");
                        ex.printStackTrace();
                    }
                }else{
                    System.out.println("Ongi da");
                    file.delete();
                    System.exit(-1);
                }

            }else{
                System.out.println("Errorea, ez duzu konfigurazio fitxategirik");
            }
        }
        else{
            List<String[]> arguments = new ArrayList<String[]>();

            for(String arg: args){
                switch (arg.toLowerCase()){
                    case "-h" :
                    case "-help":
                        System.out.println(runHelper.getHelper());
                        System.exit(-1);
                        break;
                    case "-b":
                        clients = resPartnerDao.getAll();

                        break;
                    case "-p":
                        products = productDao.getAll();

                        break;
                    case "-s":
                        sales = salesDao.getAll();
                        salesLines = saoLineDao.getAll();

                        break;
                    case "-e":
                        purchases = purchaseOrderDao.getAll();
                        purchasesLines = purchaseOrderLineDao.getAll();
                        break;

                    case "-a":
                        clients = resPartnerDao.getAll();
                        products = productDao.getAll();
                        sales = salesDao.getAll();
                        salesLines = saoLineDao.getAll();
                        purchases = purchaseOrderDao.getAll();
                        purchasesLines = purchaseOrderLineDao.getAll();

                        break;
                    case "-sapo":
                        System.out.println("\n\n\n\n\n\n\n\nJaja pringauu");
                        System.exit(-1);
                    default:
                        System.out.println("Syntax error");
                        System.out.println(runHelper.getHelper());
                        System.exit(-1);
                        break;

                }
            }
            updateDB();
            logMaker();
            openSound(1);
        }


    }

}
