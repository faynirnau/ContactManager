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
import java.util.ArrayList;

public class Bdd extends AsyncTask<ArrayList<Contact>, Void, ArrayList<Contact>> {
Connection con = null;
Statement st = null;
ResultSet rs = null;
ResultSetMetaData rsmd = null;
    @Override
    protected ArrayList<Contact> doInBackground(ArrayList<Contact>... ArrayLists) {
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/contactmanager", "root", "root");
            String result = "Database Connection Successful\n";
            Log.d("BDD", "doInBackground: Connection Reussite");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM contact;");
            rsmd = rs.getMetaData();
            while (rs.next()) {
                Contact contact = new Contact(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("phonenumber")
                        );
                contactArrayList.add(contact);
            }
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
        return contactArrayList;
    }
}
