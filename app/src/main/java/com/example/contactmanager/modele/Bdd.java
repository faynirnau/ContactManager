package com.example.contactmanager.modele;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd extends AsyncTask<String, Void, String> {
    String res;
    @Override
    protected String doInBackground(String... strings) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/contactmanager", "root", "root");
            String result = "Database Connection Successful\n";
            Log.d("BDD", "doInBackground: Connection Reussite");
            st = con.createStatement();
            rs = st.executeQuery("SELECT lastname, firstname, email, phonenumber FROM contact;");
            rsmd = rs.getMetaData();

            while (rs.next()) {
                result += rs.getString(1).toString() + " " + rs.getString(2).toString() + " " + rs.getString(3).toString() + "\n";
            }
            res = result;
            Log.d("BDD", "doInBackground: " + res);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                } // ignore

                rs = null;
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ignored) {
                } // ignore

                st = null;
            }
        }
        return res;
    }
}
