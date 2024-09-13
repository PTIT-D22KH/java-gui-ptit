package temp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import practice.codeptitGUIVersion.J05007.Employee;

/**
 * Test class for Employee and compareByTime classes.
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    
    @BeforeAll
    public static void setUpClass() {
        // Code to set up resources before any tests are run
    }
    
    @AfterAll
    public static void tearDownClass() {
        // Code to clean up resources after all tests are run
    }
    
    @BeforeEach
    public void setUp() {
        // Code to set up resources before each test
    }
    
    @AfterEach
    public void tearDown() {
        // Code to clean up resources after each test
    }

    @Test
    public void testEmployeeCreation() {
        Employee emp = new Employee("John Doe", "Male", "01/01/1990", "123 Main St", "123456789", "01/01/2020");
        assertEquals("John Doe", emp.getName());
        assertEquals("Male", emp.getGender());
        assertEquals("01/01/1990", emp.getDob());
        assertEquals("123 Main St", emp.getAddress());
        assertEquals("123456789", emp.getTaxId());
        assertEquals("01/01/2020", emp.getContractDate());
        assertNotNull(emp.getId());
        assertNotNull(emp.getDate());
    }

    @Test
    public void testEmployeeToString() {
        Employee emp = new Employee("Jane Doe", "Female", "02/02/1992", "456 Elm St", "987654321", "02/02/2022");
        String expected = emp.getId() + " Jane Doe Female 02/02/1992 456 Elm St 987654321 02/02/2022";
        assertEquals(expected, emp.toString());
    }

    @Test
    public void testCompareByTime() {
        Employee emp1 = new Employee("Alice", "Female", "03/03/1985", "789 Oak St", "111222333", "03/03/2015");
        Employee emp2 = new Employee("Bob", "Male", "04/04/1990", "101 Pine St", "444555666", "04/04/2020");
        Employee emp3 = new Employee("Charlie", "Male", "05/05/1980", "202 Maple St", "777888999", "05/05/2010");

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        Collections.sort(employees, new compareByTime());

        assertEquals("Bob", employees.get(0).getName());
        assertEquals("Alice", employees.get(1).getName());
        assertEquals("Charlie", employees.get(2).getName());
    }
}
}