import java.util.List;
import java.util.Scanner;

public class ShopApp {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню магазина:");
            System.out.println("1. Показать все товары");
            System.out.println("2. Добавить товар в корзину");
            System.out.println("3. Показать корзину");
            System.out.println("4. Выход");
            System.out.print("Выберите пункт меню: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                break;
            }

            switch (choice) {
                case 1:
                    showAllProducts(repository);
                    break;
                case 2:
                    addProductToCart(repository, cart, scanner);
                    break;
                case 3:
                    showCart(cart);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }

        scanner.close();
    }

    private static void showAllProducts(ProductRepository repository) {
        System.out.println("\nСписок товаров:");
        List<Product> products = repository.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void addProductToCart(ProductRepository repository, Cart cart, Scanner scanner) {
        System.out.print("Введите название товара: ");
        String productName = scanner.nextLine();
        Product product = repository.findProductByName(productName);

        if (product != null) {
            cart.addProduct(product);
            System.out.println("Товар добавлен в корзину!");
        } else {
            System.out.println("Товар не найден!");
        }
    }

    private static void showCart(Cart cart) {
        System.out.println("\nВаша корзина:");
        List<Product> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            for (Product item : items) {
                System.out.println(item);
            }
            System.out.printf("Итого: %.2f руб.%n", cart.getTotal());
            System.out.println("(При заказе от " + DiscountRules.MIN_AMOUNT_FOR_DISCOUNT + 
                             " руб. - скидка 10%)");
        }
    }
}
