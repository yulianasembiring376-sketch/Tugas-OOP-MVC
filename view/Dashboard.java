/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import view.InputNilai;
import view.StudentForm;
import view.FormLecturer;
import view.FormCourse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yulia
 */
public class Dashboard extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(Dashboard.class.getName());

    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuStudent = new javax.swing.JMenuItem();
        menuDosen = new javax.swing.JMenuItem();
        menuMatakuliah = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuInputNilai = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data Master");

        menuStudent.setText("Mahasiswa");
        menuStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStudentActionPerformed(evt);
            }
        });
        jMenu2.add(menuStudent);

        menuDosen.setText("Dosen");
        menuDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDosenActionPerformed(evt);
            }
        });
        jMenu2.add(menuDosen);

        menuMatakuliah.setText("Matakuliah");
        menuMatakuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMatakuliahActionPerformed(evt);
            }
        });
        jMenu2.add(menuMatakuliah);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Transaksi");

        menuInputNilai.setText("Input Nilai KRS");
        menuInputNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInputNilaiActionPerformed(evt);
            }
        });
        jMenu3.add(menuInputNilai);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void menuStudentActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            StudentForm formMhs = new StudentForm();
            formMhs.setVisible(true);
            formMhs.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void menuDosenActionPerformed(java.awt.event.ActionEvent evt) {
        FormLecturer formDosen = new FormLecturer();
        formDosen.setVisible(true);
        formDosen.setLocationRelativeTo(null);
    }

    private void menuMatakuliahActionPerformed(java.awt.event.ActionEvent evt) {
        FormCourse formCourse = new FormCourse();
        formCourse.setVisible(true);
        formCourse.setLocationRelativeTo(null);
    }

    private void menuInputNilaiActionPerformed(java.awt.event.ActionEvent evt) {
        InputNilai formNilai = new InputNilai();
        formNilai.setVisible(true);
        formNilai.setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuStudent;
    private javax.swing.JMenuItem menuDosen;
    private javax.swing.JMenuItem menuMatakuliah;
    private javax.swing.JMenuItem menuInputNilai;
    // End of variables declaration
}