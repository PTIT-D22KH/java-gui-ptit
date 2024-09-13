package practice.codeptitGUIVersion.J05007;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manual test class for Employee and compareByTime classes.
 */
public class Test {

    public static void main(String[] args) {
        testEmployeeCreation();
        testEmployeeToString();
        testCompareByTime();
    }

    public static void testEmployeeCreation() {
        Employee emp = new Employee("John Doe", "Male", "01/01/1990", "123 Main St", "123456789", "01/01/2020");
        assertEqual("John Doe", emp.getName(), "testEmployeeCreation - Name");
        assertEqual("Male", emp.getGender(), "testEmployeeCreation - Gender");
        assertEqual("01/01/1990", emp.getDob(), "testEmployeeCreation - DOB");
        assertEqual("123 Main St", emp.getAddress(), "testEmployeeCreation - Address");
        assertEqual("123456789", emp.getTaxId(), "testEmployeeCreation - Tax ID");
        assertEqual("01/01/2020", emp.getContractDate(), "testEmployeeCreation - Contract Date");
        assertNotNull(emp.getId(), "testEmployeeCreation - ID");
        assertNotNull(emp.getDate(), "testEmployeeCreation - Date");
    }

    public static void testEmployeeToString() {
        Employee emp = new Employee("Jane Doe", "Female", "02/02/1992", "456 Elm St", "987654321", "02/02/2022");
        String expected = emp.getId() + " Jane Doe Female 02/02/1992 456 Elm St 987654321 02/02/2022";
        assertEqual(expected, emp.toString(), "testEmployeeToString");
    }

    public static void testCompareByTime() {
        Employee emp1 = new Employee("Alice", "Female", "03/03/1985", "789 Oak St", "111222333", "03/03/2015");
        Employee emp2 = new Employee("Bob", "Male", "04/04/1990", "101 Pine St", "444555666", "04/04/2020");
        Employee emp3 = new Employee("Charlie", "Male", "05/05/1980", "202 Maple St", "777888999", "05/05/2010");

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        Collections.sort(employees, new compareByTime());

        assertEqual("Bob", employees.get(0).getName(), "testCompareByTime - First");
        assertEqual("Alice", employees.get(1).getName(), "testCompareByTime - Second");
        assertEqual("Charlie", employees.get(2).getName(), "testCompareByTime - Third");
    }

    private static void assertEqual(Object expected, Object actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println(testName + " passed.");
        } else {
            System.err.println(testName + " failed: expected [" + expected + "], but got [" + actual + "].");
        }
    }

    private static void assertNotNull(Object obj, String testName) {
        if (obj != null) {
            System.out.println(testName + " passed.");
        } else {
            System.err.println(testName + " failed: expected non-null value, but got null.");
        }
    }
}