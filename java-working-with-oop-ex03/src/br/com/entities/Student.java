package br.com.entities;

public class Student {

    private String name;
    private double trimesterGrade1;
    private double trimesterGrade2;
    private double trimesterGrade3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTrimesterGrade1() {
        return trimesterGrade1;
    }

    public void setTrimesterGrade1(double trimesterGrade1) {
        this.trimesterGrade1 = trimesterGrade1;
    }

    public double getTrimesterGrade2() {
        return trimesterGrade2;
    }

    public void setTrimesterGrade2(double trimesterGrade2) {
        this.trimesterGrade2 = trimesterGrade2;
    }

    public double getTrimesterGrade3() {
        return trimesterGrade3;
    }

    public void setTrimesterGrade3(double trimesterGrade3) {
        this.trimesterGrade3 = trimesterGrade3;
    }

    private double gradeSum() {
        return this.trimesterGrade1 + this.trimesterGrade2 + this.trimesterGrade3;
    }

    private String passFailed() {
        return (gradeSum() >= 60) ? "PASS" : "FAILED";
    }

    private double missingPoints() {
        if (gradeSum() < 60) {
            return 60 - gradeSum();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {

        String data = "";

        return data + "\n\nStudent: " + this.name
                + "\nGrade 1: " + this.trimesterGrade1
                + "\nGrade 2: " + this.trimesterGrade2
                + "\nGrade 3: " + this.trimesterGrade3
                + "\n\nFinal Grade: " + String.format("%.2f", gradeSum())
                + "\nMissing: " + String.format("%.1f", missingPoints()) + " points"
                + "\n" + passFailed();

    }

}
