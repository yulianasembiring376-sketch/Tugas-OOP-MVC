package datamahasiswa;

public class Course {
    private String code;
    private String courseName;
    private int sks;
    private int semester;

    public Course() {} // ← default constructor

    public Course(String code, String courseName, int sks, int semester) {
        this.code = code;
        this.courseName = courseName;
        this.sks = sks;
        this.semester = semester;
    }

    // === SETTER (dibutuhkan CourseDAO) ===
    public void setKode(String code) {
        this.code = code;
    }

    public void setNamaMK(String courseName) {
        this.courseName = courseName;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public void setSemesterAngka(String semester) {
        this.semester = Integer.parseInt(semester);
    }

    // === GETTER ===
    public String getKode() {
        return code;
    }

    public String getNamaMK() {
        return courseName;
    }

    public int getSks() {
        return sks;
    }

    public String getSemesterAngka() {
        return String.valueOf(semester);
    }

    public int getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return courseName;
    }
}