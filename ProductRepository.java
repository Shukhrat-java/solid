import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("Молоко", 85.50, "Простоквашино"));
        products.add(new Product("Хлеб", 45.30, "Пекарня"));
        products.add(new Product("Яйца", 120.90, "Стальные"));
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
