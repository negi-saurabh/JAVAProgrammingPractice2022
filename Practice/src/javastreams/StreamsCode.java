package javastreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    // Write a stream pipeline that returns the top 3 most frequently occurring
    // words across all sentences,
    // case-insensitive, excluding words shorter than 3 characters. Return them as a
    // List<String>
    // ordered by frequency descending.

    List<String> sentences;

    List<String> list = sentences.stream()
            .flatMap(s -> Arrays.stream(s.toLowerCase().split("\\W+")))
            .filter(w -> w.length() >= 3)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .map(Map.Entry::getKey)
            .toList();

}
