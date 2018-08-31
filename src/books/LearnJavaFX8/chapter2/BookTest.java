package books.LearnJavaFX8.chapter2;

import javafx.beans.property.ReadOnlyProperty;

public class BookTest {

    public static void main(String[] args) {
        Book book = new Book("Harnessing JavaFX", 9.99, "012345678900");

        System.out.println("After creating the Book object....");

        // Print property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNproperty());

        // Change the book's properties
        book.setTitle("Harnessing JavaFX 8.0");
        book.setPrice(9.49);

        System.out.println("\nAfter changing the Book properties ...");

        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNproperty());
    }

    public static void printDetails(ReadOnlyProperty<?> property) {
        String name  =  property.getName();
        Object value =  property.getValue();
        Object bean  =  property.getBean();
        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
        String propClassName = property.getClass().getSimpleName();

        System.out.print(propClassName);
        System.out.print("[Name: " + name);
        System.out.print(", Bean class: " + beanClassName);
        System.out.println(", Value: " + value + "]");
    }
}
