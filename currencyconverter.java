import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class currencyconverter {

    // Function to fetch exchange rate without JSON library
    public static double getExchangeRate(String base, String target) {
        double rate = 0.0;
        try {
            String urlStr = "https://api.exchangerate-api.com/v4/latest/" + base;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the response string to find the target currency rate manually
            String search = "\"" + target.toUpperCase() + "\":";
            int index = response.indexOf(search);
            if (index != -1) {
                int start = index + search.length();
                int end = response.indexOf(",", start);
                if (end == -1) { // might be last currency in the JSON
                    end = response.indexOf("}", start);
                }
                String rateStr = response.substring(start, end).trim();
                rate = Double.parseDouble(rateStr);
            }

        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }

        return rate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ CURRENCY CONVERTER ------");

        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double rate = getExchangeRate(baseCurrency, targetCurrency);

        if (rate == 0.0) {
            System.out.println("Conversion failed. Please check currency codes or internet.");
        } else {
            double convertedAmount = amount * rate;
            System.out.printf("%.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        }

        scanner.close();
    }
}
