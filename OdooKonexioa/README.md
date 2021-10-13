# DordokaRazing

  ## *Java datubase Konexio aplikazioa:*
   ### Helburua:
   ##### Aplikazioa
   
 Aplikazio honek remotoan daukagun Odoo-ren datubasearekin (Postgres) konektatzen da.
      Ondoren Datubaseari dauden produktuen kontsulta egiten du, eta produktu bakoitzeko id-a, kantitatea, prezioa, mota eta izena hartzen dugu. Lortutako
      datu guztiak Excel fitxategi batera (.csv) exportatzen da.
     
        
         

      
  ##### Log-a  
  
   Aplikazioak fitxategia sortzen duenean, log  fitxategi bat sortzen du. Fitxategi honetan aplikazioa azkeneko aldiz      exekutatu zenuenekiko datuen konparaketa egiten ditu eta, datu-basean datuak gehitu badituzu zenbat eta zeintzuk diren esango dizu; berriz, zerbait ezabatzerakoan zer produktu ezabatu den esango dizu.
     ![Log fitxategi bat](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/log%20a.png)
      
      // Falta lo de log
   #### Abiaraztea:
   Programa abiarazteko mvn plugina instalatuta izan behar duzu zure Sistema Eragilean (Deskargatzeko eta gida esteka):
          ``` 
         https://maven.apache.org/download.cgi
          ```
          
   Ondoren Lanzador odoo aplikazioa exekutatu behar da eta orduan background ean cmd konsola bad agertuko da spring Boot aplikazioa exekutatzen hari dela esaten. Aplikazioa batch fitxategi batek exekutatzen du ``` mvn spring-boot:run ```
   komandoa sartuta. 
   
   Erroren bat egongo balitz Odo jaurtitzailearen karpetan "Error_log.txt" fitxategia egongo da non errorea azalduko du.
   
   Aplikazioa exekutatu ostean, Excel fitxategia android proiektuko assets karpetan sortuko da eta log fitxategia proiektuaren logs karpetan egondo da
   ![Aplikazioa CMDan exekutatzerakoan](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/cmd.png)
  #### Klase diagrama:
  Gure aplikazioa osatzen dituzten klase eta interfaz desberdinen diagrama:
 ![Klase diagrama svg formatuan](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/NewTel.svg)
 
 
 #### Iturriak:
  - [StackOverflow](https://stackoverflow.com/) 
  - [Baeldung (Spring Boot)](https://www.baeldung.com/)
  - [Youtube gidak](https://www.youtube.com/)
