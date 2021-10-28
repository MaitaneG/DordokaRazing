package com.example.newtelapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KonexioaDB extends AsyncTask <String, Void, ArrayList> {

    ArrayList<String> res;
    Menua menua;
    public KonexioaDB(Menua context){
        this.menua = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(menua.getApplicationContext(), "Kargatzen...", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected ArrayList<String> doInBackground(String... strings) {
        String url = strings[0];
        String username = strings[1];
        String pass = strings[2];
        res = new ArrayList<String>();
        boolean isConnected= false;
        try {
            Class.forName("org.postgresql.Driver"); //postgres
            //Class.forName("com.mysql.jdbc.Driver"); mysql
            Connection conn = DriverManager.getConnection(url,username,pass);
            //Log.d("db", "conexion db");
            PreparedStatement pstmt = conn.prepareStatement("select product_product.id , product_template.name as deskripzioa, product_template.list_price , stock_quant.quantity as kantitatea, product_category.name as kategoria\n" +
                   " from product_product inner join product_template on product_product.id = product_template.id inner join stock_quant on product_product.id = stock_quant.product_id inner join product_category on product_template.categ_id =product_category.id\n" +
                    " where stock_quant.location_id=8\n" + "order by product_product.id asc;");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
               res.add(rs.getString(1).toString() );
               isConnected = true;
            }
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        };
        return res;
    }

    @Override
    protected void onPostExecute(ArrayList arrayList) {
        //super.onPostExecute(arrayList);
        menua.setDatuak(arrayList);
        Toast.makeText(menua.getApplicationContext(), "Datu guztiak kargatuta!!!", Toast.LENGTH_SHORT).show();
    }
}
