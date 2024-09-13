/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.codeptitGUIVersion.J05007;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author P51
 */
public class Employee {
    private String id, name, gender, dob, address, taxId, contractDate;
    private static int count = 0;
    private Date date;
    private SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
    public Employee(String name, String gender, String dob, String address, String taxId, String contractDate) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.taxId = taxId;
        this.contractDate = contractDate;
        count++;
        this.id = String.format("%05d", count);
        try{
            this.date = sd.parse(this.dob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
               
    
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getContractDate() {
        return contractDate;
    }

    public Date getDate() {
        return date;
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + gender + " " + dob + " " + address + " " + taxId + " " + contractDate;
    }
    
}
class CompareByTime implements Comparator<Employee> {
    @Override
    public int compare(Employee a, Employee b) {
        return Long.compare(a.getDate().getTime(), b.getDate().getTime());
    }
}