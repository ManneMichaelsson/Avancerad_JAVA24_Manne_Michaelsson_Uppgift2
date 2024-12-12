//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Student {
    private String id;
    private String name;
    private double grade;

    public Student(String id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    String toFileFormat() {
        return this.id + "," + this.name + "," + this.grade + ",";
    }

    String toStringFormat() {
        return "ID: " + this.id + ", Namn: " + this.name + ", Betyg: " + this.grade;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
