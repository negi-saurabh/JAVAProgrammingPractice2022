package javastreams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsCode {

    class Transaction {
        String customerId;
        double amount;
        String currency;
        // getters
    }

    List<Transaction> transactions;

    // Write a single stream pipeline that returns a Map<String, Double>
    // containing the total amount spent per customer, but only for customers whose
    // total exceeds 1000.0.
    // The map should be sorted by total amount descending.
    Map<String, Double> result = transactions.stream()
            .collect(Collectors.groupingBy(
                    Transaction::getCustomerId,
                    Collectors.summingDouble(Transaction::getAmount)))
            .entrySet().stream()
            .filter(e -> e.getValue > 1000.0)
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (a, b) -> a,
                    LinkedHashMap::new));

}
