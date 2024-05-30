package lorenzofoschetti.esercizi;

import lorenzofoschetti.entities.Customer;
import lorenzofoschetti.entities.Order;
import lorenzofoschetti.entities.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        Customer customer1 = new Customer(635262L, "Giulia", 2);
        Customer customer2 = new Customer(66636L, "Giuseppe", 1);
        Customer customer3 = new Customer(55142L, "Valerio", 5);

        Product product1 = new Product("Harry Potter", 1333, "Book", 103);
        Product product2 = new Product("Il signore degli anelli", 5466, "Film", 31);
        Product product3 = new Product("Hannybal", 7665, "Book", 40);
        Product product4 = new Product("Harry Potter", 13362, "Book", 103);
        Product product5 = new Product("Topolino", 52716, "Baby", 31);
        Product product6 = new Product("Hannybal", 7663325, "Book", 40);
        Product product7 = new Product("Harry Potter", 13332, "Book", 103);
        Product product8 = new Product("Il signore degli anelli", 5625, "Film", 31);
        Product product9 = new Product("Paperino", 88726, "Baby", 40);

        Product[] arrayProducts1 = {product1, product2, product3};
        Product[] arrayProducts2 = {product4, product5, product6};
        Product[] arrayProducts3 = {product7, product8, product9};

        List<Product> listOfProducts1 = Arrays.stream(arrayProducts1).toList();
        List<Product> listOfProducts2 = Arrays.stream(arrayProducts2).toList();
        List<Product> listOfProducts3 = Arrays.stream(arrayProducts3).toList();

        Order order1 = new Order(55625L, "in consegna", LocalDate.now(), LocalDate.now().plusDays(10), listOfProducts1, customer1);
        Order order2 = new Order(55625L, "in consegna", LocalDate.now(), LocalDate.now().plusDays(10), listOfProducts2, customer2);


        Order[] orderArray = {order1, order2};
        List<Order> orders = Arrays.stream(orderArray).toList();


        Map<Customer, List<Order>> customerListMap = orders.stream().collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println(customerListMap);
    }


}

