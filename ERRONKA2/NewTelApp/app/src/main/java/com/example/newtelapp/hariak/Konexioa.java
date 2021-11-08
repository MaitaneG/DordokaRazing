package com.example.newtelapp.hariak;

import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.AurrekontuaLerroa;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Datu basearekin konektazen den haria
 */
public class Konexioa extends Thread {
    /**
     * Datu baseko informazioa
     */
    private final String url = "jdbc:postgresql://192.168.65.6:5432/NewTel1"; // Zerbitzariaren Postgres-eko url-a
    private final String username = "openpg"; // Datu baseko erabiltzailea
    private final String password = "openpgpwd"; // Datu baseko pasahitza

    /**
     * Konexioa lortzeko metodoa
     *
     * @return Zerbitzaren Postgres-eko datu basearekiko konexioa bueltatzen du
     */
    private Connection connect() {
        try {
            Class.forName("org.postgresql.Driver"); // Driver-a

            /** Konexioa lortzen du **/
            Connection connection =null;
            connection=DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Produktuak lortzeko metodoa
     *
     * @return Produktuen ArrayList-a
     */
    public ArrayList<Produktua> selectProduktuak() {
        ArrayList<Produktua> produktuakKatalogoa = new ArrayList<>(); // Produktuen ArrayList-a

        /**
         *
         * Hari bat sortzen da produktuen select bat egiteko
         */
        Thread selectProduktuak = new Thread(new Runnable() {
            /**
             *
             * Hariaren exekutagarria da
             */
            @Override
            public void run() {
                try {
                    /** Konexioa lortzeko connect metodoari deitzen dio **/
                    Connection conn = connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;

                    /** Produktuen select-a **/
                    pstmt = conn.prepareStatement("select product_product.id as id, product_template.name as izena, " +
                            "product_template.list_price as prezioa, stock_quant.quantity as kantitatea, " +
                            "product_category.name as kategoria\n" +
                            " from product_product " +
                            "inner join product_template on product_product.id = product_template.id " +
                            "inner join stock_quant on product_product.id = stock_quant.product_id " +
                            "inner join product_category on product_template.categ_id =product_category.id \n" +
                            "where stock_quant.location_id=8\n" + "order by product_product.id asc;");

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Select-an jaso den informazioa Produktuen ArrayList batean gordetzen da **/
                    while (rs.next()) {
                        Produktua produktua = new Produktua(/**ID**/rs.getInt("id"), /**Product name**/rs.getString("izena"),
                                /**Kategoria**/rs.getString("kategoria"), /**Prezioa**/rs.getFloat("prezioa"),
                                /**Kantitatea*/rs.getFloat("kantitatea"));
                        System.out.println();
                        produktuakKatalogoa.add(produktua);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        selectProduktuak.start();
        /** Produktuen ArrayList-a bueltatzen du **/
        return produktuakKatalogoa;
    }

    /**
     * Bezeroak lortzeko metodoa
     *
     * @return Bezeroen ArrayList-a
     */
    public ArrayList<Bezeroa> selectBezeroak() {
        ArrayList<Bezeroa> bezeroakLista = new ArrayList<>();

        /**
         *
         * Hari bat sortzen da bezeroen select bat egiteko
         */
        Thread selectBezeroak = new Thread(new Runnable() {
            /**
             *
             * Hariaren exekutagarria da
             */
            @Override
            public void run() {
                try {
                    /** Konexioa lortzeko connect metodoari deitzen dio **/
                    Connection conn = connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;

                    /** Bezeroen select-a **/
                    pstmt = conn.prepareStatement("select res_partner.id as id, res_partner.name  as izenaAbizena, " +
                            "res_partner.is_company as enpresa, res_partner.mobile as mugikorra,\n" +
                            "res_partner.email as korreoa,res_partner.street as kalea,res_partner.city as hiria," +
                            "res_partner.zip as kodigoPostala, res_country_state.name as probintzia,\n" +
                            "res_country.name as herrialdea from  res_partner\n" +
                            "inner join  res_country_state on res_partner.state_id = res_country_state.id\n" +
                            "inner join res_country on res_partner.country_id = res_country.id\n" +
                            "where res_partner.customer_rank !=0" + // A ver si funciona
                            "order by res_partner.id asc\n");

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Select-an jaso den informazioa Bezeroa ArrayList batean gordetzen da **/
                    while (rs.next()) {
                        Bezeroa bezeroa = new Bezeroa(rs.getString("izenaAbizena"), rs.getBoolean("enpresa"), rs.getString("mugikorra"), rs.getString("korreoa"),
                                rs.getString("kalea"), rs.getString("hiria"), rs.getString("probintzia"), rs.getInt("kodigoPostala"),
                                rs.getString("herrialdea"));
                        System.out.println();
                        bezeroakLista.add(bezeroa);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        selectBezeroak.start();
        /** Bezeroen ArrayList-a bueltatzen du **/
        return bezeroakLista;
    }

    /**
     * Bezeroak sortzeko metodoa
     */
    public void insertBezeroak(Bezeroa bezeroa) {

        /**
         *
         * Hari bat sortzen da bezeroen insert bat egiteko
         */
        Thread insertBezeroak = new Thread(new Runnable() {
            /**
             *
             * Hariaren exekutagarria da
             */
            @Override
            public void run() {
                try {
                    /** Konexioa lortzeko connect metodoari deitzen dio **/
                    Connection conn = connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;

                    /** Bezeroaren insert-a **/
                    pstmt = conn.prepareStatement("INSERT INTO res_partner\n" +
                            "(\"name\", create_date, display_name, lang, tz, active, \"type\", street,zip, city, email, mobile, is_company, customer_rank)\n" +
                            "VALUES(?, CURRENT_DATE, ? , 'es_ES', 'Europe/Madrid',\n" +
                            "true,  'contact', ? , ? , ? ,\n" +
                            " ? , ? , ?, 1);\n");
                    pstmt.setString(1, bezeroa.getIzenaAbizena());
                    pstmt.setString(2, bezeroa.getIzenaAbizena());
                    pstmt.setString(3, bezeroa.getKalea());
                    pstmt.setInt(4, bezeroa.getKodigoPostala());
                    pstmt.setString(5, bezeroa.getHiria());
                    pstmt.setString(6, bezeroa.getKorreoa());
                    pstmt.setString(7, bezeroa.getMugikorra());
                    pstmt.setBoolean(8, bezeroa.isEnpresa());

                    /** Sententzia exekutatzen da **/
                    pstmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        insertBezeroak.start();
        /** Bezeroen ArrayList-a bueltatzen du **/
    }

    /**
     * Aurrekontuak lortzeko metodoa
     *
     * @return Aurrekontuak ArrayList-a
     */
    public ArrayList<Aurrekontua> selectAurrekontuak() {
        ArrayList<Aurrekontua> aurrekontuakLista = new ArrayList<>();

        Thread selectAurrekontuak = new Thread(new Runnable() {
            /**
             *
             * Hariaren exekutagarria da
             */
            @Override
            public void run() {
                try {
                    /** Konexioa lortzeko connect metodoari deitzen dio **/
                    Connection conn = connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;

                    /** Aurrekontuen select-a **/
                    pstmt = conn.prepareStatement("select sale_order.id as id, sale_order.name as izena, res_partner.name as bezeroaIzena," +
                            "sale_order.date_order as data, sale_order.state as egoera " +
                            "from  sale_order " +
                            "inner join res_partner on sale_order.id = res_partner.id \n" +
                            "where sale_order.state = 'draft' order by sale_order.id asc\n");

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Select-an jaso den informazioa Aurrekontua ArrayList batean gordetzen da **/
                    while (rs.next()) {
                        Aurrekontua aurrekontua = new Aurrekontua(rs.getInt("id"), rs.getString("izena"),
                                rs.getString("bezeroaIzena"), rs.getString("egoera"), rs.getDate("data"));
                        System.out.println();
                        aurrekontuakLista.add(aurrekontua);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        selectAurrekontuak.start();
        /** Aurrekontuen ArrayList-a bueltatzen du **/
        return aurrekontuakLista;
    }

    /**
     * AurrekontuaLerroak lortzeko metodoa
     *
     * @return AurrekontuaLerroen ArrayList-a
     */
    public ArrayList<AurrekontuaLerroa> selectAurrekontuaLerroa() {
        ArrayList<AurrekontuaLerroa> aurrekontuaLerroaLista = new ArrayList<>();

        Thread selectAurrekontuaLerroa = new Thread(new Runnable() {
            /**
             *
             * Hariaren exekutagarria da
             */
            @Override
            public void run() {
                try {
                    /** Konexioa lortzeko connect metodoari deitzen dio **/
                    Connection conn = connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;

                    /** AurrekontuaLerroen select-a **/
                    pstmt = conn.prepareStatement("SELECT sale_order_line.id as lerroa, sale_order_line.order_id as aurrekontua, \n" +
                            "product_template.name as ProduktuIzena, sale_order_line.product_uom_qty as kantitatea\n" +
                            "FROM sale_order_line\n" +
                            "inner join product_template on sale_order_line.product_id = product_template.id\n" +
                            "where sale_order_line.state = 'draft';");

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Select-an jaso den informazioa Aurrekontua ArrayList batean gordetzen da **/
                    while (rs.next()) {
                        AurrekontuaLerroa aurrekontuaLerroa = new AurrekontuaLerroa(rs.getInt("lerroa"),rs.getInt("aurrekontua"),rs.getString("produktuIzena"),rs.getFloat("kantitatea"));
                        System.out.println();
                        aurrekontuaLerroaLista.add(aurrekontuaLerroa);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        selectAurrekontuaLerroa.start();
        /** Aurrekontuen ArrayList-a bueltatzen du **/
        return aurrekontuaLerroaLista;
    }


    // FALTA LA SENTENCIA SQL

    /**
     * Aurrekontuak sortzeko metodoa
     */
    public void insertAurrekontua(Aurrekontua aurrekontua) {
        /**
         *
         * Hari bat sortzen da aurrekontuen insert bat egiteko
         */
        Thread insertAurrekontua = new Thread(new Runnable() {
            /**
             *
             * Hariaren exekutagarria da
             */
            @Override
            public void run() {
                try {
                    /** Konexioa lortzeko connect metodoari deitzen dio **/
                    Connection conn = connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;

                    /** Aurrekontuen insert-a **/
                    /*pstmt = conn.prepareStatement("select res_partner.id as id, res_partner.name  as izenaAbizena, " +
                            "res_partner.company_name as enpresa, res_partner.mobile as mugikorra,\n" +
                            "res_partner.email as korreoa,res_partner.street as kalea,res_partner.city as hiria," +
                            "res_partner.zip as kodigoPostala, res_country_state.name as probintzia,\n" +
                            "res_country.name as herrialdea from  res_partner\n" +
                            "inner join  res_country_state on res_partner.state_id = res_country_state.id\n" +
                            "inner join res_country on res_partner.country_id = res_country.id\n" +
                            "order by res_partner.id asc\n");*/

                    pstmt.setInt(1, aurrekontua.getId());

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Sententzia exekutatzen da **/
                    pstmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        insertAurrekontua.start();
    }

    /**
     * Aurrekontuak sortzeko metodoa
     */
    public void deleteAurrekontua(Aurrekontua aurrekontua) {
        /**
         *
         * Hari bat sortzen da aurrekontuen insert bat egiteko
         */
        Thread deleteAurrekontuak = new Thread(new Runnable() {
            /**
             *
             * Hariaren exekutagarria da
             */
            @Override
            public void run() {
                try {
                    /** Konexioa lortzeko connect metodoari deitzen dio **/
                    Connection conn = connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;

                    /** Aurrekontuen insert-a **/
                    pstmt = conn.prepareStatement("delete from sale_order  where id = ?\n");

                    pstmt.setInt(1, aurrekontua.getId());

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        deleteAurrekontuak.start();
    }
}