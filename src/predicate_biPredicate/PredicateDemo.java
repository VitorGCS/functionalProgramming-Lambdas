package predicate_biPredicate;

import model.DefaultProduct;
import model.Product;
import model.User;
import model.UserForHashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

        System.out.println("========== Predicate demo ==========");

        List<Product> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "Product 3", "Category 3", 39.99)
        ));

        removeProductsIfPriceIsMoreThan(products, 100);
        displayProducts(products);


        System.out.println("========== Predicate.and() demo ==========");

        removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo( products,90, "Category 1");
        displayProducts(products);



        System.out.println("========== Predicate.isEqual() demo ==========");
        List<User> users = new ArrayList<>(Arrays.asList(
                new UserForHashTables(1, "John", "Smith","password", "john.smith@email.com"),
                new UserForHashTables(2, "Ivan", "Ivanov","password", "ivan.ivanov@email.com"),
                new UserForHashTables(3, "Harsha", "Anand","password", "john.smith@email.com")
        ));

        User criteriaUser = new UserForHashTables(1, "John", "Smith","password", "john.smith@email.com");

        users.removeIf(Predicate.not(Predicate.isEqual(criteriaUser)));
        System.out.println(users);
    }

    private static void displayProducts(List<Product> products){
        products.forEach(System.out::println);
    }

    public static void removeProductsIfPriceIsMoreThan(List<? extends Product> products, double price) {
        products.removeIf(product -> product.getPrice() > price);
    }

    public static void removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo(
            List<? extends Product> products,
            double price,
            String categoryName) {

        Predicate<Product> isPriceIsMoreThanPredicate = product -> product.getPrice() > price;
        Predicate<Product> isCategoryIsEqualTo = product -> product.getCategoryName().equals(categoryName);
        products.removeIf(isPriceIsMoreThanPredicate.and(isCategoryIsEqualTo));

        // negate() demo
		//products.removeIf(isPriceIsMoreThanPredicate.and(isCategoryIsEqualTo).negate());
    }

}