/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import datamahasiswa.Lecturer;
import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hype
 */
public class LecturerDAO {
    private Connection connection;

    public LecturerDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // CREATE (Insert)
    public int create(Lecturer lecturer) {
        if (connection == null) {
            System.err.println("Koneksi database null!");
            return 0;
        }

        try {
            String sql = "INSERT INTO dosen (id_card, nama, nidn, expertise) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getIdCard());   // asumsi ada method getIdCard() di Lecturer
            stmt.setString(2, lecturer.getName());
            stmt.setString(3, lecturer.getNidn());
            stmt.setString(4, lecturer.getExpertise());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // SELECT (Read)
   public List<Lecturer> getLecturer() {
    List<Lecturer> lecturers = new ArrayList<>();

    try {
        String sql = "SELECT * FROM dosen";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String idCard = rs.getString("id_card");
            String name = rs.getString("nama");
            String nidn = rs.getString("nidn");
            String expertise = rs.getString("expertise");

            System.out.println(idCard + " | " + name + " | " + nidn + " | " + expertise);

            lecturers.add(new Lecturer(idCard, name, nidn, expertise));
        }

        System.out.println("Jumlah data = " + lecturers.size());

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lecturers;
}

    // UPDATE
    public int update(Lecturer lecturer, String nidn) {
        if (connection == null) {
            System.err.println("Koneksi database null!");
            return 0;
        }

        try {
            String sql = "UPDATE dosen SET id_card=?, nama=?, expertise=? WHERE nidn=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getIdCard());
            stmt.setString(2, lecturer.getName());
            stmt.setString(3, lecturer.getExpertise());
            stmt.setString(4, nidn);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // DELETE
    public int delete(String nidn) {
        if (connection == null) {
            System.err.println("Koneksi database null!");
            return 0;
        }

        try {
            String sql = "DELETE FROM dosen WHERE nidn=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nidn);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}