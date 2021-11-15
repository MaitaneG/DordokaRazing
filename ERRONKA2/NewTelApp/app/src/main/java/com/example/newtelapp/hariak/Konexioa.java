package com.example.newtelapp.hariak;

import android.widget.Toast;

import com.example.newtelapp.model.Aurrekontua;
import com.example.newtelapp.model.AurrekontuaLerroa;
import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;
import com.example.newtelapp.view.AurrekontuakIkusi;

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
            Connection connection = null;
            connection = DriverManager.getConnection(url, username, password);
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
                            "res_partner.email as korreoa,res_partner.street as kalea,res_partner.city as hiria, " +
                            "res_partner.zip as kodigoPostala\n" +
                            "from  res_partner\n" +
                            "full join  res_country_state on res_partner.state_id = res_country_state.id\n" +
                            "full join res_country on res_partner.country_id = res_country.id\n" +
                            "where res_partner.customer_rank > 0" + // A ver si funciona
                            "order by res_partner.id asc\n");

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Select-an jaso den informazioa Bezeroa ArrayList batean gordetzen da **/
                    while (rs.next()) {
                        Bezeroa bezeroa = new Bezeroa(rs.getInt("id"), rs.getString("izenaAbizena"), rs.getBoolean("enpresa"), rs.getString("mugikorra"), rs.getString("korreoa"),
                                rs.getString("kalea"), rs.getString("hiria"), rs.getInt("kodigoPostala"));
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
                            "(\"name\", create_date, display_name, lang, tz, active, \"type\", street,zip, city, email, mobile, is_company, customer_rank, country_id)\n" +
                            "VALUES(?, CURRENT_DATE, ? , 'es_ES', 'Europe/Madrid',\n" +
                            "true,  'contact', ? , ? , ? ,\n" +
                            " ? , ? , ?, 1, 68);\n");
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
                    pstmt = conn.prepareStatement("select sale_order.id as id, sale_order.partner_id as bezeoaId, " +
                            "sale_order.name as izena, res_partner.name as bezeroaIzena, " +
                            "sale_order.date_order as data, sale_order.state as egoera, sale_order.amount_total as totala " +
                            "from  sale_order " +
                            "inner join res_partner on sale_order.partner_id= res_partner.id \n" +
                            "where sale_order.state = 'draft' order by sale_order.id asc\n");

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Select-an jaso den informazioa Aurrekontua ArrayList batean gordetzen da **/
                    while (rs.next()) {
                        Aurrekontua aurrekontua = new Aurrekontua(rs.getInt("id"), rs.getString("izena"), rs.getInt("bezeoaId"),
                                rs.getString("bezeroaIzena"), rs.getString("egoera"), rs.getFloat("totala"), rs.getDate("data"));
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
                    pstmt = conn.prepareStatement("SELECT sale_order_line.id as lerroa, sale_order_line.order_id as aurrekontua, " +
                            "sale_order_line.product_id as produktuId, sale_order_line.price_unit as prezioa, " +
                            "product_template.name as ProduktuIzena, sale_order_line.product_uom_qty as kantitatea, sale_order_line.price_total as totala\n" +
                            "FROM sale_order_line\n" +
                            "inner join product_template on sale_order_line.product_id = product_template.id\n" +
                            "where sale_order_line.state = 'draft';");

                    /** Sententzia exekutatzen da **/
                    ResultSet rs = pstmt.executeQuery();

                    /** Select-an jaso den informazioa Aurrekontua ArrayList batean gordetzen da **/
                    while (rs.next()) {
                        AurrekontuaLerroa aurrekontuaLerroa = new AurrekontuaLerroa(rs.getInt("lerroa"), rs.getInt("aurrekontua"),
                                rs.getInt("produktuId"), rs.getString("produktuIzena"), rs.getFloat("prezioa"),
                                rs.getFloat("kantitatea"), rs.getFloat("totala"));
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
                    pstmt = conn.prepareStatement("INSERT INTO sale_order(name, reference, date_order, user_id,partner_id, partner_invoice_id, " +
                            "partner_shipping_id, pricelist_id, company_id, picking_policy, warehouse_id, require_signature, require_payment, create_date, " +
                            "state, currency_id, invoice_status, note, amount_total, currency_rate, payment_term_id, create_uid, write_uid, write_date)\n" +
                            "VALUES (?, ?, CURRENT_DATE , 7, ?, ?, ?,'1','1','direct','1', true, false, CURRENT_DATE,'draft',1,'no', '', ?, 1, 1, 1, 1, CURRENT_DATE);\n");

                    pstmt.setString(1, aurrekontua.getIzena());
                    pstmt.setString(2, aurrekontua.getIzena());
                    pstmt.setInt(3, aurrekontua.getBezeroaId());
                    pstmt.setInt(4, aurrekontua.getBezeroaId());
                    pstmt.setInt(5, aurrekontua.getBezeroaId());
                    pstmt.setFloat(6, aurrekontua.getTotal());

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
    public void insertAurrekontuaLerroa(AurrekontuaLerroa aurrekontualerroa) {
        /**
         *
         * Hari bat sortzen da aurrekontuLerroaren insert bat egiteko
         */
        Thread insertAurrekontuaLerroa = new Thread(new Runnable() {
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

                    /** AurrekontuLerroen insert-a **/
                    pstmt = conn.prepareStatement("INSERT INTO sale_order_line (order_id, name, sequence, invoice_status, price_unit, discount, " +
                            "product_uom_qty, customer_lead, display_type, product_id, product_uom, price_total, state, qty_delivered_method, " +
                            "qty_delivered, qty_delivered_manual, qty_to_invoice, qty_invoiced, untaxed_amount_invoiced, untaxed_amount_to_invoice, " +
                            "salesman_id, currency_id, company_id, create_uid, write_uid)\n" +
                            "VALUES ((select max(id)from sale_order ), ?, 10, 'no', ?, 0, ?, 0, null, ?, 1, ?, 'draft', 'stock_move', 0, 0, 0, 0, 0, 0, 7, 1, 1, 7, 7);\n");

                    pstmt.setString(1, aurrekontualerroa.getIzenaProduktua());
                    pstmt.setFloat(2, aurrekontualerroa.getPrezioaProduktua());
                    pstmt.setFloat(3, aurrekontualerroa.getKantitatea());
                    pstmt.setInt(4, aurrekontualerroa.getIdProduktua());
                    pstmt.setFloat(5, aurrekontualerroa.getTotala());

                    /** Sententzia exekutatzen da **/
                    pstmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        insertAurrekontuaLerroa.start();
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
                    pstmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        deleteAurrekontuak.start();
    }

    /**
     * AurrekontuLerroak ezabatzeko metodoa
     */
    public void deleteAurrekontuaLerroa(AurrekontuaLerroa aurrekontualerroa) {
        /**
         *
         * Hari bat sortzen da aurrekontuLerroen delete bat egiteko
         */
        Thread deleteAurrekontuaLerroa = new Thread(new Runnable() {
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
                    pstmt = conn.prepareStatement("delete from sale_order_line  where id = ?\n");

                    pstmt.setInt(1, aurrekontualerroa.getIdLine());

                    /** Sententzia exekutatzen da **/
                    pstmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /** Haria exekutatzen da **/
        deleteAurrekontuaLerroa.start();
    }
}