import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;
    //определяем цены(магические числа) в праметр 
    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Молоко", ProductPrices.MILK_PRICE, "Простоквашино"));
        products.add(new Product("Хлеб", ProductPrices.BREAD_PRICE, "Пекарня"));
        products.add(new Product("Яйца", ProductPrices.EGGS_PRICE, "Стальные"));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}
