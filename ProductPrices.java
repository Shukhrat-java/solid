// Применяем принцип избегания магических чисел и выносим цены на товары в отдельный класс, что сооветствует также принципам DRY - числа не дублируются в коде
public class ProductPrices {
    public static final double MILK_PRICE = 85.50;
    public static final double BREAD_PRICE = 45.30;
    public static final double EGGS_PRICE = 120.90;
}
