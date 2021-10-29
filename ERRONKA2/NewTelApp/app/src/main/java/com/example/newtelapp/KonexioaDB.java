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

    private ArrayList<Produktua> produktuakKatalogoa;
    private ArrayList<Bezeroa> bezeroLista;
    private Menua menua;

    public KonexioaDB(Menua context){
        this.menua = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(menua.getApplicationContext(), "Kargatzen...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected ArrayList<Produktua> doInBackground(String... strings) {
        String url = strings[0];
        String username = strings[1];
        String pass = strings[2];
        produktuakKatalogoa = new ArrayList<>();

        try {

            Class.forName("org.postgresql.Driver"); //postgres
            //Class.forName("com.mysql.jdbc.Driver"); mysql
            Connection conn = null;
            conn = DriverManager.getConnection(url,username,pass);
            //Log.d("db", "conexion db");
            ArrayList<Bezeroa>algo=bezeroakLortu(conn);
            return produktuakLortu(conn);

        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }catch(SQLException ex){
            Log.d("excepzioa", String.valueOf(ex));
            ex.printStackTrace();
        };
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList arrayList) {
        super.onPostExecute(arrayList);
        menua.setDatuak(arrayList);
        Toast.makeText(menua.getApplicationContext(), "Datu guztiak kargatuta!!!", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<Produktua> produktuakLortu(Connection conn) {
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return produktuakKatalogoa;
    }

    private ArrayList<Bezeroa>bezeroakLortu(Connection conn) {
        Bezeroa bezeroa;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("select res_partner.id , res_partner.name  as izenaAbizena, res_partner.company_name as enpresa, res_partner.phone_sanitized as mugikorra,\n" +
                    "res_partner.email as korreoa,res_partner.street as kalea,res_partner.city as hiria,res_partner.zip as kodigoPostala ,res_country_state.name as probintzia,\n" +
                    "res_country.name as herrialdea from  res_partner\n" +
                    "inner join  res_country_state on res_partner.state_id = res_country_state.id\n" +
                    "inner join res_country on res_partner.country_id = res_country.id\n" +
                    "order by res_partner.id asc\n");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                bezeroa= new Bezeroa(rs.getString(1),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
                System.out.println();
                bezeroLista.add(bezeroa);
            }
            return bezeroLista;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }
}
