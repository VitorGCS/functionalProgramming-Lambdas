package consumers_biConsumer;

import model.DefaultProduct;
import model.Product;
import java.util.*;

public class ConsumerDemo {

    public static void main(String[] args) {
        System.out.println("========== Consumer demo ==========");

        List<Product> products = new ArrayList<>(Arrays.asList(
                new DefaultProduct(1, "model.Product 1", "Category 1", 99.99),
                new DefaultProduct(2, "model.Product 2", "Category 2", 149.99),
                new DefaultProduct(3, "model.Product 3", "Category 3", 39.99)
        ));

        increasePriceForProductList(products, 10);
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\n========== BiConsumer demo ==========");
        Map<Integer, Product> idProductMap = new HashMap<>();
        idProductMap.put(1, new DefaultProduct(1, "model.Product 1", "Category 1", 99.99));
        idProductMap.put(2, new DefaultProduct(2, "model.Product 2", "Category 2", 149.99));
        idProductMap.put(3, new DefaultProduct(3, "model.Product 3", "Category 3", 39.99));

        increasePriceForProductMap(idProductMap, 10);

        for (Product product : idProductMap.values()) {
            System.out.println(product);
        }

    }

    public static void increasePriceForProductList(List<? extends Product> products, double priceToIncrease) {
        products.iterator()
                .forEachRemaining( product -> product.setPrice(product.getPrice() + priceToIncrease));
    }

    public static void increasePriceForProductMap(Map<Integer, ? extends Product> idProductMap, double priceToIncrease) {
        idProductMap.forEach( (id, product) -> product.setPrice(product.getPrice() + priceToIncrease));
    }

}