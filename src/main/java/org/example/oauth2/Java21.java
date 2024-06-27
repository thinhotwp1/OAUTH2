package org.example.oauth2;

import java.util.List;
import java.util.stream.Collectors;

public class Java21 {

    public static void main(String[] args) {

        Object textBlock = """
                               Hello world
                           """;
        if(textBlock instanceof String){
            System.out.println(((String) textBlock).repeat(2));
        }
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum: " + sum);

        // Sử dụng Stream API với cải tiến
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        int sum1 = numbers1.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum1);
    }

}
