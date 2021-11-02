package com.example.newtelapp.hariak;

import android.util.Log;

import com.example.newtelapp.model.Aurrekontua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AurrekontuakKargatu extends Thread{
    private Connection conn;
    private ArrayList<Aurrekontua> aurrekuntuakLista;

    public AurrekontuakKargatu(String url, String username, String password, ArrayList<Aurrekontua>aurrekuntuakLista){
        try {

            Class.forName("org.postgresql.Driver"); //postgres
            //Class.forName("com.mysql.jdbc.Driver"); mysql
            Connection conn = null;
            conn = DriverManager.getConnection(url,username,password);

            this.conn=conn;
            this.aurrekuntuakLista=aurrekuntuakLista;

        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }catch(SQLException ex){
            Log.d("Salbuespena Aurrekontuak kargatzean", String.valueOf(ex));
            ex.printStackTrace();
        };
    }

    @Override
    public void run() {
        aurrekuntuakLista=new ArrayList<>();
        Aurrekontua aurrekontua;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("select sale_order.id as id, sale_order.name, res_partner.name as bezeroaIzena," +
                    "sale_order_line.name as produktuaIzena,sale_order_line.product_uom_qty as kantitatea, sale_order.date_order as data" +
                    "from  sale_order " +
                    "inner join  res_partner on sale_order.id = res_partner.id " +
                    "inner join  sale_order_line on sale_order.id = sale_order_line.order_id\n" +
                    "where sale_order.state = 'draft'order by sale_order.id asc\n");

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                aurrekontua= new Aurrekontua(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6));
                System.out.println();
                aurrekuntuakLista.add(aurrekontua);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
