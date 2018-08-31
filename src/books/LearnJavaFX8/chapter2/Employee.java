package books.LearnJavaFX8.chapter2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Employee {

    private String name;
    private double salary;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Employee() {
        this.setName("John Doe");
        this.setSalary(1000.0);
    }

    public Employee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        double oldSalary = this.getSalary();
        this.salary = salary;

        // Notify the registered listeners about the change
        this.pcs.firePropertyChange("salary", oldSalary, this.getSalary());
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "name = " + this.getName() + ", salary = " + this.getSalary();
    }

    public static void main(String[] args) {
        IntegerProperty counter = new SimpleIntegerProperty(1);
        int counterValue = counter.get();
        System.out.println("Counter: " + counterValue);

        counter.set(2);
        counterValue = counter.get();
        System.out.println("Counter: " + counterValue);
    }

}
