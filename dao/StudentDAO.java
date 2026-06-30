/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import datamahasiswa.Student;
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
public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // CREATE (Insert)
    public int create(Student student) {
        // Pastikan koneksi tidak null
        if (connection == null) {
            System.err.println("Koneksi database null!");
            return 0;
        }

        try {
            String sql = "INSERT INTO mahasiswa (nik, nim, nama, prodi) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getStudyProgram());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();   // Cetak error ke console
            return 0;
        }
    }

    // SELECT (Read)
    public List<Student> getStudent() {
        List<Student> students = new ArrayList<>();

        try {
            String sql = "SELECT * FROM mahasiswa";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            String cardID = rs.getString("nik");
            String nim = rs.getString("nim");
            String nama = rs.getString("nama");
            String prodi = rs.getString("prodi");

            students.add(new Student(cardID, nama, nim, prodi));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
}

    // UPDATE
   public int update(Student student, String nim) {
    if (connection == null) {
        System.err.println("Koneksi database null!");
        return 0;
    }

    try {
        String sql = "UPDATE mahasiswa SET nik=?, nama=?, prodi=? WHERE nim=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, student.getCardID());        // nik
        stmt.setString(2, student.getName());          // nama
        stmt.setString(3, student.getStudyProgram());  // prodi
        stmt.setString(4, nim);                        // nim yang dicari

        stmt.executeUpdate();
        return 1;

    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
}

    // DELETE
    public int delete(String nim) {
    if (connection == null) {
        System.err.println("Koneksi database null!");
        return 0;
    }

    try {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, nim);

        stmt.executeUpdate();
        return 1;

    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
}
}