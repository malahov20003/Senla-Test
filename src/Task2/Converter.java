package Task2;

public class Converter {
    private static final double USD_TO_RUB = 73.5;
    private static final double EUR_TO_RUB = 86.1;
    private static final double GBP_TO_RUB = 100.2;
    private static final double JPY_TO_RUB = 0.67;
    private static final double CNY_TO_RUB = 11.5;

    public void convert(double rubAmount) {
        System.out.println("Конвертация суммы " + rubAmount + " рублей:");
        System.out.printf("USD: %.2f%n", rubAmount / USD_TO_RUB);
        System.out.printf("EUR: %.2f%n", rubAmount / EUR_TO_RUB);
        System.out.printf("GBP: %.2f%n", rubAmount / GBP_TO_RUB);
        System.out.printf("JPY: %.2f%n", rubAmount / JPY_TO_RUB);
        System.out.printf("CNY: %.2f%n", rubAmount / CNY_TO_RUB);
    }
}
