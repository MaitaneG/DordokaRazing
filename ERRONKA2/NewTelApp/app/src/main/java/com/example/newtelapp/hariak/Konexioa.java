package com.example.newtelapp.hariak;

import com.example.newtelapp.model.Bezeroa;
import com.example.newtelapp.model.Produktua;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Konexioa extends Thread {
    private final String url = "jdbc:postgresql://25.32.59.79:5432/NewTel1"; // Postgres-eko url-a
    private final String username = "openpg"; // Datu baseko erabiltzailea
    private final String password = "openpgpwd"; // Datu baseko pasahitza

    private Connection connect() {
        try {
            Class.forName("org.postgresql.Driver");

            Connection connection=DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Produktua> selectProduktuak() {
        ArrayList<Produktua> produktuakKatalogoa=new ArrayList<>();

        Thread selectProduktuak = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Connection conn=connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;


                    pstmt = conn.prepareStatement("select product_product.id , product_template.name as deskripzioa, product_template.list_price , stock_quant.quantity as kantitatea, product_category.name as kategoria\n" +
                            " from product_product inner join product_template on product_product.id = product_template.id inner join stock_quant on product_product.id = stock_quant.product_id inner join product_category on product_template.categ_id =product_category.id\n" +
                            " where stock_quant.location_id=8\n" + "order by product_product.id asc;");

                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        Produktua produktua = new Produktua(/*ID*/rs.getInt(1), /*Product name*/rs.getString(2), /*Kategoria*/rs.getString(5), /*Prezioa*/ rs.getFloat(3), /*Kantitatea*/rs.getFloat(4));
                        System.out.println();
                        produktuakKatalogoa.add(produktua);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        selectProduktuak.start();
        return produktuakKatalogoa;
    }

    public ArrayList<Bezeroa> selectBezeroak() {
        ArrayList<Bezeroa> bezeroakLista=new ArrayList<>();

        Thread selectBezeroak = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Connection conn=connect();
                    Class.forName("org.postgresql.Driver");
                    PreparedStatement pstmt = null;


                    pstmt = conn.prepareStatement("select res_partner.id , res_partner.name  as izenaAbizena, res_partner.company_name as enpresa, res_partner.phone_sanitized as mugikorra,\n" +
                            "res_partner.email as korreoa,res_partner.street as kalea,res_partner.city as hiria,res_partner.zip as kodigoPostala ,res_country_state.name as probintzia,\n" +
                            "res_country.name as herrialdea from  res_partner\n" +
                            "inner join  res_country_state on res_partner.state_id = res_country_state.id\n" +
                            "inner join res_country on res_partner.country_id = res_country.id\n" +
                            "order by res_partner.id asc\n");

                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next()){
                        Bezeroa bezeroa= new Bezeroa(rs.getString(1),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
                        System.out.println();
                        bezeroakLista.add(bezeroa);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        selectBezeroak.start();
        return bezeroakLista;
    }
}