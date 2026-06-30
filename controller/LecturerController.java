/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LecturerDAO;
import datamahasiswa.Lecturer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author Hype
 */
public class LecturerController {

    private final LecturerDAO lecturerDao;

    public LecturerController() {
        this.lecturerDao = new LecturerDAO();
    }

    // Mengambil semua data dosen
    public List<Lecturer> getAllLecturers() {
        return lecturerDao.getLecturer(); // ← perbaiki: getLecturer()
    }

    // PENAMBAHAN FITUR PAGINATION (sementara dikomentari/dihapus karena belum ada di DAO)
    public List<Lecturer> getLecturersByPage(int page, int limit) {
        // Sementara panggil semua data, karena method getLecturersByPage belum ada di DAO
        return lecturerDao.getLecturer();
    }

    // Method untuk menyimpan data dosen
    public boolean insert(JFrame view, String idCard, String nama, String nidn, String expertise) {
        if (idCard.isEmpty() || nama.isEmpty() || nidn.isEmpty() || expertise.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        Lecturer l = new Lecturer(idCard, nama, nidn, expertise);
        int sukses = lecturerDao.create(l); // ← perbaiki: create() mengembalikan int

        if (sukses > 0) {
            JOptionPane.showMessageDialog(view, "Data Dosen Berhasil Disimpan ke Database!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Menyimpan Data Dosen!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method untuk menghapus data dosen
    public boolean delete(JFrame view, String nidn) { // ← parameter diganti jadi nidn (karena di DAO pakai nidn)
        int sukses = lecturerDao.delete(nidn); // ← perbaiki: delete() mengembalikan int

        if (sukses > 0) {
            JOptionPane.showMessageDialog(view, "Data Dosen Berhasil Dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Menghapus Data Dosen!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method untuk logika mengubah data dosen
    public boolean update(JFrame view, String idCard, String nama, String nidn, String expertise) {
        if (idCard.isEmpty() || nama.isEmpty() || nidn.isEmpty() || expertise.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        Lecturer l = new Lecturer(idCard, nama, nidn, expertise);
        int sukses = lecturerDao.update(l, nidn); // ← perbaiki: update() butuh Lecturer dan nidn

        if (sukses > 0) {
            JOptionPane.showMessageDialog(view, "Data Dosen Berhasil Diubah!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Mengubah Data Dosen!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Method untuk logika pencarian data dosen (sementara masih return semua)
    public List<Lecturer> searchLecturers(String keyword) {
        // Karena di DAO belum ada method cari(), sementara return semua
        return lecturerDao.getLecturer();
    }
}