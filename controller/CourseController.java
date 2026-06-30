package controller;   // ← package controller (huruf kecil semua)

import dao.CourseDAO;
import datamahasiswa.Course;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CourseController {

    private final CourseDAO courseDao = new CourseDAO();

    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }

    public boolean insert(JFrame frame, String kode, String nama, String sksStr, String semesterStr) {
        try {
            int sks = Integer.parseInt(sksStr);
            int semester = Integer.parseInt(semesterStr);

            Course course = new Course(kode, nama, sks, semester);

            if (courseDao.simpan(course)) {
                JOptionPane.showMessageDialog(frame, "Mata kuliah berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(frame, "Gagal menyimpan ke database!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "SKS dan Semester harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean update(JFrame frame, String kode, String nama, String sksStr, String semesterStr) {
        return insert(frame, kode, nama, sksStr, semesterStr);
    }

    public boolean delete(JFrame frame, String kode) {
        if (courseDao.hapus(kode)) {
            JOptionPane.showMessageDialog(frame, "Mata kuliah berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(frame, "Gagal menghapus data dari database!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Course> searchCourses(String keyword) {
        return courseDao.getAll();
    }
}