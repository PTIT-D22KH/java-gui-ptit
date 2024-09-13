/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.codeptitGUIVersion.J04006;

import java.util.Comparator;

/**
 *
 * @author P51
 */
public class Student {
    private String id, name, className, dob;
    private double gpa;
    
    public Student() {
        name = className = dob = "";
        gpa = 0;
    }
    public Student(String name, String className, String dob, double gpa) {
        this.id = "B20DCCN001";
        this.name = name;
        this.className = className;
        this.dob = formatDob(dob);
        this.gpa = gpa;
    }
    private String formatDob(String dob) {
        String a[] = dob.trim().split("/");
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
//        String new_dob = "";
//        if (dob.charAt(2) != '/') {
//            new_dob = "0" + dob;
//        }
//        if (new_dob.charAt(5) != '/') {
//            new_dob = new_dob.substring(0, 3) + "0" + new_dob.substring(3); 
//        }
//        return new_dob;
    }

    public String getId() {
        return id;
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
        return id + " " + name + " " + className + " " + dob + " " +  String.format("%.2f", gpa);
    }
}
class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}