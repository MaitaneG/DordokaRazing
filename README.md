# DordokaRazing

  ### Java datubase Konexio aplikazioa:
   #### Helburua:
   Aplikazio honek remotoan daukagun Odoo-ren datubasearekin (Postgres) konektatzen da.
      Ondoren Datubaseari dauden produktuen kontsulta egiten du, eta produktu bakoitzeko id-a, kantitatea, prezioa, mota eta izena hartzen dugu. Lortutako
      datu guztiak Excel fitxategi batera (.csv) exportatzen da.
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

  #### Klase diagrama:
 ![Klase diagrama svg formatuan](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/NewTel.svg)
 
 
 #### Iturriak:
  - [StackOverflow](https://stackoverflow.com/) 
  - [Baeldung (Spring Boot)](https://www.baeldung.com/)
  - [Youtube gidak](https://www.youtube.com/)
