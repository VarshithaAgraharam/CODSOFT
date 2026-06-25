import java.util.ArrayList;
import java.util.Scanner;

class CurrencyConverterLogic {

    private final String[] currencies = {
            "INR", "USD", "EUR"
    };

    // Rates relative to INR
    private final double[] rates = {
            1.0,
            1.0 / 94.94,
            1.0 / 109.37
    };

    public double convert(int from, int to, double amount) {
        double amountInINR = amount / rates[from];
        return amountInINR * rates[to];
    }

    public String getCurrency(int index) {
        return currencies[index];
    }

    public void displayCurrencies() {
        System.out.println("\nAvailable Currencies:");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println((i + 1) + ". " + currencies[i]);
        }
    }
}

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CurrencyConverterLogic converter = new CurrencyConverterLogic();
        ArrayList<String> history = new ArrayList<>();

        int choice;

        System.out.println("===================================");
        System.out.println("      CURRENCY CONVERTER");
        System.out.println("===================================");

        do {

            System.out.println("\n1. Convert Currency");
            System.out.println("2. View Conversion History");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    converter.displayCurrencies();

                    System.out.print("\nSelect Base Currency: ");
                    int from = sc.nextInt() - 1;

                    System.out.print("Select Target Currency: ");
                    int to = sc.nextInt() - 1;

                    if (from < 0 || from >= 3 || to < 0 || to >= 3) {
                        System.out.println("Invalid Currency Selection!");
                        break;
                    }

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    if (amount <= 0) {
                        System.out.println("Amount must be greater than zero!");
                        break;
                    }

                    double result = converter.convert(from, to, amount);

                    String record = String.format(
                            "%.2f %s = %.2f %s",
                            amount,
                            converter.getCurrency(from),
                            result,
                            converter.getCurrency(to));

                    System.out.println("\n===== Conversion Result =====");
                    System.out.println(record);

                    history.add(record);

                    break;

                case 2:

                    System.out.println("\n===== Conversion History =====");

                    if (history.isEmpty()) {
                        System.out.println("No conversions performed yet.");
                    } else {
                        for (String item : history) {
                            System.out.println(item);
                        }
                    }

                    break;

                case 3:
                    System.out.println("\nThank you for using Currency Converter!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
