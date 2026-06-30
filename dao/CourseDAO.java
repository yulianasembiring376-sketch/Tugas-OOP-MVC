package dao;

import config.DBConnection;
import datamahasiswa.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private final Connection conn;

    public CourseDAO() {
        try {
            this.conn = DBConnection.getConnection(); // ← perbaiki
        } catch (SQLException e) {
            throw new RuntimeException("Gagal koneksi database!", e);
        }
    }

    public List<Course> getAll() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT kode_mk, nama_mk, sks, semester FROM matakuliah";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Course c = new Course();
                c.setKode(rs.getString("kode_mk"));
                c.setNamaMK(rs.getString("nama_mk"));
                c.setSks(rs.getInt("sks"));
                c.setSemesterAngka(rs.getString("semester"));

                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error getAll: " + e.getMessage());
        }
        return list;
    }

    public boolean simpan(Course course) {
        if (conn == null) {
            System.err.println("Error: Koneksi database bernilai NULL!");
            return false;
        }

        String sql = "INSERT INTO matakuliah (kode_mk, nama_mk, sks, semester) VALUES (?, ?, ?, ?) "
                   + "ON DUPLICATE KEY UPDATE nama_mk = ?, sks = ?, semester = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getKode());
            ps.setString(2, course.getNamaMK());
            ps.setInt(3, course.getSks());
            ps.setString(4, course.getSemesterAngka());
            ps.setString(5, course.getNamaMK());
            ps.setInt(6, course.getSks());
            ps.setString(7, course.getSemesterAngka());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
    e.printStackTrace();
    System.err.println("Error SQL Simpan: " + e.getMessage());
    return false;
}
    }

    public boolean hapus(String kodeMk) {
        String sql = "DELETE FROM matakuliah WHERE kode_mk = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeMk);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error SQL Hapus: " + e.getMessage());
            return false;
        }
    }
}