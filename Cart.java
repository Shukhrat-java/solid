import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        // Проверяем лимит на количество товаров
        if (getProductCount(product.getName()) >= DiscountRules.MAX_ITEM_QUANTITY) {
            System.out.println("Нельзя добавить больше " + DiscountRules.MAX_ITEM_QUANTITY + 
                             " единиц одного товара");
            return;
        }
        items.add(product);
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    public void clear() {
        items.clear();
    }

    public double getTotal() {
        double total = items.stream().mapToDouble(Product::getPrice).sum();
        
        // Применяем скидку 
        if (total > DiscountRules.MIN_AMOUNT_FOR_DISCOUNT) {
            double discount = total * DiscountRules.DISCOUNT_PERCENTAGE;
            System.out.printf("Скидка %.2f руб. (10%% от суммы заказа)%n", discount);
            total -= discount;
        }
        return total;
    }

    private int getProductCount(String productName) {
        return (int) items.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .count();
    }
}
