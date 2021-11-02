package com.example.newtelapp.hariak;

import android.util.Log;

import com.example.newtelapp.model.Bezeroa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AurrekontuakGehitu extends Thread {
    private Connection conn;

    public AurrekontuakGehitu(String url, String username, String password) {
        try {

            Class.forName("org.postgresql.Driver"); //postgres
            //Class.forName("com.mysql.jdbc.Driver"); mysql
            Connection conn = null;
            conn = DriverManager.getConnection(url,username,password);

            this.conn=conn;

        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        }catch(SQLException ex){
            Log.d("Salbuespena Bezeroak kargatzean", String.valueOf(ex));
            ex.printStackTrace();
        };
    }

    /*@Override
    public void run() {
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
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }*/
}
