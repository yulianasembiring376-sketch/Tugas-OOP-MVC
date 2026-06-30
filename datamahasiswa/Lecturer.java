/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa;

/**
 *
 * @author yulia
 */
public class Lecturer extends Person { // ← tambahin public

    private String nidn;
    private String expertise;

    public Lecturer(String idCard,
                    String name,
                    String nidn,
                    String expertise) {

        super(idCard, name);

        this.nidn = nidn;
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return this.name;
    }

    // === GETTER ===
    public String getIdCard() {
        return idCard;
    }

    public String getName() {
        return name;
    }

    public String getNidn() {
        return nidn;
    }

    public String getExpertise() {
        return expertise;
    }
}