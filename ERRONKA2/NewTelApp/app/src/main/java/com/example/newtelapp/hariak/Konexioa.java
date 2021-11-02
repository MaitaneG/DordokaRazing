package com.example.newtelapp.hariak;

import android.content.Context;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
    private final String url = "jdbc:postgresql://25.32.59.79:5432/NewTel1"; // Postgres-eko url-a
    private final String username = "openpg"; // Datu baseko erabiltzailea
    private final String password = "openpgpwd"; // Datu baseko pasahitza
    private boolean status;

    private Connection conn;

    public Konexioa() {
        konektatu();
    }

    private void konektatu() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
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
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getConn() {
        return conn;
    }
}


