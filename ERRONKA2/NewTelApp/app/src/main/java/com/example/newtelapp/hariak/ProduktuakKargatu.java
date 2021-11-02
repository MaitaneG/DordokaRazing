package com.example.newtelapp.hariak;

import android.os.AsyncTask;
import android.util.Log;

import com.example.newtelapp.model.Produktua;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduktuakKargatu extends Thread {

    public Connection conn;

    private ArrayList<Produktua> produktuakKatalogoa;

    public ProduktuakKargatu(ArrayList<Produktua> produktuakKatalogoa) {
        Konexioa konexioa = new Konexioa();
        conn=konexioa.getConn();
        System.out.println();

    }

    @Override
    public void run() {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                Produktua produktua;
                PreparedStatement pstmt = null;
                try {
                    pstmt = conn.prepareStatement("select product_product.id , product_template.name as deskripzioa, product_template.list_price , stock_quant.quantity as kantitatea, product_category.name as kategoria\n" +
                            " from product_product inner join product_template on product_product.id = product_template.id inner join stock_quant on product_product.id = stock_quant.product_id inner join product_category on product_template.categ_id =product_category.id\n" +
                            " where stock_quant.location_id=8\n" + "order by product_product.id asc;");

                    ResultSet rs = pstmt.executeQuery();

                    while(rs.next()){
                        produktua= new Produktua(/*ID*/rs.getInt(1), /*Product name*/rs.getString(2), /*Kategoria*/rs.getString(5), /*Prezioa*/ rs.getFloat(3), /*Kantitatea*/rs.getFloat(4));
                        System.out.println();
                        produktuakKatalogoa.add(produktua);
                    }

                    conn.close();

                }catch (SQLException throwables){
                    throwables.printStackTrace();
                }
            }
        });

    }
}
