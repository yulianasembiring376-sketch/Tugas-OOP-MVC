/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa;

/**
 *
 * @author yulia
 */
public class KRS {

    private Course course;
    private double score;
    private String grade;
    private Lecturer lecture;
    private int semester;
    private Student student;  // ← sekarang Student dikenali

    // Tambahan atribut untuk nilai komponen
    private double nilaiSikap;
    private double nilaiUts;
    private double nilaiUas;

    public KRS() {
        // default constructor
    }

    public KRS(Course course, double score) {
        this.course = course;
        this.score = score;
        this.grade = setGrade();
    }

    // ===== SETTER & GETTER STUDENT =====
    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    // ===== SETTER & GETTER COURSE =====
    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    // ===== SETTER & GETTER SCORE =====
    public void setScore(double score) {
        this.score = score;
        this.grade = setGrade();
    }

    public double getScore() {
        return score;
    }

    // ===== SETTER & GETTER GRADE =====
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    // ===== SETTER & GETTER SEMESTER =====
    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    // ===== SETTER & GETTER LECTURE =====
    public void setLecture(Lecturer lecture) {
        this.lecture = lecture;
    }

    public Lecturer getLecture() {
        return lecture;
    }

    // ===== GETTER & SETTER NILAI KOMPONEN =====
    public double getNilaiSikap() {
        return nilaiSikap;
    }

    public void setNilaiSikap(double nilaiSikap) {
        this.nilaiSikap = nilaiSikap;
    }

    public double getNilaiUts() {
        return nilaiUts;
    }

    public void setNilaiUts(double nilaiUts) {
        this.nilaiUts = nilaiUts;
    }

    public double getNilaiUas() {
        return nilaiUas;
    }

    public void setNilaiUas(double nilaiUas) {
        this.nilaiUas = nilaiUas;
    }

    public double getNilaiAkhir() {
        return score;
    }

    public void setNilaiAkhir(double nilaiAkhir) {
        this.score = nilaiAkhir;
        this.grade = setGrade();
    }

    public String getNilaiHuruf() {
        return grade;
    }

    public void setNilaiHuruf(String nilaiHuruf) {
        this.grade = nilaiHuruf;
    }

    // ===== METHOD GRADE =====
    public String setGrade() {
        if (score >= 85)
            return "A";
        else if (score >= 75)
            return "B";
        else if (score >= 60)
            return "C";
        else
            return "D";
    }
}