# DordokaRazing

  ## *Java datubase Konexio aplikazioa:*
   ### Helburua
   ##### - Aplikazioa
   
 Aplikazio honek remotoan daukagun [Odoo-ren](https://www.odoo.com/es_ES) datubasearekin [(Postgres)](https://www.postgresql.org/) konektatzen da.
      Ondoren Datubaseari dauden produktuen kontsulta egiten du, eta produktu bakoitzeko id-a, kantitatea, prezioa, mota eta izena hartzen dugu. Lortutako
      datu guztiak Excel fitxategi batera [(.csv)](https://help.cliengo.com/hc/es/articles/360020203574-C%C3%B3mo-abrir-un-archivo-CSV-en-Excel) exportatzen da.
     
        
         

      
  ##### - Log-a  
  
   Aplikazioak fitxategia sortzen duenean, log  fitxategi bat sortzen du. Fitxategi honetan aplikazioa azkeneko aldiz      exekutatu zenuenekiko datuen konparaketa egiten ditu eta, datu-basean datuak gehitu badituzu zenbat eta zeintzuk diren esango dizu; berriz, zerbait ezabatzerakoan zer produktu ezabatu den esango dizu.
   
   ![Log fitxategi bat](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/log%20a.png)

   ### Abiaraztea:
   Programa abiarazteko mvn plugina instalatuta izan behar duzu zure Sistema Eragilean (Deskargatzeko eta gida esteka):
          ``` 
         https://maven.apache.org/download.cgi
          ```
          
   Ondoren Lanzador odoo aplikazioa exekutatu behar da eta orduan [BATCH](https://github.com/MaitaneG/DordokaRazing/blob/b9a74022d098ea03c032af294de1fac2ab6876be/OdooKonexioa/ejecutador.bat#L1-L6) fitxategi bat exekutatzen du. Fitxategi honek dgoen karpetatik OdooKonexioko proiektuko karpetara mugituko da eta background-ean cmd konsola bat erabilita spring Boot aplikazioa exekutatzeko behar den komandoa sartuko du ``` mvn spring-boot:run ``` 
   
   Erroren bat egongo balitz Odo jaurtitzailearen karpetan "Error_log.txt" fitxategia egongo da non errorea azalduko du.
   
   Aplikazioa exekutatu ostean, Excel fitxategia android proiektuko assets karpetan sortuko da eta log fitxategia proiektuaren logs karpetan egondo da.
   
   ![Aplikazioa CMDan exekutatzerakoan](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/cmd.png)
  ### Klase diagrama:
  Gure aplikazioa osatzen dituzten klase eta interfaz desberdinen diagrama:
  
 ![Klase diagrama svg formatuan](https://github.com/agerKalboetxeaga/datu-atzipena2021/blob/main/NewTel.svg)
 
 
 ### Iturriak:
  - [StackOverflow](https://stackoverflow.com/) 
  - [Baeldung (Spring Boot)](https://www.baeldung.com/)
  - [Youtube gidak](https://www.youtube.com/)
