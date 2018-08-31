package books.LearnJavaFX8.chapter2;

import java.beans.PropertyChangeEvent;

public class EmployeeTest {

    public static void main(String[] args) {
        final Employee employee1 = new Employee("Happi Yvan", 2000.0);

        // Compute the tax
        computeTax(employee1.getSalary());

        // Add a property change listener to employee1
        employee1.addPropertyChangeListener(EmployeeTest::handlePropertyChange);

        // Change the salary
        employee1.setSalary(3000.0);
        employee1.setSalary(3000.0);        // No change notification is sent
        employee1.setSalary(6000.0);
    }

    public static void handlePropertyChange(PropertyChangeEvent event) {
        String propertyName = event.getPropertyName();

        if ("salary".equals(propertyName)) {
            System.out.print("Salary has changed. ");
            System.out.print("Old: " + event.getOldValue());
            System.out.println(", New: " + event.getNewValue());
            computeTax((Double) event.getNewValue());
        }
    }

    public static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0;
        double tax = salary * TAX_PERCENT / 100.0;
        System.out.println("Salary: " + salary + ", Tax: " + tax);
    }
}
