package com.example.newtelapp.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    private final String url = "jdbc:postgresql://25.32.59.79:5432/NewTel1"; // Postgres-eko url-a
    private final String username = "openpg"; // Datu baseko erabiltzailea
    private final String password = "openpgpwd"; // Datu baseko pasahitza
    private boolean status;

    private Connection conn;

    public Conn(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            status = true;
            System.out.println("connected:" + status);
        } catch (Exception e) {
            status = false;
            System.out.print(e.getMessage());
            e.printStackTrace();
        }

    }
    public Connection getConn(){
        return conn;
    }
}
