package practice.form2;

import java.util.Comparator;

/**
 * Student class represents a student with id, name, className, dob, and gpa.
 * 
 */
public class Student {
    private String id, name, className, dob;
    private double gpa;

    public Student() {
        name = className = dob = "";
        gpa = 0;
    }

    public Student(String id, String name, String className, String dob, double gpa) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.dob = formatDob(dob);
        this.gpa = gpa;
    }

    private String formatDob(String dob) {
        String[] a = dob.trim().split("/");
        StringBuilder res = new StringBuilder();
        if (a[0].length() == 1) {
            res.append("0");
        }
        res.append(a[0]).append("/");
        if (a[1].length() == 1) {
            res.append("0");
        }
        res.append(a[1]).append("/").append(a[2]);
        return res.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public String getDob() {
        return dob;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + dob + " " + String.format("%.2f", gpa);
    }
}

class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}